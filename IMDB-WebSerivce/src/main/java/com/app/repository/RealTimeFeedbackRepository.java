package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.RealTimeFeedback;

/**
 * The Interface RealTimeFeedbackRepository.
 */
@Repository
public interface RealTimeFeedbackRepository extends JpaRepository<RealTimeFeedback, Long>{

}
