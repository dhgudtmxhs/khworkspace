import React, { useState, useContext } from 'react';
import UserContext from '../contexts/UserContext';

const User = () => {

    // useContext(Context명) : 지정된 Context를 사용
    // -> 부모 컴포넌트에서 제공한 값을 꺼내 쓸 수 있다.
    const {user, temp} = useContext(UserContext); // user, temp 꺼내서 저장
    // UserContext에서 user를 꺼내서 변수 user에 저장

    //// useContext Hook을 사용하여 데이터를 가져옴

    console.log(user);
    console.log(temp);

    return(
        <ul>
            <li>{user.name}</li>
            <li>{user.email}</li>
        </ul>
    );
}

const Profile = () => {

    const [user, setUser] = useState(null);

    const print = () => {
        setUser({name:'김미영', email:'asdf@kh.or.kr'});
    }

    const temp = '임시 변수';
    return(

        /* UserContext가 감싸고 있는 자식 컴포넌트에게 <user/> 
           Context API를 이용해서 user를 제공    

            Context.Provider 컴포넌트를 이용해 하위 컴포넌트에게 데이터를 전달
        */
        <UserContext.Provider value = { {user, temp} }> {/* 전역변수를 태그로 쓰는것 */}
            <div>
                {/* 삼항 연산자를 이용한 컴포넌트 렌더링 제어(조건부 렌더링) */}
                {user != null ? (
                            <>
                                <User/>
                                <button onClick={()=>{setUser(null)}}>개인 정보 숨기기</button>
                            </>

                ) : (

                    <button onClick={print}>개인 정보 출력</button>

                )} {/*  */}

            </div>
        </UserContext.Provider>
        

    ); // 그냥 return 안에 <User/>를 넣어도 되는데 코드 많아지면 drilling의 문제때문에 context API 사용해 본 것

}

export default Profile;