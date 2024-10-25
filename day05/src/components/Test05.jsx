import React, { useEffect, useMemo, useState } from 'react';

import styles from '../css/Test05.module.css'; 

const user = [
    { id: 1, name: '홍길동' },
    { id: 2, name: '장이수' },
    { id: 3, name: 'cat' },
    { id: 4, name: '마동석' },
    { id: 5, name: 'daum' },
    { id: 6, name: '이수혁' },
    { id: 7, name: 'naver' },
    { id: 8, name: 'DAUM' },
    { id: 9, name: 'NAVER' },
    { id: 10, name: '이재용' }
]

// 검색 관련 로직을 연습해보자
const Test05 = () => {
    const [list, setList] = useState(user); 
    const [text, setText] = useState(''); 
    const [search, setSearch] = useState(''); 

     // 검색 버튼
     /*
     const onSearch = () => {
               setList(
                    // user 배열의 각 항목을 필터링하여, 검색어와 일치하는 항목들만 list 상태에 설정합니다.
                    // user.filter(item => item.name.toLowerCase().indexOf(text.toLowerCase()) !== -1)
                    user.filter(item => item.name.toLowerCase().includes(text.toLowerCase()))
               ); // 입력된 검색어 text를 소문자로 변환하여 user 배열의 각 항목과 비교한 후 일치하는 항목만 필터링합니다.
               // toLowerCase()를 사용하여 대소문자에 상관없이 검색할 수 있습니다.
          };
          */

     // 검색 버튼 - useMemo
     // useMemo는 search 상태가 변경될 때마다 특정 검색 결과를 다시 계산하여 성능을 최적화합니다.
     // 검색어가 바뀌어도 search 상태가 변경되지 않으면 다시 계산하지 않으므로 성능을 높입니다.
     useMemo(() => {
          return setList(
               user.filter(item => item.name.toLowerCase().includes(text.toLowerCase()))
          ); // user 배열에서 검색어를 포함하는 항목만 필터링하여 list 상태에 저장합니다.
          // toLowerCase()로 대소문자를 무시하고 검색할 수 있도록 합니다.
     }, [search]); // search 상태가 바뀔 때마다 useMemo 훅이 실행됩니다.

     // 검색 버튼이 클릭되면 text 상태의 현재 값을 search 상태에 저장합니다.
     // search가 변경됨으로써 useMemo가 다시 실행되어 검색 결과를 필터링합니다.
     const onSearch = () => {
          setSearch(text);
     };

     // 글자가 바뀌면 바로 검색되게 하는 것입니다.
     // 사용자가 입력한 text 상태가 변경될 때마다 검색 결과를 즉시 필터링하여 list 상태에 반영합니다.
     useEffect(() => {
          setList(user.filter(item => item.name.toLowerCase().includes(text.toLowerCase())))
     }, [text]); // text 상태가 변경될 때마다 useEffect 훅이 실행됩니다.

     // onChange 함수는 input 필드에서 사용자가 입력한 값을 text 상태에 저장합니다.!!
     const onChange = (e) => {
          setText(e.target.value); // 입력한 값을 text 상태에 저장하여 실시간으로 관리합니다.
          // 사용자가 입력할 때마다 text 상태가 업데이트되어 검색어가 바뀔 때마다 즉시 반영됩니다.
     };


    return (
        <div>
            <input
                type='text'
                value={text}
                onChange={onChange} 
                className={styles.inputBox} /> &nbsp; 
            <button
                onClick={onSearch} 
                className={styles.searchBtn}> 
                검색
            </button>
            <ul>
                {
                    list.map(
                        item => (
                            <li key={item.id} className={styles.listItem}> 
                                {item.id} / {item.name} 
                            </li>
                        )
                    )
                }
            </ul>
        </div>
    );
};

export default Test05;
