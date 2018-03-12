package com.app.service;

import com.app.dto.MovieListDTO;

/**
 * The Interface GenreService.
 */
public interface GenreService {

	MovieListDTO getMovieGenres(String name);

}
