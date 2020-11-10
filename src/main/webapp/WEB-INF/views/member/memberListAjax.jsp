<%-- <%@page import="kr.or.ddit.job.model.JobVO"%> --%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

	//해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	$(document).ready(function(){
		// ajax call 을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다
		
// 		memberListAjax(1);
		memberListAjaxHTML(1);
		
		$("#memberList").on("click","tr",function(){
			var userid = $(this).data("userid");
// 			memberAjax(userid);
			document.location = "/member/memberAjaxPage?userid=" + userid;
		})
	})
	
// 	function memberListAjax(p){

// 		$.ajax({
// 				url : "/member/memberListAjax",
// 				data : {page : p,
// 						pageSize : 5
// 					},

// 					// data : "page=1&pageSize=5"
// 					// JSON.stringify({page : 1, pageSize : 5})
// 					// 이 방법은 Controller에서 @RequestBody를 작성해야한다.
					
// 				method : "get",
// 				success : function(data){

// 					var i=0;
					
// 					//memberList tbody 영역에 들어갈 html 문자열 생성
// 					var html = "";
// 					var html2 = "";
					
// 					for(var i=0; i < data.memberList.length;i++){

// 						var member = data.memberList[i]
						
// 						html += "<tr data-userid='"+ data.memberList[i].userid + "'>";
// 						html += "<td>"+ member.userid +"</td>";
// 						html += "<td>"+ member.usernm +"</td>";
// 						html += "<td>"+ member.alias  +"</td>";
// 						html += "<td>"+ member.fmt_reg_dt +"</td></tr>";
// 					}
					
// 					$('#memberList').html(html);

// 					// 페이지네비게이션 html 문자열 동적 생성

// 					for(var i=1; i < data.pages+1;i++){

// 						if(data.pageVO.page == i){
// 							html2 += "<li class=\"active\"><span>"+i+"</span></li>";

// 						} else {
// 							 html2 += "<li><a href=\"javascript:memberListAjax(" + i + ");\">" + i + "</a></li>";  
// 						}
// 					}
// 					$('.pagination').html(html2);
// 				}
// 			});
// 		}

	function memberListAjaxHTML(p){

		$.ajax({
				url : "/member/memberListAjaxHTML",
				data : {page : p,
						pageSize : 5
					},
				method : "get",
				success : function(data){
					$('#memberList').html(data.split("$$$$SEPERRATOR$$$$")[0]);
					$('.pagination').html(data.split("$$$$SEPERRATOR$$$$")[1]);
				}
			});
		}

// 	function memberAjax(userid){

// 		$.ajax({

// 			url : "/member/memberAjax",
// 			data : { userid : userid },
// 			method : "get",
// 			success : function(data){
// 				alert("성공")
// 				document.location = "/member/memberAjax?userid=" + userid;
// 			},
// 			error : function(){
// 				alert("실패")
// 			}
// 		});
// 	}
</script>
<body>
<div class="row">
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


         </tbody>
   </table>
		</div>
		<a href="${cp }/member/memberRegistView" class="btn btn-default pull-right">사용자 등록</a>
<!-- 		현재 있는 페이지이면 if넣어서 active, 아니면 else  -->
		<div class="text-center">
			<ul class="pagination">
			</ul>
		</div>
	</div>
</div>
</body>
</html>
