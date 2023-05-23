package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerService cService;
	
	
	@GetMapping("/getMessage/{msg}")
	public ResponseEntity<String> getMessage(@PathVariable String msg){
		String str=cService.produceMessage(msg);
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	
	
	

}
