import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { increment, decrement, reset } from '../store/modules/count.jsx';

const Count = () => {

     const count = useSelector((state) => state.count.count); // 상태에서 count 값 가져오기
     // useSelector는 리덕스 스토어의 상태를 선택(select)하는 Hook입니다.
     // 여기서 state는 리덕스의 전체 상태를 의미하며, state.count는 count 리듀서가 관리하는 상태를 의미합니다.
     // 따라서 state.count.count는 count 리듀서 내에 있는 count 값을 가져옵니다.
     
     const dispatch = useDispatch();
     // useDispatch는 리덕스의 액션을 디스패치(dispatch)할 수 있게 해주는 Hook입니다.
     // 이를 통해 컴포넌트에서 직접 액션을 발생시켜 상태를 변경할 수 있습니다.

     return (
          <div>
               <h1> 카운트 : { count } </h1>
               <p>
                    <button onClick={ () => dispatch(increment()) }> 증가 </button> &nbsp;
                    <button onClick={ () => dispatch(decrement()) }> 감소 </button> &nbsp;
                    <button onClick={ () => dispatch(reset()) }> 초기화 </button> &nbsp;
               </p>
          </div>
     );
};

export default Count;
