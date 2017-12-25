package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FinalMovieDto;
import com.app.service.GenreService;

/**
 * The Class GenreController.
 */
@RestController
@RequestMapping("api/v1")
public class GenreController {
	
	@Autowired
	private GenreService genreService; 
	
//	@GetMapping("/movie/{movieName}")
//	public ResponseDTO<List<FinalMovieDto>> getMovieGenreFromIMDB(@PathVariable String movieName) {
//		List<FinalMovieDto> list = genreService.getMovieGenreFromIMDB(movieName);
//		if(list.isEmpty()) {
//			return new ResponseDTO<List<FinalMovieDto>>("failure", new ArrayList<FinalMovieDto>());
//		}
//		else {
//			return new ResponseDTO<List<FinalMovieDto>>("sucess", list);
//		}
//	}
	
	@GetMapping("/movie/{movieName}")
	public ResponseEntity<List<FinalMovieDto>> getMovieGenreFromIMDB(@PathVariable String movieName) {
		List<FinalMovieDto> list = genreService.getMovieGenreFromIMDB(movieName);
		if(list.isEmpty()) {
			return new ResponseEntity<List<FinalMovieDto>>(new ArrayList<FinalMovieDto>(), HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<FinalMovieDto>>(list, HttpStatus.OK);
		}
	}

}
