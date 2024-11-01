// src/components/TodoInput.jsx
import React, { useRef, useState } from 'react';
import { useTodos } from '../contexts/TodosContext';

import styles from '../css/TodoInput.module.css';

const TodoInput = () => {
     const [text, setText] = useState('');
     const { dispatch } = useTodos();
     const inputRef = useRef(); // focus

     const AddTodo = () => {
          if (text.trim()) {
               dispatch({ type: 'ADD_TODO', payload: text });
               setText(''); // 입력 필드 초기화
               inputRef.current.focus();
          }
     };

     return (
          <div className={styles.inputContainer}>
               <input
                    type="text"
                    value={text}
                    onChange={(e) => setText(e.target.value)}
                    placeholder="할 일을 입력하세요"
                    ref={ inputRef }
                    className={styles.inputField}
               />
               <button className={styles.addButton} onClick={AddTodo}> 추가 </button>
          </div>
     );
};

export default TodoInput;
