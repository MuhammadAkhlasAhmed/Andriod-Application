package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Genre;

/**
 * The Interface GenreRepository.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
}
