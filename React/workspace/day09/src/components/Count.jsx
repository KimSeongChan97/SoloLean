import React, { useContext } from 'react';
// CountContext를 가져와서 Count 컴포넌트에서 count 데이터와 관련 함수들을 사용한다.
// 다른 파일에서 CountContext를 import하여 사용할 수 있게 함으로써, Provider에서 제공하는 데이터를 이 컴포넌트에서도 사용할 수 있게 한다.
import { CountContext } from '../contexts/CountContext';

import styles from '../css/button.module.css';

// Count 컴포넌트는 count 값을 화면에 표시하고, increment, decrement 함수를 통해 카운트를 증감시키는 UI를 제공한다.
// 이 컴포넌트는 화면에 카운트 값을 출력하고, 이를 증가 및 감소시키는 버튼을 제공하여 유저가 직접 카운트를 조작할 수 있게 한다.
const Count = () => {

     //-----------------------------------------------------------------------------------------------------------------------
     /*
     return (
          <CountContext.Consumer>
               {
                    // Consumer를 통해 Context 데이터를 가져와서 사용할 수 있다.
                    // Consumer는 제공된 함수를 통해 Context 데이터에 접근하며, 
                    // 이 함수의 매개변수로 전달된 count, increment, decrement는 CountProvider에서 제공한 데이터와 함수들이다.
                    // Consumer 컴포넌트를 사용하면 Context API에서 제공된 데이터를 함수의 매개변수로 전달받아 사용할 수 있다.
                    // 이 방식은 하위 컴포넌트가 Context의 데이터를 접근할 때 사용된다.
                    ({ count, increment, decrement }) => (
                         <div>
                         <h1> 카운트 : { count } </h1> 
                         <p>
                              <button onClick={ () => increment() }> 증가 </button>
                              <button onClick={ () => decrement() }> 감소 </button>
                         </p>
                         </div>
                    )
               }
          </CountContext.Consumer>
     );
     */
    //-----------------------------------------------------------------------------------------------------------------------
    // <CountContext.Consumer> 를 사용하므로 코드가 복잡해져서, useContext 로 바꾼다.
    // 위와 같이 CountContext.Consumer로 Context 데이터를 사용하면 코드가 중첩되기 때문에 간단하게 사용할 수 있는 useContext 훅으로 변경한다.
    // useContext는 Context API의 데이터를 훨씬 직관적으로 사용할 수 있게 해준다.

    const { count, increment, decrement } = useContext(CountContext);
    // useContext(CountContext)를 통해 CountProvider에서 제공된 count, increment, decrement를 가져와서 사용할 수 있다.
    // 이 방식은 함수형 컴포넌트에서 Context의 데이터를 더 간결하고 직관적으로 사용할 수 있게 해준다.
     
    return (
               <div>
               <h1> 카운트 : { count } </h1> 
               <p>
                    <button className={styles.button} onClick={ () => increment() }> 증가 </button> &nbsp;
                    <button className={styles.button}  onClick={ () => decrement() }> 감소 </button>
               </p>
               </div>
    );
};

// Count 컴포넌트를 export하여 다른 파일에서 사용할 수 있도록 한다.
// 다른 파일에서 이 컴포넌트를 import하여 사용할 수 있게 하여, 화면에 카운트를 표시하는 기능을 쉽게 접근 가능하게 만든다.
export default Count;
