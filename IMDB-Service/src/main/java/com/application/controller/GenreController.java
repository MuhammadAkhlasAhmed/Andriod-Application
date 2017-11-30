package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Genre;
import com.application.service.IGenreService;

/**
 * the genre controller
 *
 */
@RestController
@RequestMapping("api/v1/genres")
public class GenreController {
	
	@Autowired
	private IGenreService genreService;
	
	@GetMapping
	public List<Genre> getAllGenres(){
		return genreService.getAllGenres();
	}
}
