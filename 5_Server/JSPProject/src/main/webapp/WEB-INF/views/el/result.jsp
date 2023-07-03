<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Person 클래스 import  -->
<%-- <%@page import="edu.kh.jsp.model.vo.Person" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인하기</title>
</head>

<body>

	<!-- 
		EL의 특징
		
		1. get이라는 단어를 사용하지 않는다.
		 왜? 표현 언어 == 출력용 언어 == 출력은 얻어와서 밖에 못함
		 
		2. EL은 null을 빈칸으로 출력함
			(null과 관련된 것은 모두 빈칸)
	 -->

	<h3>request에서 Parameter 얻어오기</h3>
	
	<pre>
		EL로 Parameter 얻어와서 출력하는 방법
		\${ param.name속성값 } <!-- \ => escape -->
	</pre>

	1) JSP 표현식 : <!-- 홍길동 / 12 / 서울시 -->
	<%= request.getParameter("inputName")%> /
	<%= request.getParameter("inputAge")%> /
	<%= request.getParameter("inputAddress")%>

	<%= request.getParameter("inputAddress2")%>
	<!-- null -->
	
	<br><br>
	
	2) EL(표현 언어) : 
		asdfasdfsafd
		${ param.inputName } /
		${ param.inputAge } /
		${ param.inputAddress }
		
		${ param.inputAddress2 }
		${ param.inputAddress3 }
		<!-- 빈칸 -->

		<h3>request에서 속성(Attribute) 얻어오기</h3>

		<pre>
			Servlet에서 추가된 속성을 표현(출력)하려는 경우
			request에 세팅된 속성(Attribute)의 key값만 작성하여 출력할 수 있다!
			<!--  req.setAttribute("menu", menu); 로 가져오면 
				jsp 표현식에서는  String menu = (String)request.getAttribute("menu"); 이렇게 다시 담아야하는데
				el 표현으로는  ${ menu } 만 하면 나온다.	
			 -->
			
		</pre>
		
				<%
			// String menu = (String)request.getAttribute("menu");
		
			/* Person person = (Person)request.getAttribute("person"); */ 
			
			
			
		
		%>

		1) JSP 표현식	<%-- <%= menu %> --%>
		
		<!-- Person 클래스의 toString() 출력 -->
<%-- 		<br> <%= person %> --%>
		
		<!-- Person 클래스의 getter를 이용해 얻어와서 출력 -->
<%-- 		<br> <%= person.getName()%>
		<br> <%= person.getAge()%>
		<br> <%= person.getAddress()%> --%>
		
		<br><br>
		
		2) EL(표현 언어) : ${ menu }
						${ person }
		
		<br> ${ person.name }
		<br> ${ person.age }
		<br> ${ person.address } 
		<!-- el은 get, import, 다운캐스팅, 변수 저장 다 안써도 된다. -->

		
		<pre>
		\${ 속성 key }
		
		\${ 속성 key. 필드명 }
		<!-- 단, person에서 getter가 다 잘 작성되어있어야 한다. -->
				
		</pre>
		
				
		<hr>
		
		<h3>null 처리 방법</h3>
		
		<pre>
			EL에서 null을 출력해야 되는 경우 ""(빈 문자열)을 출력한다.
		
			+ NullPointerException이 발생하는 코드에서도 ""(빈 문자열)을 출력한다.
			
		<!-- 	String str = null;
				str.charAt(0)을 해도 EXCEPTION 발생 안함. -->
		
			+ EL은 null인 경우를 확인할 대 empty를 통해서 확인할 수 있다.
	
		</pre>
		
		<% 
			List<String> list = null; 
		%>
		
		1) JSP 표현식 : <%=list %>
		
		<br> <%= list == null %> 
		
		
		
		<br><br>
		
		2) EL(표현 언어) : ${ list }
		
		<br> <%-- ${ list == null } --%> ${ empty list } <!-- empty = 문자열이 비어있니? ""니? -->
 		
 		<h3 style="color:red;">EL의 empty는 null과, 비어있는 컬렉션을 비어있다고 취급한다.</h3>
		
		<%
			list = new ArrayList<String>();

			// list가 ArrayList 객체를 참조한다.	 == null 아님. 참조하는 주소값이 있다.
			// 참조하고있는 ArrayList에 내용은 없음 == 비어있음.
		%>
		
		<%=list == null %>
		${ empty list }
		
		<%-- ${ list == null } 이렇게 확인 할 수 없다.
			EL을 이용해서 컬렉션 요소를 다룰 때
			null인지 비어있는지 확인하는 방법이 동일하기 때문에
			코드 작성 시 이를 잘 구분할 수 있도록 해야한다.
		--%>
		
		
		
</body>

</html>