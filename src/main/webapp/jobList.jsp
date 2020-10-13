<%@page import="kr.or.ddit.job.model.JobVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	List<JobVO> jobList = (List<JobVO>) request.getAttribute("jobList");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<%  
			if(jobList != null){
				for(int i=0;i<jobList.size();i++){	%>
		<tr>
			<td><%=jobList.get(i).getJob_id() %></td>
			<td><%=jobList.get(i).getJob_title() %></td>
		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
</body>
</html>