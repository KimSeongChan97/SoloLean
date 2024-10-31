import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { red, green, blue, magenta } from '../store/modules/color.jsx';

const Color = () => {

     const color = useSelector(state => state.color.color);
     // state(상태변수 및 객체).컴바인시킨 color(/store/index.jsx) 이름에 대한것.color(/store/modules/color.jsx)값
     // useSelector 훅을 통해 리덕스 스토어에 저장된 상태에 접근한다.
     // 여기서 state.color.color는 state.color로 index.jsx에서 정의한 color 리듀서를 참조하고,
     // 그 안의 color 속성에 접근하는 구조이다. 이는 color 리듀서의 현재 상태 값, 즉 현재 색상을 나타낸다.

     const dispatch = useDispatch();
     // action 에 대한 값, dispatch 에 저장된 값은 /store/modules/color.jsx 에 있는 값
     // useDispatch 훅은 리덕스 스토어에 액션을 보낼 수 있는 함수(dispatch)를 반환한다.
     // 이 함수는 액션 객체를 리듀서에 전달하여 상태를 변경하는 역할을 한다.
     // 예를 들어, dispatch(red())를 호출하면 red 액션을 리듀서에 전달해 상태가 'red'로 변경된다.

     const count = useSelector((state) => state.count.count);

     return (
          <div>
               <h1 style={{ color: color }}> 컬러 : { color } , { count }  </h1>
               {/* reducer 에 보관된 color 값을 가져옴 */}
               {/* 스타일에 inline 방식으로 color 값을 지정한다. 이는 리덕스 상태의 color 값이 변경되면
                   자동으로 h1 태그의 색상이 변경되도록 해준다. color 변수는 현재 선택된 색상 상태를 나타낸다. */}
               <br/>

               <p>
                    <button onClick={ () => dispatch(red()) }> RED </button> &nbsp;
                    <button onClick={ () => dispatch(green()) }> GREEN </button> &nbsp;
                    <button onClick={ () => dispatch(blue()) }> BLUE </button> &nbsp;
                    <button onClick={ () => dispatch(magenta()) }> MAGENTA </button> &nbsp;
                    {/* 각 버튼에는 onClick 이벤트로 dispatch 함수를 호출하여 색상을 변경하는 액션을 보낸다.
                        예를 들어, RED 버튼을 클릭하면 dispatch(red())가 호출되어 색상이 'red'로 변경된다.
                        dispatch 함수는 액션을 리듀서에 전달하여 상태를 업데이트하는 역할을 한다.
                        각 색상에 따라 미리 정의된 액션 함수(red, green, blue, magenta)를 호출하여 리듀서에 전달한다. */}
               </p>
          </div>
     );
};

export default Color;
