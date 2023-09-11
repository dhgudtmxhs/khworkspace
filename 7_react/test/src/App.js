import React, { useState} from 'react';
import './App.css';

function App() {

  const [signupView, setSignupView] = useState(false);

  return (
    <>
      <button onClick={() => {setSignupView(!signupView)}}>
        { signupView ? ('회원 가입 닫기') : ('회원 가입 열기') }
      </button>

      <div className='signup-wrapper'>
        {/* {signupView === true && (<Si)} */}

      </div>
    </>


  );
}

export default App;
