package com.teressas.userplaylist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.userplaylist.models.Song;
import com.teressas.userplaylist.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	SongRepository songRepo;
	
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	public Song addSong(Song song) {
		return songRepo.save(song);
	}

	// find one item
	public Song findOneSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	// find one artist
	public List<Song> findBySongsByArtist(String artist) {
		return songRepo.findByArtistContaining(artist);
	}

	// update an item
	public Song editSong(Song song) {
		return songRepo.save(song);
	}

	// delete an item
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}

//		public List<Song> getTopTenSongs(String name, Integer rating) {
//			return songRepo.findTop10ByOrderByRatingDesc(name, rating);
//		}

	public List<Song> getTopTenSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	
	
}
