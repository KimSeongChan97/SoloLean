import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

// Member 컴포넌트는 개별 회원 정보를 렌더링하는 컴포넌트로, props로 회원 정보를 전달받습니다.
const Member = ({ item }) => {
    // 회원 객체에서 id, name, email 속성을 추출하여 사용합니다.
    const { id, name, email } = item;

    // 스타일 설정을 위한 css 객체입니다.
    const css = {
        border: '1px solid red', 
        margin: 20,
        padding: '20px'
    };

    // useNavigate 훅을 통해 다른 페이지로 이동할 수 있는 navigate 함수를 가져옵니다.
    const navigate = useNavigate();

    // onGo 함수는 버튼 클릭 시 '/member/:id' 경로로 이동하는 함수입니다.
    const onGo = () => {
          navigate(`/member/${id}`);
    };

    return (
        <div style={css}>
            {/* 회원 ID, 이름, 이메일을 각각 화면에 표시 */}
            <p> 아이디 : {id} </p>
            <h4> 이름 : {name} </h4>
            <h4> 이메일 : {email } </h4>
            
            <p>
                {/* Link 컴포넌트를 사용하여 URL을 통해 상세보기 페이지로 이동 가능 */}
                <Link to={`/member/${id}`}> 상세보기 </Link>
            </p>
            {/* 버튼을 클릭하면 onGo 함수가 실행되어 navigate를 통해 상세 페이지로 이동 */}
            <button onClick={ onGo }> 상세보기 </button>
        </div>
    );
};

export default Member;
