import React from 'react';

const Test05Sub = (props) => {
    // props에서 전달된 값들을 구조 분해 할당으로 받습니다.
    const { name, age, addr, tel, color, bgcolor, done } = props;

    return (
        <div>
            <h2> 신 상 명 세 서 </h2>
            <ul style={{ color: color, backgroundColor: bgcolor }}>
                <li> 이름 : {name} </li>
                <li> 나이 : {age} </li>
                <li> 주소 : {addr} </li>
                <li> 번호 : {tel} </li>
                {/* 동의 여부는 삼항 연산자로 처리하여 true일 경우 '동의', false일 경우 '비동의'를 출력합니다. */}
                <li> 동의여부 : {done ? '동의' : '비동의'} </li>
            </ul>
        </div>
    );
};

export default Test05Sub;
