import React, { useEffect, useState } from 'react';

const Test02Sub = () => {
     // 상태변수
     // x와 y는 각각 마우스의 X축 좌표와 Y축 좌표를 저장하기 위한 상태변수.
     // useState(0)은 초기값을 0으로 설정, 마우스 움직임에 따라 값이 업데이트됨.
     const [x, setX] = useState(0);
     const [y, setY] = useState(0);

     // onMove 함수는 마우스가 움직일 때마다 호출되어 좌표를 업데이트함.
     // 이벤트 객체 e를 인자로 받아 마우스 좌표를 가져옴.
     const onMove = (e) => {
          // 브라우저에서 사용자가 웹페이지에 보여지는 영역을 기준으로 표시
          // e.clientX는 마우스의 X축 좌표를 나타내고, e.clientY는 Y축 좌표를 나타냄.
          setX(e.clientX);   // 마우스 X축 좌표를 상태변수 x에 저장
          setY(e.clientY);   // 마우스 Y축 좌표를 상태변수 y에 저장
     };

     // useEffect는 컴포넌트가 마운트되고 언마운트될 때 실행되는 함수
     // 마운트되었을 때(window에 'mousemove' 이벤트를 등록)와
     // 언마운트될 때(이벤트를 제거) 관련된 동작을 관리함.
     useEffect(() => {
          // 컴포넌트가 처음 마운트될 때 이 코드가 실행됨
          console.log('useEffect');
          window.addEventListener('mousemove', onMove); // 마우스 움직임을 감지하여 onMove 함수 실행
          
          // cleanup 함수는 컴포넌트가 언마운트될 때 실행됨
          // [] 로 지정하면, 컴포넌트가 사라질 때 cleanup 함수가 호출된다.
          return () => {
               // 컴포넌트가 사라질 때 실행됨. 이벤트 제거로 메모리 누수 방지
               console.log('cleanup');
               window.removeEventListener('mousemove', onMove); // 'mousemove' 이벤트 제거
          };     

     }, []); // 빈 배열([])을 두 번째 인자로 주면, 컴포넌트가 처음 마운트될 때와 언마운트될 때만 실행됨.

     return (
          <div>
               <h2> 마우스 좌표 </h2>
               {/* 마우스 좌표를 보여주는 UI를 가운데 정렬 */}
               <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                    {/* 마우스 좌표 정보를 담고 있는 상자를 나타냄 */}
                    <div style={{ border: '1px solid #000', width: 400, padding: 30, margin: 15 }}>
                         {/* 마우스의 현재 X축과 Y축 좌표를 화면에 출력 */}
                         <h3> X축 : { x }, Y축 : { y } </h3>
                    </div>
               </div>
          </div>
     );
};

export default Test02Sub;
