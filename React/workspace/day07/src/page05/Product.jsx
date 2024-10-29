// 개별 제품 상세 정보를 표시하는 React 컴포넌트
import React from 'react';
import { useNavigate, useParams } from 'react-router-dom';  // React 라우터에서 제공하는 useNavigate와 useParams 훅을 불러옴
import products from './data';  // 제품 데이터 파일을 불러옴
import styles from '../css/style05.module.css';  // CSS 모듈을 불러와 스타일 적용

const Product = () => {
  
  // URL에서 전달된 id 파라미터 값을 가져옴
  const { id } = useParams();
  // products 배열에서 id가 일치하는 제품을 찾음
  const product = products.find((item) => item.id === id);

  const navigate = useNavigate();  // navigate 함수로 페이지 이동을 제어 가능

  const onHome = () => {
    navigate('/');  // 루트 경로로 이동하여 홈으로 돌아가도록 설정
  };
  
  const onBack = () => {
    navigate(-1);  // 이전 페이지로 돌아가도록 설정
  };

  // 해당 제품이 없을 경우 메시지 표시
  if (!product) return <p>상품을 찾을 수 없습니다.</p>;

  return (
    <div className={styles.item}>
      <h2>{product.name}</h2> 
      <img src={product.photo} alt={product.name} />  
      <h3>가격: {product.price} 원</h3> 
      <p>{product.description}</p> 

      <button onClick={ onHome }>Home</button>
      <button onClick={ onBack }>ProductList</button> 
    </div>
  );
};

export default Product;  // Product 컴포넌트를 다른 파일에서 사용할 수 있도록 내보내기
