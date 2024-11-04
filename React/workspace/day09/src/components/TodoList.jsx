// React와 TodosContext에서 필요한 요소들을 import
import React from 'react';
import { useTodos } from '../contexts/TodosContext';
import TodoItem from './TodoItem';

import styles from '../css/TodoList.module.css';

const TodoList = () => {
    // TodosContext에서 todos 상태를 가져옴
    // todos는 현재 저장된 모든 할 일 목록을 나타내며, 각 할 일 객체는 ID, 텍스트 및 완료 여부를 포함
    const { todos } = useTodos();
    
    return (
        <ul className={styles.list}> {/* 할 일 목록을 나타내는 ul 요소, TodoList의 스타일을 적용 */}
            {todos.length === 0 ? (
                // 할 일 목록이 비어 있으면 "할 일 목록이 없습니다" 메시지를 표시
                <p className={styles.emptyMessage}>할 일 목록이 없습니다</p> // 할 일이 없을 때 사용자에게 빈 목록임을 알림
            ) : (
                // 할 일 목록이 있는 경우 각 할 일을 TodoItem 컴포넌트로 표시
                todos.map(todo => (
                    <TodoItem 
                        key={todo.id} // 각 TodoItem에 고유한 key 속성을 설정하여 React가 각 요소를 효율적으로 업데이트할 수 있도록 함
                        todo={todo} // 현재의 할 일 객체(todo)를 TodoItem 컴포넌트로 전달
                    /> // 각 할 일 항목을 TodoItem으로 표시, 고유 ID를 key로 사용하여 React가 각 항목을 식별
                ))
            )}
        </ul>
    );
};

export default TodoList;
