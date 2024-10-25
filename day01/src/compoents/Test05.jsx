import React from 'react';
import Test05Sub from './Test05Sub';

const Test05 = () => {
     return (
          <div>
               <Test05Sub name = '홍길동'
                          age = { 20 }
                          addr = '서울'
                          tel = '010-1234-5678'
                          color = 'tomato'
                          bgcolor = 'pink'
                          done = { true } />
               <hr/>
               <Test05Sub name = '김도치'
                          age = { 25 }
                          addr = '경기'
                          tel = '010-1235-5678'
                          color = 'hotpink'
                          bgcolor = 'skyblue'
                          done = { false } />           
          </div>
     );
};

export default Test05;