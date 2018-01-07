package com.app.service;

import java.util.List;

import com.app.dto.FinalMovieDto;

public interface GenreService {
	
	List<FinalMovieDto> getMovieGenreFromIMDB(String name);
}
