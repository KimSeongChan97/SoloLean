import React from 'react'; 
// React 라이브러리를 가져옵니다. 리액트는 UI 컴포넌트를 만들기 위한 라이브러리로, 리액트 컴포넌트는 이 라이브러리를 기반으로 만들어집니다.

const Person = (props) => { 
    // Person 컴포넌트는 props를 인자로 받습니다. props는 부모 컴포넌트에서 전달된 데이터를 포함하고 있으며, 이를 통해 컴포넌트 외부에서 데이터를 전달할 수 있습니다.
    // 이 컴포넌트는 자식 컴포넌트로서 부모로부터 데이터를 받아와 표시하는 역할을 합니다.

    const { name, age } = props; 
    // props 객체에서 name과 age를 구조 분해 할당합니다. 이는 props.name과 props.age로 각각 접근할 수 있는 값을 간편하게 사용할 수 있도록 합니다.
    // 구조 분해 할당을 통해 props에서 전달된 name과 age 값을 개별 변수로 추출하여 JSX 내부에서 쉽게 사용 가능합니다.

    return ( 
        // 리액트 컴포넌트는 JSX를 반환합니다. JSX는 HTML과 비슷한 문법으로, 리액트에서 사용자 인터페이스(UI)를 정의하는 데 사용됩니다.
        <div> 
            {/* div 태그는 여러 HTML 요소를 그룹화하는 데 사용됩니다. 이 컴포넌트는 하나의 div 요소 안에 모든 콘텐츠를 감쌉니다. */}
            <h3> 
                {/* h3 태그는 제목을 나타내며, 이 경우에는 크기가 작은 제목을 사용합니다. */}
                나의 이름은 <span style={{ color: 'blue' }}>{name}</span> 이고, 나이는 {age} 살 입니다.
                {/* {name}과 {age}는 props에서 받은 값을 나타냅니다. 중괄호 안의 값은 자바스크립트 표현식이므로, JSX 내부에서 동적으로 렌더링됩니다. */}
                {/* name 값은 파란색으로 스타일이 적용되었으며, 인라인 스타일로 적용되었습니다. 인라인 스타일은 style 속성을 사용하고, 객체 형태로 정의됩니다. */}
            </h3> 
            {/* 이 텍스트는 '나의 이름은 {name} 이고, 나이는 {age} 살 입니다.'로 출력됩니다. name 값은 파란색으로 표시됩니다. */}
        </div> 
    ); 
};

export default Person; 
// Person 컴포넌트를 외부에서 사용할 수 있도록 내보냅니다. export default는 해당 모듈에서 기본으로 내보낼 대상을 지정합니다.
// 이 컴포넌트를 다른 파일에서 import하여 사용할 수 있게 됩니다.