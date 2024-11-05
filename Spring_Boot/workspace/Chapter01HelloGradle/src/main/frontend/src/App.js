import React, { useState } from 'react';
import Time from './Time';
import BoardInput from './components/BoardInput';
import BoardList from './components/BoardList';
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import styles from './css/AppNav.module.css';

const App = () => {

  return (
    <div style={{
      background: 'linear-gradient(128deg, #a0e7e5, #b4f2e1)', 
      fontFamily: 'Orbitron', 
      textAlign: 'center',
      minHeight: '90vh',
      padding: '30px'
    }}>
      <Time />
      <BrowserRouter>
        <nav className={styles.navbar}>
          <Link to="/boardInput" className={styles.navLink}>🌊 게시글 등록 </Link>
          <Link to="/boardList" className={styles.navLink}>🌊 게시글 목록 </Link>
        </nav>
        <Routes>
          <Route path="/boardInput" element={<BoardInput />} />
          <Route path="/boardList" element={<BoardList />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
