import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Member from './Member';

const Main = () => {

     // 회원 목록을 저장할 list 상태 변수를 선언하고 빈 배열로 초기화합니다.
     const [ list, setList ] = useState([]); // list 상태를 빈 배열로 초기화하여 데이터를 저장할 예정

     useEffect(() => {
          // 컴포넌트가 처음 렌더링될 때 실행되는 useEffect
          // axios.get() 메서드를 통해 'https://koreanjson.com/users' URL에서 데이터를 가져옴
          axios.get('https://koreanjson.com/users')
               .then(res => setList(res.data)) // 서버 응답(res.data)을 list 상태로 설정
               // .then() 메서드는 비동기 호출이 성공적으로 완료되면 실행되고, res.data에는 서버로부터 전달된 데이터가 있음
               // setList 함수를 통해 응답 데이터를 list 상태에 저장
         
     }, []); // 빈 배열을 의존성으로 설정하여 컴포넌트가 마운트될 때 한 번만 실행

     return (
          <div>
               {/* list 배열의 길이를 사용하여 회원 수를 표시 */}
               <h1> Main Page / 회원수 { list.length } </h1>
               {
                    // list 배열을 map() 메서드를 사용하여 순회하면서 각 항목을 렌더링
                    // 각 항목은 Member 컴포넌트를 통해 개별 회원 정보를 표시합니다.
                    list.map(item => <Member key={ item.id } item={ item } /> )
                }
          </div>
     );
};

export default Main;
