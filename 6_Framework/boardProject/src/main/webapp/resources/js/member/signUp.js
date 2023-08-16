// 회원가입 js

/* 정규 표현식(Regular Expression)
    https://regexper.com/
    https://regexr.com/
    https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/%EC%A0%95%EA%B7%9C%EC%8B%9D

    - 특정한 규칙을 가진 문자열 집합을 표현하는데 사용하는 형식 언어
    - 문자열에 대한 검색, 일치 여부, 치환 등을 수행할 수 있음


    *** JS 정규표현식 객체 생성 방법 ***

    1.  const regEx = new RegExp("정규표현식");
    2.  const regEx = /정규표현식/;


    *** 정규표현식 객체가 제공하는 메서드(함수) ***
    1.  regEx.test(문자열)
        -> 문자열이 정규표현식 패턴에 부합하면 true, 아니면 false

    2.  regEx.exec(문자열)
        -> 문자열이 정규표현식 패턴에 부합하면
            첫 번째 매칭되는 문자열을 반환,
            없으면 null 반환


     *** 정규 표현식의 메타 문자***
        
    문자열의 패턴을 나타내는 문자.
    문자마다 지정된 특별한 뜻이 담겨있다.
    
    a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
    [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
    ^(캐럿) : 문자열의 시작을 의미
    $(달러) : 문자열의 끝을 의미

    \w (word, 단어) : 아무 글자(단, 띄어쓰기, 특수문자, 한글 X)
    \d (digit, 숫자) : 아무 숫자(0~9 중 하나)
    \s (space, 공간) : 아무 공백 문자(띄어쓰기, 엔터, 탭 등)

    [0-9]  : 0부터 9까지 모든 숫자
    [ㄱ-힣] : ㄱ부터 힣까지  모든 한글

    [가-힣] : 가부터 힣까지  모든 한글(자음만, 모음만 있는 경우 제외)

    [a-z] : 모든 영어 소문자
    [A-Z] : 모든 영어 대문자

    * 특수문자의 경우 각각을 입력하는 방법밖엔 없음
    단, 메타문자와 중복되는 특수문자는 
    앞에 \(백슬래시)를 추가하여 탈출 문자(Escape)로 만들어 사용

    * 수량 관련 메타 문자
    a{5} : a문자가 5개 존재 == aaaaa
    a{2,5} : a가 2개 이상 5개 이하 ==  aa, aaa, aaaa, aaaaa
    a{2,} : a가 2개 이상
    a{,5} : a가 5개 이하


    * : 0개 이상 == 0번 이상 반복 == 있어도되고, 없어도 되고

    + : 1개 이상 == 1번 이상 반복

    ? : 0개 또는 1개

    . : 1칸 (개행문자를 제외한 문자 하나)
*/

// JS 객체 : {"K" : V, "K" : V } (map 형식)

// 특징
// 1) 원하는 value를 얻어오는 방법
//   - 객체명.key
//   - 객체명["key"]

// 2) 객체에 특정 key가 존재하지 않으면 추가할 수 있다.
// ex) const obj = { "a" : 1, "b" : 2, "c": 3 }

// 3) 객체에 특정 key를 삭제할 수 있다 (delete 연산자)
// ex) const obj = {"a" : 1, "b" : 2}
//     delete obj.b; -> {"a" : 1 }

/* 유효성 검사진행여부 확인용 객체 */
// -> 모든 value가 true인 경우에만 회원가입 진행
const checkObj = {
        "memberEmail" : false,
        "memberPw" : false,
        "memberPwConfirm" : false,
        "memberNickname" : false,
        "memberTel" : false
};

// 이메일 유효성 검사

const memberEmail = document.getElementById("memberEmail");

const emailMessage = document.getElementById("emailMessage");

