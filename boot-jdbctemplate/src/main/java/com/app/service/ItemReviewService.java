package com.app.service;

import java.util.List;

import com.app.model.ItemReview;

public interface ItemReviewService {

    List<ItemReview> getAllItemReviews();

    List<String> performCollaborativeFiltering(List<String> listOfGenres);

//    int save(String action, String adventure, String animation, String childrens, String comedy,
//             String crime, String documentary, String drama, String fantasy, String filmNoir,
//             String horror, String musical, String mystery, String romance, String sciFic,
//             String thriller, String war, String western, String family, String history,
//             String realityTv, String music, String foreign);
}
