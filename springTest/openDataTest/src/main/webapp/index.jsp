<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<button id="btn">ajax 버튼</button>
	<br>
	<br>

	<table border="1" id="result">
		<thead>
			<tr>
				<th>�õ���</th>
				<th>�ñ�����</th>
				<th>����������</th>
				<th>������Ҹ�</th>
				<th>�ּ�</th>
				<th>�浵</th>
				<th>����</th>
				<th>���밡���ο���</th>
				<th>���Ǽ� �з���</th>
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
						const rowsArr = $(data).find("row"); // find = ������� �� �ϳ� ã��
						
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
						console.log("��� ����");
					}

				})

			})

		})
	</script>


</body>
</html>



</body>
</html>