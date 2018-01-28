package com.app.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class MovieListDTO.
 */
public class MovieListDTO implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  The list of movies. */
	private List<String> listOfMovies;

	/**  The firebaseMovieCount. */
	private int firebaseMovieCount;
	
	/**  The onlineAndDownloadLinks. */
	private List<String> onlineAndDownloadLinks;

	/**
	 * @return the listOfMovies
	 */
	public List<String> getListOfMovies() {
		return listOfMovies;
	}

	/**
	 * @param listOfMovies the listOfMovies to set
	 */
	public void setListOfMovies(List<String> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	/**
	 * @return the firebaseMovieCount
	 */
	public int getFirebaseMovieCount() {
		return firebaseMovieCount;
	}

	/**
	 * @param firebaseMovieCount the firebaseMovieCount to set
	 */
	public void setFirebaseMovieCount(int firebaseMovieCount) {
		this.firebaseMovieCount = firebaseMovieCount;
	}

	/**
	 * @return the onlineAndDownloadLinks
	 */
	public List<String> getOnlineAndDownloadLinks() {
		return onlineAndDownloadLinks;
	}

	/**
	 * @param onlineAndDownloadLinks the onlineAndDownloadLinks to set
	 */
	public void setOnlineAndDownloadLinks(List<String> onlineAndDownloadLinks) {
		this.onlineAndDownloadLinks = onlineAndDownloadLinks;
	}
}
