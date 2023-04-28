package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Value("${my.app.topic}")
	private String topic;
	
	
	public String sendMessage(String msg) {
		System.out.println(template.send(topic,msg));
		return "msg successfully stored into topic "+topic;
	}

}
