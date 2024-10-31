// components/CoffeeResult.jsx
import React from 'react';
import { useSelector } from 'react-redux';
import styles from '../css/CoffeeResult.module.css';

const CoffeeResult = () => {

    const { items, show } = useSelector(state => state.coffee);
    
    if (!show) return null;

    const selected = items.filter(it => it.qty > 0);
    const total = selected.reduce((sum, it) => sum + it.price * it.qty, 0);

    return (
        <div className={styles.container}>
            <h2 className={styles.header}>영수증</h2>
            <table className={styles.table}>
                <thead>
                    <tr className={styles.headerRow}>
                        <th>😜 품목</th>
                        <th>🍵 수량</th>
                        <th>✅ 총합</th>
                    </tr>
                </thead>
                <tbody>
                    {selected.map(it => (
                        <tr key={it.id} className={styles.row}>
                            <td className={styles.itemName}>{it.name}</td>
                            <td className={styles.itemQty}>🍵 {it.qty} 잔</td>
                            <td className={styles.itemTotal}>✅ { (it.price * it.qty).toLocaleString() } 원 </td>
                        </tr>
                    ))}
                </tbody>
                <tfoot>
                    <tr>
                        <td colSpan="2" className={styles.totalLabel}>전체 합계</td>
                        <td className={styles.totalAmount}>{ total.toLocaleString() } 원</td>
                    </tr>
                </tfoot>
            </table>
        </div>
    );
};

export default CoffeeResult;

