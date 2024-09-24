// FilmNote/src/main/webapp/js/userSignIn.js
$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트
    $('#loginBtn').click(function(e) {
        e.preventDefault();
        if (validateForm()) {
            $('#loginForm').submit();
        }
    });

    // focusout 이벤트 추가
    $('#loginId, #loginPwd').focusout(function() {
        validateForm();
    });

    function validateForm() {
        let isValid = true;

        if ($('#loginId').val() == '' && $('#loginPwd').val() == '') {
            $('#loginErrorDiv').html('아이디와 비밀번호를 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#loginErrorDiv').html('');
            if ($('#loginId').val() == '') {
                $('#loginIdDiv').html('아이디를 입력하세요').css('color', 'red');
                isValid = false;
            } else {
                $('#loginIdDiv').html('');
            }
            if ($('#loginPwd').val() == '') {
                $('#loginPwdDiv').html('비밀번호를 입력하세요').css('color', 'red');
                isValid = false;
            } else {
                $('#loginPwdDiv').html('');
            }
        }

        return isValid;
    }
});