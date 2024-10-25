import React, { useState } from 'react';
import Test02Sub from './Test02Sub';

const Test02 = () => {
     // 상태변수 기본값 false
     // show라는 상태변수는 컴포넌트 내에서 true/false 값을 관리하여, 
     // Test02Sub 컴포넌트의 표시 여부를 결정한다.
     // 초기 값은 false이므로 처음에는 Test02Sub가 보이지 않음.
     const [ show, isShow ] = useState(false);

     // onToggle 함수, isShow 의 false(show 라는 값)가 아니라면 true 이므로 참 
     // onToggle 함수는 현재 show 상태를 반전시키는 역할을 함. 
     // show가 false이면 true로, true이면 false로 변경.
     const onToggle = () => {
          isShow(!show); // 현재 show 값이 true/false에 따라 반전
     };

     return (
          <div>
               {/* <button> show 기본값 false 일때는 Hide, true 값일 때는 Show </button> */}
               {/* show 값에 따라 버튼의 텍스트가 바뀐다.
                   show가 true이면 버튼에 'Hide'가 표시되고, false이면 'Show'가 표시됨.
                   즉, 'Show'는 Test02Sub 컴포넌트를 보여주는 동작을 하고, 
                   'Hide'는 Test02Sub 컴포넌트를 숨기는 동작을 함. */}
               <button onClick={ onToggle }> { show ? 'Hide' : 'Show' } </button>
               <br/>
               {/* show 가 참이면 && 호출하겠다 */}
               {/* show 값이 true일 경우에만 Test02Sub 컴포넌트가 렌더링됨.
                   && 연산자를 사용하여, show가 true일 때만 Test02Sub 컴포넌트가 실행됨.
                   show가 false일 때는 렌더링되지 않음. */}
               {
                    show && <Test02Sub />
               }    
          </div>
     );
};

export default Test02;
