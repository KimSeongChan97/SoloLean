import React, { useRef, useState } from 'react';
import '../css/test01.css';

const Test01 = () => {
     // useState 훅을 사용하여 'id'와 'pwd' 상태값을 선언함
     // 'id'는 아이디 입력 필드의 값, 'pwd'는 비밀번호 입력 필드의 값
     const [id, setId] = useState(''); // useState는 상태를 관리하기 위한 훅으로, 'id'의 초기값은 빈 문자열
     const [pwd, setPwd] = useState(''); // 'pwd'도 비밀번호 입력을 관리하는 상태이며, 초기값은 빈 문자열로 설정됨

     const idRef = useRef(); // useRef 훅을 사용하여 idRef 변수를 생성, 이는 특정 DOM 요소에 직접 접근하기 위함

     const onInputId = (e) => {
          // 비구조 할당
          // e.target : 이벤트 발생 대상
          console.log(e.target); // <input type='text' value='aa'>
          // 이벤트가 발생한 대상인 e.target에서 value 속성만 가져옴 (비구조 할당 사용)
          const { value } = e.target;
          setId(value); // setId 함수로 id 상태 값을 업데이트함, 즉 입력된 값을 id로 저장
     };

     const onInputPwd = (e) => {
          // 비구조 할당
          // e.target : 이벤트 발생 대상
          console.log(e.target); 
          const { value } = e.target; 
          setPwd(value); // setPwd 함수로 pwd 상태 값을 업데이트함, 즉 입력된 비밀번호 값을 저장
     };

     const onReset = () => {
          setId(''); // id 입력 필드를 빈 문자열로 초기화
          setPwd(''); // 비밀번호 입력 필드도 빈 문자열로 초기화

          // focus
          idRef.current.focus(); // id 입력 필드로 포커스를 이동함, Ref를 사용하여 DOM 요소에 직접 접근
     };

     return (
          <div>
               {/* 입력 필드에 id 상태 값을 반영하고, 값이 변경될 때 onInputId 함수 실행 */}
               아이디 <input type='text' name='id' value={ id } onChange={ onInputId } ref={ idRef }/>
               <br/><br/>
               {/* 비밀번호 입력 필드도 동일한 방식으로 pwd 상태 값을 관리하며 onInputPwd 함수로 상태 업데이트 */}
               비밀번호 <input type='password' name='pwd' value={ pwd } onChange={ onInputPwd }/>
               <br/><br/>
               {/* 비밀번호의 길이가 6자 미만이면 로그인 버튼 비활성화, 6자 이상일 때만 활성화 */}
               <button disabled={ pwd.length < 6 } >로그인</button>
               {/* 비밀번호의 개수가 6개를 이상이면 버튼을 활성화 */}

               {/* onReset 함수를 실행하여 입력된 값들을 초기화하고 포커스를 id 입력 필드로 이동 */}
               <button onClick={ onReset }>초기화</button>

          </div>
     );
};

export default Test01;


/*
Hooks - useRef
리액트에서 제공하는 대표적인 훅 중 하나이다.

JavaScript 를 사용 할 때에는, 우리가 특정 DOM 을 선택해야 하는 상황에 
getElementById, querySelector 같은 DOM Selector 함수를 사용해서 DOM 을 선택한다.
리액트에서는 직접 DOM 요소에 접근해야 할 때, useRef 훅을 사용하여 DOM 요소에 직접 접근이 가능하다.

useRef 훅이 반환하는 ref 객체를 이용해서 자식 요소에 접근이 가능하다.

input태그와 같이 사용자가 값을 직접 입력하는 html태그에 직접적으로 접근하여 값을 가져오는 것을 가능하게 한다.

리액트 컴포넌트는 State가 변할 때마다 다시 렌더링이 되면서 컴포넌트 내부 변수들이 초기화 된다.
하지만 Ref안에 있는 값은 아무리 변경해도 컴포넌트는 다시 렌더링 되지 않는다.
즉, State 대신 Ref를 사용한다면 불필요한 렌더링을 막을 수 있다.
또한 컴포넌트가 아무리 렌더링이 되어도 Ref안에 저장되어 있는 값은 변화되지 않고 그대로 유지 된다.
그래서 렌더링을 발생시키지 말아야 하는 값을 다룰 때 정말 편리하다.

Ref 객체를 만들어준다.
const nameRef = useRef();

선택하고 싶은 DOM에 속성으로 ref 값을 설정해준다.
<input  ref = { nameRef } />

Ref 객체의 current 값은 우리가 선택하고자 하는 DOM을 가리킨다.
그리고 포커싱을 해주는 DOM API focus()를 호출한다.
*/

/* 추가 주석
- useRef는 state와 달리 값이 변경되어도 리렌더링을 발생시키지 않기 때문에, 렌더링에 영향을 주지 않으면서 특정 DOM에 접근해야 할 때 적합하다.
- 이 코드에서는 id 입력 필드에 포커스를 맞추기 위해 useRef를 사용함. 초기 렌더링 시에는 리액트가 DOM에 접근할 수 없기 때문에, useRef로 ref 객체를 생성하고 이를 input 태그의 ref 속성에 전달함.
- current 속성은 실제 DOM 요소를 가리키며, 그 값으로 focus 메서드를 호출하여 입력 필드에 포커스를 맞출 수 있음.
*/
