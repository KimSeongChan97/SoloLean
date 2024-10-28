import React, { useReducer } from 'react';

// 초기값
const initialState = 0; // initialState는 카운터의 시작값으로, 여기서는 0으로 설정. 이 값은 useReducer가 처음 실행될 때 초기 상태로 적용됨

// 값을 바꿔주는 함수가 필요하므로 reducer 적용
// const reducer = ( 파라메터로 2개의 값을 받는다. 상태변수, 함수 ) => {}; // 상태변수와 함수의 값을 받는다.
const reducer = ( state, action ) => { 
     // reducer 함수는 현재 상태(state)와 실행할 작업(action)을 받아서 상태를 업데이트하는 역할
     // action 객체 안에 type 속성을 통해 어떤 작업을 수행할지 결정 (예: 'INCREMENT', 'DECREMENT', 'RESET')
     switch(action.type){ 
          case 'INCREMENT' : return state + 1 // INCREMENT 인 값이 맞으면, state 에 +1 한 값을 돌려줌
               // 'INCREMENT'라는 type이 전달되면 현재 state 값에 1을 더하여 반환
          case 'DECREMENT' : return state - 1 // 'DECREMENT' 타입이면 현재 state에서 1을 빼서 반환
          case 'RESET' : return 0 // 'RESET' 타입이면 state를 초기값 0으로 설정
          default : return state // 반드시 default 는 작성해야 한다.
               // action.type이 정의된 case에 없으면 기존 state 값을 반환하며, 이는 에러 방지 및 안정성 확보
     } 
};

const Test01 = () => {

     // const [count, setCount ] = useState(0); 
     // useState를 사용하여 count라는 상태 변수를 0으로 초기화하려고 했으나 주석 처리되어 대체로 useReducer가 사용됨

     //  count -> state, dispatch -> action
     const [ count, dispatch ] = useReducer(reducer, initialState); 
     // count 가 state 라는 상태변수로 전달되고, 이벤트를 발생하는 함수 dispatch 가 action 에게 전달된다.
     // dispatch 를 통해 type 이라는 상태변수에서 'INCREMENT' 를 action 으로 전달
     // useReducer는 두 개의 값을 반환:
     //   - count: 현재 상태값으로, 초기에는 initialState 값인 0이 전달
     //   - dispatch: 상태를 업데이트하는 함수로, 특정 작업을 수행하도록 reducer 함수에 action을 전달하여 상태 업데이트
     
     return (
          <div>
             <h1> 카운트 : { count } </h1> 
             <p>
                    <button onClick={ () => dispatch({ type: 'INCREMENT' }) }>증가</button>
                    {/* // 증가 버튼을 클릭하면 dispatch가 호출되어 type 'INCREMENT' action을 reducer로 전달,
                    // reducer가 현재 state에 +1을 적용한 새로운 count 값 반환 */}
                    <button onClick={ () => dispatch({ type: 'DECREMENT' }) }>감소</button>
                    {/* // 감소 버튼 클릭 시 dispatch 호출 및 type 'DECREMENT' action을 reducer로 전달,
                    // reducer가 현재 state에 -1을 적용한 새로운 count 값 반환 */}
                    <button onClick={ () => dispatch({ type: 'RESET' }) }>초기화</button>
                    {/* // 초기화 버튼 클릭 시 dispatch가 호출되어 type 'RESET' action을 reducer로 전달,
                    // reducer는 상태를 0으로 리셋 */}
            </p> 
          </div>
     );
};

export default Test01;

/*

useReducer() : 리덕스에 필수적인 함수 이다.

React에서 컴포넌트의 상태 관리를 위해서 useState를 사용해서 상태를 업데이트를 하는데,
useReducer를 사용하게 되면 컴포넌트와 상태 업데이트 로직을 분리하여 컴포넌트 외부에서도 상태 관리를 할 수 있 다.
 즉, 현재 컴포넌트가 아닌 다른 곳에 state를 저장하고 싶을 때 유용하게 사용할 수 있다. 
( 상태변수와 컴포넌트 분리 )

[사용법]
const [state, dispatch] = useReducer(reducer, initialState);
const [ 현재 상태, action을 발생시키는 함수 ] = useReducer(새로운 상태 반환, 초기값);

state : 현재 상태
dispatch : action을 발생시키는 함수
reducer : state와 action를 받아 새로운 state를 반환하는 함수
initialState : 초기값

*/
