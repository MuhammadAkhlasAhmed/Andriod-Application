package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.GenreService;

@RestController
@RequestMapping("api/v1")
public class ItemReviewController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping("/{movieName}")
	public List<String> takeMovieNameThatUserSelect(@PathVariable String movieName) {
		return genreService.getMovieGenres(movieName);
	}

}
