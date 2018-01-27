package com.app.service;

import java.util.List;

/**
 * The Interface IAppService.
 */
public interface IAppService {
	
  List<String> getFireBaseMovies();
	
  int getMoviesCount(String Name);
}
