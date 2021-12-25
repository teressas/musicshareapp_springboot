package com.teressas.userplaylist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teressas.userplaylist.models.Playlist;
import com.teressas.userplaylist.models.Song;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

	List<Playlist> findAll();
	
	List<Playlist> findAllBySongs(Song song);
	
	
}
