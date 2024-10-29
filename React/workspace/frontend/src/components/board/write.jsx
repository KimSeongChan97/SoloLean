// Write.jsx
import React, { useState } from 'react';
import axios from 'axios';

const Write = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/SpringReactProject/board/write', { title, content })
      .then(response => {
        alert("글이 성공적으로 등록되었습니다!");
        setTitle('');
        setContent('');
      })
      .catch(error => console.error("Error submitting post:", error));
  };

  return (
    <div>
      <h3>글쓰기</h3>
      <form onSubmit={handleSubmit}>
        <div>
          <label>제목:</label>
          <input 
            type="text" 
            value={title} 
            onChange={(e) => setTitle(e.target.value)} 
            required 
          />
        </div>
        <div>
          <label>내용:</label>
          <textarea 
            value={content} 
            onChange={(e) => setContent(e.target.value)} 
            required 
          />
        </div>
        <button type="submit">등록</button>
      </form>
    </div>
  );
};

export default Write;
