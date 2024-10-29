// Logout.jsx
import React from 'react';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Logout = ({ onLogout }) => {
  const navigate = useNavigate();

  useEffect(() => {
    onLogout(); // 로그아웃 함수 호출
    navigate('/'); // 로그아웃 후 메인 화면으로 이동
  }, [onLogout, navigate]);

  return null;
};

export default Logout;