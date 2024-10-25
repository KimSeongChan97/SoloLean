import React, { useState, useRef } from 'react'; // useState: 상태 관리 / useRef: DOM 요소에 직접 접근.
// useState: 입력된 텍스트(할 일)를 저장하고 업데이트하기 위한 상태를 관리함.
// useRef: 입력 필드에 포커스를 맞추기 위해 사용되며, 할 일 추가 후에 입력 필드를 비우고 자동으로 포커스를 다시 맞춤.

import TodoStyle from '../css/TodoForm.module.css'; // CSS 모듈을 가져와서 폼 스타일을 적용.
// CSS 모듈을 사용하여 입력 폼에 고유한 스타일을 적용.

const TodoForm = ({ seq, list, setList }) => {
    const [text, setText] = useState(''); // 사용자가 입력하는 텍스트를 저장하는 상태.
    // text는 사용자가 입력한 할 일의 내용을 저장함. 
    // setText는 사용자가 입력할 때마다 이 값을 업데이트하는 함수.

    const textRef = useRef(); // input 요소에 접근하기 위한 참조 변수.
    // input 필드에 직접 접근하여 포커스를 주기 위한 용도로 사용됨. 
    // 예를 들어, 사용자가 할 일을 추가한 후 입력 필드에 자동으로 포커스가 다시 맞춰지도록 함.

    const onAdd = (e) => { // 폼이 제출되었을 때 호출되는 함수.
        e.preventDefault(); // 폼의 기본 제출 동작을 막음.
        // 기본적으로 폼은 제출되면 페이지를 새로고침하지만, 이 동작을 막기 위해 preventDefault()를 호출함.
        if (!text) return; // 텍스트가 없으면 추가하지 않고 함수 종료.
        // 사용자가 아무 것도 입력하지 않았을 때는 할 일을 추가하지 않고 함수 실행을 중단함.

        setList([ // 기존 리스트에 새로운 항목을 추가. 불변성을 유지하기 위해 배열을 새로 생성.
            // list 상태를 업데이트하는 함수인 setList를 호출하여 새로운 할 일 항목을 추가함.
            ...list, // 기존 리스트의 모든 항목을 복사.
            // spread 연산자를 사용하여 기존 할 일 목록을 새로운 배열에 추가함.
            {
                seq: seq.current++, // 할 일 항목에 고유 번호를 부여하고, 다음 번호로 증가시킴.
                // 현재 seq 값을 할 일 항목의 고유 번호로 사용하고, 이후 seq 값을 1 증가시켜 다음 항목에 사용할 번호를 준비함.
                text // 입력한 텍스트를 할 일 항목으로 추가.
            }
        ]);
        setText(''); // 텍스트 입력 칸을 비움.
        // 사용자가 할 일을 추가한 후 입력 필드를 비워서 새로운 할 일을 입력할 수 있도록 함.
        textRef.current.focus(); // 입력 칸에 포커스를 다시 맞춤.
        // 입력 필드에 포커스를 다시 맞춰서 사용자가 추가 작업을 쉽게 할 수 있게 함.
    }

    const onInput = (e) => { // 입력 필드에서 값이 변경될 때 호출되는 함수.
        setText(e.target.value); // 입력된 값을 상태로 업데이트.
        // 사용자가 입력한 텍스트 값을 text 상태로 업데이트하여 실시간으로 관리함.
    }

    return (
        <div className={TodoStyle.TodoForm}> {/* 할 일 추가 폼을 감싸는 div. CSS 모듈로 스타일 적용. */}
            <form onSubmit={onAdd}> {/* 폼 제출 이벤트 처리. onAdd 함수 호출. */}
                <input type='text' 
                       name='text' 
                       onChange={onInput} // 입력 필드 값이 변경될 때마다 onInput 함수가 호출됨.
                       value={text} // input의 값은 항상 state와 일치하도록 함.
                       ref={textRef} // textRef를 통해 이 필드를 참조할 수 있게 함.
                       placeholder='해야 할 일을 입력하세요'/> {/* 사용자가 할 일을 입력하는 필드 */}
                <button type='submit'>추가</button> {/* 할 일을 추가하는 버튼 */}
            </form>
        </div>
    );
};

export default TodoForm;
