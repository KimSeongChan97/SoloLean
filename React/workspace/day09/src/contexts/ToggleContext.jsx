// ToggleContext.jsx
import React, { createContext, useContext, useReducer } from 'react'; // createContext: 새 context를 생성하여 컴포넌트 간에 상태를 공유할 수 있게 합니다. useReducer: 상태를 업데이트하는 reducer 함수를 정의할 수 있습니다.

// export const ToggleContext = createContext(); // ToggleContext: 토글 상태와 상태를 변경하는 메서드(dispatch2)를 제공하는 context입니다.

const ToggleContext = createContext();
export const useToggle = () => useContext(ToggleContext);

// toggle 함수: reducer로 동작하여 액션에 따라 isChk 값을 업데이트합니다.
// state는 현재 상태를 의미하며, action은 상태 변경을 위한 액션 객체입니다.
const toggle = (state, action) => {
     switch(action.type) {
          // TOGGLE: 현재 isChk 값의 반대를 설정하여 true면 false, false면 true로 전환됩니다.
          case 'TOGGLE' : return { isChk: !state.isChk };
          // TRUE: isChk 값을 true로 설정하여 상태를 참으로 만듭니다.
          case 'TRUE' : return { isChk: true };
          // FALSE: isChk 값을 false로 설정하여 상태를 거짓으로 만듭니다.
          case 'FALSE' : return { isChk: false };
          // default: 정의되지 않은 액션 타입일 경우 현재 상태를 그대로 반환합니다.
          default : return state;
     }
};

// ToggleProvider 컴포넌트: ToggleContext.Provider로 하위 컴포넌트에 상태와 상태를 변경하는 메서드를 제공합니다.
const ToggleProvider = ({ children }) => {

     // useReducer: 상태(state2)와 상태 변경 함수(dispatch2)를 만듭니다.
     // 첫 번째 인수로 toggle reducer 함수가 들어가고, 초기값으로 { isChk : false }을 설정합니다.
     const [state2, dispatch2] = useReducer(toggle, { isChk : false });

     return (
          // ToggleContext.Provider로 state2와 dispatch2를 전달하여 하위 컴포넌트들이 상태와 상태 변경 함수를 사용할 수 있도록 설정합니다.
          <ToggleContext.Provider value={{ state2, dispatch2 }}>
               { children } {/* children은 ToggleProvider로 감싸진 하위 컴포넌트들을 의미합니다. */}
          </ToggleContext.Provider>
     );
};

export default ToggleProvider; // ToggleProvider 컴포넌트를 외부에서 사용할 수 있도록 export합니다.
