import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from '../css/BoardList.module.css';

const BoardList = () => {
  const [boardList, setBoardList] = useState([]); // 게시글 목록을 저장할 상태 변수 초기화

  const fetchData = async () => {
    try {
      const res = await axios.get('http://localhost:9000/board2/boardList'); // 서버로부터 게시글 목록을 가져옴
      console.log('GET:', res); // 디버깅용 로그 - 서버 응답 확인
      setBoardList(res.data); // 서버로부터 받은 데이터를 boardList 상태에 저장
    } catch (error) {
      console.error('GET 목록불러오기 실패', error); // 에러 발생 시 메시지 출력
    }
  };

  useEffect(() => {
    fetchData(); // 컴포넌트가 마운트될 때 fetchData 함수를 호출하여 데이터 로드
  }, []);

  // useEffect 훅 설명
  // useEffect는 React의 생명주기 훅으로, 컴포넌트가 렌더링될 때 특정 작업을 수행하도록 합니다.
  // 여기서 "컴포넌트가 마운트될 때"란, 컴포넌트가 처음 화면에 나타나고 렌더링되는 시점을 의미합니다.
  // 컴포넌트가 마운트되면 내부의 모든 코드와 JSX가 실행되며, 초기 상태를 설정하고,
  // 필요한 경우 데이터를 가져오는 등의 초기화 작업을 수행하게 됩니다.
  // useEffect의 두 번째 인자로 빈 배열 `[]`을 전달하여, 이 코드가 컴포넌트가 처음 렌더링될 때 한 번만 실행되도록 설정합니다.

  return (
    <div className={styles.container}>
      <h2>~ 게시글 목록 ~</h2>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>Seq</th>
            <th>Author</th>
            <th>Subject</th>
            <th>Content</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {boardList.map((board) => (
            <tr key={board.seq}> 
              <td>{board.seq}</td> 
              <td>{board.name}</td> 
              <td>{board.subject}</td> 
              <td>{board.content}</td> 
              <td>{new Date(board.logtime).toLocaleString()}</td> 
            </tr>
          ))}
        </tbody>
        <tfoot>
          <tr>
            <td colSpan="5">Total: {boardList.length} 개의 글 </td> 
          </tr>
        </tfoot>
      </table>
    </div>
  );
};

export default BoardList;
