// ChangeCount 컴포넌트: ChangeCountContext에서 제공하는 카운트 값과 카운트 변경 함수들을 사용하여 UI를 업데이트
// 이 컴포넌트는 카운트를 증가 또는 감소시키는 버튼들과 현재 카운트를 표시하는 역할을 함
import React, { useContext } from 'react';
import { ChangeCountContext } from '../contexts/ChangeCountContext';



// ChangeCount: 카운트를 증가 또는 감소시키기 위한 UI 컴포넌트
// 이 컴포넌트는 ChangeCountContext의 count 상태를 가져와 카운트 값을 실시간으로 표시함
const ChangeCount = () => {

    // useContext를 사용하여 ChangeCountContext에서 count, increment, decrement 함수를 가져옴
    // useContext 훅은 context의 값에 접근하도록 도와주며, 여기서는 count와 두 함수에 접근함
    const { count, increment, decrement } = useContext(ChangeCountContext);

    return (
        <div>
            {/* count 상태에 따라 카운트가 표시되며 값이 실시간으로 업데이트됨 */}
            {/* count 상태는 useContext를 통해 받아온 값으로 설정되며, 이 값이 변경되면 카운트가 화면에 업데이트됨 */}
            <h1> 카운트 : { count } </h1>
            <p>
                {/* 버튼 클릭 시 increment 또는 decrement 함수가 호출되어 카운트 증가/감소 */}
                {/* 각 버튼에는 클릭 이벤트가 연결되어 있으며, 버튼 클릭 시 각각의 함수가 호출되면서 전달된 숫자만큼 count 상태가 증가 또는 감소함 */}
                <button className="button"  onClick={ () => increment(10) }> 10 증가 </button> &nbsp;
                <button className="button"  onClick={ () => increment(50) }> 50 증가 </button> &nbsp;
                <button className="button"  onClick={ () => decrement(30) }> 30 감소 </button> &nbsp;
                <button className="button"  onClick={ () => decrement(40) }> 40 감소 </button> &nbsp;
            </p>
        </div>
    );
};

export default ChangeCount;
