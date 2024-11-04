import React, { useEffect, useState } from 'react';

const Time = () => {
  const [time, setTime] = useState(new Date().toLocaleTimeString());

  // 컴포넌트가 처음 렌더링 될 때 실행되는 useEffect 
  useEffect(() => {
    // 1초마다 시간을 업데이트하는 타이머를 설정
    const timer = setInterval(() => {
      setTime(new Date().toLocaleTimeString());
    }, 1000);
    // 컴포넌트가 언마운트 될 때 타이머를 정리해 줌
    return () => clearInterval(timer);
  }, []);

  return (
    <div style={{ textAlign: 'center', fontFamily: 'Orbitron'}}>
      <div>
        <h1 style={{ fontWeight: 'bold', fontSize: '2em' }}>
          {time}
          </h1>
      </div>
    </div>
  );
};

export default Time;
