package com.app.service;

import java.util.List;

import com.app.model.ItemReview;

public interface ItemReviewService {

    List<ItemReview> getAllItemReviews();

    List<String> performCollaborativeFiltering(List<String> listOfGenres);

    int save(List<String> listOfGenres, String feature);
}
