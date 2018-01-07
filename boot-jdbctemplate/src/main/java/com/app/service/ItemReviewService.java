package com.app.service;

import java.util.List;

import com.app.model.ItemReview;

public interface ItemReviewService {
	
	List<ItemReview> getAllItemReviews();

	List<ItemReview> performCollaborativeFiltering(List<String> listOfGenres);
}
