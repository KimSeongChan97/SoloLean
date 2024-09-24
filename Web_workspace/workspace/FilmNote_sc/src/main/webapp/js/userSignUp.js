// FilmNote/src/main/webapp/js/userSignUp.js
$(document).ready(function() {
    // 회원가입 버튼 클릭 이벤트
    $('#signUpBtn').click(function(e) {
        e.preventDefault();
        if (validateForm()) {
            $('#writeForm').submit();
        }
    });

    // focusout 이벤트 추가
    $('#name, #id, #pwd, #repwd, #birth1, #birth2, #birth3, #email1, #email2, #tel2, #tel3').focusout(function() {
        validateForm();
    });

    function validateForm() {
        let isValid = true;

        if ($('#name').val() == '') {
            $('#nameDiv').html('이름을 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#nameDiv').html('');
        }

        if ($('#id').val() == '') {
            $('#idDiv').html('아이디를 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#idDiv').html('');
        }

        if ($('#pwd').val() == '') {
            $('#pwdDiv').html('비밀번호를 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#pwdDiv').html('');
        }

        if ($('#repwd').val() == '') {
            $('#repwdDiv').html('비밀번호를 재확인하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#repwdDiv').html('');
        }

        if ($('#birth1').val() == '' || $('#birth2').val() == '' || $('#birth3').val() == '') {
            $('#birthDiv').html('생년월일을 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#birthDiv').html('');
        }

        if ($('#email1').val() == '' || $('#email2').val() == '') {
            $('#emailDiv').html('이메일을 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#emailDiv').html('');
        }

        if ($('#tel2').val() == '' || $('#tel3').val() == '') {
            $('#telDiv').html('휴대전화를 입력하세요').css('color', 'red');
            isValid = false;
        } else {
            $('#telDiv').html('');
        }

        return isValid;
    }
});
