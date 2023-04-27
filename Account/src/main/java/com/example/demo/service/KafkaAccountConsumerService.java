package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.constant.AppConstant;

@Service
public class KafkaAccountConsumerService {
	
	private List<String> list = new ArrayList<>();
	
	@KafkaListener(topics = {AppConstant.TOPIC_NAME}, groupId = "grp1" )
	public void readMessage(String message) {
		System.out.println("************ "+message+" *************");
		list.add(message);
	}

  
	public List<String> getMessages() {
		return list;
	}
}
