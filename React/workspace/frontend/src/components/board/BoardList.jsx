import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styles from '../../css/BoardList.module.css';
import axios from 'axios';

const Boardlist = () => {
    const [list, setList] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/spring/board/BoardList`)
             .then(res => {
                console.log(res.data);
                setList(res.data);
             })
             .catch(error => console.error('데이터를 불러오는 중 오류가 발생했습니다:', error));
    }, []);    

    return (
        <div className={styles.Boardlist}>
            <h1>BoardList</h1>

            <table border={1} frame='hsides' rules='rows'>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        list.map(board => (
                            <tr key={board.seq}>
                                <td>{board.seq}</td> 
                                <td><Link to={`/board/BoardDetail/${board.seq}`}>{board.subject}</Link></td> 
                                <td>{board.name}</td> 
                                <td>{board.hit}</td>  
                                <td>{board.logtime}</td>
                            </tr>
                        ))
                    }
                </tbody>
                <tfoot></tfoot>
            </table>
        </div>
    );
};

export default Boardlist;
