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
    private ItemReviewService itemReviewService;

    @Override
    public List<String> getMovieGenres(String name) {
        GenreRatingDTO genreRatingDTO = GenreUtils.getMovieGenreAndRating(name);
        List<String> listOfGenres = genreRatingDTO.getGenres();
        List<String> listOfGenresWithUnderScore = GenreUtils.replaceDashWithUnderScore(listOfGenres);
        List<String> list = itemReviewService.performCollaborativeFiltering(listOfGenresWithUnderScore);
        return list;
    }
}
