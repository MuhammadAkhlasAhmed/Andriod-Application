package com.app.dao;

import java.util.List;

import com.app.model.MoviesTitle;

public interface MoviesTitleDao {
	
	List<MoviesTitle> getMovieAgainstId(List<Long> list);
	int save(String movieName);
}
