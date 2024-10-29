import React from 'react';
import data from '../data';

import styles from '../../css/style05.module.css';


const Main = () => {
  
  const product = data.find((item) => item.id === '1');

  return (
    <div className={styles.main}>
      <h1>호박이의 홈페이지</h1>  
      <h2>방문해주셔서 감사합니다.</h2>  
      
      {product && (
        <>
          <h3>{product.name}</h3>
          <img src={product.photo} alt={product.name} /> 
        </>
      )}
    </div>
  );
};

export default Main;
