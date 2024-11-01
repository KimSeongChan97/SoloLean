// src/components/Todos.jsx
import React, { useContext } from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';

import { ColorContext } from '../contexts/ColorContext';

import styles from '../css/Todos.module.css';

const Todos = () => {

     const { color } = useContext(ColorContext);

     return (
          <div className={styles.container}>
               <h1 className={styles.title} style={{color : color }}> 할 일 만들기 </h1>
               <TodoInput />
               <h2 className={styles.subtitle}> 할 일 내용 </h2>
               <TodoList />
          </div>
     );
};

export default Todos;
