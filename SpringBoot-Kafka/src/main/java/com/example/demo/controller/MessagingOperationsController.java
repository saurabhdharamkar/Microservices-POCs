package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producer.MessageProducer;
import com.example.demo.producer.MessageStore;

@RestController
public class MessagingOperationsController {
	
	@Autowired
  private MessageProducer producer;
	
	@Autowired
	private MessageStore store;
  
  @GetMapping("/send")
  public ResponseEntity<String> sendMessage(@RequestParam("message") String msg){
	  String statusMsg=producer.sendMessage(msg);
	  
	  ResponseEntity<String> response=new ResponseEntity<String>(statusMsg,HttpStatus.OK);
	  return response;
  }
  
  
  @GetMapping("/readAll")
  public ResponseEntity<List<String>> showAllMessages(){
	  
	  List<String> list=store.getAllMessage();
	  return new ResponseEntity<List<String>>(list,HttpStatus.OK);
  }

	
}
