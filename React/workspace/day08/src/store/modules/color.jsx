// 첫글자 소문자, 컴포넌트가 아니다

// 1. 액션 생성
// 중복 방지를 위해 모듈의 이름을 앞에 붙여주어서 액션명의 중복을 방지한다.
// 각 액션 타입 상수 정의, 예를 들어 'RED' 액션의 경우 'color/RED'로 명명하여
// 전체 애플리케이션에서 'RED'라는 이름이 중복되더라도 이 모듈 내에서는 'color/RED'로
// 구분되므로 충돌을 방지할 수 있다.
const RED = 'color/RED'; 
const GREEN = 'color/GREEN'; 
const BLUE = 'color/BLUE'; 
const MAGENTA = 'color/MAGENTA';

// 2. 액션 보내기 ( action 객체 )
// red, green, blue, magenta라는 이름의 함수들을 액션 생성 함수라고 한다.
// 각 함수는 type 속성만을 가진 객체를 반환하며, 이는 액션 객체라고 한다.
// 예를 들어, red() 함수를 호출하면 { type: 'color/RED' } 형태의 액션 객체가 반환된다.
export const red = () => ({ type: RED });
export const green = () => ({ type: GREEN });
export const blue = () => ({ type: BLUE });
export const magenta = () => ({ type: MAGENTA });

// 3. 초기값
const initialState = { color: 'hotpink' }; // 초기값 설정
// 초기 상태로 color 속성에 'hotpink' 값을 설정하였다. 이는 리듀서가 처음 호출될 때
// 현재 상태가 undefined라면 이 값을 사용하게 되어, 초기 상태로 'hotpink' 색상이 설정된다.

// 4. 리듀서 만들기
// state, action ( 상태변수 또는 객체, action 파라미터) : action 파라미터를 창조하여, 새로운 상태 객체를 만든다.
// 리듀서 함수는 두 개의 인자를 받는다: 현재 상태(state)와 액션(action)이다.
// state : 현재 상태
// action : action 객체
// 반드시 state 에게 초기값을 주어야 한다. (필수)
const reducer = (state = initialState, action) => {
    // 리듀서는 주어진 액션 타입에 따라 상태를 변경하거나 기존 상태를 유지하는 역할을 한다.
    switch(action.type){
        // action.type이 'color/RED'와 일치하면 color 속성이 'red'로 설정된 새로운 상태 객체를 반환한다.
        case RED: return { color: 'red' };
        // action.type이 'color/GREEN'와 일치하면 color 속성이 'green'으로 변경된 객체를 반환.
        case GREEN: return { color: 'green' };
        // action.type이 'color/BLUE'일 때 color 속성은 'blue'로 변경된다.
        case BLUE: return { color: 'blue' };
        // action.type이 'color/MAGENTA'라면 color 속성을 'magenta'로 설정한 새로운 객체 반환.
        case MAGENTA: return { color: 'magenta' };
        // default: state // 반드시 default 는 작성해야 한다 !!
        // action.type이 매칭되지 않는 경우(예: 잘못된 액션이 들어오는 경우), default 구문이 실행된다.
        // 현재의 상태(state)를 그대로 반환하여 아무 변경이 없음을 나타내며, default가 없을 경우 에러가 발생할 수 있다.
        default: return state;
    }
};

export default reducer // 컴포넌트가 아니라 순수 js 파일이다.
// reducer를 기본 내보내기(export default)로 설정하였으므로,
// 다른 파일에서 reducer를 import하여 사용할 수 있다.
