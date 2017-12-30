package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ItemReview;

/**
 * The Interface ItemReviewRepository.
 */
@Repository
public interface ItemReviewRepository extends JpaRepository<ItemReview, Long>{

}
