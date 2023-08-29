// 미리보기 관련 요소 모두 얻어오기

// img 5개
const preview = document.getElementsByClassName("preview");

// file 5개
const inputImage = document.getElementsByClassName("inputImage");

// x버튼 5개 
const deleteImage = document.getElementsByClassName("delete-image");

// -> 위에 얻어온 요소들의 개수가 같음 == 인덱스가 일치한다.

for(let i = 0; i < inputImage.length; i++){

    inputImage[i].addEventListener("change", e=>{ // 파일 change 됐을 때
        
        const file = e.target.files[0]; // 선택된 파일의 데이터

        if(file != undefined){ // 파일이 선택 되었을 때

            const reader = new FileReader(); // 파일을 읽는 객체

            reader.readAsDataURL(file);
            // 지정된 파일을 읽은 후 result 변수에 URL 형식으로 저장
            
            reader.onload = e=>{ // 파일을 다 읽은 후 함수 실행
                preview[i].setAttribute("src", e.target.result); // src = url 대입

            }

        } else { // 선택 후 취소 되었을 때 file == undefined
            // 선택 된 파일 없음 -> 미리보기 삭제
            preview[i].removeAttribute("src");

        }

    });

    // 미리보기 삭제 버튼(x버튼)
    deleteImage[i].addEventListener("click", e=>{

        // 미리보기 이미지가 있을 경우에만
        if(preview[i].getAttribute("src") != ""){
            
            // 미리보기 삭제
            preview[i].removeAttribute("src");

            // input type = "file" 태그의 value를 삭제
            // ** input type = "file"의 value ""(빈칸)만 대입 가능 **
            inputImage[i].value = "";

        }

    })

}

// 게시글 등록 시 제목, 내용 작성 여부 검사
const boardWriteFrm = document.getElementById("boardWriteFrm"); // 폼
//const boardTitle = document.getElementsByClassName("boardTitle")[0]; // 제목 
//const boardContent = document.querySelector("#boardWriteFrm > div.board-content > textarea"); // 내용 (id, name 없을 때)

//const boardWriteFrm = document.getElementById("boardWriteFrm");
const boardTitle = document.querySelector("[name='boardTitle']");
const boardContent = document.querySelector("[name='boardContent']");

boardWriteFrm.addEventListener("submit", e=>{

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요.");
        e.preventDefault();
    }

    if(boardContent.value.trim().length == 0){
        alert("test");
        e.preventDefault();
    }

})