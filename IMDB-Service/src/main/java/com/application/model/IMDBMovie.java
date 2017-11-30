package com.application.model;

import java.util.List;

public class IMDBMovie {
	
	private Double rating;
	private Double runtime;
	private Double votes;
	private List<String> genres;
	private Double metascore;
	
	public IMDBMovie(){		
	
	}

	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * @return the runtime
	 */
	public Double getRuntime() {
		return runtime;
	}

	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(Double runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the votes
	 */
	public Double getVotes() {
		return votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(Double votes) {
		this.votes = votes;
	}

	/**
	 * @return the genres
	 */
	public List<String> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	/**
	 * @return the metascore
	 */
	public Double getMetascore() {
		return metascore;
	}

	/**
	 * @param metascore the metascore to set
	 */
	public void setMetascore(Double metascore) {
		this.metascore = metascore;
	}
}
