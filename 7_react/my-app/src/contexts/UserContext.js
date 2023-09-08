import React, { createContext } from 'react';

// createContext(초기값) : Context 생성
const UserContext = createContext();

export default UserContext;

// 💡 props drilling은 React 컴포넌트 구조에서 하위 컴포넌트로 데이터를 전달하기
// 위해 상위 컴포넌트를 거치는 것을 의미합니다.

// -> "Props drilling"은 React 컴포넌트 구조에서 상위 컴포넌트에서 하위 컴포넌트로 데이터를 전달하기 위해 
// 중간 단계의 컴포넌트를 거쳐야 하는 상황을 의미합니다. 
// 이것은 데이터가 컴포넌트 계층 구조를 따라 전파되는 프로세스를 설명하는 용어입니다.

// props drilling은 컴포넌트 구조가 깊어지면
// 코드가 복잡해지고 유지보수가 어려워지는 문제를 유발합니다. 
// Context API는 이러한 문제점을 해결하기 위한 방법 중 하나입니다.

// Context API는 React 컴포넌트 트리 전체에서 데이터를 공유할 수 있는 방법을 제공합니다. 
// 이를 통해 중첩된 구조에서 데이터를 전달하는 데 있어서 불필요한 props drilling을 방지할 수 있습니다.


/*  
    <App>
        <ParentComponent>
            <ChildComponent />
        </ParentComponent>
    </App>

    -> props drilling은 <app>이 <ChildComponent>에게 데이터를 전달하려면 <ParentComponent>를 거쳐야 함
    ->   context API는  React 컴포넌트 트리 전체에서 데이터를 공유 -> 중간을 거치치 않아도 됨
*/

// Context를 사용하기 위해서는 createContext() 함수를 사용하여 Context 객체를 생성해야합니다. 
// 이후 Context.Provider 컴포넌트를 이용해 하위 컴포넌트에게 데이터를 전달할 수 있습니다. 
// Provider는 value prop을 통해 데이터를 전달합니다.
// Consumer 컴포넌트를 이용하면 Provider에서 전달한 데이터를 사용할 수 있습니다.
// Consumer는 함수형 컴포넌트 또는 클래스 컴포넌트로 작성할 수 있습니다. 
// Context를 사용하는 컴포넌트는 Consumer를 이용해 데이터를 사용하거나, 
// useContext Hook을 사용하여 데이터를 가져올 수 있습니다.
// Context API는 Redux와 같은 상태 관리 라이브러리를 대체할 수는 없지만, 
// 단순한 상태 관리에는 편리하게 사용할 수 있습니다.