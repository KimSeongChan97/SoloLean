$(document).ready(function() {
    // 회원가입 버튼 클릭 이벤트
    $('#signUpBtn').click(function(e) {
        e.preventDefault();

        // 이름 입력 확인
        if ($('#name').val() == '') {
            $('#nameDiv').html('이름을 입력하세요').css('color', 'red');
            $('#name').focus();
            return false;
        }

        // 아이디 입력 확인 및 중복체크 확인
        if ($('#id').val() == '') {
            $('#idDiv').html('아이디를 입력하세요').css('color', 'red');
            $('#id').focus();
            return false;
        }

        if ($('#pwd').val() == '') {
            $('#pwdDiv').html('비밀번호를 입력하세요').css('color', 'red');
            $('#pwd').focus();
            return false;
        }

        if ($('#pwd').val() != $('#repwd').val()) {
            $('#repwdDiv').html('비밀번호가 일치하지 않습니다').css('color', 'red');
            $('#repwd').focus();
            return false;
        }

        $('#writeForm').submit(); // 모든 조건이 통과되면 폼 제출
    });

    // 로그인 버튼 클릭 이벤트
    $('#loginBtn').click(function(e) {
        e.preventDefault();

        if ($('#loginId').val() == '') {
            $('#loginIdDiv').html('아이디를 입력하세요').css('color', 'red');
            $('#loginId').focus();
            return false;
        }

        if ($('#loginPwd').val() == '') {
            $('#loginPwdDiv').html('비밀번호를 입력하세요').css('color', 'red');
            $('#loginPwd').focus();
            return false;
        }

        $('#loginForm').submit(); // 모든 조건이 통과되면 폼 제출
    });

    // focusout 이벤트 추가
    $('#loginId, #loginPwd').focusout(function() {
        if ($(this).val() == '') {
            $(this).next('div').html('입력하세요').css('color', 'red');
        } else {
            $(this).next('div').html('');
        }
    });

    $('#name, #id, #pwd, #repwd').focusout(function() {
        if ($(this).val() == '') {
            $(this).next('div').html('입력하세요').css('color', 'red');
        } else {
            $(this).next('div').html('');
        }
    });
});