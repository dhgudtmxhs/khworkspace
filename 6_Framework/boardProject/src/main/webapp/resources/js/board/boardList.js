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
