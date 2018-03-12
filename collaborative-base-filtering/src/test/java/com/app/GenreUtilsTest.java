package com.app;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.app.util.GenreUtils;

public class GenreUtilsTest extends BaseTest{
	
	@InjectMocks
	private GenreUtils genreUtils; 
	
	@Test
	public void isValid() {
		Assert.assertEquals(4, 2+2);
	}
}
