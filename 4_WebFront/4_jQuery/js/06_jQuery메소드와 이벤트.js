//html 버튼

$("#btn1").on("click",function(){

    // 아이디가 area인 요소의 내용을 모두 삭제
    /* $("#area").html(""); // innerHTML을 ("")로 다 없앤다. */

    $("#area").html("<p>html() 메소드로 작성된 내용</p>").css("color", "red");
                    //<p class = cls1></p> 으로도 가능

})

$("#btn2").on("click",function(){
    
    $("#area").text(""); 

    $("#area").text("<p>text() 메소드로 작성된 내용</p>").css("color", "red");
    // 태그 인식 x

})

// val() 버튼
$("#btn3").on("click",function(){

    // 아이디가 inputId인 요소인 값 삭제
    $("#inputId").val(""); 

    // 값 대 입
    $("#inputId").val("banana");

})


$(document).ready(function(){

    let count = 1;

    // append(마지막 자식 요소로 추가)
    $("#list2").append("<li>리스트" + count++ + "</li>");
    $("#list2").append("<li>리스트" + count++ + "</li>");
    $("#list2").append("<li>리스트" + count++ + "</li>");

    // prepend() : 첫 번째 자식 요소로 추가
    $("#list2").prepend("<li>리스트" + count++ + "</li>");
    $("#list2").prepend("<li>리스트" + count++ + "</li>");
    $("#list2").prepend("<li>리스트" + count++ + "</li>");

    for(let i = 0; i < 3; i++){
        const el = "<p>새로 추가된 요소" + i + "</p>";
        
        // before() : 바로 이전 형제 요소 추가
        $("#list2").before(el);
        // after() : 바로 다음 형제 요소 추가 
        $("#list2").after(el);

        // p태그 추가한건 list2와 형제고 before after
        // li 추가한건 list2의 자식임 append prepend

    }

    


})


    //empty 버튼
$("#btn2-1").on("click",function(){

        //empty() : 자식 요소들을 모두 제거하는 메소드
        //              -> 특정 요소 내부를 비움

        // id area3인 요소의 내부를 비움
        $("#area3").empty();
        

});

 $("#div3").hover(function(){
    console.log($("#div3"))

    // 마우스가 들어왔을 때 현재 요소에 lime클래스를 추가
    /* this.classList.add("lime"); */

    $(this).addClass("lime");

} , function(){
  
    $("#div3").removeClass("lime");
 
}); 

$("#btn2-2").on("click",function(){

    // remove() : 요소 잘라내기 -- 관련 이벤트 삭제?
    const el = $("#div3").remove();
    console.log(el);
    $("#area4").append(el); // 잘라낸걸 붙임?

});


// detach() 버튼

$("#btn2-3").on("click",function(){
    // detach() : 요소 잘라내기, 관련 이벤트도 같이 잘라냄
    const el = $("div3").detach();
    $("#area4").append(el);

});

$("#btn2-3").on("click",function(){
    // detach() : 요소 잘라내기, 관련 이벤트도 같이 잘라냄
    const el = $("div3").detach();
    $("area4").append(el);

})

// detach() 버튼
$("#btn2-3").on("click", function(){
    // detach() : 요소 잘라내기, 관련 이벤트도 같이 잘라냄
    const el = $("#div3").detach();
    $("#area4").append(el);
})