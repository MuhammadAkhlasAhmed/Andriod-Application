package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.MovieDTO;
import com.application.model.Movie;
import com.application.service.IMovieService;
import com.application.util.MovieUtils;

/**
 * the movie controller
 *
 */
@RestController
@RequestMapping("api/v1")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@GetMapping("/{genre}")
	public List<MovieDTO> findByMovieByGenre(@PathVariable String genre) {
		List<Movie> listOFMovie = movieService.findByMovieByGenre(genre);
		return MovieUtils.convertMovieToMovieDto(listOFMovie);
	}
	
//	@GetMapping("/{genre}")
//	public List<Movie> findByMovieByGenre(@PathVariable String genre) {
//		return movieService.findByMovieByGenre(genre);
//	}
	
	@GetMapping("/movie/{name}")
	public Movie getMovieByName(@PathVariable String name){
		return movieService.findMovieByName(name);
	}
	
}
