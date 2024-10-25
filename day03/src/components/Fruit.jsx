import React from 'react';

const Fruit = ({ fruit, onChange }) => {
    return (
        <div>
            <h3>
            {/* label 태그로 '과일명 입력'이라는 텍스트를 화면에 출력 */}
            <label>과일명 입력: </label>

            {/* 텍스트 입력 필드 생성 */}
            {/* 입력 필드의 value 속성은 fruit 상태 값을 보여줍니다 */}
            {/* onChange 속성은 사용자가 입력할 때마다 발생하는 이벤트를 처리하여 상태 값을 변경합니다 */}
            <input 
                type="text"         // 입력 타입은 텍스트입니다.
                value={fruit}       // 현재 fruit 상태값을 입력 필드에 표시
                onChange={ onChange } // 입력이 변경될 때 FruitChange 함수가 호출됨
                placeholder="좋아하는 과일을 입력하세요"  // 입력 필드에 보여지는 안내 문구
            />
            </h3>
        </div>
    );
};

export default Fruit;
