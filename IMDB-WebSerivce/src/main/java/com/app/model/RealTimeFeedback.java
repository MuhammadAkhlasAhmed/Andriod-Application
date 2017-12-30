package com.app.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the real_time_feedback database table.
 * 
 */
@Entity
@Table(name="real_time_feedback")
@NamedQuery(name="RealTimeFeedback.findAll", query="SELECT r FROM RealTimeFeedback r")
public class RealTimeFeedback implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/** The comments. */
	@Column(name="comments")
	private String comments;

	/** The name. */
	@Column(name="name")
	private String name;

	/** The rating. */
	@Column(name="rating")
	private String rating;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

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
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
}