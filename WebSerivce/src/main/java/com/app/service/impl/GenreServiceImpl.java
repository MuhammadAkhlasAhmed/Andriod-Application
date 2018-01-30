package com.app.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.FinalMovieDto;
import com.app.dto.GenreDTO;
import com.app.dto.MovieDTO;
import com.app.dto.ResponseDTO;
import com.app.model.Movie;
import com.app.service.GenreService;
import com.app.service.MovieService;
import com.app.util.AlgoUtils;
import com.app.util.GenreUtils;
import com.app.util.MovieUtils;
import com.app.util.ResponseUtils;

/**
 * The Class GenreServiceImpl.
 */
@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private MovieService movieService;
	
	@Override
	public List<FinalMovieDto> getMovieGenreFromIMDB(String name) {
		//get genres from Api
		GenreDTO genreDTO = GenreUtils.getMovieGenre(name);
		if (genreDTO.getGenres() != null) {
			// get list of that genres
			List<String> listOfGenre = genreDTO.getGenres();
	    	List<String> listOfGenresReplaceBiographyToDocumentary = GenreUtils.replaceGenreBiographyToDocumentary(listOfGenre);
	    	List<String> listOfGenresReplaceAdultToRomance =  GenreUtils.replaceGenreAdultToRomance(listOfGenresReplaceBiographyToDocumentary);
	    	List<String> listOfGenresReplaceShortToHorror = GenreUtils.replaceGenreShortToHorror(listOfGenresReplaceAdultToRomance);
	    	List<String> listOfGenresReplaceTalkShowToSciFi = GenreUtils.replaceGenreTalkShowToSciFi(listOfGenresReplaceShortToHorror);
	    	String genre = GenreUtils.getGenre(listOfGenresReplaceTalkShowToSciFi);

	    	// get movie title from api
	    	String originalMovieTile = GenreUtils.getOriginalMovieTitle(name);
	    	
	    	// get user given movie Object from DB against name
			MovieDTO userGivenMovie = movieService.getMovieByName(originalMovieTile);
			
			// get movie Object from DB against genre 
			MovieDTO movieDTO = movieService.getMovieByGenre(genre);
			
			// get movie attributes
			int runtime = movieDTO.getRuntime();
			BigInteger revenue = movieDTO.getRevenue();
			double voteAverage = movieDTO.getVoteAverage();
			int voteCount = movieDTO.getVoteCount();
			double popularity = movieDTO.getPopularity();
			BigInteger budget = movieDTO.getBudget();
			
			// get list of top twenty movies object against attributes for content based filtering
			List<Movie> listOfTwentyMovies = movieService.findMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			
			// get list of three hundred movies object against attributes for web matrix factorization
			List<Movie> listOfThreeHundredMovies = movieService.findAllMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			
			// get list of all movies name whose distance is nearest to user given movie
			List<String> moviesWithDistance =	MovieUtils.ContentBasedFiltering(MovieUtils.getListOfMovieDTO(listOfTwentyMovies), userGivenMovie);
			
			// get list of five movies name whose distance is nearest to user given movie
			List<String> listOfFirstFiveMovieName =	MovieUtils.getFirstFiveMovieName(moviesWithDistance);
			
			List<Movie>  listOfFirstFiveMovieObject = new ArrayList<Movie>();
			
			// iterate list that contain movie name and save its object in another list
			for (String eachMovie : listOfFirstFiveMovieName) {
				Movie movie = movieService.getMovieByItsName(eachMovie);
				listOfFirstFiveMovieObject.add(movie);
				}
			
			// get list of movies to predict perform web matrix factorization
			List<FinalMovieDto> listOfFinalMovieDTO = AlgoUtils.WebMatrixFactorizationTechnique(MovieUtils.getListOfMovieRecordDTO(listOfThreeHundredMovies), listOfFirstFiveMovieObject);
			return listOfFinalMovieDTO;
		} else {
			List<FinalMovieDto> list = new ArrayList<FinalMovieDto>();
			return list;
		}
	}

	@Override
	public ResponseDTO getResponse(String name) {
		return ResponseUtils.getMovieGenre(name);
	}
}