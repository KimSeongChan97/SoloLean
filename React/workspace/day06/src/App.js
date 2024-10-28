import React from 'react';
import Time from './components/Time';
import Test01 from './components/Test01';
import Test02 from './components/Test02';
import Test03 from './components/Test03';
import Test04 from './components/Test04';
import Test05 from './components/Test05';

const App = () => {
  return (
    <div style={{ background: 'linear-gradient(121deg, #d3bfeb, #bcd9f5)',
          fontFamily: 'Orbitron',
          textAlign: 'center' }}>
      <div>
          <hr/>
          <Time />
          <hr/>
          <Test01 />
          <hr/>
          <Test02 />
          <hr/>
          <Test03 />
          <hr/>
          <Test04 />
          <hr/>
          <Test05 />          
          <hr/>
          
          <hr/>

          <hr/>

          <hr/>

      </div>
    </div>
  );
};

export default App;