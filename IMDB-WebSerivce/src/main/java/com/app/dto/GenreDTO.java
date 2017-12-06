package com.app.dto;

import java.util.List;

/**
 * The Class GenreDTO.
 */
public class GenreDTO {
	
	public GenreDTO() {
		
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
