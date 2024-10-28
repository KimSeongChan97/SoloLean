import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom'; 
// React 라이브러리에서 BrowserRouter, Routes, Route 컴포넌트를 import 합니다.
// BrowserRouter: SPA(Single Page Application) 기능을 제공하여, 페이지를 새로고침하지 않고도 다른 페이지로 이동할 수 있게 합니다.
// Routes: 여러 개의 Route 컴포넌트를 감싸서 각기 다른 URL 경로에 따라 컴포넌트를 렌더링할 수 있도록 합니다.
// Route: 특정 URL 경로(path)에 대해 렌더링할 컴포넌트를 지정하여 경로에 맞는 컴포넌트를 화면에 출력합니다.

import NavBar from './page02/NavBar'; 
// NavBar 컴포넌트를 import하여 모든 페이지에 걸쳐 표시할 네비게이션 바를 렌더링합니다.
import Home from './page02/Home'; 
// Home 컴포넌트를 import하여 루트 경로('/')에 해당하는 컴포넌트를 제공합니다.
import About from './page02/About'; 
// About 컴포넌트를 import하여 /about 경로에 해당하는 컴포넌트를 제공합니다.
import Ceo from './page02/Ceo'; 
// Ceo 컴포넌트를 import하여 /ceo 경로에 해당하는 컴포넌트를 제공합니다.
import Sub01 from './page02/Sub01'; 
// Sub01 컴포넌트를 import하여 /sub01 경로에 해당하는 컴포넌트를 제공합니다.
import NotFiles from './page02/NotFiles'; 
// NotFiles 컴포넌트를 import하여 정의되지 않은 경로에 접근 시 예외 페이지를 제공합니다.

const App02 = () => {
     return (
          <BrowserRouter> {/* SPA(Single Page Application) 기능을 위해 BrowserRouter 사용 */}
              <>
                    <NavBar /> 
                    {/* NavBar 컴포넌트를 호출하여 네비게이션 바를 렌더링. 모든 페이지에 공통으로 나타납니다.
                     SPA 방식이므로 페이지 이동 시 NavBar가 새로고침되지 않고 그대로 유지됩니다. */}
                    
                    {/* 화면에 보이는 영역 */}
                    <Routes> {/* 각 경로에 따라 다른 컴포넌트를 렌더링하는 영역 */}
                         <Route path="/" element={<Home />} /> 
                         {/* path="/" 경로는 루트 경로로, 이 경로로 접근 시 Home 컴포넌트를 렌더링합니다. */}
                         
                         <Route path="/about" element={<About />} /> 
                         {/* path="/about" 경로로 접근 시 About 컴포넌트를 렌더링합니다. About 페이지에 대한 내용을 포함하고 있습니다. */}

                         <Route path="/ceo" element={<Ceo />} /> 
                         {/* path="/ceo" 경로로 접근 시 Ceo 컴포넌트를 렌더링합니다. Ceo 페이지에 대한 콘텐츠를 제공 */}
                         
                         <Route path="/sub01" element={<Sub01 />} /> 
                         {/* path="/sub01" 경로로 접근 시 Sub01 컴포넌트를 렌더링합니다. 추가적인 페이지(sub01)에 대한 내용을 포함 */}

                         <Route path="*" element={<NotFiles />} />
                         {/* path="*"는 와일드카드로, 정의되지 않은 모든 경로에 대해 NotFiles 컴포넌트를 렌더링합니다.
                              잘못된 경로로 접근 시 사용자에게 오류 페이지를 보여주는 예외 처리용 컴포넌트 */}
                    </Routes>
              </>
          </BrowserRouter>
     );
};

export default App02;
