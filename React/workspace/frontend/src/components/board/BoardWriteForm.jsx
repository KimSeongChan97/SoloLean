// BoardWriteForm.jsx
import React, { useState } from 'react';
import axios from 'axios';
import styles from '../../css/BoardWriteForm.module.css'; // CSS 모듈 가져오기
import { useNavigate } from 'react-router-dom';

const BoardWriteForm = () => {
  const [subject, setSubject] = useState('');
  const [content, setContent] = useState('');

  const [subjectDiv, setSubjectDiv] = useState('');
  const [contentDiv, setContentDiv] = useState('');

  const navigate = useNavigate();

  const onBoardWriteSubmit = (e) => {
      e.preventDefault();
      
      setSubjectDiv('');
      setContentDiv('');

      if(!subject){
        setSubjectDiv('제목 입력');
      }else if(!content){
        setContentDiv('내용 입력');
      } else {
          axios.post('http://localhost:8080/spring/board/boardWrite', 
                      null,
                      { 
                        params : { subject: subject , content: content },
                         withCredentials: true 
                      })
               .then(res => {
                    alert('글쓰기 완료');
                    navigate('/board/BoardList');
            });
      }
    };    


  return (
      <div className={styles.BoardWriteForm}>
          <div className={styles.container}>
              <h2 className={styles.title}>게시물 작성</h2>
              <form>
                  <table>
                      <thead></thead>
                      <tbody>
                          <tr>
                              <td>
                                  <label htmlFor="subject" className={styles.label}>제목:</label>
                              </td>
                              <td>
                                  <input
                                      type="text"
                                      id="subject"
                                      value={subject}
                                      onChange={(e) => setSubject(e.target.value)}
                                      required
                                      className={styles.input}
                                  />
                                  <div id={styles.subjectDiv}>{ subjectDiv }</div>
                              </td>
                          </tr>
                          <tr>
                              <td>
                                  <label htmlFor="content" className={styles.label}>내용:</label>
                              </td>
                              <td>
                                  <textarea
                                      id="content"
                                      value={content}
                                      onChange={(e) => setContent(e.target.value)}
                                      required
                                      className={styles.textarea}
                                  />
                                  <div id={styles.contentDiv}>{ contentDiv }</div>
                              </td>
                          </tr>
                          <tr>
                              <td colSpan="2">
                                  <button type="button" onClick={onBoardWriteSubmit} className={styles.button}>게시물 작성</button>
                              </td>
                          </tr>
                      </tbody>
                      <tfoot></tfoot>
                  </table>
              </form>
          </div>
      </div>
  );
};

export default BoardWriteForm;


/*

입력 : axios.get()
출력 : axios.post()
수정 : axios.put()
삭제 : axios.delete()

*/