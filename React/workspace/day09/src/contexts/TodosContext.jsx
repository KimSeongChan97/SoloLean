import React, { createContext, useContext, useEffect, useReducer, useRef } from 'react';

// 초기 상태: 할 일 목록을 빈 배열로 설정
// initialState는 모든 할 일(Todo)들이 저장될 배열이며, 처음에는 아무 것도 없기 때문에 빈 배열로 시작
// 여기서 초기 상태는 빈 배열이므로, 초기에는 할 일이 하나도 없는 상태로 설정되어 있음
// 이 변수는 로컬 스토리지에 할 일 데이터가 없을 경우에만 사용됨
const initialState = [];

// Reducer 함수, 상태와 액션을 받아 새로운 상태를 반환
// Reducer는 액션의 타입에 따라 state를 변화시키며, 여기서는 ADD, TOGGLE, DELETE 액션에 대한 처리를 정의함
// todoReducer는 현재 상태(state)와 특정 액션(action)을 받아서 새로운 상태를 반환하는 순수 함수
// 이 함수는 불변성을 유지하기 위해 항상 새로운 배열이나 객체를 반환함
// 여기서 불변성을 유지한다는 것은, 기존의 상태를 직접 변경하지 않고 새롭게 변경된 상태를 반환한다는 의미임
const todoReducer = (state, action) => {
    switch (action.type) {
        case 'ADD_TODO': // 할 일 추가 액션
            // 새로운 할 일 객체를 생성하고 기존 상태 앞에 추가
            // id는 seq를 사용해 고유한 값을 생성하며, 이를 통해 나중에 식별 가능
            // action.payload에는 추가할 할 일의 텍스트가 담겨 있으며, 이를 이용해 새로운 할 일을 생성
            // 새로운 할 일은 completed 상태가 false로 설정되며, 최근에 추가된 할 일일수록 목록의 맨 위에 위치함
            // 배열의 맨 앞에 추가하는 이유는, 최신 할 일이 목록의 가장 위에 오도록 하기 위함임
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
            // 이 과정은 불변성을 유지하기 위해 새로운 객체를 반환함으로써 이루어짐
            // 즉, 기존 객체를 수정하지 않고, 변경된 내용으로 새로운 객체를 생성해 반환하여 상태를 업데이트함
            return state.map(todo =>
                todo.id === action.payload // 액션의 payload(id)와 현재 todo의 id가 같은지 확인 (id가 같은 할 일을 찾음)
                    ? { ...todo, completed: !todo.completed } // 동일하다면 완료 상태를 반전시킨 새 객체 반환 (불변성을 유지하기 위해 새로운 객체 생성)
                    : todo // 동일하지 않다면 현재 객체 그대로 반환 (다른 항목들은 그대로 유지)
            );
        case 'DELETE_TODO': // 할 일 삭제 액션
            // 특정 id의 할 일을 삭제함, filter를 사용하여 id가 일치하지 않는 항목만 남김
            // action.payload에는 삭제할 할 일의 id가 담겨 있으며, 이를 제외한 나머지 할 일들로 새로운 배열을 생성
            // 이 동작은 현재 상태를 불변으로 유지하면서 삭제된 새 상태를 반환함
            // 삭제하려는 id와 다른 id의 항목만 필터링하여 유지함으로써 원하는 할 일만 목록에서 삭제할 수 있음
            return state.filter(todo => todo.id !== action.payload); // id가 일치하지 않는 항목만 유지 (일치하는 항목을 필터링해서 삭제)
        default:
            return state; // 정의되지 않은 액션의 경우 현재 상태를 그대로 반환 (아무 변화 없음)
            // default 문은 주어진 action.type이 정의되지 않은 경우 현재 상태를 그대로 유지하도록 함
    }
};

// Context 만들기, TodosContext를 생성하여 여러 컴포넌트에서 접근 가능하도록 설정
// Context는 하위 컴포넌트들이 필요한 데이터를 일일이 전달하지 않고도 접근할 수 있도록 도와줌
// 여기서는 TodosContext라는 이름의 Context를 만들어서 전체 할 일 목록(todos)와 이를 수정하는 함수(dispatch)를 여러 컴포넌트에서 쉽게 접근할 수 있도록 함
// Context를 사용하면 컴포넌트 계층 구조가 깊어질 때 props를 일일이 전달하지 않고도 필요한 데이터에 접근할 수 있음
const TodosContext = createContext();