// 이메일이 입력 될 때 마다 검사
memberEmail.addEventListener("input", () => {

       // 입력된 이메일이 없을 경우
       if(memberEmail.value.trim().length == 0){
                memberEmail.value = "";
                emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
                emailMessage.style.color = "black"; // remove confirm, error
                checkObj.memberEmail = false;
                return;
        }
        // 화살표 함수는 자신만의 this를 가지지 않고, 외부 스코프의 this를 그대로 사용합니다.
        // 따라서 이 경우에는 addEventListener 함수가 속한 객체를 가리키게 됩니다.

        // addEventListener의 콜백 함수 안에서 this를 사용해 memberEmail에 접근할 수 없습니다.
        // 이를 해결하기 위해서는 다른 방법을 사용해야 합니다.
        // 예를 들어, memberEmail을 전역 변수로 선언하고, 
        // memberEmail을 이벤트 리스너 함수 외부에서도 접근할 수 있도록 처리할 수 있습니다.

        // 화살표 함수에서의 this는 일반적으로 상위 스코프의 this 값을 그대로 가리킵니다. 
        // 만약 화살표 함수가 전역 스코프에서 선언되었다면, this는 전역 객체인 window를 가리키게 됩니다. 

        // 정규 표현식을 이용해서 유효한 형식인지 판별
        // 1) 정규 표현식 객체 생성
        const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힇\w\-\+]+(\.\w+){1,3}$/ // {4,} -> 4글자 이상 // + -> 1번이상 반복

        // 2) 입력 받은 이메일과 정규식 일치 여부 판별
        
        if(regEx.test(memberEmail.value)){ // 유효한 경우

                emailMessage.innerText = "이메일이 유효합니다.";
                emailMessage.style.color = "green"; // or classList.add && error
                checkObj.memberEmail = true; 

        } else { // 유효하지 않은 경우

                emailMessage.innerText = "이메일이 유효하지 않습니다.";
                emailMessage.style.color = "red";
                checkObj.memberEmail = false;

        }

})


// 비밀번호/비밀번호 확인 유효성 검사
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm"); 
const pwMessage = document.getElementById("pwMessage");

memberPw.addEventListener("input", ()=> {

        // 비번 입력 안된경우
        if(memberPw.value.trim().length == 0){

                memberPw.value ="";
                checkObj.memberPw = false;
                pwMessage.innerText = "영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.";
                pwMessage.style.color = "black"; // classList.add or remove
                
                return;
        }

        const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/

        // 비번 유효한 경우
        if(regEx.test(memberPw.value)) { // 비번 유효
                
                checkObj.memberPw = true;

                // 비밀번호가 유효하게 작성된 상태에서
                // 비밀번호 확인이 입력되지 않았을 때
                if(memberPwConfirm.value.trim().length == 0){

                        pwMessage.innerText = "유효한 비밀번호 형식입니다.";
                        pwMessage.style.color = "green";
                }else{
                        // 비밀번호가 유효하게 작성된 상태에서
                        // 비밀번호 확인이 입력되어 있을 때

                        // 비밀번호 == 비밀번호 확인 (같을 경우)
                        if(memberPw.value == memberPwConfirm.value){

                                checkObj.memberPwConfirm = true;
                                pwMessage.style.color = "green";
                                pwMessage.innerText = "비밀번호, 비밀번호 확인이 모두 유효합니다.";

                        }else{ // 다른 경우

                                checkObj.memberPwConfirm = false;
                                pwMessage.style.color = "red";
                                pwMessage.innerText = "비밀번호, 비밀번호 확인이 일치하지 않습니다."

                }

                }

        }else{ // 비번이 유효하지 않을 때

                pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다.";
                pwMessage.style.color = "red";
                checkObj.memberPw = false;

        }

})

