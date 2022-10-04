package com.fan.mvc.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.mvc.models.Book;
import com.fan.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		// TODO Auto-generated constructor stub
		this.bookRepository = bookRepository;
	}
	
    // returns all the books
    public ArrayList<Book> allBooks() {
    	ArrayList<Book> books = new ArrayList<Book>();
    	books.addAll(bookRepository.findAll());
        return books;
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book update(Book b) {
        return bookRepository.save(b);
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
	

}
