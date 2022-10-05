package com.fan.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fan.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {

    public List<Song> findTop10ByOrderByRatingDesc();
	
	List<Song> findAll();
	
	List<Song> findByAuthorContaining(String author);
	
}
