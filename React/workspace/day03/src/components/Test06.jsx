import React, { useRef, useState } from 'react';

const Test06 = () => {

     // useRef를 사용하여 name 입력란에 대한 참조를 생성함
     // useRef는 DOM 요소에 직접 접근할 수 있게 해주며, 여기서는 'name' 입력 필드에 포커스를 맞출 때 사용
     const nameRef = useRef();

     // useState를 사용하여 상태(state)를 관리함
     // dto라는 객체 상태를 선언하고 초기 값으로 name, id, pwd 필드를 빈 문자열로 설정함
     // setDto 함수는 상태를 업데이트하는 함수임
     const [ dto, setDto ] = useState({
          name: '',  // name 필드의 상태를 관리
          id: '',    // id 필드의 상태를 관리
          pwd: ''    // pwd 필드의 상태를 관리
     });

     // 객체 분해 할당(destructuring)을 사용하여 dto 객체의 필드를 쉽게 가져옴
     const { name, id, pwd } = dto;
     // 1개의 set 형태로 잡아둠
     // const [name, setName] = useState();
     // const [id, setId] = useState();
     // const [pwd, setPwd] = useState();

     // onInput 함수는 입력값이 변경될 때 호출됨
     // e.target에서 입력 요소의 name과 value를 추출하여,
     // 해당 name에 맞는 값을 dto 상태에 업데이트 함
     const onInput = (e) => {
          const { name, value } = e.target; // event 객체에서 name과 value 값을 가져옴
          
          // 기존 dto 상태를 복사하고(e.g., ...dto),
          // name에 해당하는 필드의 값을 업데이트함
          // name은 입력 필드의 'name' 속성과 대응되며, 이는 상태 필드의 key와 일치함
          setDto({
               ...dto, // 기존 dto 객체의 복사본을 생성
               [name] : value // 해당 name 필드의 값을 변경
          });
     }; 

     // onReset 함수는 "초기화" 버튼을 클릭했을 때 호출됨
     // dto 객체의 모든 필드를 빈 문자열로 초기화하고, 
     // name 입력 필드에 포커스를 다시 맞춤
     const onReset = () => {
               setDto({
                    name: '', // name 값을 빈 문자열로 초기화
                    id: '',   // id 값을 빈 문자열로 초기화
                    pwd: ''   // pwd 값을 빈 문자열로 초기화
               });
               // name 입력 필드에 포커스를 맞추기 위해 ref 사용
               nameRef.current.focus();
     };

     return (
          <div>
               {/* 테이블을 생성하고, 각 필드에 대해 입력 창을 배치함 */}
               {/* border: 테이블에 경계를 주고, cellPadding으로 셀 내 여백을 지정 */}
               <table border={ 1 } cellPadding={ 5 } cellSpacing='0'>
                    {/* tbody 태그를 추가하여 DOM 구조를 맞춤 */}
                    <tbody>
                         <tr>
                              <th width='100'> 이름 </th>
                              {/* 이름 입력 필드, name 속성에 'name'을 주고, ref로 포커스 제어 */}
                              <td><input type='text' name='name' value={ name } onChange={ onInput } ref={ nameRef }/></td>
                         </tr>
                         <tr>
                              <th width='100'> 아이디 </th>
                              {/* 아이디 입력 필드, name 속성에 'id'를 주고, onChange 이벤트로 상태 업데이트 */}
                              <td><input type='text' name='id' value={ id } onChange={ onInput } /></td>
                         </tr>
                         <tr>
                              <th width='100'> 비밀번호 </th>
                              {/* 비밀번호 입력 필드, type을 'password'로 설정하여 입력 값이 숨김처리됨 */}
                              <td><input type='password' name='pwd' value={ pwd } onChange={ onInput } /></td>
                         </tr>
                         <tr>
                              {/* 버튼을 가운데 정렬하고, "초기화" 버튼을 클릭 시 onReset 함수 호출 */}
                              <td colSpan='2' align='center'>
                                   <button onClick={ onReset }>초기화</button>
                              </td>
                         </tr>
                    </tbody>
               </table>
          </div>
     );
};

export default Test06;


// const onInputName = (e) => {
//      const { value } = e.target;
//        setName(value);       
// };

// 기존에 별도로 관리하려던 name 필드를 위해서 onInputName 함수가 있지만,
// 현재는 setDto로 전체 상태(dto)를 관리하는 방식으로 코드를 변경함.
// onInputName 대신 onInput에서 name을 포함한 모든 필드를 처리함.
