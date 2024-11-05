import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import styles from '../css/BoardInput.module.css';

const BoardInput = () => {

  // 게시글 데이터를 저장하는 state 변수 boardDTO를 생성합니다.
  // useState를 사용하여 초기 값으로 name, subject, content가 빈 문자열로 설정된 객체를 만듭니다.
  const [ boardDTO, setBoardDTO ] = useState({
    name: '',
    subject: '',
    content: ''
  });

  // boardDTO 객체에서 name, subject, content 변수를 구조 분해 할당하여 각각의 변수로 사용합니다.
  // 이렇게 하면 더 간결하게 각 값을 접근할 수 있습니다.
  const { name, subject, content } = boardDTO;

  // 각 입력 필드 아래에 표시될 에러 메시지용 state 변수를 정의합니다.
  // nameDiv, subjectDiv, contentDiv에는 각각 name, subject, content 입력 필드에 대한 오류 메시지가 들어갑니다.
  const [nameDiv, setNameDiv] = useState('');
  const [subjectDiv, setSubjectDiv] = useState('');
  const [contentDiv, setContentDiv] = useState('');

  // const [name, setName] = useState(''); 
  // const [subject, setSubject] = useState(''); 
  // const [content, setContent] = useState('');

  // 입력 필드의 변화를 처리하는 onInput 함수입니다.
  // e는 이벤트 객체로, e.target에서 name과 value를 구조 분해 할당으로 가져옵니다.
  const onInput = (e) => {
      const { name, value } = e.target; // e.target.name은 input의 name 속성 값이며, e.target.value는 입력한 값입니다.
      setBoardDTO({ 
          ...boardDTO, // 기존의 boardDTO 객체를 복사하여 새 객체를 만듭니다.
          [name] : value // name 속성에 따라 특정 필드의 값을 업데이트합니다.
      });
  };

  // 페이지 이동을 위한 navigate 함수를 useNavigate 훅을 사용하여 생성합니다.
  const navigate = useNavigate(); 

  // 폼이 제출될 때 호출되는 onAdd 함수입니다.
  const onAdd = async (e) => {
    e.preventDefault(); // 기본 폼 제출 동작(페이지 리로드)을 방지합니다.

    // 에러 메시지 초기화
    setNameDiv(''); // name 입력 필드 아래에 표시될 오류 메시지를 초기화합니다.
    setSubjectDiv(''); // subject 입력 필드 아래에 표시될 오류 메시지를 초기화합니다.
    setContentDiv(''); // content 입력 필드 아래에 표시될 오류 메시지를 초기화합니다.

    // 필수 입력 항목 체크
    // 각 입력 필드에 내용이 없으면 해당 오류 메시지를 설정하고 함수를 종료하여 서버로의 요청을 막습니다.
    if (!name) {
      setNameDiv(' 이름을 입력하시오 '); // 이름 입력 필드 아래에 오류 메시지를 설정합니다.
      return; // 유효성 검사에서 오류가 발생했으므로 이후 코드를 실행하지 않습니다.
    }
    if (!subject) {
      setSubjectDiv(' 제목을 입력하시오 '); // 제목 입력 필드 아래에 오류 메시지를 설정합니다.
      return;
    }
    if (!content) {
      setContentDiv(' 내용을 입력하시오 '); // 내용 입력 필드 아래에 오류 메시지를 설정합니다.
      return;
    }

    try {
      // 서버에 데이터를 전송하는 POST 요청을 비동기적으로 수행합니다.
      // 서버 주소는 로컬의 9000 포트로 설정되어 있습니다.
      const response = await axios.post('http://localhost:9000/board2/boardInput', {
        name, // name 필드의 값
        subject, // subject 필드의 값
        content, // content 필드의 값
      });
      console.log('POST ', response); // 디버깅용 로그 - 서버 응답 확인
      alert('Input 성공!'); // 게시글이 성공적으로 등록되었다는 알림을 표시합니다.
      navigate('/boardList'); // navigate 함수를 사용하여 게시글 목록 페이지로 이동합니다.
    } catch (error) {
      console.error('POST 에러메시지', error); // 에러가 발생할 경우 콘솔에 에러 메시지를 출력합니다.
    }
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
