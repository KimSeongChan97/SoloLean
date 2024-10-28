import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Main from './page04/Main';
import MemberDetail from './page04/MemberDetail';

// App04 컴포넌트는 전체 애플리케이션의 라우팅을 관리하는 컴포넌트입니다.
const App04 = () => {
     return (
          // BrowserRouter는 애플리케이션의 라우팅을 관리하는 기본 컴포넌트로, URL 변화를 감지하고 해당하는 페이지를 렌더링해 줍니다.
          <BrowserRouter>
               <>
                    {/* 화면에 보이는 영역 */}
                    <Routes>
                         {/* '/' 경로는 Main 컴포넌트를 렌더링합니다. */}
                         <Route path='/' element={ <Main /> } /> 
                         {/* '/member/:memberId' 경로는 회원 상세 페이지를 렌더링하며, :memberId는 특정 회원의 ID를 동적으로 받아올 수 있습니다. */}
                         <Route path='/member'>
                              <Route path=':memberId' element={ <MemberDetail /> } />
                         </Route>
                    </Routes>     
               </>
          </BrowserRouter>
     );
};

export default App04;
