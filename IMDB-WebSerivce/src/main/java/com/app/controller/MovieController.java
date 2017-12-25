package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MovieDTO;
import com.app.dto.ResponseDTO;
import com.app.service.MovieService;

/**
 * The Class MovieController.
 */
@RestController
@RequestMapping("api/v1")
public class MovieController {
	
	@Autowired
	private MovieService movieService; 
	
	@GetMapping("/genre/{genreName}")
	public ResponseDTO<MovieDTO> getMovieByGenre(@PathVariable String genreName) {
		MovieDTO movieDTO = movieService.getMovieByGenre(genreName);
		if(movieDTO == null) {
			return new ResponseDTO<MovieDTO>("failure", movieDTO);
		}
		else {
			return new ResponseDTO<MovieDTO>("sucess", movieDTO);
		}
	}
	
}
