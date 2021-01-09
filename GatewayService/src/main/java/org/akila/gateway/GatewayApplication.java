package org.akila.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("path_route", r -> r.path("/cartons")
				.uri("http://localhost:8082"))
			.route("path_route", r -> r.path("/products")
				.uri("http://localhost:8082"))
			.route("path_route", r -> r.path("/calculate")
					.uri("http://localhost:8081"))
			.route("path_route", r -> r.path("/priceList")
					.uri("http://localhost:8081"))	
			.build();
	}

}
