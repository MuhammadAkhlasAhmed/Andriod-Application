package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ItemReviewDao;
import com.app.model.ItemReview;
import com.app.service.ItemReviewService;

@Service
public class ItemReviewServiceImpl implements ItemReviewService{

	@Autowired
	private ItemReviewDao itemReviewDao; 
	
	@Override
	public List<ItemReview> getAllItemReviews() {
		return itemReviewDao.getAllItemReviews();
	}

	@Override
	public List<ItemReview> performCollaborativeFiltering(List<String> listOfGenres) {
		return itemReviewDao.getRowAgainsGenres(listOfGenres);
}
	}