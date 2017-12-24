package com.app.dto;

import java.math.BigInteger;

public class MovieRecordDTO {
	
	/** The runtime. */
	public int runtime;
	
	/** The revenue. */
	public BigInteger revenue;
	
	/** The voteCount. */
	public int voteCount;
	
	/** The rating. */
	public double rating;

	/** The popularity. */
	public double popularity;
	
	/** The budget. */
	public BigInteger budget;

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the runtime
	 */
	public int getRuntime() {
		return runtime;
	}

	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the revenue
	 */
	public BigInteger getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(BigInteger revenue) {
		this.revenue = revenue;
	}

	/**
	 * @return the voteCount
	 */
	public int getVoteCount() {
		return voteCount;
	}

	/**
	 * @param voteCount the voteCount to set
	 */
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	/**
	 * @return the popularity
	 */
	public double getPopularity() {
		return popularity;
	}

	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	/**
	 * @return the budget
	 */
	public BigInteger getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(BigInteger budget) {
		this.budget = budget;
	}
}
