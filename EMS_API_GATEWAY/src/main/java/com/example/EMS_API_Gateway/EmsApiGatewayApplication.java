package com.example.EMS_API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class EmsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApiGatewayApplication.class, args);
	}

	@Bean
	public CorsWebFilter corsWebFilter() {
	    CorsConfiguration corsConfig = new CorsConfiguration();

	    corsConfig.setAllowedOrigins(Arrays.asList(
	            "http://localhost:3000",
	            "https://main.d15ztt0s52f8f4.amplifyapp.com"
	    ));

	    corsConfig.setAllowedMethods(Arrays.asList(
	            "GET", "POST", "PUT", "DELETE", "OPTIONS"
	    ));

	    corsConfig.setAllowedHeaders(Arrays.asList(
	            "Content-Type",
	            "Authorization",
	            "X-Requested-With",
	            "Accept",
	            "Origin"
	    ));

	    corsConfig.setExposedHeaders(Arrays.asList(
	            "Authorization",
	            "Content-Type"
	    ));

	    corsConfig.setAllowCredentials(true);
	    corsConfig.setMaxAge(3600L);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);

	    return new CorsWebFilter(source);
	}

}