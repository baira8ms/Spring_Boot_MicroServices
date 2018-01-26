package com.chart.spring.MicroserviceWeb.beans;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDTO {

	private String id;
	private String name;
	private String currencyType;
	private BigDecimal amount;
}
