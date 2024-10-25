import React, { useEffect, useState } from 'react';
const Test01 = () => {

    // 배우 이름들을 배열로 저장. 배열의 각 요소는 '이름'이다.
    // split(',')을 사용하여 문자열을 ',' 기준으로 나누어 배열로 변환
    const names = '안효섭,이제훈,유연석,김세정,김태리,여진구,이동욱,공유,아이유,이준기,설인아'.split(',');
    
    // name과 age는 각각 '홍길동'과 25로 초기화된 상태
    // useState를 사용해 상태 값을 정의
    // 상태 값이 변경되면 컴포넌트가 다시 렌더링된다.
    const [name, setName] = useState('홍길동'); 
    const [age, setAge] = useState(25); 

    // 이름을 랜덤으로 변경하는 함수
    const onName = () => {
        // 0부터 10까지의 랜덤한 정수를 생성하여 배열의 인덱스로 사용
        const index = Math.floor(Math.random() * 11); // 0에서 10 사이의 정수값을 반환
        // names 배열에서 해당 인덱스의 값을 가져와 setName으로 상태 업데이트
        setName(names[index]); 
    };
    
    // 나이를 1 증가시키는 함수
    const onAge = () => {
        setAge(age + 1); // 현재 age 상태에서 1을 더해 업데이트
    };

    // 나이를 1 감소시키는 함수
    const onAgeDown = () => {
        setAge(age - 1); // 현재 age 상태에서 1을 빼서 업데이트
    };

    // 거의 사용 X
    // 값이 바뀌기만 하면 실행이 된다. ( memory 를 많이 소요)
    // 그래서 불필요한 사용이 많다.
    /*
    useEffect(() => {
        // 컴포넌트가 렌더링될 때마다 이 함수가 실행됨
        // 값을 추적하지 않으면 렌더링 될 때마다 실행되므로 메모리 낭비 가능성이 있음
        console.log('안녕하세요');
    });
    */
    /*
    // 마운트 될 때 1번만 실행 할려면..
    useEffect(() => {
        // 처음 컴포넌트가 화면에 나타날 때만 실행됨
        // 두 번째 인자로 빈 배열([])을 전달하면, 이 배열 안에 의존성 값이 없으므로
        // 렌더링이 발생해도 이 코드는 딱 한 번만 실행됨
        console.log('안녕하세요');
    }, []); // , [] 을 추가하면 된다.
    */
    
    // 마운트, name 값이 바뀔 때만 실행 할려면..
    useEffect(() => {
        // 컴포넌트가 처음 마운트될 때 한 번 실행되고, name 값이 변경될 때마다 실행됨
        // name이라는 상태가 의존성 배열에 포함되어 있기 때문에 name이 변할 때만 이 함수가 호출된다.
        console.log('안녕하세요');
    }, [name]); // props 의 name 값을 기입하면 된다. 

    return (
        <div>
            {/* onName, onAge, onAgeDown 함수가 버튼 클릭 시 호출됨 */}
            <button onClick={onName}>이름 변경</button>
            <button onClick={onAge}>나이 증가</button>
            <button onClick={onAgeDown}>나이 감소</button>
            <hr/>
            {/* name과 age 상태값이 UI에 반영됨 */}
            <h1> {name} </h1> 
            <h1> {age} </h1>
        </div>
    );
};

export default Test01;


/*
useEffect란?
useEffect는 렌더링, 혹은 변수의 값 혹은 오브젝트가 달라지게 되면, 그것을 인지하고 업데이트를 해주는 함수이다.
useEffect는 콜백 함수를 부르게 되며, 렌더링 혹은 값, 오브젝트의 변경에 따라 어떠한 함수 혹은 여러 개의 함수들을 동작시킬 수 있다.
렌더링 후 useEffect는 무조건 한번은 실행된다.

[형식] 
① 컴포넌트가 나타날 때 딱 1번만 함수가 호출
useEffect( () => {
}, [ ]);

② 특정 props가 바뀔 때마다 함수가 호출
useEffect( () => {
}, [ props ]);

useEffect 라는 Hook을 사용하여 할 수 있는 3가지 동작
- 컴포넌트가 마운트 됐을 때 (처음 나타났을 때)
- 언 마운트 됐을 때 (사라질 때)
- 업데이트될 때 (특정 props가 바뀔 때)

[ ]로 설정하면 컴포넌트가 처음 나타날 때만 useEffect에 등록한 함수가 호출 한다.

useEffect 에서는 함수를 반환 할 수 있는데 이를 cleanup 함수라고 부른다. 
cleanup 함수는 useEffect 에 대한 뒷정리를 해준다고 이해하면 되는데, 
[ ] 안에 내용이 비어 있는 경우에는 컴포넌트가 사라질 때 cleanup 함수가 호출된다.
/

/
실행하면 콘솔창에 UseEffect는 왜 두번 실행되는걸까?

[해결 방법]
index.js
=> <React.StrictMode> 부분을 주석으로 처리

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    //<React.StrictMode>
        <App />
    //</React.StrictMode>
);

React의 Strict Mode ?
StrictMode는 리액트에서 제공하는 검사 도구이다.
개발 모드일 때 디버그를 통하여, 이 태그로 감싸져있는 App 컴포넌트와 자손까지 검사하는 것이다.
안전하지 않은 생명 주기를 가진 컴포넌트, 권장되지 않은 부분, 배포 후 문제가 될 수 있는 부분들까지 미리 확인하는 것이다.

creat-react-app으로 앱을 만들었기 때문에 기본적으로 생성되어 랜더링을 두 번이나 했었던 것이다.
*/
