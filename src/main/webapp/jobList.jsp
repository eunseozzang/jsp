<%@page import="kr.or.ddit.job.model.JobVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/layout/commonLib.jsp" %>
</head>

<body>
<%@ include file="/layout/header.jsp" %>
<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
		<%@ include file="/layout/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
<div class="col-sm-8 blog-main">
<h2 class="sub-header">Jobs</h2>
<div class="table-responsive">
<table class="table table-striped">
<tr>
<th>직업코드</th>
<th>직업명</th>
</tr>
 <%  
	List<JobVO> jobList = (List<JobVO>) request.getAttribute("jobList");
    if(jobList != null){
		for(int i=0;i<jobList.size();i++){   %>
      		<tr>
				<td><%=jobList.get(i).getJob_id() %></td>
				<td><%=jobList.get(i).getJob_title() %></td>
			</tr>
										<%} %>
				      <%
				         }
				      %>
   </table>
		</div>
		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
