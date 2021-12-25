package com.teressas.userplaylist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teressas.userplaylist.models.Playlist;
import com.teressas.userplaylist.models.Song;

@Repository
public interface SongRepository  extends CrudRepository<Song, Long> {
	
	List<Song> findAll();

	List<Song> findByArtistContaining(String artist);

	List<Song> findTop10ByOrderByRatingDesc();

	List<Song> findAllByPlaylists(Playlist playlist);
	
	List<Song> findByPlaylistsNotContains(Playlist playlist);

//	@Query(value = "SELECT * FROM songs ORDER BY rating DESC", nativeQuery = true)
//	List<Song> findTopTenOrderByRatingDesc();


}
