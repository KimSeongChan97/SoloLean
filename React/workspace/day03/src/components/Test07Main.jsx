import React, { useState } from 'react';
import Test07Input from './Test07Input';
import Test07Print from './Test07Print';
import Test07Output from './Test07Output'; 
import '../css/Test07.css';

const Test07Main = () => {
     // 상태변수 , dto
     const [ dto, setDto ] = useState({
          name: '',
          age: '',
          addr: '',
          phone: ''
     });
     /* 
     dto라는 상태변수를 생성하고, 초기값은 name, age, addr, phone을 빈 문자열로 설정함.
     이 상태는 사용자가 입력한 설문 데이터를 담기 위한 객체.
     setDto는 상태를 업데이트하는 함수로, dto 객체의 특정 필드 값이 바뀌면 setDto를 사용해
     해당 필드를 업데이트함.
     */

     const onChange = (e) => {
          const { name, value } = e.target;
          setDto({
               ...dto,
               [name]: value     
          });     
     };
     /*
     onChange 함수는 사용자가 입력 필드에 데이터를 입력할 때마다 호출됨.
     e.target에서 name과 value를 가져와서 해당 name 필드의 값을 dto 상태에 업데이트함.
     'name' 속성은 각 입력 필드의 속성명과 동일하게 되어 있으므로, 이를 통해 dto 객체의 필드와
     연결되어 데이터를 저장할 수 있음. 기존 dto 객체를 그대로 유지하고, 수정된 부분만 업데이트하는 방식으로 동작.
     */

          /* 
     선생님 답안. 
     const onInput = (e) => {
               console.log(e.target)
               const { name, value } = e.target;
               setDto({
                         ...dto,
                         [ name ] : value
               });
          };
     */

     const [ count, setCount ] = useState(1);
     /*
     count라는 상태변수를 통해 현재 설문 페이지의 상태를 나타냄.
     count가 1일 때는 Test07Input 화면, 2일 때는 Test07Print 화면, 3일 때는 Test07Output 화면을 보여줌.
     */

     const onNext = () => {
          if ( count < 3 ) {
               setCount(count + 1);
          }
     };
     /*
     Next 함수는 '다음' 버튼이 클릭될 때 호출되며, 설문 페이지를 다음 단계로 이동시킴.
     count가 3보다 작을 때만 count 값을 증가시켜 페이지를 이동할 수 있도록 제어함.
     */

     const onPrev = () => {
          if ( count > 1 ) {
               setCount(count - 1);
          }
     };
     /*
     Prev 함수는 '이전' 버튼이 클릭될 때 호출되며, 설문 페이지를 이전 단계로 이동시킴.
     count가 1보다 클 때만 count 값을 감소시켜 페이지를 이전 단계로 이동시킬 수 있음.
     */

     return (
          <div className='wrap'>
               {/* 
               count의 상태에 따라 다른 컴포넌트를 렌더링함.
               count === 1이면 Test07Input 컴포넌트를 보여주고,
               count === 2이면 Test07Print 컴포넌트를,
               count === 3이면 Test07Output 컴포넌트를 렌더링함.
               */}
               {/* 함수 && 참이라면 ~ 해당 함수 변수 = { 값 } */}
               {
                    count === 1 && <Test07Input dto={ dto } onChange={ onChange } onNext={ onNext } />
               }
               {
                    count === 2 && <Test07Print dto={ dto } onPrev={ onPrev } onNext={ onNext } />
               }
               {
                    count === 3 && <Test07Output dto={ dto } />
               }

          </div>
     );
};

export default Test07Main;
