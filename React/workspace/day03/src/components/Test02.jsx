import React, { useState } from 'react';

const Test02 = () => {

     const [chk, isChk] = useState(false); // 상태변수 값 ( default : false )

     const onInputChk = (e) => {
          console.log(e.target);
          const { checked } = e.target;
          isChk(checked);
     }; // <input type="checkbox">



     return (
          //  만약 chk 가 참이면 글자색을 blue, 거짓이면 hotpink
          <div style={ { color: chk ? 'blue' : 'hotpink', fontSize: 25, margin: 30 } } >
               <input type='checkbox' checked={ chk } onChange={ onInputChk } /> Hava a nice day !!
          </div>
     );
};

export default Test02;