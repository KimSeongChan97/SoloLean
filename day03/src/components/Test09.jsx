import React from 'react';

import img01 from '../image/chi1.jpeg';
import img02 from '../image/chi2.jpeg';
import img03 from '../image/chi3.jpeg';
import img04 from '../image/chi4.jpeg';

const Test09 = () => {
     return (
          <div>
               <img src = { img01 } alt='치이카와1' style={{ width: ' 200px', height: '200px' }} /> &emsp;
               <img src = { img02 } alt='치이카와2' style={{ width: ' 200px', height: '200px' }} /> &emsp;
               <img src = { img03 } alt='치이카와3' style={{ width: ' 200px', height: '200px' }} /> &emsp;
               <img src = { img04 } alt='치이카와4' style={{ width: ' 200px', height: '200px' }} /> &emsp;

          </div>
     );
};

export default Test09;

/*

 src 안에 있는 이미지 파일 처리는 참조변수를 사용한다.

  [ 형식 ]
 import 참조변수 from '이미지경로';

 */