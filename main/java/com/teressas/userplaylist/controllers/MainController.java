package com.teressas.userplaylist.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teressas.userplaylist.models.Playlist;
import com.teressas.userplaylist.models.Song;
import com.teressas.userplaylist.services.PlaylistService;
import com.teressas.userplaylist.services.SongService;

@Controller
public class MainController {

	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;

	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// Get All 
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs",songs);
		List<Playlist> playlists = playlistService.allPlaylists();
		model.addAttribute("playlists", playlists);
		return "dashboard.jsp";
	}
	
	// Create New
	@GetMapping("/songs/new")
	public String showCreateSongForm(@ModelAttribute("newSong")Song newSong) {
		return "createSongForm.jsp";
	}
	
	// Process Create Form
	@PostMapping("/songs/new")
	public String processCreateSongForm(@Valid @ModelAttribute("newSong") Song newSong,
			BindingResult result) {
		if(result.hasErrors()) {
			return "createSongForm.jsp";
		} else {
			songService.addSong(newSong);
			return "redirect:/dashboard";
		}
		
	}
	
	// Get One
	@GetMapping("/songs/{id}")
	public String getOneSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findOneSong(id);
		model.addAttribute("song", song);
		return "showOneSong.jsp";
	}

	
	// Search
	@GetMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<Song> songs  = songService.findBySongsByArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "searchSongsByArtist.jsp";
	}
	
	@PostMapping("/search")
	public String searchProcess(@RequestParam(value="artist") String artist) {
		if (artist.equals("")) {
			return "redirect:/dashboard";
		}
		if(songService.findBySongsByArtist(artist) != null) {
			return "redirect:/search/" + artist;
		} else {
			return "redirect:/dashboard";
		}
	}
	

	// Process Edit Form
	@PutMapping("/dashboard")
	public String processEditForm(@Valid @ModelAttribute("song") Song song, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "dashboard.jsp";
		} else {
			songService.findOneSong(id);
			return "redirect:/search/{id}";
		}
	}
	
	@GetMapping("/songs/topsongs")
	public String showTopTenSongs(Model model) {
		List<Song> songs = songService.getTopTenSongs();
		model.addAttribute("songs", songs);
		return "showTopTenSongs.jsp";
	}
	


	// Delete
	@DeleteMapping("/songs/delete/{id}")
	public String processDeleteOne(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	
}
