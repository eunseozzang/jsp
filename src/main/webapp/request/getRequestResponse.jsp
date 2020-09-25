<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GET</h1>
	userId 파라미터는 brown, sally 두개를 보내지만 getParameter를 호출하면 첫번째 파라미터 값을 반환한다.
	request.getParameter("userId") : <%=request.getParameter("userId") %> <br><br>
	String[] 을 반환
	request.getParameterValues("userId") : 
	<%
		String[] userIds = request.getParameterValues("userId");
		for(String userId : userIds){	%>
			<%=userId %>
	<%	} %> <br><br>
	
	parameterMap : Map<String,String[]>
	request.getParameterMap() : <%=request.getParameterMap() %><br><br>
	
	요청에 존재하는 파라미터 이름 출력하기
	<%
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();	%>
			<%=name %>
	<%	}
	%>
</body>
</html>