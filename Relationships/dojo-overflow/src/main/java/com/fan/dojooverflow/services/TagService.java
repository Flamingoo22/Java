package com.fan.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.dojooverflow.models.Question;
import com.fan.dojooverflow.models.Tag;
import com.fan.dojooverflow.repositories.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepo;
	
	public Tag create(Tag tag) {
		return this.tagRepo.save(tag);
	}
	
	public Tag showOne(Long tag_id) {
		Optional<Tag>tag = this.tagRepo.findById(tag_id);
		return tag.isPresent()?tag.get():null;
	}
	
	public List<Tag> findAll(){
		return this.tagRepo.findAll();
	}
	
	public List<Tag> findAssignedQuestion(Question question){
		return this.tagRepo.findAllByQuestions(question);
	}
	
	public List<Tag> findUnassignedQuestion(Question question){
		return this.tagRepo.findAllByQuestionsNotContains(question);
	}
	
	public Tag findBySubject(String subject) {
		return this.tagRepo.findBySubjectIs(subject);
	}
}
