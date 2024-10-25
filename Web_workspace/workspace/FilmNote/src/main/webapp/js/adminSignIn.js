$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트
    $('#adminLoginBtn').click(function(e) {
        e.preventDefault(); // 기본 폼 제출 동작을 막습니다.
        clearMessages(); // 경고 메시지를 숨깁니다.
        if (validateForm()) {
            // 유효성 검사를 통과하면 폼을 제출합니다.
            $('#adminLoginForm').submit();
        }
    });

    // 입력 필드가 포커스를 잃을 때(focusout) 유효성 검사를 실행하는 이벤트
    $('#adminId, #adminPwd').on('focusout', function() {
        // 입력된 필드가 비어 있는지 확인하여 유효성 검사
        validateField($(this)); 
    });

    // 폼 전체에 대한 유효성 검사 함수
    function validateForm() {
        let isValid = true; // 유효성 검사가 성공하면 true, 실패하면 false
        
        // 아이디와 비밀번호가 모두 비어 있는지 확인
        if ($('#adminId').val() == '' && $('#adminPwd').val() == '') {
            // 아이디와 비밀번호가 모두 비어있을 때의 에러 메시지
            showErrorMessage('아이디와 비밀번호를 입력하세요');
            isValid = false;
        } else {
            // 아이디가 비어있는지 확인
            if ($('#adminId').val() == '') {
                showErrorMessage('아이디를 입력하세요');
                isValid = false;
            }
            // 비밀번호가 비어있는지 확인
            if ($('#adminPwd').val() == '') {
                showErrorMessage('비밀번호를 입력하세요');
                isValid = false;
            }
        }

        return isValid; // 유효성 검사 결과를 반환
    }

    // 개별 필드에 대한 유효성 검사 함수 (focusout 이벤트에서 호출)
    function validateField(field) {
        // adminId 필드에 대한 유효성 검사
        if (field.attr('id') == 'adminId' && field.val() == '') {
            showErrorMessage('아이디를 입력하세요');
        } 
        // adminPwd 필드에 대한 유효성 검사
        else if (field.attr('id') == 'adminPwd' && field.val() == '') {
            showErrorMessage('비밀번호를 입력하세요');
        }
    }

    // 에러 메시지를 표시하는 함수
    function showErrorMessage(message) {
        // 메시지를 빨간색으로 표시하며 화면에 보여줌
        $('#adminLoginErrorDiv').html(message).css('color', 'red').show();
    }

    // 에러 메시지를 숨기는 함수
    function clearMessages() {
        // 에러 메시지 영역을 숨깁니다.
        $('#adminLoginErrorDiv').hide();
    }
});
