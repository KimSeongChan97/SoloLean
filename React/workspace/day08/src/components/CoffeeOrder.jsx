// components/CoffeeOrder.jsx
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { updateQty, submit, reset } from '../store/modules/coffee';
import styles from '../css/CoffeeOrder.module.css';

const CoffeeOrder = () => {
    const dispatch = useDispatch();
    const items = useSelector(state => state.coffee.items);

    const QtyChange = (id, event) => {
        // const qty = parseInt(event.target.value); 
        const qty = parseInt(event.target.value, 10) || 0; // 입력값이 숫자가 아닌 경우(빈값,문자) 일때 0 으로 처리 
        dispatch(updateQty(id, qty));
    };

    return (
        <div className={styles.container}>
            <table className={styles.table}>
                <thead>
                    <tr className={styles.headerRow}>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>주문 수량</th>
                    </tr>
                </thead>
                <tbody>
                    {items.map(it => (
                        <tr key={it.id} className={styles.row}>
                            <td className={styles.itemName}>{it.name}</td>
                            <td className={styles.itemPrice}>{it.price.toLocaleString()} 원</td>
                            <td>
                                <input
                                    type="number"
                                    value={it.qty}
                                    onChange={(e) => QtyChange(it.id, e)}
                                    className={styles.input}
                                />
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <button onClick={() => dispatch(submit())} className={styles.orderButton}>주문</button> &nbsp; &nbsp;
            <button onClick={() => dispatch(reset())} className={styles.orderButton}>재주문</button>
        </div>
    );
};

export default CoffeeOrder;

/* 
주석 설명:

1. **`useDispatch`와 `useSelector` 사용**:
   - `useDispatch`는 Redux의 `dispatch` 함수를 반환하여 컴포넌트 내에서 액션을 호출할 수 있게 해줍니다. 
     즉, `dispatch`를 통해 리덕스 상태를 변경할 수 있습니다.
   - `useSelector`는 리덕스 상태에서 필요한 데이터를 선택하여 가져오는 역할을 합니다. 
     여기서는 `state.coffee.items`로 접근하여 `items` 배열을 가져옵니다. 이 배열에는 각 커피 상품의 정보가 포함되어 있으며,
     각 상품의 `id`, `name`, `price`, `qty` 속성을 사용하여 화면에 표시합니다.
   - **추가 설명**: Redux는 전역 상태 관리 라이브러리로, `dispatch`는 상태를 변경하는 동작을 실행하게 해주며, 
     `useSelector`는 필요한 상태를 조회할 수 있게 합니다. 이를 통해 전역 상태를 일관되게 관리할 수 있습니다.
   - **추가 설명2**: `useDispatch`와 `useSelector`는 함수형 컴포넌트에서 Redux와 상호작용하기 위해 사용됩니다. `dispatch` 함수는 상태 변경을 트리거하는 방법으로, 사용자가 버튼을 클릭하거나 값이 변경될 때 상태 업데이트 요청을 보내기 위해 사용됩니다. `useSelector`는 전체 Redux 상태에서 특정 부분을 선택해 사용할 수 있게 도와주며, `state.coffee.items`를 통해 각 커피 상품의 정보 배열에 접근합니다. 이를 사용하여 Redux 스토어의 상태를 컴포넌트로 가져올 수 있습니다.

2. **`QtyChange` 함수**:
   - `QtyChange` 함수는 사용자가 수량 입력 필드에서 값을 변경할 때마다 호출됩니다.
   - `event.target.value`는 사용자가 입력한 값을 문자열로 가져옵니다. 
     `parseInt(event.target.value, 10)`을 사용해 이 값을 정수로 변환하여 숫자로 만듭니다.
   - `|| 0`를 추가하여 입력값이 비어있거나 숫자가 아닐 때 `qty`가 `0`이 되도록 설정합니다.
   - `dispatch(updateQty(id, qty))`는 특정 상품의 수량(`qty`)을 업데이트하는 액션을 리덕스에 전달합니다. `updateQty` 액션은 상품의 `id`와 변경된 수량을 인자로 받아 리덕스 상태를 업데이트합니다.
   - **추가 설명**: `parseInt`는 문자열을 숫자로 변환하는 함수로, 두 번째 인자는 진수(`10`은 십진수)를 의미합니다. 
     `dispatch`를 통해 특정 상품의 수량을 업데이트할 수 있어, Redux 상태가 바뀌면 관련 컴포넌트가 다시 렌더링됩니다.
   - **추가 설명2**: `QtyChange` 함수는 사용자가 입력한 값을 실시간으로 받아 처리하여, 입력한 수량이 없는 경우(`NaN`), 기본값으로 `0`을 설정하도록 `|| 0` 구문을 추가한 것이 특징입니다. 이 로직을 통해 예상치 못한 입력이 들어와도 Redux 상태가 안정적으로 유지됩니다. Redux의 `updateQty` 액션을 호출해 특정 상품의 수량을 업데이트하게 되며, 이 과정에서 `dispatch`가 트리거되어 전역 상태가 변경되고 리렌더링이 발생하여 화면에 즉각적으로 반영됩니다.

3. **`<table>` 구조**:
   - `<table>`은 상품 정보를 보여주는 테이블입니다.
   - `<thead>`와 `<tbody>`로 나뉘며, `<thead>`에는 테이블의 헤더(상품명, 가격, 주문 수량)를 정의합니다.
     이 행(`tr`) 안에 `<th>` 요소로 각 열의 제목이 들어가며, `className`을 통해 스타일을 지정합니다.
   - `<tbody>`에서는 `items.map()`을 사용하여 각 상품의 정보를 테이블의 행(`tr`)으로 출력합니다.
     각 상품의 `name`, `price`, `qty`는 `<td>` 태그로 출력되며, 
     `input` 요소를 통해 사용자가 직접 수량을 입력하여 조정할 수 있습니다.
   - **추가 설명**: `map()` 함수는 배열의 각 항목을 반복하여 원하는 요소로 변환하는 데 사용됩니다.
     여기서는 `items` 배열을 순회하며 각 상품을 테이블 행(`tr`)으로 변환합니다. `key={it.id}`는 
     각 행에 고유 식별자를 부여하여 리액트가 효율적으로 DOM을 관리할 수 있게 도와줍니다.
   - **추가 설명2**: 이 테이블은 `map()` 함수를 사용해 반복적으로 구성되며, Redux 상태의 `items` 배열을 순회해 각 상품 정보(`name`, `price`, `qty`)를 렌더링합니다. `key={it.id}`는 React가 각 요소를 고유하게 식별하도록 하여, 불필요한 재렌더링을 막고 효율적인 업데이트를 가능하게 합니다. 스타일 지정은 `className` 속성을 통해 CSS 모듈에서 정의된 스타일을 적용하는 방식으로 이루어져 있습니다.

4. **`<button>` 구조**:
   - `<button onClick={() => dispatch(submit())}>주문</button>`은 사용자가 주문 버튼을 클릭했을 때 
     `dispatch(submit())`를 호출하여 주문을 완료 상태로 설정합니다.
   - `<button onClick={() => dispatch(reset())}>재주문</button>`은 사용자가 재주문 버튼을 클릭했을 때 
     `dispatch(reset())`를 호출하여 리덕스 상태를 초기화합니다. 이를 통해 사용자는 다시 수량을 입력하고 주문할 수 있습니다.
   - **추가 설명**: `submit()`과 `reset()`은 Redux 액션으로, 각각 주문 완료와 상태 초기화 기능을 수행합니다. 
     각 버튼은 `onClick` 이벤트가 발생했을 때 특정 액션을 `dispatch`하여 상태 변경을 트리거합니다.
   - **추가 설명2**: `submit`과 `reset`은 Redux 스토어에 정의된 액션으로, `submit`은 사용자가 입력한 주문을 완료 상태로 만들고, `reset`은 이전 주문을 초기화해 사용자 입력을 초기 상태로 되돌립니다. `onClick` 이벤트 핸들러는 버튼 클릭 시 각 액션을 `dispatch`하는 역할을 수행해 Redux 스토어의 상태를 직접 변경합니다.
*/