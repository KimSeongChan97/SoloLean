import React, { useMemo, useState } from 'react';

// useMemo
const Test03 = () => {

     const [ count, setCount ] = useState(0);  // count라는 상태 변수를 선언하고 초기값을 0으로 설정합니다. setCount를 통해 count의 값을 변경할 수 있습니다.

     // count 의 값은 증가하지만, '짝수' / '홀수' 의 결과는 바뀌지 않는다
     // const isEven = () => {
     //      return count%2 === 0 // 짝수 또는 홀수, 2로 나눈 값이 0 이라면...
     // };

     // 사용자가 함수를 만들어서 return 할 경우 return 값을 기억하기 때문에 결과가 '짝수', '홀수' 가 나온다.
     const isEven = useMemo(() => {
          return count%2 === 0  // count의 값이 2로 나누어 떨어지면 true를 반환하고, 그렇지 않으면 false를 반환하여 짝수 또는 홀수를 판단합니다.
     }, [count]); // count 상태변수가 변경될때 마다 적용됨
     // useMemo는 count가 변경될 때만 계산을 실행하여, 그 외의 리렌더링 상황에서는 기존 값을 재활용합니다.
     // 이를 통해 불필요한 연산을 줄여 성능을 최적화할 수 있습니다.
     
     return (
          <div>
               <div style={{ textAlign: 'center' }}>
                    <h2> 카운트 : { count } </h2> 
                    <button onClick={ () => setCount(count + 1) } > 증가 </button>  
                    <h2>
                         결과 : { isEven ? '짝수' : '홀수' }
                    </h2>
                      {/* isEven의 값이 true면 '짝수', false면 '홀수'를 표시하여 짝수/홀수를 화면에 나타냅니다. */}
               </div>
          </div>
     );
};

export default Test03;

/*

return 되는 값을 저장한다

useMemo
리랜더링, 최적화
useMemo는 컴포넌트의 성능을 최적화시킬 수 있는 대표적인 react hooks 중 하나이다.
useMemo에서 Memo는 Memoization을 뜻한다.

memoization?
기존에 수행한 연산의 결괏값을 어딘가에 저장해 두고 동일한 입력이 들어오면 재활용하는 프로그래밍 기법을 말한다.

*/
