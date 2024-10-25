import React from 'react';

const SungJukDTO = ({ seq, name, kor, eng, math }) => {
    // 총점 계산
    // 국어, 영어, 수학 점수를 더해 총점을 계산합니다.
    const tot = kor + eng + math;
    
    // 평균 계산
    // 총점을 3으로 나누어 평균을 계산하고, 소수점 둘째 자리까지 표시합니다.
    const avg = (tot / 3).toFixed(2);

    // 성적 데이터를 담은 객체를 반환
    // 여기서 반환된 값은 SungJukItem에서 사용됩니다.
    return { seq, name, kor, eng, math, tot, avg };
};

export default SungJukDTO;
