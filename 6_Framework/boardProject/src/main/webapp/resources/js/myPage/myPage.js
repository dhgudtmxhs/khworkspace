// 내 정보 수정 페이지

const memberNickname = document.getElementById("memberNickname");
const memberTel = document.getElementById("memberTel");
const updateInfo = document.getElementById("updateInfo");

// 내 정보 수정 form태그가 존재 할 때 --> 내정보 페이지 
// form안에 다 담겨있으니 form으로 조건문을 걸어준다.
if(updateInfo != null){

    // 전역변수로 (const, let, var 안쓰면) 수정 전 닉네임, 전화번호를 변수에 저장
    initNickname = memberNickname.value;    
    initTel = memberTel.value;

    memberNickname.addEventListener("input", ()=>{

        // 변경 전 닉네임과 입력 값이 같을 경우
        if(initNickname == memberNickname.value){
            memberNickname.removeAttribute("style"); // 스타일 속성을 remove
            return;
        }

        // 정규 표현식으로 유효성 검사
        const regEx = /^[가-힇\w]{2,10}$/

        if(regEx.test(memberNickname.value)){ 

            memberNickname.style.color = "green";

        }else{

            memberNickname.style.color = "red";
        }

    })


    memberTel.addEventListener("input", ()=>{

        // 변경 전 전화번호와 입력 값이 같을 경우
        if(initTel == memberTel.value){
            memberTel.removeAttribute("style");
            return;
        }

        const regEx = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/

        if(regEx.test(memberTel.value)){

            memberTel.style.color = "green";

        }else{

            memberTel.style.color = "red";

        }


    })

    // form 태그 제출 시 유효하지 않은 값이 있으면 제출 안되게끔

    updateInfo.addEventListener("submit", e=>{ // 매개변수 하나면 괄호생략 가능 (e)=> // 익명함수

        if(memberNickname.style.color == "red"){
            
            alert("유효한 닉네임을 입력해주세요.");
            e.preventDefault();
            memberNickname.focus();
            return;

        }

        if(memberTel.style.color == "red"){

            alert("유효한 전화번호를 입력해주세요.");
            e.preventDefault();
            memberTel.focus();

        }

    })

} // info


// changePw
const changePwFrm = document.getElementById("changePwFrm");
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

// 비밀번호 변경 페이지 인 경우

// 현재 비밀번호 미작성 시 

if(changePwFrm != null){

    changePwFrm.addEventListener("submit", e=>{

        if(currentPw.value.trim().length == 0){

            alert("현재 비밀번호를 입력해주세요.");
            e.preventDefault();
            currentPw.focus();
            currentPw.value = "";
            return;

        }

        if(newPw.value.trim().length == 0){

            alert("새 비밀번호를 입력해주세요.");
            e.preventDefault();
            newPw.focus();
            newPw.value = "";
            return;

        }

        if(newPwConfirm.value.trim().length == 0){

            alert("새 비밀번호 확인을 입력해주세요.");
            e.preventDefault();
            newPwConfirm.focus();
            newPwConfirm.value = "";
            return;

        }



    
        // 비번 유효성 검사
        const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/
    
        if(regEx.test(newPw.value)){

            alert("비밀번호가 유효하지 않습니다.");
            e.preventDefault();
            newPw.focus();
            return;

        }
        
        // 비번, 비번확인이 같은지만 확인
        if(newPw.value != newPwConfirm.value){

            alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
            e.preventDefault();
            newPw.focus();
            return;


        }
    
    })

} // changePw



// secession
const secessionFrm = document.getElementById("secessionFrm");
const memberPw = document.getElementById("memberPw");
const agree = document.getElementById("agree");
const agreeLabel = document.getElementById("agreeLabel");

if(secessionFrm != null){
   
    secessionFrm.addEventListener("submit", e=>{

        // 비밀번호 미작성
        if(memberPw.value.trim().length == 0){ // memberPw.value.trim() == ""

            alert("비밀번호를 입력해주세요.");
            e.preventDefault();
            memberPw.focus();
            memberPw.value = "";
            return;

        }    

        // 동의 체크
        if(!agree.checked){
            alert("약관에 동의해주세요.");
            e.preventDefault();
            // agree.focus(); 
            // checkbox에는 focus를 주기 위해서는 checkbox의 label 요소에 포커스를 줄 수 있습니다. 
            agreeLabel.focus(); // spacebar로 확인
            return;

        }

        // confirm
        if (confirm("진짜 탈퇴하시겠습니까?") != true) {
            alert("탈퇴 취소");
            e.preventDefault();
            return;
        }

    })    



}    








