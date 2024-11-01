// src/components/TodoItem.jsx
import React from 'react';
import { useTodos } from '../contexts/TodosContext';
import styles from '../css/TodoItem.module.css';

const TodoItem = ({ todo }) => {
    const { dispatch } = useTodos();

    const onToggle = () => {
        dispatch({ type: 'TOGGLE_TODO', payload: todo.id });
    };

    const onDelete = () => {
        if (todo.completed) {
            dispatch({ type: 'DELETE_TODO', payload: todo.id });
        } else {
            alert("할 일을 완료로 표시해야 삭제할 수 있습니다.");
        }
    };

    return (
        <li className={styles.item}>
            <input
                type="checkbox"
                checked={todo.completed}
                onChange={onToggle}
                className={styles.checkbox}
                id={`checkbox-${todo.id}`}
            />
            <label htmlFor={`checkbox-${todo.id}`} className={styles.checkboxLabel} />
            <span className={todo.completed ? styles.textCompleted : styles.text}>
                {todo.text}
            </span>
            <button className={styles.button} onClick={onDelete}>삭제</button>     
        </li>
    );
};

export default TodoItem;
