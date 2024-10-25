import React from 'react';

// Display 컴포넌트: Animal 컴포넌트에서 입력된 name 값을 props로 전달받아 화면에 표시
const Display = ({ name }) => {
    return (
        <div>
            <h2>Display Component</h2>
            {/* Animal 컴포넌트에서 전달받은 name이 있으면 그 값을 보여주고, 없으면 '값을 입력하시오.'라고 표시 */}
            <p>내가 좋아하는 동물: {name || '값을 입력하시오.'} 입니다 ! </p>
        </div>
    );
};

// 컴포넌트를 외부에서 사용할 수 있도록 export
export default Display;

// 이 컴포넌트는 Animal 컴포넌트에서 입력된 name 값을 받아 화면에 표시해주는 역할을 한다.
// name 값이 없을 경우 "값을 입력하시오"라는 기본 메시지를 출력하여, 사용자가 입력하지 않았을 때의 경우도 처리한다.
