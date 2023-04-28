package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.BalanceResponse;
import com.example.demo.TransferAccountDetails;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.service.KafkaProducerService;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private KafkaProducerService kafkaProductService;
	
	
   @GetMapping("/getAccountDetails/{accountNo}")
   public ResponseEntity<?> getAccountDetails(@PathVariable int accountNo){
	  ResponseEntity<?> resp=null;
	  String url="http://localhost:8082/account/getAccount/"+accountNo;
	  ResponseEntity<Account> account = restTemplate.getForEntity(url, Account.class);
	   return account;
   }
   
   
   
   @GetMapping("/depositAmmount/{accountNo}/{password}/{deposit}")
   public ResponseEntity<Account> depositAmmount(@PathVariable int accountNo,@PathVariable int password,@PathVariable int deposit) {
	
	   String url="http://localhost:8082/account/depositAmmount/"+accountNo+"/"+password+"/"+deposit;
	   ResponseEntity<Account> account=restTemplate.getForEntity(url,Account.class);
	   return account;
   }
   
   
   
   @GetMapping("/withdrawAmmount/{accountNo}/{password}/{withdraw}")
   public ResponseEntity<Account> withdrawAmmount(@PathVariable int accountNo,@PathVariable int password,@PathVariable int withdraw) { 
	   String url="http://localhost:8082/account/withdrawAmmount/"+accountNo+"/"+password+"/"+withdraw;
	   System.out.println(url);
	   ResponseEntity<Account> account=restTemplate.getForEntity(url,Account.class);
	   return account;
   }
   
   
   
   @GetMapping("/checkAccountBalance/{accountNo}/{password}")
   public ResponseEntity<BalanceResponse> checkBalance(@PathVariable int accountNo,@PathVariable int password) {
	   ResponseEntity<BalanceResponse> balanceResponse;
	   String url="http://localhost:8082/account/checkBalance/"+accountNo+"/"+password;
	   balanceResponse=restTemplate.getForEntity(url, BalanceResponse.class);
	   return balanceResponse;
	   
   }
   
   @GetMapping("/transferAmmount/{accountNo1}/{ammount}/{accountNo2}")
   public ResponseEntity<TransferAccountDetails> transferAmmount(@PathVariable int accountNo1,@PathVariable int ammount,
		                                                                                @PathVariable int accountNo2){
	   
	   String url="http://localhost:8082/account/transferAmmount/"+accountNo1+"/"+ammount+"/"+accountNo2;
	   ResponseEntity<TransferAccountDetails> account=restTemplate.getForEntity(url, TransferAccountDetails.class);
	   return account;
   }
   
   @GetMapping("/getUserDetail/{accNo}")
   public ResponseEntity<?> getUserDetails(@PathVariable int accNo){
	   String url="http://localhost:8081/user/getUserListByAccountNo/"+accNo;
	   System.out.println("url "+url);
	   ResponseEntity<?> user=restTemplate.getForEntity(url, User[].class);
	   return user;
   }
   
   @GetMapping("/send/data/topic/{message}")
   public ResponseEntity<String> sendDataToTopic(@PathVariable String message){
	   String messageResponse = kafkaProductService.sendMessage(message);
	   return ResponseEntity.ok(messageResponse);
   }
   
}