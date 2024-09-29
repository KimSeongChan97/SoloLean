$(document).ready(function() {
    // 회원가입 버튼 클릭 이벤트
    $('#signUp').click(function(e) {
        e.preventDefault(); // 폼 제출 막기
        clearMessages(); // 경고 메시지 숨기기
        if (validateForm()) {
            $.ajax({
                url: $('#signUpForm').attr('action'),
                type: 'POST',
                data: $('#signUpForm').serialize(),
                success: function(response) {
					console.log("서버 응답: ", response);  // 응답 데이터 콘솔에 출력
                    if (response.status === "success") {
                        showModal(response.message, function() {
                            window.location.href = contextPath + '/user/userSignIn.do';
                        });
                    } else {
                        showWarningMessage('회원가입 중 오류가 발생했습니다');
                    }
                },
                error: function() {
                    showWarningMessage('회원가입 중 오류가 발생했습니다');
                }
            });
        }
    });

    // 이메일 도메인 자동 입력 기능
    $('#emailSelect').change(function() {
        $('#email2').val($('#emailSelect').val());
    });

    // ID 입력 필드 focusout 이벤트
    $('#uid').on('focusout', function() {
        let uid = $(this).val().trim();
        if (uid === '') {
            showWarningMessage('아이디를 입력하세요.');
        } else {
            checkIdDuplicate(uid);
        }
    });

    // 비밀번호 입력 필드 focusout 이벤트
    $('#upwd').on('focusout', function() {
        validateField($(this));
    });

    // 비밀번호 확인 입력 필드 focusout 이벤트
    $('#repwd').on('focusout', function() {
        validateField($(this));
    });

    function checkIdDuplicate(uid) {
        $.ajax({
            url: contextPath + '/user/checkId.do',
            type: 'POST',
            data: { uid: uid },
            success: function(response) {
                if (response.exists) {
                    showWarningMessage('존재하는 아이디 입니다');
                } else {
                    showWarningMessage('사용 가능한 아이디 입니다', true);
                }
            },
            error: function(xhr, status, error) {
                showWarningMessage('ID 체크 중 오류가 발생했습니다');
            }
        });
    }

    // 필드 검증 함수
    function validateField(field) {
        let id = field.attr('id');
        let value = field.val().trim();
        let messages = {
            'uid': '아이디를 입력하세요.',
            'upwd': '비밀번호를 입력하세요.',
            'repwd': '비밀번호를 재확인하세요.'
        };

        if (value === '') {
            showWarningMessage(messages[id]);
            return false;
        } else {
            // 비밀번호 필드 유효성 검사
            if (id === 'upwd') {
                if (!validatePassword(value)) {
                    showWarningMessage('비밀번호는 영어 대소문자, 숫자, 특수문자 1가지씩은 포함되어야 합니다.');
                    return false;
                } else {
                    showWarningMessage('올바른 비밀번호 형식입니다', true);
                    return true;
                }
            } else if (id === 'repwd') {
                if (value !== $('#upwd').val()) {
                    showWarningMessage('비밀번호가 일치하지 않습니다.');
                    return false;
                } else {
                    showWarningMessage('비밀번호가 일치합니다', true);
                    return true;
                }
            } else {
                return true;
            }
        }
    }

    // 경고 메시지 표시 함수
    function showWarningMessage(message, success = false) {
        const messageDiv = $('#warningMessage'); // 폼 하단 경고 메시지 영역
        messageDiv.html(message);
        if (success) {
            messageDiv.css('color', '#2ecc71'); // 성공 메시지: 녹색
        } else {
            messageDiv.css('color', '#e74c3c'); // 경고 메시지: 빨간색
        }
        messageDiv.show();
    }

    // 경고 메시지 숨기기 함수
    function clearMessages() {
        $('#warningMessage').hide(); // 폼 하단 경고 메시지 숨기기
    }

    // 비밀번호 검증 함수
    function validatePassword(password) {
        const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>]).{1,}$/;
        return regex.test(password);
    }

    // 폼 유효성 검증 (아이디와 비밀번호 필드만 검증)
    function validateForm() {
        let isValid = true;
        let firstInvalidField = null;

        $('#uid, #upwd, #repwd').each(function() {
            if (!validateField($(this))) {
                isValid = false;
                if (!firstInvalidField) {
                    firstInvalidField = $(this);
                }
            }
        });

        if (!isValid && firstInvalidField) {
            showWarningMessage('필수 입력값을 입력하세요.');
            firstInvalidField.focus(); // 잘못된 첫 번째 필드로 포커스 이동
        }

        return isValid;
    }

    // 모달 표시 함수
    function showModal(message, callback) {
        $('#dialogMessage').text(message);
        $('#dialog').dialog({
            modal: true,
            buttons: {
                "확인": function() {
                    $(this).dialog("close");
                    if (typeof callback === 'function') {
                        callback();
                    }
                }
            }
        });
    }
});
