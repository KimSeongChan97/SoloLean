import axios from 'axios';
import React, { useState } from 'react';
import loginStyle from '../../css/loginForm.module.css';
import { useNavigate } from 'react-router-dom';

const LoginForm = () => {
  const [id, setId] = useState('');
  const [pwd, setPwd] = useState('');
  const [idDiv, setIdDiv] = useState('');
  const [pwdDiv, setPwdDiv] = useState('');
  const [loginResult, setLoginResult] = useState('');
  const navigate = useNavigate();

  const onLoginSubmit = (e) => {
    e.preventDefault();
    setIdDiv('');
    setPwdDiv('');
    setLoginResult('');

    if (!id) { 
      setIdDiv(' 아이디를 입력하시오 !');
    } else if (!pwd) { 
      setPwdDiv(' 비밀번호를 입력하시오 !');
    } else { 
      // 로그인 요청
      axios.get(`http://localhost:8080/spring/member/login?id=${id}&password=${pwd}`, {
        withCredentials: true // CORS 정책에 따른 쿠키 전달
      })
      .then(res => {
        if (res.data === 'success') {
          setLoginResult('로그인 성공');
          sessionStorage.setItem('userId', id); // 세션에 사용자 ID 저장
          navigate('/'); // 로그인 성공 시 메인 페이지로 이동
        } else {
          setLoginResult('아이디 또는 비밀번호가 틀렸습니다.');
        }
      })
      .catch(error => {
        console.error('로그인 요청 오류', error);
        setLoginResult('서버 요청 중 오류가 발생했습니다.');
      });
    }
  };

  return (
    <div className={loginStyle.loginform}>
      <h3>LOGIN</h3>
      <form>
        <table className={loginStyle.logintable}>
          <tbody>
            <tr>
              <th>아이디</th>
              <td>
                <input
                  type='text'
                  name='id'
                  value={id}
                  onChange={e => setId(e.target.value)}
                  placeholder="아이디를 입력하세요"
                />
                <div id={loginStyle.idDiv}>{idDiv}</div>
              </td>
            </tr>
            <tr>
              <th>비밀번호</th>
              <td>
                <input
                  type='password'
                  name='pwd'
                  value={pwd}
                  onChange={e => setPwd(e.target.value)}
                  placeholder="비밀번호를 입력하세요"
                />
                <div id={loginStyle.pwdDiv}>{pwdDiv}</div>
              </td>
            </tr>
            <tr>
              <td colSpan={2} align='center'>
                <button onClick={onLoginSubmit}>로그인</button>
              </td>
            </tr>
          </tbody>
        </table>
        <div>{loginResult}</div>
      </form>
    </div>
  );
};

export default LoginForm;
