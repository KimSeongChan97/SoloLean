import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import styles from '../css/BoardInput.module.css';

const BoardInput = () => {

  const [name, setName] = useState(''); 
  const [subject, setSubject] = useState(''); 
  const [content, setContent] = useState('');
  const navigate = useNavigate(); 

  const onSubmit = async (e) => {
    e.preventDefault(); 
    try {
      const response = await axios.post('http://localhost:9000/board2/boardInput', {
        name, 
        subject, 
        content, 
      });
      console.log('POST ', response); // 디버깅용 로그 - 서버 응답 확인
      alert('Input 성공 !'); 
      navigate('/boardList'); 
    } catch (error) {
      console.error('POST 에러메시지', error); 
    }
  };

  return (
    <div className={styles.container}>
      <h2> 게시글 등록 ! </h2>
      <form onSubmit={onSubmit} className={styles.form}>

        <input
          type="text" 
          placeholder="Name" 
          value={name}
          onChange={(e) => setName(e.target.value)} 
          className={styles.input} />

        <input
          type="text" 
          placeholder="Subject"
          value={subject} 
          onChange={(e) => setSubject(e.target.value)} 
          className={styles.input} />
 
        <textarea
          placeholder="Content" 
          value={content} 
          onChange={(e) => setContent(e.target.value)} 
          className={styles.textarea} />

        <button type="submit" className={styles.button}>Submit</button>
      </form>
    </div>
  );
};

export default BoardInput;
