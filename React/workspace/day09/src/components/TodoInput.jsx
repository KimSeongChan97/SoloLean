// React, 필요한 Hooks와 useTodos를 import
import React, { useRef, useState } from 'react';
import { useTodos } from '../contexts/TodosContext';

import styles from '../css/TodoInput.module.css';

const TodoInput = () => {
    // text 상태를 정의하고, 이 상태는 사용자가 입력한 할 일 내용을 저장하는 역할을 함
    // useState는 초기값을 빈 문자열로 설정하여 처음에는 입력 필드가 비어 있도록 함
    const [text, setText] = useState('');
    
    // TodosContext에서 제공하는 addTodo 함수를 가져옴
    // addTodo는 TodosContext에 정의된 addTodo 함수를 통해 새로운 할 일을 추가할 수 있도록 함
    const { addTodoSeq } = useTodos(); 

    // inputRef를 useRef로 생성하여 input 요소를 참조할 수 있게 함
    // 이 참조를 통해 입력 필드에 포커스를 줄 수 있으며, 할 일을 추가한 후 입력 필드가 자동으로 활성화되도록 함
    const inputRef = useRef();

    // 할 일을 추가하는 함수로, 버튼이 클릭될 때 호출됨
    // 이 함수는 현재 입력된 text 상태의 내용을 기반으로 새 할 일을 TodosContext에 추가함
    const AddTodo = () => {
        // 입력된 text 값이 공백이 아닌 경우에만 할 일을 추가하도록 조건을 설정
        if (text.trim()) {
            addTodoSeq(text); // 시퀀스를 활용해 할 일 추가, 사용자가 입력한 텍스트를 Context로 전달하여 새로운 할 일을 생성
            setText(''); // 할 일을 추가한 후 text 상태를 빈 문자열로 설정하여 입력 필드를 초기화함
            inputRef.current.focus(); // inputRef를 통해 입력 필드에 포커스를 줌으로써 사용자가 새로운 할 일을 쉽게 추가할 수 있게 함
        }
    };

    // Enter 키 입력 시 AddTodo 함수를 호출하는 이벤트 핸들러
    // 이 핸들러는 사용자가 Enter 키를 눌렀을 때 할 일을 추가하는 역할을 함
    const onEnter = (e) => {
          
        // e.key가 'Enter'이며 Shift 키와 조합되지 않은 경우에만 AddTodo 호출
        if (e.key === 'Enter' && !e.shiftKey) { // Shift 키와 함께 Enter가 아닌 경우에만 동작
               e.preventDefault();
               AddTodo();
        }
    };

    return (
        <div className={styles.inputContainer}>
            <input
                type="text"
                value={text} // 입력 필드의 현재 값 설정
                onChange={(e) => setText(e.target.value)} // 입력 필드에 텍스트가 변경될 때 text 상태를 업데이트하여 입력 내용을 실시간 반영
                placeholder="할 일을 입력하세요" // 사용자에게 입력할 내용을 안내하는 힌트
                ref={inputRef} // input 요소에 참조 설정, 이를 통해 할 일이 추가된 후 포커스를 입력 필드로 이동시킬 수 있음
                onKeyDown={onEnter} // onEnter 이벤트 핸들러 추가, Enter 키를 눌렀을 때 AddTodo를 호출하여 할 일을 추가
                className={styles.inputField} // 스타일 적용을 위한 클래스 이름
            />
            <button className={styles.addButton} onClick={AddTodo}> 추가 </button> {/* 할 일을 추가하는 버튼 */}
        </div>
    );
};

export default TodoInput;
