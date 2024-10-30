import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import loginStyle from '../../css/loginForm.module.css';

const LoginForm = ({ setIsLoggedIn }) => {
  const [id, setId] = useState('');
  const [pwd, setPwd] = useState('');
  const [idDiv, setIdDiv] = useState('');
  const [pwdDiv, setPwdDiv] = useState('');
  const [result, setResult] = useState('');
  const navigate = useNavigate();

  const onLoginSubmit = (e) => {
    e.preventDefault();
    setIdDiv('');
    setPwdDiv('');
    setResult('');

    if (!id) { 
      setIdDiv(' 아이디를 입력하시오 !');
    } else if (!pwd) { 
      setPwdDiv(' 비밀번호를 입력하시오 !');
    } else { 
      axios.get(`http://localhost:8080/spring/member/login?id=${id}&pwd=${pwd}`, { withCredentials: true })
        .then(res => {
          if (res.data === 'success') {
            alert('로그인 성공!');
            setIsLoggedIn(true); // 로그인 상태 갱신
            navigate('/'); // 로그인 성공 시 메인 화면으로 이동
          } else {
            setResult('아이디 또는 비밀번호가 틀렸습니다');
          }
        })
        .catch(error => {
          console.error('로그인 중 오류 발생:', error);
          setResult('Spring 과의 연결이 올바르지 않음');
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
        <br/>
        <div id={loginStyle.result}>{result}</div>
      </form>
    </div>
  );
};

export default LoginForm;
