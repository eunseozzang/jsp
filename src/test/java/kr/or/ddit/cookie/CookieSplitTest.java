package kr.or.ddit.cookie;

import static org.junit.Assert.assertEquals;

public class CookieSplitTest {
	
	public void getCookieValueTest() {
		
		/***Given***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When***/
		String cookieValue = cookieSplit.getCookieValue("USERNM");

		/***Then***/
		assertEquals("brown", cookieValue);
	}
}
