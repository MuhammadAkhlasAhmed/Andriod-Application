package com.app.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class GenreRatingDTO.
 */
public class GenreRatingDTO implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The list of genres.
     */
    private List<String> genres;

    /**
     * @return the genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
