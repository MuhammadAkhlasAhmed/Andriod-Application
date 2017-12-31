package com.app.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.FinalMovieDto;
import com.app.dto.FinalMovieNameDTO;
import com.app.dto.GenreDTO;
import com.app.dto.MovieDTO;
import com.app.model.Movie;
import com.app.service.GenreService;
import com.app.service.MovieService;
import com.app.util.AlgoUtils;
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
	public List<FinalMovieDto> getMovieGenreFromIMDB(String name) {
		GenreDTO genreDTO = GenreUtils.getMovieGenre(name);
		if (genreDTO.getGenres() != null) {
			List<String> listOfGenre = genreDTO.getGenres();
			String genre = GenreUtils.getGenre(listOfGenre);
			String originalMovieTile = GenreUtils.getOriginalMovieTitle(name);
			MovieDTO userGivenMovie = movieService.getMovieByName(originalMovieTile);
			MovieDTO movieDTO = movieService.getMovieByGenre(genre);
			int runtime = movieDTO.getRuntime();
			BigInteger revenue = movieDTO.getRevenue();
			double voteAverage = movieDTO.getVoteAverage();
			int voteCount = movieDTO.getVoteCount();
			double popularity = movieDTO.getPopularity();
			BigInteger budget = movieDTO.getBudget();
			List<Movie> listOFMovies = movieService.findMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			List<Movie> findAllMovie = movieService.findAllMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			List<String> moviesWithDistance =	MovieUtils.ContentBasedFiltering(MovieUtils.getListOfMovieDTO(listOFMovies), userGivenMovie);
			List<String> listOfFirstFiveMovieName =	MovieUtils.getFirstFiveMovieName(moviesWithDistance);
			List<Movie>  listOfFirstFiveMovieObject = new ArrayList<Movie>();
			for (String eachMovie : listOfFirstFiveMovieName) {
				Movie movie = movieService.getMovieByItsName(eachMovie);
				listOfFirstFiveMovieObject.add(movie);
			}
			List<FinalMovieDto> listOfFinalMovieDTO = AlgoUtils.WebMatrixFactorizationTechnique(MovieUtils.getListOfMovieRecordDTO(findAllMovie), listOfFirstFiveMovieObject);
			List<FinalMovieNameDTO> listOfFinalMovieName = new ArrayList<FinalMovieNameDTO>();
			for (FinalMovieDto finalMovieDto : listOfFinalMovieDTO) {
				FinalMovieNameDTO finalMovieNameDTO = new FinalMovieNameDTO();
				finalMovieNameDTO.setName(finalMovieDto.getName());
				listOfFinalMovieName.add(finalMovieNameDTO);
			}
			
			
			return AlgoUtils.WebMatrixFactorizationTechnique(MovieUtils.getListOfMovieRecordDTO(findAllMovie), listOfFirstFiveMovieObject);
		}
		else {
			List<FinalMovieDto> list = new ArrayList<FinalMovieDto>();
			return list;
		}
	}
}