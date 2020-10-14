<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/MulCalculation">
		param1 : <input type="text" name="param1" id="param1" value=""><br>
		param2 : <input type="text" name="param2" id="param2" value=""><br><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>