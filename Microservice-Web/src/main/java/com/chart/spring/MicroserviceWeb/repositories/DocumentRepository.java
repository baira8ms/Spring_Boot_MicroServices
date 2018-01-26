package com.chart.spring.MicroserviceWeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chart.spring.MicroserviceWeb.beans.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
