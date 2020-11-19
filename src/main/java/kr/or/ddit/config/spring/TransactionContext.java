package kr.or.ddit.config.spring;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//스프링 빈 중에 PlatformTransactionManager 타입의 빈이 있으면 해당 빈을 트랜잭션 매니저로 등록
//DataSourceContext에 등록된 dataSource 스프링빈을 주입받기위해 선언
//@Import({DataSourceContext.class})
@EnableTransactionManagement
@Configuration
public class TransactionContext {

	/*
		<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
			<property name="dataSource" ref="dataSource"/>
		</bean>
	 */
	
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		DataSourceTransactionManager transactionManager = 
				new DataSourceTransactionManager(dataSource);
		
		return transactionManager;
	}
	
	//<tx:advice id="txAdvisor"
	//<aop:config>
	//위 두 부분에 해당하는 java 설정은 없음
	//@Transactional 어노테이션을 트랜잭션으로 삼을 메서드나, 클래스 단위로 붙여준다
	//스프링빈을 <bean>엘레먼트를 통해 일일히 등록 => @Controller, @Service
	
}
