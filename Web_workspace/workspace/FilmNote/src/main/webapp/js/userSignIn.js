$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트
    $('#loginBtn').click(function(e) {
        e.preventDefault();
        clearMessages(); // 기존 경고 메시지 숨기기
        
        // AJAX로 폼 데이터를 서버로 전송
        $.ajax({
            type: 'POST',
            url: $('#loginForm').attr('action'), // 로그인 폼의 액션 URL
            data: $('#loginForm').serialize(),   // 폼 데이터를 직렬화하여 전송
            dataType: 'json',
            success: function(response) {
                if (response.status === 'success') {
                    // 로그인 성공 시 페이지 리다이렉트
                    window.location.href = response.redirectUrl; 
                } else {
                    // 로그인 실패 시 모달을 띄움
                    showLoginErrorModal(response.message);
                }
            },
            error: function() {
                alert('서버와의 통신 중 오류가 발생했습니다.');
            }
        });
    });

    // Admin 버튼 클릭 이벤트
    $('#adminBtn').click(function(e) {
        e.preventDefault();
        window.location.href = $(this).attr('onclick').replace('location.href=', '').replace(/'/g, '');
    });

    // focusout 이벤트 추가
    $('#loginId, #loginPwd').on('focusout', function() {
        validateField($(this));
    });

    function validateForm() {
        let isValid = true;
        let warningMessage = ''; // 경고 메시지

        // 로그인 폼 전체 검증
        if ($('#loginId').val() === '' || $('#loginPwd').val() === '') {
            warningMessage = '아이디와 비밀번호를 모두 입력하세요.';
            isValid = false;
        }

        if (!isValid) {
            showWarningMessage(warningMessage); // 경고 메시지 표시
        }

        return isValid;
    }

    function validateField(field) {
        let warningMessage = '';
        if (field.attr('id') === 'loginId' && field.val() === '') {
            warningMessage = '아이디를 입력하세요.';
        } else if (field.attr('id') === 'loginPwd' && field.val() === '') {
            warningMessage = '비밀번호를 입력하세요.';
        }

        if (warningMessage !== '') {
            showWarningMessage(warningMessage);
        }
    }

    // 경고 메시지 표시 함수 (로그인 실패 시 경고 메시지로 변경 가능)
    function showWarningMessage(message) {
        $('#loginWarningMessage').html(message).css('color', '#e74c3c').show(); // 경고: 빨간색
    }

    // 경고 메시지 숨기기 함수
    function clearMessages() {
        $('#loginWarningMessage').hide();
    }

	// 로그인 실패 시 모달 표시 함수
	    function showLoginErrorModal(message) {
	        $('#loginErrorMessage').text(message); // 오류 메시지 설정
	        $('#loginErrorModal').dialog({
	            modal: true,
	            buttons: {
	                "확인": function() {
	                    $(this).dialog("close"); // 모달을 닫음
	                }
	            }
	        });
	    }
});
