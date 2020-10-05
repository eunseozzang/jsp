<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/SumCalculation">
		start : <input type="text" name="start" id="start" value=""><br>
		end : <input type="text" name="end" id="end" value=""><br><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>