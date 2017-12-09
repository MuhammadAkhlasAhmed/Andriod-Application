package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MovieDTO;
import com.app.service.GenreService;

/**
 * The Class GenreController.
 */
@RestController
@RequestMapping("api/v1")
public class GenreController {
	
	@Autowired
	private GenreService genreService; 
	
	@GetMapping("/movie/{movieName}")
	public List<MovieDTO> getMovieGenreFromIMDB(@PathVariable String movieName) {
		return genreService.getMovieGenreFromIMDB(movieName);
	}

}
