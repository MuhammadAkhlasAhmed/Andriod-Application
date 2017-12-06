package com.app.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.dto.MovieDTO;
import com.app.model.Movie;
import com.app.repository.MovieRepository;
import com.app.service.MovieService;
import com.app.util.MovieUtils;

/**
 * The Class MovieServiceImpl.
 */
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository; 
	
	@Override
	public MovieDTO getMovieByGenre(String genreName) {
		List<Movie> listOfMovies = movieRepository.findByMovieByGenre(genreName);
		return MovieUtils.getMovie(listOfMovies);
	}

	@Override
	public List<Movie> getListOfMovies(String genreName) {
		return movieRepository.findByMovieByGenre(genreName);
	}

	@Override
	public List<Movie> findMovie(int runtime, BigInteger revenue, double voteAverage, int voteCount, double popularity,
			BigInteger budget) {
		Pageable toptwenty = new PageRequest(0, 20);
		return movieRepository.findMovie(runtime, revenue, voteAverage, voteCount, popularity, budget, toptwenty);
	}
	
}