package kr.or.ddit.mvc.exception.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 컨트롤러마다 말고 하나의 클래스에서 처리하는 방법
@ControllerAdvice
public class ExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	@ExceptionHandler({ArithmeticException.class})
	public String handler() {
		logger.debug("ExceptionController.handler()");
		
		//에러를 처리할 화면
		return "exception/arithmetic";
	}	
}
