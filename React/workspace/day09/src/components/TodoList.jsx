// src/components/TodoList.jsx
import React from 'react';
import { useTodos } from '../contexts/TodosContext';
import TodoItem from './TodoItem';

import styles from '../css/TodoList.module.css';

const TodoList = () => {
    const { todos } = useTodos();

    return (
        <ul className={styles.list}>
            {todos.length === 0 ? (
                <p className={styles.emptyMessage}>할 일이 없습니다</p>
            ) : (
                todos.map(todo => (
                    <TodoItem key={todo.id} todo={todo} />
                ))
            )}
        </ul>
    );
};

export default TodoList;
