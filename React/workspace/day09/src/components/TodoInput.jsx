// React와 필요한 Hooks를 import (useRef: 특정 요소 참조, useState: 상태 관리)
// useRef는 특정 DOM 요소에 접근할 때 사용하고, useState는 컴포넌트 내부에서 상태를 관리할 때 사용함
import React, { useRef, useState } from 'react';
import { useTodos } from '../contexts/TodosContext'; // TodosContext에서 dispatch 함수를 가져오기 위한 custom hook 사용

import styles from '../css/TodoInput.module.css';

const TodoInput = () => {
     // text 상태를 정의하고, 이 상태는 사용자가 입력한 할 일 내용을 저장하는 역할을 함
     // useState는 초기값을 빈 문자열로 설정하여 처음에는 입력 필드가 비어 있도록 함
     const [text, setText] = useState('');

     // TodosContext에서 제공하는 dispatch 함수를 가져옴
     // dispatch는 TodosContext에 정의된 reducer 함수를 통해 상태를 변경할 수 있도록 함
     const { dispatch } = useTodos();
     
     // inputRef를 useRef로 생성하여 input 요소를 참조할 수 있게 함
     // 이 참조를 통해 입력 필드에 포커스를 줄 수 있으며, 할 일을 추가한 후 입력 필드가 자동으로 활성화되도록 함
     const inputRef = useRef();

     // 할 일을 추가하는 함수로, 버튼이 클릭될 때 호출됨
     // 이 함수는 현재 입력된 text 상태의 내용을 기반으로 새 할 일을 TodosContext에 추가함
     const AddTodo = () => {
          // 입력된 text 값이 공백이 아닌 경우에만 할 일을 추가하도록 조건을 설정
          if (text.trim()) {
               // dispatch 함수를 호출하여 'ADD_TODO' 액션을 실행하고, text 내용을 payload로 전달하여 할 일을 추가
               dispatch({ type: 'ADD_TODO', payload: text });
               // 할 일을 추가한 후 text 상태를 빈 문자열로 설정하여 입력 필드를 초기화함
               setText('');
               inputRef.current.focus();
               // inputRef를 통해 입력 필드에 포커스를 줌으로써 사용자가 새로운 할 일을 쉽게 추가할 수 있게 함
               // inputRef가 null이 아닌지 확인
          }
     };

     return (
          <div className={styles.inputContainer}>
               <input
                    type="text"
                    value={text} // 입력 필드의 현재 값 설정
                    onChange={(e) => { setText(e.target.value); }}
                    placeholder="할 일을 입력하세요" // 사용자에게 입력할 내용을 안내하는 힌트
                    ref={ inputRef } // input 요소에 참조 설정
                    className={styles.inputField} // 스타일 적용을 위한 클래스 이름
               />
               <button className={styles.addButton} onClick={AddTodo}> 추가 </button> {/* 할 일을 추가하는 버튼 */}
          </div>
     );
};

export default TodoInput;
