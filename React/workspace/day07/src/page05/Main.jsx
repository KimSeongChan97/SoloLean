import React from 'react';
import styles from '../css/style05.module.css';
import products from './data';

const Main = () => {
  
  const product = products.find((item) => item.id === '1');

  return (
    <div className={styles.main}>
      <h1>토심이의 홈페이지</h1>
      <h2>방문해주셔서 감사합니다.</h2>
      
      {product && (
        <>
          <h3>{product.name}</h3>
          <img src={product.photo} alt={product.name} />
          <p>{product.description}</p>
          <p>가격: {product.price} 원</p>
        </>
      )}
    </div>
  );
};

export default Main;
