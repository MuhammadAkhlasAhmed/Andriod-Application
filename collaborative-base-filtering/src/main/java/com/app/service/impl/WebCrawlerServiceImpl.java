package com.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.app.dto.WebCrawlerDTO;
import com.app.service.WebCrawlerService;
import com.app.util.GenreUtils;

/**
 * The Class WebCrawlerServiceImpl.
 */
@Service
public class WebCrawlerServiceImpl implements WebCrawlerService{

	public static List<String> listOfOnlineAndDownloadLinks;
	private HashSet<String> links;
	
	@Override
	public List<String> getOnlineAndDownloadLinks(String name) {
		listOfOnlineAndDownloadLinks = new ArrayList<String>();
		WebCrawlerDTO getMovieNameAndYear = GenreUtils.getMovieNameAndYear(name);
		String movieTitle = getMovieNameAndYear.getMovieTitle();
		int movieYear = getMovieNameAndYear.getMovieYear();
		if(name.contains(" ")) {
			String movieNameForDownload = GenreUtils.replaceSpaceToDash(movieTitle).toLowerCase();
			String downloadLink = "https://yts.am/movie/"+movieNameForDownload+"-"+movieYear+"";
			String onlineFMovie = "https://fmovies.pe/watch/"+movieNameForDownload+"-hd-720p.html";
			String movieNameForYoutube = GenreUtils.replaceSpaceToPlus(name);
			String youtubeLinkOnlineWatch = "https://www.youtube.com/results?search_query="+movieNameForYoutube.toLowerCase()+"+online+movie";
	        listOfOnlineAndDownloadLinks.add(0,downloadLink);
	        listOfOnlineAndDownloadLinks.add(1,onlineFMovie);
	        listOfOnlineAndDownloadLinks.add(2,youtubeLinkOnlineWatch);
		} else {
			String downloadLink = "https://yts.am/movie/"+name.toLowerCase()+"-"+movieYear+"";
			String onlineFMovie = "https://fmovies.pe/watch/"+name.toLowerCase()+"-hd-720p.html";
			String youtubeLinkOnlineWatch = "https://www.youtube.com/results?search_query="+name.toLowerCase()+"+online+movie";
	        listOfOnlineAndDownloadLinks.add(0,downloadLink);
	        listOfOnlineAndDownloadLinks.add(1,onlineFMovie);
	        listOfOnlineAndDownloadLinks.add(2,youtubeLinkOnlineWatch);
		}
		Document doc;
        try {
        	int x=3;
             doc = Jsoup //
                     .connect("https://www.bing.com/search?q='"+name+"' watching links") //
                     .userAgent("Google") //
                     .get();
             String title = doc.title();
             Elements links = doc.select("a");
             for (Element link : links ) {
             	if(link.absUrl("href").contains(name)) {
             		listOfOnlineAndDownloadLinks.add(x,link.absUrl("href"));            	
                 	x++;
             	}
             }
        }        
         catch (IOException e) {
             e.printStackTrace();
         }
        	return listOfOnlineAndDownloadLinks;
	}
}
