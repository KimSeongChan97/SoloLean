import React, { useReducer } from 'react';

// 초기 상태 객체로 초기 색상 값을 'pink'로 설정합니다.
// 초기 상태는 컴포넌트가 처음 렌더링될 때의 기본 색상을 의미합니다.
// initialState는 useReducer의 초기 상태값으로 사용되며, 필요에 따라 'RESET' 액션을 통해 원래 상태로 돌아갈 때 참조됩니다.
const initialState = { color: 'pink' };

// reducer 함수는 상태(state)와 액션(action)을 받아 새로운 상태를 반환합니다.
// 상태 변경의 로직이 포함되며, 어떤 액션이 발생했는지(action.type)에 따라 새로운 상태를 설정합니다.
// 이 함수는 여러 가지 액션 타입을 처리하며, 각 타입에 따른 상태 변화(즉, 색상 변경)를 정의합니다.
const reducer = (state, action) => {

     // action의 타입을 확인하고 그에 따른 상태 변경을 수행합니다.
     // switch 문을 통해 action.type이 특정 값일 때 어떤 동작을 할지 정의합니다.
     // action.type에 따라 다른 반환 값을 설정해 조건별로 동작을 분기시킵니다.
     switch(action.type){
          case 'CHANGE_COLOR' : 
               // 'CHANGE_COLOR' 액션을 수신할 때, action.text에 포함된 색상을 사용하여
               // 새로운 객체 { color: action.text }를 반환하여 색상을 업데이트합니다.
               return { color: action.text };
          case 'RESET' : 
               // 'RESET' 액션을 수신할 때, 초기 상태인 initialState를 반환하여
               // 현재 상태를 기본값으로 되돌립니다.
               return initialState;
          default : 
               // 정의되지 않은 액션 타입을 수신할 경우, 현재 상태를 그대로 반환하여
               // 불필요한 상태 변경을 방지합니다.
               return state;     
     }
};


const Test03 = () => {

     // useReducer 훅을 사용하여 상태와 디스패치 함수(dispatch)를 가져옵니다.
     // reducer와 initialState를 인자로 받아 현재 상태(state)와 상태 업데이트 함수(dispatch)를 반환합니다.
     // dispatch는 상태 업데이트를 트리거하는 함수로, 액션을 전달받아 reducer가 새로운 상태를 생성하도록 합니다.
     const [state, dispatch] = useReducer(reducer, initialState);
     // reducet -> action ( -> state ) -> dispatch
     // 상태 변화의 순서를 요약한 것으로, reducer가 액션을 받아 상태를 변경하고, 그 결과가 dispatch로 반영됨을 의미합니다.

     return (
          <div>
               {/* h1 태그의 스타일을 동적으로 설정하여 state.color의 값에 따라 텍스트 색상이 변경됩니다. */}
               {/* state.color는 현재 상태 객체의 color 속성 값을 참조하여 현재 설정된 색상을 반영합니다. */}
               <h1 style={{ color: state.color }}> 색3 : { state.color } </h1>
               <p>
                    {/* 각각의 버튼을 클릭할 때마다 dispatch 함수에 액션 객체를 전달하여 상태를 변경합니다. */}
                    {/* 각 버튼은 'CHANGE_COLOR' 타입과 특정 색상을 나타내는 text 값을 함께 전달합니다. */}
                    {/* onClick 이벤트 핸들러에서 dispatch 함수를 호출하여, 각 액션 타입과 색상을 담은 객체를 전달합니다. */}
                    <button onClick={() => dispatch({ type: 'CHANGE_COLOR', text: 'red' })}> 빨강 </button>
                    <button onClick={() => dispatch({ type: 'CHANGE_COLOR', text: 'green' })}> 초록 </button>
                    <button onClick={() => dispatch({ type: 'CHANGE_COLOR', text: 'blue' })}> 파랑 </button>
                    <button onClick={() => dispatch({ type: 'CHANGE_COLOR', text: 'purple' })}> 보라 </button>
                    {/* 'RESET' 버튼 클릭 시 초기 상태로 돌아가 색상이 'pink'로 변경됩니다. */}
                    {/* 'RESET' 액션은 초기 상태로 되돌려주는 역할을 하며, dispatch에 전달됩니다. */}
                    <button onClick={() => dispatch({ type: 'RESET' })}> 초기화 </button>
               </p>
          </div>
     );
};

export default Test03;