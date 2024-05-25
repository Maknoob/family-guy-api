package com.codingmak.familyguyapi.Controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingmak.familyguyapi.Model.EpisodesModel;
import com.codingmak.familyguyapi.service.EpisodesService;

@RestController
public class EpisodesController {
	
	private EpisodesService episodesService;
	
	public EpisodesController(EpisodesService episodesService) {
		this.episodesService = episodesService;
		
	}
	
	@GetMapping ("/episodes")
	public EpisodesModel getEpisode(@RequestParam Integer id) {
		Optional<EpisodesModel> episode = episodesService.getEpisode(id);
		if(episode.isPresent()) {
			return (EpisodesModel) episode.get();
		}
		return null;
	}



}
