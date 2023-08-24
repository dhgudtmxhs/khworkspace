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

// ------------------------------------------------------------------------

// 프로필 이미지 추가/변경/삭제
const profileImage = document.getElementById("profileImage"); // img 태그
const imageInput = document.getElementById("imageInput"); // input 태그
const deleteImage = document.getElementById("deleteImage"); // x 버튼

    // 프로필 이미지가 출력되는 img 태그의 src 속성을 저장

    let initCheck; // 초기 프로필 이미지 상태를 저장하는 변수
                   // false == 기본 이미지, true == 이전 업로드 이미지
    let deleteCheck = -1;
    // 프로필 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 변수
    // -1 == 초기값, 0 == 프로필삭제(x버튼), 1 == 새 이미지 업로드

    let originalImage; // 초기 프로필 이미지 파일 경로 저장

if(imageInput != null){ // 화면에 imageInput이 있을 경우에만

    originalImage = profileImage.getAttribute("src");

    // 회원 프로필 화면 진입 시
    // 현재 회원의 프로필 이미지 상태를 확인
    if(originalImage == "/resources/images/user.png"){ // 기본 이미지인 경우
        initCheck = false;
    }else{
        initCheck = true; 
    }

    // change 이벤트 : 값이 변했을 때
    // - input type="file", "checkbox", "radio" 에서 많이 사용
    // - text/number 형식 사용 가능
    //   -> 이 때 input값 입력 후 포커스를 잃었을 때
    //      이전 값과 다르면 change 이벤트 발생  

    imageInput.addEventListener("change", e => {

        const maxSize = 1 * 1024 * 1024 * 2; // 파일최대크기(Byte 단위) => 2MB 로 제한

        //console.log(e.target); // input
        //console.log(e.target.value); // 업로드된 파일 경로
        //console.log(e.target.files); // 업로드된 파일의 정보가 담긴 배열

        const file = e.target.files[0]; // 업로드한 파일의 정보가 담긴 객체 (file은 배열같은 형태임)

        // 파일을 한번 선택한 후 취소했을 때
        if(file == undefined){
            console.log("파일 선택이 취소됨");
            deleteCheck = -1; // 취소 == 파일 없음 == 초기상태
            
            // 취소시 기존 프로필 이미지로 변경
            profileImage.setAttribute("src", originalImage);

            return;
        }

        if(file.size > maxSize){ // 선택된 파일의 크기가 최대 크기를 초과한 경우

            alert("2MB 이하의 이미지를 선택해주세요.");
            e.target.value = ''; // 빈칸은 대입이 가능한데 직접 경로를 대입하면 에러남
            // input type="file" 태그에 대입할 수 있는 value는 "" (빈칸) 뿐이다.
            
            deleteCheck = -1;

            // 기존 프로필 이미지로 변경
            profileImage.setAttribute("src", originalImage);
            
            return;

        }

        const reader = new FileReader(); // 자바스크립트에서 파일을 읽는 객체
                                         // - 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있다.

        reader.readAsDataURL(file);
        // 매개변수에 작성된 파일을 읽어서 저장 후
        // 파일을 나타내는 URL을 result 속성으로 얻어올 수 있게 한다.

        // 다 읽었을 때
        reader.onload = e => { // 함수 호출하겠다.
            
            //console.log(e.target);
            //console.log(e.target.result); // 읽은 파일의 url

            const url =  e.target.result;

            // 프로필이미지(img) 태그에 src 속성으로 추가
            profileImage.setAttribute("src", url);

            deleteCheck = 1;

        }

    });

    // x버튼 클릭 시 if(imageInput != null) 안
    deleteImage.addEventListener("click", e => {

        profileImage.setAttribute("src", "/resources/images/user.png");
        // originalImage는 내 원래 사진이 담겨있기 때문에 삭제할때는 기본값으로 만들어줘야함
        imageInput.value = ''; // input type="file"의 value 삭제

        deleteCheck = 0;

    })

    // profileFrm이 제출 되었을 때 if(imageInput != null) 안
    document.getElementById("profileFrm").addEventListener("submit", e=> {

        // let initCheck; // 초기 프로필 이미지 상태를 저장하는 변수
        // false == 기본 이미지, true == 이전 업로드 이미지
        
        // let deleteCheck = -1;
        // 프로필 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 변수
        // -1 == 초기값, 0 == 프로필삭제(x버튼), 1 == 새 이미지 업로드

        // 제출하는 경우만 생각
        let flag = true;

        // 1) 프로필 이미지가 없다가 생김
        if(initCheck == false && deleteCheck == 1){
            flag = false;
        }
        
        // 2) 이전 프로필 이미지가 있다가 삭제
        if(initCheck == true && deleteCheck == 0){
            flag = false;
        }

        // 3) 이전 프로필 이미지가 있다가 새 이미지로 변경
        if(initCheck == true && deleteCheck == 1){
            flag = false;
        }

        if(flag){ // flag == true -> 제출 안되도록
            e.preventDefault();
            alert("이미지 변경 후 클릭하세요.");
        }

    })

}


