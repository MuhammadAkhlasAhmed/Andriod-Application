package com.application.util;

import java.util.ArrayList;
import java.util.List;

import com.application.dto.MovieDTO;
import com.application.model.Movie;

public class MovieUtils {
	
	public static List<MovieDTO> convertMovieToMovieDto(List<Movie> movieList){
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		for(Movie movie: movieList) {
			MovieDTO movieDto = new MovieDTO();
			movieDto.setName(movie.getName());
			list.add(movieDto);
		}
		return list;
	}
}