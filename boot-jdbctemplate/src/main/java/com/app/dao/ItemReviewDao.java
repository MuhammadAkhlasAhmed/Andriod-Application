package com.app.dao;

import java.util.List;

import com.app.model.ItemReview;

public interface ItemReviewDao {

    List<ItemReview> getAllItemReviews();

    List<ItemReview> getRowAgainsGenres(List<String> list);

    int save(List<String> movieGenres, List<String> allGenres, String feature);
}
