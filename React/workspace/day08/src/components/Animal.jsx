import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { tiger, dog, cat, chick } from '../store/modules/animal';

const Animal = () => {

     const name = useSelector(state => state.animal.name);
     const crying = useSelector(state => state.animal.crying);
     const count = useSelector((state) => state.count.count);
     const color = useSelector(state => state.color.color);
     
     const dispatch = useDispatch();

     return (
          <div>
               <h1> 동물의 울음소리 </h1>
               <h3 style={{ color }}>  { color } 색의  { name } 는 { crying } 하고 { count } 번 웁니다. </h3>
               <p>
                    <button onClick={ () => dispatch(tiger()) } > 호랑이 </button> &nbsp;
                    <button onClick={ () => dispatch(dog()) } > 강아지 </button> &nbsp;
                    <button onClick={ () => dispatch(cat()) } > 고양이 </button> &nbsp;
                    <button onClick={ () => dispatch(chick()) } > 병아리 </button> &nbsp;
               </p>
          </div>
     );
};

export default Animal;