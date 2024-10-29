// 제품 목록을 보여주는 React 컴포넌트
import React from 'react';
import products from './data';  // 제품 목록 데이터를 불러옴
import styles from '../css/style05.module.css';  // CSS 모듈을 불러와 스타일 적용
import { Link } from 'react-router-dom';  // Link 컴포넌트를 사용해 다른 페이지로 이동 가능하게 설정

const ProductList = () => {
  return (
    <div className={styles.products}>
      <h2>토심이의 일상 리스트</h2>  
      <div>
        {
          // products 배열을 순회하여 각 제품에 대한 정보 표시
          products.map((product) => (
            <article key={product.id} className={styles.article}>
              {/* 각 제품의 링크를 설정하여 개별 Product 페이지로 이동 */}
              <Link to={`/product/${product.id}`}>
                <img src={product.photo} alt={product.name} />  
                <h3>{product.name}</h3>  
              </Link>
            </article>
          ))
        }
      </div>
    </div>
  );
};

export default ProductList;  // ProductList 컴포넌트를 다른 파일에서 사용할 수 있도록 내보내기
