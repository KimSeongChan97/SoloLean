import React, { useState, useRef, useEffect } from 'react'; 
// React에서 useState와 useRef 훅을 사용하여 상태와 참조를 관리함.
// useState: 컴포넌트에서 상태를 관리하는 훅으로, 상태가 변경되면 컴포넌트가 다시 렌더링됨.
// useRef: 특정 DOM 요소나 값을 기억하는 훅으로, 값이 변경되어도 컴포넌트가 다시 렌더링되지 않음. 주로 컴포넌트 렌더 간에 값을 유지하기 위해 사용함.
// useEffect: 컴포넌트가 마운트되거나 업데이트될 때 특정 작업을 수행할 수 있게 해주는 훅. 주로 비동기 작업이나 외부 데이터를 가져올 때 사용함.

import TodoForm from './TodoForm'; 
import TodoList from './TodoList'; 

import TodoStyle from '../css/Todos.module.css'; 


const Todos = () => {
    // const [list, setList] = useState([]); // 할 일 목록을 저장하는 상태. 초기값은 빈 배열.
    // list는 현재까지 추가된 모든 할 일의 배열로, 각 항목은 객체 형태로 저장됨.
    // setList는 list 상태를 업데이트하는 함수로, 새로운 할 일을 추가하거나 삭제할 때 사용됨.
    // 이 부분이 주석처리된 이유는 로컬스토리지에서 데이터를 가져와 초기화하는 방식으로 대체되었기 때문임.

    // const [list, setList] = useState([]); 를 주석처리하고 사용됨.
    // Local Storage 읽어오기
    const [list, setList] = useState(JSON.parse(localStorage.getItem('list')) || [] ); 
    // 로컬 스토리지에서 'list'라는 키를 통해 할 일 목록을 불러옴. 
    // 만약 로컬 스토리지에 데이터가 없으면 빈 배열([])을 초기값으로 사용함.
    // JSON.parse는 문자열로 저장된 데이터를 실제 JavaScript 객체로 변환하는 함수임.
    // JSON.stringify와 함께 자주 사용되며, 로컬스토리지에서 객체를 저장하고 불러올 때 필수적임.
    // 로컬스토리지는 브라우저에 데이터를 영구적으로 저장할 수 있는 메커니즘임.

    // Local Storage 저장하기 -> list(배열)이 바뀔 때마다 저장
    useEffect(() => {
        // useEffect는 list 배열이 변경될 때마다 실행됨.
        // setItem(키값, 밸류), JSON의 형식을 문자열로 변환하여 list에 저장
        localStorage.setItem('list', JSON.stringify(list))
        // 로컬 스토리지에 list 배열을 JSON 형태로 문자열로 변환해 저장함.
        // 이렇게 하면 페이지를 새로고침해도 기존에 추가한 할 일이 유지됨.
        // useEffect의 두 번째 인자인 [list]는 list가 변경될 때마다 이 함수를 실행하게 만듦.
        localStorage.setItem("lastSeq", seq.current);
    }, [list]);
    // useEffect의 두 번째 인자로 list를 넣어 주었기 때문에, list가 업데이트될 때마다 이 효과가 실행됨.
    // 이로 인해 할 일이 추가되거나 삭제될 때마다 로컬스토리지에 자동으로 업데이트됨.

const seq = useRef(parseInt(localStorage.getItem("lastSeq") || "1", 10));
// seq는 useRef 훅을 사용하여 선언되었으며, 할 일 항목에 고유한 순번(seq)을 부여하기 위한 역할을 한다.
// 이 값을 유지하는 이유는 컴포넌트가 다시 렌더링되어도 seq 값이 초기화되지 않고 유지되도록 하기 위함이다.

// useRef()를 사용한 이유는 무엇인가요?
// - useRef는 렌더링 사이에 값을 유지하며 컴포넌트가 다시 렌더링될 때도 값이 변경되지 않는다.
//   즉, 할 일을 추가하거나 삭제할 때마다 seq 값을 유지하면서 추가적인 순번을 계속적으로 증가시킬 수 있도록 해준다.
//   만약 이 값을 상태로 관리했다면 매 렌더링마다 업데이트가 일어나 불필요한 렌더링이 발생할 수 있다.
// - useRef로 생성한 변수는 값을 변경해도 컴포넌트를 다시 렌더링하지 않기 때문에 성능 측면에서도 유리하다.

// parseInt(localStorage.getItem("lastSeq") || "1", 10)
// - localStorage.getItem("lastSeq"): 로컬 스토리지에서 "lastSeq"라는 키로 저장된 값을 가져옴.
//   로컬 스토리지란 브라우저에 데이터를 영구적으로 저장하는 공간으로, 페이지를 새로고침해도 데이터가 유지된다.
// - 만약 "lastSeq" 값이 로컬 스토리지에 없다면, 즉 사용자가 처음으로 이 애플리케이션에 접근하거나 기존 데이터가 지워진 경우, 기본값으로 "1"을 사용함.
// - || "1": "lastSeq" 값이 null 또는 undefined일 경우 기본값으로 "1"을 사용하도록 함.
//   따라서 로컬 스토리지에 "lastSeq"가 없다면 seq의 초기값으로 1을 부여함.
// - parseInt(): 문자열을 정수로 변환하는 함수. 두 번째 인자로 10을 넣어 10진수로 변환하도록 지정함.
//   이렇게 하면 문자열로 저장된 로컬 스토리지 값을 숫자로 바꾸어 다음 순번을 생성할 수 있게 된다.

// 예시
// - 예를 들어, 사용자가 몇 가지 할 일 목록을 추가하고 이를 로컬 스토리지에 저장했다고 가정하자.
//   마지막으로 추가된 항목의 순번이 5라면, 로컬 스토리지에는 "lastSeq"라는 키 값으로 5가 저장되어 있을 것이다.
// - 이후 페이지를 새로고침하거나 사용자가 앱에 다시 접속했을 때, 위의 코드를 통해 "lastSeq" 값을 가져오게 된다.
//   따라서 seq의 초기값은 5 + 1 = 6이 되어, 새로운 할 일 항목에 순번을 부여할 때 중복되지 않는 고유 번호를 계속해서 사용할 수 있게 된다.

// seq.current
// - useRef로 생성한 객체는 .current라는 프로퍼티에 실제 값을 저장함.
//   따라서 seq.current를 통해 현재 seq의 값을 참조하거나 수정할 수 있다.
// - 예를 들어, 새로운 할 일 항목을 추가할 때마다 seq.current 값을 1씩 증가시켜 다음 항목에 고유 번호를 부여한다.
// - 이렇게 함으로써 각 항목마다 고유한 순번을 유지할 수 있으며, 새로 추가되는 항목들도 중복 없이 관리가 가능해진다.

    //const seq = useRef(list.length ? list[list.length - 1].seq + 1 : 1);
    // 각 할 일 항목에 고유 번호를 부여하기 위한 변수. useRef는 컴포넌트가 다시 렌더링되어도 값이 유지되도록 해줌.
    // list의 마지막 항목이 존재할 경우, 그 항목의 seq 값을 참조하여 +1 한 값을 초기값으로 설정함.
    // - list.length가 0이 아니면, 즉 할 일 목록이 존재하면 가장 마지막 할 일의 seq 값을 가져와서 +1을 하여 새로운 할 일의 seq로 설정
    // - list.length가 0이라면, 즉 할 일이 하나도 없는 경우에는 초기값을 1로 설정하여 첫 할 일 항목의 seq 값이 1이 되도록 함.
    // useRef를 사용하여 seq를 관리함으로써, list가 변경되어도 seq 값이 변하지 않으며 컴포넌트 재렌더링 없이 다음 항목의 seq 값을 참조할 수 있음.
    
    /*
    const seq = useRef(1); 
     각 할 일 항목의 고유 번호를 위한 참조 변수. useRef는 렌더링 사이에 값이 유지됨.
     seq는 각 할 일 항목에 고유한 번호(순번)를 부여하기 위한 변수로, 렌더링이 다시 일어나도 값이 유지됨.
     useRef로 선언된 변수는 값이 변경되어도 컴포넌트를 다시 렌더링하지 않음. 여기서는 할 일을 추가할 때마다 seq의 값을 1씩 증가시킴.
     seq는 직접 상태로 관리하지 않음으로써, 불필요한 렌더링을 방지하고 성능을 최적화함.
    */

    const onDel = (seq) => { 
        // 특정 seq를 가진 할 일을 삭제하는 함수.
        // 인자로 받은 seq를 기준으로 해당 항목을 목록에서 삭제함.
        setList(
            list.filter(item => item.seq !== seq) 
            // 선택한 seq와 일치하지 않는 할 일들만 필터링하여 새로운 리스트를 만듦.
            // filter 메서드는 배열을 순회하며 조건에 맞는 요소들만 새 배열로 반환하는 함수임.
            // 이 경우 item.seq가 삭제하고자 하는 seq와 다른 항목들만 남겨 새로운 배열을 생성함.
            // 그 결과 삭제하고자 하는 항목을 제외한 새로운 배열을 상태로 설정함.
        )
    }

    return (
        <div className={TodoStyle.Todos}> 
            {/* 전체 할 일 관리 UI를 감싸는 div. CSS 모듈로 스타일 적용. */}
            {/* TodoStyle에서 정의한 CSS 클래스명을 사용해 이 div에 스타일을 적용함. */}
            <h1>일정관리</h1> 
            {/* 일정관리 타이틀을 표시 */}
            <TodoForm seq={seq} list={list} setList={setList} /> 
            {/* 할 일 추가 폼을 렌더링하고 상태와 함수들을 전달. */}
            {/* TodoForm 컴포넌트에 seq, list, setList를 props로 전달하여 할 일 추가 기능을 구현함. */}
            {/* TodoForm은 사용자가 새로운 할 일을 입력할 수 있는 폼이며, 제출 시 새로운 할 일을 list에 추가하는 기능을 함. */}
            <br/>
            <TodoList list={list} onDel={onDel} /> 
            {/* 할 일 목록을 렌더링하고 삭제 함수를 전달. */}
            {/* TodoList 컴포넌트에 현재 할 일 목록과 삭제 기능을 props로 전달하여, 사용자가 추가한 할 일 목록을 보여주고 삭제할 수 있게 함. */}
        </div>
    );
};

