import React from 'react';

const Output = ({ name, fruit }) => {
    return (
        <div>
            <h3>
            {/* 입력된 이름과 과일명을 출력 */}
            <p> 현재 {name} 님이 좋아하는 과일은 {fruit} 입니다.</p>
            </h3>
        </div>
    );
};

export default Output;
