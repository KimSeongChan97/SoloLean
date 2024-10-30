import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Main from './components/main/Main';
import LoginForm from './components/member/LoginForm';
import BoardWriteForm from './components/board/BoardWriteForm';
import BoardList from './components/board/BoardList';

import styles from './css/style05.module.css';

const App01 = () => {
  return (
    <BrowserRouter>
      <div className={styles.menunav}>
        <nav>
          <ul>
            <li><Link to="/">메인화면</Link></li>
            <li><Link to="/member/LoginForm">LOGIN</Link></li>
            <li><Link to="/board/BoardWriteForm">글쓰기</Link></li>
            <li><Link to="/board/BoardList">목록</Link></li>
          </ul>
        </nav>
      </div>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/member/LoginForm" element={<LoginForm />} />
        <Route path="/board">
          <Route path="BoardWriteForm" element={<BoardWriteForm />} /> 
          <Route path="BoardList" element={<BoardList />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App01;
