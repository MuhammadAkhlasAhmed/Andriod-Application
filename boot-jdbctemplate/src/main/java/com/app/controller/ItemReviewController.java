package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MovieListDTO;
import com.app.service.GenreService;
import com.app.service.MoviesTitleService;

/**
 * The Class ItemReviewController.
 */
@RestController
@RequestMapping("api/v1")
public class ItemReviewController {
    @Autowired
    private GenreService genreService;

    @Autowired
    private MoviesTitleService movieTitleService;

    @GetMapping("/{movieName}")
    public ResponseEntity<MovieListDTO> takeMovieNameThatUserSelect(@PathVariable String movieName) {
    	MovieListDTO movieListDTO = genreService.getMovieGenres(movieName);
        if (movieListDTO != null) {
            return new ResponseEntity<MovieListDTO>(movieListDTO, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<MovieListDTO>(movieListDTO, HttpStatus.OK);
        }
    }

	@GetMapping("/{movieName}/{feature}")
	public String save(@PathVariable String movieName, @PathVariable String feature) {
		movieTitleService.saveMovieNameAndItsReview(movieName, feature);
		return "feedback Sucessfully inserted";
	}
}
