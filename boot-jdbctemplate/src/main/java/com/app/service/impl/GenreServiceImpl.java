package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.GenreRatingDTO;
import com.app.service.GenreService;
import com.app.service.ItemReviewService;
import com.app.util.GenreUtils;

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
			// get list of genres from OMDB Api
			List<String> listOfGenre = genreDTO.getGenres();
	    	List<String> listOfGenresReplaceBiographyToDocumentary = GenreUtils.replaceGenreBiographyToDocumentary(listOfGenre);
	    	List<String> listOfGenresReplaceAdultToRomance =  GenreUtils.replaceGenreAdultToRomance(listOfGenresReplaceBiographyToDocumentary);
	    	List<String> listOfGenresReplaceShortToHorror = GenreUtils.replaceGenreShortToHorror(listOfGenresReplaceAdultToRomance);
	    	List<String> listOfGenresReplaceTalkShowToSciFi = GenreUtils.replaceGenreTalkShowToSciFi(listOfGenresReplaceShortToHorror);
			String genre = GenreUtils.getGenre(listOfGenresReplaceTalkShowToSciFi);
			
			//get original movie name from OMDB Api	
			String originalMovieTile = GenreUtils.getOriginalMovieTitle(name);
			
			//get movie object by name from local database
			MovieDTO userGivenMovie = movieService.getMovieByName(originalMovieTile);
			
			//get movie against by genres
			MovieDTO movieDTO = movieService.getMovieByGenre(genre);
			
			//get all movie attributes
			int runtime = movieDTO.getRuntime();
			BigInteger revenue = movieDTO.getRevenue();
			double voteAverage = movieDTO.getVoteAverage();
			int voteCount = movieDTO.getVoteCount();
			double popularity = movieDTO.getPopularity();
			BigInteger budget = movieDTO.getBudget();
			
			//get top 20 movies by attributes from local database
			List<Movie> listOFMovies = movieService.findMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			
			//get top 300 movies by attributes from local database
			List<Movie> findAllMovie = movieService.findAllMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			
			//get list of top 20 movie name whose distance is close to user given movie
			List<String> moviesWithDistance =	MovieUtils.ContentBasedFiltering(MovieUtils.getListOfMovieDTO(listOFMovies), userGivenMovie);
			
			//get list of top 5 movie name from list of top 20 movie name
			List<String> listOfFirstFiveMovieName =	MovieUtils.getFirstFiveMovieName(moviesWithDistance);
			
			//get list of top 5 movie object from local db
			List<Movie>  listOfFirstFiveMovieObject = new ArrayList<Movie>();
			for (String eachMovie : listOfFirstFiveMovieName) {
				Movie movie = movieService.getMovieByItsName(eachMovie);
				listOfFirstFiveMovieObject.add(movie);
			}
			
			//get list of object which contain rating, tagline, movie name 
			List<FinalMovieDto> listOfFinalMovieDTO = AlgoUtils.WebMatrixFactorizationTechnique(MovieUtils.getListOfMovieRecordDTO(findAllMovie), listOfFirstFiveMovieObject);
//			List<FinalMovieNameDTO> listOfFinalMovieName = new ArrayList<FinalMovieNameDTO>();
//			for (FinalMovieDto finalMovieDto : listOfFinalMovieDTO) {
//				FinalMovieNameDTO finalMovieNameDTO = new FinalMovieNameDTO();
//				finalMovieNameDTO.setName(finalMovieDto.getName());
//				listOfFinalMovieName.add(finalMovieNameDTO);
//			}
			return listOfFinalMovieDTO;
		}
		else {
			List<FinalMovieDto> list = new ArrayList<FinalMovieDto>();
			return list;
		}
	}

	@Override
	public ResponseDTO getResponse(String name) {
		return ResponseUtils.getMovieGenre(name);
	}
}
