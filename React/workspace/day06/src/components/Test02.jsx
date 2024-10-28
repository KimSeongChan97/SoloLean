import React, { useReducer } from 'react';

// 초기 상태(initialState)를 'PINK'로 설정합니다. useReducer를 사용할 때의 기본 색상입니다.
const initialState = 'PINK';

// reducer 함수는 상태(state)와 액션(action)을 받아 새로운 상태를 반환합니다.
// 상태 변경을 어떻게 처리할지 결정하는 역할을 합니다.
const reducer = (state, action) => {
     // switch 문을 통해 action.type의 값에 따라 다른 색상을 반환하도록 처리합니다.
     // 각 case 문에 대응하는 색상이 state로 설정됩니다.
     switch(action.type){
          case 'RED' : return 'RED'; // 'RED' 타입을 받으면 상태를 'RED'로 변경
          case 'GREEN' : return 'GREEN'; // 'GREEN' 타입을 받으면 상태를 'GREEN'으로 변경
          case 'BLUE' : return 'BLUE'; // 'BLUE' 타입을 받으면 상태를 'BLUE'로 변경
          case 'PURPLE' : return 'PURPLE'; // 'PURPLE' 타입을 받으면 상태를 'PURPLE'로 변경
          case 'RESET' : return initialState; // 'RESET' 타입을 받으면 초기 상태로 돌아갑니다.
          default : return state; // 그 외의 액션 타입이 들어올 경우 현재 상태(state)를 그대로 반환
     }
};

const Test02 = () => {

     // useReducer 훅을 사용하여 상태와 디스패치 함수(dispatch)를 가져옵니다.
     // useReducer(reducer, initialState)는 reducer 함수와 초기 상태를 받아, 
     // 현재 상태인 color와 dispatch 함수를 반환합니다.
     const [color, dispatch] = useReducer(reducer, initialState);

     // 컴포넌트 렌더링
     return (
          <div>
               <h1 style={{ color: color }}> 색2 : { color } </h1>
               <p>
                    {/* 각 버튼 클릭 시, dispatch 함수로 액션을 전달하여 상태를 변경합니다. */}
                    {/* 버튼을 클릭할 때마다 지정된 type 값을 가진 객체가 dispatch에 전달되어 reducer에서 해당 type에 따라 색상을 변경 */}
                    <button onClick={() => dispatch({ type: 'RED' })}> 빨강 </button>
                    <button onClick={() => dispatch({ type: 'GREEN' })}> 초록 </button>
                    <button onClick={() => dispatch({ type: 'BLUE' })}> 파랑 </button>
                    <button onClick={() => dispatch({ type: 'PURPLE' })}> 보라 </button>
                    <button onClick={() => dispatch({ type: 'RESET' })}> 초기화 </button>
               </p>
          </div>
     );
};

export default Test02;
