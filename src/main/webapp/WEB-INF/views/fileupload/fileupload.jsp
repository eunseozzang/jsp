<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 	$(function(){
// 		$('button').on('click',function(){
// 			alert("전송")
// 			$('form').submit();
// 		})
// 	})

</script>
</head>
<body>

<!-- 	client form methkd : post -->
<!-- 	encType : multipart/form-data 
		server - servlet @MultipartConfig
		       - spring Frameworked MultiparResolver
-->

	<form action="${cp }/fileupload/upload" method="post" enctype="multipart/form-data">
		userid : <input type="text" name="userid" id="userid" value="어피치"><br><br>
		파일첨부 : <input type="file" name="file" id="file"><br><br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>