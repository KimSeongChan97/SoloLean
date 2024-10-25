import React from 'react';

const Lion = (props) => {
     const { name } = props;
     return (
          <div>
               <h3>나는 {name} 컴포넌트에요. </h3>
          </div>
     );
};

export default Lion;