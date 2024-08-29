function goBack() {
    window.history.back();
}

// 사용자가 로그인하면 로그아웃 버튼으로 전환
function checkLoginStatus() {
    const isLoggedIn = false; // 실제 로그인 상태 체크 로직을 여기에 구현해야 합니다.

    if (isLoggedIn) {
        const loginNavItem = document.querySelector('a[href="login.html"]');
        loginNavItem.href = "index.html"; // 로그아웃 시 메인 페이지로 이동
        loginNavItem.innerHTML = '<img src="images/logout.png" alt="로그아웃" style="height: 30px;">';
        loginNavItem.onclick = function() {
            alert('로그아웃 되었습니다.');
            // 로그아웃 로직을 여기에 추가하세요.
        };
    }
}

// 날씨 정보를 가져오는 함수
function fetchWeather() {
    const apiKey = "5233d140772d45ceb3ec91756afa4e78"; // Weatherbit API 키
    const city = "Seoul";
    const url = `https://api.weatherbit.io/v2.0/current?city=${city}&key=${apiKey}&lang=ko`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("날씨 데이터를 가져오는 데 실패했습니다.");
            }
            return response.json();
        })
        .then(data => {
            const weatherData = `
                <strong>${data.data[0].city_name}</strong>의 현재 날씨: 
                ${data.data[0].weather.description}, 온도: ${data.data[0].temp}°C
            `;
            document.getElementById("weather-data").innerHTML = weatherData;
        })
        .catch(error => {
            console.error("Error fetching the weather data:", error);
            document.getElementById("weather-data").innerHTML = error.message;
        });
}

// 페이지 로드 시 모든 초기화 작업을 수행합니다.
window.onload = function() {
    checkLoginStatus();
    fetchWeather(); // 날씨 정보를 가져오는 함수 호출
}