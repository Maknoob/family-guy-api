package com.codingmak.familyguyapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingmak.familyguyapi.Exceptions.EpisodeNotFound;
import com.codingmak.familyguyapi.Model.EpisodesModel;
import com.codingmak.familyguyapi.service.EpisodesService;

@RestController
@RequestMapping("/episodes")
public class EpisodesController {
	
	@Autowired
	private EpisodesService episodesService;
	
	public EpisodesController(EpisodesService episodesService) {
		this.episodesService = episodesService;
		
	}
	
	@GetMapping
	public List<EpisodesModel> getAllEpisodes() {
		return episodesService.getAllEpisodes();
	}

	
	@GetMapping ("/{id}")
	public EpisodesModel getEpisodeById(@PathVariable Integer id) {
		Optional<EpisodesModel> episode = episodesService.getEpisodeById(id);
		if(episode.isPresent()) {
			return (EpisodesModel) episode.get();
		} 
		return null;
	}
	
	@ExceptionHandler({EpisodeNotFound.class})
	public ResponseEntity<String> handleEpisodeNotFound(EpisodeNotFound exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
