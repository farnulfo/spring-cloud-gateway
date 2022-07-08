package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p
				.path("/get")
				.filters(f -> f.addRequestHeader("Hello", "World"))
				.uri("http://httpbin.org:80"))
			.route(p -> p
				.path("/uuid")
				.filters(f -> f.addRequestHeader("Hello", "World"))
				.uri("http://httpbin.org:80"))
			.route(p -> p
				.path("/documentation")
				.filters(f -> f.addRequestHeader("Hello", "World"))
				.uri("https://www.keycloak.org:443"))
			.build();
	}
}
