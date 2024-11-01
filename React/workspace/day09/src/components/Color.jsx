import React, { useContext } from 'react';
// ColorContext를 import하여 색상 데이터와 함수를 가져올 준비를 한다.
// ColorContext는 색상 데이터와 관련된 함수들을 포함하고 있어, 이를 통해 색상 상태에 접근할 수 있다.
import { ColorContext } from '../contexts/ColorContext';
// CountContext를 import하여 count 데이터와 관련 함수들을 가져온다.
// CountContext는 숫자 카운트를 위한 데이터를 포함하고 있으며, 이를 통해 카운트 상태를 활용할 수 있다.
import { CountContext } from '../contexts/CountContext';

import styles from '../css/button.module.css';


const Color = () => {

     // ColorContext와 CountContext에서 필요한 데이터를 가져온다.
     // useContext를 사용하여 ColorContext에서 color와 각 색상 변경 함수를, 
     // CountContext에서 count, increment, decrement를 가져와 컴포넌트 내에서 사용한다.
     const { color, onRed, onGreen, onBlue, onMagenta, onCyan } = useContext(ColorContext);
     const { count, increment, decrement } = useContext(CountContext);

     return (
          <div>
               <h1 style={{ color: color }}> 컬러 : { color } , { count }  </h1>
               <p>
                    <button className={styles.button}  onClick={ () => onRed() }> 빨강 </button>
                    <button className={styles.button}  onClick={ () => onGreen() }> 초록 </button>
                    <button className={styles.button}  onClick={ () => onBlue() }> 파랑 </button>
                    <button className={styles.button}  onClick={ () => onMagenta() }> 마젠타 </button>
                    <button className={styles.button}  onClick={ () => onCyan() }> 시안 </button>
               </p>
               <p>
                    <button className={styles.button}  onClick={ () => increment() }> 증가 </button>
                    <button className={styles.button}  onClick={ () => decrement() }> 감소 </button>
               </p>
          </div>
     );
};

// Color 컴포넌트를 export하여 다른 파일에서 사용할 수 있게 한다.
// 외부 파일에서도 Color 컴포넌트를 사용하여 색상 변경과 카운트 조작 기능을 화면에 표시할 수 있게 한다.
export default Color;
