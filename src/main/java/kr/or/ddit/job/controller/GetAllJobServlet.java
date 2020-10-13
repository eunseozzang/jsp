package kr.or.ddit.job.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.job.model.JobVO;
import kr.or.ddit.job.service.JobService;
import kr.or.ddit.job.service.JobServiceI;

/**
 * Servlet implementation class GetAllJobServlet
 */
@WebServlet("/GetAllJobServlet")
public class GetAllJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobService service = new JobService();
		List<JobVO> jobList = service.getAllJob();
		
		request.setAttribute("jobList", jobList);
		System.out.println(jobList.get(1).getJob_id());
		request.getRequestDispatcher("jobList.jsp").forward(request, response);
	
	}

}
