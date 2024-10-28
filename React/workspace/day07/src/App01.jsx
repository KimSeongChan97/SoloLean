// App01.jsx
import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom'; 
// React 라이브러리에서 BrowserRouter, Routes, Route, Link 컴포넌트를 불러옵니다.
// BrowserRouter: SPA(Single Page Application) 방식으로 페이지를 로딩 없이 전환하도록 돕는 라우터
// Routes: 여러 개의 Route들을 감싸고, 그 중 하나만 화면에 표시되도록 하는 컨테이너 역할
// Route: 특정 경로(path)에 해당하는 컴포넌트를 지정하여 해당 경로로 이동 시 렌더링할 컴포넌트를 설정
// Link: 페이지 전환을 위한 링크 생성(기본 <a> 태그와 달리 로딩 없이 이동)

import Home from './page01/Home'; // Home 컴포넌트 파일을 import하여 메인 경로에서 표시할 컴포넌트를 정의합니다.
import About from './page01/About'; // About 컴포넌트 파일을 import하여 /about 경로에서 표시할 컴포넌트를 정의합니다.
import Ceo from './page01/Ceo'; // Ceo 컴포넌트 파일을 import하여 /ceo 경로에서 표시할 컴포넌트를 정의합니다.
import Sub01 from './page01/Sub01'; // Sub01 컴포넌트 파일을 import하여 /sub01 경로에서 표시할 컴포넌트를 정의합니다.
import NotFiles from './page01/NotFiles'; // NotFiles 컴포넌트 파일을 import하여 잘못된 경로에 대한 예외 처리를 합니다.

const App01 = () => {
     return (
          <BrowserRouter> {/* SPA(Single Page Application) 기능을 위해 BrowserRouter 사용 */}
              <>
                    <nav style={{ marginBottom: '20px' }}>
                         <ul style={{ listStyleType: 'none', margin: '0' }}>
                              {/* <a href=''/> 를 사용하면 로딩하느라 계속해서 대기해야한다. */}
                              {/* <a href=''/> 를 대신해서 <Link> 를 사용해야 한다. */}
                              {/* Link를 사용함으로써 페이지가 새로고침 없이 이동 가능하여, 빠른 반응성과 SPA 기능을 구현합니다 */}
                              <Link to="/" style={{ margin: '0 10px' }}>Home</Link> 
                              <Link to="/about" style={{ margin: '0 10px' }}>About</Link> 
                              <Link to="/ceo" style={{ margin: '0 10px' }}>CEO</Link> 
                              <Link to="/sub01" style={{ margin: '0 10px' }}>Sub01</Link> 
                         </ul>
                    </nav>
              </>

               {/* 화면에 보이는 영역 */}
               <Routes> {/* 각 경로에 따라 다른 컴포넌트를 렌더링하는 영역 */}
                    <Route path="/" element={<Home />} /> 
                    {/* path="/" 경로는 루트 경로를 나타내며, 루트 경로로 이동 시 Home 컴포넌트를 렌더링 */}
                    
                    <Route path="/about" element={<About />} /> 
                    {/* path="/about" 경로로 이동 시 About 컴포넌트를 렌더링 */}

                    <Route path="/ceo" element={<Ceo />} /> 
                    {/* path="/ceo" 경로로 이동 시 Ceo 컴포넌트를 렌더링 */}

                    <Route path="/sub01" element={<Sub01 />} /> 
                    {/* path="/sub01" 경로로 이동 시 Sub01 컴포넌트를 렌더링 */}

                    <Route path="*" element={<NotFiles />} />
                    {/* path="*"는 와일드카드로, 정의되지 않은 경로로 접근할 때 NotFiles 컴포넌트를 렌더링 */}
                    {/* Spring 의 RequestMapping과 비슷한 의미 = @RequestMapping(value="/") */}
               </Routes>
          </BrowserRouter>
     );
};

export default App01;

/*
     // Link 네비게이션 링크 생성
     <nav style={{ marginBottom: '20px' }}> 
          <Link to="/" style={{ margin: '0 10px' }}>Home</Link> 
          <Link to="/about" style={{ margin: '0 10px' }}>About</Link> 
          <Link to="/ceo" style={{ margin: '0 10px' }}>CEO</Link> 
          <Link to="/sub01" style={{ margin: '0 10px' }}>Sub01</Link> 
     </nav>

     // 위 주석은 간단한 네비게이션 바의 예시로, 페이지 전환을 위한 Link 요소를 설명하고 있음
*/
