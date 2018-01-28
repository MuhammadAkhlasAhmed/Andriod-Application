package com.app.service;

import java.util.List;

/**
 * The Interface FireBaseService.
 */
public interface FireBaseService {
	
	List<String> getFireBaseMovies();
		
	int getMoviesCount(String Name);
}
