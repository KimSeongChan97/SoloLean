import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from '../css/BoardList.module.css';

const BoardList = () => {
  const [boardList, setBoardList] = useState([]);

  const fetchData = async () => {
    try {
      const res = await axios.get('http://localhost:9000/board2/boardList');
      setBoardList(res.data);
    } catch (error) {
      console.error('GET 목록불러오기 실패', error);
      // 에러 발생 시 콘솔에 에러 메시지를 출력합니다.
    }
  };

  useEffect(() => {
    fetchData();  // 컴포넌트가 마운트될 때 fetchData 함수를 호출하여 데이터 로드
    // useEffect는 컴포넌트가 처음 렌더링될 때 한 번 실행됩니다. 여기서는 게시글 목록을 처음 로드할 때 사용됩니다.
  }, []);

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
          {boardList.map((board, index) => (
            <tr key={`${board.seq}-${index}`}>
              {/* 각 <tr> 태그에는 고유한 key 값이 필요합니다. board.seq와 index를 조합하여 고유 키를 생성합니다 */}
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
