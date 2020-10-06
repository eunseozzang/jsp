package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {
	
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);
	//cookieStrim 문자열 변수에 담긴 값은
	// 쿠키이름1=쿠키값1; 쿠키이름2=쿠키값2; ... 형태이다..
	// 구성된 쿠키 이름과 값은 상황에 따라 변경될 수 있다.
	
	private String cookieString = "USERNM=brown; REMEMBERME=Y; TEST=T";
	
	public static void main(String[] args) {
		
		CookieSplit cookieSplit = new CookieSplit();
		logger.debug("USERNM : " + cookieSplit.getCookieValue("USERNM")); // 기대되는 값 brown
		logger.debug("TEST : " + cookieSplit.getCookieValue("TEST")); // 기대되는 값 T
		logger.debug("XXX : " + cookieSplit.getCookieValue("XXX")); // 기대되는 값 ""
	}
	
	public String getCookieValue(String cookieName) {

		String[] cookie = cookieString.split("; ");
		String[] cookie2;
		String value = "";
		for(int i=0;i<cookie.length;i++) {
			cookie2 = cookie[i].split("=");
			if(cookie2[0].equals(cookieName)) {
				value = cookie2[1];
			}
		}
		return value;
	}
}
