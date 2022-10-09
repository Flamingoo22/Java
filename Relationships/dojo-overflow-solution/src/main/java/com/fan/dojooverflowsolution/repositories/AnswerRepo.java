package com.fan.dojooverflowsolution.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.dojooverflowsolution.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long> {
	List<Answer> findAll();
	List<Answer> findByQuestionIdIs(Long id);
}
