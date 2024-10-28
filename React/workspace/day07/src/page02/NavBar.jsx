import React, { useState } from 'react'; 
// React와 useState 훅을 import 합니다. useState는 컴포넌트 내에서 상태 관리에 사용됩니다.

import data from './navData'; 
// 외부 파일에서 navData 데이터를 import합니다. 이 파일은 네비게이션 링크의 제목과 경로를 정의한 데이터 배열을 포함합니다.

import style02 from '../css/style02.module.css'; 
// CSS 모듈 파일(style02.module.css)을 import하여 네비게이션 컴포넌트에 스타일을 적용합니다.

import { Link } from 'react-router-dom'; 
// Link 컴포넌트를 import하여 SPA(Single Page Application) 방식으로 페이지 이동 시 새로고침 없이 부드럽게 화면 전환을 가능하게 합니다.

const NavBar = () => {
     const [ nav, isNav ] = useState(false); 
     // nav: 현재 메뉴의 상태를 나타내는 변수로, false로 초기화되어 메뉴가 닫힌 상태를 나타냅니다.
     // isNav: nav 상태를 변경하는 함수. useState(false)는 초기 상태를 닫힘(false)으로 설정합니다.

     const onToggle = () => {
          isNav(!nav); 
          // onToggle 함수는 isNav 함수를 호출하여 nav 상태를 반전시킵니다.
          // nav가 true면 false로, false면 true로 변경합니다.
     };

     return (
          <div className={style02.navbar}> 
               {/* navBar 컴포넌트의 최상위 요소로, CSS 모듈 클래스 navbar를 적용하여 스타일링을 추가합니다.
                    스타일 적용 시, 모듈을 사용하므로 style02 객체의 속성으로 클래스명을 지정합니다. */}

               <p className={style02['all-menu']} onClick={ onToggle }>
                    menu 
                    {/* 'menu'라는 텍스트를 가진 p 태그. 사용자가 이 메뉴를 클릭하면 onToggle 함수가 호출되어 메뉴의 표시 여부가 전환됩니다.
                         'all-menu' 클래스도 CSS 모듈 방식으로 style02 객체에서 가져옵니다. */}
               </p>

               <nav className={ `${style02.nav} ${ nav ? style02.on : '' }` }>
                    {/* true 시 nav on 이 되고, false 시 공백으로 둔다. */}
                    {/* 이를 통해 css 구현 */}
                    {/* 'nav' 클래스를 적용하고, nav 상태가 true일 때는 'on' 클래스를 추가하여, 
                         상태에 따라 CSS 스타일이 적용됩니다. nav가 true일 때 메뉴가 열리고, false일 때 닫힙니다.
                         이때 on 클래스도 CSS 모듈의 style02 객체에서 가져옵니다. */}

                    <ul>
                         {/* data 파일을 [] 로 잡았기에 map 으로 구현 가능 */}
                         {/* data 배열을 map 함수로 순회하여 각 항목에 대해 li 요소를 생성합니다. 
                              map은 배열의 각 항목을 순회하여 반복 렌더링이 가능하게 합니다. */}

                         {
                              data.map(( item, index ) => <li key={ index }> 
                                   {/* data 배열의 각 요소마다 고유한 li 요소를 생성하며, map 메서드의 index를 key로 사용하여 
                                        React의 각 요소 식별에 도움을 줍니다. */}
                                   <Link to={ item.path }> { item.title } </Link> 
                                   {/* Link 컴포넌트를 사용하여 to 속성에 경로를 설정, 페이지 새로고침 없이 부드럽게 이동합니다.
                                        item.path와 item.title은 각각 경로와 링크의 텍스트를 정의한 data 파일의 요소입니다. */}
                              </li>)
                         }
                    </ul>

                    <p className={style02.close} onClick={ () => isNav(false) }> X </p>
                    {/* 'X' 버튼을 클릭하면 onClick 이벤트가 발생하여 isNav(false)를 호출하여 nav 상태를 false로 설정하고 메뉴를 닫습니다.
                         사용자가 메뉴를 닫고자 할 때 사용할 수 있는 닫기 버튼으로, 닫힘 동작을 명시적으로 처리합니다.
                         close 클래스도 CSS 모듈 방식으로 style02 객체에서 가져옵니다. */}
               </nav>
          </div>
     );
};

export default NavBar; 
// NavBar 컴포넌트를 export하여 다른 파일에서 import하여 사용할 수 있도록 합니다.
