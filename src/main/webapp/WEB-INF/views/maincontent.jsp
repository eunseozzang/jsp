<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
#news {
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	
}

.col-md-4 {

	height: 270px;
	margin-top: 7%;
}


.carousel-item, .carousel-inner, .carousel-inner img {

	height: 100%;
	width: auto;
}




#dayimg {

	width: 250px;
	height: 80px;
	padding-left: 20px;
}

#ddayimgdiv {

	display: inline-block;
}

#table2 {

	width: 470px;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid #444444;
	padding: 10px;
}

.container {
	
	display: inline-block;
	position: absolute;
	top: 130%;
	left: 45%;
}
</style>
<script>
	$(function() {
		$.ajax({
			url : '/MiddleProject/SoonEnd',
			type : 'get',
			dataType : 'json',
			success : function(res) {
				code = "<div id='table'>";
				code += "<table id='table2'>";
				code += "<tr><td>채용공고명</td><td>기업명</td><td>마감일</td>";
				$.each(res, function(i, v) {
					code += "<tr><td><a href='/MiddleProject/EachRecruitServlet?id="+v.id+"'>"+v.title+"</a></td><td><a href='/MiddleProject/CompanyInfo?compid="+v.compid+"' >"+ v.compname
							+ "</a></td><td>D-" + v.dday + "</td></tr>";
				})
				code += "</table></div>";
				$('#dday').html(code);

			}
		})
	})
</script>


</head>
<body>
<div id="main">
	<div class="carousel">
		<h2></h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img class="carimg" src="<%=request.getContextPath()%>/images/getjob.png" alt="Los Angeles"
						style="width: 100%;">
				</div>


				<div class="item">
					<img src="<%=request.getContextPath()%>/images/title4.jpg" alt="Chicago" style="width: 100%;">
				</div>



				<div class="item">
					<img src="<%=request.getContextPath()%>/images/banner.f5d558ef.png" class="carimg"
						alt="New york" style="width: 100%;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<!--     // ---------------------------------------------------------->
	<hr>

		<div id="ddayimgdiv">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<img src="<%=request.getContextPath()%>/images/ddayimg.png" id="dayimg">
		<div id="dday"></div>
		
		</div>
		<br>
		


	<div class="container">
		<br> <br>
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="https://www.kakaocorp.com/" target="_blank"> <img src="<%=request.getContextPath()%>/images/kakao.jpg" style="width: 100%">
						<div class="caption">
							
						</div>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="https://www.bighitcorp.com/kor/" target="_blank"> <img src="<%=request.getContextPath()%>/images/bighit.png" style="width: 100%">
						<div class="caption">
							
						</div>
					</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="https://www.ygfamily.com/" target="_blank"> <img src="<%=request.getContextPath()%>/images/YG.jpg" style="width: 100%">
						<div class="caption">
						
						</div>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="http://www.netmarble.net/" target="_blank"> <img src="<%=request.getContextPath()%>/images/netmarble.jpg" style="width: 100%">
						<div class="caption">

						</div>
					</a>
				</div>
			</div>
		</div>
</div>
</div>







</body>
</html>