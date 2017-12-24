package com.app.dto;

import java.math.BigInteger;

public class UserGivenMovieDTO {
	
	/** The runtime. */
	public int runtime;
	
	/** The revenue. */
	public BigInteger revenue;
	
	/** The voteCount. */
	public int voteCount;
	
	/** The budget. */
	public BigInteger budget;
	
	/** The fireBaseMovieCount. */
	public int fireBaseMovieCount;

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

	/**
	 * @return the fireBaseMovieCount
	 */
	public int getFireBaseMovieCount() {
		return fireBaseMovieCount;
	}

	/**
	 * @param fireBaseMovieCount the fireBaseMovieCount to set
	 */
	public void setFireBaseMovieCount(int fireBaseMovieCount) {
		this.fireBaseMovieCount = fireBaseMovieCount;
	}
}
