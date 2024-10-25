import React, { useEffect, useState } from 'react'; 

import axios from 'axios'; 
//import axios from './../../node_modules/axios/lib/axios'; 
// axios 라이브러리를 불러옵니다. axios는 HTTP 요청을 보내고 응답을 처리하는 데 사용하는 라이브러리입니다.
// 경로에 주목할 필요가 있습니다. 일반적으로 'axios'라고만 불러오지만, 이 코드에서는 명시적으로 경로를 적어줬네요.

// axios 이용해보기
const Test01 = () => {

     // 데이터 받기
     const [ list, setList ] = useState([]);
     // 'list'라는 상태 변수를 선언하고, 그 값을 변경하기 위해 'setList' 함수를 사용합니다.
     // useState([])는 빈 배열로 초기화하며, 이는 데이터를 배열 형태로 받겠다는 의도를 나타냅니다.

     /*
     // 1. fetch 를 통해 url 안에 있는 데이터 가져오기
     // Test01 이 실행되자마자 데이터를 받을려면 useEffect
     // , [] 를 통해 1번만 하는걸로 지정
     useEffect(() => {
          // fetch('https://jsonplaceholder.typicode.com/posts')
          fetch('https://koreanjson.com/posts')
          // fetch() 함수는 네트워크 요청을 보내고 Promise를 반환합니다.
          // fetch에 넘겨준 URL에 있는 데이터를 가져옵니다.
          .then(res => res.json())
          // fetch로 받은 응답 데이터를 .json() 메서드로 JSON 형식으로 변환합니다.
          .then(res => setList(res))
          // 변환된 데이터를 'list' 상태에 저장합니다.
     }, []);
     // useEffect의 두 번째 매개변수인 []는 의존성 배열입니다. 이 배열이 비어 있으면 컴포넌트가 처음 렌더링될 때 한 번만 실행됩니다.
     */

     /*
     // $.ajax({
     //      type: 'post',
     //      url: '',
     //      success:..
     // }) 하던걸 .then 으로 하는 것이다..
     // jQuery의 $.ajax() 방식과 비슷하지만, fetch 또는 axios는 Promise 기반으로 동작하여
     // 응답을 받았을 때 .then()을 사용해 콜백을 처리합니다.
     */

     /*
     // 2. axios  를 통해 가져오기
     useEffect(() => {
          axios.get('https://koreanjson.com/posts')
          // axios는 GET 요청을 보낼 때, .get() 메서드를 사용합니다.
          .then(res => setList(res.data)) 
          // axios의 응답 데이터는 객체로 반환되며, 실제 데이터는 res.data에 저장됩니다.
     }, []);
     // axios도 fetch와 마찬가지로 비동기 통신을 처리할 수 있으며, 데이터 형식과 처리가 더 간결합니다.
     */

     /*
     // 3. 비동기로 가져오기 ( async() )
     useEffect(() => { 
          const getData = async() => {
               const res = await fetch('https://koreanjson.com/posts')
               // async/await 문법을 사용하여 비동기 처리를 합니다.
               // await는 Promise가 완료될 때까지 기다렸다가 결과를 반환합니다.
               const data = await res.json()
               // fetch로 받은 응답을 JSON 데이터로 변환합니다.
               setList(data)
               // 변환된 데이터를 list 상태에 저장합니다.
          }
          getData() // 호출
          // getData 함수가 실행되면서 비동기 처리를 합니다.
     }, []);
     // useEffect는 첫 렌더링 이후 getData를 한 번 호출하게 됩니다.
     */

    // 4. axios 로 비동기
    useEffect(() => { 
     const getData = async() => {
          const res = await axios.get('https://koreanjson.com/posts')
          // axios를 비동기로 사용합니다. await 키워드는 axios.get()의 요청이 완료될 때까지 기다립니다.
          setList(res.data)
          // axios의 응답에서 데이터를 추출해 상태에 저장합니다.
     }
     getData() // 호출
     // getData 함수는 비동기 요청을 보낸 후 데이터를 처리합니다.
     }, []);
     // useEffect를 사용해 첫 렌더링 시 axios로 데이터를 받아옵니다.

     return (
          <div>
               <h2 style={{ textAlign: 'center' }}> 대한민국 헌법 </h2>
               <ul>
                    
                    {
                         list.map(item => <li key={ item.id }>
                                   { item.id }항 <br/> { item.title }
                         </li>)
                         // list 상태에 저장된 데이터를 map 함수를 사용해 렌더링합니다.
                         // 각 항목은 id 값을 key로 하여 리스트 요소로 출력됩니다.
                         // item.id는 글의 고유 식별자이며, item.title은 글의 제목입니다.
                    }
               </ul>
          </div>
     );
};

export default Test01;
// 컴포넌트를 외부에서 사용할 수 있도록 export 합니다.

/*
비동기 통신 - ajax
서버에 새로고침 없이 요청할 수 있게 도와준다.
서버로 네트워크 요청을 보내고 응답을 받을 수 있도록 도와준다.

jQuery - $.ajax()
js - fetch()
     fetch() -> json 형식으로 가져온다.
설치 - axios
       axios.get() -> object 형식으로 가져온다.

외부 API 비동기 통신을 위해서 fetch()를 이용한다.
fetch()에 API 경로를 적어주면 promise가 반환된다.
fetch( url, [options] )

fetch(url)
.then(콜백) - 응답 성공
.catch(콜백) - 응답 실패

axios.get(url)
     .then(콜백) - 응답 성공
     .catch(콜백) - 응답 실패

npm install axios / yarn add axios
// 주석에서 비동기 통신 방식에 대해 설명하고 있습니다.
// jQuery, fetch, axios 모두 비동기 요청을 처리하는 방법이며, 각각의 특성과 사용법을 비교하고 있습니다.
*/
