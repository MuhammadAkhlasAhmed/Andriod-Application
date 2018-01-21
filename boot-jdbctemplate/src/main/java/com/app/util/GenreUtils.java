package com.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.dto.GenreRatingDTO;
import com.app.model.ItemReview;
import com.app.model.MoviesTitle;

/**
 * The Class GenreUtils.
 */
public class GenreUtils {

    /**
     * The keyAgainstHighestValueInMap.
     */
    public static int keyAgainstHighestValueInMap;

    /**
     * The map.
     */
    public static Map<Long, Integer> map;

    /**
     * The list.
     */
    public static List<Long> list;

    /**
     * The list of movie name.
     */
    public static List<String> listOfMovieName;

    /**
     * The count.
     */
    public static int count = 0;

    /**
     * The method that return movie genre and rating.
     */
    public static GenreRatingDTO getMovieGenreAndRating(String name) {
        GenreRatingDTO genreRatingDTO = new GenreRatingDTO();
        if (name.contains(" ")) {
            String movie_name = GenreUtils.replacewith20(name);
            try {
//				URL url = new URL("http://api.myapifilms.com/imdb/idIMDB?title=" + movie_name
//						+ "&&token=260407a8-26de-4f38-a226-17cfe4841e1d");
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

                        // this is only used for OMDB APIs
//						JSONObject myResponse = jsonObject.getJSONObject("data");
//						JSONArray array = myResponse.getJSONArray("movies");
//						JSONObject obj1 = array.getJSONObject(0);
//						JSONArray genresArray = obj1.getJSONArray("genres");
//						ArrayList<String> list = new ArrayList<String>();
//						for (int i = 0; i < genresArray.length(); i++) {
//							list.add(genresArray.get(i).toString());
//						}
//						genreRatingDTO.setGenres(list);

//						 String rating = obj1.getString("rating");
//						 genreRatingDTO.setRating(Double.parseDouble(rating)/2);

                        // this is only used for OMDB API
                        String genre = jsonObject.getString("Genre").toString();
                        String[] genreArray = genre.split(", ");
                        ArrayList<String> list = new ArrayList<String>();
                        for (int i = 0; i < genreArray.length; i++) {
                            list.add(genreArray[i].toString());
                        }
                        genreRatingDTO.setGenres(list);
                    } catch (Exception e) {
                        System.out.println("Not Found " + e);
                    }
                }
                conn.disconnect();
            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException " + e);
            } catch (IOException e) {
                System.out.println("IOException " + e);
            }
            return genreRatingDTO;
        } else {
            try {
//				URL url = new URL("http://api.myapifilms.com/imdb/idIMDB?title=" + name
//						+ "&&token=260407a8-26de-4f38-a226-17cfe4841e1d");
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

//						JSONObject myResponse = jsonObject.getJSONObject("data");
//						JSONArray array = myResponse.getJSONArray("movies");
//						JSONObject obj1 = array.getJSONObject(0);
//						JSONArray genresArray = obj1.getJSONArray("genres");
//						ArrayList<String> list = new ArrayList<String>();
//						for (int i = 0; i < genresArray.length(); i++) {
//							list.add(genresArray.get(i).toString());
//						}
//						genreRatingDTO.setGenres(list);

//						 String rating = obj1.getString("rating");
//						 genreRatingDTO.setRating(Double.parseDouble(rating)/2);

                        // this is only used for OMDB API
                        String genre = jsonObject.getString("Genre").toString();
                        String[] genreArray = genre.split(", ");
                        ArrayList<String> list = new ArrayList<String>();
                        for (int i = 0; i < genreArray.length; i++) {
                            list.add(genreArray[i].toString());
                        }
                        genreRatingDTO.setGenres(list);
                    } catch (Exception e) {
                        System.out.println("Not Found " + e);
                    }
                }
                conn.disconnect();
            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException " + e);
            } catch (IOException e) {
                System.out.println("IOException " + e);
            }
            return genreRatingDTO;
        }
    }

    /**
     * The method that remove spaces in string and add %20.
     */
    public static String replacewith20(String word) {
        String result = new String();
        for (int i = 0; i < word.length(); i++) {
            result += (word.charAt(i) == ' ' ? "%20" : word.charAt(i));
        }
        return result;
    }

    /**
     * The method that remove dash in string and replace it by undercore.
     */
    public static List<String> replaceDashWithUnderScore(List<String> listOfGenres) {
        List<String> listOfGenresWithUnderscore = new ArrayList<String>();
        for (String str : listOfGenres) {
            if (str.contains("-")) {
                String genres = str.replaceAll("-", "_");
                listOfGenresWithUnderscore.add(genres);
            } else {
                listOfGenresWithUnderscore.add(str);
            }
        }
        return listOfGenresWithUnderscore;
    }

    /**
     * The method that return a sorted hashmap in ascending order.
     */
    public static HashMap sortByValues(Map<Long, Integer> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    /**
     * The method that return key against highest value in map.
     */
    public static int getKeyAgainstValueInMap(Map<Integer, Integer> hashmap, int highestValueInMap) {
        for (int i = 1; i <= hashmap.size(); i++) {
            if (hashmap.get(i).equals(highestValueInMap)) {
                keyAgainstHighestValueInMap = i;
            }
        }
        return keyAgainstHighestValueInMap;
    }

    /**
     * The method that list of movie id.
     */
    public static List<Long> getKeyAgainstParticularValueInMap(Map<Long, Integer> sortedMapByValue, int mapValue) {
        list = new ArrayList<Long>();
        for (Entry<Long, Integer> entry : sortedMapByValue.entrySet()) {
            if (entry.getValue().equals(mapValue)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    /**
     * The method that return map.
     */
    public static Map<Long, Integer> getMapAgainstList(List<ItemReview> listOfItemReview) {
        map = new HashMap<Long, Integer>();
        listOfItemReview.forEach(x -> {
            if (x.getAction().equals("1")) {
                count++;
            }
            if (x.getAdventure().equals("1")) {
                count++;
            }
            if (x.getAnimation().equals("1")) {
                count++;
            }
            if (x.getChildrens().equals("1")) {
                count++;
            }
            if (x.getComedy().equals("1")) {
                count++;
            }
            if (x.getCrime().equals("1")) {
                count++;
            }
            if (x.getDocumentary().equals("1")) {
                count++;
            }
            if (x.getDrama().equals("1")) {
                count++;
            }
            if (x.getFantasy().equals("1")) {
                count++;
            }
            if (x.getFilmNoir().equals("1")) {
                count++;
            }
            if (x.getHorror().equals("1")) {
                count++;
            }
            if (x.getMusical().equals("1")) {
                count++;
            }
            if (x.getMystery().equals("1")) {
                count++;
            }
            if (x.getRomance().equals("1")) {
                count++;
            }
            if (x.getSciFi().equals("1")) {
                count++;
            }
            if (x.getThriller().equals("1")) {
                count++;
            }
            if (x.getWar().equals("1")) {
                count++;
            }
            if (x.getWestern().equals("1")) {
                count++;
            }
            map.put(x.getId(), count);
            count = 0;
        });
        return map;
    }

    /**
     * The method that list of movie name.
     */
    public static List<String> getListOfMovieName(List<MoviesTitle> list) {
        listOfMovieName = new ArrayList<String>();
        for (MoviesTitle movie : list) {
            listOfMovieName.add(movie.getTitle());
        }
        return listOfMovieName;
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
    
    /**
     * The method that return list of all genres.
     */
    public static List<String> getAllGenres() {
    	List <String> updatelist = new ArrayList<String> ();
    	updatelist.add("action");
    	updatelist.add("adventure");
    	updatelist.add("animation");
    	updatelist.add("childrens");
    	updatelist.add("comedy");
    	updatelist.add("crime");
    	updatelist.add("documentary");
    	updatelist.add("drama");
    	updatelist.add("fantasy");
    	updatelist.add("film_noir");
    	updatelist.add("horror");
    	updatelist.add("musical");
    	updatelist.add("mystery");
    	updatelist.add("romance");
    	updatelist.add("sci_fi");
    	updatelist.add("thriller");
    	updatelist.add("war");
    	updatelist.add("western");
    	updatelist.add("family");
    	updatelist.add("history");
    	updatelist.add("reality_tv");
    	updatelist.add("music");
    	return updatelist;
    }
    
    /**
     * The method that return list of all genres which does not exist in existing genres.
     */
    public static List<String> getAllGenres(List<String> allGenres, List<String> existingGenres){
    	List<String> listOfGenres = new ArrayList<String>();
    	List<String> list = new ArrayList<String>();
    	for(String a : existingGenres) {
    		list.add(a.toLowerCase());
    	}
    	listOfGenres = ListUtils.removeAll(allGenres, list);
    	return listOfGenres;
    }
}
