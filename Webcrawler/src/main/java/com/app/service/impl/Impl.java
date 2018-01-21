package com.app.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.app.service.AppService;


@Service
public class Impl implements AppService{

	

	private HashSet<String> links;

	
	//links = new HashSet<String>();
	@Override
	public void getPageLinks(String URL) {
		
        //String str = "http://www.watchonlinemovies.com.pk/?s=" + " " +URL;
        
		//String str = "http://www.watchonlinemovies.com.pk/"+URL;
        
//		String str = "https://www.google.com/?s="+URL;
        
		
      //  links = new HashSet<String>();
        
        
        
        
        
        Document doc;
        try {
            String keyword = URL;
            doc = Jsoup //
                    .connect("https://www.bing.com/search?q='"+URL+"' watching links") //
                    .userAgent("Google") //
                    .get();

            String title = doc.title();
            System.out.println("title : " + title);

            Elements links = doc.select("a");
            for (Element link : links) {
                System.out.println("\nlink : " + link.absUrl("href"));
                System.out.println("text : " + link.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        if (!links.contains(str)) {
//            try {
//        
//              
//
//                Document document = Jsoup.connect(str).get();
//        
//                
//                
//                Document doc = Jsoup.parse(String.valueOf(document));
//                
//                
//                Elements linksOnPage = doc.select("div");
//                
//               // System.out.println(linksOnPage);
//                
//                String text = doc.body().text();
//                //String l1 = linksOnPage.attr("a");
//                
//                linksOnPage.forEach(x->{System.out.println(x.attr("a"));});
//                
//                
//                
//              //  System.out.println(l1);
//                
//                
//                
//                
//                
//                
//                //String absHref = linksOnPage.attr("abs:href");
//                
//                //Elements imports = document.select("[href]");
//                
//                
////                System.out.println("Your"+linksOnPage.text());
////                linksOnPage.forEach(k->{System.out.println(k.toString());});
////                
//                
//                
//                
//                //System.out.println(absHref);
//                
////                for (Element page : linksOnPage) {
////                    getPageLinks(page.attr("abs:href"));
////                    
////                }
//
//                
//            }
//            catch (IOException e) {
//                System.err.println("For '" + str + "': " + e.getMessage());
//            }
//          
//            
//            
//            
//        }
//    }

	

        


	
}}
