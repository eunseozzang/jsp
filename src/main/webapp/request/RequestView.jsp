<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){
		$('.radio').on('click',function(){
	 		type = $('input[name="type"]:checked').val();
	 		$('form').attr('method',type);
			})
		})
		
</script>
<style>

	label{
		display : inline-block;
		width : 80px;
	}
	
</style>
</head>
<body>
<%--
		파라미터 : client 서버로 요청을 보낼 때 추가적으로 보낸 값
		 	 ex) 로그인 요청시 : 사용자 id, 비밀번호
		파라미터는 내부적으로 Map<String, String[]> 객체로 관리를 한다
							파라미터이름, 파라미터 값들
							==> 동일한 이름의 파라미터를 여러갭 보낼 수 있다
		request 객체에 있는 파라미터 관련 메소드 4가지
		getParameter(String param) : param에 해당하는 파라미터 값을 조회한다
									 파라미터맵에서 첫번째 값을 반환
		String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다
		Map<String, String[]> getParameterMap() : request 객체에 생성된 파라미터 맵을 반환
		Enumeration<String> getParameterNames() : request 객체에 담긴 모든 파라미터 이름을 반환
 --%>
 
<%--한글 파라미터 설정
	get : server.xml  <Connector URIEncoding="utf-8">
	post : request.setCharacterEncoding("utf-8");
		   request.getParameter() 메서드를 호출하기 전에 설정을 해줘야 한다.
 --%> 
<%--action : 요청을 보낼 경로
	method : 요청방식 (form에서는 GET, POST 두가지만 가능하며 DEFAULT는 GET --%>
<form action="/jsp/request/RequestResponse.jsp">
	<label>user id : </label><input type="text" name="userId" value="어피치"><br>
	<label>user id : </label><input type="text" name="userId" value="튜브"><br>
	<label>password: </label><input type="password" name="userPw" value="pass1234"><br><br>
	<input type="radio" name="type" value="GET" class="radio"> GET
	<input type="radio" name="type" value="POST" class="radio"> POST<br>
	<input type="submit" value="전송" id="sendBtn"><br>
	GET POST 두가지를 선택할 수 있는 라디오 버튼을 만들어서
	FORM 전송시 사용자가 GET, POST 방식을 지정할 수 있도록 만들어보기 !
</form>
			
</body>
</html>