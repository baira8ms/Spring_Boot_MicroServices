package com.chart.spring.MicroserviceWeb.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_SEQ")
	@SequenceGenerator(sequenceName = "document_sequence", allocationSize = 1, name = "DOCUMENT_SEQ",initialValue=5)
	private long id;
	
	private String name;
	
	@Lob
	private byte[] content;
}
