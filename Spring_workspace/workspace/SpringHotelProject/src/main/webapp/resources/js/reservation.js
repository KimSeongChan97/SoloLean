// 메뉴 설정
function setMenu() {
    var menuNum = $('.container').data('menu'); // .container 요소에 설정된 데이터 속성 'menu' 값을 가져옴 (현재 선택된 메뉴 번호)
    
    console.log(menuNum); // 선택된 메뉴 번호를 콘솔에 출력
    $('#m' + menuNum).addClass('active'); // 선택된 메뉴 번호에 해당하는 메뉴에 'active' 클래스를 추가하여 활성화
    $('#m' + menuNum + ' > a').css('color', 'white'); // 활성화된 메뉴의 링크 색상을 흰색으로 변경
    $('#m' + menuNum + ' > a').css('background-color', '#ded3c5'); // 활성화된 메뉴의 배경 색상을 지정된 색상으로 변경
    
    if(menuNum == 1) { // 만약 첫 번째 메뉴가 활성화된 경우
        // 1. 메뉴 초기화 (href 속성 제거)
        $("#m1 a").removeAttr("href"); // 첫 번째 메뉴의 링크를 비활성화 (href 속성을 제거하여 링크 기능 제거)
        $("#m2 a").removeAttr("href"); // 두 번째 메뉴의 링크를 비활성화
        $("#m3 a").removeAttr("href"); // 세 번째 메뉴의 링크를 비활성화
        
        // 2. 날짜 초기화
        $('#checkin').attr('min', getToday()); // 체크인 날짜의 최소값을 오늘 날짜로 설정
        $('#checkin').val(getToday()); // 체크인 날짜를 기본적으로 오늘 날짜로 설정
        $('#checkout').val(getTomorrow()); // 체크아웃 날짜를 내일로 설정
        $('#checkout').attr('min', getTomorrow()); // 체크아웃 날짜의 최소값을 내일 날짜로 설정
        $('#diffday').val(calculateStayDuration() + '박'); // 숙박일수를 계산하여 '박' 단위로 표시
    } else if(menuNum == 2) {
        $("#m2 a").removeAttr("href"); // 두 번째 메뉴의 링크를 비활성화
        $("#m3 a").removeAttr("href"); // 세 번째 메뉴의 링크를 비활성화
    } else if(menuNum == 3) {
        $("#m2 a").removeAttr("href"); // 두 번째 메뉴의 링크를 비활성화
        $("#m3 a").removeAttr("href"); // 세 번째 메뉴의 링크를 비활성화
    }
}

// 오늘 날짜 구하기
function getToday() {
    var today = new Date(); // 오늘 날짜 객체 생성

    var year = today.getFullYear(); // 연도를 가져옴
    var month = ('0' + (today.getMonth() + 1)).slice(-2); // 월은 0부터 시작하므로 +1을 해주고, 두 자리로 맞추기 위해 '0'을 덧붙인 후 뒤에서 두 자리만 사용
    var day = ('0' + today.getDate()).slice(-2); // 날짜도 두 자리로 맞추기 위해 '0'을 덧붙인 후 뒤에서 두 자리만 사용
    
    var dateString = year + '-' + month  + '-' + day; // YYYY-MM-DD 형식으로 날짜를 조합
    
    console.log(dateString); // 오늘 날짜를 콘솔에 출력

    return dateString; // 오늘 날짜 문자열을 반환
}

