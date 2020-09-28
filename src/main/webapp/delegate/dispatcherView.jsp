<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%List<String> rangers = (List<String>) request.getAttribute("rangers"); %>
</head>
<body>
	dispatcherView.jsp
	<table>
		<tr>
			<th>이름</th>
		</tr>
<!-- 		request 객체에 저장된 rangers 속성을 이용하여 tr,td 그리고ranger 이름 출력 -->
<%-- 		<% for(int i=0;i<rangers.size();i++){	%> --%>
<!-- 			<tr> -->
<%-- 				<td><%= rangers.get(i) %></td> --%>
<!-- 			</tr> -->
<%-- <%		} %> --%>

<!-- 		향상된 for문 -->
		<% for(String ranger : rangers){	%>
			<tr>
				<td><%= ranger %></td>
			</tr>
<%		} %>
	</table>
</body>
</html>