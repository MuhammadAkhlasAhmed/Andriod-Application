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
    	GenreRatingDTO genreRatingDTO = GenreUtils.getMovieGenreAndRating(name);
    	if(genreRatingDTO.getGenres() != null) {
    		List<String> listOfGenres = genreRatingDTO.getGenres();
            List<String> listOfGenresWithUnderScore = GenreUtils.replaceDashWithUnderScore(listOfGenres);
            List<String> list = itemReviewService.performCollaborativeFiltering(listOfGenresWithUnderScore);
            int fireBaseCount = fireBaseService.getMoviesCount(name);
            List<String> listOfOnlineAndDownloadLinks = webCrawlerService.getOnlineAndDownloadLinks(name);
            movieListDTO.setFirebaseMovieCount(fireBaseCount);
            movieListDTO.setListOfMovies(list);
            movieListDTO.setOnlineAndDownloadLinks(listOfOnlineAndDownloadLinks);
            return movieListDTO;
    	} 
    		return new MovieListDTO();
    }
}
