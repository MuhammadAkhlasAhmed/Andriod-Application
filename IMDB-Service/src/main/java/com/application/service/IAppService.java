package com.application.service;

import java.util.List;

import com.application.dto.MovieDTO;
import com.application.model.IMDBMovie;

public interface IAppService {

	public IMDBMovie getMovieFieldsFromIMDB(String name);
	
	public List<MovieDTO> getMovieGenresFromIMDB(String name);
}
