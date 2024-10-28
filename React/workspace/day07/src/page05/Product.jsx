import React from 'react';
import { useParams } from 'react-router-dom';
import products from './data';
import styles from '../css/style05.module.css';

const Product = () => {
  const { id } = useParams();
  const product = products.find((item) => item.id === id);

  if (!product) return <p>상품을 찾을 수 없습니다.</p>;

  return (
    <div className={styles.item}>
      <h2>{product.name}</h2>
      <img src={product.photo} alt={product.name} />
      <h3>가격: {product.price} 원</h3>
      <p>{product.description}</p>
    </div>
  );
};

export default Product;
