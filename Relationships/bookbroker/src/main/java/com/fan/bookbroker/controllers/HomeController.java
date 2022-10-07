package com.fan.bookbroker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.fan.bookbroker.models.Book;
import com.fan.bookbroker.models.LoginUser;
import com.fan.bookbroker.models.User;
import com.fan.bookbroker.services.BookService;
import com.fan.bookbroker.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookServ;
	
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @GetMapping("/books")
    public String home(
    		Model model,
    		HttpSession session
    		) {
    	if(session.getAttribute("user_id")==null) {
    		return "redirect:/";
    	}
    	Long id = (Long) session.getAttribute("user_id");
    	model.addAttribute("user", this.userServ.findUserById(id));
    	model.addAttribute("books", this.bookServ.findAllBook());
    	return "books/home.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        this.userServ.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        this.userServ.create(newUser);
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	User user = this.userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/books";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/books/new")
    public String createBook(
    		@ModelAttribute("book")Book book,
    		HttpSession session
    		) {
    	if(session.getAttribute("user_id")==null) {
    		return "redirect:/";
    	}
    	return "books/new.jsp";
    }
    
    @PostMapping("/books/new")
    public String createBook(
    		@Valid @ModelAttribute("book")Book book,
    		BindingResult result,
    		HttpSession session
    		) {
    	if(session.getAttribute("user_id")==null) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
    		return "books/new.jsp";
    	}
    	this.bookServ.createBook(book);
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{book_id}")
    public String showOne(
    		@PathVariable("book_id")Long book_id,
    		Model model,
    		HttpSession session
    		) {
    	if(session.getAttribute("user_id")==null) {
    		return "redirect:/";
    	}
    	model.addAttribute("book", this.bookServ.findBookById(book_id));
    	return "books/showOne.jsp";
    	
    }
    
    @GetMapping("/books/{book_id}/edit")
    public String editBook(
    		@PathVariable("book_id")Long book_id,
    		Model model
    		) {
    	model.addAttribute("book", this.bookServ.findBookById(book_id));
    	return "books/edit.jsp";
    }
    
    @PutMapping("/books/{id}/edit")
    public String editBook(
    		@PathVariable("id")Long book_id,
    		@Valid @ModelAttribute("book")Book book,
    		BindingResult result,
    		Model model
    		) {
    	if(result.hasErrors()) {
    		model.addAttribute("book",book);
    		return "books/edit.jsp";
    	}
    	System.out.println("WE MADE IT HERE");
    	this.bookServ.editBook(book, result);
    	return "redirect:/books";
    }
    		
    @DeleteMapping("/books/{id}")
    public String deleteBook(
    		@PathVariable("id")Long id
    		) {
    	this.bookServ.deleteBook(id);
    	return "redirect:/books";
    }
    
    
}
