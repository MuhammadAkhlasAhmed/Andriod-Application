package com.app.dao;

import java.util.List;

import com.app.model.MoviesTitle;

/**
 * The Interface MoviesTitleDao.
 */
public interface MoviesTitleDao {

    List<MoviesTitle> getMovieAgainstId(List<Long> list);

    int save(String movieName);
    
    boolean getMovieByName(String name);
}
