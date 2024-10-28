import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Main from './page05/Main'; 
import ProductList from './page05/ProductList'; 
import Product from './page05/Product'; 
import styles from './css/style05.module.css'; 

const App05 = () => {
  return (
    <Router>
      <div className={styles.menunav}>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/productlist">ProductList</Link></li>
        </ul>
      </div>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="/productlist" element={<ProductList />} />
        <Route path="/product/:id" element={<Product />} />
      </Routes>
    </Router>
  );
};

export default App05;
