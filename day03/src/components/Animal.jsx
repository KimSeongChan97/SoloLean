import React from 'react';

// Animal 컴포넌트: 입력 필드를 제공하여 사용자가 동물의 이름을 입력할 수 있게 한다.
const Animal = ({ name, setName }) => {
    // const Animal = ({ name, onInputName }) => {
    return (
        <div>
            <h2>Animal Component</h2>
            {/* onChange에서 setName을 사용하여 입력 값으로 상태 변경 */}
            {/* 입력 필드의 값은 name 상태값과 동기화되어 있으며, 입력이 변경될 때마다 setName 함수를 통해 상태가 갱신된다. */}
            <input
                type='text'
                value={name}  // 입력 필드의 value 속성은 name 상태와 연결된다.
                onChange={(e) => setName(e.target.value)}  // 입력 필드에서 값이 변경될 때마다 setName 함수가 호출되어 name 상태를 업데이트한다.
                placeholder='입력 대기 칸'  // 사용자에게 입력할 공간을 안내하는 힌트를 제공하는 속성
               />
               <br/>
            {/* 선생님 답안 */}
            {/* <label>Teacher.동물의 이름을 입력해라</label>
            <input 
               type='text'
               value={ name }
               onChange={ onInputName }
               /> */}
            {/* 위 주석 처리된 코드는 대안적인 방식으로, onInputName이라는 이름으로 상태 업데이트 함수를 받는 방식이다. 
            setName과 동일한 역할을 하지만, 좀 더 명확하게 함수를 직접 넘겨줄 수 있다. */}
        </div>
    );
};

// 컴포넌트를 외부에서 사용할 수 있도록 export
export default Animal;

// 이 컴포넌트는 사용자가 입력한 동물 이름을 받기 위한 텍스트 입력 필드를 제공한다.
// 사용자가 입력을 변경할
