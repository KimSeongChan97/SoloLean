// 1. 액션 생성
const INCREMENT = 'count/INCREMENT';
const DECREMENT = 'count/DECREMENT';
const RESET = 'count/RESET';
// 액션 타입은 상태를 어떻게 변화시킬지를 정의하는 상수입니다.
// 'count/INCREMENT'와 같은 문자열로 작성하는 것은 액션 타입의 고유성을 보장합니다.
// 리덕스는 액션 타입을 통해 리듀서가 어떤 작업을 해야 할지를 결정합니다.

// 2. 액션 보내기 ( action 객체 )
export const increment = () => ({ type: INCREMENT });
export const decrement = () => ({ type: DECREMENT });
export const reset = () => ({ type: RESET });
// 액션 생성 함수는 특정 액션 타입을 반환하는 함수입니다.
// increment, decrement, reset 함수는 각각 INCREMENT, DECREMENT, RESET 타입의 액션 객체를 반환합니다.
// 이러한 액션 객체는 리듀서에 의해 처리되며, 상태 변화가 발생하게 됩니다.

// 3. 초기값
const initialState = { count : 0 };
// initialState는 리듀서가 관리할 상태의 초기값을 정의한 객체입니다.
// 여기서는 count가 0인 초기 상태를 설정하고 있습니다.
// 리덕스 스토어가 처음 생성될 때, 이 초기값이 count 상태의 기본값으로 사용됩니다.

// 4. 리듀서 만들기
const reducer = (state = initialState, action) => {
     switch(action.type){
          case INCREMENT: return { ...state, count: state.count + 1 };
          // INCREMENT 액션이 디스패치되면 count 상태가 1 증가합니다.
          // ...state는 기존 상태를 그대로 유지하고, count만 수정합니다.
          // 이는 불변성을 유지하면서 상태를 업데이트하는 방법입니다.
          // case INCREMENT: return { count: state.count +1 };

          case DECREMENT: return { ...state, count: state.count - 1 };
          // DECREMENT 액션이 디스패치되면 count 상태가 1 감소합니다.
          // 불변성을 유지하면서 count 값을 업데이트합니다.

          case RESET: return { ...state, count: 0 };
          // RESET 액션이 디스패치되면 count 상태가 0으로 초기화됩니다.
          // 이는 상태를 초기 상태로 되돌리는 기능을 수행합니다.

          default: return state;
          // 리듀서는 항상 기본 상태를 반환해야 합니다.
          // 만약 액션 타입이 일치하지 않으면, 현재 상태를 그대로 반환하여 상태를 유지합니다.
     }
};

export default reducer
// 리듀서를 export default로 내보내면, 다른 파일에서 import하여 이 리듀서를 사용할 수 있습니다.
// 리덕스 스토어는 이 리듀서를 통해 count 상태를 관리하게 됩니다.
