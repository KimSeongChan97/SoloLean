// List.jsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const List = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/SpringReactProject/board/list')
      .then(response => setPosts(response.data))
      .catch(error => console.error("Error fetching posts:", error));
  }, []);

  return (
    <div>
      <h3>글 목록</h3>
      <ul>
        {posts.map(post => (
          <li key={post.id}>
            <h4>{post.title}</h4>
            <p>{post.content}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default List;
