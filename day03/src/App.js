import React from 'react';
import './App2.css';
import Time from './components/Time';
import Test01 from './components/Test01';
import Test02 from './components/Test02';
import Test03 from './components/Test03';
import Test04 from './components/Test04';
import Test05 from './components/Test05';
import Test06 from './components/Test06';
import Test07Main from './components/Test07Main';
import Test08Gallary from './components/Test08Gallary';
import Test09 from './components/Test09';
import Test10 from './components/Test10';
import Test11 from './components/Test11';

const App = () => {
  return (
    <div>
      <hr/>
      <Time/>
      <hr/>
      <Test01/>
      <hr/> 
      <Test02 /> 
      <hr/>
      <Test03 />
      <hr/>
      <Test04 />
      <hr/>
      <Test05 />
      <hr/> 
      <Test06 />
      <hr/>    
      <Test07Main />
      <hr/>
      {/* <Test08Gallary />
      <hr/> */}
      <hr/>
        <Test09 />
      <hr/>
        <Test10 />
      <hr/>
        <Test11 />
      <hr/>
        
      <hr/>
    </div>
  );
};

export default App;