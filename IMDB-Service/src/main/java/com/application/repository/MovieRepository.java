package com.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.model.Movie;

/**
 * The Interface MovieRepository.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query("select m from Movie m JOIN m.genres mg where mg.genre=?")
	public List<Movie> findByMovieByGenre(String Genre);
}
