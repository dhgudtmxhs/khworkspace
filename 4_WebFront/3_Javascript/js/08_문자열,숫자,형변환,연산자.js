// 문자열 관련 함수

document.getElementById("btn1").addEventListener("click",function(){

    // 문자열.indexOf("str") : 
    // 문자열에서 "str"과 일치하는 부분이 시작되는 인덱스를 반환
    // 없으면 -1 반환

    const str1 = "Hello World";

    console.log(str1.indexOf("e")); //1
    console.log(str1.indexOf("l")); //2 (가장 먼저 검색된 인덱스 반환)
    console.log(str1.indexOf("가")); //-1

    // 문자열.substring(시작인덱스, 종료인덱스(미포함)) : 문자열 일부 잘라내기
    // - 시작 인덱스 이상, 종료 인덱스 미만
    const str2 = "abcdefg";

    console.log(str2.substring(0, 3)); // abc
                            /* 0, 1, 2 (3은 미포함) */

    console.log(str2.substring(2, 6));

    // 문자열.split("구분자") : 문자열을 "구분자"로 잘라서 배열로 반환한다.

    const str3 = "햄버거, 비빔밥, 김밥, 라면, 파스타, 스테이크";

    const arr = str3.split(", "); /* 각각의 인덱스가 됐다 */

    console.log(arr);

    for(let i=0; i<arr.length; i++){
        console.log(arr[i]); // arr=str3.split(", ")
    }

})

// 숫자 관련 함수

document.getElementById("btn2").addEventListener("click", function(){

    // Infinity 리터럴 확인
    console.log( 5 / 0 );

    if(5/0 == Infinity){
        console.log("무한입니다.");
    }

    // NaN 리터럴 확인 낫 오브 넘버
    console.log("aaa" * 100);

    /* "aaa" * 100 == NaN 실행 안댐*/
    // NaN 은 isNaN(값) 으로 함 값이 NaN = true, 아니면 false

    if(isNaN("aaa" * 100)){
        console.log("숫자가 아닙니다.");
    }

    // Math.random() : 0이상 1미만의 난수 발생( 0 <= random < 1 )
    //this.innerText = Math.random();

    // 소수점 관련 함수
    // round(), ceil(), floor(), trunc()

    // -> 소수점 자리를 지정할 수 없다.

    console.log(Math.round(10.5));
    console.log(Math.ceil(10.5));
    console.log(Math.floor(-10.5));
    console.log(Math.trunc(-10.5));

    // 버튼 배경색 랜덤으로 바꾸기

    const r = Math.floor((Math.random() * 256));
    const g = Math.floor((Math.random() * 256));
    const b = Math.floor((Math.random() * 256));

    this.style.backgroundColor = "rgb(" + r +"," + g +", "+ b + ")";

    // 숫자.toFixed(자릿수) : 지정된 자릿수까지 반올림해서 표현
    // 정확한 소수점을 표현 x (부동소수점)
    console.log( (1.45.toFixed(1)) );
}) 

// 형변환 확인
document.getElementById("btn3").addEventListener("click",function(){
   
    console.log( parseInt(1.2345) ); // -> 1 정수로만 변환가능
    console.log( parseFloat(1.2345) ); // 정수-> 정수 실수->실수
    console.log( parseFloat("1.23") ); // 정수-> 정수 실수->실수
    console.log("1");
    console.log( Number("1.234") );

})