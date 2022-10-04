package com.fan.mvc.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fan.mvc.models.Book;
import com.fan.mvc.services.BookService;

@Controller
public class RenderBook {
	private final BookService bookService;
	public RenderBook(BookService bookService) {
		this.bookService = bookService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/books/{bookId}")
	public String showBook(
			@PathVariable(value="bookId") Long bookId,
			Model model) {
        Book book = bookService.findBook(bookId);
        model.addAttribute(book);
		return "index.jsp";
		
	}
	
	@GetMapping("/books")
	public String showBooks(
			Model model) {
        ArrayList<Book> books = bookService.allBooks();
        model.addAttribute("books",books);
		return "home.jsp";
		
	}
	

}
