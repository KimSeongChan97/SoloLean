import React from 'react';
import TodoItem from './TodoItem';

import TodoStyle from '../css/TodoList.module.css';

const TodoList = ({ todos, onDel }) => {
    return (
        <ul className={TodoStyle.TodoList}>
            {todos.map(todo => (
                <TodoItem key={todo.seq} todo={todo} onDel={onDel} />
            ))}
        </ul>
    );
};

export default TodoList;
