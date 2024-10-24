import React, { useState } from 'react';

const dataList = [
     { id: 1, name: 'chk1', text: '연령(만 14세 이상) 확인(필수)', isChk: false },
     { id: 2, name: 'chk2', text: '개인정보 위탁 처리 동의(필수)', isChk: false },
     { id: 3, name: 'chk3', text: '개인정보 수집 및 이용에 대한 동의(필수)', isChk: false },
     { id: 4, name: 'chk4', text: '이벤트, 우대 혜택 동의 안내(선택)', isChk: false }
]; 
// 전역변수는 바깥에도 설정 가능하다.
// 이 전역 변수는 약관 항목의 초기 데이터를 정의하며, 상태 관리를 위해 컴포넌트 내부에서 사용됩니다.
// dataList는 전체 약관의 초기 상태를 정의하는 배열입니다. 각 항목에는 id, name, text, isChk(체크 여부)가 포함되어 있습니다.
// isChk는 체크 여부를 나타내며 초기값은 모두 false로 설정되어 있습니다.
// -> 여기서 전역변수로 선언된 dataList는 여러 개의 약관을 표현하는 객체들의 배열입니다. 
// 각 객체는 체크박스 항목 하나를 나타내며, isChk 속성은 해당 항목의 선택 여부를 관리하는데 사용됩니다.
// -> React에서 상태 관리를 위해 기본적으로 컴포넌트 내부에서 상태를 선언하지만, 초기 데이터는 컴포넌트 외부에서 설정할 수도 있습니다.
// 이는 여러 컴포넌트에서 동일한 데이터를 사용하거나 유지할 필요가 있을 때 유용합니다.

