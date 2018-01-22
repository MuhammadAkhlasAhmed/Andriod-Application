package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MoviesTitleDao;
import com.app.dto.GenreRatingDTO;
import com.app.model.MoviesTitle;
import com.app.service.ItemReviewService;
import com.app.service.MoviesTitleService;
import com.app.util.GenreUtils;

@Service
public class MovieTitleServiceImpl implements MoviesTitleService {

    @Autowired
    private MoviesTitleDao moviesTitleDao;

    @Autowired
    private ItemReviewService itemReviewService;
    
    @Override
    public List<MoviesTitle> getMoviesAgainstId(List<Long> list) {
        return moviesTitleDao.getMovieAgainstId(list);
    }

    @Override
    public int save(String movieName) {
        return moviesTitleDao.save(movieName);
    }

	@Override
	public boolean getMovieByName(String name) {
		return moviesTitleDao.getMovieByName(name);
	}

	@Override
	public void saveMovieNameAndItsReview(String movieName, String feature) {
		boolean count = getMovieByName(movieName);
        GenreRatingDTO genreRatingDTO = GenreUtils.getMovieGenreAndRating(movieName);
        List<String> listOfGenres = genreRatingDTO.getGenres();
		if(count == true) {
	        int row = itemReviewService.save(listOfGenres, feature);
		} else {
			int movieNameInsert = save(movieName);
			int row = itemReviewService.save(listOfGenres, feature);
		}
		

	}
	
}
