package com.app.dao;

import java.util.List;

import com.app.model.ItemReview;

/**
 * The Interface ItemReviewController.
 */
public interface ItemReviewDao {

    List<ItemReview> getAllItemReviews();

    List<ItemReview> getRowAgainstGenres(List<String> list);

    int save(List<String> movieGenres, List<String> allGenres, String feature);
}
