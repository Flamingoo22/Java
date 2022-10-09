package com.fan.dojooverflowsolution.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fan.dojooverflowsolution.models.Answer;
import com.fan.dojooverflowsolution.models.Question;
import com.fan.dojooverflowsolution.models.Tag;
import com.fan.dojooverflowsolution.repositories.QuestionRepo;

@Service
public class QuestionService {
	private final QuestionRepo questionRepo;
	
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public List<Question> allQuestions(){
		return questionRepo.findAll();
	}
	
	public List<Question> getAssignedTags(Tag tag){
		return questionRepo.findAllByTags(tag);
	}
	
	public List<Question> getUnassignedTags(Tag tag){
		return questionRepo.findByTagsNotContains(tag);
	}
	
	public Question findById(Long id) {
		Optional<Question> optionalQuestion = questionRepo.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}else {
			return null;
		}
	}
	
	public Question addQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public void deleteQuestion(Question question) {
		questionRepo.delete(question);
	}
	
	public Question addAnswer(Question question, Answer answer) {
		question.getAnswers().add(answer);
		return questionRepo.save(question);
	}
}
