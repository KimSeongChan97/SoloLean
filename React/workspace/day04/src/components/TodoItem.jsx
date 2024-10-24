import React from 'react';

import TodoStyle from '../css/TodoItem.module.css';

const TodoItem = ({ todo, onDel }) => {
    return (
        <li className={TodoStyle.TodoItem}>
            <span>{todo.text}</span>
            <button onClick={() => onDel(todo.seq)}>삭제</button>
        </li>
    );
};

export default TodoItem;
