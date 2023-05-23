package com.example.demo.listner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.producer.MessageStore;

@Component("listner")
public class MessageListner {
	
	@Autowired 
	private MessageStore store;
	
	@KafkaListener(topics="${app.topic.name}", groupId="grp1")
	public void readMessage(String message) {
		store.addMessage(message);
	}
	

}
