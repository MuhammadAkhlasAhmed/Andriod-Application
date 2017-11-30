package com.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Genre;
import com.application.repository.GenreRepository;
import com.application.service.IGenreService;

/**
 * The Class GenreServiceImpl.
 */
@Service
public class GenreServiceImpl implements IGenreService{
	
	@Autowired
	private GenreRepository genreRepository;
	
	/**
	 * Method that return list all genres.
	 */
	public List<Genre> getAllGenres(){
		List<Genre> listOfGenres = genreRepository.findAll();
		return listOfGenres;
	}
}
