package com.app.dao;

import java.util.List;

import com.app.model.ItemReview;

public interface ItemReviewDao {

    List<ItemReview> getAllItemReviews();

    List<ItemReview> getRowAgainsGenres(List<String> list);

//    int save(List<String> movieGenres, String action, String adventure, String animation, String childrens, String comedy,
//             String crime, String documentary, String drama, String fantasy, String filmNoir,
//             String horror, String musical, String mystery, String romance, String sciFic,
//             String thriller, String war, String western, String family, String history,
//             String realityTv, String music, String foreign_);
}
