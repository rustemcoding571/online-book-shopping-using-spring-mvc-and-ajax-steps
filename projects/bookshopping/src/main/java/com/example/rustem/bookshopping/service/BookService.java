package com.example.rustem.bookshopping.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.rustem.bookshopping.dto.BookDto;

public interface BookService {

	List<BookDto> findAll(Model model);

	List<BookDto> findAllByUsername(Model model);

	BookDto findAllById(Integer id);

	BookDto addBook(BookDto bookDto, MultipartFile image);

	void deleteById(Integer id);

	BookDto editBook(Integer id, Model model);
}
