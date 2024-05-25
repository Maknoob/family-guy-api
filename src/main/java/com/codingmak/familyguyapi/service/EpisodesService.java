package com.codingmak.familyguyapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingmak.familyguyapi.Model.EpisodesModel;


@Service
public class EpisodesService {

	List<EpisodesModel> episodeList;
	
	public EpisodesService() {
		episodeList = new ArrayList<>();
		
		EpisodesModel peter = new EpisodesModel(1, 1, 1, "Death Has a Shadow", "N/A");
		EpisodesModel lois = new EpisodesModel(2, 2, 1, "I Never Met the Dead Man", "N/A");
		EpisodesModel chris = new EpisodesModel(3, 3, 1, "Chitty Chitty Death Bang", "N/A");
		EpisodesModel stewie = new EpisodesModel(4, 4, 1, "Mind Over Murder", "N/A");
		EpisodesModel meg = new EpisodesModel(5, 5, 1, "A Hero Sits Next Door", "N/A");
		
		episodeList.addAll(Arrays.asList(peter,lois,chris,stewie,meg));
	}
	
	public List<EpisodesModel> getAllEpisodes() {
	
		return episodeList;
	}
	
	public Optional<EpisodesModel> getEpisodeById(Integer id) {
		Optional<EpisodesModel> optional = Optional.empty();
		for (EpisodesModel episodesModel : episodeList) {
			
			if (id == episodesModel.getId()) {
				optional = Optional.of(episodesModel);
				return optional;
			}
		}
		return optional;
	}
}