/* 
주석 설명:

1. **`useSelector` 사용**:
   - `useSelector`는 Redux 상태에서 필요한 데이터를 선택하여 컴포넌트에서 사용할 수 있게 합니다.
     여기서는 `items`와 `office` 상태를 가져옵니다.
   - `items`는 각 커피 상품의 정보를 담은 배열로, 상품명, 가격, 수량 등의 정보가 포함됩니다.
   - `office`는 주문이 완료되었는지 여부를 나타내는 불리언 값입니다. `office`가 `true`일 때만 영수증이 표시되도록 조건을 설정합니다.
   - **추가 설명**: Redux의 `useSelector`는 현재 상태값을 가져올 때 사용됩니다. 여기서는 `state.coffee`에서 
     `items`와 `show`를 받아와서, 상품 정보와 영수증 표시 여부를 결정하는데 사용합니다.
   - **추가 설명2**: `useSelector`는 Redux의 상태에서 필요한 부분만 선택하여 가져오는 역할을 합니다. 이 코드에서는 `items` 배열과 `show` 불리언 값을 가져와, 조건에 따라 컴포넌트를 렌더링하거나 렌더링하지 않도록 제어합니다. 상태의 특정 부분만 가져오므로 컴포넌트의 불필요한 리렌더링을 줄이는 데도 도움이 됩니다.

2. **주문 완료 상태 확인**:
   - `if (!office) return null;` 조건문을 사용하여, `office`가 `true`가 아닌 경우 컴포넌트가 렌더링되지 않도록 합니다.
     즉, 주문이 완료되지 않은 경우 영수증을 표시하지 않도록 설정하여 불필요한 렌더링을 방지합니다.
   - **추가 설명**: `show`가 `false`라면 컴포넌트가 null을 반환하여 아무것도 렌더링하지 않습니다. 이를 통해 
     불필요한 DOM 요소가 렌더링되는 것을 방지하고 성능을 최적화합니다.
   - **추가 설명2**: `show`는 영수증을 렌더링할지 결정하는 플래그로, `false`일 경우 `null`을 반환해 컴포넌트 자체를 렌더링하지 않도록 합니다. 이를 통해 DOM에 불필요한 요소가 생기지 않으며, 상태 변화에 따라 효율적인 렌더링 제어가 가능합니다.

3. **주문된 항목 필터링**:
   - `const selected = items.filter(it => it.qty > 0);`는 수량(`qty`)이 0보다 큰 상품만 필터링하여 
     `selected` 배열에 저장합니다. 이렇게 함으로써, 주문하지 않은 상품은 영수증에 표시되지 않게 됩니다.
   - `selected` 배열에는 실제 주문된 상품만 포함되며, 이를 기반으로 영수증에 표시할 데이터를 준비합니다.
   - **추가 설명**: `filter`는 조건에 맞는 요소만 배열에 포함시키므로, 주문 수량이 0보다 큰 경우만 영수증에 표시됩니다. 
     이를 통해 사용자에게 필요한 정보만 전달할 수 있습니다.
   - **추가 설명2**: `filter` 메서드는 배열을 반복하며, 조건에 맞는 요소만 새로운 배열로 반환합니다. `qty > 0` 조건에 맞는 상품만 `selected` 배열에 저장해 실제로 주문된 항목만 영수증에 표시될 수 있도록 관리합니다. 이는 불필요한 정보를 배제하여 사용자가 필요한 정보만 확인할 수 있게 돕습니다.

4. **합계 계산**:
   - `const total = selected.reduce((sum, it) => sum + it.price * it.qty, 0);`는 `selected` 배열에 있는 모든 상품의 
     총액을 계산하여 `total` 변수에 저장합니다.
   - `reduce` 함수를 사용해 각 상품의 `price * qty`를 누적하여 총합을 구하며, 초기값은 `0`으로 설정합니다.
   - 이렇게 계산된 `total` 값은 영수증의 전체 합계 부분에 표시됩니다.
   - **추가 설명**: `reduce` 함수는 배열을 누적하여 하나의 값으로 반환하는 함수로, `price * qty`를 더해 전체 금액을 계산합니다. 
     `0`은 초기값이며, 모든 상품의 합계를 구하는 데 유용합니다.
   - **추가 설명2**: `reduce`는 `sum`이라는 누적값을 유지하며 배열을 반복하여 합계를 계산하는 함수로, `selected` 배열의 모든 항목의 `(price * qty)` 값을 합산하여 최종 주문 금액을 `total` 변수에 저장합니다. 이를 통해 전체 주문 금액을 쉽게 계산할 수 있습니다.

5. **테이블 구조**:
   - `<table>` 요소는 주문된 항목과 그 합계를 정리해 보여주기 위해 사용됩니다.
   - `<thead>`: 테이블의 헤더 부분으로, 각 열의 제목인 "품목", "수량", "총합"을 표시합니다.
   - `<tbody>`: `selected.map()`을 사용해 실제 주문된 각 상품의 정보를 테이블 행으로 표시합니다. 
     각 행에는 상품명, 수량, 총합(단가 * 수량)이 포함됩니다.
   - `<tfoot>`: 전체 합계를 표시하는 행으로, `colSpan="2"`를 사용하여 두 개의 셀을 합쳐 합계가 가운데 정렬되도록 합니다.
     `totalAmount` 클래스가 적용되어 전체 합계 금액이 강조되어 표시됩니다.
   - **추가 설명**: `map()` 함수는 `selected` 배열의 각 항목을 반복하며, 상품명과 수량, 총액을 행으로 나타냅니다. 
     `tfoot`을 사용해 전체 금액을 합계 행에 표시하고 시각적 강조를 통해 사용자가 합계 정보를 쉽게 파악하도록 돕습니다.
   - **추가 설명2**: `<thead>`와 `<tbody>`는 테이블의 구조를 시각적으로 명확히 하며, 각 항목과 전체 합계를 시각적으로 구분해줍니다. `tfoot`에는 전체 주문 금액을 표시하여 사용자가 쉽게 파악할 수 있도록 돕습니다. `colSpan` 속성은 셀을 합쳐 테이블 레이아웃을 조정하는 데 유용하며, 합계 부분을 강조하기 위해 `className`을 통해 별도의 스타일이 적용됩니다.
*/