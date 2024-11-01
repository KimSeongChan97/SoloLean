// src/contexts/TodosContext.jsx
import React, { createContext, useContext, useReducer } from 'react';

// 초기 ( 빈 항목 )
const initialState = [];

// Reducer 함수
const todoReducer = (state, action) => {
     switch (action.type) {
               case 'ADD_TODO' : return [ { id: Date.now(), text: action.payload, completed: false }, ...state ];
               case 'TOGGLE_TODO' : return state.map( todo => todo.id === action.payload ?
                    { ...todo, completed: !todo.completed } : todo );
               case 'DELETE_TODO' : return state.filter(todo => todo.id !== action.payload);
               default : return state;     
     }
};

// Context 만들기
const TodosContext = createContext();
// 사용자 Hooks
export const useTodos = () => useContext(TodosContext);

const TodosProvider = ({ children }) => {

     const [ todos, dispatch ] = useReducer(todoReducer, initialState);

     return (
          <TodosContext.Provider value={{ todos, dispatch }}>
               { children }
          </TodosContext.Provider>
     );
};

export default TodosProvider;