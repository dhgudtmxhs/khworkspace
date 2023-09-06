

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>

	<button id="btn">ajax 버튼</button>

	<table border="1" id="result">
		<thead>
			<tr>
				<th>결과코드</th>
				<th>결과메세지</th>
				<th>한페이지결과수</th>
				<th>페이지번호</th>
				<th>전체결과수</th>
				<th>수신문서형식</th>
				<th>일련번호</th>
				<th>시도명</th>
				<th>시군구명</th>
				<th>대피지구명</th>
				<th>대피장소명</th>
				<th>주소</th>
				<th>경도</th>
				<th>위도</th>
				<th>수용가능인원수</th>
				<th>해변으로부터의거리</th>
				<th>대피소 분류명</th>
				<th>내진적용여부</th>
				<th>해발높이</th>
			</tr>
		</thead>
		
		<tbody>
		</tbody>
		
	</table>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

	<script>
		$(function() {

			$("#btn").click(function() {

				$.ajax({

					url : "disaster",
					success : function(result) {
						let value;
						const arr = $(result).find("row");
						arr.each(function(index, row){ 
							
							value += "<tr>"
								+ "<td>"+ $(row).find("resultCode").text() +"</td>"
								+ "<td>"+ $(row).find("resultMsg").text() +"</td>"
								+ "<td>"+ $(row).find("numOfRows").text() +"</td>"
								+ "<td>"+ $(row).find("pageNo").text() +"</td>"
								+ "<td>"+ $(row).find("totalCount").text() +"</td>"
								+ "<td>"+ $(row).find("type").text() +"</td>"
								+ "<td>"+ $(row).find("id").text() +"</td>"
								+ "<td>"+ $(row).find("sido_name").text() +"</td>"
								+ "<td>"+ $(row).find("sigungu_name").text() +"</td>"
								+ "<td>"+ $(row).find("remarks").text() +"</td>"
								+ "<td>"+ $(row).find("shel_nm").text() +"</td>"
								+ "<td>"+ $(row).find("address").text() +"</td>"
								+ "<td>"+ $(row).find("lon").text() +"</td>"
								+ "<td>"+ $(row).find("lat").text() +"</td>"
								+ "<td>"+ $(row).find("shel_av").text() +"</td>"
								+ "<td>"+ $(row).find("lenth").text() +"</td>"
								+ "<td>"+ $(row).find("shel_div_type").text() +"</td>"
								+ "<td>"+ $(row).find("seismic").text() +"</td>"
								+ "<td>"+ $(row).find("height").text() +"</td>"
						  +"</tr>"	
							
						})
						
						$("#result > tbody").html(value);
						
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