// 비밀번호 확인 유효성 검사
memberPwConfirm.addEventListener("input", ()=> {
        if(checkObj.memberPw){ // 비밀번호가 유효하게 작성된 경우에

                // 비밀번호 == 비밀번호 확인 (같을 경우)
                if(memberPw.value == memberPwConfirm.value){

                        checkObj.memberPwConfirm = true;
                        pwMessage.style.color = "green";
                        pwMessage.innerText = "비밀번호, 비밀번호 확인이 모두 유효합니다.";

                }else{ // 다른 경우

                        checkObj.memberPwConfirm = false;
                        pwMessage.style.color = "red";
                        pwMessage.innerText = "비밀번호, 비밀번호 확인이 일치하지 않습니다."

                }

                if(memberPwConfirm.value.trim().length == 0){

                        checkObj.memberPwConfirm = false;
                        pwMessage.style.color = "red";
                        pwMessage.innerText = "비밀번호 확인란을 작성해주세요.";

                        return;
                }

        }else{ // if(!checkObj.memberPw)

                checkObj.memberPwConfirm = false;
                alert("비밀번호부터 유효하게 작성해주세요.");
                memberPwConfirm.value = "";
                pwMessage.style.color = "red";
                memberPw.focus();

        } 

})

// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nickMessage = document.getElementById("nickMessage");

memberNickname.addEventListener("input", ()=>{

        // 입력 안된 경우
        if(memberNickname.value.trim().length == 0){
                checkObj.memberNickname = false;
                nickMessage.innerText = "한글,영어,숫자로 2~10글자 입력해주세요.";
                nickMessage.style.color = "black";
                memberNickname.value = "";
                return;
        }

        const regEx = /^[가-힇\w]{2,10}$/

        if(regEx.test(memberNickname.value)){

                checkObj.memberNickname = true;
                nickMessage.innerText = "닉네임이 유효합니다.";
                nickMessage.style.color = "green";

        }else{

                checkObj.memberNickname = false;
                nickMessage.innerText = "닉네임이 유효하지 않습니다.";
                nickMessage.style.color = "red"; 

        }

})

// 전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

memberTel.addEventListener("input", ()=>{

        if(memberTel.value.trim().length == 0){

                checkObj.memberTel = false;
                telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";
                telMessage.style.color = "black";
                memberTel.value = "";
                return;
        }

        const regEx = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/

        if(regEx.test(memberTel.value)){

                checkObj.memberTel = true;
                telMessage.innerText = "전화번호가 유효합니다.";
                telMessage.style.color = "green";
        }else{

                checkObj.memberTel = false;
                telMessage.innerText = "전화번호가 유효하지 않습니다.";
                telMessage.style.color = "red";
        }
})


// 회원가입 form태그가 제출되었을 때
/* const signUpBtn = document.getElementById("signUpBtn");

signUpBtn.addEventListener("click",function(){}) */

const signUpFrm = document.getElementById("signUpFrm");

signUpFrm.addEventListener("submit", e=> {

        // CheckObj에 모든 value가 true인지 검사

        // (배열용 for문)
        // for ... of : 향상
        //      -> iterator(반복자) 속성을 지닌 배열, 유사 배열 사용 가능

        // (객체용 for문)
        // for ... in : 향상
        // -> JS 객체가 가지고 있는 key를 순서대로 하나씩 꺼내는 반복문


        for(let key in checkObj){

            if(!checkObj[key]){ // 각 key에 대한 value(true/false)를 얻어와
                  // false인 경우 == 유효하지 않다

                switch(key){
                        case "memberEmail"     : alert("이메일이 유효하지 않습니다."); break;
                        case "memberPw"        : alert("비밀번호가 유효하지 않습니다."); break;
                        case "memberPwConfirm" : alert("비밀번호가 확인되지 않았습니다."); break; 
                        case "memberNickname"  : alert("닉네임이 유효하지 않습니다."); break;
                        case "memberTel"       : alert("전화번호가 유효하지 않습니다."); break;
                }
                // 객체 안의 걸 가져오는거임. "" 빼면 const 담아놓은걸 가리키게 됨
               
                document.getElementById(key).focus();

                e.preventDefault();

                return false;

            }     

        }

})










