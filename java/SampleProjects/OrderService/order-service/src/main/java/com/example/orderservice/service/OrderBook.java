package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.dao.OrderRepository;
import com.example.orderservice.dto.Payment;
import com.example.orderservice.dto.TransactionPayload;
import com.example.orderservice.entity.Order;

@Service
@RefreshScope
public class OrderBook {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String PAYMENT_API;
	
	public TransactionPayload saveOrder(TransactionPayload transactionRequest) {
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();

			payment.setOrderId(order.getId());
			payment.setAmount(order.getPrice());
			
			Payment paymentResponse = restTemplate.postForObject(PAYMENT_API, payment, Payment.class);		
			Order orderResponse = orderRepository.save(order);
			

			return new TransactionPayload(orderResponse, paymentResponse);
			
	}

}
