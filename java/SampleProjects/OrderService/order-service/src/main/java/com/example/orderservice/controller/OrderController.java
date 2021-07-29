package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dto.TransactionPayload;
import com.example.orderservice.service.OrderBook;

@RestController
@RequestMapping("/order")
 class OrderController {
	
	@Autowired
	private OrderBook orderBook;

	
	@PostMapping("/orders")
	public TransactionPayload bookOrder(@RequestBody TransactionPayload transactionRequest) {	
		return orderBook.saveOrder(transactionRequest);
	}
	
	 
	

}
