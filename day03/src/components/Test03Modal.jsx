import React from 'react';

const Test03Modal = ({ onClose }) => { 
     // Test03Modal 컴포넌트는 모달창을 나타냄
     // onClose는 props로 전달된 함수로, 모달을 닫기 위한 함수임.
     // 부모 컴포넌트에서 전달된 onClose 함수를 통해 모달창을 닫을 수 있음.

     return (
          <>
               {/* 반투명 배경을 담당하는 div */}
               <div className='bg'></div> 
               {/* 배경 요소로, 모달창 뒤에 위치하며 화면 전체를 덮음. */}
               {/* CSS에서 이 bg 클래스는 화면을 어둡게 만들기 위해 사용됨 */}
               
               <div className='popup'>
                    {/* 닫기 버튼, 'X'를 클릭하면 onClose 함수가 호출되어 모달이 닫힘 */}
                    <p className='closex' onClick={ onClose }>X</p> 
                    {/* 'X' 버튼이 클릭되면 onClose 함수가 호출되어 모달창이 닫힘.
                    이 함수는 부모 컴포넌트에서 전달된 onClose를 이용함. */}

                    {/* 모달창의 내용 */}
                    <h2>Have a nice Day !!! </h2>
                    {/* 모달창에 표시될 메시지나 제목. 이 부분은 자유롭게 수정 가능 */}
               </div>
          </>
     );
};

export default Test03Modal;
