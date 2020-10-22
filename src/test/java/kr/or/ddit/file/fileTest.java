package kr.or.ddit.file;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;

public class fileTest {
	
	private static final Logger logger = LoggerFactory.getLogger(fileTest.class);
	
	@Test
	public void getFilenameTest(){
		
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);
		/***Then***/
		assertEquals("sally.png", fileName);
		
	}
	
	@Test
	public void UUIDtest() {
		/***Given***/

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}",uuid);
		/***Then***/
	}
	
	@Test
	public void getExtensionTest() {
		/***Given***/
		String filename = "sally.png";

		/***When***/
		String ex = FileUploadUtil.getExtension(filename);
		/***Then***/
		assertEquals("png", ex);
	}
	
	@Test
	public void getExtensionFailTest() {
		/***Given***/
		String filename = "asdf";
		/***When***/
		String ex = FileUploadUtil.getExtension(filename);
		/***Then***/
		assertEquals("", ex);
		
	}

}
