import React, { useState, useRef } from 'react'; // React에서 useState와 useRef 훅을 사용하여 상태와 참조를 관리함.
// useState: 컴포넌트에서 상태를 관리하는 훅으로, 상태가 변경되면 컴포넌트가 다시 렌더링됨.
// useRef: 특정 DOM 요소나 값을 기억하는 훅으로, 값이 변경되어도 컴포넌트가 다시 렌더링되지 않음. 주로 컴포넌트 렌더 간에 값을 유지하기 위해 사용함.

import TodoForm from './TodoForm'; // 할 일 추가 폼 컴포넌트를 가져옴.
// 할 일을 입력하고 추가하는 기능을 제공하는 컴포넌트.
import TodoList from './TodoList'; // 할 일 목록 컴포넌트를 가져옴.
// 현재 추가된 할 일 목록을 보여주는 컴포넌트.
import TodoStyle from '../css/Todos.module.css'; // CSS 모듈을 가져와서 스타일 적용.
// CSS 모듈을 사용하면 각 컴포넌트에 고유한 클래스 이름을 만들어 충돌을 방지함.

const Todos = () => {
    const [list, setList] = useState([]); // 할 일 목록을 저장하는 상태. 초기값은 빈 배열.
    // list는 현재까지 추가된 모든 할 일의 배열로, 각 항목은 객체 형태로 저장됨.
    // setList는 list 상태를 업데이트하는 함수로, 새로운 할 일을 추가하거나 삭제할 때 사용됨.

    const seq = useRef(1); // 각 할 일 항목의 고유 번호를 위한 참조 변수. useRef는 렌더링 사이에 값이 유지됨.
    // seq는 각 할 일 항목에 고유한 번호(순번)를 부여하기 위한 변수로, 렌더링이 다시 일어나도 값이 유지됨.
    // useRef로 선언된 변수는 값이 변경되어도 컴포넌트를 다시 렌더링하지 않음. 여기서는 할 일을 추가할 때마다 seq의 값을 1씩 증가시킴.

    const onDel = (seq) => { // 특정 seq를 가진 할 일을 삭제하는 함수.
        // 인자로 받은 seq를 기준으로 해당 항목을 목록에서 삭제함.
        setList(
            list.filter(item => item.seq !== seq) // 선택한 seq와 일치하지 않는 할 일들만 필터링하여 새로운 리스트를 만듦.
            // list에서 각 항목의 seq를 비교하여, 삭제하고자 하는 항목만 제외하고 새로운 배열을 만듦.
        )
    }

    return (
        <div className={TodoStyle.Todos}> {/* 전체 할 일 관리 UI를 감싸는 div. CSS 모듈로 스타일 적용. */}
            <h1>일정관리</h1> {/* 일정관리 타이틀을 표시 */}
            <TodoForm seq={seq} list={list} setList={setList} /> {/* 할 일 추가 폼을 렌더링하고 상태와 함수들을 전달. */}
            {/* TodoForm 컴포넌트에 seq, list, setList를 props로 전달하여 할 일 추가 기능을 구현함. */}
            <br/>
            <TodoList list={list} onDel={onDel} /> {/* 할 일 목록을 렌더링하고 삭제 함수를 전달. */}
            {/* TodoList 컴포넌트에 현재 할 일 목록과 삭제 기능을 props로 전달하여, 사용자가 추가한 할 일 목록을 보여주고 삭제할 수 있게 함. */}
        </div>
    );
};

export default Todos;
