package com.chart.spring.MicroserviceWeb.services;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chart.spring.MicroserviceWeb.beans.Document;
import com.chart.spring.MicroserviceWeb.beans.DocumentDTO;
import com.chart.spring.MicroserviceWeb.beans.PaymentDTO;
import com.chart.spring.MicroserviceWeb.beans.Payment;
import com.chart.spring.MicroserviceWeb.repositories.DocumentRepository;
import com.chart.spring.MicroserviceWeb.repositories.PaymentRepository;

@Service
public class UploadService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Transactional
	public PaymentDTO savePaymentDetails(PaymentDTO payment) {
		Payment paymentEntity = paymentRepository.save(modelMapper.map(payment, Payment.class));
		return modelMapper.map(paymentEntity, PaymentDTO.class);
	}

	public DocumentDTO uploadDocument(String docName, MultipartFile file) throws IOException {
		DocumentDTO dto = new DocumentDTO();
		dto.setContent(file.getBytes());
		dto.setName(docName);

		return modelMapper.map(documentRepository.save(modelMapper.map(dto, Document.class)), DocumentDTO.class);
	}

	public DocumentDTO downloadDocument(long id) throws IOException {
		return modelMapper.map(documentRepository.findOne(id), DocumentDTO.class);
	}
}
