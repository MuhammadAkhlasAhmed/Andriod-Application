package com.app.dto;

import java.io.Serializable;

/**
 * The Class WebCrawlerDTO.
 */
public class WebCrawlerDTO implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  The movieTitle. */
	private String movieTitle;
	
	/**  The movieYear. */
	private int movieYear;

	/**
	 * @return the movieTitle
	 */
	public String getMovieTitle() {
		return movieTitle;
	}

	/**
	 * @param movieTitle the movieTitle to set
	 */
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	/**
	 * @return the movieYear
	 */
	public int getMovieYear() {
		return movieYear;
	}

	/**
	 * @param movieYear the movieYear to set
	 */
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
}
