import React, { useState } from 'react';

// 함수형 컴포넌트인 Test03을 정의합니다. 이 컴포넌트는 React의 Hook을 사용해 상태를 관리합니다.
const Test03 = () => {
     // useState는 현재 컴포넌트 내에서 상태값을 저장하고 변경하는 데 사용됩니다.
     // '홍길동'은 name의 초기값이고, setName은 name을 변경할 수 있는 함수입니다.
     const [name, setName] = useState('홍길동');

     // age와 setAge도 마찬가지로 useState로 관리되며, 초기값은 '25'입니다.
     const [age, setAge] = useState('25');

     // color는 배경색을 관리하며 초기값은 'cyan'입니다. setColor는 color 값을 변경하는 함수입니다.
     const [color, setColor] = useState('cyan');
     // Setter, Getter 와 같은 역할
     // useState로 설정된 값들은 setter 함수(setName, setAge, setColor)를 사용해 값을 변경합니다.

     // onName 함수는 이름을 '코난'으로 변경하는 역할을 합니다.
     const onName = () => {
          setName('코난');
          // setName을 통해 name 상태를 '코난'으로 변경합니다.
          // 이 함수는 버튼을 클릭했을 때 호출되어 name의 값을 변경합니다.
     };

     // onAge 함수는 전달된 인자(age)를 사용해 나이를 변경하는 함수입니다.
     const onAge = (age) => {
           setAge(age);    
           // onAge 함수는 파라미터로 받은 나이를 setAge를 통해 상태로 저장합니다.
           // 즉, onAge(30)을 호출하면 age가 30으로 바뀝니다.
     };

     // onColor 함수는 전달된 인자(color)를 사용해 배경색을 변경하는 함수입니다.
     const onColor = (color) => {
          setColor(color);
          // 마찬가지로 setColor를 사용하여 전달된 색상 값으로 상태를 업데이트합니다.
          // 예를 들어, onColor('yellow')를 호출하면 배경색이 노란색으로 변경됩니다.
     };

     // 컴포넌트가 렌더링되는 부분입니다. JSX 문법으로 구성되어 있습니다.
     return (
          <div>
               {/* style 속성은 객체 형식으로 전달되며, 여기서는 backgroundColor 속성에 color 상태가 적용됩니다.
                   즉, color 값에 따라 <h2> 태그의 배경색이 바뀝니다. */}
               <h2 style={{ backgroundColor: color }}>
                    이름 : { name }  /  {/* name 상태 값을 화면에 표시합니다. */}
                    나이 : { age }  {/* age 상태 값을 화면에 표시합니다. */}
               </h2>   

               <p>
                    {/* setName('홍길동')을 호출하여 name 값을 '홍길동'으로 변경합니다.
                        버튼을 클릭하면 name 상태가 '홍길동'으로 변경됩니다. */}
                    <button onClick={ () => setName('홍길동') }> 이름을 홍길동으로 변경 하는 함수 </button>

                    {/* onName 함수를 호출하여 name 값을 '코난'으로 변경합니다.
                        이 버튼을 클릭하면 name 상태가 '코난'으로 변경됩니다. */}
                    <button onClick={ onName }> 이름을 코난으로 변경 하는 함수 </button>

                    {/* onAge(30)을 호출하여 age 값을 30으로 변경합니다.
                        버튼을 클릭하면 age 상태가 30으로 변경됩니다. */}
                    <button onClick={ () => onAge(30) }> 나이를 30으로 변경 하는 함수 </button>

                    {/* setAge(35)를 호출하여 age 값을 35으로 변경합니다.
                        버튼을 클릭하면 age 상태가 35으로 변경됩니다. */}
                    <button onClick={ () => setAge(35) }> 나이를 35으로 변경 하는 함수 </button>

                    {/* onColor('yellow')를 호출하여 배경색을 노란색으로 변경합니다.
                        버튼을 클릭하면 color 상태가 'yellow'로 변경되어 배경색이 노란색으로 바뀝니다. */}
                    <button onClick={ () => onColor('yellow') }> 바탕색을 노란색으로 변경 하는 함수 </button>

                    {/* setColor('cyan')을 호출하여 배경색을 cyan으로 변경합니다.
                        버튼을 클릭하면 color 상태가 'cyan'으로 변경되어 배경색이 cyan으로 바뀝니다. */}
                    <button onClick={ () => setColor('cyan') }> 바탕색을 Cyan색으로 변경 하는 함수 </button>
               </p>       
          </div>
     );
};

export default Test03;


/*
Hook ?

https://ko.reactjs.org/docs/hooks-state.html

Hook은 React 16.8버전에 새로 추가되었습니다.
Hook은 클래스 컴포넌트를 작성하지 않아도 state와 같은 특징들을 사용할 수 있습니다.

Hook의 개요

함수형 컴포넌트는 렌더링할때마다 내부의 것들을 기억하지 못한다.
다시 생성, 초기화 해야한다. (변수, 함수 등)

내부의 것들을 유지하기 위해서 hook이 등장했다 - useXXX

useState
값이 유동으로 변할 때

[형식]
const [변수명, 변수의 함수] = React.useState(초기값);
const [상태데이터, 상태데이터의 값을 변경해주는 함수] = React.useState(초기값);

*/

// 위 주석은 React의 Hook 개념에 대한 설명이며, useState Hook을 통해 상태 관리를 할 수 있는 방식에 대한 기본적인 설명을 담고 있습니다.
// 여기에서 사용된 useState는 name, age, color와 같은 상태를 관리하기 위한 것입니다.
// 리액트는 함수형 컴포넌트가 상태를 기억하지 못하는 문제를 해결하기 위해 useState와 같은 Hook을 도입했습니다.
