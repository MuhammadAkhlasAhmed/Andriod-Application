package com.app.service;

import java.util.List;

import com.app.dto.FinalMovieDto;
import com.app.dto.ResponseDTO;

/**
 * The Interface GenreService.
 */
public interface GenreService {
	
	List<FinalMovieDto> getMovieGenreFromIMDB(String name);
	
	ResponseDTO getResponse(String name); 
}
