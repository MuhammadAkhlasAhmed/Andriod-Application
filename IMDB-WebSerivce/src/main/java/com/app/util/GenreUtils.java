package com.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.json.JSONObject;

import com.app.dto.GenreDTO;

/**
 * The Class GenreUtils.
 */
public class GenreUtils {
	
	/** The Constant logger. */
	static final Logger logger = LoggerFactory.logger(GenreUtils.class);

	/** The method that return movie genre. */
	public static String getGenre(List<String> listOfGenre) {
		List<String> list = listOfGenre;
		if (list.get(0).toString().equalsIgnoreCase("biography")) {
			return list.get(1).toString();
		} if (list.get(0).toString().equalsIgnoreCase("Talk-Show")) {
			return "science fiction";
		} else {
			return list.get(0).toString();
		}
	}

	/** The method that return genre DTO. */
	public static GenreDTO getMovieGenre(String name) {
		GenreDTO genreDTO = new GenreDTO();
		if (name.contains(" ")) {
			String movie_name = GenreUtils.replacewith20(name);
			try {
				URL url = new URL("http://www.omdbapi.com/?t=" + movie_name
						+ "&apikey=a4c03f2c");
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
						String genre = jsonObject.getString("Genre").toString();
						String[] genreArray = genre.split(", ");
						ArrayList<String> list = new ArrayList<String>();
						for(int i=0; i<genreArray.length; i++) {
							list.add(genreArray[i].toString());
						}
						genreDTO.setGenres(list);
					} catch (Exception e) {
						logger.info("Not Found");
					}
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				logger.info("MalformedURLException");
			} catch (IOException e) {
				logger.info("IOException");
			}
				return genreDTO;
		} else {
			try {
				URL url = new URL("http://www.omdbapi.com/?t=" + name
						+ "&apikey=a4c03f2c");
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
						String genre = jsonObject.getString("Genre").toString();
						String[] genreArray = genre.split(", ");
						ArrayList<String> list = new ArrayList<String>();
						for(int i=0; i<genreArray.length; i++) {
							list.add(genreArray[i].toString());
						}
						genreDTO.setGenres(list);
					} catch (Exception e) {
						logger.info("Not Found");
					}
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				logger.info("MalformedURLException");
			} catch (IOException e) {
				logger.info("IOException");
			}
			return genreDTO;
		}
	}

	/** The method that return original movie title. */
	public static String getOriginalMovieTitle(String name) {
		String movieTitle = "";
		if (name.contains(" ")) {
			String movie_name = GenreUtils.replacewith20(name);
			try {
				URL url = new URL("http://www.omdbapi.com/?t=" + movie_name
						+ "&apikey=a4c03f2c");
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
						movieTitle = jsonObject.getString("Title").toString();
					} catch (Exception e) {
						logger.info("Not Found");
					}
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				logger.info("MalformedURLException");
			} catch (IOException e) {
				logger.info("IOException");
			}
			return movieTitle;
		} else {
			try {
				URL url = new URL("http://www.omdbapi.com/?t=" + name
						+ "&apikey=a4c03f2c");
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
						movieTitle = jsonObject.getString("Title").toString();
					} catch (Exception e) {
						logger.info("Not Found");
					}
				}
				conn.disconnect();
			} catch (MalformedURLException e) {
				logger.info("MalformedURLException");
			} catch (IOException e) {
				logger.info("IOException");
			}
			return movieTitle;
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
	
    /**
     * The method that replace movie genre biography to documentary.
     */
    public static List<String> replaceGenreBiographyToDocumentary(List<String> listOfGenres){
    	List<String> listOfMovieGenres = new ArrayList<String>();    
    	for(String x : listOfGenres) {
    			if(x.equalsIgnoreCase("biography")) {
    				String genreDocumentary = x.replaceAll("Biography", "documentary");
    				listOfMovieGenres.add(genreDocumentary);
    			} else {
    				listOfMovieGenres.add(x);
    			}
    	   	}
    	return listOfMovieGenres;
    }
    
    /**
     * The method that replace movie genre adult to romance.
     */
    public static List<String> replaceGenreAdultToRomance(List<String> listOfGenres){
    	List<String> listOfMovieGenres = new ArrayList<String>();    
    	for(String x : listOfGenres) {
    			if(x.equalsIgnoreCase("adult")) {
    				String genreDocumentary = x.replaceAll("Adult", "romance");
    				listOfMovieGenres.add(genreDocumentary);
    			} else {
    				listOfMovieGenres.add(x);
    			}
    	   	}
    	return listOfMovieGenres;
    }
    
    /**
     * The method that replace movie genre short to horror.
     */
    public static List<String> replaceGenreShortToHorror(List<String> listOfGenres){
    	List<String> listOfMovieGenres = new ArrayList<String>();    
    	for(String x : listOfGenres) {
    			if(x.equalsIgnoreCase("short")) {
    				String genreDocumentary = x.replaceAll("Short", "horror");
    				listOfMovieGenres.add(genreDocumentary);
    			} else {
    				listOfMovieGenres.add(x);
    			}
    	   	}
    	return listOfMovieGenres;
    }

    /**
     * The method that replace movie genre talk show to sci fi.
     */
    public static List<String> replaceGenreTalkShowToSciFi(List<String> listOfGenres){
    	List<String> listOfMovieGenres = new ArrayList<String>();    
    	for(String x : listOfGenres) {
    			if(x.equalsIgnoreCase("Talk-Show")) {
    				String genreDocumentary = x.replaceAll("Talk-Show", "sci_fi");
    				listOfMovieGenres.add(genreDocumentary);
    			} else {
    				listOfMovieGenres.add(x);
    			}
    	   	}
    	return listOfMovieGenres;
    }
}
