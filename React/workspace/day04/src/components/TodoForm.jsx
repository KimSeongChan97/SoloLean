import React, { useState, useRef } from 'react';

import TodoStyle from '../css/TodoForm.module.css';

const TodoForm = ({ addTodo }) => {

     const [text, setText] = useState('');
     // [text, setText]는 React의 useState 훅을 사용하여 상태(state)를 관리하는 방법입니다.
     // useState('')는 초기값으로 빈 문자열('')을 설정합니다. 즉, 이 상태는 처음에 아무런 텍스트도 입력되지 않은 상태입니다.
     // text는 현재 입력된 텍스트 값을 저장하고 있는 변수입니다.
     // setText는 text 값을 업데이트하는 함수로, 사용자가 입력 필드에 텍스트를 입력할 때마다 이 함수가 호출되어 text 상태를 변경합니다.
     // 이를 통해 React 컴포넌트는 text 값이 변경될 때마다 화면을 다시 렌더링하여 새로운 값을 반영합니다.
     // 간단히 말해서, 사용자가 입력하는 값을 실시간으로 저장하고 관리하는 역할을 합니다.

     const todoRef = useRef(null);
     // todoRef는 useRef 훅을 사용하여 HTML DOM 요소(여기서는 <input> 요소)를 직접 참조하기 위한 변수입니다.
     // 초기값으로 null을 설정하여, 아직 참조할 요소가 없음을 나타냅니다.
     // React에서 useRef는 DOM 요소나 다른 값에 직접 접근할 수 있는 "참조"를 만들어 줍니다.
     // 여기서 todoRef 입력 필드를 참조하는 데 사용되며, 폼 제출 후 입력 필드에 자동으로 포커스를 맞추기 위해 사용됩니다.
     // 예를 들어, todoRef.current.focus()를 호출하면 해당 입력 필드가 자동으로 선택됩니다. 이를 통해 사용자는 추가 버튼을 누른 후 바로 새 할 일을 입력할 수 있습니다.

     
    // 폼 제출시 할 일 추가
    const onSubmit = (e) => {
        e.preventDefault();
        if (text.trim()) {
            addTodo(text);
            setText(''); // 입력란 초기화
            todoRef.current.focus(); // 추가 후 포커스 이동
        }
    };

    return (
        <div className={TodoStyle.TodoForm}>
            <form onSubmit={onSubmit}>
                <input
                    ref={todoRef}
                    type='text'
                    value={text}
                    onChange={(e) => setText(e.target.value)}
                    placeholder='해야 할 일을 입력하시오'
                />
                <button type='submit'>추가</button>
            </form>
        </div>
    );
};

export default TodoForm;
