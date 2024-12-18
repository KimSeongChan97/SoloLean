function handleMouseMove(event) {
    // 마우스가 움직일 때마다 이벤트가 발생하고, 그 이벤트의 정보를 event 객체로 받음
    const mouseX = event.clientX / window.innerWidth; // 마우스 X 위치를 화면 너비로 나눠 0과 1 사이의 비율로 변환.
    const mouseY = event.clientY / window.innerHeight; // 마우스 Y 위치를 화면 높이로 나눠 0과 1 사이의 비율로 변환.

    // 각도와 색상 계산
    const angle = Math.round(mouseX * 360); // X 위치 비율에 따라 각도를 계산하여 0도에서 360도 사이의 값을 생성.
    const red = Math.round(mouseX * 255); // X 위치 비율에 따라 빨간색 값(0~255)을 계산.
    const blue = Math.round(mouseY * 255); // Y 위치 비율에 따라 파란색 값(0~255)을 계산.
    const green = Math.round((mouseX + mouseY) * 127.5); // 255 / 2 // X와 Y 위치 비율을 더한 값을 평균화하여 초록색 값(0~255)을 계산.

    // 두 번째 색상 계산 (X, Y 반대로)
    const secondRed = Math.round(mouseY * 255); // Y 위치 비율에 따라 두 번째 빨간색 값(0~255)을 계산합니다.
    const secondGreen = Math.round(mouseX * 255); // X 위치 비율에 따라 두 번째 초록색 값(0~255)을 계산합니다.
    const secondBlue = Math.round((mouseX + mouseY) * 127.5); // 255 / 2

    // 배경 업데이트
    document.body.style.background = `linear-gradient(${angle}deg, rgb(${red}, ${green}, ${blue}), rgb(${secondRed}, ${secondGreen}, ${secondBlue}))`;
}

// 초기 이벤트 리스너 추가
document.addEventListener('mousemove', handleMouseMove);
