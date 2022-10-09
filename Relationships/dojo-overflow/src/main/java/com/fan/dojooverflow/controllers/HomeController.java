package com.fan.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fan.dojooverflow.models.Answer;
import com.fan.dojooverflow.models.Question;
import com.fan.dojooverflow.models.Tag;
import com.fan.dojooverflow.services.AnswerService;
import com.fan.dojooverflow.services.QuestionService;
import com.fan.dojooverflow.services.TagService;

@Controller
public class HomeController {

	@Autowired
	private AnswerService answerSev;
	
	@Autowired
	private QuestionService questionServ;
	
	@Autowired
	private TagService tagServ;
	
	
	@GetMapping("")
	public String dashboard(
			Model model
			) {
		model.addAttribute("questions", this.questionServ.findAll());
		model.addAttribute("tags", this.tagServ.findAll());
		return "/questions/dashboard.jsp";
	}
	
	
	@GetMapping("/questions/new")
	public String newQuestion(
			Model model
			) {
		
		List<Tag>tags = this.tagServ.findAll();
		model.addAttribute(tags);
		return "/questions/new.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(
			@RequestParam(value="listOfTags")String listOfTags,
            @RequestParam(value="questionText")String questionText,
			Model model
			) {
		List<Tag> tags = this.tagServ.findAll();
		model.addAttribute("tags",tags);
		System.out.println("-------------------");
		List<Tag> questionTags = this.checkTags(listOfTags);
		System.out.println(questionTags);
		if(questionTags != null) {
		    System.out.println("-------------------");
			Question newQuestion = new Question(questionText);
			System.out.println("-------------------");
			newQuestion.setTags(questionTags);
			System.out.println("-------------------");
			this.questionServ.create(newQuestion);
			System.out.println("-------------------");
		}else {
			model.addAttribute("errorMsg","You can only enter up to three tags (all lowercase and separated by a comma)");
			return "questions/new.jsp";		
		}
		return "redirect:/";
	}
	
	@GetMapping("/answers/{id}")
	public String newAnswer(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Question question = this.questionServ.findOne(id);
		model.addAttribute("question", question);
		return "new_answer.jsp";
	}
	
	@PostMapping("/answers/{id}")
	public String addNewAnswer(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("answer") Answer answer, 
			BindingResult result,
			Model model) {
		Question question = this.questionServ.findOne(id);
		model.addAttribute("question", question);
		if(result.hasErrors()) {
			return "new_answer.jsp";
		}else {
			Answer newAnswer = new Answer(answer.getAnswerText());
			newAnswer.setQuestion(question);
			this.answerSev.create(newAnswer);
			return "redirect:/answers/"+id;
		}	
	}
	
	private List<Tag> checkTags(String tags){
		String[] splitTags = tags.trim().split(",");
		ArrayList<Tag> tempTags = new ArrayList<Tag>();
		
		if(splitTags.length>3) {
			return null;
		}
		
		for(String s :splitTags) {
			s = s.trim().toLowerCase();
			if(this.tagServ.findBySubject(s) == null && s.length()>0) {
			    this.tagServ.create(new Tag(s));
				tempTags.add(new Tag(s));
			}else {
				tempTags.add(this.tagServ.findBySubject(s));
			}
		}
		return tempTags;
	}
}
