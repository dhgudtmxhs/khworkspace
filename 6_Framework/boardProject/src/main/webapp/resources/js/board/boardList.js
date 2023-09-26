const insertBtn = document.getElementById("insertBtn");

// 글쓰기 버튼을 클릭 했을 때
if(insertBtn != null){

    insertBtn.addEventListener("click", ()=>{
    
        // JS BOM 객체 중 location 이용

        // location.href = "주소" -> 해당 주소 요청 (GET)

        // 1)
        // location.pathname -> '/board/2'

        // location.pathname.split("/") -> (3) ['', 'board', '2']
                        
        // location.pathname.split("/")[2] -> '2' 방식으로 boardCode 가져옴

        // location.href =  "/board/" + "location.pathname.split("/")[2]" + / insert << ???

        // 2)
        location.href = `/board2/${location.pathname.split("/")[2]}/insert` ;
                                // `` -> 연결연산자 사용 안해도 됨


    })
}

// 검색창 이전 검색 기록을 남겨 놓기
const boardSearch = document.querySelector("#boardSearch");
const searchKey = document.querySelector("#searchKey");
const searchQuery = document.querySelector("#searchQuery");
const options = document.querySelectorAll("#searchKey > option");

(()=>{

    const params = new URL(location.href).searchParams; // 주소에 쿼리스트링의 값 가져오기

    const key = params.get("key"); // t, c, tc, w 중 하나
    const query = params.get("query"); // 검색어
    
    if(key != null){ // 검색을 했을 때
        
        searchQuery.value = query; // 검색어를 화면에 출력

        // option 태그를 하나씩 순차 접근해서 value가 key랑 같으면
        // selected 속성 추가
        for(let op of options){
            if(op.value == key){
                op.selected = true;
            }
        }
    
    }

})();

// 검색어 입력 없이 제출된 경우
boardSearch.addEventListener("submit", e=>{
    
    if(searchQuery.value.trim().length == 0){ // 검색어 미입력 시
        
        e.preventDefault(); // submit 이벤트 제거
        alert("검색어를 입력해주세요.");
        location.href = location.pathname // 해당 boardCode의 1페이지로 넘김
                                          // location.pathname 은 쿼리스트링 제외한 주소 /localhost/board/1



    }

})







