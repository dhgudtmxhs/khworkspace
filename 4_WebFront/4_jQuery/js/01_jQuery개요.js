// js와 jQuery 차이점

// 배경 : black
// 글자색 : yeloow
// 글자 크기 : 20px

// javascript
document.querySelector("#jsBtn").addEventListener("click",function(){
        // querySelector는 css선택자? -> 아이디 앞에 #
        this.style.backgroundColor = "black";
        this.style.color = "yellow";
        this.style.fontSize = "20px";
        // 화삺표함수는 this 사용 불가능. window.~~ 이 되어버림

})

// jQuery
$("#jQueryBtn").on("click", function(){

    $(this).css("backgroundColor", "black")
            .css("color","yellow")
            .css("fontSize","20px");

})

// window.onload 확인
window.onload = function(){ // 문서 로딩이 완료된 후 수행
    console.log("1");
}

// window.onload 중복 작성 -> 앞서 작성한 window.onload를 덮어씌운다.
window.onload = function(){
    console.log("3");
}

console.log("2"); 

// ready() 함수 확인

$(document).ready(function(){
    $("#readyTest").on("click", function(){
        alert("클릭이 되었습니다.");
    })
})

// ready() 중복 작성
$(document).ready(function(){
    document.getElementById("readyTest").style.color = "pink";
})

// ready() 함수 다른 형태
$(function(){
    console.log("ready() 함수의 다른 형태");
})

// ready() + 화살표 함수
$(() => {console.log("이렇게도 됩니다.")});
