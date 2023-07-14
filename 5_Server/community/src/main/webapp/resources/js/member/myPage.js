/* 
const btn = document.getElementById("info-update-btn");
const nickname = document.getElementsByName("memberNickname")[0];
const tel = document.getElementsByName("memberTel")[0];



function infoValidate(){

    if(nickname.value.trim().length == 0){
        alert("닉네임을 입력해주세요.");
        
        nickname.value="";
        nickname.focus();

        return false;
    }

    if(tel.value.trim().length == 0){
        alert("전화번호를 입력해주세요.");

        tel.value="";
        tel.focus();

        return false;
    }

}

nickname.addEventListener("keyup",function(){

    const nickRegtest = document.getElementById("nickRegTest");

    const regExp = /^([ㄱ-힇]|\w|[0-9]){2,10}$/;

    if(regExp.test(nickname.value)){

        nickRegtest.innerHTML = "유효성 맞음";

    }else{

        nickRegtest.innerHTML = "닉네임은 영어/숫자/한글 2~~10 글자 사이로 작성해주세요."
        nickname.focus();
        return false;

    }

})

tel.addEventListener("keyup",function(){

    const telRegtest = document.getElementById("telRegTest");

    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if(regExp.test(tel.value)){

        telRegtest.innerHTML = "유효성 맞음";

    }else{

        telRegtest.innerHTML = "전화번호 형식이 올바르지 않습니다."
        tel.focus();
        return false;

    }
    return true;

}) */

// 내 정보 수정 유효성 검사
function infoValidate(){

    const memberNickname = document.getElementById("memberNickname");
    const memberTel = document.getElementById("memberTel");

    const regExp1= /^[a-zA-Z0-9가-힣]{2,10}$/; // 닉네임 정규식
    const regExp2= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;  // 전화번호 정규식

    // 닉네임 유효성 검사
    if(memberNickname.value.length == 0){ // 미작성 시 : 닉네임을 입력해주세요.
        alert("닉네임을 입력해주세요.");
        memberNickname.focus();
        return false;
    }

    if(!regExp1.test(memberNickname.value)){ // 유효하지 않은 경우
        alert("닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요.");
        memberNickname.focus();
        return false;
    }


    // 전화번호 유효성 검사
    if(memberTel.value.length == 0){ // 미작성 시 : 전화번호를 입력해주세요.(-제외)
        alert("전화번호를 입력해주세요.(-제외)");
        memberTel.focus();
        return false;
    }

    if(!regExp2.test(memberTel.value)){ // 유효하지 않은 경우
       // alert("전화번호 형식이 올바르지 않습니다.");
       // memberTel.focus();
       // return false;

        return printAlert(memberTel, "전화번호 형식이 올바르지 않습니다.");
    }

    return true; // true를 반환해서 form 제출 수행
}

// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el은 요소
    alert(message);
    el.focus;
    return false;
}

function changePwValidate(){

    const currentPw = document.getElementById("currentPw");
    const newPw = document.getElementById("newPw");
    const newPwConfirm = document.getElementById("newPwConfirm");
    
   /*  const regExp1 = /^(\w|\!|\@|\#|\-|\_){6,30}$/; */
    const regExp1 = /^[\w!@#_-]{6,30}$/; 

    if(currentPw.value.trim().length == 0){
        return printAlert(currentPw, "현재 비밀번호를 입력해주세요.");
    }

    if(newPw.value.trim().length == 0){
        return printAlert(newPw, "새 비밀번호를 입력해주세요.");
    }

    if(!regExp1.test(newPw.value)){
        return printAlert(newPw, "영어, 숫자, 특수문자(!,@,#,-,_) 6글자 사이로 작성해주세요.");
    }

    if(newPwConfirm.value.trim().length == 0){
        return printAlert(newPwConfirm, "새 비밀번호 확인을 입력해주세요.");
    }

    if(newPw.value != newPwConfirm.value){
        alert("새 비밀번호가 일치하지 않습니다.");
        return false; 
        // return printAlert(newPwConfirm, "새 비밀번호가 일치하지 않습니다.");
    }

    return true;

}

//회원 탈퇴 유효성 검사

function secessionValidate(){
    
    const memberPw = document.getElementsByName("memberPw")[0];
    const agree = document.getElementById("agree");

    if(memberPw.value.trim().length == 0){
        
        return printAlert(memberPw, "비밀번호를 입력해주세요.");

    }

    if(!agree.checked){

        return printAlert(agree, "약관 동의 후 탈퇴버튼을 클릭해주세요.");
    }

    // [window.]confirm("내용") : 대화상자에 확인/취소 생성
    //  -> 확인 클릭 시 true / 취소 클릭 시 false

    if(!(memberPw.value.trim().length == 0) && agree.checked){
        // if문 안써도 됨
        
        const str = "정말 탈퇴하시겠습니까?";

        if(!confirm(str)){
            return false;
        }else{
            return true;
        }

    }

}

