<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

$(document).ready(function(){

	alert("ddddddddddddddddddd")

	memberAjax("${param.userid}");
	
})


	function memberAjax(userid){
		$.ajax({
			url : "/member/memberAjax",
			data : { userid : userid },
			method : "get",
			success : function(data){
				$('#userid').html(data.userid)
			},
			error : function(){
			}
		});
	}

</script>

<form class="form-horizontal" role="form">

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
<%-- 			<img src="${cp }/profileImgView?userid=${memberVO.userid }" /><br> --%>
			<br>
			<button id="profileDownBtn" type="button" class="btn btn-default">
				다운로드 : </button>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<label class="control-label" id="userid"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">등록일자</label>
		<div class="col-sm-10">
			<label class="control-label"></label>
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="${cp }/member/memberUpdateView?userid=${memberVO.userid}"
				class="btn btn-default">사용자 수정</a>
		</div>
	</div>
</form>
