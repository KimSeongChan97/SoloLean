import React from 'react';
import Time from './Time';
import Color from './components/Color';
import Count from './components/Count';
import Animal from './components/Animal';
import CoffeeResult from './components/CoffeeResult';
import CoffeeOrder from './components/CoffeeOrder';

const App = () => {
  return (
    <div style={{
      background: 'linear-gradient(115deg, #d3bfeb, #bcd9f5)', 
      fontFamily: 'Orbitron', 
      textAlign: 'center' 
    }}>
        <div>
          <br/>
          <Time />
          {/*
          <br/>
           <Color />  
          <br/>
          <Count />
          <br/>
          <Animal />
          <br/> */}
          <br/>
          <CoffeeOrder />
          <br/>
          <CoffeeResult />
          <br/>
          
          <br/>
          
          <br/>
        </div>
    </div>
  );
};

export default App;

/*

Redux
- 리덕스를 사용하면 컴포넌트들의 상태 관련 로직들을 다른 파일들로 분리시켜서 더욱 효율적으로 관리할 수 있으며, 글로벌 상태 관리도 손쉽게 할 수 있다. 
   - Redux를 사용하면 애플리케이션의 상태 관리를 컴포넌트 외부에서 제어할 수 있다.
   - 이를 통해 여러 컴포넌트 간에 상태를 공유하거나 중앙에서 제어할 수 있다.
 - 상태값을 컴포넌트에 종속시키지 않고, 상태 관리를 컴포넌트의 바깥에서 관리할 수 있게 된다. 
 - Redux와 React는 독립적으로 사용될 수 있는 별개의 다른 라이브러리이다. 
 - Redux는 자바스크립트 어플리케이션에서 흔히 쓰이는 상태관리 라이브러리이다.
   - Redux는 Angular, Vue, Ember, jQuery 또는 Vanilla JavaScript와 같은 다른 라이브러리, 프레임워크에서도 사용할 수 있다.

store
- 모두 한 곳에서 집중 관리
- 컴포넌트와는 별개로 스토어라는 공간이 있어서 그 스토어 안에 앱에서 필요한 상태를 담는다. 
   - 스토어는 애플리케이션의 중앙 상태 저장소로, 모든 컴포넌트가 스토어에 접근하여 필요한 상태를 가져오거나 변경할 수 있다.
- 컴포넌트에서 상태 정보가 필요할 때 스토어에 접근한다. 

action
- Action(액션)은 앱에서 스토어에 운반할 데이터를 말한다. (주문서) 
   - Action은 상태를 변경하고자 할 때, 스토어에 전달되는 데이터로, Redux에서는 이를 통해 상태가 어떻게 변경되어야 하는지를 정의한다.
- Action(액션)은 자바스크립트 객체 형식으로 되어있다. 

reducer 
- Action(액션)을 Store(스토어)에 바로 전달하는 것이 아니다. 
- Action(액션)을 Reducer에 전달해야 한다. 
- Reducer가 주문을 보고 Store의 상태를 업데이트하는 것이다. 
- Action을 Reducer에 전달하기 위해서는 dispatch() 메소드를 사용해야 한다. 
① Action(액션) 객체가 dispatch() 메소드에 전달된다. 
② dispatch(액션)를 통해 Reducer를 호출한다.
③ Reducer는 새로운 Store를 생성한다. [설치]

yarn add react-redux ( npm install react-redux / npm i react-redux )
yarn add redux ← 리덕스가 제대로 설치가 안 되면 또 한 번 한다.
yarn add redux-devtools-extension ( npm i redux-devtools-extension )

createStore
앱의 상태 트리 전체를 보관하는 Redux 저장소를 만든다.
앱 내에는 단 하나의 저장소만 있어야 한다. 
앱에 하나 이외의 저장소를 만들지 않는다. 
 -> 대신 여러 개의 리듀서를 하나의 루트 리듀서로 만들기 위해 combineReducers를 사용한다.

반환
앱의 전체 상태를 가지고 있는 객체이다. 
이 객체의 상태를 바꾸는 유일한 방법은 액션을 보내는 것뿐이다.
UI를 업데이트하기 위해 상태를 구독 할 수도 있다.


*/