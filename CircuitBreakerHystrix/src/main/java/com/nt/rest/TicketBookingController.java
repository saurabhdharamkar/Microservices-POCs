package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TicketBookingController {

	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod = "bookShow")
	public  String   bookTickets() {
		System.out.println("TicketBookingController.bookShow()");
		int n=10/0;
			return "show booked sucessfully";
		}
	
	
	public  String bookShow() {  
		System.out.println("TicketBookingController.bookShow()");
		return " some problem in ticket booking";
	}
	
}
	
