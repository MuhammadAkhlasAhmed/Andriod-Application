package com.app.model;

import java.io.Serializable;

public class MoviesTitle implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private Long movieId;

    /**
     * The title.
     */
    private String title;

    /**
     * @return the movieId
     */
    public Long getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}