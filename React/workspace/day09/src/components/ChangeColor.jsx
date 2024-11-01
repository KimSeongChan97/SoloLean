// ChangeColor 컴포넌트: ChangeColorContext에서 제공하는 색상 값과 색상 변경 함수(onColor)를 사용하여 UI 업데이트
// 이 컴포넌트는 색상을 변경하는 버튼들과 현재 색상으로 텍스트를 표시하는 역할을 함
import React, { useContext } from 'react';
import { ChangeColorContext } from '../contexts/ChangeColorContext';



// ChangeColor: 글자의 색상 변경을 위한 UI 컴포넌트
// 이 컴포넌트는 ChangeColorContext의 color 상태값을 가져와 글자의 색상을 실시간으로 변경함
const ChangeColor = () => {

    // useContext를 사용하여 ChangeColorContext에서 color와 onColor를 가져옴
    // useContext 훅은 context의 값에 접근하도록 도와주며, 여기서는 color와 onColor 함수에 접근함
    const { color, onColor } = useContext(ChangeColorContext);

    return (
        <div>
            {/* color 상태에 따라 글자 색상이 변하도록 스타일 적용 */}
            {/* color 상태는 useContext를 통해 받아온 색상 값으로 설정되며, 이 값이 변경되면 글자 색상도 변경됨 */}
            <h1 style={{ color: color }}> 글자의 색상 변경 { color } </h1>
            <p>
                {/* 버튼 클릭 시 onColor 함수를 호출하여 색상 상태 변경 */}
                {/* 각 버튼에는 클릭 이벤트가 연결되어 있으며, 버튼 클릭 시 onColor 함수가 호출되면서 해당 버튼의 색상으로 color 상태가 업데이트됨 */}
                <button className="button"  onClick={ () => onColor('hotpink') }>hotpink</button> &nbsp;
                <button className="button"  onClick={ () => onColor('skyblue') }>skyblue</button> &nbsp;
                <button className="button"  onClick={ () => onColor('pink') }>pink</button> &nbsp;
                <button className="button"  onClick={ () => onColor('tomato') }>tomato</button> &nbsp;
                <button className="button"  onClick={ () => onColor('lime') }>lime</button> &nbsp;
            </p>
        </div>
    );
};

export default ChangeColor;
