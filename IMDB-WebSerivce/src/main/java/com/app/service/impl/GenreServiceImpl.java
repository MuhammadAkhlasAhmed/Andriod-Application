package com.app.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.GenreDTO;
import com.app.dto.MovieDTO;
import com.app.model.Movie;
import com.app.service.GenreService;
import com.app.service.MovieService;
import com.app.util.GenreUtils;
import com.app.util.MovieUtils;

/**
 * The Class GenreServiceImpl.
 */
@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private MovieService movieService;
	
	@Override
	public List<MovieDTO> getMovieGenreFromIMDB(String name) {
		GenreDTO genreDTO = GenreUtils.getMovieGenre(name);
		if (genreDTO != null) {
			List<String> listOfGenre = genreDTO.getGenres();
			String genre = GenreUtils.getGenre(listOfGenre);
			//Movie movieDTO = movieService.getMovieByName(name);
			MovieDTO movieDTO = movieService.getMovieByGenre(genre);
			int runtime = movieDTO.getRuntime();
			BigInteger revenue = movieDTO.getRevenue();
			double voteAverage = movieDTO.getVoteAverage();
			int voteCount = movieDTO.getVoteCount();
			double popularity = movieDTO.getPopularity();
			BigInteger budget = movieDTO.getBudget();
			List<Movie> listOFMovies = movieService.findMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			MovieUtils.ContentBasedFiltering(MovieUtils.getListOfMovieDTO(listOFMovies), movieDTO);
			return MovieUtils.getListOfMovieDTO(listOFMovies);
		}
		else {
			List<MovieDTO> list = new ArrayList<MovieDTO>();
			return list;
		}
	}
}