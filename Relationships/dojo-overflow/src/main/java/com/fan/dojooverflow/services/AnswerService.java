package com.fan.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.dojooverflow.models.Answer;
import com.fan.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;
	
	public Answer findOne(Long answer_id) {
		Optional<Answer> answer = this.answerRepo.findById(answer_id);
		return answer.isPresent() ? answer.get() : null;
	}
	
	public List<Answer> findAll(){
		return this.answerRepo.findAll();
	}
	
	public Answer create(Answer answer) {
		return this.answerRepo.save(answer);
	}
	
	public List<Answer> questionAnswers(Long questionId){
		return this.answerRepo.findByQuestionIdIs(questionId);
	}
}
