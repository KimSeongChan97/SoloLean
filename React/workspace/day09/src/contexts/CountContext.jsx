// CountContext를 생성하여 Context API를 사용할 준비를 한다.
// Context API는 계층 구조를 통해 데이터(여기서는 count와 관련 함수들)를 전역적으로 공유할 수 있게 해준다.
import React, { createContext, useState } from 'react';

// CountContext 객체 생성 - createContext()로 생성된 객체는 데이터 공급자와 소비자를 제공한다.
// Context는 여러 컴포넌트에서 데이터를 손쉽게 사용할 수 있게 하며, 일일이 props로 전달할 필요 없이 전역적으로 값을 전달할 수 있다.
export const CountContext = createContext();

// CountProvider 컴포넌트는 count 관련 상태와 함수들을 관리하며, 이를 하위 컴포넌트에게 전달하는 역할을 한다.
// 이 컴포넌트를 사용하는 컴포넌트들은 이 Provider 컴포넌트가 제공하는 count 상태와 관련 함수를 사용 가능하게 된다.
const CountProvider = (props) => {
     // count 상태와 이를 변경할 수 있는 setCount 함수 선언 - useState 훅을 사용하여 초기값은 0으로 설정
     // useState는 리액트에서 상태를 생성하고 관리하는 훅으로, 초기값을 설정하고 현재 상태와 이를 업데이트하는 함수(setter)를 반환한다.
     // count: 현재 카운트 값을 나타내는 변수 - count 변수는 현재 상태값을 담고 있어 화면에 표시할 값으로 사용된다.
     // setCount: count 값을 변경할 수 있는 함수 - setCount는 count 값을 업데이트할 수 있는 함수로, 이 함수를 통해 count 상태를 변경한다.
     const [count, setCount] = useState(0);

     // count 값을 1 증가시키는 함수 - increment 함수는 setCount 함수를 사용하여 현재 count 값에 1을 더한 값을 설정한다.
     // 이 함수는 버튼 클릭 시 호출되어 count 값을 증가시킨다.
     // setCount(count + 1)로 현재 count 값에 1을 더한 새 값을 설정하고 상태를 업데이트한다.
     const increment = () => {
          setCount(count + 1);
     };

     // count 값을 1 감소시키는 함수 - decrement 함수는 setCount 함수를 사용하여 현재 count 값에서 1을 뺀 값을 설정한다.
     // decrement는 count 값을 줄이는 역할을 한다. 이 함수는 하위 컴포넌트에서 호출되어 count 값을 감소시킨다.
     const decrement = () => {
          setCount(count - 1);
     };

     // CountContext.Provider는 Context를 하위 컴포넌트로 전달하는 역할을 한다.
     // value 속성에는 전달할 데이터와 함수들을 객체 형태로 포함시킨다.
     // 여기서는 count 상태와 increment, decrement 함수를 전달한다.
     // CountContext.Provider를 사용하여 count 상태와 이를 조작할 수 있는 함수들을 하위 컴포넌트에서 접근할 수 있도록 한다.
     return (
          <CountContext.Provider value={{ count, increment, decrement }}>
                    {/* children 은 부모 컴포넌트에서 자식 엘레먼트나 컴포넌트를 포함할 때 자동으로 전달된다. */}
                    {/* props.children은 CountProvider 컴포넌트 내에 정의된 자식 컴포넌트들을 의미하며,
                        CountContext.Provider에 의해 감싸지므로 모든 자식 컴포넌트가 count 데이터를 사용할 수 있다. */}
                    {/* CountProvider 내의 모든 자식 컴포넌트는 Provider에 의해 count 상태와 관련 함수들에 접근 가능해진다. */}
                    { props.children }
          </CountContext.Provider>
     );
};

// CountProvider 컴포넌트를 export하여 다른 파일에서 사용할 수 있도록 한다.
// 외부 파일에서도 CountProvider를 사용할 수 있게 하여 필요한 컴포넌트가 Context를 쉽게 사용할 수 있게 한다.
export default CountProvider;

