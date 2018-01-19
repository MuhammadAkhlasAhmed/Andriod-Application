package com.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import com.app.dto.ResponseDTO;

/**
 * The Class ResponseUtils.
 */
public class ResponseUtils {
	
	/** The Constant logger. */
	static final Logger logger = LoggerFactory.logger(GenreUtils.class);
	
	/** The method that return Response DTO. */
	public static ResponseDTO getMovieGenre(String name) {
		ResponseDTO responseDTO = new ResponseDTO();
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
						String response = jsonObject.getString("Response").toString();
						String error = jsonObject.getString("Error").toString();
						responseDTO.setResponse(response);
						responseDTO.setError(error);
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
			return responseDTO;
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
						String response = jsonObject.getString("Response").toString();
						String error = jsonObject.getString("Error").toString();
						responseDTO.setResponse(response);
						responseDTO.setError(error);
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
			return responseDTO;
		}
	}
}
