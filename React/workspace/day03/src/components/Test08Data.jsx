// Test08Data.jsx
export default [
     { id: 1, img: './image/dog01.gif', title: 'dog1' },
     { id: 2, img: './image/dog02.jpg', title: 'dog2' },
     { id: 3, img: './image/dog03.jpg', title: 'dog3' },
     { id: 4, img: './image/dog04.jpg', title: 'dog4' },
     { id: 5, img: './image/dog05.jpg', title: 'dog5' },
     { id: 6, img: './image/dog06.jpg', title: 'dog6' },
     { id: 7, img: './image/dog07.jpg', title: 'dog7' },
     { id: 8, img: './image/dog08.jpg', title: 'dog8' },
     { id: 9, img: './image/dog09.jpg', title: 'dog9' },
     { id: 10, img: './image/dog10.jpg', title: 'dog10' }
     // index.html 기준이므로 public 폴더 내에서 시작됨
 ];
 
 /*
 public에 있는 이미지 폴더는 index.html를 기준으로부터 상대경로를 지정해야 한다.
 index.html 안의 <div id="root"></div> 이곳으로 렌더링 되기 때문이다.
 단 ./ 를 생략해서는 안 된다.
 => 즉, 이미지 파일 경로가 index.html을 기준으로 설정됨.
 src 안에 있는 이미지 파일 처리는 참조변수를 사용한다.
 import 참조변수 from '이미지경로';
 */
 