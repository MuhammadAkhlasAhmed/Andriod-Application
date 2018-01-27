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

/**
 * The Class ItemReviewServiceImpl.
 */
@Service
public class ItemReviewServiceImpl implements ItemReviewService {

    public static Map<Integer, Integer> hashmap;

    @Autowired
    private ItemReviewDao itemReviewDao;

    @Autowired
    private MoviesTitleService moviesTitleService;

    /**
     * The method that return all user reviews.
     */
    @Override
    public List<ItemReview> getAllItemReviews() {
        return itemReviewDao.getAllItemReviews();
    }

    /**
     * The method that perform collaborative filtering against user and item.
     */
    @Override
    public List<String> performCollaborativeFiltering(List<String> listOfGenres) {
    	List<String> listOfGenresReplaceBiographyToDocumentary = GenreUtils.replaceGenreBiographyToDocumentary(listOfGenres);
    	List<String> listOfGenresReplaceAdultToRomance =  GenreUtils.replaceGenreAdultToRomance(listOfGenresReplaceBiographyToDocumentary);
    	List<String> listOfGenresReplaceShortToHorror = GenreUtils.replaceGenreShortToHorror(listOfGenresReplaceAdultToRomance);
    	List<String> listOfGenresReplaceTalkShowToSciFi = GenreUtils.replaceGenreTalkShowToSciFi(listOfGenresReplaceShortToHorror);
    	List<ItemReview> listOfItemReview = itemReviewDao.getRowAgainstGenres(listOfGenresReplaceTalkShowToSciFi);
        Map<Long, Integer> map = GenreUtils.getMapAgainstList(listOfItemReview);
        Map<Long, Integer> sortedMapByValue = GenreUtils.sortByValues(map);
        hashmap = new HashMap<Integer, Integer>();
        int maxValueInMap = (Collections.max(sortedMapByValue.values()));
        for (int i = 1; i <= maxValueInMap; i++) {
            hashmap.put(i, Collections.frequency(sortedMapByValue.values(), i));
        	}
        int highestValueInMap = Collections.max(hashmap.values());
        int keyAgainstHighestValueInMap = GenreUtils.getKeyAgainstValueInMap(hashmap, highestValueInMap);
        List<Long> sortedList = GenreUtils.getKeyAgainstParticularValueInMap(sortedMapByValue, keyAgainstHighestValueInMap);
        List<MoviesTitle> list = moviesTitleService.getMoviesAgainstId(sortedList);
        List<String> listOfMovieName = GenreUtils.getListOfMovieName(list);
        return listOfMovieName;
    }

    /**
     * The method that save user reviews against item.
     */
	@Override
	public int save(List<String> listOfGenres, String feature) {
    	List<String> listOfGenresReplaceBiographyToDocumentary = GenreUtils.replaceGenreBiographyToDocumentary(listOfGenres);
    	List<String> listOfGenresReplaceAdultToRomance =  GenreUtils.replaceGenreAdultToRomance(listOfGenresReplaceBiographyToDocumentary);
    	List<String> listOfGenresReplaceShortToHorror = GenreUtils.replaceGenreShortToHorror(listOfGenresReplaceAdultToRomance);
    	List<String> listOfGenresReplaceTalkShowToSciFi = GenreUtils.replaceGenreTalkShowToSciFi(listOfGenresReplaceShortToHorror);
		List<String> listOfAllGenres = GenreUtils.getAllGenres();
		List<String> listOfGenresWithUnderScore = GenreUtils.replaceDashWithUnderScore(listOfGenresReplaceTalkShowToSciFi);
		List<String> list = GenreUtils.getAllGenres(listOfAllGenres, listOfGenresWithUnderScore);
    	return itemReviewDao.save(listOfGenresWithUnderScore, list, feature);
	}
}