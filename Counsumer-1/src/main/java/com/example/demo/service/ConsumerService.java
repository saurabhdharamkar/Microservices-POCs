package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCER-SERVICE")
public interface ConsumerService {
	
	@GetMapping("/producer/sendMessage/{msg}")
	public String produceMessage(@PathVariable String  msg);

}
