import React, { useEffect, useReducer, useState } from 'react'; // React에서 useEffect, useReducer, useState를 불러옵니다.
import axios from 'axios'; // HTTP 요청을 위한 axios 라이브러리를 불러옵니다.

// 초기 상태 설정
const initialState = {
    dto: {}, // 데이터를 담을 객체 초기값 (서버로부터 가져올 데이터를 저장할 곳입니다)
    error: null, // 에러 메시지 초기값 (없음) (요청에 실패했을 때 에러 메시지를 담을 공간입니다)
    loading: true // 로딩 상태 초기값 (로딩 중) (데이터를 가져오는 중임을 표시하는 상태입니다)
};

// 상태를 변경하기 위한 reducer 함수 정의
const reducer = (state, action) => {
    switch(action.type){ // action.type에 따라 상태를 다르게 업데이트하는 조건문입니다.
        // 요청 성공 시 상태 업데이트
        case 'SUCCESS':
            return {
                dto: action.payload, // 서버에서 받아온 데이터를 dto에 저장
                error: null, // 에러 초기화 (성공했으므로 에러는 없다고 설정)
                loading: false // 로딩 완료 상태로 변경 (데이터가 성공적으로 로드되었음을 표시)
            }
        // 요청 실패 시 상태 업데이트
        case 'ERROR':
            return {
                dto: {}, // 데이터 초기화 (에러 발생 시 이전 데이터는 무효화)
                error: '404에러, 데이터를 가져오지 못하였습니다.', // 에러 메시지 설정 (404 오류 발생 시 사용자에게 표시할 메시지)
                loading: false // 로딩 완료 상태로 변경 (요청이 끝났음을 표시)
            }
        // 정의된 타입 외의 기본 상태 반환
        default: 
            return state; // 정의되지 않은 액션이 발생할 경우 기존 상태를 그대로 반환
    }
};

// Test05 컴포넌트 정의
const Test05 = () => {
    const [id, setId] = useState(1); // 사용자가 입력한 id를 관리하는 state (사용자가 검색할 ID를 입력할 때 값이 저장됨)
    const [search, setSearch] = useState(1); // 검색 버튼 클릭 시 검색할 id를 관리하는 state (검색 버튼을 누르면 해당 ID 값으로 API 요청을 보냄)
    const [state, dispatch] = useReducer(reducer, initialState); // reducer와 초기 상태를 설정하여 state와 dispatch 함수 생성
    // useReducer 훅은 reducer 함수를 사용하여 state를 관리하고, 이를 통해 비동기 요청 결과를 state에 반영할 수 있습니다.

    // 검색 버튼 클릭 시 호출되는 함수
    const onSearch = (id) => {
        setSearch(id); // 검색할 id 값을 설정하여 useEffect에서 요청을 트리거함
        // setSearch는 검색할 ID를 업데이트하여, useEffect가 이 값 변화를 감지하고 API 요청을 실행하게 합니다.
    };

    // search 값이 변경될 때마다 실행되는 useEffect
    useEffect(() => {
        const url = `https://jsonplaceholder.typicode.com/photos/${search}`; // 외부 API의 URL에 검색할 id 값을 포함
        // 요청을 보낼 URL로, search 값이 변할 때마다 해당 ID로 데이터를 요청할 수 있게 설정합니다.

        // axios를 이용한 비동기 요청
        axios.get(url)
            .then(res => dispatch({ type: 'SUCCESS', payload: res.data })) // 요청 성공 시 SUCCESS 액션을 dispatch하여 데이터 상태 업데이트
            // 요청이 성공하면, action.type을 'SUCCESS'로 설정하여 받아온 데이터(res.data)를 state에 저장합니다.
            .catch(error => dispatch({ type: 'ERROR' })); // 요청 실패 시 ERROR 액션을 dispatch하여 에러 메시지 업데이트
            // 요청이 실패하면 action.type을 'ERROR'로 설정하여 에러 상태로 업데이트하고, 로딩을 완료 상태로 변경합니다.

    }, [search]); // search가 변경될 때마다 이 useEffect가 실행됨
    // search 값이 변경될 때마다 이 useEffect가 실행되어 API 요청을 보내고, 결과에 따라 state를 업데이트합니다.

    return (
        <div>
            <h3>
                ID 입력하시오 (1~5000): 
                <input 
                    type='text' 
                    value={id} // input의 값은 id 상태 값과 연결됨 (input 필드의 값을 id 상태에 바인딩하여 화면에 동기화합니다)
                    onChange={e => setId(e.target.value)} // input 값 변경 시 id 상태를 업데이트 (입력된 값이 변경되면 id 상태를 즉시 업데이트합니다)
                />
                <button onClick={() => onSearch(id)}> 검색 </button> {/* 검색 버튼 클릭 시 onSearch 함수 호출 */}
                {/* 사용자가 검색 버튼을 클릭하면 onSearch 함수가 호출되어 현재 id 값을 search 상태로 설정합니다 */}
            </h3>
            <br/>
            <h2>
                {
                    state.loading ? '로딩 중' : state.dto.title // 로딩 중이면 '로딩 중' 메시지, 완료되면 dto의 title 표시
                    // state.loading이 true일 경우 '로딩 중' 메시지를 표시하고, false일 경우 API로부터 받아온 데이터의 title을 표시합니다.
                }
                <br/>
                {
                    !state.loading && state.dto.thumbnailUrl && // 로딩이 완료되고 데이터에 thumbnailUrl이 있는 경우에만 이미지 표시
                    <img src={state.dto.thumbnailUrl} alt={state.dto.id} /> // API로부터 받아온 썸네일 이미지 표시
                    // 로딩이 완료되고 dto 객체에 thumbnailUrl이 존재하면 이미지가 화면에 렌더링됩니다.
                }
            </h2>
            <p>
                { state.error || null } {/* 에러가 있으면 에러 메시지 표시, 없으면 null */}
                {/* 에러가 존재하면 해당 메시지를 표시하고, 그렇지 않으면 null을 반환하여 화면에 아무것도 표시되지 않게 합니다. */}
            </p>
        </div>
    );
};

export default Test05;
