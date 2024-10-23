import React from 'react';

const CatItem = ({ item }) => {
     const { id, img, title } = item;


     return (
          <li>
               <a href='#'>
                    <div>
               <img src={ img } alt={ title } />
                    </div>
               </a>  
          </li>
     );
};

export default CatItem;