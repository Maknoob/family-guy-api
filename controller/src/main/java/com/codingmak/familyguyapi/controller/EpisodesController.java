package com.codingmak.familyguyapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingmak.familyguyapi.model.Episodes;
import com.codingmak.familyguyapi.exceptions.EpisodeNotFound;
import com.codingmak.familyguyapi.service.EpisodesService;

@RestController
public class EpisodesController {
	
	
	private EpisodesService episodesService;
	
	public EpisodesController(EpisodesService episodesService) {
		this.episodesService = episodesService;
		
	}
	
	@GetMapping("/rest/episodes")
	public List<Episodes> getEpisodes(@RequestParam(required = false) String season) {
		if (season == null || season.isEmpty()) {
			return episodesService.getAllEpisodes();
		}
		return episodesService.getEpisodesBySeason(season);
	}
	
	@GetMapping("/rest/episodes/id")
	public Episodes getEpisodesById(@RequestParam(required = false) int id) {
		
		return episodesService.getEpisodeById(id);
	}
	
	
	@ExceptionHandler({EpisodeNotFound.class})
	public ResponseEntity<String> handleEpisodeNotFound(EpisodeNotFound exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
