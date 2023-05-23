package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sevice.ProducerService;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	
	@Autowired
	private ProducerService service;
	
	@GetMapping("/sendMessage/{msg}")
	public ResponseEntity<String> produceMessage(@PathVariable String msg){
		String str=service.produceMessage(msg);
		return new ResponseEntity<String>(str,HttpStatus.OK);
		
	}
	

}
