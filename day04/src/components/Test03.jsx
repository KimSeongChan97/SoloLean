import React from 'react';

//  '../css/Test03.css'; 전역 CSS 파일을 가져옴
import myStyle from '../css/Test03.module.css';  // CSS Module로 작성된 파일을 가져옴
import Test03Sub from './Test03Sub';
import Test04 from './Test04';

const Test03 = () => {
     return (
          <div>
               {/* className을 통해 일반 CSS 파일에서 정의된 'box' 클래스를 적용함
                   이 경우 전역적으로 적용되며, 모든 컴포넌트에서 이 클래스명을 사용할 수 있음. */}
               <div className='box'>Test</div>

               {/* className을 통해 CSS Module에서 정의된 'box' 클래스를 적용함
                   CSS Module은 클래스 이름에 고유한 해시값이 붙어 컴포넌트별로 CSS가 독립적으로 적용됨.
                   myStyle.box는 import한 CSS Module 파일에서 'box' 클래스명을 참조하는 것. */}
               <div className={ myStyle.box }>Test</div>
               <hr/>
               <Test03Sub />
               <Test04 />

          </div>
     );
};

export default Test03;


/*
컴포넌트별로 CSS 작성
파일명.module.css
import 참조변수 form './파일명.module.css';
개발자 도구에서 보면 '파일명_클래스명_아무말' 이라고 설정된다

CSS Module을 사용하는 이유는 전역 네임스페이스 오염을 방지하기 위해서다.
일반적인 CSS는 한 번 정의되면 해당 스타일이 전역적으로 적용되기 때문에
다른 컴포넌트에서 동일한 클래스명을 사용하면 스타일이 충돌할 수 있다.

CSS Module은 고유한 클래스명을 생성함으로써 이러한 충돌을 방지한다.
이 방식으로 컴포넌트별로 스타일을 독립적으로 관리할 수 있고, 클래스명이 겹치는 문제를 해결할 수 있다.

전역 CSS (Test03.css)와 CSS Module (Test03.module.css)의 차이:
1. 전역 CSS는 모든 컴포넌트에서 클래스명이 겹칠 위험이 있으나, CSS Module은 컴포넌트마다 고유한 해시가 붙어 스타일 충돌이 방지됨.
2. CSS Module에서 클래스를 적용할 때는 myStyle.box와 같이 객체를 통해 접근해야 함.
*/
