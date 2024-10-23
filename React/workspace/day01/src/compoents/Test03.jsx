import React from 'react'; 
// 리액트 라이브러리를 가져옵니다. 리액트는 UI를 구성하는 데 사용되는 라이브러리로, 컴포넌트 기반으로 UI를 선언적으로 구성할 수 있게 도와줍니다.

import './Test03.css';
// CSS 파일을 import하여 이 컴포넌트에 스타일을 적용합니다. Test03.css 파일은 이 컴포넌트 내부에만 적용되는 스타일을 포함할 수 있습니다.
// 이 CSS 파일은 전역 스타일을 적용하지 않고, 해당 컴포넌트에 필요한 스타일만 정의하는 방식으로 사용됩니다.

const Test03 = () => {
     // Test03 함수형 컴포넌트는 JSX를 반환하며, 이는 HTML과 비슷한 구조를 사용하여 UI를 정의합니다.
     return (
          <div>
               {/* <div> 태그는 HTML에서 컨테이너 요소로 사용됩니다. 이 컴포넌트의 전체 컨테이너로서 역할을 합니다. */}
               <h1>Class 속성 적용</h1>
               {/* <h1> 태그는 HTML에서 가장 큰 크기의 제목을 나타냅니다. 여기서는 'Class 속성 적용'이라는 텍스트를 출력합니다. */}
               {/* JSX에서 class 속성 대신 className을 사용해야 합니다. 이는 자바스크립트의 예약어인 class와 충돌을 방지하기 위한 것입니다. */}
               
               <div className='con-box'>
                    {/* className 속성을 통해 이 div 요소에 'con-box'라는 클래스가 적용됩니다. CSS 파일에서 정의된 'con-box' 스타일이 적용됩니다. */}
                    {/* className은 HTML의 class 속성과 동일한 역할을 합니다. CSS에서 정의된 스타일 규칙이 이 요소에 적용됩니다. */}
                    
                    <article>test</article>
                    {/* <article> 태그는 HTML5에서 문서의 독립적인 섹션을 정의할 때 사용됩니다. 'test'라는 텍스트가 표시됩니다. */}
                    {/* 이 요소는 CSS 파일에서 'con-box'에 지정된 스타일에 따라 레이아웃 및 스타일이 지정됩니다. */}
                    
                    <article>test</article>
                    {/* 두 번째 <article> 태그도 첫 번째와 동일한 구조이며, 'test'라는 텍스트가 출력됩니다. */}
                    
                    <article>test</article>
                    {/* 세 번째 <article> 태그 역시 동일한 구조로 반복되며, 'test'라는 텍스트가 출력됩니다. */}
               </div>
          </div>
     );
};

export default Test03;
// 이 컴포넌트를 다른 파일에서 사용할 수 있도록 export default를 사용하여 내보냅니다. 다른 파일에서 이 컴포넌트를 import하여 사용할 수 있습니다.
// export default는 기본 내보내기를 의미하며, 이를 통해 이 컴포넌트를 불러올 때 특별한 이름으로 import할 수 있습니다.
