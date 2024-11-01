// ChangeColorContext라는 Context를 생성하여 전역에서 접근 가능한 색상 변경 상태를 관리하기 위한 컨텍스트 생성
// 이 컨텍스트는 애플리케이션 내 여러 컴포넌트에서 색상 값을 공유하도록 설정
import React, { createContext, useState } from 'react';

// ChangeColorContext: 색상을 변경하는 상태를 공유하기 위한 컨텍스트 생성
// createContext()를 사용하여 기본값을 설정하지 않고 컨텍스트를 생성함
export const ChangeColorContext = createContext();

// ChangeColorProvider 컴포넌트: 자식 컴포넌트에 색상 변경 기능을 제공
// 이 컴포넌트는 color와 onColor 함수를 context의 값으로 전달하여 하위 컴포넌트에서 이를 사용할 수 있게 함
const ChangeColorProvider = ({ children }) => {

    // color 상태 초기화: useState를 사용해 초기 색상을 'cyan'으로 설정
    // useState를 통해 상태를 관리하며, color는 현재 선택된 색상을 나타냄
    const [color, setColor] = useState('cyan');

    // onColor 함수: 호출 시 전달된 색상으로 color 상태를 변경
    // onColor 함수는 매개변수로 전달된 색상을 현재 color 상태로 설정하여, 호출 시마다 글자 색상이 변경되도록 함
    const onColor = (text) => setColor(text);

    return (
        // Provider 컴포넌트로 color와 onColor를 값으로 전달해 하위 컴포넌트가 이 값들에 접근하도록 설정
        // ChangeColorContext.Provider 컴포넌트는 value 속성을 통해 공유할 데이터를 정의하며, 
        // 여기서는 color와 onColor 함수가 포함된 객체를 전달함
        <ChangeColorContext.Provider value={{ color, onColor }}>
            { children } {/* 자식 컴포넌트를 렌더링하며 context 값을 전달함 */}
        </ChangeColorContext.Provider>
    );
};

export default ChangeColorProvider;
