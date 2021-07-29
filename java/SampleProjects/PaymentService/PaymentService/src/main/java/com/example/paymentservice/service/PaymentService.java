package com.example.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentservice.dao.PaymentRepo;
import com.example.paymentservice.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo paymentRepository;
	
	public Payment savePayment(Payment payment) {
		payment.setPaymentStatus(paymentGateway());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentGateway() {
		return new Random().nextBoolean()? "Payment is successfull" : "TRansaction failure";
	}

	
}
