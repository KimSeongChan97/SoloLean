$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트: 로그인 버튼을 눌렀을 때 실행되는 동작
    $('#loginBtn').click(function(e) {
        e.preventDefault(); // 기본 폼 제출을 방지
        clearMessages(); // 기존 경고 메시지 숨기기
        
        // AJAX로 폼 데이터를 서버로 전송하여 로그인 요청
        $.ajax({
            type: 'POST', // 서버로 데이터를 보내는 방식 (POST)
            url: $('#loginForm').attr('action'), // 로그인 폼에 정의된 action 속성의 URL로 요청
            data: $('#loginForm').serialize(),   // 폼 데이터를 직렬화하여 전송
            dataType: 'json', // 서버로부터 기대하는 응답 타입을 JSON으로 설정
            success: function(response) {
                if (response.status === 'success') { // 서버 응답이 'success'일 경우
                    // 로그인 성공 시 리다이렉트할 URL로 페이지 이동
                    window.location.href = response.redirectUrl; 
                } else {
                    // 로그인 실패 시 경고 메시지를 모달 창으로 표시
                    showLoginErrorModal(response.message);
                }
            },
            error: function() {
                // 서버와의 통신 중 오류가 발생한 경우 실행
                alert('서버와의 통신 중 오류가 발생했습니다.');
            }
        });
    });

    // Admin 버튼 클릭 이벤트: Admin 버튼 클릭 시 관리자 로그인 페이지로 이동
    $('#adminBtn').click(function(e) {
        e.preventDefault(); // 기본 동작 방지
        // onclick 속성을 사용하여 설정된 이동 URL로 페이지 이동
        window.location.href = $(this).attr('onclick').replace('location.href=', '').replace(/'/g, '');
    });

    // focusout 이벤트 추가: 아이디 또는 비밀번호 필드에서 포커스가 벗어날 때 유효성 검증 실행
    $('#loginId, #loginPwd').on('focusout', function() {
        validateField($(this)); // 필드 유효성 검사
    });

    // 전체 로그인 폼 검증 함수: 아이디와 비밀번호 모두 입력되었는지 확인
    function validateForm() {
        let isValid = true; // 폼이 유효한지 여부
        let warningMessage = ''; // 경고 메시지 내용

        // 아이디와 비밀번호 필드가 비어있을 때 경고 메시지 설정
        if ($('#loginId').val() === '' || $('#loginPwd').val() === '') {
            warningMessage = '아이디와 비밀번호를 모두 입력하세요.';
            isValid = false; // 유효성 검사 실패
        }

        if (!isValid) { // 폼이 유효하지 않을 때
            showWarningMessage(warningMessage); // 경고 메시지 출력
        }

        return isValid; // 폼이 유효하면 true, 그렇지 않으면 false 반환
    }

    // 개별 필드 유효성 검증 함수: 아이디 또는 비밀번호가 비어있는지 확인
    function validateField(field) {
        let warningMessage = ''; // 경고 메시지
        if (field.attr('id') === 'loginId' && field.val() === '') { // 아이디 필드가 비어있을 때
            warningMessage = '아이디를 입력하세요.';
        } else if (field.attr('id') === 'loginPwd' && field.val() === '') { // 비밀번호 필드가 비어있을 때
            warningMessage = '비밀번호를 입력하세요.';
        }

        if (warningMessage !== '') { // 경고 메시지가 존재할 때
            showWarningMessage(warningMessage); // 경고 메시지 출력
        }
    }

    // 경고 메시지 표시 함수: 경고 또는 오류 메시지를 지정된 영역에 출력
    function showWarningMessage(message) {
        $('#loginWarningMessage').html(message).css('color', '#e74c3c').show(); // 경고 메시지를 빨간색으로 표시
    }

    // 경고 메시지 숨기기 함수: 기존 경고 메시지를 숨김
    function clearMessages() {
        $('#loginWarningMessage').hide(); // 경고 메시지 영역을 숨김
    }

    // 로그인 실패 시 모달 표시 함수: 로그인 실패 시 경고 모달 창을 띄움
    function showLoginErrorModal(message) {
        $('#loginErrorMessage').text(message); // 모달 창에 오류 메시지 설정
        $('#loginErrorModal').dialog({
            modal: true, // 모달 형식으로 설정
            buttons: {
                "확인": function() { // 확인 버튼 클릭 시 모달 닫기
                    $(this).dialog("close"); // 모달 창 닫기
                }
            }
        });
    }
});
