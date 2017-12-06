package com.app.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.dto.MovieDTO;
import com.app.dto.MovieFilterDTO;
import com.app.model.Movie;

/**
 * The Class MovieUtils.
 */
public class MovieUtils {
	
	/**
	 * The Default Distance.
	 */
	static double distance=20;

	/**
	 * The Revenue of Average Movie.
	 */
	static BigInteger avgRevenue = BigInteger.valueOf(150567000);

	/**
	 * The Budget of Average Movie.
	 */
	static BigInteger avgBudget =  BigInteger.valueOf(100000000);
	
	/**
	 * The method that return MovieDTO.
	 */
	public static MovieDTO getMovie(List<Movie> listOfMovie) {
		
		MovieDTO movieDTO = new MovieDTO();
		List<Movie> list = listOfMovie;
		movieDTO.setName(list.get(0).getName());
		movieDTO.setRuntime(list.get(0).getRuntime());
		movieDTO.setRevenue(list.get(0).getRevenue());
		movieDTO.setVoteAverage(list.get(0).getVoteAverage());
		movieDTO.setVoteCount(list.get(0).getVoteCount());
		movieDTO.setPopularity(list.get(0).getPopularity());
		movieDTO.setBudget(list.get(0).getBudget());
		return movieDTO;
	}
	
	/**
	 * The method that return List of MovieDTO.
	 */
	public static List<MovieDTO> getListOfMovieDTO(List<Movie> listOfMovie){
	
		List<MovieDTO> listOfMovieDTO = new ArrayList<MovieDTO>();
		for (Movie movielist : listOfMovie) {
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setName(movielist.getName());
			movieDTO.setRuntime(movielist.getRuntime());
			movieDTO.setRevenue(movielist.getRevenue());
			movieDTO.setVoteAverage(movielist.getVoteAverage());
			movieDTO.setVoteCount(movielist.getVoteCount());
			movieDTO.setPopularity(movielist.getPopularity());
			movieDTO.setBudget(movielist.getBudget());
			listOfMovieDTO.add(movieDTO);
		}
		return listOfMovieDTO;
	}

	/**
	 * The method that perform filtering and calculate distance for each movie.
	 */
	public static void ContentBasedFiltering(List<MovieDTO> listOFMovieDTO, MovieDTO movieDTO){
	
		BigInteger revenue = movieDTO.getRevenue();
		double popularity = movieDTO.getPopularity();
		int runtime = movieDTO.getRuntime();
		double voteaverage = movieDTO.getVoteAverage();
		int votecount = movieDTO.getVoteCount();
		BigInteger budget = movieDTO.getBudget();
		HashMap<String,MovieFilterDTO> map = new HashMap<String, MovieFilterDTO>();
		HashMap<String,Double> moviesWithDistance = new HashMap<String,Double>();
		for(MovieDTO movie : listOFMovieDTO) {
			map.put(movie.getName(),new MovieFilterDTO(movie.getRuntime(), movie.getRevenue(), movie.getVoteAverage(),movie.getVoteCount(),movie.getPopularity(),movie.getBudget()));
		}
		map.forEach((k,v)->{
	if(v.voteAverage>voteaverage) {
		//150,567,000
	distance=distance+3;
	if(v.revenue.compareTo(avgRevenue)>0) {
		distance=distance+2;
		if(v.popularity>popularity) {
			distance=distance+0.5;
		if(v.runtime>runtime) {
			distance=distance-0.5;
	if(v.voteCount>votecount) {
		distance=distance+0.5;
	if(v.budget.compareTo(avgBudget)>0) {
		distance=distance-0.5;
	}else {
		distance=distance+0.5;
	}
	}else {
		distance=distance-0.5;	
	}
		}else {
			distance=distance+0.5;
		}
		}else {
			distance=distance-0.5;
		}
	}else {
		distance=distance-1;	
		if(v.popularity>popularity) {
			distance=distance+0.5;
			if(v.runtime>runtime) {
				distance=distance-0.5;
				if(v.voteCount>votecount) {
					distance=distance+0.5;
					if(v.budget.compareTo(avgBudget)>0) {
						distance=distance-0.5;
					}else {
						distance=distance+0.5;
					}
				}else {
					distance=distance-0.5;	
				}
			}else {
				distance=distance+0.5;
			}
		}else {
			distance=distance-0.5;
		}
	}
	}
	else {
		//if voteaverage is less then given movie voteaverage check all other field again
		distance=distance-3;
		if(v.revenue.compareTo(avgRevenue)>0) {
		distance=distance+2;
		if(v.popularity>popularity) {
			distance=distance+0.5;
			if(v.runtime>runtime) {
				distance=distance-0.5;
			if(v.voteCount>votecount) {
				distance=distance+0.5;
				if(v.budget.compareTo(avgBudget)>0) {
					distance=distance-0.5;
				}
				else {
					distance=distance+0.5;
				}
			}
			else {
				distance=distance-0.5;
			}
			}
			else {
				distance=distance+0.5;
			}
		}
		else {
			distance=distance-0.5;
		}
		}
		else {
			distance=distance-1;
			if(v.popularity>popularity) {
				distance=distance+0.5;
				if(v.runtime>runtime) {
					distance=distance+0.5;
					if(v.voteCount>votecount) {
						distance=distance+0.5;
						if(v.budget.compareTo(avgBudget)>0) {
							distance=distance-0.5;
						}
						else {
							distance=distance+0.5;
						}
					}
					else {
						distance=distance-0.5;
					}
				}
				else {
					distance=distance+0.5;
				}
			}
			else {
				distance=distance-0.5;
			}	
		}	
	}
	moviesWithDistance.put(k,distance);
	});
		moviesWithDistance.forEach((k,v)->{System.out.println("key "+k+" distance "+v);});
}
}
