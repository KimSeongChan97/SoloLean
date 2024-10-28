import React from 'react';
import products from './data';
import styles from '../css/style05.module.css';
import { Link } from 'react-router-dom';

const ProductList = () => {
  return (
    <div className={styles.products}>
      <h2>토심이의 일상 리스트</h2>
      <div>
        {products.map((product) => (
          <article key={product.id} className={styles.article}>
            <Link to={`/product/${product.id}`}>
              <img src={product.photo} alt={product.name} />
              <h3>{product.name}</h3>
            </Link>
          </article>
        ))}
      </div>
    </div>
  );
};

export default ProductList;
