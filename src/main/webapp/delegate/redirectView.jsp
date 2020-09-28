<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	redirectView.jsp
	
	<table>
		<tr>
			<th>이름</th>
		</tr>
<!-- 		향상된 for문 -->
		<% List<String> rangers = (List<String>) request.getAttribute("rangers");
			for(String ranger : rangers){	%>
			<tr>
				<td><%= ranger %></td>
			</tr>
<%		} %>
	</table>
</body>
</html>