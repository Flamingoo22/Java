package com.fan.dojooverflowsolution.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.dojooverflowsolution.models.Question;
import com.fan.dojooverflowsolution.models.Tag;


@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {
	List<Question> findAll();
	Question findByIdIs(Long id);
	List<Question> findAllByTags(Tag tag);
	List<Question> findByTagsNotContains(Tag tag);
}