import React, { useState, useRef, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import styles from '../css/BoardInput.module.css';

const BoardInput = () => {
  const [boardDTO, setBoardDTO] = useState({
    name: '',
    subject: '',
    content: ''
  });
  const { name, subject, content } = boardDTO;

  const [nameDiv, setNameDiv] = useState('');
  const [subjectDiv, setSubjectDiv] = useState('');
  const [contentDiv, setContentDiv] = useState('');

  const navigate = useNavigate(); 

// localStorage에서 'seq'라는 키의 값을 가져와 정수로 변환하여 초기 seq 값으로 설정하는 코드입니다.
// localStorage.getItem('seq')는 'seq'라는 이름으로 저장된 값을 가져오는 메서드입니다.
// localStorage는 브라우저에 데이터를 영구적으로 저장하는 공간으로, 페이지를 새로고침해도 값이 유지됩니다.
// 예를 들어, 이전에 게시글을 등록하면서 증가된 seq 값이 저장되어 있다면 그 값을 가져와 다음 seq 값으로 사용할 수 있습니다.
// 만약 localStorage에 'seq' 값이 없으면(null인 경우), 기본값 '1'을 사용하도록 설정합니다.
// 상세 설명:
// - localStorage.getItem('seq'): 'seq'라는 키에 저장된 값을 가져옵니다. 값이 없으면 null을 반환합니다.
// - '||' 연산자: 논리 OR 연산자로, 앞의 값이 null, undefined, 빈 문자열 등이면 뒤의 값을 반환합니다.
//   이 코드에서는 localStorage에 값이 없을 때 '1'을 반환합니다. 즉, 처음으로 게시글을 작성할 때 seq 값을 1로 시작하게 됩니다.
// - parseInt(..., 10): 문자열을 10진수 정수로 변환하는 함수입니다.
//   localStorage에 저장된 값은 문자열 형식이기 때문에, parseInt를 사용하여 정수로 변환합니다.
//   두 번째 인수로 10을 지정하여, 이 값이 10진수임을 명시적으로 알려줍니다 (기본값도 10진수이지만 명확성을 위해 추가했습니다).
// 결과:
// - 이 코드의 결과로 initialSeq에는 localStorage에 저장된 'seq' 값(정수로 변환됨)이 저장되며,
//   만약 'seq' 값이 없으면 기본값인 1이 저장됩니다.
// - 이후 이 값을 useRef에 할당하여, 컴포넌트가 새로 렌더링되더라도 이 초기 seq 값이 유지됩니다.
  const initialSeq = parseInt(localStorage.getItem('seq') || '1', 10);
  const seqRef = useRef(initialSeq); // seq 값을 useRef로 관리
  // useRef는 리렌더링이 일어나도 값이 초기화되지 않으며, 렌더링 간의 값 유지에 적합한 방식입니다.

  // seq 값이 변경될 때마다 localStorage에 저장
  // useEffect는 특정 값이 변경될 때 실행되는 함수입니다. 여기서는 seqRef.current가 변경될 때마다 localStorage에 저장하여 페이지 새로고침 시에도 유지되도록 합니다.
  useEffect(() => {
    localStorage.setItem('seq', seqRef.current);
  }, [seqRef.current]);

  const onAdd = async (e) => {
    e.preventDefault();
    setNameDiv('');
    setSubjectDiv('');
    setContentDiv('');

    // 입력 필드 검증: 빈 값일 경우 사용자에게 경고 메시지를 표시합니다.
    if (!name) {
      setNameDiv(' 이름을 입력하시오 ');
      return;
    }
    if (!subject) {
      setSubjectDiv(' 제목을 입력하시오 ');
      return;
    }
    if (!content) {
      setContentDiv(' 내용을 입력하시오 ');
      return;
    }

    try {
      // 게시글 데이터 POST 요청
      // seqRef.current 값과 입력한 name, subject, content 값을 서버에 전송합니다.
      const response = await axios.post('http://localhost:9000/board2/boardInput', {
        seq: seqRef.current, // 현재 seqRef 값을 사용하여 seq 전송
        name,
        subject,
        content,
      });
      console.log('POST ', response); 
      alert('Input 성공!');
      // 게시글 추가 후 seq 값을 증가하고 localStorage에 저장
      // seqRef.current 값을 1 증가시켜 다음 게시글이 작성될 때마다 고유한 seq 값을 가질 수 있도록 합니다.
      // 증가된 seq 값을 다시 localStorage에 저장하여 페이지 새로고침 후에도 반영되도록 합니다.
      seqRef.current += 1;
      localStorage.setItem('seq', seqRef.current);
      navigate('/boardList');
    } catch (error) {
      console.error('POST 에러메시지', error); 
    }
  };

  const onInput = (e) => {
    const { name, value } = e.target;
    // setBoardDTO 함수를 통해 name, subject, content 각각의 값을 업데이트합니다.
    // 스프레드 연산자 (...)를 사용해 기존 boardDTO 값을 유지하면서, 현재 입력된 값만 업데이트합니다.
    setBoardDTO({
      ...boardDTO,
      [name]: value
    });
  };

  return (
    <div className={styles.container}>
      <h2> 게시글 등록 ! </h2>
      <form onSubmit={ onAdd } className={styles.form}>
        <table className={styles.table}>
          <thead>
            <tr>
              <th colSpan="2">글을 작성해보자</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>이름</td>
              <td>
                <input
                  type="text"
                  name="name"
                  placeholder="이름을 입력하시오"
                  value={name}
                  onChange={onInput}
                  className={styles.input}
                />
                <div className={styles.nameDiv}> { nameDiv } </div>
              </td>
            </tr>
            <tr>
              <td>제목</td>
              <td>
                <input
                  type="text"
                  name="subject"
                  placeholder="제목을 입력하세영"
                  value={subject}
                  onChange={onInput}
                  className={styles.input}
                />
                <div className={styles.subjectDiv}>{ subjectDiv }</div>
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td>
                <textarea
                  placeholder="내용입니다"
                  name="content"
                  value={content}
                  onChange={onInput}
                  className={styles.textarea}
                />
                <div className={styles.contentDiv}>{ contentDiv }</div>
              </td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colSpan="2">
                <button type="submit" className={styles.button}>글쓰기</button>
                <button type="reset" className={`${styles.button} ${styles.reset}`}>새로 작성</button>
              </td>
            </tr>
          </tfoot>
        </table>
      </form>
    </div>
  );
};

export default BoardInput;
