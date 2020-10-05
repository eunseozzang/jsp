<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
	List<String> list = (List<String>) request.getAttribute("list");
%>
</head>
<body>
	<%
		for(String name :list){
			out.print(name + "\t");	
		}
	%>
</body>
</html>