package com.app.util;

import java.util.List;

/**
 * The Class GenreUtils.
 */
public class GenreUtils {
	
	public static String getGenre(List<String> listOfGenre) {
		List<String> list  = listOfGenre;
		return list.get(0).toString();
	}
}
