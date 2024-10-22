import React from 'react';
// React 라이브러리를 가져옵니다. React는 UI를 구성하는 라이브러리로, 함수형 컴포넌트로 화면을 정의할 수 있습니다.

const Test02 = () => {
    // Test02라는 함수형 컴포넌트를 정의합니다. 함수형 컴포넌트는 간단한 UI를 반환하는 함수로, 리액트의 주요 컴포넌트 형태 중 하나입니다.
    
    const title = '신상명세서';
    // title 변수는 '신상명세서'라는 문자열을 가지고 있으며, JSX 내부에서 제목으로 사용됩니다.
    
    const arr = ['홍길동', '코난', '둘리', '라이언', '네오'];
    // arr 변수는 문자열로 구성된 배열로, 각 인물의 이름을 포함하고 있습니다.

    const data = [
        { id: 1, name: '홍길동' },
        { id: 2, name: '코난' },
        { id: 3, name: '둘리' },
        { id: 4, name: '라이언' },
        { id: 5, name: '네오' }
    ];
    // data 변수는 객체 배열로, 각 객체는 id와 name 속성을 가집니다. 이 배열은 신상명세서를 더 구체적으로 표현하기 위해 사용됩니다.

    return (
        <div>
            <h2>{title}</h2>
            {/* title 변수 값을 h2 태그를 통해 화면에 출력합니다. 여기서는 '신상명세서'라는 텍스트가 표시됩니다. */}
            
            <ul>
                {/* arr 배열을 map 함수를 이용해 순회하여 각각의 항목을 출력합니다. */}
                {/* arr 를 map 으로 반복하여 출력
                    0 : 홍길동 
                    1 : 코난 ...
                */}
                
                {/* rendering 시 unique  한 key 값으로 지정해야함 */}
                {/* React에서는 리스트 항목을 렌더링할 때 각 항목을 고유하게 구분할 수 있는 key 값을 필수로 지정해야 합니다. */}
                
                {
                    // map 을 사용 할 때는 반드시 key 라는 속성을 주어야 한다
                    arr.map((item, index) => (
                        // map 함수는 배열의 각 요소를 순회하여 새로운 JSX 요소를 반환합니다.
                        // index는 배열의 현재 요소의 인덱스(0부터 시작)를 나타내며, item은 각 요소의 값(이름)을 나타냅니다.
                        <li key={index}>
                            {/* key 속성은 React가 리스트를 효율적으로 렌더링하는 데 필요합니다. index를 key로 사용하여 각 항목을 고유하게 식별합니다. */}
                            {index} : {item}
                            {/* {index}는 배열의 인덱스, {item}은 배열의 실제 값을 출력합니다. */}
                        </li>
                    ))
                }
            </ul>
            <hr />
            <ul>
                {/* data 배열을 map 함수로 순회하여 각 객체의 id와 name을 출력합니다. */}
                {/* data 를 map 으로 반복
                    1 : 홍길동
                    2 : 코난 ...
                */}
                {
                    data.map(item => (
                        // data 배열의 각 요소는 객체로, 객체의 id를 key로 사용하여 고유하게 식별합니다.
                        <li key={item.id}>
                            {/* 각 객체의 id와 name을 출력합니다. id는 key로 사용되어 고유성을 보장합니다. */}
                            {item.id} : {item.name}
                            {/* {item.id}는 객체의 고유 번호, {item.name}은 객체의 이름을 출력합니다. */}
                        </li>
                    ))
                }
            </ul>
        </div>
    );
};

export default Test02;
// Test02 컴포넌트를 외부에서 사용할 수 있도록 export default로 내보냅니다. 다른 파일에서 import를 통해 이 컴포넌트를 사용할 수 있습니다.