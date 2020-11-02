package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.DbProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/ioc/property-placeholder.xml"})
public class PropertyPlaceholderTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyPlaceholderTest.class);
	
	@Resource(name="dbProperty")
	private DbProperty dbProperty;
	
	@Test
	public void propertyPlaceHolderTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertEquals("CES", dbProperty.getUser());
		assertEquals("java", dbProperty.getPass());
	}

}
