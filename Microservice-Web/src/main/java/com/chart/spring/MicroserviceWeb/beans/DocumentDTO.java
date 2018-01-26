package com.chart.spring.MicroserviceWeb.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentDTO {
	private long id;
	private String name;
	private byte[] content;
}