const Test11 = () => {

     const [ list, setList ] = useState(dataList); 
     // 상태변수로 변경하여 isChk 값 변경에 사용하게 함
     // dataList를 상태로 관리하여 사용자가 체크박스를 클릭할 때 상태가 변경되도록 합니다.
     // list는 체크박스 상태를 저장하는 배열이고, setList는 이 상태를 업데이트하는 함수입니다.
     // useState를 사용하여 list라는 상태 변수에 dataList를 할당합니다. 초기값은 dataList이며, setList는 list의 상태를 변경하는 함수입니다.
     // 이 상태는 컴포넌트가 렌더링될 때마다 유지되며, setList를 통해 상태를 업데이트할 수 있습니다.
     // -> useState 훅은 React에서 컴포넌트가 동적으로 변경되는 데이터를 관리하는 방법입니다. 
     // 처음엔 dataList를 초기값으로 설정하고, 사용자의 상호작용에 따라 상태가 변할 때마다 이 데이터를 업데이트합니다.
     // -> useState를 사용하면 상태가 변경될 때마다 컴포넌트가 재렌더링됩니다. 
     // 이를 통해 UI는 데이터와 상태가 동기화된 모습을 유지할 수 있습니다.

     const onChk = (e) => {
          // name, checked 값에 따라 어느 위치에서 onChk 가 되었는지 를 파악해야 함
          // e.target을 통해 체크박스의 name과 checked 값을 추출합니다.
          // name은 어떤 체크박스가 클릭되었는지를 식별하고, checked는 체크 여부를 나타냅니다.
          const { name, checked } = e.target;
          // e.target에서 name과 checked 값을 추출하여 특정 체크박스가 선택되었는지 여부를 파악합니다.
          // name은 체크박스의 고유 식별자이며, checked는 체크 여부를 나타내는 불리언 값입니다.
          // -> e.target은 사용자가 상호작용한 HTML 요소를 가리킵니다. 여기서는 체크박스를 의미하며, 
          // name 속성은 어떤 체크박스가 클릭되었는지를 식별하고, checked는 그 체크박스의 선택 여부를 나타냅니다.
          // -> e.target에서 가져온 값은 이벤트 핸들러에서 사용됩니다. checked는 boolean 값으로 true 또는 false로 나타내며, 
          // 사용자가 해당 체크박스를 선택했는지 아닌지에 대한 정보를 제공합니다.

               if( name === 'all' ) {
                    // setList 을 map 으로 돌리면서 현재 값 isChk 를 'checked' 로 변경(true)
                    // 모든 항목의 isChk 값을 checked 로 변경
                    // '약관동의' 체크박스가 클릭된 경우, 모든 개별 항목의 체크 상태를 'checked'로 변경합니다.
                    setList( list.map(item => ({ 
                                                  ...item, 
                                                  isChk: checked }
                    )));    
                    // list.map()을 사용하여 리스트의 모든 항목을 순회하며, 각 항목의 isChk 값을 checked 값으로 업데이트합니다.
                    // ...item은 기존 항목의 값을 복사하고, isChk만 업데이트하여 새로운 객체를 반환합니다.
                    // 즉, '약관동의' 체크박스를 클릭하면 전체 항목이 한 번에 선택되거나 해제됩니다.
                    // 모든 항목을 업데이트하려면 setList를 호출하여 새로운 배열을 상태로 설정합니다.
                    // -> 이 부분은 '약관동의'라는 전체 선택 체크박스를 클릭했을 때 실행됩니다. 
                    // map 함수로 list의 각 항목을 순회하면서 모든 isChk 값을 true 또는 false로 업데이트합니다.
                    // -> spread operator(...item)를 사용하여 객체의 기존 속성을 유지한 채, isChk만 변경하고 새로운 객체를 반환합니다.
                    
               } else {
                    // setList 을 map 을 돌리면서 선택한 name ( chk 값 ) 과 같은 값을 찾아서 isChk 를 변경
                    // 개별 항목의 isChk 값을 변경
                    // 특정 항목이 클릭되었을 때, 해당 항목의 isChk 값을 체크 상태에 맞게 업데이트합니다.
                    setList( list.map(item => item.name === name ? { ...item, isChk: checked } : item));
                    // item.name이 클릭된 name과 일치하는 항목만 isChk 값을 변경하고, 나머지 항목은 그대로 유지합니다.
                    // { ...item, isChk: checked } 은 checked 가 된 item 이고, 일반적인 item 은 checked 가 false 인 값이다.
                    // 따라서 name 값에 따라 조건을 걸어 참이면 { ...item, isChk: checked } 인 item(true) 와 item(false) 를 비교하는 것.
                    // 클릭된 체크박스의 이름과 일치하는 항목만 업데이트하고, 그렇지 않은 항목은 변경하지 않기 위해 삼항 연산자를 사용합니다.
                    // ...item은 기존의 항목 속성을 유지하면서 isChk만 변경합니다.
                    // -> 여기서는 특정 항목이 클릭되었을 때 실행됩니다. 선택된 체크박스의 name과 일치하는 항목의 isChk 값을 
                    // checked 상태로 업데이트합니다. name이 일치하지 않는 항목들은 그대로 유지됩니다.
                    // -> React에서 상태를 업데이트할 때는 상태가 불변성을 유지해야 하기 때문에, 기존 객체를 직접 수정하지 않고
                    // 새로운 객체를 반환해야 합니다. spread operator를 사용하여 기존 속성을 유지하면서 필요한 속성만 변경하는 방식을 취합니다.
               }
     };

     return (
          <div>
               <p>
                    {/* 
                    <input type='checkbox' name='all' onChange={ onChk } 
                         checked={ list.filter(item => item.isChk !== true ).length < 1 } />
                         // '약관동의' 체크박스입니다. name='all'로 설정되어 전체 선택 또는 해제 기능을 담당합니다.
                        // onChange 이벤트를 통해 체크 상태가 변경될 때 onChk 함수가 호출됩니다.(비추천) */}
                    {/*
                    <input type='checkbox' name='all' onChange={ onChk } 
                         checked={ list.filter(item => item.isChk ).length === list.length } /> 
                    */}
                    {/* 
                         filter 함수를 사용해 리스트에서 isChk가 false인 항목이 하나라도 있는지 확인합니다.
                         모든 항목이 선택되어 있으면 '약관동의' 체크박스도 체크된 상태로 표시됩니다. 
                         checked 속성은 list에서 isChk가 false인 항목이 하나도 없을 경우 전체가 체크되도록 설정합니다.
                         */}

                     <input type='checkbox' name='all' onChange={ onChk } 
                         checked={list.every(item => item.isChk)} />          
                    {/* '약관동의' 체크박스는 모든 약관을 한 번에 선택하거나 해제할 수 있는 기능을 제공합니다. */}
                    {/* checked 속성은 list에서 isChk가 false인 항목이 하나도 없을 경우 전체가 체크되도록 설정합니다. */}
                    {/* -> every 함수는 배열의 모든 요소가 조건을 만족할 때 true를 반환합니다. 이 경우 모든 항목의 isChk가 true일 때만 전체 선택이 체크됩니다. */}

                    <label style={{ fontSize: '25px' }}>약관동의</label>
               </p>
               <hr/>
               {
                    // dataList.map()
                    // 각 약관 항목을 map() 함수를 사용해 렌더링합니다.
                    // list 배열을 순회하면서 각 항목에 대해 <input>과 <label>을 렌더링합니다.
                    list.map( item => <p key={ item.id }> 
                                   <input type='checkbox' name={ item.name } checked={ item.isChk } onChange={ onChk } />
                                   {/* 개별 체크박스입니다. name은 item.name이며, checked는 item.isChk 값을 사용해 체크 상태를 동기화합니다.
                                       사용자가 체크박스를 클릭하면 onChk 함수가 호출되어 상태가 변경됩니다. */}
                                   {/* name 속성은 각 체크박스를 고유하게 식별할 수 있도록 하고, checked 속성은 현재 체크 상태를 동기화합니다. */}
                                   {/* -> 각 항목의 name 속성은 onChk 이벤트 핸들러에서 특정 항목을 식별하기 위해 사용됩니다. 
                                   개별 항목마다 isChk 값을 checked 속성으로 설정하여 해당 항목이 선택되었는지 여부를 관리합니다. */}
                                   <label style={{ fontFamily: 'Orbitron', fontSize: '25px' }}> { item.text } </label>
                                   {/* label은 체크박스와 관련된 설명을 나타냅니다. item.text 값을 출력하여 각 항목의 설명을 보여줍니다. */}
                                   {/* 스타일링을 통해 label의 글꼴과 크기를 설정하여 UI의 가독성을 높입니다. */}
                              </p>)
               }
          </div>
     );
};

export default Test11;
