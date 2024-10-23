import React from 'react';
import SungJukDTO from './SungJukDTO';

const SungJukItem = ({ item }) => {
    // DTO를 통해 총점과 평균을 계산하여 반환받음
    // SungJukDTO는 item 객체(성적 데이터를 담은 객체)를 받아 총점(tot)과 평균(avg)을 계산합니다.
    const { seq, name, kor, eng, math, tot, avg } = SungJukDTO(item);

    // 테이블의 각 행에 성적 데이터를 표시
    return (
        <tr className='sungjuk-item'>
            {/* 성적 데이터 출력: 번호, 이름, 국어, 영어, 수학, 총점, 평균 */}
            <td>{seq}</td>
            <td>{name}</td>
            <td>{kor}</td>
            <td>{eng}</td>
            <td>{math}</td>
            <td>{tot}</td>
            <td>{avg}</td>
        </tr>
    );
};

export default SungJukItem;
