// Test08List.jsx
import React from 'react';
import Test08Item from './Test08Item'; // 리스트 내 각 아이템을 보여주는 컴포넌트

const Test08List = ({ list, onView }) => {
    return (
        <ul className='list'>
            {
                // list 배열을 map 함수를 사용해 각각의 아이템을 Test08Item 컴포넌트로 렌더링
                list.map(item => <Test08Item key={item.id} item={item} onView={onView} />)
            }
        </ul>
    );
};

export default Test08List;
