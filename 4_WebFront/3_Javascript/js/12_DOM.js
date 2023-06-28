// Node 확인하기

document.getElementById("btn1").addEventListener("click",function(){

    // #test의 자식 노드를 모두 얻어오기
    // - 요소.childNodes : 요소의 자식 노드를 모두 반환
    const nodeList = document.getElementById("test").childNodes;

    console.log(nodeList);

    // 노드 탐색

    // 1) 부모 노드 탐색 : parentNode
    const li1 = document.getElementById("li1");
    console.log(li1.parentNode);

    // 부모 노드의 배경색 변경
    li1.parentNode.style.backgroundColor = "red";

    // 부모 노드 마지막에 새로운 노드 추가(append : (마지막에)덧붙인다.)
    li1.parentNode.append("ABCD");

    // 2) 첫 번째 자식 노드 탐색 : firstChild
    console.log(document.getElementById("test").firstChild);

    // 3) 마지막 자식 노드 탐색 : lastChild
    console.log(document.getElementById("test").lastChild); // 추가된 "ABCD"

    // 4) 중간에 존재하는 자식 노드 탐색 : 부모요소.childNodes[인덱스 번호]

    console.log(document.getElementById("test").childNodes[7]);
    nodeList[11].append("1234");

    // 5) 이전 형제 노드 탐색 : previousSibiling
    //    다음 형제 노드 탐색 : nextSibiling

    console.log(nodeList[8].previousSibling);
    console.log(nodeList[8].nextSibling);

    // 노드 탐색을 위한 구문은 연달아서 사용이 가능하다.
    console.log(nodeList[8].previousSibling.previousSibling.previousSibling);

})

// Element 탐색 확인하기
document.getElementById("btn2").addEventListener("click", function(){

    // #test의 모든 자식 요소 반환
    const list = document.getElementById("test").children;

    console.log(list);

    // #test의 첫 번째 자식 요소
    document.getElementById("test").firstElementChild.style.backgroundColor = "orange";
    document.getElementById("test").lastElementChild.style.backgroundColor = "yellowgreen";

    // #test의 자식 중(list) 2번재 인덱스의 이전/다음 형제 요소

    list[2].previousElementSibling.addEventListener("click", function(){
        alert("2번 인덱스의 이전 형제 요소 클릭됨.");
    });
    
    list[2].nextElementSibling.addEventListener("click",function(){
        alert("2번 인덱스의 다음 형제 요소 클릭됨.")
    })

    console.log(prevEl(list[2]));
    console.log(prevEl(prevEl(list[2])));
    console.log(nextEl(list[2]));

})

// 이전 형제 요소 선택 함수
function prevEl(el){
    return el.previousElementSibling;
}

function nextEl(el){
    return el.nextElementSibling;
}

// innerHTML 버튼 클릭시

let count = 1; // 전역변수

document.getElementById("btn3-1").addEventListener("click", function(){

    if(count <= 10){
    document.getElementById("div3-1").innerHTML += "<div>"+ count +"</div>";
    
    count++;
    }
    
})


//ccreateElement 버튼 클릭 시

let count2 = 1;

document.getElementById("btn3-2").addEventListener("click",function(){

    const div = document.getElementById("div3-2");

    // createElement를 이용해서 div 요소 생성하기

    // document.createElement("태그명") : 해당 태그 요소를 생성해서 반환한다.

    const child = document.createElement("div"); // <div></div> 생성

    // 만들어진 div(child)에 내용 추가

    // #div3-2의 마지막 자식 요소를 추가하기

    if(count2 <= 10){

        child.innerText = count2++;
        
        div.append(child);
    }
})

document.getElementById("temp").addEventListener("click", function(){

    alert("temp");

})

document.getElementById("temp2").addEventListener("click", function(){

    alert("temp2");

})