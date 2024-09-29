$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트
    $('#adminLoginBtn').click(function(e) {
        e.preventDefault();
        clearMessages(); // 경고 메시지를 숨김
        if (validateForm()) {
            $('#adminLoginForm').submit();
        }
    });

    // focusout 이벤트 추가
    $('#adminId, #adminPwd').on('focusout', function() {
        validateField($(this));
    });

    function validateForm() {
        let isValid = true;

        if ($('#adminId').val() == '' && $('#adminPwd').val() == '') {
            showErrorMessage('아이디와 비밀번호를 입력하세요');
            isValid = false;
        } else {
            if ($('#adminId').val() == '') {
                showErrorMessage('아이디를 입력하세요');
                isValid = false;
            }
            if ($('#adminPwd').val() == '') {
                showErrorMessage('비밀번호를 입력하세요');
                isValid = false;
            }
        }

        return isValid;
    }

    function validateField(field) {
        if (field.attr('id') == 'adminId' && field.val() == '') {
            showErrorMessage('아이디를 입력하세요');
        } else if (field.attr('id') == 'adminPwd' && field.val() == '') {
            showErrorMessage('비밀번호를 입력하세요');
        }
    }

    // 에러 메시지 표시 함수
    function showErrorMessage(message) {
        $('#adminLoginErrorDiv').html(message).css('color', 'red').show();
    }

    // 에러 메시지 숨기기 함수
    function clearMessages() {
        $('#adminLoginErrorDiv').hide();
    }
});
