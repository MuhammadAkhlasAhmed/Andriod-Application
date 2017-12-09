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

import com.app.dto.GenreDTO;

/**
 * The Class GenreUtils.
 */
public class GenreUtils {
	
	public static String getGenre(List<String> listOfGenre) {
		List<String> list  = listOfGenre;
		return list.get(0).toString();
	}
	
	public static GenreDTO getMovieGenre(String name) {
		GenreDTO genreDTO = new GenreDTO();
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
					genreDTO.setGenres(list);
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
		return genreDTO;
	}
	
	public static String getOriginalMovieTitle(String name) {
		String movieTitle = "" ;
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
					movieTitle = obj1.getString("title");
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
		return movieTitle;
	}
	
}
