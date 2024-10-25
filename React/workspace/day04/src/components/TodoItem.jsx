import React from 'react';

import TodoStyle from '../css/TodoItem.module.css'; // CSS 모듈을 가져와서 스타일 적용.
// 각 TodoItem에 대한 스타일을 지정한 CSS 모듈을 사용하여 스타일을 적용.

const TodoItem = ({ item, onDel }) => {
    return (
        <li key={item.seq} className={TodoStyle.TodoItem}> {/* 각 할 일 항목을 리스트 아이템으로 표시. */}
        {/* 각 할 일 항목을 li 태그로 감싸서 리스트 형태로 표시. className은 CSS 모듈을 통해 스타일이 적용됨. */}
            <span>{item.text}</span> {/* 할 일 내용 표시 */}
            {/* 할 일 내용이 담긴 text를 화면에 표시. */}
            <button onClick={() => onDel(item.seq)}>삭제</button> {/* 삭제 버튼, 클릭 시 onDel 함수 실행 */}
            {/* 삭제 버튼을 클릭하면 onDel 함수가 호출되어 해당 항목이 삭제됨. onDel 함수는 부모 컴포넌트에서 전달됨. */}
        </li>
    );
};

export default TodoItem;
