var str = "JS 코드를 함수 내부가 아닌" 
            + "JS파일 또는 script 태그 밑에 바로 작성하면 html 렌더링시 바로 수행된다.";

console.log(str);
            
// 변수 선언 위치에 따른 구분
var num1 = 10; // 전역변수
num2 = 20; // 전역변수

var num1 = 20; // 자바에선 안댐

console.log("num1 : " + num1);
console.log("num2 : " + num2);

function test(){
    var num3 = 3; // function 지역변수
    num4 = 4; // 전역변수

    if(true){ // 무조건 if문 수행
        
        var num5 = 5; // function의 지역변수
        num6 = 6; // 전역변수
    }

    console.log("num5 : " + num5); // 여기서 사용해서 if에서 function의 지역변수가 됐다?

}

test();

console.log("num4 : " +  num4); // function 종료 후에도 사용가능
/* console.log("num3 : " +  num3); */ // 지역변수라 펑션 바깥에서 사용하면 오류난다.

/* console.log("num5 : " + num5); */
console.log("num6 : " + num6); // function 종료 후에도 사용가능

// 자료형 확인
function typeTest(){
    
    const typeBox = document.getElementById("typeBox");

    let temp; // 선언 후 값을 초기화 하지 않았음
    typeBox.innerHTML = "temp : " + temp; // 초기화 안하면 undefined

    const name = "김민석";

    // typeof 변수명 : 해당 변수의 자료형을 검사하는 연산자
    typeBox.innerHTML += "<br>name : " + name + " / " + typeof name;

    const gender = 'm';
    typeBox.innerHTML += "<br>gender : " + gender + " / " + typeof gender;
    // 자바스크립트는 char 자료형이 존재하지 않는다!
    // "", '' 모두 string 리터럴 표기법

    const age = 20;
    const height = 178.3;
    typeBox.innerHTML += "<br>age : " + age + " / " + typeof age;
    typeBox.innerHTML += "<br>age : " + height + " / " + typeof height;
    // 다 넘버다

    const isTrue = true;
       
    typeBox.innerHTML += "<br>isTrue : " + isTrue + " / " + typeof isTrue;
    // boolean

    // object

    // java ( {} 사용 )
    // int[] arr = {1,2,3,4,5}


    // javascript ([] 사용)
    
    const arr = [10, 30, 70, 50];

    typeBox.innerHTML += "<br>arr : " + arr + " / " + typeof arr;
    // 오브젝트 타입

    for(let i=0; i<arr.length; i++) {  
    typeBox.innerHTML += "<br>arr[" + i + "] = " + arr[i] ;
    }
    
    // 자바 스크립트 객체는 K:V (Map 형식)
    const user = {"id" : "user01" , "pw" : "pass01"};

    typeBox.innerHTML += "<br>user : " + user + " / " + typeof user;
    // user, id, pw = object 출력이 잘 안댐

    // 객체 내용 출력 방법 1
    typeBox.innerHTML += "<br>user.key1 : " + user.id; // 키에 작성된 값 : id
    typeBox.innerHTML += "<br>user.key2 : " + user.pw;

    // 객체 내용 출력 방법 2 (객체 전용 for문 => for...in)

    for(let key in user){
        // user 객체의 키(id, pw)를 반복할 때 마다 하나씩 얻어와 key 변수에 저장
        typeBox.innerHTML += "<br>user[" + key + "] : " + user[key];
                                        /* "id" : "user01" , 
                                           "pw" : "pass01" */
    }

    console.log(user); // 콘솔 출력시 보기가 더 좋다. 위처럼 작성할 필요가 없음.

    // function (함수도 자료형이다!)
    
    const sumFn = function (n1, n2){// 익명함수
    
        return n1+n2;
    }
    // 함수명이 없다 -> 익명함수  이렇게 쓰면 이 변수명(sumFn)이 함수명이 되는 것. => function sumFn

    // 함수명만 작성한 경우 -> 함수에 작성된 코드가 출력됨
    typeBox.innerHTML += "<br>sumFn : " + sumFn + " / " + typeof sumFn; // 타입 = 펑션

    // 함수명() 괄호를 포함해서 작성하는 경우 -> 함수를 호출해서 수행함. (return n1+n2;)
    typeBox.innerHTML += "<br>sumFn(10,20) : " + sumFn(10,20);
    
    // 
    typeBox.innerHTML += "<br>tempFn(30,sumFn) : " + tempFn(30, sumFn);

}

function tempFn(n3, fn){
    
    return n3 + fn(10, 20);

}





