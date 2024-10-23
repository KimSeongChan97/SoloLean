import React from 'react';
import CatItem from './CatItem';

const CatList = ({ list }) => {
     return (
          
               <ul className='list2'>
                    {
                         list.map(item => <CatItem key={ item.id } item = { item } />)
                    }
               </ul>
          
     );
};

export default CatList;