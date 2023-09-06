import './App.css'; // ./ 같은폴더

// component 폴더의 Exam.js를 가져와서 사용
// 사용할 때 이름을 Ex1으로 지정
//import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';

import PropsEx from './components/R01.props.js';

import State1 from './componets/R02_state1.jsn';
import State2 from './components/R03_state2.js';

import { Component } from 'react';

function App() {
  // 리액트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다. 
  // 여러 요소로 반환하고 싶을 때는 부모요소 반환
  return (
  /* fragment(<></>) 반환 요소를 감쌀 때 사용, 해석 x*/
    
    <>

      {/* JSX 주석 */}
      <h1>hello react</h1>
      <div>리액트</div>

      {/* <Ex1/> */}
      {/* <Ex2/> */}

      {/* <PropsEx name={'홍길동'}/> */}
      {/* <PropsEx name={'김길동'}/> */}
      {/* <PropsEx name={'이길동'}/> */}

      {/* R02_state1 */}
      <State1/>
      {/* R02_state2 */}
      <State2 init={100}/>

    </>
    
  );
}

export default App;
