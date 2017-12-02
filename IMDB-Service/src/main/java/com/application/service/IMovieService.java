package com.application.service;

import java.util.List;

import com.application.dto.IMDBMovieDTO;
import com.application.model.Movie;

public interface IMovieService {
	
	/**
	 * To get all movies record
	 *  
	 */
	public List<Movie> getAllMovies();
	
	/**
	 * To get all movies record against a particular genres
	 *  
	 */
	public List<Movie> findByMovieByGenre(String genre);

	/**
	 * To get movie by movie name
	 *  
	 */
	public Movie findMovieByName(String name);
	
	public IMDBMovieDTO getGenresAgainstMovie(String name);
}


