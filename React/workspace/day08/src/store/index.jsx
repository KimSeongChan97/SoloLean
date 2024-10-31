import { combineReducers } from "redux";
import color from './modules/color.jsx';
import count from './modules/count.jsx';
import animal from './modules/animal.jsx';

export default combineReducers({
     
     // 이름: 값
     // 리듀서 이름: 리듀서 값
     // modules 폴더 안의 color.jsx
     color : color,
     // 여기서 key로 사용되는 'color'는 상태 트리에서의 이름을 결정한다.
     // 즉, 스토어의 상태에서 color 리듀서가 관리하는 상태가 state.color로 접근 가능하게 된다.
     // 오른쪽의 'color'는 './modules/color.jsx' 파일에서 가져온 리듀서 함수 자체이다.
     // 이를 통해 상태가 증가할 때마다 필요한 리듀서를 combineReducers로 묶어주어 하나의 스토어를 구성할 수 있다.

     // 리듀서 이름 : 리듀서 함수
     // key : value 가 동일 값이므로 ES6 문법에 의해 축약형으로 줄일 수 있다.
     count, // count : count 와 같은 의미 ( key : value )

     animal // animal : animal 와 같은 의미  ( key : value )

});
