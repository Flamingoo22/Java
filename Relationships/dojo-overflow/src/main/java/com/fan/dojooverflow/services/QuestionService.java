package com.fan.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.dojooverflow.models.Answer;
import com.fan.dojooverflow.models.Question;
import com.fan.dojooverflow.models.Tag;
import com.fan.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	public Question create(Question question) {
		return this.questionRepo.save(question);
	}
	
	public Question findOne(Long question_id) {
		Optional<Question>question = this.questionRepo.findById(question_id);
		return question.isPresent()?question.get():null;
	}
	
	public List<Question> findAll(){
		return this.questionRepo.findAll();
	}
	
	public List<Question> getAssignedTag(Tag tag){
		return this.questionRepo.findAllByTags(tag);
	}
	
	public List<Question> getUnassignedTag(Tag tag){
		return this.questionRepo.findAllByTagsNotContains(tag);
	}
	
	public Question addAnswer(Question question, Answer answer) {
		question.getAnswers().add(answer);
		return this.questionRepo.save(question);
	}
}