// 사용자 Hooks, useTodos를 통해 TodosContext에 접근하도록 함
// useTodos는 TodosContext에 있는 상태와 dispatch 함수를 사용할 수 있게 해주는 사용자 정의 Hook
// 이 Hook을 사용하면 Context의 값을 쉽게 가져올 수 있어, 하위 컴포넌트가 Context를 활용하기 쉬워짐
// 여러 컴포넌트에서 이 Hook을 호출하여 할 일 목록을 조회하거나 수정할 수 있음
// 이 Hook을 통해 todos와 dispatch 함수를 가져와서 사용할 수 있으므로 Context에 대한 직접적인 접근이 불필요함
export const useTodos = () => useContext(TodosContext);

// 초기 상태를 로컬 스토리지에서 가져오는 함수
// initializeTodos 함수는 앱이 시작될 때 로컬 스토리지에 저장된 할 일 목록이 있는지 확인하고, 있다면 이를 초기 상태로 반환함
// 로컬 스토리지에 'todos' 데이터가 없다면 initialState를 반환하여 할 일이 없는 상태로 시작함
// 이 함수는 useReducer에서 초기 상태를 설정할 때 호출되며, 로컬 스토리지에 저장된 데이터가 있을 경우 이를 반영하도록 함
const initializeTodos = () => {
    const localData = localStorage.getItem('todos');
    return localData ? JSON.parse(localData) : initialState;
};

// TodosProvider 컴포넌트는 모든 하위 컴포넌트가 TodosContext에 접근할 수 있도록 함
// children은 TodosProvider 내부에 위치한 모든 자식 컴포넌트를 의미하며, 이들이 Context를 사용할 수 있게 해줌
// TodosProvider는 하위 컴포넌트들에게 todos와 관련된 상태와 기능을 제공하는 역할을 함
// 이 컴포넌트를 사용하여 하위 컴포넌트들이 Context를 통해 할 일 목록과 관련된 상태와 기능에 접근 가능하게 함
const TodosProvider = ({ children }) => {
    // Reducer와 초기 상태를 통해 할 일 목록(todos)과 액션을 실행하는 dispatch 함수 생성
    // useReducer는 todoReducer와 initialState를 받아 현재 상태(todos)와 이를 변경하는 함수(dispatch)를 반환
    // todos는 현재의 할 일 목록을, dispatch는 상태를 변경하는 데 사용되는 함수
    // 여기서 초기 상태는 initializeTodos 함수를 통해 설정되어, 로컬 스토리지에 저장된 데이터를 기반으로 초기화됨
    const [todos, dispatch] = useReducer(todoReducer, undefined, initializeTodos);
    
    // 시퀀스 번호를 관리하기 위한 useRef, 최초 값은 1로 설정
    // 시퀀스 번호는 각 할 일의 고유한 ID로 할 일들이 순서대로 추가될 때 중복되지 않도록 관리함
    // const seq = useRef(1); // 시퀀스 번호를 관리하는 useRef, 1로 초기화
    const seq = useRef(todos.length ? todos[0].id + 1 : 1); // 시퀀스 번호 초기화
    // todos 배열의 길이가 0이 아닐 때(할 일이 있을 때) 가장 첫 번째 항목의 id에 1을 더한 값으로 seq를 설정하여 중복되지 않도록 함
    // useRef를 사용해 seq 값을 유지하므로 리렌더링 시에도 초기화되지 않고 유지됨

    // 할 일 추가 함수
    const addTodoSeq = (text) => {
        dispatch({ type: 'ADD_TODO', payload: text, seq: seq.current });
        seq.current += 1;
        // 새로운 할 일을 추가할 때마다 현재 seq 값을 id로 사용하고, 그 후 seq.current를 1씩 증가시켜 다음 할 일의 id가 겹치지 않도록 관리
        // seq.current를 1씩 증가시켜 각 할 일마다 고유한 id가 부여되도록 함
    };

    // todos가 변경될 때마다 로컬 스토리지에 저장
    useEffect(() => {
        localStorage.setItem('todos', JSON.stringify(todos));
        // JSON.stringify를 통해 todos 배열을 문자열로 변환 후 로컬 스토리지에 저장하여, 페이지를 새로고침해도 데이터가 유지되도록 함
        // todos가 변경될 때마다 이 함수가 실행되며, 로컬 스토리지에 항상 최신 상태가 반영됨
    }, [todos]);

    return (
        <TodosContext.Provider value={{ todos, dispatch, addTodoSeq }}>
            {/* TodosContext.Provider를 통해 하위 컴포넌트에 todos와 dispatch, addTodo 함수를 전달 */}
            {children} {/* TodosProvider 내부의 모든 컴포넌트들이 Context를 사용할 수 있도록 함 */}
            {/* TodosContext.Provider를 통해 제공된 value는 todos, dispatch, addTodoSeq 포함하며, 이를 통해 할 일 목록과 상태 변경 함수에 접근 가능 */}
        </TodosContext.Provider>
    );
};

export default TodosProvider;
