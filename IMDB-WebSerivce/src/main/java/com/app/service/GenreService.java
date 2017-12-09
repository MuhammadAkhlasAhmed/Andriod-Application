package com.app.service;

import java.util.List;

import com.app.dto.MovieDTO;

/**
 * The Interface GenreService.
 */
public interface GenreService {
	
	public List<MovieDTO> getMovieGenreFromIMDB(String name);
	
}
