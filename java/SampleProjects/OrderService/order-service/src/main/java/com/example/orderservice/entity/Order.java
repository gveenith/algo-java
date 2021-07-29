package com.example.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "ORDERS_TB")
public class Order {

	@Id
	private int id;
	private String name;
	private int qty;
	private double price;
	
	
	
	public Order() {
		super();
	}

	public Order(int id, String name, int qty, double price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
