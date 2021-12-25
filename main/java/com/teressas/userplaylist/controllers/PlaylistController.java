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
public class PlaylistController {
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
		// Create New
		@GetMapping("/playlist/new")
		public String showCreatePlaylistForm(@ModelAttribute("newPlaylist")Playlist newPlaylist, Model model) {
			List<Playlist> playlists = playlistService.allPlaylists();
			model.addAttribute("playlists",playlists);
			return "createPlaylistForm.jsp";
		}
		
		// Process Create Form
		@PostMapping("/playlist/new")
		public String processCreatePlaylistForm(@Valid @ModelAttribute("newPlaylist") Playlist newPlaylist,
				BindingResult result) {
			if(result.hasErrors()) {
				return "createPlaylistForm.jsp";
			} else {
				playlistService.saveplaylist(newPlaylist);
				return "redirect:/dashboard";
			}
			
		}
		
		// Get One
		@GetMapping("/playlists/{id}")
		public String getOnePlaylist(@PathVariable("id") Long id, Model model) {
			Playlist playlist = playlistService.findOnePlaylist(id);
			model.addAttribute("playlist", playlist);
			List<Song> songs = songService.allSongs();
			model.addAttribute("songs",songs);
			return "showOnePlaylist.jsp";
		}
		
		// Add song to playlist
		@PutMapping("/playlists/{playlistId}")
		public String addSongToPlaylist(@PathVariable("playlistId") Long playlistId,
				@RequestParam("songId") Long songId) {
			Playlist playlist = playlistService.findOnePlaylist(playlistId);
			Song song = songService.findOneSong(songId);
			playlist.getSongs().add(song);
			playlistService.saveplaylist(playlist);
			return "redirect:/playlists/" + playlistId;
		}

		// remove a song for a playlist
		@PutMapping("/playlists/{playlistId}/update/{songId}")
		public String removeSongFromPlaylist(@PathVariable("playlistId") Long playlistId, 
				@PathVariable("songId") Long songId) {
			Playlist playlist = playlistService.findOnePlaylist(playlistId);
			Song song = songService.findOneSong(songId);
			playlistService.removeSong(playlistId, song);
			return "redirect:/playlists/" + playlistId;
			
		}				

		
		
		// Edit a playlist name
		@GetMapping("/playlists/edit/{id}")
		public String showUpdatePlaylistForm(@PathVariable("id") Long id, Model model) {
			Playlist playlist = playlistService.findOnePlaylist(id);
			model.addAttribute("playlist", playlist);
			return "editOnePlaylistForm.jsp";
		}
		
		
		// process edit playlist form
		@PutMapping("/playlists/edit/{id}")
		public String processEditPlaylistForm(@Valid @ModelAttribute("playlist") Playlist playlist, 
				BindingResult result, @PathVariable("id") Long id) {
			if(result.hasErrors()) {
				return "editOnePlaylistForm.jsp";
			}else {
				playlistService.saveplaylist(playlist);
				return "redirect:/dashboard";
			}
			
		}
	
		// Delete a playlist
		@DeleteMapping("/playlists/delete/{id}")
		public String processDeleteOne(@PathVariable("id") Long id) {
			playlistService.deletePlaylist(id);
			return "redirect:/dashboard";
		}
		
		
		
			
}
