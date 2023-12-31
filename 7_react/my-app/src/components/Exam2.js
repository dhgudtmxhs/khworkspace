import React, { useState } from 'react'; 
// React는 표준
// from 'react'는 react 라이브러리를 가져온다 -> 기본 내보내기 -> 전부 다가져옴
// {useState} 는 라이브러리 안의 특정 함수만을 가져온다. -> 명명된 내보내기 -> useState 함수 만을 가져옴

// 그냥 from 'react'하면 다가져오는데 왜 {} 로 하나만 가져옴??
// 코드베이스를 깨끗하게 유지하고 잠재적인 충돌이나 사용되지 않는 코드를 최소화하는 데 
// 필요한 라이브러리의 특정 부분만 가져오는 것이 일반적입니다. << 아닌듯?

// 함수형 컴포넌트
// 1. 함수 생성하기
// 2. return 구문에 출력하고자 하는 html 코드 작성
// 3. 만든 함수를 export default 지정
function Exam2(){

    const [count, setCount] = useState(100);
    // count라는 변수에 초기값 100 대입
    // count 값(상태)를 변경할 때는 setCount 함수를 이용

    const handleClick = () => {
        setCount( () => count -1 ) // {return count -1}

    }

    return(

        <>
            <h2>함수형 컴포넌트</h2>
            <h1>Count : {count}</h1>
            <button onClick={handleClick}>Decrement</button>
        </>

    // {handleClick()}과 같은 JSX 이벤트 핸들러 내에서 직접 '()'를 사용하여 함수를 호출하지 않는 이유는 
    // 이렇게 하면 이벤트가 발생할 때가 아니라 구성 요소가 렌더링될 때 함수가 즉시 호출되기 때문입니다. 

    // 이와 같이 이벤트 핸들러를 정의할 때 '()'를 포함하면 실제로 버튼을 클릭할 때가 아니라 
    // 구성 요소가 렌더링될 때 즉시 'handleClick' 함수를 호출하게 됩니다. 
    // 이는 사용자 작업에 대한 응답이 아니라 구성 요소가 렌더링되자마자 함수를 실행하기 때문에 일반적으로 원하는 것이 아닙니다.
    // 구성 요소가 렌더링된다 라는 말은 React 또는 다른 프론트엔드 프레임워크/라이브러리에서 
    // 컴포넌트가 화면에 나타나거나 표시되는 것을 의미합니다. 

    // 컴포넌트 : React 애플리케이션은 작은 독립적인 조각들인 "컴포넌트"로 구성됩니다. 각 컴포넌트는 UI의 일부를 정의하고 상호작용을 처리합니다. 
    // 예를 들어, 버튼, 텍스트 입력, 목록, 레이아웃 등이 모두 컴포넌트로 표현될 수 있습니다.

    // 렌더링: 렌더링은 컴포넌트가 화면에 표시되는 프로세스를 가리킵니다.
    // 즉, 컴포넌트의 내용과 UI가 사용자에게 보여지는 것을 말합니다.

    // 렌더링의 주체 : 렌더링은 주로 React나 다른 UI 라이브러리/프레임워크에 의해 관리됩니다. 
    // 이러한 도구들은 컴포넌트의 상태나 속성(props) 변경에 따라 UI를 업데이트하고 화면에 다시 그립니다.

    // 렌더링의 트리거 - 컴포넌트가 렌더링되는 주요 이유는 다음과 같습니다.
    // - 초기 로딩 : 앱이 시작될 때 초기 UI를 렌더링합니다.
    // - 상태(state) 변경 : 컴포넌트의 상태가 변경될 때 해당 컴포넌트 또는 관련 컴포넌트가 다시 렌더링됩니다.
    // - 속성(props) 변경 : 부모 컴포넌트로부터 전달된 속성(props)이 변경될 때 자식 컴포넌트가 다시 렌더링됩니다.
    // - 사용자 상호작용 : 사용자의 동작(예: 버튼 클릭, 양식 제출)에 따라 UI를 업데이트하기 위해 렌더링됩니다.

    // <button onClick={handleClick()}>Decrement</button> 를 하면 
    // 해당 함수는 컴포넌트 렌더링 시에 즉시 실행되며, 이로 인해 예기치 않은 동작이 발생하거나 오류가 발생할 수 있습니다.
    // -> 해보니까 화면에 아무것도 안나옴
    // React 컴포넌트의 렌더링 시에 함수를 즉시 실행하는 것은 일반적으로 원하지 않는 동작이며, 
    // 함수를 호출하지 않고 함수의 참조만을 'onClick' 이벤트 핸들러에 할당하는 것이 올바른 방법입니다.

    );

}

export default Exam2;