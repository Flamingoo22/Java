package com.fan.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fan.lookify.models.Song;
import com.fan.lookify.repositories.SongRepo;

@Service
public class SongService {
	private SongRepo songRepo;
	
	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSong(){
		return this.songRepo.findAll();
	}
	
	public List<Song> findByAuthor(String author){
		return this.songRepo.findByAuthorContaining(author);
	}
	
	public Song oneSong(Long id) {
		return this.songRepo.findById(id).isPresent() ? this.songRepo.findById(id).get(): null;
	}
	
	public Song createSong(Song song) {
		return this.songRepo.save(song);
	}
	
	public Song editSong(Song song) {
		return this.songRepo.save(song);
	}
	
	public void deleteSong(Long id) {
		this.songRepo.deleteById(id);
	}
	
	public List<Song> topTen(){
		return this.songRepo.findTop10ByOrderByRatingDesc();
	}

}
