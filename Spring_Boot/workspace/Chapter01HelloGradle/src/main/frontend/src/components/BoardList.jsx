import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from '../css/BoardList.module.css';

const BoardList = () => {
  const [boardList, setBoardList] = useState([]);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:9000/board2/boardList');
      console.log('GET:', response); // 디버깅용 로그
      setBoardList(response.data);
    } catch (error) {
      console.error('GET 목록불러오기 실패', error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const onDelete = async (seq) => {
    try {
      await axios.delete(`http://localhost:9000/board2/boardDelete/${seq}`);
      alert('삭제 성공!');
      fetchData(); // 삭제 후 목록 새로고침
    } catch (error) {
      console.error('DELETE 에러메시지', error);
    }
  };

  return (
    <div className={styles.container}>
      <h2>Board List</h2>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>Seq</th>
            <th>Author</th>
            <th>Subject</th>
            <th>Content</th>
            <th>Date</th>
            <th>Action</th>
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
              <td>
                <button 
                  onClick={() => onDelete(board.seq)} 
                  className={styles.deleteButton}>삭제</button>
              </td>
            </tr>
          ))}
        </tbody>
        <tfoot>
          <tr>
            <td colSpan="6">Total: {boardList.length} items</td>
          </tr>
        </tfoot>
      </table>
    </div>
  );
};

export default BoardList;
