import React from 'react';
import Time from './Time';

import Count from './components/Count';
import CountProvider from './contexts/CountContext';

import Color from './components/Color';
import ColorProvider from './contexts/ColorContext';

import ChangeColor from './components/ChangeColor';
import ChangeCount from './components/ChangeCount';
import ChangeColorProvider from './contexts/ChangeColorContext';
import ChageCountProvider from './contexts/ChangeCountContext';

import Counter from './components/Counter';
import CounterProvider from './contexts/CounterContext';
import ToggleProvider from './contexts/ToggleContext';

import Todos from './components/Todos';
import TodosProvider from './contexts/TodosContext';

const App = () => {
  return (
    <div style={{
      background: 'linear-gradient(128deg, #d3bfeb, #bcd9f5)', 
      fontFamily: 'Orbitron', 
      textAlign: 'center' 
    }}>
      <div>
          <br/>
              <Time />
          <br/>
          {/* Context 를 사용할 컴포넌트 -> 상위 컴포넌트에서 Provider 로 감싸주어야 한다.
              Provider 의 모든 하위 컴포넌트가 얼마나 깊이 위치에 있는지 상관없이 Context의 데이터를 읽을 수 있다. */}
          {/* CountProvider로 Count 컴포넌트를 감싸줌으로써 Count 컴포넌트에서 count 상태와 관련 함수들을 사용할 수 있게 된다. */}
          {/* Count 컴포넌트는 CountProvider에 의해 감싸져 있으며, 이를 통해 count 상태와 관련 함수들을 사용할 수 있다. */}
{/* 
              <CountProvider>
                <Count />
              </CountProvider>

          <br/>

              <ColorProvider>
                <CountProvider>
                  <Color />
                </CountProvider>
              </ColorProvider>

          <br/>

              <ChangeColorProvider>
                <ChageCountProvider>
                    <ChangeColor />
                    <br/>
                    <ChangeCount />
                </ChageCountProvider>
              </ChangeColorProvider>

          <br/>

              <CounterProvider>
                <ToggleProvider>
                    <Counter />
                </ToggleProvider>
              </CounterProvider>
 */}
          <br/>

                <TodosProvider>
                  <ColorProvider>
                    <CountProvider>
                      <Todos />
                      <br/>
                      <Color />
                      <br/>
                      <Count />
                    </CountProvider>
                  </ColorProvider>
                </TodosProvider>

          <br/>
      </div>
    </div>
  );
};


export default App;

/*
Context 
- context를 이용하면 단계마다 일일이 props를 넘겨주지 않고도 컴포넌트 트리 전체에 데이터를 제공할 수 있다. 
- context는 React 컴포넌트 트리 안에서 전역적(global)이라고 볼 수 있는 데이터를 공유할 수 있도록 고안된 방법이다.
  이러한 데이터로는 현재 로그인한 유저 정보, 테마(어두운 모드/밝은 모드), 사용자가 선택한 언어 등의 설정이 있다.
 
- React 애플리케이션에서 데이터는 일반적으로 props를 통해 부모에서 자식 컴포넌트로 전달된다. 
  하지만 여러 컴포넌트에 공통으로 필요한 데이터를 관리할 때, props로만 전달하는 것은 복잡해질 수 있다.
  Context를 사용하면 이러한 과정을 단순화하여, props 없이도 컴포넌트 트리 전체에 데이터를 제공할 수 있다.

 => Context를 사용하여 전역적으로 데이터를 관리하면, 데이터가 필요할 때마다 props를 통해 전달할 필요 없이
    필요한 컴포넌트가 Context에서 직접 데이터를 가져올 수 있어 편리하다.
    
 Context API 사용을 위해 필요한 주요 개념:
  ① createContext : context 객체를 생성한다.
     - createContext 함수는 Provider와 Consumer 컴포넌트를 반환하며, Provider는 데이터를 공급하고,
       Consumer는 공급된 데이터를 사용하는 컴포넌트이다.
     - initialValue: Provider를 사용하지 않았을 때 적용될 초기값을 설정할 수 있다.

  ② Provider : 생성한 context를 하위 컴포넌트에게 전달하는 역할을 한다.
     - Provider는 context 데이터를 사용하려는 모든 하위 컴포넌트를 감싸야 한다.
     - Provider의 value 속성을 통해 전달할 데이터를 지정할 수 있으며, 이 값이 바뀌면 하위 Consumer 컴포넌트들이 갱신된다.

  ③ Consumer : context의 변화를 감시하며 데이터를 불러오는 컴포넌트이다.
     - Provider로부터 전달된 데이터를 사용하기 위해 Consumer를 통해 데이터를 불러온다.
     - Consumer 컴포넌트는 function을 children으로 받으며, 그 function의 매개변수로 value에 접근할 수 있다.
     - 이로 인해 하위 컴포넌트가 직접 props 없이 Context 데이터에 접근할 수 있게 된다.
  
 useContext 훅:
 - useContext를 사용하면 Consumer 컴포넌트를 사용하는 것보다 더 간단하게 context에 접근할 수 있다.
 - 기존의 Consumer 방식보다 코드가 간결하고 가독성이 좋아지며, useState와 useEffect와 조합하여 사용하기에도 편리하다.

 - 중요한 점:
    1) Provider의 value 값이 변경되면, 해당 Context를 사용 중인 모든 컴포넌트가 리렌더링된다.
    2) 이로 인해 불필요한 리렌더링을 방지하기 위해, Provider의 value 값을 메모이제이션할 필요가 있다.
       예를 들어, useMemo 훅을 사용하여 value 값을 캐시하면 리렌더링을 최적화할 수 있다.

 npm install react-router-dom / yarn add react-router-dom
  - 페이지 라우팅을 도와주는 패키지로, URL에 따라 다른 화면을 보여줄 수 있다.
  - 특히, React SPA(Single Page Application)에서는 react-router-dom을 통해 페이지 전환을 관리한다.
 npm install axios / yarn add axios
  - HTTP 요청을 손쉽게 보낼 수 있는 라이브러리로, REST API를 호출하여 데이터를 주고받을 때 자주 사용된다.


*/


