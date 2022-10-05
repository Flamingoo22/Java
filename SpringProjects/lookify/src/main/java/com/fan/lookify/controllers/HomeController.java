package com.fan.lookify.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fan.lookify.models.Song;
import com.fan.lookify.services.SongService;

@Controller
public class HomeController {
	private SongService songServ;
	
	public HomeController(SongService songServ) {
		this.songServ = songServ;
	}
	
	
	@GetMapping("")
	public String splash() {
		return "splash.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(
			Model model
			) {
		model.addAttribute("songs",this.songServ.allSong());
		return "dashboard.jsp";
	}
	
	@DeleteMapping("/songs/{id}")
	public String deleteSong(
			@PathVariable("id")Long id
			) {
		this.songServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/search")
	public String findAuthor(
			@RequestParam("author")String author,
			HttpSession session
			){
		System.out.println(author);
		List<Song> song = this.songServ.findByAuthor(author);
		System.out.println(song);
		session.setAttribute("song", song);
		return "redirect:/search/" + author;
	}
	
	@GetMapping("/search/{author}")
	public String searchAuthor(
			@PathVariable("author")String author,
			Model model
			) {
		model.addAttribute("author", author);
		model.addAttribute("songs",this.songServ.findByAuthor(author));
		return "/search/author.jsp";
	}
	
	@GetMapping("/songs/new")
	public String createSong(
			@ModelAttribute("song")Song song
			) {
		return"/songs/new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createRoute(
			@Valid @ModelAttribute("song")Song song,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		}
		this.songServ.createSong(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{id}")
	public String edit(
			@PathVariable("id")Long id,
			Model model
			) {
		model.addAttribute("song", this.songServ.oneSong(id));
		return "songs/oneSong.jsp";
	}
	
	@GetMapping("/search/topTen/a")
	public String topTen(Model model) {
		model.addAttribute("topTen", this.songServ.topTen());
		return "search/topTen.jsp";
	}
	
}
