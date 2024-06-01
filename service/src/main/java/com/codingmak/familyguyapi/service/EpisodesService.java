package com.codingmak.familyguyapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.codingmak.familyguyapi.exceptions.EpisodeNotFound;
import com.codingmak.familyguyapi.model.Episodes;

import org.springframework.stereotype.Service;






@Service
public class EpisodesService {

	List<Episodes> episodeList;
	
	public EpisodesService() {
		episodeList = new ArrayList<>();
		
		Episodes peter = new Episodes(1, 1, 1, "Death Has a Shadow", "N/A");
		Episodes lois = new Episodes(2, 2, 2, "I Never Met the Dead Man", "N/A");
		Episodes chris = new Episodes(3, 3, 2, "Chitty Chitty Death Bang", "N/A");
		Episodes stewie = new Episodes(4, 4, 3, "Mind Over Murder", "N/A");
		Episodes meg = new Episodes(5, 5, 4, "A Hero Sits Next Door", "N/A");
		
		episodeList.addAll(Arrays.asList(peter,lois,chris,stewie,meg));
	}
	
	public List<Episodes> getAllEpisodes() {
	
		return episodeList;
	}
	
    public Episodes getEpisodeById(Integer id) {
    	
    	return episodeList.stream()
    			.filter(episodes -> id.equals(episodes.getId()))
    			.findFirst()
    			.orElseThrow(() -> new EpisodeNotFound("Episode not found with ID: " + id));
    			

    }

	public List<Episodes> getEpisodesBySeason(String season) {
		
		return episodeList.stream()
				.filter(episodes -> String.valueOf(episodes.getSeason()).equalsIgnoreCase(season))
				.collect(Collectors.toList());
	}
}
