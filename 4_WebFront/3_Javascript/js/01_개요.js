// 한줄 주석
/* 범위 주석 */

// js파일은 <script>태그 내부라고 생각하면 된다.</script> 
// <style>css가 style 태그 안인 것 처럼</style>

function btnClick2(){
    alert("external 알림창 출력"); /* window.alert 에서 window 제거 가능 */
}

function changeColor1(){
    document.getElementById("box").style.backgroundColor = "red";
    /* 문서내에서. 요소가-아이디가 박스. 스타일. 백그라운드컬러. 레드로 하겠다. */
}

function changeColor2(){
    document.getElementById("box").style.backgroundColor = "yellow";
}