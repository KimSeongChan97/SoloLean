// React와 react-router-dom 라이브러리를 사용하여 라우팅 기능을 추가한 컴포넌트를 만들고 있음
import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Main from './page05/Main';  // 메인 페이지 컴포넌트 불러오기
import ProductList from './page05/ProductList';  // 제품 목록 페이지 컴포넌트 불러오기
import Product from './page05/Product';  // 개별 제품 페이지 컴포넌트 불러오기

import styles from './css/style05.module.css';  // 스타일 모듈을 CSS 파일로 불러와 스타일을 적용

// App05 컴포넌트: 전체 애플리케이션의 라우팅 설정과 네비게이션을 제공
const App05 = () => {
  return (
    // BrowserRouter로 전체 라우터를 감싸, React 라우팅 기능을 가능하게 함
    <BrowserRouter>
      <div className={styles.menunav}>
        {/* 네비게이션 메뉴 */}
        <ul>
          {/* Link 컴포넌트를 사용해 페이지 간 네비게이션이 가능한 링크 생성 */}
          <li><Link to="/">Home</Link></li>
          <li><Link to="/productlist">ProductList</Link></li>
        </ul>
      </div>
      <Routes>
        <Route path="/" element={<Main />}>  
          {/* "/" 기본 경로에서 Main 컴포넌트를 기본적으로 표시 */}
          <Route index element={<Main />} />  {/* Index Route를 사용하여 Main 컴포넌트를 기본 경로에 표시 */}
        </Route>
        <Route path="/productlist" element={<ProductList />} />
        <Route path="/product/:id" element={<Product />} />
      </Routes>
    </BrowserRouter>
  );
};

export default App05;  // App05 컴포넌트를 다른 파일에서 사용 가능하도록 내보내기

