<%-- <%@page import="kr.or.ddit.job.model.JobVO"%> --%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	$(document).ready(function(){
		$("#memberList tr").on("click",function(){
			var userid = $(this).data("userid");

			console.log("userid : " + userid)

			document.location = "/member/getMember?userid=" + userid;
			})
	})
</script>


<body>
<div class="row">
tiles : memberListContent.jsp
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
      <table class="table table-striped">
         <tr>
            <th>사용자 아이디</th>
            <th>사용자 이름</th>
            <th>사용자 별명</th>
            <th>등록일시</th>
         </tr>
         <tbody id="memberList">
<!--          tr태그를 전부 날리지 않고 tbody안에 있는 내용만 날릴 때 주로 사용 -->
      <c:forEach items="${memberList }" var="member">
         <tr data-userid="${member.userid }">
<%--          	<input type="hidden" value="${member.userid }"/> --%>
            <td>${member.userid }</td>
            <td>${member.usernm }</td>
            <td>${member.alias }</td>
<!--             format : yyyy-MM-dd -->
            <td><fmt:formatDate value="${member.reg_dt }" pattern="YYYY-MM-dd"/></td>
            
         </tr>
      </c:forEach>
         </tbody>
   </table>
		</div>

		<a href="${cp }/member/memberRegistView" class="btn btn-default pull-right">사용자 등록</a>

<!-- 		현재 있는 페이지이면 if넣어서 active, 아니면 else  -->
		<div class="text-center">
			<ul class="pagination">
				<c:forEach var="i" begin="1" end="${pages }">
					<c:choose>
						<c:when test="${i == page }">
							<li class="active"><span>${i }</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${cp }/member/memberList?page=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
</body>
</html>
