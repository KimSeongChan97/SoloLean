import React from 'react';
import { useParams } from 'react-router-dom';

const Front = ({ data }) => {

     // 내가 설정한 변수명
     // useParams 가 내가 설정한 변수명을 받아서 전달한다.
     // useParams 훅은 현재 URL의 경로 매개변수를 읽어서 객체 형태로 반환함
     // 여기서 { name }은 '/front/:name' 경로의 변수 부분을 받아와 해당 값을 name에 할당
     const { name } = useParams();

     return (
          <div>
               <h1> Front Page </h1>  
               <h1> { name } </h1> {/* URL에서 받아온 'name' 값을 화면에 출력 */}
               
               <br/>
               {
                    // data 배열에서 name과 일치하는 title 값을 가진 항목만 필터링하여 렌더링
                    data.filter(item => item.title === name)  // 데이터 필터링: item의 title이 URL에서 전달된 name과 일치하는지 확인
                         .map((item, index) => (
                              //  필터링된 항목을 순회하며 각 항목을 <div>로 감싸 렌더링
                              <div key={ index }> 
                                   <h2>
                                        {/* item의 title과 info 값을 화면에 표시, 예: "HTML : HTML 입니다." */}
                                        { item.title } : { item.info }  
                                   </h2>
                              </div>
                         ))
               }
          </div>
     );
};

export default Front;

/*
JSX(JavaScript XML)는 React 애플리케이션에서 사용되는 JavaScript의 확장 문법으로, UI를 표현하기 위한 도구이다.
JSX를 사용하면 JavaScript 코드 내에서 HTML과 비슷한 구문을 사용하여 UI를 선언할 수 있다.

.map() 메서드는 배열의 각 요소를 JSX로 변환하여 새로운 배열을 생성한다.
.map() 메서드를 사용하여 데이터 배열을 JSX로 변환하고, 이를 React 컴포넌트에서 렌더링하면 화면에 원하는 결과를 표시할 수 있다.

.filter() 메서드만 사용하면 원본 배열을 필터링하여 조건을 만족하는 요소들을 포함하는 새로운 배열을 반환하지만, 
이 배열은 JSX로 렌더링할 준비가 되어있지 않다.
JSX를 생성하려면 .map() 메서드나 다른 순회 메서드를 사용하여 각 요소를 JSX로 변환해주어야 한다.

따라서 원본 데이터를 필터링해서 새로운 배열을 만든다고 해서 그것만으로는 웹 페이지나 UI에 결과를 표시할 수 없다.
JSX로 렌더링하려면 .map()이나 유사한 메서드를 사용하여 각 요소를 JSX로 변환해주어야 한다.
*/
