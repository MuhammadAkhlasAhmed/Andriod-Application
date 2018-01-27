package com.app.service.impl;

import java.io.IOException;
import java.util.HashSet;
import org.apache.commons.logging.LogFactory;
import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.app.service.AppService;

/**
 * The Class AppServiceImpl.
 */
@Service
public class AppServiceImpl implements AppService{
	
	private HashSet<String> links;
	
	@Override
	public void getPageLinks(String URL) {
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
}
	}
