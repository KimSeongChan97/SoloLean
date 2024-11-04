// React와 TodosContext에서 필요한 요소들을 import
import React from 'react';
import { useTodos } from '../contexts/TodosContext';
import styles from '../css/TodoItem.module.css';

const TodoItem = ({ todo }) => {
    // TodosContext에서 제공하는 dispatch 함수를 가져옴
    // dispatch는 Context에서 정의된 상태 관리 함수로, 할 일의 완료 상태를 토글하거나 삭제할 때 사용됨
    // useTodos를 호출하여 Context에서 dispatch 함수를 추출함. 이 함수는 Reducer에 정의된 액션을 실행하여 상태를 변경하는 역할을 함
    const { dispatch } = useTodos();

    // 할 일 완료 여부를 토글하는 함수
    // 이 함수는 checkbox를 클릭할 때 호출되며, 할 일의 완료 상태를 반전시킴
    // 현재 todo의 id를 이용해 완료 여부를 반전시키는 'TOGGLE_TODO' 액션을 reducer에 전달함
    const onToggle = () => {
        // dispatch 함수를 호출하여 'TOGGLE_TODO' 액션을 실행하고, 해당 할 일의 ID를 payload로 전달함
        // reducer 함수에서 이 ID를 가진 할 일의 완료 상태를 반전시켜 업데이트함
        // 여기서 dispatch는 Context의 reducer 함수와 상호작용하여 상태를 변경하며, 액션 객체를 reducer에 전달함
        dispatch({ type: 'TOGGLE_TODO', payload: todo.id });
    };

    // 완료된 할 일만 삭제할 수 있도록 하는 삭제 함수
    // 할 일 항목이 완료되지 않으면 삭제할 수 없도록 로직을 추가하여 사용자가 실수로 중요한 할 일을 삭제하는 것을 방지함
    const onDelete = () => {
        // todo 객체의 completed 속성을 확인하여, 할 일이 완료된 경우에만 삭제 가능
        // 만약 할 일이 완료되지 않은 경우에는 사용자에게 알림을 주어 완료 처리를 유도함
        if (todo.completed) {
            // dispatch 함수를 호출하여 'DELETE_TODO' 액션을 실행하고, 해당 할 일의 ID를 payload로 전달함
            // reducer는 전달된 ID에 해당하는 할 일을 목록에서 삭제함
            dispatch({ type: 'DELETE_TODO', payload: todo.id });
        } else {
            // 할 일이 완료되지 않은 경우 경고 메시지를 통해 사용자가 먼저 완료 표시를 하도록 안내함
            // alert는 사용자에게 현재 작업을 설명하고 다음 단계로 진행하도록 유도하는 역할을 함
            alert("먼저 완료 표시를 한 후에 삭제할 수 있습니다.");
        }
    };

    return (
        <li className={styles.item}> {/* 각 할 일을 나타내는 li 요소, TodoItem의 스타일을 적용 */}
            <input
                type="checkbox"
                checked={todo.completed} // 할 일 완료 여부에 따라 체크박스 상태 설정
                // 체크박스가 변경될 때 onToggle 함수 호출, 이를 통해 할 일의 완료 상태를 토글함
                onChange={onToggle}
                className={styles.checkbox} // 스타일 적용을 위한 클래스 이름, 체크박스 스타일링
                id={`checkbox-${todo.id}`} // 체크박스와 레이블 연결을 위한 고유 ID 설정, 각 할 일에 대해 고유한 ID를 부여하여 레이블과 연동
            />
            <label htmlFor={`checkbox-${todo.id}`} className={styles.checkboxLabel} /> {/* 체크박스 레이블 */}
            <span className={todo.completed ? styles.textCompleted : styles.text}> {/* 완료 여부에 따른 스타일 */}
                {todo.text} {/* 할 일 텍스트, 사용자가 입력한 할 일 내용을 화면에 표시 */}
            </span>
            <button className={styles.button} onClick={onDelete}>삭제</button> {/* 할 일 삭제 버튼 */}
        </li>
    );
};

export default TodoItem;
