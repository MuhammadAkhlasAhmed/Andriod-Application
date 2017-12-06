package com.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.GenreDTO;
import com.app.dto.MovieDTO;
import com.app.model.Movie;
import com.app.service.GenreService;
import com.app.service.MovieService;
import com.app.util.GenreUtils;
import com.app.util.MovieUtils;

/**
 * The Class GenreServiceImpl.
 */
@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private MovieService movieService;
	
	@SuppressWarnings("unused")
	@Override
	public List<MovieDTO> getMovieGenreFromIMDB(String name) {
		GenreDTO movieGenre = new GenreDTO();
		try {
			URL url = new URL("http://api.myapifilms.com/imdb/idIMDB?title=" + name
					+ "&&token=260407a8-26de-4f38-a226-17cfe4841e1d");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				try {
					JSONObject jsonObject = new JSONObject(output);
					JSONObject myResponse = jsonObject.getJSONObject("data");
					JSONArray array = myResponse.getJSONArray("movies");
					JSONObject obj1 = array.getJSONObject(0);
					JSONArray genresArray = obj1.getJSONArray("genres");
					ArrayList<String> list = new ArrayList<String>();
					for (int i = 0; i < genresArray.length(); i++) {
						list.add(genresArray.get(i).toString());
					}
					movieGenre.setGenres(list);
				} catch (Exception e) {
					System.out.println("Exception " + e);
				}
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException" + e);
		} catch (IOException e) {
			System.out.println("IOException" + e);
		}
		
		String string = "";
		
		if (movieGenre != null) {
			List<String> listOfGenre = movieGenre.getGenres();
			String genre = GenreUtils.getGenre(listOfGenre);
			MovieDTO movieDTO = movieService.getMovieByGenre(genre);
			int runtime = movieDTO.getRuntime();
			BigInteger revenue = movieDTO.getRevenue();
			double voteAverage = movieDTO.getVoteAverage();
			int voteCount = movieDTO.getVoteCount();
			double popularity = movieDTO.getPopularity();
			BigInteger budget = movieDTO.getBudget();
			List<Movie> listOFMovies = movieService.findMovie(runtime, revenue, voteAverage, voteCount, popularity, budget);
			MovieUtils.ContentBasedFiltering(MovieUtils.getListOfMovieDTO(listOFMovies), movieDTO);
			return MovieUtils.getListOfMovieDTO(listOFMovies);
			
		}
		else {
			List<MovieDTO> list = new ArrayList<MovieDTO>();
			return list;
		}
	}
}