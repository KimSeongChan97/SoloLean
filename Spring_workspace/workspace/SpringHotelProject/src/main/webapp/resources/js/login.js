function login() {
    var isOk = true; // 로그인 유효성 검사를 통과할 경우 true로 유지, 실패 시 false로 변경

    // 아이디 입력란이 비어 있는지 확인
    if($('#userid').val() == '') { 
        // 아이디가 비어 있을 경우 경고 메시지를 표시
        $('#idDiv').text('아이디를 입력하세요.'); // '아이디를 입력하세요.'라는 경고 메시지 표시
        $('#idDiv').css('color', 'red'); // 경고 메시지를 빨간색으로 설정
        $('#idDiv').css('font-size', '8pt'); // 글씨 크기를 작게 설정하여 경고 메시지 표시
        isOk = false; // 유효성 검사 실패
    }

    // 비밀번호 입력란이 비어 있는지 확인
    if($('#pwd').val() == '') {
        // 비밀번호가 비어 있을 경우 경고 메시지를 표시
        $('#pwdDiv').text('비밀번호를 입력하세요.'); // '비밀번호를 입력하세요.'라는 경고 메시지 표시
        $('#pwdDiv').css('color', 'red'); // 경고 메시지를 빨간색으로 설정
        $('#pwdDiv').css('font-size', '8pt'); // 글씨 크기를 작게 설정하여 경고 메시지 표시
        isOk = false; // 유효성 검사 실패
    }
    
    // 만약 아이디와 비밀번호 입력란이 모두 비어있지 않다면 (유효성 검사 통과)
    if(isOk) {
        // Ajax를 사용하여 서버에 로그인 요청을 보냄
        $.ajax({
            type: 'post', // HTTP POST 방식으로 데이터를 전송
            url: '/SpringHotel/user/login/sh', // 로그인 요청을 처리할 서버의 URL
            data: {
                'userid' : $('#userid').val(), // 입력된 아이디 값을 'userid'라는 이름으로 전송
                'pwd' : $('#pwd').val() // 입력된 비밀번호 값을 'pwd'라는 이름으로 전송
            },
            dataType: 'text', // 서버로부터의 응답을 텍스트 형식으로 받을 것을 지정
            success: function(data) { // 서버로부터 응답이 성공적으로 오면 실행
                if(data == 'true') { // 서버로부터 'true'가 응답되면 (로그인 성공)
                    console.log('SH 로그인 성공'); // 로그인 성공 메시지를 콘솔에 출력
                    alert("환영합니다."); // 환영 메시지를 띄움
                    location.href="/SpringHotel"; // 로그인 성공 후 홈페이지로 이동
                } else { // 서버로부터 'true'가 아닌 값이 응답되면 (로그인 실패)
                    console.log('SH 로그인 실패'); // 로그인 실패 메시지를 콘솔에 출력
                    alert("아이디 혹은 비밀번호가 틀렸습니다."); // 로그인 실패 경고 메시지를 띄움
                }
            },
            error: function(e) { // 서버 요청이 실패했을 때 실행
                console.log(e); // 에러 메시지를 콘솔에 출력
            }
        });
    }
}

$(function() {
    // 초기화
    $('#userid').blur(function() { // 아이디 입력란에서 포커스가 해제될 때
        $('#idDiv').text(''); // idDiv 영역의 메시지를 초기화
    });
    
    $('#pwd').blur(function() { // 비밀번호 입력란에서 포커스가 해제될 때
        $('#pwdDiv').text(''); // pwdDiv 영역의 메시지를 초기화
    });
    
    // 로그인
    $('#loginBtn').click(login); // 로그인 버튼을 클릭할 때 login 함수를 호출
});
