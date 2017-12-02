package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.MovieDTO;
import com.application.model.IMDBMovie;
import com.application.service.IAppService;

@RestController
@RequestMapping("api/v1")
public class AppController {
	
	@Autowired
	private IAppService iAppService; 
	
	@GetMapping("/imdb/{name}")
	public IMDBMovie getMovieFieldsFromIMDB(@PathVariable String name) {
		return iAppService.getMovieFieldsFromIMDB(name);
	}
	
	@GetMapping("/movie/imdb/{name}")
	public List<MovieDTO> getGenresFromMovie(@PathVariable String name) {
 		return iAppService.getMovieGenresFromIMDB(name);
	}
}
