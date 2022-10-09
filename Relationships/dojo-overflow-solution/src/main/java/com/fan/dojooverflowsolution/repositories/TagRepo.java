package com.fan.dojooverflowsolution.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.dojooverflowsolution.models.Question;
import com.fan.dojooverflowsolution.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	Tag findByIdIs(Long id);
	Tag findBySubjectIs(String subject);
	List<Tag> findAllByQuestions(Question question);
	List<Tag> findByQuestionsNotContains(Question question);
}