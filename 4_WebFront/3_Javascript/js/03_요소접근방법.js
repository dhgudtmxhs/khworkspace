// id로 접근하기
function accessId(){

    // 접근한 요소의 배경색 얻어오기
    const div1 = document.getElementById("div1");

    const bgColor = div1.style.backgroundColor;

    // 자바스크립트는 문자열 비굑시에도 비교연산자를 사용한다. equals 사용하지 않음.
    if(bgColor == "red"){

        //div1의 배경색을 yellow로 변경
        div1.style.backgroundColor = "yellow";

    }else{
        //div1의 배경색을 red로 변경
        div1.style.backgroundColor = "red";
    }


}

function accessId2(){

    const div2 = document.getElementById("div2");

    if(div2.style.backgroundColor == "red"){

        div2.style.backgroundColor = "yellow";

    }else{

        div2.style.backgroundColor = "red";
    }

}

// class로 접근하기
function accessClass(){

    // 요소를 여러 개 접근하는 경우 [배열] 형태로 반환된다.
    const arr = document.getElementsByClassName("div2")

    // 인덱스를 이용해서 요소 하나씩 접근
    arr[0].style.backgroundColor = "blue";
    arr[1].style.backgroundColor = "green";
    arr[2].style.backgroundColor = "orange";

    arr[0].innerHTML = "<b>첫 번째 요소</b>";
    arr[1].innerHTML = "<b>두 번째 요소</b>";
    arr[2].innerHTML = "<b>세 번째 요소</b>";

}

// tag명으로 접근하기
function accessTagName(){

    // 문서 내 모든 li 태그 접근 -> [배열] 형태로 반환된다.
    const arr = document.getElementsByTagName("li");

    // 반복문(Java랑 비슷)
    for(let i=0; i < arr.length; i++){

        const num = arr[i].innerText; // 1,2,3,4,5 를 얻어오겠다. <li>1</li>, ...

        arr[i].style.backgroundColor = "rgb(130, 220, " + (50 * num) + ")";



    }

}

// input 태그의 값(value) 얻어오기, 변경하기
function inputTest(){

    // input 요소 접근하기
    const input = document.getElementById("input-test");

    // input은 닫는 태그가 없어서 innerText와 innerHTML을 사용할 수 없음. value 써야함.
    
    console.log(input.value);


    // input에 작성된 값 변경하기 '' or ""
    input.value='';

    //input에 초점 맞추기 -> focus()
    input.focus();

}

// name으로 접근하기
function accessName(){

    /* 배열로 담아져서 옴 */
    const hobbyList = document.getElementsByName("hobby");

    let str = "";

    for(let i=0; i<hobbyList.length; i++){
     
        // radio / checkbox 전용 속성
        // .checked : 해당 요소가 체크되어 있으면 true, 아니면 false 반환

        if(hobbyList[i].checked){

            // str 변수에 value 누적

            str += hobbyList[i].value + " ";

        }

    }

    // #name-div에 출력
    let a = 0;

    for(let i=0; i<hobbyList.length; i++){

        if(hobbyList[i].checked){
            a++;
        }

    }
    const nd = document.getElementById("name-div");

    nd.innerHTML = str + "<br>선택된 개수 : " + a;

}

// CSS 선택자로 접근하기
function accessCSS(){

    // querySelector() : 요소 1개 선택시 사용

    // 1개만 있는 요소 선택 

    document.querySelector("#css-div").style.border="3px solid red";

    // 여러개 있는 요소 선택 (첫번째 요소만 적용됨)
    document.querySelector("#css-div > div").style.fontSize = "30px";

    //querySelectorAll() : 모든 요소 선택 시 사용
    const arr = document.querySelectorAll("#css-div > div");

    for(let i = 0; i < arr.length; i++){
        
        if(arr[i]=arr[0]){
            arr[i].style.backgroundColor = "yellow";
        }else {
            arr[i].style.backgroundColor = "blue";
        }

    }
 
}

// 카카오톡 채팅 만들기
function readValue(){
    
    // 채팅 입력에 사용되는 요소 모두 얻어오기
    const bg = document.getElementById("chatting-bg");

    const input = document.querySelector("#chatting-input");

    // input에 입력된 값이 있을 경우
    if(input.value.trim().length > 0 ){ // 공백없이 1글자라도 있다면.
        // 문자열.trim() : 문자열 양 끝에 공백을 모두 제거

        // input에 입력된 값을 얻어와서 bg에 추가(누적)한다.
        bg.innerHTML += "<p><span>" + input.value + "</span></p>";
    
        // 요소.scrollTop : 요소 내부 현재 스크롤 위 치 반환
        // 요소.scrollTop = 위치 : 스크롤을 특정 위치로 이동시킬 수 있다.
        // 요소.scrollHeight : 스크롤 전체 높이 알려줌
       
        // bg의 스크롤을 제일 밑으로 내리기
        
        bg.scrollTop = bg.scrollHeight; // 맨 밑 콘솔로 봤을때 전체높이로 나옴. -> 그래서 밑으로 고정됨
    
    }

    /* input 작성된 값 초기화시켜주기 */
    input.value ='';

    /* 초점맞추기 */
    input.focus();
}

// input 태그 키가 눌러졌을 때 엔터인 경우를 검사하는 함수
function inputEnter(event){

    console.log(event.key); // 현재 눌러진 key를 반환한다.

    if(event.key == "Enter"){ // 엔터를 누른다면
        readValue();
    }
    /* window.event.key였는데 event 매개변수?로 받으면 이렇게도 가능 */

}
