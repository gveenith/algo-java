package com.example.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/doPayment")
	public Payment performPayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
		
	}
}
