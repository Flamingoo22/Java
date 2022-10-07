package com.fan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.fan.bookclub.models.Book;
import com.fan.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book findBookById(Long book_id) {
		Optional<Book> book = this.bookRepo.findById(book_id);
		return book.isPresent()? book.get():null;
	}
	
	public List<Book> findAllBook(){
		return this.bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	public Book editBook(Book book, BindingResult result) {
		if(book.getId() == null) {
			result.rejectValue("book_id", "Book not found");
			return null;
		}
		return this.bookRepo.save(book);
	}
	
	public void deleteBook(Long book_id) {
		this.bookRepo.deleteById(book_id);
	}

}
