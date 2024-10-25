// Test08Gallary.jsx
import React, { useState } from 'react';
import dataList from './Test08Data'; // Test08Data에서 데이터를 가져옴
import Test08View from './Test08View'; // Test08View 컴포넌트를 가져옴
// import '../css/Test08.css'; // 외부 CSS 파일을 가져옴

const Test08Gallary = () => {
    // 상태 관리: 'list'는 전체 데이터 리스트, 'setList'는 그 리스트를 갱신하는 함수
    const [list, setList] = useState(dataList); 
    // 상태 관리: 'one'은 현재 선택된 아이템, 'setOne'은 선택된 아이템을 갱신하는 함수
    const [one, setOne] = useState(list[1]); // 기본적으로 두 번째 아이템을 선택함

    // onView 함수는 특정 ID를 가진 아이템을 선택했을 때 'one' 상태를 업데이트하는 역할
    const onView = (id) => {
        setOne(list[id - 1]); // id가 1부터 시작하므로 배열 인덱스에 맞추기 위해 id-1로 접근
    };

    return (
        <div className='wrap2'>
            {/* Test08View 컴포넌트에 list, one, onView를 전달 */}
            <Test08View list={list} one={one} onView={onView} />
        </div>
    );
};

export default Test08Gallary;

/*

public
     index.html(file) // HTML 파일이 public 폴더에 위치
     image(folder) // 이미지 폴더
          dog01... // 이미지 파일들

src
     App.js(file) // 리액트 메인 파일
     components(folder) // 컴포넌트들을 모아둔 폴더
          Test08Gallary.jsx // 갤러리 컴포넌트
          Test08View.jsx // 뷰 컴포넌트
          Test08List.jsx // 리스트 컴포넌트
          Test08Item.jsx // 리스트 아이템 컴포넌트
          Test08Big.jsx // 큰 이미지 컴포넌트
          Test08Data.jsx // 데이터 파일
*/

