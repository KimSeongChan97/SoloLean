const list = document.querySelectorAll('.list'); 
// querySelectorAll을 사용하여 클래스명이 'list'인 모든 요소를 선택하고, 'list'라는 변수에 NodeList로 저장합니다.
// 여기서 NodeList는 배열과 유사한 형태로, 선택된 요소들을 다룰 수 있게 해줍니다.

function activeLink() {
    // activeLink 함수는 특정 항목을 클릭했을 때 그 항목에 'active' 클래스를 추가하는 역할을 합니다.
    
    list.forEach((item) =>
    // list에 포함된 각 항목(item)에 대해 반복문을 실행합니다. 
    // forEach는 NodeList에 있는 각 요소에 대해 동일한 작업을 수행하게 해주는 메서드입니다.

    item.classList.remove('active'));
    // 반복문 안에서 각 항목에 대해 'active' 클래스를 제거합니다. 
    // 클릭될 때마다 모든 항목에서 'active' 클래스를 제거함으로써, 이전에 선택된 항목이 더 이상 활성화되지 않도록 합니다.

    this.classList.add('active');
    // 현재 클릭된 항목(this)에 'active' 클래스를 추가합니다. 
    // 여기서 'this'는 현재 이벤트가 발생한 대상, 즉 클릭된 항목을 가리킵니다.
}

list.forEach((item) =>
// list 배열의 모든 항목(item)에 대해 다시 한번 반복문을 돌립니다.

item.addEventListener('click', activeLink));
// 각 항목(item)에 대해 'click' 이벤트 리스너를 추가합니다. 
// 사용자가 항목을 클릭하면 activeLink 함수가 호출되어, 클릭된 항목에 'active' 클래스를 추가하고, 나머지 항목에서는 제거됩니다.
// addEventListener는 특정 이벤트(여기서는 'click')가 발생했을 때 실행할 함수를 설정하는 메서드입니다.
