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
    // resp : 응답 객체 (변수명이라 뭐라 적던 상관없다??)
    // .then ( (resp) => {} ) << 원래 이건데 매개변수 하나라 ()생략, 전달 값 하나라 {} 생략되는 형식

    // resp.text() : 응답 객체 내용을 문자열로 변환하여 반환

    .then( tel => {
        /* 비동기 요청 후 수행할 코드 */
        result1.innerText = tel;
    } ) // 조회 결과를 result1에 출력

    // tel : 파싱되어 반환된 값이 저장된 변수 ( resp.text() )

    .catch( err => console.log(err));

})