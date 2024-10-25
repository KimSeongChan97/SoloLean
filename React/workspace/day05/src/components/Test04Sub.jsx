import React, { useMemo } from 'react';

// getColor 함수는 선택된 색상에 맞는 한글 이름을 반환합니다.
const getColor = (color) => {
     console.log('getColor 함수 실행'); // getColor 함수가 실행될 때마다 로그를 출력합니다.

     // 선택된 색상에 따른 한글 색상 이름을 반환하는 switch 문입니다.
     switch(color){
          case 'hotpink':
               return '진분홍'
          case 'magenta':
               return '마젠타'
          case 'skyblue':
               return '하늘'
          case 'tomato':
               return '토마토'
          case 'cyan':
               return '시안'
          case 'darkgreen':
               return '진녹'
     }
};

// getFood 함수는 선택된 음식에 맞는 분류 이름을 반환합니다.
const getFood = (food) => {
     console.log('getFood 함수 실행'); // getFood 함수가 실행될 때마다 로그를 출력합니다.

     // 선택된 음식에 따른 분류를 반환하는 switch 문입니다.
     switch(food){
          case '햄버거':
               return '인스턴트'
          case '삼겹살':
               return '돼지고기'
          case '치킨':
               return '닭고기'
          case '피자':
               return '밀가루'
     }
};

const Test04Sub = ({ color, food }) => {

     // 색상을 바꾸거나 음식을 바꾸면, 모든 getColor, getFood  로그가 발생한다.
     //const colorInfo = getColor(color);
     //const foodInfo = getFood(food);

     // 해결방법 : useMemo
     // 일반함수가 아니라 useMemo 를 사용하면,
     // color 가 바뀌면 getColor 만 발생하거나 , food 가 바뀌면 getFood 만 로그 발생한다.

     // color가 변경될 때만 getColor가 실행됩니다. 캐싱된 값을 사용하여 불필요한 재실행을 방지합니다.
     const colorInfo = useMemo(() => getColor(color), [color]);
     
     // food가 변경될 때만 getFood가 실행됩니다. 캐싱된 값을 사용하여 불필요한 재실행을 방지합니다.
     const foodInfo = useMemo(() => getFood(food), [food]);

     // 다른 방법
     // const colorInfo = useMemo(() => {
     //      return getColor(color)
     // }, [color]);
     // const foodInfo = useMemo(() => {
     //      return getFood(food)
     // }, [food]);

     // 전체적으로 차이점은 일반함수보다 useMemo 사용시 메모리적으로 유리하다
     // useMemo를 사용하면 메모리 사용 효율이 증가하고 불필요한 함수 실행이 줄어듭니다.
     // 이는 성능 최적화에 도움을 주며, 각각의 상태가 변경될 때 필요한 함수만 실행되도록 보장합니다.

     return (
          <div>
               {/* 선택한 색상과 해당 색상에 맞는 한글 이름을 표시합니다. */}
               <h3> 선택한 색 : { color } </h3>
               <h4> 당신은 { colorInfo } 을 좋아하는 군요 !! </h4>

               {/* 선택한 음식과 해당 음식에 맞는 분류 이름을 표시합니다. */}
               <h3> 선택한 음식 : { food } </h3>
               <h4> 당신은 { foodInfo } 을 좋아하는 군요 !! </h4>
          </div>
     );
};

export default Test04Sub;
