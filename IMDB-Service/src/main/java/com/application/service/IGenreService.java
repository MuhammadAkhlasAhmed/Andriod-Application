package com.application.service;

import java.util.List;

import com.application.model.Genre;

public interface IGenreService {
	
	/**
	 * To get all genres record
	 *  
	 */
	public List<Genre> getAllGenres();
}
