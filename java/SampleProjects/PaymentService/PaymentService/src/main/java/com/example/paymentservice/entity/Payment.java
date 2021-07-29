package com.example.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	private double amount;
	private int orderId;
	
	
	public Payment() {
		super();
	}
	
	public Payment(int paymentId, String paymentStatus, String transactionId, double amount, int orderId) {
		super();
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.setAmount(amount);
		this.setOrderId(orderId);
	}
	
	
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

}
