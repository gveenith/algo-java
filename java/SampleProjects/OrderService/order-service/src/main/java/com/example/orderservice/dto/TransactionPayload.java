package com.example.orderservice.dto;


import com.example.orderservice.entity.Order;


public class TransactionPayload {
	
	private Order order;
	private Payment payment;
		
	
	public TransactionPayload() {
		super();
	}

	public TransactionPayload(Order order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}
	
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}


}
