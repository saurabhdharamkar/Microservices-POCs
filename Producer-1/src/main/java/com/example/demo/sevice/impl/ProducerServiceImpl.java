package com.example.demo.sevice.impl;

import org.springframework.stereotype.Service;

import com.example.demo.sevice.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Override
	public String produceMessage(String msg) {
		
		return "Hello "+msg;
	}

}
