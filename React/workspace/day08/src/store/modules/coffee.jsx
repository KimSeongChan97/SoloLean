// 1. 액션 생성
const UPDATE_QTY = 'coffee/UPDATE_QTY';
const SUBMIT = 'coffee/SUBMIT';
const RESET = 'coffee/RESET';

// 2. 액션 보내기 ( action 객체 )
export const updateQty = (id, qty) => ({ type: UPDATE_QTY, id, qty });
export const submit = () => ({ type: SUBMIT });
export const reset = () => ({ type: RESET });

// 3. 초기값
const initialState = {
    items: [
        { id: 1, name: '아메리카노', price: 1500, qty: 1 },
        { id: 2, name: '라떼', price: 2300, qty: 1 },
        { id: 3, name: '카푸치노', price: 2000, qty: 1 },
        { id: 4, name: '모카', price: 2500, qty: 1 },
        { id: 5, name: '딸기라떼', price: 3000, qty: 1 },
        { id: 6, name: '초코프라페', price: 3500, qty: 1 }
    ],
    show: false
};

// 4. 리듀서 만들기
const coffee = (state = initialState, action) => {
    const { id, qty } = action;
    switch (action.type) {
        case UPDATE_QTY: return { ...state, items: state.items.map(item => item.id === id ? { ...item, qty: qty } : item )};
        case SUBMIT: return { ...state, show: true, items: state.items.filter(item => item.qty > 0)};
        case RESET: return initialState;
        default: return state;
    }
};

export default coffee;

/* 
주석 설명:

리덕스 리듀서 `coffee`: 
이 리듀서는 Redux 상태와 액션을 인자로 받아 상태를 업데이트하는 함수입니다. Redux 상태는 항상 불변성을 유지해야 하며, 이 리듀서도 이 규칙을 따릅니다. 
액션 객체에는 액션 타입(`action.type`)과 필요한 추가 데이터(`id`, `qty`)가 포함되어 있으며, 이를 기반으로 상태를 변경합니다.
 상태 변경은 각 액션 타입별로 다르게 수행됩니다.

1. **`UPDATE_QTY`**:
   - 특정 상품의 수량(`qty`)을 업데이트하기 위한 액션입니다.
   - `state.items.map()`을 사용해 `items` 배열의 각 상품을 순회하며, `item.id === id` 조건을 통해 전달받은 `id`와 일치하는 상품을 찾습니다.
   - 조건을 만족하는 경우, 해당 상품의 `qty`를 업데이트된 수량으로 변경하고 나머지 속성은 그대로 유지합니다.
   - `...item`으로 기존 `item` 객체의 속성을 모두 복사하고, `{ qty: qty }`를 추가하여 `qty` 속성만 업데이트하는 방식입니다.
   - **불변성 유지**: 리덕스에서 상태 변경 시 불변성을 유지해야 하므로, `state.items` 배열을 직접 수정하지 않고 새로운 배열을 생성하여 반환합니다. 
   이 새로운 배열에는 `qty`만 업데이트된 상품이 포함됩니다.

2. **`SUBMIT`**:
   - 주문 완료 상태를 설정하는 액션입니다.
   - `show` 값을 `true`로 설정하여 주문이 완료되었음을 나타냅니다.
   - `state.items.filter(item => item.qty > 0)`를 사용하여 수량(`qty`)이 0보다 큰 항목만 남기고, 수량이 0인 항목은 `items` 배열에서 제거합니다.
    이렇게 하면 주문하지 않은 상품들은 영수증에서 제외되게 됩니다.
   - `filter` 함수는 원래 배열을 수정하지 않고 새로운 배열을 반환하므로, `state.items`의 불변성을 유지할 수 있습니다.
   - 이 상태가 설정되면 `show`가 `true`가 되어 주문 완료 상태로 변환됩니다.

3. **`RESET`**:
   - 상태를 초기값으로 되돌리는 액션입니다. 
   - `initialState`를 반환하여 모든 수량과 주문 상태가 초기 상태로 리셋됩니다.
   - 여기서 `initialState`는 리듀서의 최상단에 정의된 초기값 객체로, 각 항목의 수량(`qty`)이 0이고 `show`는 `false`로 설정된 상태입니다.
   - `initialState`를 직접 반환하므로 상태 전체가 초기화되며, 새로운 주문을 시작할 수 있게 됩니다.

4. **`default`**:
   - 액션 타입이 위에 정의된 타입(`UPDATE_QTY`, `SUBMIT`, `RESET`)과 일치하지 않는 경우, 기본적으로 현재 상태(`state`)를 그대로 반환합니다.
   - 이는 예기치 않은 액션이 들어왔을 때 상태가 의도치 않게 변경되는 것을 방지하며, 안전성을 높입니다.
   - 이 기본 반환 방식은 리덕스 리듀서의 표준 관행입니다. 상태는 변경되지 않으며 그대로 유지됩니다.

### 상태 관리와 불변성:
각 액션 타입에 따라 상태가 다르게 업데이트되며, Redux의 원칙을 따라 상태 불변성을 유지하기 위해 
`...state`, `...item` 같은 스프레드 연산자를 사용하여 기존 객체의 복사본을 반환하는 방식을 사용합니다.
 이는 리덕스 애플리케이션에서 상태 변화가 추적 가능하고 디버깅이 용이하도록 하기 위함입니다.

*/