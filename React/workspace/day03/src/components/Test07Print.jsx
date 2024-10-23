import React from 'react';

const Test07Print = ({ dto, onPrev, onNext }) => {
  return (
    <div>
      <h3><span>입력 확인</span></h3>
      {/* 
      입력된 설문 데이터를 확인할 수 있는 화면을 보여줌.
      부모 컴포넌트에서 전달된 dto 값을 표시함.
      */}
      <ul>
        <li><span>이름:</span> <em>{dto.name}</em></li>
        {/* dto.name 값을 화면에 표시 */}
        <li><span>나이:</span> <em>{dto.age}</em></li>
        {/* dto.age 값을 화면에 표시 */}
        <li><span>주소:</span> <em>{dto.addr}</em></li>
        {/* dto.addr 값을 화면에 표시 */}
        <li><span>핸드폰:</span> <em>{dto.phone}</em></li>
        {/* dto.phone 값을 화면에 표시 */}
      </ul>
      
      <p>
        <button onClick={onPrev}>이전</button>
        {/* 
        '이전' 버튼을 클릭하면 onPrev 함수가 호출되어 설문 페이지가 이전 단계로 돌아감.
        이 함수는 부모 컴포넌트인 Test07Main에서 정의됨.
        */}
        <button onClick={onNext}>다음</button>
        {/* 
        '다음' 버튼을 클릭하면 onNext 함수가 호출되어 설문 페이지가 다음 단계로 넘어감.
        */}
      </p>
    </div>
  );
};

export default Test07Print;
