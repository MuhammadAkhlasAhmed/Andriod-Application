package com.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Movie;

/**
 * The Interface MovieRepository.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query("select m from Movie m JOIN m.genres mg where mg.genre=?")
	public List<Movie> findByMovieByGenre(String name);
	
	@Transactional
	@Query("select m from Movie m where m.runtime=? or m.revenue=? or m.voteAverage=? or m.voteCount=? or m.popularity=? or m.budget=?")
	public List<Movie> findMovie(int runtime, BigInteger revenue, double voteAverage, int voteCount, double popularity, BigInteger budget, Pageable pageable);

	public Movie findMovieByName(String name);
	
}
