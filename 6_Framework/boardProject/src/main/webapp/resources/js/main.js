const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']"); // 후손 중

const memberPw = document.querySelector("#loginFrm input[name='memberPw']"); // 후손 중



// 로그인 시도를 할 때
if(loginFrm != null){ // 로그인 되었을때는 존재안함

    loginFrm.addEventListener("submit", e => {
    
       // alert("로그인");
       // form태그 기본 이벤트 제거 -> e.preventDefault();
    
       // 이메일이 입력되지 않은 경우 
       if(memberEmail.value.trim().length == 0){
            alert("이메일을 입력해주세요.");

            memberEmail.value = "";
            memberEmail.focus();

            e.preventDefault();
            return;
       }

       // 비번이 입력되지 않은 경우 
       if(memberPw.value.trim().length == 0){
            alert("비밀번호를 입력해주세요.");
       
            memberPw.value = "";
            memberPw.focus();
       
            e.preventDefault();
            return;
        }


    })

}

// fetch() API : JS의 Promise 객체를 이용한 비동기 요청 방법으로 JS에서 기본 제공함
// Promise(약속) 객체 : 비동기 요청에 대한 처리가 완료되면 바로 결과를 제공하겠다고 약속
// fetch(가지고오다) API

// [get 방식 요청 작성 방법]
/* 
    fetch("요청주소") 
    
    // 지정된 주소로 GET방식 비동기 요청(ajax)
    // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가

    .then(response => response 파싱) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱
    
    .then(response 파싱 데이터 => {}); // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성

    .catch(e => {}) // 예외 발생시 처리할 내용을 작성 
*/


// 비동기로 이메일이 일치하는 회원의 닉네임 조회
function selectNickname(email){

    fetch("/selectNickname?email=" + email) // ?키=값 
    
    // 지정된 주소로 GET방식 비동기 요청(ajax)
    // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가

    .then(response => response.text()) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱
    
    .then(nickname => {console.log(nickname)}) // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성

    .catch(e => {console.log(e)}) // 예외 발생시 처리할 내용을 작성 
    
}

// 닉네임이 일치하는 회원의 전화번호 조회

const inputNickname = document.getElementById("inputNickname");
const btn1 = document.getElementById("btn1");
const result1 = document.getElementById("result1");

btn1.addEventListener("click", ()=>{

    // fetch() API를 이용해서 ajax(비동기 통신)


    // POST는 fetch("요청주소", {}) 이런식

    // GET 방식 요청
    fetch("/selectMemberTel?nickname=" + inputNickname.value)

    .then( resp => resp.text() )
    // resp : 응답 객체 (변수명이라 뭐라 적던 상관없다)
    // .then ( (resp) => {} ) << 원래 이건데 매개변수 하나라 ()생략, 한줄 + 전달 값 하나라 {} 생략되는 형식

    // resp.text() : 응답 객체 내용을 문자열로 변환하여 반환

    .then( tel => {
        /* 비동기 요청 후 수행할 코드 */
        result1.innerText = tel;
    } ) // 조회 결과를 result1에 출력

    // tel : 파싱되어 반환된 값이 저장된 변수 ( resp.text() )

    .catch( err => console.log(err));

})

// fetch() API를 이용한 POST 방식 요청

// 이메일을 입력 받아 일치하는 회원의 정보를 모두 조회

const inputEmail = document.getElementById("inputEmail");
const btn2 = document.getElementById("btn2");
const result2 = document.getElementById("result2");

btn2.addEventListener("click", ()=>{

    // POST 방식 비동기 요청
    //fetch( "요청주소", { 자바스크립트 객체(k:v) } )
    fetch("/selectMember", {
        method : "POST", // method : ??? 에서 method는 key로 인식되어서 "" 안붙여도 문자열로 인식됨
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({"email" : inputEmail.value}) 
        // json을 쓰는데 body는 js 객체 형식
        // JSON.stringify() : JS 객체 -> JSON
        // JSON.parse()     : JSON -> JS 객체 

    }) 
    
    .then( resp => resp.json() ) // 응답 객체를 매개변수로 얻어와서 파싱한다.
        // .json() -> js 객체로 반환
    
    .then( member => {
            console.log(member);

            // ul(#result2)의 내부 내용 모두 없애기
            result2.innerText = "";
                        // `` : 띄어쓰기, 줄바꿈, el 다 가능
            const li1 = document.createElement("li");
            li1.innerText = `회원번호 : ${member.memberNo}`;

            const li2 = document.createElement("li");
            li2.innerText = `이메일 : ${member.memberEmail}`;

            const li3 = document.createElement("li");
            li3.innerText = `닉네임 : ${member.memberNickname}`;

            const li4 = document.createElement("li");
            li4.innerText = `전화번호 : ${member.memberTel}`;

            const li5 = document.createElement("li");
            li5.innerText = `주소 : ${member.memberAddress}`;

            const li6 = document.createElement("li");
            li6.innerText = `가입일 : ${member.enrollDate}`;

            result2.append(li1, li2, li3, li4, li5, li6);



    })// 파싱한 데이터를 이용해서 비동기 처리 후 동작

    .catch( err => { 
        console.log(err)
        result2.innerText = "일치하는 회원이 없습니다.";
    }) // ( (err) => {return console.log(err)})


})


// 이메일이 일부라도 일치하는 모든 회원 조회
const input = document.getElementById("input");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

// post방식은 json으로 보내는데 문자열 하나로도 보낼 순 있긴 함
btn3.addEventListener("click", ()=>{
    // 조회는 보통 Get 으로 함

    fetch("/selectMemberList",{
        method : "POST",            // text -> 데이터 하나만 보낼 수 있음
        headers : {"Content-Type" : "application/text"}, // 문자열 하나를 파라미터로 전달
        body : input.value // 보내질 문자열 하나

    })

    .then( resp => resp.json() )

    .then( memberList => {
        console.log(memberList);

        result3.innerHTML = "";

        // 향상된 for문으로 memberList 순차 접근
        for(let member of memberList){
            
            const tr = document.createElement("tr");
            const td1 = document.createElement("td");
            td1.innerText = `${member.memberNo}`;

            const td2 = document.createElement("td");
            td2.innerText = `${member.memberEmail}`;

            const td3 = document.createElement("td");
            td3.innerText = `${member.memberNickname}`;

            tr.append(td1, td2, td3)
            result3.append(tr);

        }

        if(memberList.length == 0){
            result3.innerText = "조회 결과가 없습니다.";
        }

    })

    .catch(err => {
        console.log(err)
    })

})



