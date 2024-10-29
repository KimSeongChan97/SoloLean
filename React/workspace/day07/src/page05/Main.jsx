// React와 CSS 모듈을 사용해 메인 페이지 컴포넌트를 구성
import React from 'react';
import styles from '../css/style05.module.css';  // CSS 모듈을 불러와 컴포넌트에 스타일을 적용
import products from './data';  // 제품 데이터를 포함하는 파일을 불러옴

// Main 컴포넌트: 메인 페이지에 특정 제품 정보를 표시
const Main = () => {
  
  // products 배열에서 id가 '1'인 첫 번째 제품을 찾음
  const product = products.find((item) => item.id === '1');

  return (
    <div className={styles.main}>
      <h1>토심이의 홈페이지</h1>  
      <h2>방문해주셔서 감사합니다.</h2>  
      
      {/* product가 존재할 때만 아래 내용을 표시 */}
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

export default Main;  // Main 컴포넌트를 다른 파일에서 사용할 수 있도록 내보내기
