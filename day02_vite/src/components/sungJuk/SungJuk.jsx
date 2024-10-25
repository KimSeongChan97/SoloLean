import React, { useState } from 'react';
import '../../css/sungjuk.css';
import SungJukItem from './SungJukItem';  // 성적 항목 컴포넌트 불러오기
import SungJukData from './SungJukData';  // 성적 데이터 컴포넌트 불러오기

// 테이블 형식으로 출력, 예시 5명, 계산은 DTO 에서 실행한 값을 가지고 옴
// 이 컴포넌트는 성적 리스트를 테이블 형식으로 출력하는 역할을 합니다.
// 성적 데이터(SungJukData)를 받아와서 테이블에 표시하고, 각 항목은 SungJukItem 컴포넌트가 담당합니다.
const SungJuk = () => {
    // useState를 사용하여 SungJukData를 상태로 설정
    // useState는 상태를 관리하는 훅(Hook)입니다.
    // data는 상태 값이고, setData는 그 값을 변경하는 함수입니다.
    const [data, setData] = useState(SungJukData);

    // JSX 반환: 전체 UI 구조를 정의
    // <div> 태그로 페이지의 주요 콘텐츠를 감싸고, 테이블 형식으로 성적을 출력합니다.
    return (
        <div className='app-container'>
            {/* 페이지 제목 */}
            <h1>성적 관리 시스템 구현을 학습 해보자!</h1>
            <div className='sungjuk-container'>
                {/* 성적 리스트 제목 */}
                <h2>성적 리스트</h2>
                {/* 테이블 시작: 성적 항목을 테이블 형식으로 출력 */}
                <table className='sungjuk-table'>
                    <thead>
                        {/* 테이블 헤더 부분: 번호, 이름, 국어, 영어, 수학, 총점, 평균 */}
                        <tr>
                            <th>번호</th>
                            <th>이름</th>
                            <th>국어</th>
                            <th>영어</th>
                            <th>수학</th>
                            <th>총점</th>
                            <th>평균</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/* data 배열을 map 함수로 순회하면서 각 항목을 SungJukItem 컴포넌트로 전달 */}
                        {/* map 함수는 배열의 각 요소에 대해 반복을 수행하며, JSX 요소를 반환합니다. */}
                        {data.map((item, index) => (
                            <SungJukItem key={index} item={item} />
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default SungJuk;
