import React from 'react';
import Time from './components/Time';
import Test01 from './components/Test01';
import Test02 from './components/Test02';
import Movies from './components/Movies';
import Test03 from './components/Test03';
import Test04 from './components/Test04';
import Test05 from './components/Test05';

const App = () => {
  return (
    <div style={{ background: 'linear-gradient(132deg, #d3bfeb, #bcd9f5)',
                  fontFamily: 'Orbitron',
                   textAlign: 'center' }}>
      <div >
          <hr/>
          <Time />
          {/* 
          <hr/>
          <hr/>
          <Test01 /> 
            <Test02 />
          <hr/>
          */}
          <hr/>
          <Movies />
          <hr/>
          <Test03 />
          <hr/>
          <Test04 />
          <hr/>
          <Test05 />
          <hr/> 
          <hr/>
      </div>
    </div>
  );
};

export default App;