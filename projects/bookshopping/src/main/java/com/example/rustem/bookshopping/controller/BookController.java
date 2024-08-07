package com.example.rustem.bookshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.rustem.bookshopping.dto.BookDto;
import com.example.rustem.bookshopping.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;

	@GetMapping
	public String showBooks(Model model) {
		List<BookDto> books = service.findAllByUsername(model);
		model.addAttribute("books", books);
		return "books";
	}

	@GetMapping(path = "/new")
	public String openNewBookPage(Model model) {
		BookDto bookDto = new BookDto();
		model.addAttribute("book", bookDto);
		model.addAttribute("header", "Create new Book");
		return "new-book";
	}

	@PostMapping(path = "/new-book-process")
	public String saveBook(@Valid @ModelAttribute(name = "book") BookDto dto, BindingResult br,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile, Model model) {
		if (br.hasErrors()) {
			return "new-book";
		}
		System.out.println(imageFile);
		service.addBook(dto, imageFile);
		List<BookDto> books = service.findAll(model);
		model.addAttribute("books", books);
		return "redirect:/books";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteById(@PathVariable(name = "id") Integer id, Model model) {
		service.deleteById(id);
		List<BookDto> books = service.findAll(model);
		model.addAttribute("books", books);
		return "redirect:/books";
	}

	@GetMapping(path = "/edit/{id}")
	public String editBook(@PathVariable(name = "id") Integer id, Model model) {
		service.editBook(id, model);
		model.addAttribute("header", "Edit Book");
		return "new-book";
	}
}