// 체크인 다음날 구하기
function getTomorrow() {
    // 체크인 날짜를 가져오기
    var checkinDate = new Date($('#checkin').val()); // 체크인 날짜 input에서 값을 가져와 Date 객체로 변환
    
    // 하루를 더하기 (1일 = 24 * 60 * 60 * 1000 ms)
    checkinDate.setDate(checkinDate.getDate() + 1); // 체크인 날짜에 하루를 더함
    
    // 날짜를 YYYY-MM-DD 형식으로 변환
    var year = checkinDate.getFullYear(); // 연도 가져오기
    var month = ('0' + (checkinDate.getMonth() + 1)).slice(-2); // 월을 두 자리로 맞추기 위해 '0'을 덧붙임
    var day = ('0' + checkinDate.getDate()).slice(-2); // 일도 두 자리로 맞춤
    
    var tomorrowString = year + '-' + month + '-' + day; // 내일 날짜를 YYYY-MM-DD 형식으로 조합
    
    console.log('+1 day: ' + tomorrowString); // 콘솔에 내일 날짜 출력
    
    return tomorrowString; // 내일 날짜 문자열을 반환
}

// 숙박일 구하기
function calculateStayDuration() {
    var checkinDate = new Date($('#checkin').val()); // 체크인 날짜를 Date 객체로 변환
    var checkoutDate = new Date($('#checkout').val()); // 체크아웃 날짜를 Date 객체로 변환

    // 날짜 차이 계산 (밀리초 단위)
    var timeDiff = checkoutDate - checkinDate; // 체크아웃과 체크인 날짜의 차이를 계산 (밀리초 단위)

    // 밀리초를 하루 단위로 변환 (1일 = 24 * 60 * 60 * 1000 ms)
    var dayDiff = timeDiff / (1000 * 60 * 60 * 24); // 밀리초 단위 차이를 일수로 변환

    console.log('숙박일수: ' + dayDiff + '박'); // 숙박일수를 콘솔에 출력
    return dayDiff; // 숙박일수를 반환
}

// 날짜, 인원 데이터 전송
function findRoom() {
    // Ajax를 통해 서버로 날짜와 인원 정보를 전송하여 예약 가능한 방을 찾음
    $.ajax({
        type: 'post', // HTTP POST 방식 사용
        url: '/SpringHotel/reserve/menu2/findRoom', // 예약 가능한 방을 찾는 URL에 요청
        data: {
            'checkin' : $('#checkin').val(), // 체크인 날짜 전송
            'checkout' : $('#checkout').val(), // 체크아웃 날짜 전송
            'adults' : $('#adults').val(), // 성인 인원 수 전송
            'kids' : $('#kids').val() // 어린이 인원 수 전송
        },
        dataType: 'text', // 서버로부터의 응답을 텍스트 형식으로 받음
        success: function(data) { // 요청이 성공했을 때 실행
            if(data == "true") { // 방이 예약 가능하다면
                location.href = '/SpringHotel/reserve/menu2?' // 예약 화면으로 이동
                                + 'checkin=' + $('#checkin').val() // 체크인 날짜를 URL에 포함
                                + '&checkout=' + $('#checkout').val() // 체크아웃 날짜를 URL에 포함
                                + '&adults=' + $('#adults').val() // 성인 인원 수를 URL에 포함
                                + '&kids=' + $('#kids').val(); // 어린이 인원 수를 URL에 포함
            } else { // 예약 가능한 방이 없다면
                alert('예약 가능한 객실이 없습니다.'); // 사용자에게 알림
            }
        },
        error: function(e) { // 요청이 실패했을 때 실행
            console.log(e); // 에러 내용을 콘솔에 출력
        }
    });
}

// 예약 정보 전송
function reserveInfo(roomId) {
    const userSeq = $('#seq').text(); // 사용자 고유 번호를 가져옴
    
    // Ajax를 통해 예약 정보를 서버로 전송
    $.ajax({
        type: 'get', // HTTP GET 방식 사용
        url: '/SpringHotel/reserve/menu3/info', // 예약 정보를 가져오는 서버 URL
        dataType: 'text', // 서버로부터의 응답을 텍스트 형식으로 받음
        success: function(data) { // 요청이 성공했을 때 실행
            location.href = '/SpringHotel/reserve/menu3?' // 예약 완료 화면으로 이동
                            + 'checkin=' + $('#checkin').val() // 체크인 날짜를 URL에 포함
                            + '&checkout=' + $('#checkout').val() // 체크아웃 날짜를 URL에 포함
                            + '&adults=' + $('#adults').val() // 성인 인원 수를 URL에 포함
                            + '&kids=' + $('#kids').val() // 어린이 인원 수를 URL에 포함
                            + '&roomId=' + roomId // 선택한 방 ID를 URL에 포함
                            + '&userSeq=' + userSeq; // 사용자 고유 번호를 URL에 포함
        },
        error: function(e) { // 요청이 실패했을 때 실행
            console.log(e); // 에러 내용을 콘솔에 출력
        }
    });
}

