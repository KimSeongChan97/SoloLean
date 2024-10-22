import React, { useState } from 'react';
import '../css/Test06.css';

const Test06 = () => {
     // useState를 사용하여 'list'라는 상태 변수를 선언하고, 초기값으로 객체 배열을 설정합니다.
     // 각 객체는 'seq', 'name', 'age', 'addr', 'done'과 같은 사람의 정보를 담고 있습니다.
     // 'seq'는 번호, 'name'은 이름, 'age'는 나이, 'addr'은 주소, 'done'은 동의 여부를 나타냅니다.
     const [list, setList] = useState([
          { seq: 1, name: '홍길동', age: 20, addr: '서울', done: true},
          { seq: 2, name: '라이언', age: 25, addr: '제주', done: true},
          { seq: 3, name: '네오', age: 26, addr: '울산', done: false},
          { seq: 4, name: '프로도', age: 22, addr: '경기', done: true},
          { seq: 5, name: '코난', age: 28, addr: '부산', done: false}
     ]);
     // 'setList'는 상태를 업데이트할 때 사용되며, 현재는 데이터를 설정만 하고 있으므로 사용되지 않습니다.

     return (
          <div>
               <table className='list'>
                    {/* caption은 테이블의 제목 역할을 하며, 화면에 보이지 않도록 CSS에서 숨길 수 있습니다. */}
                    <caption>신 상 명 세 서</caption>

                    <colgroup>
                         {/* colgroup과 col 태그를 사용하여 각 열의 스타일을 정의합니다.
                             각 열은 seq(번호), name(이름), age(나이), addr(주소), done(동의여부) 클래스를 사용해
                             개별적인 스타일을 설정할 수 있습니다. */}
                         <col className='seq'></col>
                         <col className='name'></col>
                         <col className='age'></col>
                         <col className='addr'></col>
                         <col className='done'></col>
                    </colgroup>

                    <thead>
                         <tr>
                              {/* 테이블 헤더에 표시되는 제목으로, 각 열의 이름을 지정합니다. 
                                  번호, 이름, 나이, 주소, 동의 여부에 대한 제목을 지정했습니다. */}
                              <th>번호</th>
                              <th>이름</th>
                              <th>나이</th>
                              <th>주소</th>
                              <th>동의여부</th>
                         </tr>
                    </thead>

                    <tbody>
                         {/* map 함수를 사용하여 list 배열의 각 항목을 반복 처리하고 테이블 행을 생성합니다. 
                             map은 각 항목(item)에 대해 새로운 <tr>을 생성하며, 이때 고유한 key로 seq 값을 사용합니다. */}
                         { list.map(item => (
                                  <tr key={item.seq}> {/* 각 행의 고유한 key는 seq(번호)로 설정하여 React가 각 행을 구분할 수 있게 합니다. */}
                                       <td>{item.seq}</td> {/* 번호는 seq 값을 출력합니다. */}
                                       <td>{item.name}</td> {/* 이름은 name 값을 출력합니다. */}
                                       <td>{item.age}</td> {/* 나이는 age 값을 출력합니다. */}
                                       <td>{item.addr}</td> {/* 주소는 addr 값을 출력합니다. */}
                                       {/* 동의여부는 done 값이 true일 경우 '동의', false일 경우 '비동의'로 출력됩니다. 
                                           삼항 연산자를 사용하여 조건에 맞는 값을 출력합니다. */}
                                       <td>{item.done ? '동의' : '비동의' }</td>
                                  </tr>      
                         )) }
                    </tbody>
               </table>
          </div>
     );
};

export default Test06;

/*
  이 컴포넌트는 React의 useState를 이용해 테이블에 데이터를 동적으로 렌더링합니다.
  list 배열은 각 항목에 대해 번호, 이름, 나이, 주소, 동의여부 정보를 담고 있으며, 
  map 함수를 사용해 각 항목을 테이블의 행으로 렌더링합니다.

  각 행은 seq(번호), name(이름), age(나이), addr(주소), done(동의여부) 값을 각각의 셀에 출력합니다.
  동의여부(done)는 true일 때 '동의', false일 때 '비동의'로 출력되며, 삼항 연산자를 이용해 이 조건을 처리합니다.
  
  이 테이블은 사용자 인터페이스에서 데이터를 구조적으로 보여주는 데 유용하며, 추가적인 기능(데이터 변경 등)을 위해
  setList를 이용하여 상태를 업데이트할 수 있습니다. key 속성은 React에서 성능을 최적화하기 위해 각 행을 구분할 때 사용됩니다.
*/

/* 
  추가 분석:
  - useState: React의 Hook 중 하나로, 상태를 정의하고 변경할 수 있습니다. 여기서는 'list'라는 배열 상태를 정의하였으며, setList를 통해 이 상태를 변경할 수 있습니다.
  - map 함수: 배열의 각 요소를 순회하며, 새로운 JSX 요소(여기서는 <tr>)를 반환합니다. 이를 통해 동적으로 여러 행을 생성할 수 있습니다.
  - 삼항 연산자: item.done의 값에 따라 '동의' 또는 '비동의'라는 텍스트를 출력합니다. 'true'일 때 '동의', 'false'일 때 '비동의'가 됩니다.
  - key: React가 각각의 <tr>을 구분할 수 있도록 고유한 key를 seq 값으로 지정하여, 성능 최적화와 오류 방지에 도움을 줍니다.
*/
