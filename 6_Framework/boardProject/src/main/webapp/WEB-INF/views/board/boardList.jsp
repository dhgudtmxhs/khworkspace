<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%-- map에 저장된 값들을 각각 변수에 저장 --%>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>

<%-- 게시판 이름 가져오는 방법 1 --%>
<%-- <c:set var="boardName" value="${boardTypeList[boardCode-1].BOARD_NAME}"/> --%> 
                            <%-- 인터셉터에서 application.setAttribute("boardTypeList", boardTypeList); --%>    
                            <%-- 공지사항이 1번짼데 boradtypelist의 0번째 인덱스에 담겨있어서 -1 --%>
                            <%-- [{BOARD_NAME=공지사항, BOARD_CODE=1}, {BOARD_NAME=자유 게시판, BOARD_CODE=2}, ...] --%>


<%-- 게시판 이름 가져오는 방법 2 --%>
<c:forEach items="${boardTypeList}" var="boardType">
    <c:if test="${boardType.BOARD_CODE == boardCode}"> 
    <%-- 0번 인덱스부터 끝 인덱스까지 boardcode와 비교? --%> 

    <%-- boardCode는 @PathVariable("boardCode") --%>

    <%-- boardType.BOARD_CODE는 
    [{BOARD_NAME=공지사항, BOARD_CODE=1}, {BOARD_NAME=자유 게시판, BOARD_CODE=2}, ...] --%>
  
        <c:set var="boardName" value = "${boardType.BOARD_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>boardList</title>

    <link rel="stylesheet" href="/resources/css/board/boardList-style.css">

</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <%-- 검색을 진행한 경우 파라미터(key, query)를
             쿼리스트링 형태로 저장한 변수를 선언 --%>

        <%-- param.key or param.query == 검색했을때 주소에 key=숫자 나 query= 숫자가 있다면

            -> 검색했을때 첫페이지는 http://localhost/board/1?key=t&query=1 인데 다른 페이지네이션 누르면
               key=숫자&value=숫자 가 안넘어와서 해줌
        --%>
       <c:if test="${!empty param.key}" > 
        <c:set var="cpQuery" value="&key=${param.key}&query=${param.query}"/>
       </c:if> 

        <section class="board-list">

            <%-- 게시판 이름 --%>
            <h1 class="board-name">${boardName}</h1>

            <c:if test="${!empty param.key}">
                <h3 style="margin:30px">"${param.query}" 의 검색 결과</h3>
            </c:if>

            <div class="list-wrapper">
                <table class="list-table">
                    
                    <thead>
                        <tr>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                            <th>좋아요</th>
                        </tr>
                    </thead>

                    <tbody>

                    <c:choose>
                       <c:when test="${empty boardList}">
                            <%-- 조회된 게시글 목록이 비어있거나 null 인 경우 --%>
                            <!-- 게시글 목록 조회 결과가 비어있다면 -->
                            <tr>
                                <th colspan="6">게시글이 존재하지 않습니다.</th>
                            </tr>
                       </c:when>
                    
                       <c:otherwise>
                       
                            <!-- 게시글 목록 조회 결과가 있다면 -->
                            <c:forEach items="${boardList}" var="board">
                                <tr>
                                    <td>${board.boardNo}</td> <%-- 글번호 1495 --%>
                                    <td> 

                                    <%-- 썸네일이 있을 경우 --%>
                                    <c:if test="${!empty board.thumbnail}">
                                        <img class="list-thumbnail" src="${board.thumbnail}"> <%-- 썸네일 이미지 --%>
                                    </c:if>
                                        <a href="/board/${boardCode}/${board.boardNo}?cp=${pagination.currentPage}${cpQuery}">${board.boardTitle}</a>   
                                        <%-- boardCode가 pathVariable로 있어서 resultMap이나 sql에서 쓰지않고 이렇게 가져옴--%>
                                        <%-- 1495번째 게시글 --%>
                                        [${board.commentCount}] <%-- 댓글 수 --%>
                                    </td>
                                    <td>${board.memberNickname}</td> <%-- 닉네임 --%>
                                    <td>${board.boardCreateDate}</td> <%-- 작성일 --%>
                                    <td>${board.readCount}</td> <%-- 조회수 --%>
                                    <td>${board.likeCount}</td> <%-- 좋아요 수 --%>
                                </tr>
                            </c:forEach>

                       </c:otherwise>
                    </c:choose>


                    </tbody>
                </table>
            </div>



            <div class="btn-area">

                <!-- 로그인 상태일 경우 글쓰기 버튼 노출 -->
                <c:if test="${!empty loginMember}">
                    <button id="insertBtn">글쓰기</button>                     
                </c:if>

            </div>


            <div class="pagination-area">


                <ul class="pagination">
                
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="${boardCode}?cp=1${cpQuery}" >&lt;&lt;</a></li>
                    <%-- 절대경로 : href="/board/${boardCode}?cp=1" --%>
                    
                    <!-- 이전 목록 마지막 번호로 이동 -->
                    <li><a href="${boardCode}?cp=${pagination.prevPage}${cpQuery}">&lt;</a></li>

                    <!-- 특정 페이지로 이동 -->
                    <c:forEach var="i" begin="${pagination.startPage}" 
                                end="${pagination.endPage}" step="1"> 
                                <%-- private int pageSize = 10;  --%>
                                <%-- endPage = startPage + pageSize - 1; 
                                     startPage = 1 이면 endpage = 10
                                     startPage = 1~10 사이면 endpage = 10 (5, 6 이런페이지 넘어가도 끝페이지는 10)
                                     
                                     startPage = 11~20 이면 endPage = 20 (12, 13 이런페이지로 가도 끝페이지는 20)
                                --%>

                                    <c:choose>
                                       <c:when test="${i == pagination.currentPage}">
                                                <!-- 현재 보고있는 페이지 -->
                                                <li><a class="current">${i}</a></li> <%-- 주소달 필요없음, 파랑 표시--%>
                                       </c:when>
                                    
                                       <c:otherwise>
                                                <!-- 현재 페이지를 제외한 나머지 -->
                                                <li><a href="/board/${boardCode}?cp=${i}${cpQuery}">${i}</a></li>
                                       </c:otherwise>
                                    </c:choose>

                    </c:forEach>
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="/board/${boardCode}?cp=${pagination.nextPage}${cpQuery}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="/board/${boardCode}?cp=${pagination.maxPage}${cpQuery}">&gt;&gt;</a></li>

                </ul>
            </div>


         <!-- 검색창 -->

            <%--    
                    게시글 목록 조회
                    @GetMapping("/{boardCode:[0-9]+}") 
            --%>
            <form action="${boardCode}" method="get" id="boardSearch">

                <select name="key" id="searchKey">
                    <option value="t">제목</option>
                    <option value="c">내용</option>
                    <option value="tc">제목+내용</option>
                    <option value="w">작성자</option>
                </select>

                <input type="text" name="query"  id="searchQuery" placeholder="검색어를 입력해주세요.">

                <button>검색</button>
            </form>

        </section>
    </main>
    
    <!-- 썸네일 클릭 시 모달창 출력 -->
    <div class="modal">
        <span id="modalClose">&times;</span>
        <img id="modalImage" src="/resources/images/user.png">
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="/resources/js/board/boardList.js">
    
    </script>

</body>
</html>