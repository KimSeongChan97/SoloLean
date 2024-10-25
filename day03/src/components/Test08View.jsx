// Test08View.jsx
import React from 'react';
import Test08Big from './Test08Big'; // 큰 이미지를 보여주는 컴포넌트
import Test08List from './Test08List'; // 이미지 목록을 보여주는 컴포넌트

const Test08View = ({ list, one, onView }) => {
    return (
        <div className='bigView'>
            {/* Test08Big 컴포넌트에 현재 선택된 이미지 정보를 전달 */}
            <Test08Big one={one} />

            {/* Test08List 컴포넌트에 전체 리스트와 클릭 시 호출되는 onView 함수 전달 */}
            <Test08List list={list} onView={onView} />
        </div>
    );
};

export default Test08View;
