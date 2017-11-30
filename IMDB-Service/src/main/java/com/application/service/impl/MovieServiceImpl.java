package com.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Movie;
import com.application.repository.MovieRepository;
import com.application.service.IMovieService;

/**
 * The Class MovieServiceImpl.
 */
@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private MovieRepository movieRepository; 
	
	/**
	 * Method that return list all movies.
	 */
	public List<Movie> getAllMovies(){
		List<Movie> listOfMovies = movieRepository.findAll();
		return listOfMovies;
	}

	/**
	 * Method that return list of movies record against a particular genres
	 *  
	 */
	@Override
	public List<Movie> findByMovieByGenre(String genre) {
		return movieRepository.findByMovieByGenre(genre);
	}
}
