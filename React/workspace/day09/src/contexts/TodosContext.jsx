// React, 필요한 Hooks 및 createContext, useContext, useReducer, useRef를 import
import React, { createContext, useContext, useReducer, useRef } from 'react';

// 초기 상태: 할 일 목록을 빈 배열로 설정
// initialState는 모든 할 일(Todo)들이 저장될 배열이며, 처음에는 아무 것도 없기 때문에 빈 배열로 시작
const initialState = [];

// Reducer 함수, 상태와 액션을 받아 새로운 상태를 반환
// Reducer는 액션의 타입에 따라 state를 변화시키며, 여기서는 ADD, TOGGLE, DELETE 액션에 대한 처리를 정의함
// todoReducer는 현재 상태(state)와 특정 액션(action)을 받아서 새로운 상태를 반환하는 순수 함수
const todoReducer = (state, action) => {
    switch (action.type) {
        case 'ADD_TODO': // 할 일 추가 액션
            // 새로운 할 일 객체를 생성하고 기존 상태 앞에 추가
            // id는 seq를 사용해 고유한 값을 생성하며, 이를 통해 나중에 식별 가능
            // action.payload에는 추가할 할 일의 텍스트가 담겨 있으며, 이를 이용해 새로운 할 일을 생성
            return [
                { 
                    id: action.seq, // seq 값을 id로 설정, 각 할 일마다 고유한 id가 부여되어 목록 관리에 용이함
                    text: action.payload, // 할 일의 텍스트는 액션에서 전달된 payload로 설정 (할 일의 내용)
                    completed: false // 처음 생성될 때는 할 일이 완료되지 않은 상태로 설정 (default로 false 설정)
                },
                ...state // 기존의 할 일들을 유지하고 새로 추가된 할 일은 맨 앞에 위치 (최근 추가된 할 일을 가장 먼저 보여주기 위해)
            ];
        case 'TOGGLE_TODO': // 할 일 완료 상태 토글 액션
            // 특정 id의 할 일의 완료 상태를 반대로 변경 (완료 -> 미완료 또는 미완료 -> 완료)
            // map을 사용하여 상태를 순회하며, 액션의 payload와 id가 일치하는 항목을 찾아 상태를 변경
            // 완료 상태는 completed라는 boolean 값으로 관리되며, !todo.completed를 통해 상태를 반전시킴
            return state.map(todo =>
                todo.id === action.payload // 액션의 payload(id)와 현재 todo의 id가 같은지 확인 (id가 같은 할 일을 찾음)
                    ? { ...todo, completed: !todo.completed } // 동일하다면 완료 상태를 반전시킨 새 객체 반환 (불변성을 유지하기 위해 새로운 객체 생성)
                    : todo // 동일하지 않다면 현재 객체 그대로 반환 (다른 항목들은 그대로 유지)
            );
        case 'DELETE_TODO': // 할 일 삭제 액션
            // 특정 id의 할 일을 삭제함, filter를 사용하여 id가 일치하지 않는 항목만 남김
            // action.payload에는 삭제할 할 일의 id가 담겨 있으며, 이를 제외한 나머지 할 일들로 새로운 배열을 생성
            return state.filter(todo => todo.id !== action.payload); // id가 일치하지 않는 항목만 유지 (일치하는 항목을 필터링해서 삭제)
        default:
            return state; // 정의되지 않은 액션의 경우 현재 상태를 그대로 반환 (아무 변화 없음)
    }
};

// Context 만들기, TodosContext를 생성하여 여러 컴포넌트에서 접근 가능하도록 설정
// Context는 하위 컴포넌트들이 필요한 데이터를 일일이 전달하지 않고도 접근할 수 있도록 도와줌
const TodosContext = createContext();

// 사용자 Hooks, useTodos를 통해 TodosContext에 접근하도록 함
// useTodos는 TodosContext에 있는 상태와 dispatch 함수를 사용할 수 있게 해주는 사용자 정의 Hook
// 이 Hook을 사용하면 Context의 값을 쉽게 가져올 수 있어, 하위 컴포넌트가 Context를 활용하기 쉬워짐
export const useTodos = () => useContext(TodosContext);

// TodosProvider 컴포넌트는 모든 하위 컴포넌트가 TodosContext에 접근할 수 있도록 함
// children은 TodosProvider 내부에 위치한 모든 자식 컴포넌트를 의미하며, 이들이 Context를 사용할 수 있게 해줌
const TodosProvider = ({ children }) => {
    // Reducer와 초기 상태를 통해 할 일 목록(todos)과 액션을 실행하는 dispatch 함수 생성
    // useReducer는 todoReducer와 initialState를 받아 현재 상태(todos)와 이를 변경하는 함수(dispatch)를 반환
    // todos는 현재의 할 일 목록을, dispatch는 상태를 변경하는 데 사용되는 함수
    const [todos, dispatch] = useReducer(todoReducer, initialState);
    
    // 시퀀스 번호를 관리하기 위한 useRef, 최초 값은 1로 설정
    // 시퀀스 번호는 각 할 일의 고유한 ID로 할 일들이 순서대로 추가될 때 중복되지 않도록 관리함
    const seq = useRef(1); // 시퀀스 번호를 관리하는 useRef, 1로 초기화

    // 할 일 추가 시 시퀀스 번호를 업데이트하고 전달
    // 새로운 할 일이 추가될 때마다 시퀀스 번호를 사용하여 고유한 id를 부여
    // seq.current는 현재 시퀀스 값을 나타내며, 할 일이 추가될 때마다 증가하여 다음 추가할 할 일의 id로 사용
    const addTodoSeq = (text) => {
        dispatch({ type: 'ADD_TODO', payload: text, seq: seq.current });
        seq.current += 1; // 시퀀스 번호 증가
    };

    return (
        <TodosContext.Provider value={{ todos, dispatch, addTodoSeq }}> {/* TodosContext.Provider를 통해 하위 컴포넌트에 todos와 dispatch, addTodo 함수를 전달 */}
            {children} {/* TodosProvider 내부의 모든 컴포넌트들이 Context를 사용할 수 있도록 함 */}
            {/* TodosContext.Provider를 통해 제공된 value는 todos, dispatch, addTodoSeq 포함하며, 이를 통해 할 일 목록과 상태 변경 함수에 접근 가능 */}
        </TodosContext.Provider>
    );
};

export default TodosProvider;

