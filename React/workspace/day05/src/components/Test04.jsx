import React, { useState } from 'react';
import Test04Sub from './Test04Sub';

const Test04 = () => {
     // color와 food 상태 변수를 생성합니다. 이 상태 변수들은 각각 사용자가 선택한 색상과 음식을 저장하는 역할을 합니다.
     const [color, setColor] = useState(''); // 색상 선택 상태를 관리하기 위한 state 선언, 초기값은 빈 문자열
     const [food, setFood] = useState('');   // 음식 선택 상태를 관리하기 위한 state 선언, 초기값은 빈 문자열

     // onColor 함수는 색상을 선택할 때마다 호출되어 color 상태를 업데이트합니다.
     const onColor = (e) => {
          setColor(e.target.value); // 이벤트 객체 e의 target 값 (선택된 값)을 color 상태변수 에 반영합니다.
     };

     // onFood 함수는 음식을 선택할 때마다 호출되어 food 상태를 업데이트합니다.
     const onFood = (e) => {
          setFood(e.target.value); // 이벤트 객체 e의 target 값 (선택된 값)을 food 상태변수 에 반영합니다.
     };

     return (
          <div style={{ textAlign: 'center' }}>
               <h2> 당신이 좋아하는 색은 ? </h2>
               <div>
                    <select size='5' 
                            style={{ width: '120px'}}
                            onChange={ onColor } >
                                   <option value='hotpink'>hotpink</option>
                                   <option value='magenta'>magenta</option>
                                   <option value='skyblue'>skyblue</option>
                                   <option value='tomato'>tomato</option>
                                   <option value='cyan'>cyan</option>
                                   <option value='darkgreen'>darkgreen</option>
                    </select>
                    {/* 사용자가 선택할 수 있는 색상 목록을 표시하는 select 요소입니다.
                    각 옵션의 value 속성은 색상 상태로 저장될 값을 의미합니다. */}
               </div>
               <hr/>
               <h2> 당신이 좋아하는 음식은? </h2>
               <div>
                    <p>
                         <input type='radio' name='food' value='햄버거' onChange={onFood} />
                         <label>햄버거</label>
                    </p>
                    <p>
                         <input type='radio' name='food' value='삼겹살' onChange={onFood} />
                         <label>삼겹살</label>
                    </p>
                    <p>
                         <input type='radio' name='food' value='치킨' onChange={onFood} />
                         <label>치킨</label>
                    </p>
                    <p>
                         <input type='radio' name='food' value='피자' onChange={onFood} />
                         <label>피자</label>
                    </p>
                    {/* 라디오 버튼을 사용하여 사용자가 선택할 수 있는 음식 목록을 제공합니다.
                    각 라디오 버튼의 값은 food 상태에 저장될 값을 나타냅니다. onFood 함수가 실행되어 상태를 업데이트합니다. */}
               </div>
               <hr/>
               
               {/* 선택된 color와 food 상태를 Test04Sub 컴포넌트로 전달합니다.
               자식 컴포넌트에서 이 상태를 받아 해당 색상과 음식에 따라 다른 정보를 표시할 수 있습니다. */}
               <Test04Sub color={color} food={food} />
          </div>
     );
};

export default Test04;
