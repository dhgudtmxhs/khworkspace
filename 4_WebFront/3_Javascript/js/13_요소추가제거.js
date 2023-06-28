document.getElementById("add").addEventListener("click",function(){

    const con = document.getElementById("container");

   /*  con.innerHTML += "<div class='row'><input type='number' class='in'> <span class='remove'>X</span></div>"; */

    const child1 = document.createElement("div");

    // 클래스 추가
    child1.classList.add("row");

    
    
    const child2 = document.createElement("input");

    child2.classList.add("in");

    // input의 type속성, 속성값 "number" 추가하기 (type = "number")

    // - 요소.setAttribute("속성", "속성값") : 요소에 속성/ 속성값 추가
    child2.setAttribute("type", "number");

    const child3 = document.createElement("span");

    child3.classList.add("remove");
    child3.innerHTML = "X";

    // span이 클릭 되었을 때에 대한 이벤트 동작 추가
    child3.addEventListener("click", function(){

        // 요소.parentElement : 부모요소
        // 요소.remove() : 요소를 제거한다.

        this.parentElement.remove(); // span.parent~

    })

    //------------------------------------------------------------

    // div 내부에(자식으로) input, span 순서대로 추가해주기

    // #container에 div를 마지막 자식으로 추가

    con.append(child1);
    child1.append(child2);
    child1.append(child3); // input이 닫는 태그가 없어서 child2가 아님

})

// 계산 버튼 클릭시 이벤트 동작

document.getElementById("calc").addEventListener("click",function(){

    // sum을 alert로 출력

    let sum = 0;
    
    // in 클래스 요소를 모두 얻어옴 -> 배열 형태

    const list = document.getElementsByClassName("in");

    // 배열용 향상된 for문()
    for(let input of list){
        // input에 작성된 값은 모두 string - > 숫자 변환 Number 필요
       sum += Number(input.value); 

       // Number("") == 0 빈칸은 0으로 변환되기 때문에 신경x

    }
    
    alert("합계 : " + sum);

})