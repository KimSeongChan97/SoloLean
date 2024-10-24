// Test08Big.jsx
import React from 'react';

const Test08Big = ({ one }) => {
    const { id, img, title } = one; // 선택된 아이템에서 id, img, title 추출

    return (
        <div className='bigimg'>
            {/* 현재 선택된 이미지의 제목을 h2 태그로 출력 */}
            <h2>{title}</h2>
            {/* 큰 이미지로 출력 */}
            <img src={img} alt={title} />
        </div>
    );
};

export default Test08Big;
