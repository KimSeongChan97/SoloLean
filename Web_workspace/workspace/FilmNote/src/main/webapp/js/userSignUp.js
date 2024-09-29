$(document).ready(function() {
    // 회원가입 버튼 클릭 이벤트: 회원가입 버튼을 클릭할 때 실행되는 로직
    $('#signUp').click(function(e) {
        e.preventDefault(); // 기본 폼 제출 방지
        clearMessages(); // 이전에 남아있던 경고 메시지를 모두 숨김
        if (validateForm()) { // 폼 검증이 통과되면
            $.ajax({
                url: $('#signUpForm').attr('action'), // 폼 action 속성에서 URL을 가져와 요청 전송
                type: 'POST', // POST 방식으로 데이터 전송
                data: $('#signUpForm').serialize(), // 폼 데이터를 직렬화하여 전송
                success: function(response) {
					console.log("서버 응답: ", response);  // 서버에서 받은 응답을 콘솔에 출력
                    if (response.status === "success") { // 응답 상태가 성공이면
                        showModal(response.message, function() { // 모달 창을 띄운 후
                            window.location.href = contextPath + '/user/userSignIn.do'; // 로그인 페이지로 이동
                        });
                    } else {
                        showWarningMessage('회원가입 중 오류가 발생했습니다'); // 오류 메시지 표시
                    }
                },
                error: function() {
                    showWarningMessage('회원가입 중 오류가 발생했습니다'); // 오류 발생 시 경고 메시지 표시
                }
            });
        }
    });

    // 이메일 도메인 자동 입력 기능: 이메일 도메인 선택 시 해당 값이 입력창에 자동 입력됨
    $('#emailSelect').change(function() {
        $('#email2').val($('#emailSelect').val());
    });

    // ID 입력 필드 focusout 이벤트: 입력한 ID가 빈 값이 아니면 중복 체크 실행
    $('#uid').on('focusout', function() {
        let uid = $(this).val().trim(); // ID 입력값을 가져옴
        if (uid === '') { // ID가 빈 값이면 경고 메시지 표시
            showWarningMessage('아이디를 입력하세요.');
        } else {
            checkIdDuplicate(uid); // ID 중복 체크 실행
        }
    });

    // 비밀번호 입력 필드 focusout 이벤트: 비밀번호가 올바르게 입력되었는지 검증
    $('#upwd').on('focusout', function() {
        validateField($(this)); // 필드 검증 함수 호출
    });

    // 비밀번호 확인 입력 필드 focusout 이벤트: 비밀번호 확인 필드 검증
    $('#repwd').on('focusout', function() {
        validateField($(this)); // 필드 검증 함수 호출
    });

    // ID 중복 체크 함수: 서버에 ID 중복 여부를 체크하는 요청을 보냄
    function checkIdDuplicate(uid) {
        $.ajax({
            url: contextPath + '/user/checkId.do', // ID 중복 체크를 위한 서버 URL
            type: 'POST', // POST 방식으로 데이터 전송
            data: { uid: uid }, // 서버에 전송할 데이터 (ID)
            success: function(response) {
                if (response.exists) { // 서버 응답으로 ID가 존재하면
                    showWarningMessage('존재하는 아이디 입니다'); // 중복된 ID 경고 메시지 표시
                } else {
                    showWarningMessage('사용 가능한 아이디 입니다', true); // 사용 가능한 ID 메시지 표시 (녹색)
                }
            },
            error: function(xhr, status, error) {
                showWarningMessage('ID 체크 중 오류가 발생했습니다'); // 서버 오류 발생 시 경고 메시지 표시
            }
        });
    }

    // 필드 검증 함수: 특정 필드의 유효성을 검증하는 함수
    function validateField(field) {
        let id = field.attr('id'); // 필드의 ID 가져오기
        let value = field.val().trim(); // 필드 값 가져오기
        let messages = { // 각 필드별로 출력할 메시지 설정
            'uid': '아이디를 입력하세요.',
            'upwd': '비밀번호를 입력하세요.',
            'repwd': '비밀번호를 재확인하세요.'
        };

        // 필드가 비어있을 때 경고 메시지 표시
        if (value === '') {
            showWarningMessage(messages[id]);
            return false;
        } else {
            // 비밀번호 필드의 경우 추가적인 유효성 검증 수행
            if (id === 'upwd') {
                if (!validatePassword(value)) { // 비밀번호 유효성 검사 실패 시
                    showWarningMessage('비밀번호는 영어 대소문자, 숫자, 특수문자 1가지씩은 포함되어야 합니다.');
                    return false;
                } else {
                    showWarningMessage('올바른 비밀번호 형식입니다', true); // 성공 메시지
                    return true;
                }
            } else if (id === 'repwd') { // 비밀번호 확인 필드의 경우
                if (value !== $('#upwd').val()) { // 비밀번호가 일치하지 않으면 경고 메시지
                    showWarningMessage('비밀번호가 일치하지 않습니다.');
                    return false;
                } else {
                    showWarningMessage('비밀번호가 일치합니다', true); // 성공 메시지
                    return true;
                }
            } else {
                return true; // 다른 필드의 경우 통과
            }
        }
    }

    // 경고 메시지 표시 함수: 경고 또는 성공 메시지를 출력하는 함수
    function showWarningMessage(message, success = false) {
        const messageDiv = $('#warningMessage'); // 경고 메시지를 표시할 div
        messageDiv.html(message); // 메시지 설정
        if (success) {
            messageDiv.css('color', '#2ecc71'); // 성공 메시지 색상 설정 (녹색)
        } else {
            messageDiv.css('color', '#e74c3c'); // 경고 메시지 색상 설정 (빨간색)
        }
        messageDiv.show(); // 메시지 표시
    }

    // 경고 메시지 숨기기 함수: 경고 메시지를 숨기는 함수
    function clearMessages() {
        $('#warningMessage').hide(); // 경고 메시지 영역을 숨김
    }

    // 비밀번호 유효성 검사 함수: 비밀번호가 규칙에 맞는지 검증
    function validatePassword(password) {
        const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>]).{1,}$/; // 영문, 숫자, 특수문자가 포함된 패턴
        return regex.test(password); // 패턴에 맞는지 테스트
    }

    // 폼 전체 유효성 검증 함수: ID와 비밀번호 필드를 검증
    function validateForm() {
        let isValid = true; // 폼이 유효한지 여부
        let firstInvalidField = null; // 유효성 검사를 통과하지 못한 첫 번째 필드

        // ID, 비밀번호, 비밀번호 확인 필드 검증
        $('#uid, #upwd, #repwd').each(function() {
            if (!validateField($(this))) {
                isValid = false; // 하나라도 통과하지 못하면 false로 설정
                if (!firstInvalidField) {
                    firstInvalidField = $(this); // 첫 번째로 통과하지 못한 필드를 저장
                }
            }
        });

        // 유효성 검사를 통과하지 못하면 경고 메시지 출력 및 첫 번째 필드에 포커스 이동
        if (!isValid && firstInvalidField) {
            showWarningMessage('필수 입력값을 입력하세요.');
            firstInvalidField.focus(); // 첫 번째 잘못된 필드에 포커스 이동
        }

        return isValid; // 모든 필드가 유효하면 true 반환
    }

    // 모달 표시 함수: 메시지를 담은 모달 창을 띄우고 콜백 실행
    function showModal(message, callback) {
        $('#dialogMessage').text(message); // 모달에 메시지 설정
        $('#dialog').dialog({ // jQuery UI 다이얼로그 생성
            modal: true, // 모달 형식으로 설정
            buttons: {
                "확인": function() { // 확인 버튼 클릭 시
                    $(this).dialog("close"); // 모달 닫기
                    if (typeof callback === 'function') { // 콜백 함수가 있으면 실행
                        callback();
                    }
                }
            }
        });
    }
});