// 예약하기
function reserveSubmit() {
    // Ajax를 통해 서버로 예약 정보를 전송
    $.ajax({
        type: 'post', // HTTP POST 방식 사용
        url: '/SpringHotel/reserve/menu3/submit', // 예약 정보를 제출하는 서버 URL
        data: {
            'roomId' : $('#roomId').text(), // 방 ID 전송
            'checkin' : $('#checkin').text(), // 체크인 날짜 전송
            'checkout' : $('#checkout').text(), // 체크아웃 날짜 전송
            'adults' : $('#adults').text(), // 성인 인원 수 전송
            'kids' : $('#kids').text(), // 어린이 인원 수 전송
            'price' : $('#price').text() // 가격 전송
        },
        dataType: 'text', // 서버로부터의 응답을 텍스트 형식으로 받음
        success: function(data) { // 요청이 성공했을 때 실행
            alert("예약되었습니다."); // 예약 성공 메시지 표시
            location.href = '/SpringHotel/reserve/list'; // 예약 목록 화면으로 이동
        },
        error: function(e) { // 요청이 실패했을 때 실행
            console.log(e); // 에러 내용을 콘솔에 출력
        }
    });
}

$(function() {
    // 1. 메뉴 활성화
    setMenu(); // 페이지 로드 시 메뉴 활성화 설정

    // 2. 체크아웃 min 설정: 체크인+1일부터 선택 가능
    $('#checkin').change(function() { // 체크인 날짜가 변경되면
        $('#checkout').attr('min', getTomorrow()); // 체크아웃 최소 날짜를 체크인 다음날로 설정
        $('#checkout').val(getTomorrow()); // 체크아웃 날짜를 기본적으로 체크인 다음날로 설정
    });
    
    // 3. 숙박 일수 계산 
    $('#diffday').val(calculateStayDuration() + '박'); // 숙박 일수를 초기화
    $('#checkout').change(function() { // 체크아웃 날짜가 변경되면
        if($('#checkout').val != '') { // 체크아웃 날짜가 입력되어 있을 경우
            $('#diffday').val(calculateStayDuration() + '박'); // 숙박 일수를 계산하여 표시
        }
    });

    // 4. 날짜, 인원 데이터 전송
    $('#findRoomBtn').click(findRoom); // 방 찾기 버튼 클릭 시 findRoom 함수 실행
    
    // 5. 예약 정보 전송
    $('.reserveInfoBtn').click(function() { // 예약 정보 버튼 클릭 시
        if($('#seq').text() != '') { // 사용자 고유 번호가 있을 경우
            reserveInfo($(this).data('roomid')); // 선택한 방의 예약 정보를 전송
        } else {
            alert('로그인 후에 예약 가능합니다.'); // 로그인이 필요하다는 메시지 표시
        }
    });
    
    // 6. 예약하기
    $('#reserveBtn').click(reserveSubmit); // 예약 버튼 클릭 시 reserveSubmit 함수 실행
    
    // 7. 등급 색상
    var grade = $('#grade').text().split(' ')[0]; // 등급을 확인
    if(grade == 'VIP') $('#grade').css('color', '#0d3591'); // VIP 등급은 파란색
    else if(grade == 'GOLD') $('#grade').css('color', '#b8860b'); // GOLD 등급은 금색
    else if(grade == 'SILVER') $('#grade').css('color', '#807e79'); // SILVER 등급은 은색
});
