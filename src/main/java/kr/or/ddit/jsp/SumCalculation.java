package kr.or.ddit.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SumCalculation
 */
@WebServlet("/SumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumCalculation1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int result = 0;
		
		for(int i=start;i<=end;i++) {
			result += i;
		}
		
		logger.debug(start + "부터 " + end +"까지의 합 : {}", result);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", result);
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
