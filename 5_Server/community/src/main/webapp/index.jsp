<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH 커뮤니티</title>

    <link rel="stylesheet" href="resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>

</head>

<body>
 
    <main>
    
    	<!-- jsp : include 태그  
    			다른 jsp파일의 내용을 해당 위치에 포함시킴
    			경로 작성 시 외부 요청 주소 X (인터넷 주소 -> 최상위 : /community ),
    			내부 접근 경로로만 작성해야 한다. (파일 경로, 최상위 : /webapp ) 
    	-->
    	
    	<!-- 내부 접근 경로 -->
    	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
  
        <section class=content>
            
            <section class="content-1">
               loginMember : ${ sessionScope.loginMember }
               
               <hr>
               
               message : ${ sessionScope.message }
               
            </section>

            <section class="content-2">

				<!-- if - else -->
				<c:choose>
				
					<%-- choose 내부에는 jsp 주석만 사용 --%>
					<c:when test="${ empty sessionScope.loginMember }">
					
				<!-- 절대경로 : /community/member/login -->              
                
                <!-- 상대경로 (index.jsp) 기준 -->
                <form action="member/login" method="post" name="login-form" onsubmit ="return loginValidate()">
        
                        <!-- 아이디(이메일 형식으로)/비밀번호/로그인버튼 영역 -->
                        <fieldset id="id-pw-area">
        
                            <section>
                                <input type="text" name="inputEmail" placeholder="아이디(이메일)" value="${ cookie.saveId.value }"> 
                                																	<%-- value값이 이메일임 --%>
                                <input type="password" name="inputPw" placeholder="비밀번호">
                            </section>
        
                            <section>
                                <button >로그인</button>
                            </section>
        
                        </fieldset>
        
                        <!-- 회원가입/ ID,PW찾기 영역 -->
                        <article id="signup-find-area">

                        <!-- WEB-INF 폴더는 외부로부터 직접적으로 요청할 수 없는 폴더
                            왜? 중요한 코드(자바, sql, 설정관련)가 위치하는 폴더로서
                            외부로부터 접근을 차단하기 위해서
                            <a href="/community/WEB-INF/views/member/signUp.jsp">회원가입</a>

                            -> 대신 Servlet을 이용한 내부 접근(forward)는 가능
                        -->
    
                            <a href="/community/member/signUp">회원가입</a>
                            <span>|</span> <!-- inline요소 -->
                            <a href="#">ID/PW 찾기</a>
                        </article>

						<%-- 쿠키에 saveId가 있는 경우 --%>
						<c:if test="${!empty cookie.saveId.value}">
						
						<%-- check 변수 생성(page scope) --%>
						<c:set var="chk" value="checked"></c:set>
						<%-- <c:set> 태그를 사용하여 변수를 설정할 때, 기본 범위는 page 범위입니다. scope="page"가 기본값 --%>
						<%-- <c:set var="chk" value="checked"></c:set>는 if문 안에서만 사용되는 변수입니다. 
						기본 범위가 page 범위이기 때문에, 이 변수는 해당 JSP 페이지 전체에서 사용할 수 있습니다. 
						다시 말해, if문 밖에서도 해당 변수를 참조할 수 있습니다. --%>
						
						</c:if>
						
                        <label>
                            <input type="checkbox" name="saveId" ${chk} id="saveId">아이디 저장
                        </label>
        
                		</form>
					
					</c:when>
					
					
					<%-- 로그인이 되어있는 경우 --%>
					<c:otherwise>
						<article class="login-area">
							<!-- 회원 프로필 이미지  -->
							<a href="#">
								<img src="/community/resources/images/a.png" id="member-profile">
							</a>
							
							<!-- 회원 정보 + 로그아웃 버튼  -->
							<div class="my-info">
								<div>
									<a href="${contextPath}/member/myPage/info" id="nickname">${sessionScope.loginMember.memberNickname }</a> <%-- scope 범위때문에 sessionScope.은 빼도 된다. page, request 범위의 값이 없으니까--%>
									<%-- a태그는 무조건 get --%>
									
									<a href="/community/member/logout" id="logout-btn">로그아웃</a>
								</div>
								
								<p>
									${loginMember.memberEmail }
								</p>
								
							</div>
							
							
							
						</article>
						
					</c:otherwise>
				
				</c:choose>
  
            </section>

        </section>

    </main>



	    <!-- footer -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


	<script src="${contextPath}/resources/js/main.js"></script>

</body>

</html>