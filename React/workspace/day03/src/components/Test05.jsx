import React, { useState } from 'react';
import Name from './Name';
import Fruit from './Fruit';
import Output from './Output';

const Test05 = () => {
    // useState 훅을 사용하여 'name'과 'fruit' 상태 변수를 선언
    // 'name'은 사용자가 입력한 이름을 저장하고,
    // 'fruit'은 사용자가 입력한 좋아하는 과일명을 저장합니다.
    const [ name, setName ] = useState('');
    const [ fruit, setFruit ] = useState('');

    // 이름 입력이 변경되면 실행되는 함수
    // 이벤트 객체 e에서 입력된 값을 가져와서 'name' 상태에 반영합니다.
    const NameChange = (e) => {
        setName(e.target.value);  // 입력된 이름을 name 상태에 저장
    };

    // 과일 입력이 변경되면 실행되는 함수
    // 이벤트 객체 e에서 입력된 값을 가져와서 'fruit' 상태에 반영합니다.
    const FruitChange = (e) => {
        setFruit(e.target.value);  // 입력된 과일명을 fruit 상태에 저장
    };

    // 컴포넌트 렌더링 부분
    // Name, Fruit, Output 컴포넌트를 사용하며, 상태와 상태 변경 함수를 각각 전달
    return (
        <div>
            {/* Name 컴포넌트에 name 상태값과 NameChange 이벤트 핸들러를 전달 */}
            <Name name={name} onChange={ NameChange } />
            {/* Fruit 컴포넌트에 fruit 상태값과 FruitChange 이벤트 핸들러를 전달 */}
            <Fruit fruit={fruit} onChange={ FruitChange } />
            {/* Output 컴포넌트에 name과 fruit 상태값을 전달 */}
            <Output name={name} fruit={fruit} />
        </div>
    );
};

export default Test05;

// 상태변수 : name, fruit
// Name.jsx -> 이름 입력 : {name}
// Fruit.jsx -> 과일명 입력 : {fruit}
// Ouput.jsx -> {name} 님이 좋아하는 과일은 {fruit} 입니다.
