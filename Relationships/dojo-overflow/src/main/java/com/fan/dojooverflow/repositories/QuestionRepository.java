package com.fan.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.dojooverflow.models.Question;
import com.fan.dojooverflow.models.Tag;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
	Question findByIdIs(Long id);
	List<Question> findAllByTags(Tag tag);
	List<Question> findAllByTagsNotContains(Tag tag);
}
