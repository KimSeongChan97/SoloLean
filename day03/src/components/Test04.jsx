import React, { useState } from 'react';  // React에서 useState 훅을 불러와 상태 관리를 위해 사용
import Animal from './Animal';  // Animal 컴포넌트를 불러옴
import Display from './Display';  // Display 컴포넌트를 불러옴

// Test04 컴포넌트: 전체적인 로직을 관리하는 부모 컴포넌트
const Test04 = () => {
    const [name, setName] = useState('');  // 상태변수 name과 이를 갱신하는 함수 setName을 선언. 기본값은 빈 문자열로 설정.

    // 상태변수 와 상태변수의 값을 변경시키는 함수는 항상 같이 있어야 한다.
    // 이 함수는 사용자가 입력 필드에 값을 입력할 때마다 호출되어 name 상태를 업데이트함.
    const onInputName = (e) => {
     const { value } = e.target;  // 입력 필드의 변경된 값을 가져옴
     setName(value);  // 상태를 변경하여 입력된 값을 name 상태 변수에 저장
    };
    
    return (
        <div>
            {/* Animal 컴포넌트에 상태값(name)과 상태 변경 함수(setName)를 props로 전달 */}
            {/* Animal 컴포넌트는 입력 필드를 제공하고, 입력값을 변경할 때마다 setName을 호출하여 name 상태를 갱신 */}
            <Animal name={name} setName={setName} onInputName={onInputName} />
            
            {/* Display 컴포넌트에 상태값(name)만 props로 전달 */}
            {/* Display 컴포넌트는 name 상태값을 받아 이를 화면에 출력 */}
            <Display name={name} />
        </div>
    );
};

// 컴포넌트를 외부에서 사용할 수 있도록 export
export default Test04;

// Test04 컴포넌트는 부모 컴포넌트로서 Animal 컴포넌트와 Display 컴포넌트를 모두 포함하고 있다.
// Animal 컴포넌트는 사용자 입력을 받는 역할을 하고, Display 컴포넌트는 그 입력값을 화면에 보여주는 역할을 한다.
// 상태 관리는 useState 훅을 통해 수행되며, 상태를 변경하는 함수와 상태값은 props로 자식 컴포넌트에 전달된다.
