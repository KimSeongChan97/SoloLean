import React, { useState } from 'react';

const Test05 = () => {
     // count는 숫자 상태를 저장하는 상태 변수로, 초기값은 0입니다.
     // setCount는 count 값을 변경하는 함수입니다. 이 함수는 상태를 변경할 때 사용됩니다.
     const [count, setCount] = useState(0);

     // onAdd 함수는 count 값을 1씩 증가시킵니다.
     // setCount를 호출할 때 count + 1로 현재 상태에서 1을 더한 값을 저장합니다.
     const onAdd = () => {
          setCount(count + 1);
     };

     // onSub 함수는 count 값을 1씩 감소시킵니다.
     // setCount를 호출할 때 count - 1로 현재 상태에서 1을 뺀 값을 저장합니다.
     const onSub = () => {
          setCount(count - 1);     
     };

     // onReset 함수는 count 값을 초기값인 0으로 리셋합니다.
     // setCount(0)을 호출하여 상태를 0으로 초기화합니다.
     const onReset = () => {
          setCount(0);
     };

     return (
          <div>

               <h2> 숫자 : { count } </h2>

               <p>
                    {/* onAdd 함수를 호출하여 count 값을 1 증가시킵니다.
                        setCount가 호출되어 count 상태가 변경되면 화면이 다시 렌더링됩니다. */}
                    <button onClick={ onAdd }>1씩 증가</button>

                    {/* onSub 함수를 호출하여 count 값을 1 감소시킵니다.
                        setCount가 호출되어 count 상태가 변경되면 화면이 다시 렌더링됩니다. */}
                    <button onClick={ onSub }>1씩 감소</button>

                    {/* onReset 함수를 호출하여 count 값을 0으로 초기화합니다.
                        setCount(0)이 호출되면 count 상태가 0으로 변경되며, 화면도 이에 맞게 렌더링됩니다. */}
                    <button onClick={ onReset }>초기화</button>
               </p>
          </div>
     );
};

export default Test05;


/*
상태변수 count 기본값은 0

useState는 React Hook 중 하나로, 함수형 컴포넌트에서 상태를 관리할 수 있게 해줍니다.
상태 변수 count는 숫자 상태를 관리하는데 사용되며, 이 값은 setCount를 통해 업데이트됩니다.
상태가 변경되면 컴포넌트가 자동으로 다시 렌더링되어 화면에 변경 사항이 반영됩니다.

버튼을 클릭하면 각각의 함수(onAdd, onSub, onReset)가 호출되어 상태를 변경하고, 그 결과에 따라
화면에 숫자가 증가, 감소, 혹은 초기화됩니다. num 변수는 count 값을 담아 화면에 보여주기 위한
변수로, 결국 count 상태를 간접적으로 참조합니다.
*/
