// 좋아요 버튼이 클릭되었을 때
const boardLike = document.getElementById("boardLike");

// 로그인 여부 검사

boardLike.addEventListener("click", e => {

    if(loginMemberNo == ""){
        alert("로그인 후 이용해주세요.");
        return;
    }

    let check; // 기존에 좋아요 x (빈하트)   : 0
               // 기존에 좋아요 o (꽉찬하트) : 1

    // contains("클래스명") : 클래스가 있으면 true, 없으면 false
    
    if(e.target.classList.contains("fa-regular")){ // 좋아요 x 빈하트면
        check = 0;
    }else{ // 좋아요 o 꽉찬하트면
        check = 1;
    }

    // ajax로 서버로 제출할 파라미터를 모아둔 JS 객체 만들어서 body에 담아 보내기
    const data = {"boardNo" : boardNo,
                  "memberNo" : loginMemberNo,
                  "check" : check};


    // ajax 코드 작성
    fetch("/board/like", { // 원랜 get 방식으로 보냄
        method : "POST", 
        headers : {"Content-Type" : "application/json"}, // application에서 사용할 json 데이터
        body : JSON.stringify(data) 
        // json을 쓰는데 body는 js 객체 형식 
        // JSON.stringify() : JS 객체 -> JSON 
        // JSON.parse()     : JSON -> JS 객체 

    })

    // JSON으로 보냄 -> DTO/MAP(controller)로바꿈 -> sql 수행 -> 
    // JSON으로 반환(@ResponseBody) -> 필요한 형태로 parsing

    
    .then( resp => resp.text() ) // 응답 객체를 필요한 형태로 파싱하여 리턴 resp = {return resp.json()}

    .then( count12345 => { 
        // 이전 .then() 함수에서 반환된 데이터가 전달되고 이 이름은 아무렇게나 설정 가능

        console.log("count : " + count12345)

        // serviceImpl에서 if(result == 0) return -1;
        if(count12345 == -1){ // insert 또는 delete 실패
            console.log("좋아요 처리 실패");
            return;
        }

        // toggle() : 클래스가 있으면 없애고 없으면 추가한다.
        // e.target : 이벤트가 발생한 변수?
        e.target.classList.toggle("fa-regular"); // 빈하트
        e.target.classList.toggle("fa-solid"); // 꽉찬하트

        // 현재 게시글의 좋아요 수를 화면에 출력
        // 빈하트 or 꽉찬하트 태그(test="${empty ~}")의 다음 형제(if문은 상관 x)
        e.target.nextElementSibling.innerText = count12345;
        // <span>${board.likeCount}</span> 를 실시간으로 바꿈
        // 누르면 insert된 후에 -> count + 1
        //       delete -> count - 1

    } ) // 파싱된 데이터를 받아서 처리하는 코드 작성

    .catch(err => {
        console.log("예외 발생");
        console.log(err);
    }) // 예외 발생 시 처리하는 부분

})

// 게시글 수정 버튼 클릭 시
const updateBtn = document.getElementById("updateBtn")

if(updateBtn != null){
updateBtn.addEventListener("click",()=>{

    // board/1/2012 에서
    // board2/1/2012/update?cp=1 으로 이동하기

    // 1) location.pathname -> '/board/1/1521'

    // 2) location.pathname.replace("board", "board2") -> '/board2/1/1521'

    // 3) location.pathname.replace("board", "board2") + "/update" -> '/board2/1/1521/update'

    // 4) location.search -> '?cp=1' 상세페이지에 있던 쿼리스트링

    // 5) location.pathname.replace("board", "board2") + "/update" + location.search
    
    // -> '/board2/1/1521/update?cp=1'

    location.href = location.pathname.replace("board", "board2") + "/update" + location.search;

})
}

// 게시글 삭제 버튼이 클릭 되었을 때
const deleteBtn = document.getElementById("deleteBtn");
if(deleteBtn != null){
deleteBtn.addEventListener("click", () => {


    if(confirm("정말 삭제 하시겠습니까?")){
        location.href 
        = location.pathname.replace("board","board2")
            + "/delete";
        //   /board2/1/2006/delete (GET)

        // 삭제 서비스 호출 성공 시 redirect:/board/{boardCode}
        // + RedirectAttributes 이용해서 "삭제 되었습니다" alert 출력

        // 삭제 서비스 호출 실패 시 redirect:/board/{boardCoed}/{boardNo}
         // + RedirectAttributes 이용해서 "삭제 실패" alert 출력
        }
    })
}

    // board/1/1517?cp=1 에서
    // board/1/cp=1 으로 이동

    // location.pathname.split("/") -> (4) ['', 'board', '1' '1524']
                    
    // location.pathname.split("/")[2] -> '1'

    // location.search -> '?cp=1' 쿼리스트링

    //location.href = `/board/${location.pathname.split("/")[2]}` + location.search ;


// 목록으로 
const goToListBtn = document.getElementById("goToListBtn");

goToListBtn.addEventListener("click", ()=>{

   // history.back();
/*    const params = new URL(location.href).searchParams;
   const cp = params.get("cp");
   const key = params.get("key"); 
   const query = params.get("query");  */

   /*    게시글 등록 
   location.href = `/board/${location.pathname.split("/")[2]}?cp=1` ;

   if(cp != null){

       location.href = `/board/${location.pathname.split("/")[2]}` + location.search ;
   }

   if(key != null || query != null){

       location.href = `/board/${location.pathname.split("/")[2]}` + location.search ;
   } 
   */

   let url = "/board/" + boardCode;

   // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
   // URL.searchParams : 쿼리스트링만 별도 객체로 반환

   const params = new URL(location.href).searchParams;

   let cp;

   if(params.get("cp") != "") { // 쿼리스트링에 cp가 있을 경우
        
        cp = "?cp=" + params.get("cp");

   } else {
        cp = "?cp=1";
   }

   if(params.get("cp") == null){ // 게시글작성하고 목록가면 cp=null pointexception뜸
        cp = "?cp=1";
   }

   url += cp;

   if(params.get("key") != null){
        const key = "&key=" + params.get("key");
        const query = "&query=" + params.get("query");
   
        url += key + query; // url 뒤에 붙이기
   }

   

   location.href = url;

})