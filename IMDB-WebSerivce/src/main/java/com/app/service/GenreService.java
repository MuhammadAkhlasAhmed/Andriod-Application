package com.app.service;

import java.util.List;

import com.app.dto.FinalMovieDto;

/**
 * The Interface GenreService.
 */
public interface GenreService {
	
	public List<FinalMovieDto> getMovieGenreFromIMDB(String name);
	
}
