import React from 'react';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import Home from './page03/Home';
import About from './page03/About';
import Profile from './page03/Profile';
import Front from './page03/Front';

// data 배열 생성, 각 객체는 title과 info 속성을 포함하여 프론트엔드 기술 정보를 담고 있음
const data = [
     { title: 'html', info: 'HTML 입니다. '},  // title: 기술 이름, info: 설명 (예: HTML)
     { title: 'css', info: 'CSS 입니다. '},    // CSS에 대한 간단한 설명
     { title: 'javascript', info: 'Javascript 입니다. '}, // JavaScript에 대한 간단한 설명
     { title: 'react', info: 'React 입니다. '}, // React에 대한 간단한 설명
     { title: 'vue', info: 'Vue 입니다. '}       // Vue에 대한 간단한 설명
]

// App03 컴포넌트는 React 애플리케이션의 메인 컴포넌트로 라우팅 및 네비게이션을 담당
const App03 = () => {
     return (
          // BrowserRouter는 전체 라우팅 기능을 제공하는 컴포넌트로, 하위 요소에 모든 라우팅 기능을 적용
          <BrowserRouter>
               <>
                    {/* 네비게이션 링크를 정의하는 목록 */}
                    <ul style={{ listStyleType: 'none' }}>
                         {/* 각 <li> 안에 Link를 통해 라우트 경로로 이동할 수 있게 설정 */}
                         <li><Link to='/' > HOME </Link></li>   
                         <li><Link to='/about' > ABOUT </Link></li>  
                         <li><Link to='/profile' > PROFILE </Link></li> 

                         {/* @RequestMapping(value="user") 의 함수 밑에 @RequestMappgng(value="getExistId") 와 비슷하다 */}
                         {/* 위의 주석은 Spring의 @RequestMapping을 설명하는 것으로, 각 라우트가 특정 URL 패턴과 연관되는 방식을 나타냄 */}
                         
                         {/* 중첩 url - 프론트엔드 각 기술에 대한 상세 페이지로 이동할 수 있도록 링크를 설정 */}
                         {/* front components 를 통해 이동 - Front 컴포넌트에서 중첩된 URL을 통해 데이터를 렌더링 */}
                         <li><Link to='/front/html' > HTML </Link></li> 
                         <li><Link to='/front/css' > CSS </Link></li>  
                         <li><Link to='/front/javascript' > Javascript </Link></li> 
                         <li><Link to='/front/react' > React </Link></li>  
                         <li><Link to='/front/vue' > VUE </Link></li>  
                    </ul>
               </>

               {/* 화면에 보이는 영역 - 라우팅 설정 */}
               <Routes>
                    {/* Route 컴포넌트를 사용하여 각 경로에 대해 렌더링할 컴포넌트를 정의 */}
                    <Route path='/' element={ <Home /> } /> 
                    <Route path='/about' element={ <About /> } />  
                    <Route path='/profile' element={ <Profile /> } />  

                    {/* <Route path='/front:변수명(변수명은 자유롭게 가능)' /> */}
                    {/* :name으로 변수를 지정하여 각 기술 이름에 따라 데이터를 동적으로 전달 */}
                    <Route path='/front/:name' element={ <Front data={ data } /> } /> 
                    {/* '/front/:name' 경로에서 Front 컴포넌트를 렌더링하며 data 배열을 전달 */}
               </Routes>
          </BrowserRouter>
     );
};

// 컴포넌트 export로 외부에서 사용할 수 있도록 설정
export default App03;

/*
 :style 를 route path에 사용하면 useParams() 로 불러와 사용할 수 있다.
 : 뒤에 나오는 부분이 params의 key 부분이 되어 :name 는 name가 key가 되어 불러오고 있다.
 :name 구문은 React Router에서 특정 URL 경로의 일부분을 변수처럼 동적으로 받아올 수 있게 해주며,
 이를 통해 URL의 일부분을 useParams() 훅으로 접근하여 컴포넌트에서 사용할 수 있음
*/
