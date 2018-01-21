package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.AppService;


@RestController
@RequestMapping("api/v1/")
public class AppController {

	@Autowired
	private AppService AppService;
	
	@GetMapping("{str}")
	public void getPageLinks(@PathVariable String str) {
		
		AppService.getPageLinks(str);
		
	}
	
	
	
}
