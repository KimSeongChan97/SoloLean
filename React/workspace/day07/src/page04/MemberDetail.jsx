import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

// MemberDetail 컴포넌트는 개별 회원의 상세 정보를 보여주는 컴포넌트입니다.
const MemberDetail = () => {
     
     // useParams 훅을 사용하여 URL 경로에서 memberId 파라미터를 추출합니다.
     const { memberId } = useParams();

     // 개별 회원 정보를 저장할 memberDTO 상태 변수
     const [ memberDTO, setMemberDTO ] = useState({});

     // 구조 분해 할당을 통해 name, email, phone, website 속성을 추출하여 표시할 수 있도록 합니다.
     const { name, email, phone, website } = memberDTO; 

     // 페이지 이동을 위해 useNavigate 훅 사용
     const navigate = useNavigate();

     // css 스타일 설정 객체
     const css = {
          border: '1px solid red', 
          margin: 20,
          padding: '20px'
      };

     useEffect(() => {
          // axios를 통해 특정 회원의 상세 정보를 가져오고, memberDTO 상태에 저장합니다.
          axios.get(`https://koreanjson.com/users/${memberId}`)
               .then(res => setMemberDTO(res.data))
     }, []); // 1사람의 데이터를 가져옴

     // onBack 함수는 이전 페이지 또는 메인 페이지로 돌아가도록 합니다.
     const onBack = () => {
          //navigate(-1);
          navigate('/');
     };

     return (
          <div style={ css }>
               {/* 회원 ID와 이름 등 상세 정보를 화면에 표시 */}
               <h2> MemberDetail Page : { memberId } </h2>
               <h4> 이름 : { name } </h4>
               <ul style={{ listStyleType: 'none' }}>
                    <li> 이메일 : { email } </li>
                    <li> 핸드폰 : { phone } </li>
                    <li> 웹사이트 : { website } </li>
               </ul>
               {/* 뒤로가기 버튼을 클릭하면 onBack 함수가 실행되어 navigate를 통해 메인 페이지로 이동 */}
               <button onClick={ onBack } > 뒤로가기 </button>
          </div>
     );
};

export default MemberDetail;
