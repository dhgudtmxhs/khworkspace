<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/boardDetail-style.css">

    <script src="https://kit.fontawesome.com/16679b9adf.js" crossorigin="anonymous"></script>

</head>

<body>

    <main>
        
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="board-detail">

            <!-- 제목 -->
            <div class="board-title">제목</div>

            <!-- 프로필 + 닉네임 + 작성일 + 조회수 -->
            <div class="board-header">
                <div class="board-writer">
                    <img src="${contextPath}/resources/images/user.png">
                    <span>닉네임</span>
                </div>

                <div class="board-info">
                    <p> <span>작성일</span>2023년 07월 19일 11:12:23 </p>
                    <p> <span>마지막 수정일</span>2023년 07월 19일 11:12:23 </p>
                    <p> <span>조회수</span>23 </p>
                </div>

            </div>

            <!-- 썸네일 영역 -->
            <h5>썸네일</h5>
            <div class="img-box">
                <div class="boardImg thumnail">
                    <img src="${contextPath}/resources/images/logo.jpg">
                    <a href="#">다운로드</a>
                </div>
            </div>

            <!-- 업로드 이미지 영역 -->
            <h5>업로드 이미지</h5>
           
            <div class="img-box">
               
                <div class="boardImg">
                    <img src="${contextPath}/resources/images/logo.jpg">
                    <a href="#">다운로드</a> 
                </div>
                    
                <div class="boardImg">
                    <img src="${contextPath}/resources/images/logo.jpg">
                    <a href="#">다운로드</a> 
                </div>
                        
                <div class="boardImg">
                    <img src="${contextPath}/resources/images/logo.jpg">
                    <a href="#">다운로드</a> 
                </div>
                            
                <div class="boardImg">
                    <img src="${contextPath}/resources/images/logo.jpg">
                    <a href="#">다운로드</a> 
                </div>

            </div>

            <!-- 내용 -->
            <div class="board-content">
                내용입니다<br>
                내용입니다<br>
                내용입니다<br>
                내용입니다<br>
                내용입니다<br>
                내용입니다<br>
            </div>

            <!-- 버튼 영역 -->
            <div class="board-btn-area">
                <button id="updateBtn">수정</button>
                <button id="deleteBtn">삭제</button>
                <button id="goToListBtn">목록으로</button>
            </div>
        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>

</html>