package com.application.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.application.model.IMDBMovie;
import com.application.service.IAppService;

@Service
public class AppServiceImpl implements IAppService{
	  
	@SuppressWarnings("unused")
	@Override
	public IMDBMovie getMovieFieldsFromIMDB(String name) {
	    IMDBMovie movie = new IMDBMovie();
		try {
			URL url = new URL(
					"http://api.myapifilms.com/imdb/idIMDB?title="+name+"&&token=260407a8-26de-4f38-a226-17cfe4841e1d");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				try {
					JSONObject jsonObject = new JSONObject(output);
				    JSONObject myResponse = jsonObject.getJSONObject("data");
				    JSONArray array = myResponse.getJSONArray("movies");
				    JSONObject obj1 = array.getJSONObject(0);
				    String title = obj1.getString("title");
				    movie.setTitle(title);
				    String rating = obj1.getString("rating");
				    if(rating.contains(",")) {
				    	String replaceString = rating.replaceAll("," , "\\.");
					    movie.setRating(Double.parseDouble(replaceString));	
				    }
				    else {
				    	movie.setRating(Double.parseDouble(rating));
				    }
				    String runtime = obj1.getString("runtime");
				    String[] runtimeArray = runtime.split("\\s+");
				    movie.setRuntime(Double.parseDouble(runtimeArray[0]));
				    String str = obj1.getString("votes");
				    boolean a = str.contains(",");
				    if(a==true) {
				    	String[] abc = str.split(",");
					    String votes = "";
					    for(int i=0;i<abc.length;i++) {
					    votes += abc[i];
					    movie.setVotes(Double.parseDouble(votes));
				    }
				    }
					    else {
						    char[] chr = str.toCharArray();
						    int spaces = 0;
						    for(char ch: chr) {
						    	int i = ch;
						    	if(i==160 || i==32) {
						    	spaces++;	
						    	}
						    }
						    char[] chr1 = new char[str.length()-spaces];				    
						    int index = 0; 
						    for(char ch : chr) {
						    	int i = ch;
						    	System.out.println(i);
						    	if(i!= 160 && i!=32) {
						    		chr1[index] = ch;
						    		index++;
						    	}
						    }
						    String newString = "";
						    for(char ch: chr1) {
						    	newString+=ch;
						    }
						    movie.setVotes(Double.parseDouble(newString));
					    }
				    JSONArray genresArray = obj1.getJSONArray("genres");
				    ArrayList<String> list=new ArrayList<String>();
				    for(int i=0;i<genresArray.length();i++) {
				    list.add(genresArray.get(i).toString());
				    }
				    movie.setGenres(list);
				    movie.setMetascore(Double.parseDouble(obj1.getString("metascore")));
					}
					catch (Exception e) {
						System.out.println("Exception "+e);
					}
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException"+e);
		} catch (IOException e) {
			System.out.println("IOException"+e);
		}
		if(movie!=null) {
		return movie;
		}
		
		else {
			IMDBMovie ImdbMovie = new IMDBMovie();
			return ImdbMovie;
		}
	}
}
