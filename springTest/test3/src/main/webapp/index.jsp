<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<button id="btn">ajax 버튼</button>
	<br>
	<br>

	<table border="1" id="result2">
		<thead>
			<tr>
				<th>시도명</th>
				<th>시군구명</th>
				<th>대피지구명</th>
				<th>대피장소명</th>
				<th>주소</th>
				<th>경도</th>
				<th>위도</th>
				<th>수용가능인원수</th>
				<th>대피소 분류명</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

	<script>
		$(function() {

			$("#btn").click(function() {

				$.ajax({

					url : "disaster",
					
					success : function(data) {
						
						let value;
						
						const rowsArr = $(data).find("row"); 
						
						console.log($(data).find("row"));

						rowsArr.each(function(index, row){ 
							
							value += "<tr>"
								+ "<td>"+ $(row).find("sido_name").text() +"</td>"
								+ "<td>"+ $(row).find("sigungu_name").text() +"</td>"
								+ "<td>"+ $(row).find("remarks").text() +"</td>"
								+ "<td>"+ $(row).find("shel_nm").text() +"</td>"
								+ "<td>"+ $(row).find("address").text() +"</td>"
								+ "<td>"+ $(row).find("lon").text() +"</td>"
								+ "<td>"+ $(row).find("lat").text() +"</td>"
								+ "<td>"+ $(row).find("shel_av").text() +"</td>"
								+ "<td>"+ $(row).find("shel_div_type").text() +"</td>"
						  +"</tr>"	
							
						})
						
						$("#result2 > tbody").html(value);
						
					},
					
					error : function() {
						console.log("통신 실패");
					}

				})

			})

		})
	</script>


</body>
</html>



</body>
</html>