package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.IAppService;
@RequestMapping("api/v1/")
@RestController
public class AppController {

	@Autowired
	private IAppService iAppService;
	
	@PostMapping("movie/{name}")
	public int getMoviesCount(@PathVariable String name) {
		
		
		return iAppService.getMoviesCount(name);
		
		
	}
	
	
	
	
	
}
