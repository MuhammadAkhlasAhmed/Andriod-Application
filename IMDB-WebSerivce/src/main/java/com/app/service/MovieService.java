package com.app.service;

import java.math.BigInteger;
import java.util.List;

import com.app.dto.MovieDTO;
import com.app.model.Movie;

/**
 * The Interface MovieService.
 */
public interface MovieService {
	
	public MovieDTO getMovieByGenre(String genreName);

	public MovieDTO getMovieByName(String name);
	
	public Movie getMovieByItsName(String movieName);
	
	public List<Movie> getListOfMovies(String genreName);
	
	public List<Movie> findMovie(int runtime, BigInteger revenue, double voteAverage, int voteCount, double popularity, BigInteger budget);
	
	public List<Movie> findAllMovie(int runtime, BigInteger revenue, double voteAverage, int voteCount, double popularity, BigInteger budget);
}
