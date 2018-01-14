package com.app.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ItemReviewDao;
import com.app.model.ItemReview;
import com.app.model.MoviesTitle;
import com.app.service.ItemReviewService;
import com.app.service.MoviesTitleService;
import com.app.util.GenreUtils;

@Service
public class ItemReviewServiceImpl implements ItemReviewService{

	/** The map. */
	public static Map<Integer, Integer> hashmap ;
	
	@Autowired
	private ItemReviewDao itemReviewDao; 
	
	@Autowired
	private MoviesTitleService moviesTitleService;
	
	@Override
	public List<ItemReview> getAllItemReviews() {
		return itemReviewDao.getAllItemReviews();
	}

	@Override
	public List<String> performCollaborativeFiltering(List<String> listOfGenres) {
		List<ItemReview> listOfItemReview = itemReviewDao.getRowAgainsGenres(listOfGenres);
		Map<Long, Integer> map = GenreUtils.getMapAgainstList(listOfItemReview);
		Map<Long, Integer> sortedMapByValue = GenreUtils.sortByValues(map);
		hashmap = new HashMap<Integer, Integer>();
		int maxValueInMap = (Collections.max(sortedMapByValue.values()));
		     for(int i=1; i<=maxValueInMap; i++) {
			hashmap.put(i, Collections.frequency(sortedMapByValue.values(), i));
		}
		int highestValueInMap = Collections.max(hashmap.values());
		int keyAgainstHighestValueInMap = GenreUtils.getKeyAgainstValueInMap(hashmap, highestValueInMap);
		List<Long> sortedList = GenreUtils.getKeyAgainstParticularValueInMap(sortedMapByValue, keyAgainstHighestValueInMap); 
		List<MoviesTitle> list = moviesTitleService.getMoviesAgainstId(sortedList);
		List<String> listOfMovieName = GenreUtils.getListOfMovieName(list);
		return listOfMovieName;
		}
	}