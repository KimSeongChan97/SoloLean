import React from 'react';
import App01 from './App01';
import Time from './Time';

const App = () => {
     return (
          <div style={{
               background: 'linear-gradient(115deg, #d3bfeb, #bcd9f5)', 
               fontFamily: 'Orbitron', 
               textAlign: 'center' 
             }}>
               <br/>
               
               <Time />     
               <App01 />
               
               <br/>
               <br/>
          </div>
     );
};

export default App;