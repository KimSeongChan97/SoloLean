import React, { useRef, useState } from 'react';
import '../css/Test10.css';

const Test10 = () => {
     // nameRef는 input 필드에 포커스를 주기 위해 사용됩니다.
     // 참조 객체는 실제 DOM 요소에 직접 접근할 수 있게 해줍니다.
     const nameRef = useRef(); // 참초 추가

     // seq는 각 항목에 고유한 번호(시퀀스)를 부여하기 위해 사용됩니다.
     // useRef를 사용하면 상태처럼 값이 기억되지만, 값이 변경되어도 컴포넌트가 다시 렌더링되지 않습니다.
     const seq = useRef(1); // 1 2 3 4 5 6 7 ....


     // dto 상태는 name과 age라는 두 개의 속성을 가진 객체로 초기화합니다.
     // 이 객체는 사용자가 입력한 이름과 나이 값을 저장하기 위한 상태입니다.
     const [ dto, setDto ] = useState({ // 1인분
          name: '',  // name은 사용자가 입력하는 이름을 저장하는 역할
          age: ''    // age는 사용자가 입력하는 나이를 저장하는 역할
     });
     
     // 구조 분해 할당을 통해 dto 객체에서 name과 age를 바로 사용할 수 있게 합니다.
     const { name, age } = dto; // , addr, phone
     // 위 코드는 addr과 phone 같은 추가적인 속성도 있을 수 있음을 암시합니다.
     // 여기서는 name과 age만 사용하고 있지만, 더 많은 필드를 사용할 수 있도록 확장할 수 있습니다.

     // list 상태는 사용자가 입력한 이름과 나이를 저장하는 객체들의 배열을 관리합니다.
     // 이 배열은 나중에 화면에 목록 형태로 출력됩니다.
     const [ list, setList ] = useState([]);

     // onInput 함수는 사용자가 입력한 값을 실시간으로 dto 상태에 반영합니다.
     const onInput = (e) => {
          console.log(e.target)  // 사용자가 입력한 input 요소가 출력됩니다.
          
          // e.target은 input 요소를 나타내며, 여기서 name과 value 값을 추출합니다.
          // name 속성은 input 요소의 name 속성 값을 의미하고, value는 입력된 실제 값입니다.
          const { name, value } = e.target; // <input type="" name="" value="" />
          
          // 이전 dto 상태를 복사한 후, 변경된 input 값만 업데이트합니다.
          // 이를 통해 다른 필드 값이 유지되면서 새로운 값만 변경됩니다.
          setDto({
                    ...dto,   // 기존 dto 객체의 값들을 복사해서 유지
                    [ name ] : value  // name 속성에 해당하는 값을 업데이트
          });
     };

     // onAdd 함수는 폼이 제출될 때 호출되며, 새로운 항목을 리스트에 추가합니다.
     const onAdd = (e) => {
          e.preventDefault(); // 브라우저의 기본 동작(페이지 새로고침)을 막기 위한 코드
          // 폼이 제출될 때 페이지가 새로고침 되는 것을 방지합니다.

          // name 또는 age 값이 비어 있으면 함수를 종료하여 항목을 추가하지 않습니다.
          // 필수 입력 값이 없을 경우 빈 항목이 추가되지 않도록 방어 로직입니다.
          if (!name || !age) return;

          // 현재의 dto 객체(name과 age를 포함한)를 리스트에 추가합니다.
          // ...list는 기존 리스트 배열의 내용을 유지하고,
          // { name, age }는 dto 객체에서 구조 분해 할당된 name과 age 값을 사용하여 
          // 새로운 객체를 리스트에 추가합니다.
          setList([
               ...list,  // 기존 배열의 항목을 유지하면서
               {
                    // 각 항목에 고유한 seq(시퀀스) 값을 부여합니다.
                    // seq.current++로 시퀀스 값을 증가시키면서 각 항목마다 고유 번호가 생성됩니다.
                    seq: seq.current++,
                    name,  // 기존 dto에서 구조 분해된 name 값을 추가
                    age    // 기존 dto에서 구조 분해된 age 값을 추가
               }
               // { ...dto } 도 가능
          ]);
          
          // 항목이 추가된 후 입력 필드를 비워서 초기화합니다.
          // setDto를 통해 name과 age를 다시 빈 문자열로 초기화하여
          // 사용자가 새로운 값을 입력할 수 있도록 합니다.
          setDto(
               { 
               name: '',
               age: '' 
          });

          // 입력 필드를 초기화한 후, name 입력 필드에 포커스를 줍니다.
          // nameRef.current.focus()를 호출하여 이름 입력 필드로 포커스를 이동시킵니다.
          nameRef.current.focus(); // 포커스 추가

     };
     

     return (
          <div>
               <form onSubmit={ onAdd } >
                    이름 : <input type='text' name='name' value={ name } onChange={ onInput } ref={ nameRef } />
                    {/* input 요소의 value는 dto 상태의 name 값과 동기화됩니다.
                        사용자가 입력할 때마다 onInput 함수가 호출되어 상태가 업데이트 됩니다. */}
                    {/* ref={ nameRef }를 추가하여, 이 input 필드를 nameRef로 참조할 수 있습니다. */}
                    <br/>
                    나이 : <input type='text' name='age' value={ age } onChange={ onInput } />
                    {/* 나이 input 역시 dto 상태의 age 값과 동기화되어 입력 값이 반영됩니다. */}
                    <br/>
                    <button type='submit'>추가</button>
                    {/* 버튼을 클릭하면 폼이 제출되고 onAdd 함수가 호출됩니다. */}
               </form>
               <hr/>
               <ul>
                    {
                         // list 배열의 각 항목을 map 함수를 사용해 li 요소로 렌더링합니다.
                         // index 값을 키로 사용하여 리스트 항목을 구분합니다.
                         // key 값을 seq 로 해도 가능하다.
                         list.map((item, index) => <li key={ index }>
                                  { item.seq } / { item.name } / { item.age } </li>
                                   )
                    }
               </ul>
               {/* 리스트에 추가된 항목들이 ul 안에서 이름과 나이 형식으로 출력됩니다. */}
          </div>
     );
};

export default Test10;
