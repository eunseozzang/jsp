<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/el" method="post">
	
		<%
			String scope = request.getParameter("scope");
			String requestParam = "";
			String sessionParam = "";
			String applicationParam = "";
			
			if(scope != null){
				if(scope.equals("requestValue")){
					requestParam = "checked";
				} else if(scope.equals("sessionValue")){
					sessionParam = "checked";
				} else if(scope.equals("applicationValue")){
					applicationParam = "checked";
				} else {
					requestParam="checked";
				}
			}
		%>
		
		request	: <input type="radio" name="scope" value="requestValue" <%=requestParam %>/><br>
		session	: <input type="radio" name="scope" value="sessionValue" <%=sessionParam %>/><br>
		application	: <input type="radio" name="scope" value="applicationValue" <%=applicationParam %>/><br>
		<button type="submit">전송</button>
	</form>
	
	attr : ${attr } (page-> request-> session-> application)<br>
	requestScope : ${requestScope.attr }<br>
	sessionScope : ${sessionScope.attr }<br>
	applicationScope : ${applicationScope.attr }<br><br>
	
	scope parameter : <%=request.getParameter("scope") %><br>
	scope parameter : ${param.scope }<br><br>
	
	cookie : <%=request.getCookies() %><br>
	cookie : ${cookie.userid.value }<br>
	
	rangers.brown : ${rangers.brown }<br>
	rangers.sally : ${rangers.sally }<br>
	
	list[인덱스], list[인덱스].속성<br>
	rangersList[0] : ${rangersList[0].userid }<br>
	rangersList[1] : ${rangersList[1] }<br>
	
</body>
</html>