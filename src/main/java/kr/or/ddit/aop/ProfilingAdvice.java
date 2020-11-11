package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);

	//pointCut 설정을 위한 의미 없는 메서드
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
		
	}
	
	// 어떤 메서드가 실행되기 전에 공통사항을 담는애
	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("beforeMethod : {}",joinPoint.getSignature().getName());
	}
	
	
	// 시간 측정하기
	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//메소드 실행전 공통 관심사항
		long start = System.currentTimeMillis();
		
		//메소드 실행
		Object ret = joinPoint.proceed(joinPoint.getArgs());
		
		//인자가 필요한 경우 이용해야한다.
		//핵심로직이 실행될 때 전달된 메소드 인자
		long end = System.currentTimeMillis();
		
		// 2. 메서드이름 3. 실행시간
		logger.debug("profiling: {} {} - {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName(),end-start + "ms");
		//메소드 실행 후 공통 관심사항
		return ret;
	}
}
