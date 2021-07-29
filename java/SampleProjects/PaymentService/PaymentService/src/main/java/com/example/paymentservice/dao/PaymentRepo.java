package com.example.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentservice.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
