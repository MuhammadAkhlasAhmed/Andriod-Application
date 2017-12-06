package com.app.dto;

import java.math.BigInteger;

public class MovieFilterDTO {
	

	
	/** The runtime. */
	public int runtime;
	
	/** The revenue. */
	public BigInteger revenue;
	
	/** The voteAverage. */
	public double voteAverage;
	
	/** The voteCount. */
	public int voteCount;

	/** The popularity. */
	public double popularity;
	
	/** The budget. */
	public BigInteger budget;

	
	public MovieFilterDTO(int runtime,BigInteger revenue,double voteaverage,int votecount,double popularity,BigInteger budget)
	{

	this.runtime=runtime;
	this.revenue=revenue;
	this.voteAverage=voteaverage;
	this.voteCount=votecount;
	this.popularity=popularity;
	this.budget=budget;
	
	}
}
