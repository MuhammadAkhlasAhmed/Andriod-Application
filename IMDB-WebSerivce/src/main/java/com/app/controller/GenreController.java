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
import com.app.dto.ResponseDTO;
import com.app.service.GenreService;

/**
 * The Class GenreController.
 * @param <T>
 */
@RestController
@RequestMapping("api/v1")
public class GenreController<T> {
	
	@Autowired
	private GenreService genreService; 

	@GetMapping("/movie/{movieName}")
	public ResponseEntity<T> getMovieGenreFromIMDB(@PathVariable String movieName) {
		ResponseDTO responseDTO = genreService.getResponse(movieName) ;
			if(responseDTO.getError() != null && responseDTO.getResponse() != null) {
				return new ResponseEntity<T>((T) responseDTO, HttpStatus.NOT_FOUND);
			} else {
			List<FinalMovieDto> list = genreService.getMovieGenreFromIMDB(movieName);
			return (ResponseEntity<T>) new ResponseEntity<List<FinalMovieDto>>(list, HttpStatus.OK);
		}
	}

}
