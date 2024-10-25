import React from 'react';

const Test07Output = ({ dto }) => {
  return (
    <div>
      <h3><span>감사합니다!</span></h3>
      {/* 
      설문 조사가 완료되었을 때 보여지는 감사 메시지 화면.
      사용자가 입력한 이름을 포함하여 감사 메시지를 표시함.
      */}
      <p>{dto.name} 님, 설문조사에 참여해주셔서 감사합니다.</p>
      {/* dto.name 값을 이용해 사용자에게 개인화된 메시지를 출력 */}
    </div>
  );
};

export default Test07Output;
