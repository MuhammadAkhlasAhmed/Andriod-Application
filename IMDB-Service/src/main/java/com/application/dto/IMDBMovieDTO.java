package com.application.dto;

import java.util.List;

public class IMDBMovieDTO {

	public IMDBMovieDTO() {
		
	}
	
	/**  The list of genres. */
	private List<String> genres;
	
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
}
