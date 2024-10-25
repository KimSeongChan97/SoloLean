import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from '../css/Movies.module.css'; 


const Movies = () => {
    // date와 movies라는 state를 각각 빈 문자열과 빈 배열로 초기화합니다.
    // date는 사용자 입력을 통해 날짜를 저장하는 데 사용되며, movies는 API 호출 후 받아오는 영화 데이터 목록을 저장합니다.
    const [date, setDate] = useState('');  
    const [error, setError] = useState('');  // API 오류 발생 시 에러 메시지를 저장하는 state를 추가합니다.
    const [movies, setMovies] = useState([]);    

    // async/await을 사용한 비동기 함수 onMovies를 정의하여 API 호출을 수행합니다.
    const onMovies = async () => {
        try {
            // 기존에 발생한 오류 메시지를 초기화합니다. 
            // 새로운 요청을 시작할 때마다 error state를 빈 문자열로 설정하여 이전 오류 메시지가 표시되지 않게 합니다.
            setError('');
            
            // 날짜별 영화 데이터를 가져오기 위해 KOBIS 오픈 API URL을 구성합니다.
            // API 키와 사용자 입력 날짜를 포함하여 요청을 수행합니다.
            const API_URL = `https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=82ca741a2844c5c180a208137bb92bd7&targetDt=${date}`;
            const res = await axios.get(API_URL);  // axios로 API URL에 GET 요청을 보냅니다.
            const movieList = res.data.boxOfficeResult.dailyBoxOfficeList;  // 응답에서 일일 박스오피스 목록을 가져옵니다.

            // API 응답으로 받은 영화 목록이 비어있으면 빈 배열을 state에 설정합니다.
            if (movieList.length === 0) {
                setMovies([]);  // movies state를 빈 배열로 업데이트하여 영화 목록을 초기화합니다.
                setError('해당 날짜에 데이터가 없습니다. 다른 날짜를 입력해 주세요.');  // 데이터가 없는 경우 사용자에게 안내 메시지를 설정합니다.
            } else {
                setMovies(movieList);  // 영화 목록을 movies state에 설정합니다.
            }
        } catch (err) {
            // API 호출에 실패하면 catch 블록으로 들어옵니다.
            // 오류가 발생한 경우 error state에 오류 메시지를 설정하여 사용자에게 표시합니다.
            setMovies([]);
            setError('데이터를 불러오는 중 오류가 발생했습니다. 다시 시도해 주세요.');
        }
    };

    // Form 제출 시 실행되는 이벤트 핸들러 함수
    const onSubmit = (e) => {
        e.preventDefault();  // form 제출 시 페이지 새로고침을 방지합니다.

        // date 값이 8글자가 아니거나 숫자가 아니면 movies를 빈 배열로 설정하여 목록을 초기화합니다.
        if (date.length !== 8 || isNaN(date)) {
            setMovies([]);  // 날짜 형식이 올바르지 않으면 빈 배열로 설정하여 잘못된 입력에 대한 반응을 처리합니다.
            setError('날짜 형식이 잘못되었습니다. yyyymmdd 형식으로 입력해 주세요.');  // 형식 오류 시 사용자에게 안내 메시지를 설정합니다.
        } else {
            onMovies();  // 올바른 날짜 형식이라면 API 호출을 수행하여 영화 목록을 가져옵니다.
        }
    };

    return (
        <div className={styles.container}>
            <h1 className={styles.title}>날짜별 영화 랭킹 사이트</h1>
            {/* 날짜 입력 폼으로, 사용자가 날짜를 입력하고 onSubmit을 통해 API 호출이 이루어집니다. */}
            <form onSubmit={onSubmit} className={styles.form}>
                <label className={styles.label}>
                    날짜 입력 (yyyymmdd): 
                    {/* 사용자 입력을 받아 date state에 설정하는 input 요소입니다. */}
                    <input 
                        type='text'
                        value={date}  // 입력된 날짜 값을 date state와 연결합니다.
                        onChange={(e) => setDate(e.target.value)}  // 입력 변화에 따라 date state를 업데이트합니다.
                        placeholder='예: 20241024'  // 날짜 입력 형식에 대한 예시를 보여줍니다.
                        className={styles.input}
                    />
                </label> &nbsp;
                {/* 날짜를 입력한 후 API 요청을 시작하기 위한 버튼입니다. */}
                <button type='submit' className={styles.button}>
                    검색
                </button>
            </form>
            {/* 오류 메시지가 있을 경우 사용자에게 표시합니다. */}
            {error && <p className={styles.error}>{error}</p>}
            {/* API로부터 받은 영화 데이터를 출력하는 목록입니다. */}
            <ul className={styles.list}>
                {/* movies 배열의 각 항목을 map 메서드를 통해 렌더링합니다. */}
                {movies.map((movie, index) => (
                    // movie.movieCd를 키로 사용하여 영화 정보를 표시합니다.
                    <li key={movie.movieCd} className={styles.listItem}>
                        {index + 1} 위  :  {movie.openDt}  /  {movie.movieNm}  {/* 순위와 개봉일, 영화 제목을 표시합니다. */}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Movies;


