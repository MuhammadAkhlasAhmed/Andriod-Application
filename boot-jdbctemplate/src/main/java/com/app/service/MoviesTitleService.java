package com.app.service;

import java.util.List;

import com.app.model.MoviesTitle;

public interface MoviesTitleService {

    List<MoviesTitle> getMoviesAgainstId(List<Long> list);

    int save(String movieName);
    
    boolean getMovieByName(String name);
    
    void saveMovieNameAndItsReview(String movieName, String feature);
}
