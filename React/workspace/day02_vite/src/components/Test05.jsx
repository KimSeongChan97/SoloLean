import React, { useState } from 'react';

const Test05 = () => {
     const [ count, setCount ] = useState(0);

     const onAdd = () => {
          setCount(count + 1);
     };
     const onSub = () => {
          setCount(count - 1);     
     };
     const onReset = () => {
          setCount(0);
     };

     const num = count;

     return (
          <div>
               <h2> 숫자 : { num } </h2>
               <p>
                    <button onClick={ onAdd }>1씩 증가</button>
                    <button onClick={ onSub }>1씩 감소</button>
                    <button onClick={ onReset }>초기화</button>
               </p>
          </div>
     );
};

export default Test05;


// 상태변수 count 기본값은 0