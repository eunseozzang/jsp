<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function(){
		// select box 옵션 바꿔주기
		$('#selectLang').val("${param.lang == null ? 'ko' : param.lang}");
		$('#selectLang').on('change',function(){
			lang = $('#selectLang').val()
// 			window.location = "http://localhost/jstl/jstl_fmt.jsp?lang=" + lang
			window.location = "jstl_fmt.jsp?lang=" + lang
		})
	})
</script>
</head>
<body>
   <%-- 1.jQuery 라이브러리 추가
       2.select box 생성
       3.option 3가지 언어 (en, ko, ja) 선택 가능
       4.페이지가 로딩될 때 사용자가 요청한 언어로 option tag가 선택되게끔..
       만약에 사용자가 언어 설정 파라미터를 보내지 않았을 경우 기본값으로 한국어가 설정되게끔 한다.
       5. option 태그가 바뀌면 자동으로 jstl_fmt.jsp로 재요청
    --%>

   <!-- locale 정보를 변경 -->
	<%
		String lang = request.getParameter("lang");
	%>
	<select name="selectLang" id="selectLang">
	    <option value="ko">한국어</option>
	    <option value="ja">日本語 </option>
	    <option value="en">ENGLISH</option>
	</select><br><br>
<%--    <% request.getParameter("lang"); // 아래와 동일 %>  --%>
     
   <fmt:setLocale value="${param.lang }"/>
   
   <!--  사용할 리소스 번들을 작성한다. (리소스번들명_로케일.properties) -->
   <% 
      request.setAttribute("userId", "brown");
   %>
   <fmt:bundle basename="kr.or.ddit.resource.message">
      <fmt:message key="GREETING" var="greeting"/>[${greeting }]<br>
      <fmt:message key="LOGIN_MSG">
         <fmt:param value="${userId }"/>
      </fmt:message>
   </fmt:bundle>
   
   <h3>setBundle</h3>
   <!--  set Bundle : 번들 메시지를 변수에 저장하여 message 태그에서 사용하게끔 하는 태그 -->
   <fmt:setBundle basename="kr.or.ddit.resource.message" var="msg"/>
   <fmt:message key="GREETING" bundle="${msg }"/>
</body>
</html>