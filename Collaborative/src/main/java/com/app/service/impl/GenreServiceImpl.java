package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.GenreRatingDTO;
import com.app.dto.MovieListDTO;
import com.app.service.FireBaseService;
import com.app.service.GenreService;
import com.app.service.ItemReviewService;
import com.app.service.WebCrawlerService;
import com.app.util.GenreUtils;

/**
 * The Class GenreServiceImpl.
 */
@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private ItemReviewService itemReviewService;
    
    @Autowired
    private FireBaseService fireBaseService;
    
    @Autowired
    private WebCrawlerService webCrawlerService; 

    /**
     * The method that return movie genres.
     */
    @Override
    public MovieListDTO getMovieGenres(String name) {
    	MovieListDTO movieListDTO = new MovieListDTO();
    	// get list of genres against movie
    	GenreRatingDTO genreRatingDTO = GenreUtils.getMovieGenreAndRating(name);
    	if(genreRatingDTO.getGenres() != null) {
    		List<String> listOfGenres = genreRatingDTO.getGenres();
            
    		// remove irrelevant syntax like special characters.
    		List<String> listOfGenresWithUnderScore = GenreUtils.replaceDashWithUnderScore(listOfGenres);
            
    		// perform collaborative filtering and get list of movie name
    		List<String> list = itemReviewService.performCollaborativeFiltering(listOfGenresWithUnderScore);
            
    		// get firebase count
    		int fireBaseCount = fireBaseService.getMoviesCount(name);
            
    		// get online and download links using web crawler
    		List<String> listOfOnlineAndDownloadLinks = webCrawlerService.getOnlineAndDownloadLinks(name);
            
    		// set firebase count in movie list DTO object
    		movieListDTO.setFirebaseMovieCount(fireBaseCount);
    		
    		// set list of movies name in movie list DTO object
            movieListDTO.setListOfMovies(list);
            
            // set online and download links in movie list DTO object
            movieListDTO.setOnlineAndDownloadLinks(listOfOnlineAndDownloadLinks);
            return movieListDTO;
    	} 
    		return new MovieListDTO();
    }
}
