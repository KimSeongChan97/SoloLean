import React from 'react';
import Time from './components/Time';
import Test01 from './components/Test01';
import Test02 from './components/Test02';
import Test03 from './components/Test03';
import Test04 from './components/Test04';
import Todos from './components/Todos';

const App = () => {
  return (
    <div style={{ 
        background: 'linear-gradient(132deg, #d3bfeb, #bcd9f5)', 
        textAlign: 'center', 
        padding: '20px',
        minHeight: '100vh' // 화면 전체를 채우기 위해 추가
      }}
    >
        <div style={{
            background: '#f4f4f4',
            borderRadius: '15px', 
            boxShadow: '0 4px 15px rgba(0, 0, 0, 0.1)', // 박스 그림자
            padding: '20px', // 내부 여백
            
        }}>
            <hr/>
            <Time />
            {/* 
            <hr/>
            <Test01 />
            <hr/>
            <Test02 />
            <hr/>
            <Test03 />
            <hr/>
            <Test04 />
            <hr/> 
            */}
            <hr/>
              <Todos />
            <hr/>
              
            <hr/>
        </div>
    </div>
  );
};

export default App;
