package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableCircuitBreaker
public class CircuitBreakerHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerHystrixApplication.class, args);
	}

}
