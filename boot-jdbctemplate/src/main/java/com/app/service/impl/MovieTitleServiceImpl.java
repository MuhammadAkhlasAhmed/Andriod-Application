package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MoviesTitleDao;
import com.app.model.MoviesTitle;
import com.app.service.MoviesTitleService;

@Service
public class MovieTitleServiceImpl implements MoviesTitleService{
	
	@Autowired
	private MoviesTitleDao moviesTitleDao;  

	@Override
	public List<MoviesTitle> getMoviesAgainstId(List<Long> list) {
		return moviesTitleDao.getMovieAgainstId(list);
	}
}
