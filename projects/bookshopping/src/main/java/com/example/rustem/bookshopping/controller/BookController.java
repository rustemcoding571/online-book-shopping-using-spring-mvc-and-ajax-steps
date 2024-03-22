package com.example.rustem.bookshopping.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.entity.Book;
import com.example.rustem.bookshopping.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;
	
	@GetMapping
	public String showBooks(Model model){
		 List<BookDto> books = service.findAll();
		 model.addAttribute("books", books);
		 return "books";
	}
	
	@GetMapping(path = "/new")
	public String openNewBookPage(Model model){
		BookDto bookDto = new BookDto();
		model.addAttribute("book", bookDto);
		 return "new-book"; 
	}
	
	@PostMapping(path = "/new-book-process")
	public String saveBook(@ModelAttribute(name = "book") BookDto dto,Model model) {
		service.addBook(dto);
		List<BookDto> books = service.findAll();
		model.addAttribute("books", books);
		return "books";
	}
}