package com.app.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

import com.app.dto.MovieDTO;
import com.app.dto.MovieFilterDTO;
import com.app.dto.MovieRecordDTO;
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
	 * The method that return MovieDTO.
	 */
	public static MovieDTO MovieToMovieDTO(Movie movie) {
		
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setName(movie.getName());
		movieDTO.setRuntime(movie.getRuntime());
		movieDTO.setRevenue(movie.getRevenue());
		movieDTO.setVoteAverage(movie.getVoteAverage());
		movieDTO.setVoteCount(movie.getVoteCount());
		movieDTO.setPopularity(movie.getPopularity());
		movieDTO.setBudget(movie.getBudget());
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
	 * The method that return List of MovieRecordDTO.
	 */
	public static List<MovieRecordDTO> getListOfMovieRecordDTO(List<Movie> listOfMovie){
	
		List<MovieRecordDTO> listOfMovieRecordDTO = new ArrayList<MovieRecordDTO>();
		for (Movie movielist : listOfMovie) {
			MovieRecordDTO movieRecordDTO = new MovieRecordDTO();
			movieRecordDTO.setBudget(movielist.getBudget());
			movieRecordDTO.setPopularity(movielist.getPopularity());
			movieRecordDTO.setRating(movielist.getVoteAverage());
			movieRecordDTO.setRevenue(movielist.getRevenue());
			movieRecordDTO.setRuntime(movielist.getRuntime());
			movieRecordDTO.setVoteCount(movielist.getVoteCount());
			listOfMovieRecordDTO.add(movieRecordDTO);
		}
		return listOfMovieRecordDTO;
	}


	/**
	 * The method that perform filtering and calculate distance for each movie.
	 */
	public static List<String> ContentBasedFiltering(List<MovieDTO> listOFMovieDTO, MovieDTO movieDTO){
	
		double popularity = movieDTO.getPopularity();//875.581305
		int runtime = movieDTO.getRuntime();//91
		double voteaverage = movieDTO.getVoteAverage();//6.4
		int votecount = movieDTO.getVoteCount();//4571
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
		Set<Entry<String, Double>> set = moviesWithDistance.entrySet();
		List<Entry<String, Double>> list = new ArrayList<Entry<String,Double>>(set);
		Collections.sort(list, new Comparator<Map.Entry<String,Double>>() {
			public int compare(Map.Entry<String,Double> o1, Map.Entry<String,Double> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		List<String> moviesWithDist = new ArrayList<String>();
		Map<String, Double> aMap2 = new LinkedHashMap<String, Double>();
		for (Entry<String,Double> entry : list) {
			aMap2.put(entry.getKey(), entry.getValue());
		}
		
		aMap2.forEach((k,v)->{
			moviesWithDist.add(k);
			});
		return moviesWithDist;
	}
	
	/**
	 * The method that return list of first five movie name.
	 */
	public static List<String> getFirstFiveMovieName(List<String> moviesWithDistance){
		
		int counter = 0;
		List<String> listOfFirstFiveMovieName = new ArrayList<String>();
		for (String eachMovie : moviesWithDistance) {
			if(counter == 5) {
				break;
			}
		else {
			listOfFirstFiveMovieName.add(eachMovie);
		}
			counter++;
		}
		return listOfFirstFiveMovieName;
		
	}
}
