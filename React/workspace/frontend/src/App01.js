import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Main from './components/main/Main';
import LoginForm from './components/member/LoginForm';
import BoardWriteForm from './components/board/BoardWriteForm';
import BoardList from './components/board/BoardList';
import BoardDetail from './components/board/BoardDetail';

import styles from './css/style05.module.css';

const App01 = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    // 서버로부터 로그인 상태를 확인하는 코드 추가
    axios.get('http://localhost:8080/spring/member/checkLoginStatus', { withCredentials: true })
        .then(res => setIsLoggedIn(res.data.isLoggedIn))
        .catch(error => console.error('로그인 상태 확인 실패:', error));
  }, []);

  const handleLogout = () => {
    axios.post('http://localhost:8080/spring/member/logout', null, { withCredentials: true })
        .then(() => {
            alert('로그아웃 완료!');
            setIsLoggedIn(false);
        })
        .catch(error => console.error('로그아웃 실패:', error));
  };

  return (
    <BrowserRouter>
      <div className={styles.menunav}>
        <nav>
          <ul>
            <li><Link to="/">메인화면</Link></li>
            <li>
                {isLoggedIn ? (
                    <button onClick={handleLogout} className={styles.logoutButton}>LOGOUT</button>
                ) : (
                    <Link to="/member/LoginForm">LOGIN</Link>
                )}
            </li>
            <li><Link to="/board/BoardWriteForm">글쓰기</Link></li>
            <li><Link to="/board/BoardList">목록</Link></li>
          </ul>
        </nav>
      </div>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/member/LoginForm" element={<LoginForm setIsLoggedIn={setIsLoggedIn} />} />
        <Route path="/board">
          <Route path="BoardWriteForm" element={<BoardWriteForm />} /> 
          <Route path="BoardList" element={<BoardList />} />
        </Route>
        <Route path="/board/BoardDetail/:seq" element={<BoardDetail />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App01;
