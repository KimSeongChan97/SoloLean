import React, { useEffect, useReducer } from 'react';
import axios from 'axios';

// 초기 상태 객체를 설정합니다. 이 객체는 데이터(dto), 오류 메시지(error), 로딩 상태(loading)를 관리하는 세 가지 속성을 가지고 있습니다.
// 컴포넌트가 처음 렌더링될 때 초기 상태는 dto가 빈 객체, error가 null, 그리고 로딩 상태가 true로 설정됩니다.
// 초기 상태는 reducer의 기본값으로, 초기 상태의 각 속성은 컴포넌트의 최초 렌더링 시의 상태를 나타냅니다.
const initialState = {
     dto: {},
     error: null,
     loading: true
};

// reducer 함수는 현재 상태(state)와 전달된 액션(action)을 받아 새로운 상태를 반환합니다.
// 상태가 변경되는 로직을 이 reducer에서 정의합니다. action.type 값에 따라 switch 문을 통해 상태를 다르게 처리합니다.
// 상태 업데이트는 불변성을 유지해야 하며, 이 함수는 새로운 객체를 반환해 상태 변경을 구현합니다.
const reducer = ( state, action ) => {
     switch(action.type){
          case 'SUCCESS':
               // 성공 케이스: 데이터를 정상적으로 받아온 경우
               // dto는 action.payload에 담긴 데이터로 업데이트되며, error는 null로 설정하고, 로딩 상태를 false로 변경하여 로딩이 끝났음을 나타냅니다.
               // 성공적으로 데이터를 받아왔기 때문에 dto 속성에 데이터가 담기고, 로딩을 완료 상태로 표시합니다.
               return {
                    dto: action.payload,
                    error: null,
                    loading: false
               }
          case 'ERROR':
               // 에러 케이스: 데이터를 가져오는 데 실패한 경우
               // dto는 빈 객체로 설정되고, error는 에러 메시지를 담아 에러가 발생했음을 나타내며, loading 상태는 true로 유지하여 데이터를 로딩 중임을 나타냅니다.
               // 이 경우 데이터가 존재하지 않으므로 dto는 빈 객체로 설정되고, 에러 메시지를 error에 저장하여 화면에 표시할 수 있게 합니다.
               return {
                    dto: {},
                    error: '404에러, 데이터를 가져오지 못하였습니다.',
                    loading: true
               }
          default: 
               // 정의되지 않은 액션 타입이 들어올 경우 현재 상태를 그대로 반환하여 상태를 유지합니다.
               // 이 기본 case는 예기치 않은 액션이 발생했을 때 현재 상태를 그대로 유지해주므로 안전성을 높여줍니다.
               return state;     
     }
};

const Test04 = () => {

     // useReducer 훅을 통해 state와 dispatch 함수를 가져옵니다.
     // state는 현재 상태 객체를 나타내고, dispatch는 액션을 보내는 함수입니다.
     // reducer와 initialState를 인수로 전달받아 state를 관리하며, dispatch를 통해 reducer로 액션을 보냅니다.
     const [ state, dispatch ] = useReducer(reducer, initialState);
     // state -> state / dispatch -> action -> reducer
     // 상태가 reducer에서 정의된 로직에 따라 dispatch로 전달된 action을 통해 업데이트됩니다.
     // dispatch는 reducer 함수에 action 객체를 전달하여 상태 업데이트를 트리거합니다.

     useEffect(() => {
          // useEffect 훅을 사용하여 컴포넌트가 마운트될 때 데이터를 가져옵니다.
          // URL은 가져올 데이터의 주소로 설정합니다. 이 예제에서는 JSONPlaceholder API의 특정 포스트 데이터를 가져옵니다.
          const url = 'https://jsonplaceholder.typicode.com/posts/3';

          // axios를 사용해 비동기 GET 요청을 통해 데이터를 가져옵니다.
          // 데이터 요청이 성공하면 dispatch를 호출해 'SUCCESS' 타입의 액션과 함께 payload로 응답 데이터를 전달합니다.
          // 성공하면 서버에서 전달된 데이터를 payload에 담아 'SUCCESS' 액션을 통해 전달합니다.
          axios.get(url)
               .then( res => dispatch({ type: 'SUCCESS', payload: res.data }))
               .catch(error => dispatch({ type: 'ERROR' })); // 오류 발생 시 'ERROR' 타입의 액션을 dispatch하여 에러 메시지를 설정합니다.
     }, []); // , [] 를 함으로써 한번의 효과 적용
     // 빈 배열([])을 두 번째 인수로 전달하여 컴포넌트가 처음 마운트될 때 한 번만 이 효과가 실행되도록 설정합니다.
     // 빈 배열은 이 useEffect가 컴포넌트가 처음 렌더링될 때 단 한 번만 실행되도록 해줍니다.

     return (
          <div>
               <h2>
                    {
                         // state.dto 가 참이라면, state.loading 으로 로딩 중을 표시, false 라면 body 을 표시
                         // state.loading이 true면 데이터를 아직 가져오는 중이므로 '로딩 중'을 화면에 표시합니다.
                         // 만약 state.loading이 false이면, 요청 성공 후 받아온 데이터를 표시하는 것으로 간주하고 state.dto.body 화면에 표시합니다.
                         state.dto && state.loading ? '로딩 중' : state.dto.body
                    }
               </h2>
                    <p>
                         {
                              // state.error 가 
                              // state.error가 null이 아니라면 에러가 발생한 것으로 간주하여 에러 메시지를 화면에 표시합니다.
                              // 에러가 없다면(null) 아무 것도 표시하지 않습니다.
                              // 에러 메시지는 사용자에게 오류 상황을 전달하는 용도로 활용됩니다.
                              state.error ? state.error : null
                         }
                    </p>
          </div>
     );
};


export default Test04;