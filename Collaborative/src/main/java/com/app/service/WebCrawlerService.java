package com.app.service;

import java.util.List;

/**
 * The Interface WebCrawlerService.
 */
public interface WebCrawlerService {
	
	List<String> getOnlineAndDownloadLinks(String name);
}
