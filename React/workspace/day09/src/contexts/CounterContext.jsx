// CounterContext.jsx
import React, { createContext, useContext, useReducer } from 'react'; // createContext: 새 context를 생성해 컴포넌트 간에 공유할 수 있는 상태를 만듭니다. useReducer: state를 관리할 수 있는 훅입니다.

// export const CounterContext = createContext(); // CounterContext: 카운터 상태와 상태를 변경하는 메서드(dispatch)를 제공하는 context입니다.

// 사용자가 만든 Hooks 를 사용해서 해보자
const CounterContext = createContext();
export const useCounter = () => useContext(CounterContext);

// count 함수: reducer로 동작하여 액션에 따라 counter 값을 업데이트합니다.
// state는 현재 상태를 의미하며, action은 상태 변경을 위한 액션 객체입니다.
const count = (state, action) => {
     switch (action.type) {
          // INCREMENT: 현재 counter 값에 1을 더한 값을 반환하여 카운터 값을 증가시킵니다.
          case 'INCREMENT': return { counter: state.counter + 1 };
          // DECREMENT: 현재 counter 값에서 1을 뺀 값을 반환하여 카운터 값을 감소시킵니다.
          case 'DECREMENT': return { counter: state.counter - 1 };
          // RESET: counter를 0으로 설정하여 카운터 값을 초기화합니다.
          case 'RESET': return { counter: 0 };
          // default: 정의되지 않은 액션 타입일 경우 현재 상태를 그대로 반환합니다.
          default: return state;
     }
};

// CounterProvider 컴포넌트: CounterContext.Provider로서 하위 컴포넌트에 상태와 상태를 변경하는 메서드를 제공합니다.
const CounterProvider = ({ children }) => {

     // useReducer: 상태(state)와 상태 변경 함수(dispatch)를 만듭니다.
     // useReducer : useReducer( state, initialState );
     // 첫 번째 인수로 count reducer 함수가 들어가고, 초기값으로 { counter: 0 }을 설정합니다.
     const [state, dispatch] = useReducer(count, { counter: 0 });
     
     return (
          // CounterContext.Provider로 state와 dispatch를 전달하여 하위 컴포넌트들이 state와 dispatch에 접근할 수 있도록 설정합니다.
          <CounterContext.Provider value={{ state, dispatch }}>
               { children } {/* children은 CounterProvider로 감싸진 하위 컴포넌트들을 의미합니다. */}
          </CounterContext.Provider>
     );
};

export default CounterProvider; // CounterProvider 컴포넌트를 외부에서 사용할 수 있도록 export합니다.
