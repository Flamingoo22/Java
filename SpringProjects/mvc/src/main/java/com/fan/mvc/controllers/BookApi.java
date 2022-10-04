package com.fan.mvc.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fan.mvc.models.Book;
import com.fan.mvc.services.BookService;

@RestController
public class BookApi {
	private final BookService bookService;
	public BookApi(BookService bookService) {
		this.bookService = bookService;
		// TODO Auto-generated constructor stub
	}
    @RequestMapping("/api/books")
    public ArrayList<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    
    @PutMapping("/api/books")
    public Book update(@RequestParam(value="id") Long id, 
    		@RequestParam(value="title", required=false) String title, 
    		@RequestParam(value="description", required=false) String desc, 
    		@RequestParam(value="language", required=false) String lang, 
    		@RequestParam(value="pages", required=false) int numOfPages) {
    	Book bookFromDb = bookService.findBook(id);
    	//if title doesnot equal null;
    	bookFromDb.setTitle(title);
    	bookFromDb.setDescription(desc);
    	bookFromDb.setLanguage(lang);
    	bookFromDb.setNumberOfPages(numOfPages);
    	return bookService.createBook(bookFromDb);
    }
    
    @DeleteMapping("/api/books/delete")
    public String delete(
    		@RequestParam(value="id") Long id
    		) {
    	bookService.deleteBook(id);
    	return "redirect:/api/books";
    }
    
    @GetMapping("/api/books/update")
    public String update(
    		@RequestParam(value="id") Long id
    		) {
    	bookService.deleteBook(id);
    	return "redirect:/api/books";
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
}	
