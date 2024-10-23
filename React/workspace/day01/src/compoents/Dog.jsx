import React from 'react';

// Dog라는 컴포넌트를 정의하는 부분입니다. 이 컴포넌트는 JSX로 렌더링되며, React 컴포넌트는 대문자로 시작하는 것이 관례입니다.
const Dog = () => {
    return (
        <div>
            {/* 이 부분은 실제로 화면에 표시되는 HTML 구조를 정의합니다. <div>는 모든 콘텐츠를 감싸는 컨테이너입니다. */}
            <h1>Dog 컴포넌트 입니다.</h1> 
            {/* <h1> 태그는 제목을 표시하는데 사용됩니다. 여기서는 "Dog 컴포넌트 입니다."라는 텍스트가 큰 글씨로 표시됩니다. */}
        </div>
    );
};

export default Dog;
// 이 부분은 이 컴포넌트를 외부에서 사용할 수 있도록 내보내는 구문입니다. export default를 사용하면 다른 파일에서 이 컴포넌트를 import하여 사용할 수 있습니다.
