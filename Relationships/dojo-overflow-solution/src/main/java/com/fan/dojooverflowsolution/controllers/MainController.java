package com.fan.dojooverflowsolution.controllers;

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

import com.fan.dojooverflowsolution.models.Answer;
import com.fan.dojooverflowsolution.models.Question;
import com.fan.dojooverflowsolution.models.Tag;
import com.fan.dojooverflowsolution.services.AnswerService;
import com.fan.dojooverflowsolution.services.QuestionService;
import com.fan.dojooverflowsolution.services.TagService;

@Controller
public class MainController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private TagService tagService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Question> questions = questionService.allQuestions();
		List<Tag> tags = tagService.allTags();
		
		model.addAttribute("questions", questions);
		model.addAttribute("tags", tags);
		
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question, Model model) {
		
		List<Tag> tags = tagService.allTags();
		model.addAttribute("tags", tags);
		return "new_question.jsp";
		
	}
	
	@PostMapping("/questions/new")
	public String addNewQuestion(
			@Valid @ModelAttribute("question") Question question, 
			BindingResult result,
			@RequestParam(value="listOfTags") String listOfTags,
			Model model) {
		List<Tag> tags = tagService.allTags();
		model.addAttribute("tags", tags);
		if(result.hasErrors()) {
			return "new_question.jsp";
		}else {
			List<Tag> questionTags = checkTags(listOfTags);
			if(questionTags!=null) {	
				Question newQuestion = new Question(question.getText());
				newQuestion.setTags(questionTags);
				questionService.addQuestion(newQuestion);
			}else {
				model.addAttribute("errorMsg", "You can only enter up to three tags (all lowercase and separated by a comma)");
				return "new_question.jsp";
			}

			return "redirect:/";
		}
	}
	
	@GetMapping("/answers/{id}")
	public String newAnswer(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Question question = questionService.findById(id);
		model.addAttribute("question", question);
		return "new_answer.jsp";
	}
	
	@PostMapping("/answers/{id}")
	public String addNewAnswer(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("answer") Answer answer, 
			BindingResult result,
			Model model) {
		Question question = questionService.findById(id);
		model.addAttribute("question", question);
		if(result.hasErrors()) {
			return "new_answer.jsp";
		}else {
			Answer newAnswer = new Answer(answer.getText());
			newAnswer.setQuestion(question);
			answerService.addAnswer(newAnswer);
			return "redirect:/answers/"+id;
		}	
	}
	
	private List<Tag> checkTags(String tagsString){
		// Create a List of Strings using the 'tagsString' String, which contains the tags the user has entered
		String[] splitTags = tagsString.trim().split(",");
		// Create a new ArrayList that we will populate with individual Tag objects
		ArrayList<Tag> tempTags = new ArrayList<>();
		
		// If we find more than 3 tags, we return null because we can only have up to 3 tags
		if(splitTags.length>3) {
			return null;
		}
		
		// Using a for loop, we iterate through the 'splitTags' and create new Tag objects for each one that does not exist in our database
		for(String s: splitTags) {
			// First we remove spaces before and after the tag String and convert the tag to all lower case characters
			s = s.trim().toLowerCase();
			// We make sure the Tag object does not exist and that the tag String is at least one character long
			if(tagService.findBySubject(s)==null && s.length()>0) {
				// If the Tag object is not found, we add a new Tag object to our tempTags ArrayList (which will then add it to our database later)
				tempTags.add(new Tag(s));
			}else {
				// If the object is found, we simply add it to the tempTags ArrayList
				tempTags.add(tagService.findBySubject(s));
			}
			
		}

		// Once we pass the tags to our question, it will add all new Tag objects to our database, 
		// pull existing Tag objects we have found, then add those Tag objects to the question
		// This happens on line 71 - 'newQuestion.setTags(questionTags);'
		return tempTags;
	}
}
	