import React, { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Main from './components/main/Main';
import LoginForm from './components/member/LoginForm';
import Write from './components/board/write';
import List from './components/board/list';
import styles from './css/style05.module.css';

const App01 = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const userId = sessionStorage.getItem('userId'); // 세션에서 userId 확인
    setIsLoggedIn(!!userId); // userId가 있으면 로그인 상태로 설정
  }, []);

  const onLogout = () => {
    sessionStorage.removeItem('userId'); // 세션 스토리지에서 userId 삭제
    setIsLoggedIn(false); // 로그아웃 후 상태 업데이트
  };

  return (
    <BrowserRouter>
      <div className={styles.menunav}>
        <nav>
          <ul>
            <li><Link to="/">메인화면</Link></li>
            {isLoggedIn ? (
              <>
                <li>
                  <Link to="/" onClick={onLogout} style={{ cursor: 'pointer' }}>
                    LOGOUT
                  </Link>
                </li>
                <li><Link to="/board/write">글쓰기</Link></li>
              </>
            ) : (
              <li><Link to="/loginForm">LOGIN</Link></li>
            )}
            <li><Link to="/board/list">목록</Link></li>
          </ul>
        </nav>
      </div>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/loginForm" element={<LoginForm />} />
        <Route path="/board/write" element={<Write />} />
        <Route path="/board/list" element={<List />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App01;
