import React from 'react'; // React 라이브러리에서 React를 가져옵니다. 이는 JSX 구문을 해석하고 컴포넌트를 만들 때 필요합니다.
import ReactDOM from 'react-dom/client'; // React 18에서 도입된 'react-dom/client'에서 ReactDOM을 가져옵니다. 이 모듈은 애플리케이션을 실제 DOM에 렌더링하는 데 사용됩니다.
import './index.css'; // 전역 스타일 시트를 가져옵니다. 모든 컴포넌트에서 이 CSS 파일의 스타일을 적용받을 수 있습니다.
import App from './App'; // 최상위 컴포넌트인 App을 가져옵니다. 이 컴포넌트는 애플리케이션의 주요 UI 구조를 포함합니다.
import reportWebVitals from './reportWebVitals'; // 성능 측정을 위한 reportWebVitals 함수를 가져옵니다. 이 함수는 애플리케이션의 성능 지표를 기록하거나 분석 서버로 전송할 때 유용합니다.

// ---------------------- 임의로 추가하는 import
import { Provider } from 'react-redux'; // react-redux 라이브러리의 Provider 컴포넌트를 가져옵니다. Provider는 Redux 스토어를 React 애플리케이션에 공급하는 역할을 합니다.
import rootReducer from './store'; // 애플리케이션의 전체 상태 관리 로직을 정의한 rootReducer를 가져옵니다. rootReducer는 여러 리듀서를 결합한 최상위 리듀서입니다.

//import { createStore } from 'redux'; -> deprecated, 실행은 된다..
// createStore 함수는 Redux에서 스토어를 생성하는 데 사용됩니다. 이전 방식(createStore)은 더 이상 권장되지 않으므로 legacy_createStore로 사용합니다.
import { legacy_createStore as createStore } from 'redux'; // redux 라이브러리의 createStore 함수를 가져옵니다. 여기서는 이름을 legacy_createStore로 가져와 사용합니다.
import { composeWithDevTools } from 'redux-devtools-extension'; // Redux DevTools와의 연동을 돕는 composeWithDevTools를 가져옵니다. 이 함수는 브라우저의 Redux DevTools에서 애플리케이션의 상태를 디버그할 수 있도록 합니다.

//const store = createStore(rootReducer);
// Redux의 스토어를 생성합니다. 스토어는 애플리케이션의 전역 상태를 관리하는 객체로, rootReducer를 통해 상태와 액션을 연결합니다.
const store = createStore(rootReducer, composeWithDevTools()); // DevTools 확장 프로그램과 연결된 스토어를 생성합니다. composeWithDevTools를 사용하면 스토어의 상태를 DevTools에서 더 쉽게 추적하고 디버그할 수 있습니다.

// ----------------------

const root = ReactDOM.createRoot(document.getElementById('root')); // index.html 파일에서 'root'라는 id를 가진 DOM 요소를 찾아 root 변수에 할당합니다.
// 이 DOM 요소는 애플리케이션의 최상위 요소로, 모든 React 컴포넌트가 이 요소 안에 렌더링됩니다.

root.render(
    //  <React.StrictMode>
    //  </React.StrictMode>
    <Provider store={ store } > 
        {/* Provider 컴포넌트를 통해 Redux 스토어를 애플리케이션에 공급합니다. 
            Provider를 사용하면 <App /> 컴포넌트뿐만 아니라 그 하위 모든 컴포넌트가 Redux 스토어에 접근할 수 있습니다.
            이 방식은 Redux 상태 관리를 전역에서 손쉽게 사용할 수 있도록 설정해 줍니다. */}
        <App /> {/* <App /> 의 후손 까지 모두 store 사용해도 된다.(App 위에 걸었기 때문에) */}
    </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals(); // reportWebVitals 함수를 실행하여 애플리케이션의 성능을 측정합니다. 이 함수는 렌더링 속도와 같은 지표를 기록하여 애플리케이션 최적화에 도움을 줄 수 있습니다.
