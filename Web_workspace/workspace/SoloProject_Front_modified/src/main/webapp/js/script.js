// 전역 변수 선언
let map; // 구글 맵 객체를 저장할 변수
let currentMarker = null; // 현재 지도에 표시된 마커를 저장하는 변수

// infoPopup 및 infoContent DOM 요소는 initPage() 함수 내에서 초기화되도록 수정합니다
let infoPopup;
let infoContent;

// 구글 맵 초기화 함수
function initMap() {
    // 구글 맵 객체를 생성하여 전역 변수에 저장
    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: 37.5665, lng: 126.9780 }, // 초기 맵 중심 좌표 (서울)
        zoom: 12 // 초기 줌 레벨
    });

    // 맵 클릭 이벤트 리스너 추가
    map.addListener('click', function(event) {
        // 클릭한 위치에 마커를 배치하고, 위치 정보를 가져옴
        placeMarkerAndPanTo(event.latLng, map);
    });

    // 위치 검색 버튼 클릭 이벤트 리스너 추가
    document.getElementById('search-button').addEventListener('click', function() {
        // 입력된 위치를 검색하고, 해당 위치로 지도를 이동
        const location = document.getElementById('location-input').value;
        if (location) {
            searchLocation(location, map);
        }
    });
}

// 마커를 배치하고, 해당 위치의 날씨 및 정보를 가져오는 함수
function placeMarkerAndPanTo(latLng, map) {
    // 기존 마커가 있으면 제거
    if (currentMarker) {
        currentMarker.setMap(null);
    }

    // 새로운 마커를 생성하여 지도에 추가
    currentMarker = new google.maps.Marker({
        position: latLng, // 마커를 배치할 좌표
        map: map // 마커를 추가할 맵 객체
    });

    // 지도의 중심을 클릭한 위치로 이동
    map.panTo(latLng);

    // 클릭한 위치의 날씨 정보를 가져와서 화면에 표시
    fetchWeatherByCoordinates(latLng.lat(), latLng.lng());

    // 클릭한 위치의 주소 정보를 가져와서 팝업에 표시
    fetchLocationInfo(latLng, map);
}

// 좌표를 사용하여 날씨 정보를 가져오는 함수
function fetchWeatherByCoordinates(lat, lon) {
    const apiKey = "5233d140772d45ceb3ec91756afa4e78"; // Weatherbit API 키
    const url = `https://api.weatherbit.io/v2.0/current?lat=${lat}&lon=${lon}&key=${apiKey}&lang=ko`; // API 호출 URL

    // Weatherbit API를 사용하여 날씨 정보 가져오기
    fetch(url)
        .then(response => response.json()) // JSON 형태로 응답 파싱
        .then(data => {
            // 받아온 날씨 정보를 DOM 요소에 표시
            const weatherData = `
                <strong>${data.data[0].city_name}</strong>의 현재 날씨: 
                ${data.data[0].weather.description}, 온도: ${data.data[0].temp}°C
            `;
            document.getElementById("weather-data").innerHTML = weatherData;
        })
        .catch(error => {
            // 오류 발생 시 콘솔에 출력하고 사용자에게 알림
            console.error("Error fetching the weather data:", error);
            document.getElementById("weather-data").innerHTML = error.message;
        });
}

// 좌표를 사용하여 위치 정보를 가져오는 함수
function fetchLocationInfo(latLng, map) {
    const geocoder = new google.maps.Geocoder(); // 구글 지오코더 객체 생성

    // 좌표를 사용하여 주소 정보 가져오기
    geocoder.geocode({ location: latLng }, function(results, status) {
        if (status === 'OK') {
            // 주소 정보가 성공적으로 받아지면 팝업에 표시
            const locationInfo = `
                <strong>${results[0].formatted_address}</strong>
            `;
            infoContent.innerHTML = locationInfo; // 팝업 내용 업데이트
            infoPopup.classList.add('visible'); // 팝업 표시
        } else {
            // 오류 발생 시 사용자에게 알림
            alert('위치 정보를 가져올 수 없습니다: ' + status);
        }
    });
}

// 사용자가 입력한 위치를 검색하고, 지도를 해당 위치로 이동시키는 함수
function searchLocation(location, map) {
    const geocoder = new google.maps.Geocoder(); // 구글 지오코더 객체 생성

    // 입력된 주소를 사용하여 좌표 정보 가져오기
    geocoder.geocode({ address: location }, function(results, status) {
        if (status === 'OK') {
            // 검색된 좌표를 사용하여 지도를 이동시키고 마커 배치
            const latLng = results[0].geometry.location;
            map.setCenter(latLng);
            placeMarkerAndPanTo(latLng, map);
        } else {
            // 오류 발생 시 사용자에게 알림
            alert('위치를 찾을 수 없습니다: ' + status);
        }
    });
}

// 길찾기 요청을 처리하는 함수
function calculateAndDisplayRoute() {
    if (navigator.geolocation) {
        // 현재 위치를 가져옴
        navigator.geolocation.getCurrentPosition(function(position) {
            const origin = {
                lat: position.coords.latitude, // 현재 위치의 위도
                lng: position.coords.longitude // 현재 위치의 경도
            };
            const destination = currentMarker.getPosition(); // 목적지 (현재 마커의 위치)
            const directionsService = new google.maps.DirectionsService(); // 길찾기 서비스 객체 생성
            const directionsRenderer = new google.maps.DirectionsRenderer(); // 길찾기 결과 렌더링 객체 생성

            directionsRenderer.setMap(map); // 길찾기 결과를 표시할 맵 객체 설정
            directionsRenderer.setPanel(document.getElementById('directions-panel')); // 길찾기 결과를 표시할 패널 설정

            // 길찾기 요청
            directionsService.route(
                {
                    origin: origin, // 출발지
                    destination: destination, // 목적지
                    travelMode: google.maps.TravelMode.DRIVING // 이동 수단 (운전)
                },
                function(response, status) {
                    if (status === google.maps.DirectionsStatus.OK) {
                        // 길찾기 결과를 화면에 표시
                        directionsRenderer.setDirections(response);
                        document.getElementById('directions-panel').classList.add('visible'); // 길찾기 패널 표시
                    } else {
                        // 오류 발생 시 콘솔에 출력하고 사용자에게 알림
                        console.error('길찾기 요청에 실패했습니다:', status);
                        alert('길찾기 요청에 실패했습니다: ' + status + '\n' + 
                              '이 오류는 경로를 찾을 수 없는 경우 발생할 수 있습니다. ' +
                              '출발지와 도착지를 확인하거나, 다른 길찾기 모드를 시도해 보세요.');
                    }
                }
            );
        });
    } else {
        // 위치 정보를 사용할 수 없을 때 사용자에게 알림
        alert('현재 위치를 사용할 수 없습니다.');
    }
}

// 페이지 로드 시 모든 초기화 작업을 수행하는 함수
function initPage() {
    // infoPopup 및 infoContent 요소를 초기화
    infoPopup = document.getElementById('info-popup');
    infoContent = document.getElementById('info-content');

    // X 버튼 클릭 시 팝업 닫기
    document.getElementById('close-popup').addEventListener('click', function() {
        infoPopup.classList.add('hidden'); // hidden 클래스를 추가하여 팝업을 숨김
    });

    initMap(); // 구글 맵 초기화
}

// 길찾기 버튼 클릭 이벤트 리스너 추가
document.getElementById('directions-button').addEventListener('click', function() {
    calculateAndDisplayRoute(); // 길찾기 요청 함수 호출
});
