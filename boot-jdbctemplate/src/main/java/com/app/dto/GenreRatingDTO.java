package com.app.dto;

import java.io.Serializable;
import java.util.List;

public class GenreRatingDTO implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  The list of genres. */
	private List<String> genres;
	
//	/** The rating. */
//	public double rating;

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

//	/**
//	 * @return the rating
//	 */
//	public double getRating() {
//		return rating;
//	}
//
//	/**
//	 * @param rating the rating to set
//	 */
//	public void setRating(double rating) {
//		this.rating = rating;
//	}
}
