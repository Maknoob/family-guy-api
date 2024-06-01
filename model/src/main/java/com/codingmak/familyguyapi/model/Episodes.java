package com.codingmak.familyguyapi.model;

public class Episodes {
	
	private int id;
	private int episode;
	private int season;
	private String title;
	private String description;
	
	
	
	public Episodes(int id, int episode, int season, String title, String description) {
		this.id = id;
		this.episode = episode;
		this.season = season;
		this.title = title;
		this.description = description;
	}
	
	
	public int getId() {
		return id;
	}
	public int getEpisode() {
		return episode;
	}
	public int getSeason() {
		return season;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	
	

}
