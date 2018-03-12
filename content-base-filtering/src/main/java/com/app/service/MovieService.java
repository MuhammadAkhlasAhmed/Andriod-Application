package com.app.service;

import java.math.BigInteger;
import java.util.List;

import com.app.dto.MovieDTO;
import com.app.model.Movie;

/**
 * The Interface MovieService.
 */
public interface MovieService {
	
	MovieDTO getMovieByGenre(String genreName);

	MovieDTO getMovieByName(String name);
	
	Movie getMovieByItsName(String movieName);
	
	List<Movie> getListOfMovies(String genreName);
	
	List<Movie> findMovie(int runtime, BigInteger revenue, double voteAverage, int voteCount, double popularity, BigInteger budget);
	
	List<Movie> findAllMovie(int runtime, BigInteger revenue, double voteAverage, int voteCount, double popularity, BigInteger budget);
}
