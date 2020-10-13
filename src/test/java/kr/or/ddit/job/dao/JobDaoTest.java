package kr.or.ddit.job.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.job.model.JobVO;


public class JobDaoTest {
	
	@Test
	public void getAllJobtest() {
		
		/***Given***/
		JobDao jobDao = new JobDao();
		/***When***/
		List<JobVO> jobList = jobDao.getAllJob();
		/***Then***/
		assertEquals(19, jobList.size());
	}
}
