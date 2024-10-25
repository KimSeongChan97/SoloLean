import React from 'react';
import TodoItem from './TodoItem';

import TodoStyle from '../css/TodoList.module.css'; // CSS 모듈을 가져와서 리스트 스타일을 적용.
// CSS 모듈을 사용하여 TodoList에만 적용되는 고유한 스타일을 설정함.

const TodoList = ({ list, onDel }) => {
    return (
        <ul className={TodoStyle.TodoList}>
            {
                list.map(item => <TodoItem key={item.seq} item={item} onDel={onDel}/>) // 리스트의 각 항목을 TodoItem 컴포넌트로 렌더링.
                // map 함수로 할 일 목록 배열을 순회하면서 각 항목을 TodoItem 컴포넌트로 변환. key는 리액트에서 고유한 식별자로 사용되며, 성능 최적화를 위해 필요함.
            }
        </ul>
    );
};

export default TodoList;
