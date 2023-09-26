<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
</head>

<body>

<input type="text" id="emailInput"><span id="emailResult"></span>

<script>

$("#emailInput").on("input",function(){

var email = $("#emailInput").val();

var regex = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

if(regex.exec(email) == null){

$("#emailResult").text("이메일 형식에 맞지 않습니다.");

return;

}

$.ajax({

url:"/check/checkEmail",

data:{email: $("#emailInput").val()},

success:function(resp){

$("#emailResult").text(resp);

}

})

})

</script>

</body>

</html>