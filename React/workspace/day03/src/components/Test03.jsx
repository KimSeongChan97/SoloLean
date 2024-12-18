import React, { useState } from 'react';
import Test03Modal from './Test03Modal';

import '../css/Test03.css';

const Test03 = () => {
     // 상태변수, 기본값은 false
     // 상태변수 open은 모달창이 열렸는지 여부를 관리함. 
     // 기본값은 false로 설정되어 있으므로 처음에는 모달창이 열리지 않은 상태임.
     const [open, isOpen] = useState(false); // useState 훅을 사용하여 'open' 상태값과 이를 변경하는 함수 'isOpen'을 정의

     // open 이 true 이면 팝업창이 뜬다.
     // 'isOpen(true)'를 호출하면 'open' 상태가 true로 바뀌고, 조건부 렌더링에 의해 모달창이 화면에 나타남.
     
     // 상태변수 와 상태변수의 값을 변경시키는 함수는 항상 같이 있어야 한다. 
     // onOpen 함수는 버튼이 클릭될 때 호출되며, 모달창을 열기 위해 open 상태값을 true로 변경함.
     const onOpen = () => {
          isOpen(true); // 'isOpen' 함수를 통해 'open' 상태를 true로 설정하여 모달창이 열리도록 함.
     };

     // onClose 함수는 모달창을 닫는 역할을 함. 
     // 이 함수는 모달창에서 호출되어 'open' 상태를 false로 변경함으로써 모달창을 닫음.
     const onClose = () => {
          isOpen(false); // 'isOpen' 함수를 통해 'open' 상태를 false로 설정하여 모달창을 닫음.
     };

     return (
          <div>
               {/* 버튼 클릭 시 onOpen 함수가 실행되어 모달창을 열 수 있음 */}
               <button className='button' onClick={ onOpen }>팝업창</button>
               {
                    // open && <Test03Modal 변수 = { 값 } />
                    // 'open' 상태가 true일 때만 모달 컴포넌트를 렌더링함.
                    // 조건부 렌더링을 사용하여, 모달이 열렸을 때만 <Test03Modal />이 화면에 표시됨.
                    open && <Test03Modal onClose = { onClose } /> 
                    // onClose 함수를 모달 컴포넌트에 props로 전달하여 모달에서 이 함수를 호출해 모달을 닫을 수 있게 함.
               }
          </div>
     );
};

export default Test03;

/* 
팝업과 모달의 차이점
1. 팝업 (Popup):
   - 팝업은 주로 새로운 창이나 탭에서 열리는 독립적인 UI 요소입니다. 팝업 창은 사용자가 보고 있는 페이지 외부에 표시되며, 화면에서 다른 페이지로 전환되거나, 독립적인 브라우저 창으로 나타납니다.
   - 팝업은 보통 광고, 알림, 경고 등을 표시하는데 사용됩니다. 사용자가 브라우저 설정에 따라 팝업을 차단할 수도 있습니다.
   - 팝업은 종종 페이지 전환이나 새로운 창으로 연결되므로 사용자가 뒤로 가기 버튼을 누르면 팝업이 사라지게 됩니다.
   
2. 모달 (Modal):
   - 모달은 현재 페이지 안에서 표시되는 UI 요소로, 화면의 중앙에 오버레이 형태로 나타납니다. 모달 창이 열리면 배경의 다른 부분은 비활성화되거나 흐릿해집니다.
   - 모달은 사용자와 상호작용하기 전까지는 다른 화면 요소와의 상호작용을 차단하는 특성이 있습니다. 보통 중요한 메시지나 작업을 처리할 때 사용됩니다.
   - 사용자는 모달을 닫아야만 다른 작업을 진행할 수 있기 때문에 모달은 사용자 경험에 있어서 좀 더 강제적인 요소로 작용합니다.
   
   * 주요 차이점:
     - 팝업은 브라우저 창이나 탭에서 열리지만, 모달은 현재 페이지 내에서 오버레이로 표시됨.
     - 팝업은 독립적으로 열리며 브라우저의 설정에 영향을 받을 수 있지만, 모달은 웹 애플리케이션의 UI 일부로 관리되며 브라우저 설정의 영향을 받지 않음.
     - 팝업은 페이지 외부에서 열리고, 모달은 페이지 내부에서 사용자 경험을 방해하지 않는 한도 내에서 사용됨.
*/
