// Counter.jsx
import React, { useContext } from 'react'; // useContext: React에서 context를 사용할 수 있도록 해주는 Hook으로, 지정한 context의 데이터를 가져와서 사용할 수 있도록 합니다.
// import { CounterContext } from '../contexts/CounterContext'; // CounterContext: 카운터 상태와 이를 변경할 수 있는 메서드를 제공하는 context입니다.
// import { ToggleContext } from '../contexts/ToggleContext'; // ToggleContext: 토글 상태와 상태 변경 메서드를 제공하는 context입니다.

import { useCounter } from '../contexts/CounterContext';
import { useToggle } from '../contexts/ToggleContext';

import styles from '../css/button.module.css';

const Counter = () => {

    // CounterContext에서 제공하는 현재 state와 dispatch를 불러옵니다.
    //const { state, dispatch } = useContext(CounterContext);
    // ToggleContext에서 state2와 dispatch2를 불러옵니다.
    // useContext를 사용하면 해당 context에서 제공하는 데이터를 현재 컴포넌트에서 바로 사용할 수 있습니다.
    // const { state2, dispatch2 } = useContext(ToggleContext);

    // 사용자가 만든 Hooks 를 사용
    const { state, dispatch } = useCounter();
    const { state2, dispatch2 } = useToggle();

    return (
        <div>
            {/* 카운터 값 출력: 현재 counter 값을 화면에 표시합니다.
                CounterContext의 state 객체에서 counter 속성을 가져와서 사용할 수 있게 됩니다. */}
            {/* state.counter는 useCounter 훅을 통해 받아온 상태 객체에서 counter라는 속성 값을 의미합니다.
                카운터의 현재 상태 값을 실시간으로 화면에 표시합니다. */}
            <h1> 카운터 : {state.counter} </h1>

            {/* 토글 상태에 따른 색상 설정 및 출력: 
                state2의 isChk 값이 true면 글자 색이 빨간색, false면 파란색으로 표시됩니다.
                삼항 연산자 표현식({ color: state2.isChk ? 'red' : 'blue' })를 통해 상태에 따라 스타일을 동적으로 설정합니다.
                state2.isChk의 현재 값이 텍스트로 표시되며, true 또는 false 값이 string으로 변환되어 출력됩니다. */}
            <h1 style={{ color: state2.isChk ? 'red' : 'blue' }}> 토글 : {`${state2.isChk}`}</h1>

            {/* 카운터 버튼 그룹: 카운터 값을 증가, 감소 또는 초기화하는 버튼들을 렌더링합니다. */}
            <p>
                {/* '증가' 버튼: 버튼을 클릭하면 dispatch 메서드가 INCREMENT 액션을 CounterContext에 전달합니다.
                    이로 인해 CounterContext 내에서 지정된 reducer 함수가 호출되어 counter 값을 1 증가시킵니다.
                    &nbsp;는 버튼 사이의 간격을 위한 HTML 공백 문자입니다. */}
                <button className={styles.button} onClick={() => dispatch({ type: 'INCREMENT' })}> 증가 </button> &nbsp;
                {/* '감소' 버튼: 버튼을 클릭하면 dispatch 메서드가 DECREMENT 액션을 CounterContext에 전달합니다.
                    카운터 값이 1 감소합니다. */}
                <button className={styles.button} onClick={() => dispatch({ type: 'DECREMENT' })}> 감소 </button> &nbsp;
                {/* '초기화' 버튼: 버튼을 클릭하면 dispatch 메서드가 RESET 액션을 CounterContext에 전달합니다.
                    카운터 값이 0으로 초기화됩니다. */}
                <button className={styles.button} onClick={() => dispatch({ type: 'RESET' })}> 초기화 </button>
            </p>

            {/* 토글 버튼 그룹: 토글 상태를 변경하는 버튼들을 렌더링합니다. */}
            <p>
                {/* 'Toggle' 버튼: 클릭 시 dispatch2가 TOGGLE 액션을 ToggleContext에 전달합니다.
                    TOGGLE 액션은 현재의 isChk 값을 반전(true에서 false 또는 false에서 true로 변경)시킵니다. */}
                <button className={styles.button} onClick={() => dispatch2({ type: 'TOGGLE' })}> Toggle </button> &nbsp;

                {/* 'True' 버튼: 클릭 시 dispatch2가 TRUE 액션을 ToggleContext에 전달하며, isChk 값이 true로 설정됩니다. */}
                <button className={styles.button} onClick={() => dispatch2({ type: 'TRUE' })}> True </button> &nbsp;

                {/* 'False' 버튼: 클릭 시 dispatch2가 FALSE 액션을 ToggleContext에 전달하며, isChk 값이 false로 설정됩니다. */}
                <button className={styles.button} onClick={() => dispatch2({ type: 'FALSE' })}> False </button>
            </p>
        </div>
    );
};

export default Counter; // Counter 컴포넌트를 외부에서 import하여 사용할 수 있도록 export해줍니다.
