import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import styles from '../../css/BoardDetail.module.css';

const BoardDetail = () => {
     const { seq } = useParams(); 
     const [board, setBoard] = useState(null);
     const navigate = useNavigate();

     useEffect(() => {
          axios.get(`http://localhost:8080/spring/board/BoardDetail?seq=${seq}`)
          .then(res => setBoard(res.data))
          .catch(error => console.error('글을 불러오는 중 에러 : ', error));
     }, [seq]);

     if (!board) return <div className={styles.loading}>로딩 중...</div>;

     return (
          <div className={styles.boardDetail}>
               <h2 className={styles.title}>{board.subject}</h2>
               <table className={styles.infoTable}>
                    <tbody>
                         <tr>
                              <th>작성자</th>
                              <td>{board.name}</td>
                         </tr>
                         <tr>
                              <th>이메일</th>
                              <td>{board.email}</td>
                         </tr>
                         <tr>
                              <th>작성일</th>
                              <td>{board.logtime}</td>
                         </tr>
                         <tr>
                              <th>조회수</th>
                              <td>{board.hit}</td>
                         </tr>
                         <tr>
                              <th>레벨</th>
                              <td>{board.lev}</td>
                         </tr>
                         <tr>
                              <th>스텝</th>
                              <td>{board.step}</td>
                         </tr>
                         <tr>
                              <th>참조 ID</th>
                              <td>{board.ref}</td>
                         </tr>
                    </tbody>
               </table>

               <div className={styles.contentBox}>
                    <p className={styles.content}>{board.content}</p>
               </div>
               
               <button onClick={() => navigate('/board/BoardList')} className={styles.backButton}>목록으로 돌아가기</button>
          </div>
     );
};

export default BoardDetail;
