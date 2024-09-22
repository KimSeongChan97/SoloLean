$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트
    $('#loginBtn').click(function(e) {
        e.preventDefault();
        if ($('#loginId').val() == '' && $('#loginPwd').val() == '') {
            $('#loginErrorDiv').html('아이디와 비밀번호를 입력하세요').css('color', 'red');
        } else {
            $('#loginErrorDiv').html('');
            if ($('#loginId').val() == '') {
                $('#loginIdDiv').html('아이디를 입력하세요').css('color', 'red');
            } else {
                $('#loginIdDiv').html('');
            }
            if ($('#loginPwd').val() == '') {
                $('#loginPwdDiv').html('비밀번호를 입력하세요').css('color', 'red');
            } else {
                $('#loginPwdDiv').html('');
            }
        }
    });

    // focusout 이벤트 추가
    $('#loginId, #loginPwd').focusout(function() {
        if ($('#loginId').val() == '' && $('#loginPwd').val() == '') {
            $('#loginErrorDiv').html('아이디와 비밀번호를 입력하세요').css('color', 'red');
        } else {
            $('#loginErrorDiv').html('');
            if ($('#loginId').val() == '') {
                $('#loginIdDiv').html('아이디를 입력하세요').css('color', 'red');
            } else {
                $('#loginIdDiv').html('');
            }
            if ($('#loginPwd').val() == '') {
                $('#loginPwdDiv').html('비밀번호를 입력하세요').css('color', 'red');
            } else {
                $('#loginPwdDiv').html('');
            }
        }
    });
});