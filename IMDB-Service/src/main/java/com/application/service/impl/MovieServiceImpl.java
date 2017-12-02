package com.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.application.dto.IMDBMovieDTO;
import com.application.model.Movie;
import com.application.repository.MovieRepository;
import com.application.service.IAppService;
import com.application.service.IMovieService;

/**
 * The Class MovieServiceImpl.
 */
@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private MovieRepository movieRepository; 
	
	@Autowired
	private IAppService iAppService;
	
	/**
	 * Method that return list all movies.
	 */
	public List<Movie> getAllMovies(){
		List<Movie> listOfMovies = movieRepository.findAll();
		return listOfMovies;
	}

	/**
	 * Method that return list of movies record against a particular genres
	 *  
	 */
	@Override
	public List<Movie> findByMovieByGenre(String genre) {
		Pageable topTen = new PageRequest(0, 10);
		return movieRepository.findByMovieByGenre(genre,topTen);
	}

	@Override
	public Movie findMovieByName(String name) {
		if(movieRepository.findMovieByName(name) == null) {
			return new Movie();
		}
		else
		return movieRepository.findMovieByName(name);
	}

	@Override
	public IMDBMovieDTO getGenresAgainstMovie(String name) {
		Movie movie = findMovieByName(name);
		IMDBMovieDTO imdbMovieDTO = new IMDBMovieDTO();
	    ArrayList<String> list= new ArrayList<String>();
	    ArrayList<String> genresList = new ArrayList<String>();
	    for (String genres : genresList) {
	    	list.add(genres.toString());	
		}
	    imdbMovieDTO.setGenres(list);
	    return imdbMovieDTO;
	    }
	}
	
