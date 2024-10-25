import React, { useEffect, useState, useRef } from 'react';
import axios from 'axios';

// 특정 id 값에 대한 결과물들을 가져오기
const Test02 = () => {

    // 데이터 받기 (객체), dto는 1인분이므로 설정
    const [dto, setDto] = useState({});
    // dto는 데이터를 저장하기 위한 상태 변수로, 처음에는 빈 객체로 초기화한다.
    // 이 상태 변수는 서버에서 받아온 데이터를 저장하는데 사용된다.
    
    const [id, setId] = useState(3); // 기본값 3으로 설정
    // id는 사용자가 입력한 값을 저장하는 상태 변수이다.
    // 초기값은 3으로 설정되어 있으며, 사용자가 input 필드에 값을 입력할 때마다 갱신된다.
    
    const [search, setSearch] = useState(3);
    // search는 실제로 API 호출 시 사용되는 id 값을 저장하는 상태 변수이다.
    // 검색 버튼을 누를 때, 현재 입력된 id 값을 이 상태 변수에 설정하여 해당 id로 검색이 이루어진다.
    
    const [errorMessage, setErrorMessage] = useState(''); // 오류 메시지 관리
    // errorMessage는 서버 요청 실패 또는 잘못된 입력이 있을 경우 표시될 오류 메시지를 저장하는 상태 변수이다.
    // 처음에는 빈 문자열로 초기화되며, 오류가 발생하면 메시지가 업데이트된다.
    
    const inputRef = useRef(null); // input 포커스를 위해 useRef 사용
    // inputRef는 입력 필드에 포커스를 다시 설정하기 위한 reference 객체이다.
    // useRef를 사용하여 직접적으로 DOM 요소에 접근할 수 있으며, 검색 후 입력 필드에 포커스를 다시 설정할 수 있다.

    // 지정 id에 따른 값 가져오기
    useEffect(() => {
        axios.get(`https://koreanjson.com/posts/${search}`)
        // axios.get은 비동기 함수로, 해당 URL에서 데이터를 가져온다.
        // 여기서 search는 검색할 id를 의미하며, 사용자가 입력한 id가 이 변수에 담겨 API 요청을 보낸다.
        
        .then(response => {
            setDto(response.data);  // 데이터 설정
            // 서버로부터 응답이 성공적으로 도착하면 response 객체에서 data 속성을 추출해 dto 상태 변수에 저장한다.
            // 이를 통해 화면에 받아온 데이터를 표시할 수 있게 된다.
            
            setErrorMessage('');    // 오류 메시지 초기화
            // 데이터가 성공적으로 받아졌으므로, 혹시 이전에 있었던 오류 메시지를 비워준다.
        })
        .catch(() => {
            setDto({}); // 데이터 초기화
            // 만약 요청에 실패하거나, 해당 id가 존재하지 않을 경우 dto 상태를 빈 객체로 초기화한다.
            
            setErrorMessage('존재하지 않는 id입니다, 다시 입력해주세요'); // 오류 메시지 설정
            // 요청에 실패했을 때는 사용자에게 알리기 위해 오류 메시지를 설정한다.
            // 존재하지 않는 id일 때 화면에 표시할 문구를 설정한 것이다.
        });
    }, [search]); // 검색 버튼을 클릭할 때마다 적용하게 하려면 [search]를 설정
    // useEffect는 search 값이 변경될 때마다 실행된다.
    // 즉, 사용자가 검색 버튼을 클릭해 search 값이 변경되면 새로운 API 요청이 발생한다.
    // 배열 안에 search 상태 변수를 넣어 search가 변경될 때마다 이 함수가 호출된다.

    // 검색 버튼 클릭 시 처리
    const onSearch = () => {
        if (!isNaN(id) && id !== '') { // id가 숫자인지 확인
        // 사용자가 입력한 id가 숫자인지 확인하는 조건문이다. isNaN은 "Not-a-Number"를 뜻하는 함수로,
        // id가 숫자가 아니면 true를 반환한다. 따라서 이 조건은 숫자 입력이 제대로 되었는지 확인하는 부분이다.
        // 또한, 빈 문자열이 아닌지 확인하여 입력이 비어 있지 않도록 체크한다.
        
            setSearch(id); // 검색할 id 설정
            // id가 유효한 경우, search 상태 변수에 현재 입력된 id 값을 설정한다.
            // 이로 인해 useEffect가 다시 실행되며 새로운 API 요청이 발생하게 된다.
        } else {
            setErrorMessage('숫자만 입력해주세요.'); // 유효하지 않은 입력일 경우 처리
            // 입력된 값이 숫자가 아니거나 비어 있는 경우 사용자에게 오류 메시지를 출력한다.
        }
        setId(''); // 입력 필드 초기화
        // 검색 후 입력 필드를 비워 사용자가 새로 값을 입력할 수 있도록 한다.
        
        inputRef.current.focus(); // 포커스 다시 설정
        // inputRef를 사용해 검색 후 다시 입력 필드에 포커스를 맞춘다.
        // 사용자가 새로 입력할 준비를 쉽게 할 수 있도록 하는 UX 개선이다.
    }

    return (
        <div style={{ textAlign: 'center' }}>
            <h2>대한민국 헌법</h2>
            <label>1 ~ 100 번 까지의 id 입력 : </label>
            <input
                type='text'
                value={id}
                ref={inputRef} // input에 ref 연결
                // 입력 필드에 ref를 연결하여 포커스를 제어할 수 있게 한다.
                onChange={e => setId(e.target.value)}
                // 사용자가 input 필드에 값을 입력할 때마다 onChange 이벤트가 발생하며,
                // 입력된 값이 id 상태 변수에 저장된다.
            />
            <button onClick={onSearch}>검색</button>
            {/* 버튼을 클릭하면 onSearch 함수가 실행되어 API 요청이 발생하고, 결과가 표시된다 */}
            
            <h3>
                {errorMessage 
                  ? errorMessage // 오류 메시지가 있을 경우 해당 메시지 출력
                  : dto.id // dto에 id가 없으면 "데이터가 없습니다" 출력
                    ? `${dto.id} / ${dto.title}` 
                    : "데이터가 없습니다."
                }
                {/* errorMessage가 비어 있지 않으면 오류 메시지를 화면에 출력하고,
                // 오류가 없을 경우 dto에서 받아온 id와 title을 화면에 표시한다 */}
            </h3>                        
        </div>
    );
};

export default Test02;
