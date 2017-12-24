package com.app.dto;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * The Class MovieDTO.
 */
public class MovieDTO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The name. */
	private String name;
	
	/** The runtime. */
	private int runtime;
	
	/** The revenue. */
	private BigInteger revenue;
	
	/** The voteAverage. */
	private double voteAverage;
	
	/** The voteCount. */
	private int voteCount;

	/** The popularity. */
	private double popularity;
	
	/** The budget. */
	private BigInteger budget;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the voteAverage
	 */
	public double getVoteAverage() {
		return voteAverage;
	}

	/**
	 * @param voteAverage the voteAverage to set
	 */
	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
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
