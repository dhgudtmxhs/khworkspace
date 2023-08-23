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


