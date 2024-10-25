import React from 'react';

const Test07Input = ({ dto, onChange, onNext }) => {
  return (
    <div>
      <h3><span>설문조사 입력</span></h3>
      {/* 
      설문조사 입력 화면을 보여주는 컴포넌트.
      각 입력 필드는 name 속성에 해당하는 dto 필드와 연결되어 있으며,
      사용자가 입력할 때마다 onChange 함수가 호출되어 입력된 값이 dto 상태에 반영됨.
      */}
      <p><label>이름:</label> <input type="text" name="name" value={dto.name} onChange={onChange} /></p>
      {/* name 필드 입력: 입력된 값이 dto.name에 저장됨 */}
      
      <p><label>나이:</label> <input type="text" name="age" value={dto.age} onChange={onChange} /></p>
      {/* age 필드 입력: 입력된 값이 dto.age에 저장됨 */}
      
      <p><label>주소:</label> <input type="text" name="addr" value={dto.addr} onChange={onChange} /></p>
      {/* addr 필드 입력: 입력된 값이 dto.addr에 저장됨 */}
      
      <p><label>핸드폰:</label> <input type="text" name="phone" value={dto.phone} onChange={onChange} /></p>
      {/* phone 필드 입력: 입력된 값이 dto.phone에 저장됨 */}
      
      <p><button onClick={onNext}>다음</button></p>
      {/* 
      '다음' 버튼을 클릭하면 onNext 함수가 호출되어 설문 페이지가 다음 단계로 넘어감.
      이 함수는 부모 컴포넌트인 Test07Main에서 정의됨.
      */}
    </div>
  );
};

export default Test07Input;
