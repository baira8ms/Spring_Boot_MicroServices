package com.chart.spring.MicroserviceWeb.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="Payment")
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_SEQ")
    @SequenceGenerator(sequenceName = "payment_sequence", allocationSize = 1, name = "PAYMENT_SEQ")
	private String id;
	private String name;
	private String currencyType;
	private BigDecimal amount;
}
