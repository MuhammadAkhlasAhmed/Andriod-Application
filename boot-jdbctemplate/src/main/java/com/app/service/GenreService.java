package com.app.service;

import com.app.dto.GenreRatingDTO;

public interface GenreService {
	
	GenreRatingDTO getMovieGenres(String name);
	
	
}
