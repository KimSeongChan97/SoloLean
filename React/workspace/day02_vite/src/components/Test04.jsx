import React, { useState } from 'react';

const Test04 = () => {
     // visible 상태 변수는 컴포넌트 내에서 특정 요소가 보이는지 여부를 결정하는 값입니다.
     // isVisible은 visible 상태를 변경하는 함수로, useState의 두 번째 반환값입니다.
     const [visible, isVisible] = useState(false);

     // onToggle 함수는 visible 상태값을 반전시킵니다 (true <-> false).
     // 현재 visible 값이 true이면 false로, false이면 true로 바뀝니다.
     const onToggle = () => {
          isVisible(!visible);
     };

     // onShow 함수는 visible 값을 true로 설정하여 요소를 보이게 합니다.
     const onShow = () => {
          isVisible(true);
     };

     // onHide 함수는 visible 값을 false로 설정하여 요소를 숨깁니다.
     const onHide = () => {
          isVisible(false);
     };

     return (
          <div>
               {/* onShow 함수가 호출되어 visible 상태를 true로 설정합니다.
                   즉, 버튼을 클릭하면 요소가 보이게 됩니다. */}
               <button onClick={ onShow }> 보이기 </button>

               {/* onHide 함수가 호출되어 visible 상태를 false로 설정합니다.
                   즉, 버튼을 클릭하면 요소가 숨겨집니다. */}
               <button onClick={ onHide }> 숨기기 </button>

               {/* onToggle 함수는 visible 값을 반전시키는 역할을 합니다.
                   삼항연산자를 이용하여 visible이 true일 때는 '숨기기', false일 때는 '보이기'로 버튼의 텍스트가 바뀝니다. */}
               <button onClick={ onToggle }> { visible ? '숨기기' : '보이기' } </button>
               <hr/>

               { /* 삼항 연산자를 사용하여 visible이 true일 경우 특정 JSX 요소를 렌더링합니다.
                     visible이 true이면 hotpink 색상의 div가 화면에 보이고, false이면 null을 반환하여 아무것도 렌더링되지 않습니다.
                     조건 ? 참 : 거짓 구문의 형태로 작성되었습니다. */}
               { visible ?
                    <div style={{ width: 300, height: 100, margin: 20, background: 'hotpink'}}>
                    
                    </div> : null
               }
               <hr/>

               { /* && 연산자를 사용한 조건부 렌더링입니다.
                    visible이 true일 경우에만 해당 JSX가 렌더링됩니다.
                    즉, visible이 true이면 cyan 색상의 div가 화면에 보이고, false일 경우에는 렌더링되지 않습니다.
                    && 연산자는 좌측의 조건이 true일 때만 우측의 내용을 렌더링하는 방식입니다. */}
               { visible &&
                    <div style={{ width: 300, height: 100, margin: 20, background: 'cyan'}}>
                         BoxText  {/* 이 텍스트는 visible이 true일 때만 화면에 출력됩니다. */}
                    </div>
               }

          </div>
     );
};

export default Test04;

/*
  이 컴포넌트는 React의 useState를 이용하여 visible 상태를 관리합니다.
  여러 버튼을 통해 사용자가 visible 상태를 직접 변경할 수 있으며, 그에 따라 특정 요소가 보이거나 숨겨집니다.
  삼항 연산자와 && 연산자를 사용한 조건부 렌더링을 통해 visible 값에 따라 다른 요소들이 렌더링됩니다.
*/
