// Test08Item.jsx
import React from 'react';

const Test08Item = ({ item, onView }) => {
    const { id, img, title } = item; // 아이템에서 id, img, title 추출

    return (
        // li 태그를 클릭하면 해당 아이템의 id를 onView 함수에 전달
        <li onClick={() => onView(id)}>
            {/* 이미지 출력 */}
            <img src={img} alt={title} />
        </li>
    );
};

export default Test08Item;
