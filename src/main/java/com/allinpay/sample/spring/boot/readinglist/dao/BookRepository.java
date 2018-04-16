package com.allinpay.sample.spring.boot.readinglist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allinpay.sample.spring.boot.readinglist.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}