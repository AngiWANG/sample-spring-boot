package com.allinpay.sample.spring.boot.readinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allinpay.sample.spring.boot.readinglist.dao.BookRepository;
import com.allinpay.sample.spring.boot.readinglist.model.Book;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {
	private BookRepository bookRepository;

	@Autowired
	public ReadingListController(BookRepository readingListRepository) {
		this.bookRepository = readingListRepository;
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.GET)
	public String readersBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> readingList = bookRepository.findByReader(reader);
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		return "readingList";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		bookRepository.save(book);
		return "redirect:{reader}";
	}
}
