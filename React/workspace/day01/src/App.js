import logo from './logo.svg'; 
import './App.css'; 
import Dog from './compoents/Dog'; 
import React from 'react'; 
import Test01 from './compoents/Test01'; 
import Test02 from './compoents/Test02';
import Test03 from './compoents/Test03';
import Test04 from './compoents/Test04';
import Person from './compoents/Person';
import Test05 from './compoents/Test05';

{/* 
function App() { 
  return ( 
    <div className="App"> 
      <header className="App-header"> 
        <img src={logo} className="App-logo" alt="logo" /> 
        <p> 
          Edit <code>src/App.js</code> and save to reload. 
        </p> 
        <a 
          className="App-link" 
          href="https://reactjs.org" 
          target="_blank" 
          rel="noopener noreferrer" 
        > 
          Learn React 
        </a> 
      </header> 
    </div> 
  ); 
} 
*/}

const App = () => {
  return (
    <>
    {/* 최상단에는 반드시 <div></div> 로 감싸야 한다. */}
    {/* 리액트 컴포넌트는 여러 요소를 반환할 때 최상위 태그로 감싸야 하는데, Fragment를 사용하면 <div>를 쓰지 않고 빈 태그(<></>)로 감쌀 수 있습니다. */}
    <h3> Hello React !! </h3> 
    {/* <h3> 태그는 제목을 표시합니다. 여기서는 "Hello React !!"라는 문구가 나타납니다. */}
    <hr/>
    <Dog />
    {/* Dog 컴포넌트를 화면에 렌더링합니다. 해당 컴포넌트에서 정의된 JSX 구조가 표시됩니다. */}
    <hr/>
    <Dog />
    <hr/>
    <Test01 />
    {/* Test01 컴포넌트를 화면에 렌더링합니다. 해당 컴포넌트에서 정의된 내용을 JSX로 화면에 표시합니다. */}
    <hr/>
    <Test02 />
    {/* Test02 컴포넌트를 화면에 렌더링합니다. 이 컴포넌트에서 사용된 변수와 JSX가 화면에 표시됩니다. */}
    <hr/>
    <Test03 />
    <hr/>
    <Test04 />
    <hr/>
    <Test05 />
    <hr/>
    </>
  );
};

export default App;
// 이 부분은 이 파일(App 컴포넌트)을 외부에서 사용할 수 있도록 내보내는 구문입니다. 이로 인해 다른 파일에서 import App를 통해 App 컴포넌트를 불러올 수 있습니다.
