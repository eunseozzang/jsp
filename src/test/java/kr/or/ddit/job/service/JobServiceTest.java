package kr.or.ddit.job.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.job.model.JobVO;


public class JobServiceTest {
	
	@Test
	public void getAllMembertest() {
		/***Given***/
		JobServiceI jobService = new JobService();
		/***When***/
		List<JobVO> jobList = jobService.getAllJob();
		/***Then***/
		assertEquals(19, jobList.size());
	}

}
