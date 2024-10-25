import React, { useState } from 'react';
import CatData from './CatData';
import CatList from './CatList';
import '../../css/reset.css';
import '../../css/style.css';


const Cat = () => {

     const [list, setList] = useState(CatData); // 상태변수


     return (
          <>
               <section className='business'>
                    <div className='inner'>
                         <h2> 고 양 이 </h2>
                         <p>고양이들</p>
                         <CatList list={ list } />
                    </div>
               </section>
          </>
     );
};

export default Cat;