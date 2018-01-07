package com.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.dto.GenreRatingDTO;

/**
 * The Class GenreUtils.
 */
public class GenreUtils {

	/** The method that return movie genre and rating. */
	public static GenreRatingDTO getMovieGenreAndRating(String name) {
		GenreRatingDTO genreRatingDTO = new GenreRatingDTO(); 
		if (name.contains(" ")) {
			String movie_name = GenreUtils.replacewith20(name);
			try {
				URL url = new URL("http://api.myapifilms.com/imdb/idIMDB?title=" + movie_name
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
						genreRatingDTO.setGenres(list);
						String rating = obj1.getString("rating");
						genreRatingDTO.setRating(Double.parseDouble(rating)/2);
					} catch (Exception e) {
						System.out.println("Not Found "+e);
					}
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException "+e);
			} catch (IOException e) {
				System.out.println("IOException "+e);
			}
			return genreRatingDTO;
		} else {
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
						genreRatingDTO.setGenres(list);
						String rating = obj1.getString("rating");
						genreRatingDTO.setRating(Double.parseDouble(rating)/2);
					} catch (Exception e) {
						System.out.println("Not Found "+e);
					}
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException " +e);
			} catch (IOException e) {
				System.out.println("IOException "+e);
			}
			return genreRatingDTO;
		}
	}

	/** The method that remove spaces in string and add %20. */
	public static String replacewith20(String word) {
		String result = new String();
		for (int i = 0; i < word.length(); i++) {
			result += (word.charAt(i) == ' ' ? "%20" : word.charAt(i));
		}
		return result;
	}
	
	/** The method that remove dash in string and replace it by undercore. */
	public static List<String> replaceDashWithUnderScore(List<String> listOfGenres){
		List<String> listOfGenresWithUnderscore = new ArrayList<String>();
		for(String str : listOfGenres) {
			if(str.contains("-")) {
				String genres = str.replaceAll("-", "_");
				listOfGenresWithUnderscore.add(genres);
			}
			else {
				listOfGenresWithUnderscore.add(str);
			}
		}
		return listOfGenresWithUnderscore;
	}

}
