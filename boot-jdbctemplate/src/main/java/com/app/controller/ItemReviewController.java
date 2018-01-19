package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<String>> takeMovieNameThatUserSelect(@PathVariable String movieName) {
		List<String> list = genreService.getMovieGenres(movieName);
			if(list.isEmpty()) {
				return new ResponseEntity<List<String>>(list, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<String>>(list, HttpStatus.OK);
			}
	}
}
