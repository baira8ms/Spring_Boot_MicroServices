package com.chart.spring.MicroserviceWeb.controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chart.spring.MicroserviceWeb.services.UploadService;

@RestController
public class UploadController {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UploadService uploadService;

	@PostMapping("/upload/{docName}")
	public ResponseEntity<String> uploadFile(@PathVariable String docName, @RequestParam("file") MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException {
		if (file == null) {
			throw new UnsupportedOperationException("MultipartFile unavailable.");
		}

		uploadService.uploadDocument(docName, file);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/download/{docId}")
	public ResponseEntity<Resource> uploadFile(@PathVariable long docId)
			throws JsonParseException, JsonMappingException, IOException {
		if (docId <= 0) {
			throw new UnsupportedOperationException("Document id is missing.");
		}
		byte[] arr = uploadService.downloadDocument(docId).getContent();

		ByteArrayResource resource = new ByteArrayResource(arr);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Content-Disposition", "attachment; filename=download.pdf");
		return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength()).body(resource);

	}

	// Payment payment = objectMapper.readValue(file.getInputStream(),
	// Payment.class);
	// System.out.println(uploadService.savePaymentDetails(payment));
	// return ResponseEntity.status(HttpStatus.CREATED).build();
}
