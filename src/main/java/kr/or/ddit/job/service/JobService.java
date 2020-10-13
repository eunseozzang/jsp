package kr.or.ddit.job.service;

import java.util.List;

import kr.or.ddit.job.dao.JobDao;
import kr.or.ddit.job.dao.JobDaoI;
import kr.or.ddit.job.model.JobVO;

public class JobService implements JobServiceI{

	@Override
	public List<JobVO> getAllJob() {
		JobDaoI jobDao = new JobDao();
		return jobDao.getAllJob();
	}

}
