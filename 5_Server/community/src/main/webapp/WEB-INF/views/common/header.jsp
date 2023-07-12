<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>

	<section>
		<!-- 클릭 시 메인페이지로 이동하는 로고 -->
		<a href="${ contextPath }"> 
		
			<!-- http://localhost:8080/community/member/resources/images/logo.jpg -->
			
			<!-- header를 별도의 jsp로 분리한 경우
				 상대경로로 작성된 이미지의 경로가 일치하지 않게된다.
				 
				지금처럼 분리시켜둔 jsp에 경로를 지정하는 경우
				상대경로는 문제가 발생할 가능성이 높다.
				-> 절대 경로 사용이 바람직하다.	 
			
			 -->
			
		<%-- /resources 앞에
			/community
			<%= request.getContextPath() %>
			${ pageContext.servletContext.contextPath }
			
			위에 작성된 내용은 모두 같은 결과이지만 하자가 조금씩 있다. 길거나.. 등
			-> 모든 주소 요청 시 동작하는 EncodingFilter에서
			   application scope에 최상위 주소를 간단히 부를 수 있는 형태로 저장한다.
		 --%>	
		
		<!-- applicationScope -->
		<img src="${contextPath}/resources/images/logo.jpg" id="home-logo">
		<!-- 범위가 page, request, session 다 없어서 이렇게만 써도 된다.  -->
		</a>

	</section>

	<!-- header의 두번째 자식 div -->
	<section>
		<article class="search-area">

			<!-- form태그 내부 input 태그 값을 서버 또는 페이지로 전달 -->
			<form action="#" name="search-form">

				<!-- fieldset : form 태그 내부에서 input을 종류별로 묶는 용도로 많이 사용함 -->
				<fieldset>

					<input type="search" id="query" name="query"
						placeholder="검색어를 입력해주세요." autocomplete="off">
					<!-- 자동완성 끄기 -->

					<!-- 검색 버튼 -->
					<button type="submit" id="search-btn"
						class="fa-solid fa-magnifying-glass"></button>

				</fieldset>
			</form>
		</article>
	</section>


	<section></section>

</header>

<nav>
	<ul>
		<li><a href="#">공지사항</a></li>
		<li><a href="#">자유 게시판</a></li>
		<li><a href="#">질문 게시판</a></li>
		<li><a href="#">FAQ</a></li>
		<li><a href="#">1:1문의</a></li>
	</ul>
</nav>
