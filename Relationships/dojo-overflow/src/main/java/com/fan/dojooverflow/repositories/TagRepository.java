package com.fan.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.dojooverflow.models.Question;
import com.fan.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
    Tag findByIdIs(Long id);
	Tag findBySubjectIs(String subject);
	List<Tag> findAllByQuestions(Question question);
	List<Tag> findAllByQuestionsNotContains(Question question);
}
