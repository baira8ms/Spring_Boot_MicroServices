package com.chart.spring.MicroserviceWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chart.spring.MicroserviceWeb.beans.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
