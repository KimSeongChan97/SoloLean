// ChangeCountContext라는 컨텍스트를 생성하여 카운트 상태를 관리하는 컴포넌트에 전역 상태를 제공
// 이 컨텍스트는 애플리케이션 내 여러 컴포넌트에서 카운트 값을 공유하도록 설정함
import React, { createContext, useState } from 'react';

// ChangeCountContext: 카운트 증가 및 감소 상태를 공유하는 컨텍스트 생성
// createContext()를 사용하여 기본값을 설정하지 않고 컨텍스트를 생성함
export const ChangeCountContext = createContext();

// ChangeCountProvider 컴포넌트: 자식 컴포넌트에 카운트 관련 기능을 제공
// 이 컴포넌트는 count 상태와 increment, decrement 함수를 context의 값으로 전달하여 하위 컴포넌트에서 이를 사용할 수 있게 함
const ChangeCountProvider = ({ children }) => {

    // count 상태 초기화: useState로 초기값을 0으로 설정
    // useState를 통해 count 상태를 관리하며, 초기 값은 0으로 설정
    const [count, setCount] = useState(0);

    // increment 함수: 전달된 값만큼 count 상태를 증가
    // increment 함수는 매개변수로 전달된 값을 현재 count 값에 더해줌
    const increment = (value) => {
        setCount(count + value);
    };

    // decrement 함수: 전달된 값만큼 count 상태를 감소
    // decrement 함수는 매개변수로 전달된 값을 현재 count 값에서 빼줌
    const decrement = (value) => {
        setCount(count - value);
    };

    return (
        // Provider 컴포넌트로 count, increment, decrement를 자식 컴포넌트에 제공
        // ChangeCountContext.Provider 컴포넌트는 value 속성을 통해 공유할 데이터를 정의하며, 
        // 여기서는 count, increment, decrement 함수가 포함된 객체를 전달함
        <ChangeCountContext.Provider value={{ count, increment, decrement }}>
            { children } {/* 자식 컴포넌트를 렌더링하며 context 값을 전달함 */}
        </ChangeCountContext.Provider>
    );
};

export default ChangeCountProvider;
