import React from 'react'; 
// React 라이브러리를 가져옵니다. React는 컴포넌트를 작성하고 UI를 구성하는 데 사용됩니다.

import Cat from './Cat';
// Cat 컴포넌트를 가져옵니다. Cat 컴포넌트는 './Cat' 경로에서 정의되어 있으며, 이 파일 안에서 사용할 수 있게 import합니다.
// './Cat'은 현재 디렉토리 내에서 Cat.js 파일을 의미합니다.

import Lion from './Lion'; 
// Lion 컴포넌트를 가져옵니다. Lion 컴포넌트는 './Lion' 경로에서 정의된 컴포넌트입니다.

import Person from './Person'; 
// Person 컴포넌트를 가져옵니다. Person 컴포넌트는 './Person' 경로에서 정의된 컴포넌트입니다.

const Test04 = () => { 
     // Test04는 함수형 컴포넌트로, React에서 기본적으로 컴포넌트를 정의하는 방법입니다.
     // 이 컴포넌트는 JSX를 반환하며, HTML 구조와 유사하게 생긴 구문을 사용하여 UI를 정의합니다.
     
     return ( 
          // return 문은 JSX를 반환하여 브라우저에 렌더링할 UI를 정의합니다.
          // JSX는 HTML과 매우 비슷하지만, 중괄호 {}를 사용해 자바스크립트 표현식을 삽입할 수 있습니다.
          <div> 
                {/* <Cat 변수명=값 /> */}
                {/* Cat 컴포넌트를 렌더링하며, name이라는 props를 전달합니다. name에 '고양이'라는 문자열이 전달됩니다. */}
                <Cat name='고양이' />
                {/* 여기서는 Cat 컴포넌트에 name='고양이'라는 props가 전달됩니다. 이 props는 Cat 컴포넌트에서 받아서 사용할 수 있습니다. */}
                
                <Lion name='사자' /> 
                {/* Lion 컴포넌트를 렌더링하며, name이라는 props를 전달합니다. name에 '사자'라는 값이 전달됩니다. */}
                {/* Lion 컴포넌트 역시 name='사자'라는 props를 받아서 사용할 수 있습니다. */}
                
                <Person name='홍길동' age='25' /> 
                {/* Person 컴포넌트를 렌더링하며, name과 age라는 두 가지 props를 전달합니다. */}
                {/* name에는 '홍길동', age에는 '25'라는 값이 전달되며, Person 컴포넌트에서 이 값을 받아 사용할 수 있습니다. */}
          </div> 
          // 전체 UI는 <div> 태그로 감싸져 있으며, 여러 개의 하위 컴포넌트를 포함하고 있습니다.
     ); 
};

export default Test04;
// Test04 컴포넌트를 다른 파일에서 사용할 수 있도록 내보냅니다. export default는 해당 모듈에서 기본적으로 내보낼 대상을 지정하는 구문입니다.
// 다른 파일에서 import Test04 from './Test04';와 같은 방식으로 이 컴포넌트를 불러올 수 있습니다.
