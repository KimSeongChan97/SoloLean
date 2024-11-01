import React, { createContext, useState } from 'react';

// ColorContext 생성 - 색상 관련 데이터를 전역으로 관리하고 사용할 수 있도록 한다.
// Context API를 사용하면 계층 구조에서 props를 전달하지 않고 데이터를 쉽게 전역적으로 사용할 수 있다.
export const ColorContext = createContext();

//const ColorProvider = (props) => {
const ColorProvider = ({ children }) => {
     
     // color 상태와 이를 변경할 setColor 함수를 선언 - 초기 색상은 빈 문자열로 설정
     // useState를 통해 상태를 관리하며, 초기값을 빈 문자열로 설정하여 아직 선택된 색상이 없음을 나타낸다.
     //const [color, setColor] = useState('');
     const [color, setColor] = useState('hotpink'); // 기본색상 핫핑크

     // 각 색상으로 변경하는 함수들을 정의 - setColor를 통해 각 색상으로 color 상태를 변경
     const onRed = () => setColor('red');
     const onGreen = () => setColor('green');
     const onBlue = () => setColor('blue');
     const onMagenta = () => setColor('magenta');
     const onCyan = () => setColor('cyan');

     // ColorContext.Provider를 통해 color 상태와 색상 변경 함수들을 하위 컴포넌트에 전달
     // value 속성에 전달할 데이터와 함수들을 객체 형태로 포함시켜 자식 컴포넌트에서 이를 사용할 수 있게 한다.
     // 자식 컴포넌트에서는 이 Context를 사용하여 color 상태와 색상을 변경하는 함수를 활용할 수 있다.
     return (
          <ColorContext.Provider value={{ color, onRed, onGreen, onBlue, onMagenta, onCyan }}>
               {/* { props.children } */}
               { children }
          </ColorContext.Provider>
     );
};

// ColorProvider를 export하여 다른 파일에서 사용할 수 있게 한다.
// export를 통해 외부에서 이 Provider를 import하여 Context API의 데이터를 쉽게 사용할 수 있다.
export default ColorProvider;