export default Todos;

/*
데이터 읽기, 쓰기

웹 스토리지
HTML5에서 추가된 기술로 로컬스토리지와 세션스토리지로 구분된다.

특징
웹 스토리지는 Key와 Value 형태로 이루어졌다.
웹 스토리지는 클라이언트에 대한 정보를 저장한다.
웹 스토리지는 로컬에만 정보를 저장하고 쿠키는 서버와 로컬에 정보를 저장한다.

종류
로컬스토리지 (localStorage) - 클라이언트에 대한 정보를 영구적으로 저장
세션스토리지 (sessionStorage) - 세션 종료 시(브라우저 닫을 경우) 클라이언트에 대한 정보 삭제

장점
서버에 불필요하게 데이터를 저장하지 않는다. (백엔드에 절대로 전송되지 않는다.)
저장 가능한 데이터의 용량이 크다. (약 5Mb, 브라우저마다 차이 존재)

단점
HTML5를 지원하지 않는 브라우저의 경우 사용 불가. (현재는 거의 없다고 봐야 한다.)
*/
// 이 주석에서는 웹 스토리지에 대해 설명하고 있음.
// 로컬 스토리지와 세션 스토리지를 비교하며, 로컬 스토리지는 영구 저장을 위해, 세션 스토리지는 브라우저 세션 동안만 데이터를 저장하는 방식임.
// 추가적으로, 쿠키는 서버와 클라이언트 모두에 데이터를 저장할 수 있는 반면, 로컬 스토리지는 클라이언트 측에서만 데이터를 저장함.
