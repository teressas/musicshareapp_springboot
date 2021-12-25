package com.teressas.userplaylist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teressas.userplaylist.models.Playlist;
import com.teressas.userplaylist.models.Song;
import com.teressas.userplaylist.repositories.PlaylistRepository;
import com.teressas.userplaylist.repositories.SongRepository;

@Service
public class PlaylistService {
	
	@Autowired
	PlaylistRepository playlistRepo;
	
	@Autowired
	SongRepository songRepo;
	
	// find all playlists
	public List<Playlist> allPlaylists() {
		return playlistRepo.findAll();
	}
	
	// add playlist
	public Playlist saveplaylist(Playlist playlist) {
		return playlistRepo.save(playlist);
	}

	// edit playlist
	public Playlist editPlaylist(Long id, String name) {
		Playlist oldPlaylist = this.findOnePlaylist(id);
		oldPlaylist.setName(name);
		return playlistRepo.save(oldPlaylist);
	}
	
	// find one playlist
	public Playlist findOnePlaylist(Long id) {
		Optional<Playlist> optionalPlaylist = playlistRepo.findById(id);
		if(optionalPlaylist.isPresent()) {
			return optionalPlaylist.get();
		} else {
			return null;
		}
	}
	
	// delete a playlist
	public void deletePlaylist(Long id) {
		playlistRepo.deleteById(id);
	}
	
	// add a song to a playlist
	public Playlist addSongToPlaylist(Playlist playlist) {
		return playlistRepo.save(playlist);
	}
	
	// remove a song from a playlist
	public Playlist removeSong(Long playlist_id, Song song) {
		Playlist playlist = this.findOnePlaylist(playlist_id);
		playlist.getSongs().remove(song);
		return playlistRepo.save(playlist);
		
	}
	
	
}
