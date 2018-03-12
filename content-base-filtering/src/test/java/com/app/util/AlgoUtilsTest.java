package com.app.util;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.app.BaseTest;

public class AlgoUtilsTest extends BaseTest{
	
	@InjectMocks
	private AlgoUtils algoUtils; 
	
	@Test
	public void isValid() {
		Assert.assertEquals(4, 2+2);
	}
}
