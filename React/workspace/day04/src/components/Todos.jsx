import React, { useState } from 'react';

import TodoStyle from '../css/Todos.module.css';
import TodoForm from './TodoForm';
import TodoList from './TodoList';

const Todos = () => {
    const [todos, setTodos] = useState([]);
    const [seq, setSeq] = useState(1); // 시퀀스 번호 관리

    // 새로운 todo 추가하는 함수
    const addTodo = (text) => {
        const newTodo = {
            seq: seq,  // 시퀀스 번호 사용
            text: text,
        };
        setTodos([...todos, newTodo]);
        setSeq(seq + 1); // 시퀀스 번호 증가
    };

    // todo 삭제하는 함수
    const onDel = (seq) => {
        const updatedTodos = todos.filter(todo => todo.seq !== seq);
        setTodos(updatedTodos);
    };

    return (
        <div className={TodoStyle.Todos}>
            <h1>일정관리</h1>
            <TodoForm addTodo={addTodo} />
            <TodoList todos={todos} onDel={onDel} />
        </div>
    );
};

export default Todos;
