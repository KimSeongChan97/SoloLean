import React from 'react';
import Time from './Time';
import App01 from './App01'; 
import App02 from './App02';
import App03 from './App03';
import App04 from './App04';
import App05 from './App05';

const App = () => {
  return (
    <div style={{
      background: 'linear-gradient(115deg, #d3bfeb, #bcd9f5)', 
      fontFamily: 'Orbitron', 
      textAlign: 'center' 
    }}>
      <div>
        <hr/>
        <Time />
        {/* <hr/>
        <App01 />
        <hr/>
        <App02 />
        <hr/>
        <App03 />
        <hr/>
        <App04 /> */}
        <hr/>
        <App05 />
        <hr/>
      </div>
    </div>
  );
};

export default App; 


/*
index.html (화면에 보이는 파일): 애플리케이션의 루트 HTML 파일로, 최상위 문서입니다.
  - 모든 리액트 컴포넌트가 이 문서의 루트 div에 렌더링됩니다.
index.js: React 애플리케이션의 진입점입니다.
  - ReactDOM을 통해 index.html의 루트 div에 React 컴포넌트를 렌더링합니다.
App.js: 최상위 App 컴포넌트를 정의하는 파일로, 애플리케이션의 기본 레이아웃을 제공합니다.
  - 전체 앱을 포함하는 최상위 컴포넌트로, App01과 같은 다른 주요 컴포넌트를 포함하여 구조를 구성합니다.
App01.jsx: App 컴포넌트 내부에 포함되는 컴포넌트로, 다른 페이지들을 구조화하고 구성하는 역할을 합니다.
  - App 컴포넌트 내에서 구체적인 기능을 수행하는 하위 컴포넌트
      page01 (components): App01의 자식 컴포넌트를 모아 둔 디렉토리로, 다양한 페이지별 구성 요소를 포함합니다.
        - About.jsx: 소개 페이지의 내용을 렌더링하는 컴포넌트입니다.
        - Home.jsx: 메인 페이지 또는 시작 페이지를 구성하는 컴포넌트입니다.
        - Ceo.jsx: CEO 소개 페이지 컴포넌트입니다.
        - NotFiles.jsx: 파일을 찾을 수 없는 경우에 표시되는 컴포넌트입니다.
        - Sub01.jsx: 보조 페이지를 구성하는 컴포넌트로, 특정 세부 정보를 표시할 때 사용됩니다.
  App02.jsx
      page02 (components)
        - About.jsx
        - Home.jsx
        - Ceo.jsx
        - NotFiles.jsx
        - Sub01.jsx
        - NavBar.jsx
        - navData.jsx
  App03.jsx
      page03 (components)
        - About.jsx
        - Home.jsx
        - Ceo.jsx
        - NotFiles.jsx
        - Sub01.jsx
  ..

*/

/*

React-Router

1. React는 SPA (Single Page Application) 방식입니다. 
  - 기존 웹 페이지는 MPA(Multi-Page Application) 방식으로, 각 요청에 따라 서버에서 새로운 페이지를 응답합니다. 
  - 그러나 React는 모든 페이지가 한 번에 로드되며, 사용자가 페이지 간에 이동할 때마다 새로 로드하지 않고 필요한 데이터만 가져와 처리합니다.
  - 이로 인해 반응 속도가 빨라지고 사용 경험이 매끄럽습니다.
  
2. React Router는 사용자가 입력한 주소를 감지하고 해당 경로에 맞는 컴포넌트를 표시해주는 역할을 합니다.
  - 다양한 환경에 적합한 BrowserRouter와 HashRouter 등 여러 종류의 라우터 컴포넌트를 제공합니다.
  [설치]
  npm install react-router-dom // react-router-dom 패키지를 설치하여 React 애플리케이션에 라우팅 기능을 추가합니다.
  yarn add react-router-dom // npm을 사용하는 대신 yarn으로 동일한 패키지를 설치할 수 있습니다.

# react-router-dom의 주요 변경사항 (2021. 11. 25 기준)
1. Routes로 Route 컴포넌트를 감싸야 합니다. 
   - 여러 Route 컴포넌트를 하나의 Routes로 묶어 관리하여 더욱 체계적으로 설정할 수 있습니다.
2. Route 컴포넌트의 매개변수가 component에서 element로 변경되었습니다. 
   - 컴포넌트를 지정할 때 element 속성을 사용하여 지정합니다.
3. useHistory 대신 useNavigate 훅을 사용해야 합니다. 
   - useHistory는 더 이상 사용되지 않고, 페이지 이동에 사용하는 훅이 useNavigate로 대체되었습니다.
4. history.push('/') 대신 navigate('/')로 변경되었습니다. 
   - 특정 경로로의 이동 시 history.push가 아닌 navigate 함수를 사용하여 간편하게 이동을 구현합니다.

주요 라우팅 요소:
Route: 특정 경로에 접근했을 때 어떤 컴포넌트를 표시할지 정의합니다.
Link: a 태그와 비슷한 기능을 하지만 페이지 리로드 없이 경로를 변경합니다.
 - Link 컴포넌트를 사용하여 SPA의 장점을 살려 페이지 리로드 없이 원하는 컴포넌트로 이동할 수 있습니다.
 
: 동적 URL 파라미터로 설정 가능하며, 이를 통해 페이지 이동 시 파라미터를 전달할 수 있습니다.
  - 예를 들어 `:name`이라는 파라미터는 name 키로 전달된 값을 불러와 컴포넌트 내에서 사용할 수 있습니다.

  Route : 어떤 경로로 들어왔을 때 어떤 컴포넌트를 보여 주겠다
  Link : Router의 주소를 바꿈, a 태그지만 새로 고침이 안 된다.
: style 를 route path에 사용하면 useParams() 로 불러와 사용할 수 있다.
: 뒤에 나오는 부분이 params의 key 부분이 되어 :name 는 name가 key가 되어 불러오고 있다. 
  
1. Link
 - 바로 이동하는 로직을 구현할 때 Link 컴포넌트가 유용합니다. 
   - 예) 상품 리스트에서 상세 페이지로 이동할 때
 - Link는 a 태그로 변환되지만, 외부 프로젝트가 아닌 내부 경로 이동에 사용됩니다.
 - 외부 사이트로 이동할 때는 a 태그를, 내부 페이지 전환에는 Link를 사용합니다.
 
2. useNavigate
 - 페이지 이동을 구현할 때 사용하는 훅으로 navigate 함수를 반환합니다.
 - navigate 함수에 이동 경로를 넘겨주면 해당 경로로 이동합니다.
 - 페이지 전환 시 추가로 수행할 작업이 있을 경우 사용됩니다.
   예) 로그인 버튼 클릭 시 
     - 회원가입된 사용자는 Main 페이지로 이동
     - 미가입자는 SignUp 페이지로 이동

Index Routes:
 - Route 컴포넌트에 index 속성을 설정하면 부모 Route의 기본 자식 Route로 동작합니다.
 - 예를 들어 부모 Route에 여러 자식 Route가 있을 때 기본적으로 로드될 경로를 지정하는 데 유용합니다.
 - 부모 경로에서 + '/' 인 경우 설정

*/
