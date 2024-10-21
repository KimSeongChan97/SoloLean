// 아이디 중복 체크 
function checkId(focusId) {
    console.log("checkId()") // 아이디 체크 함수가 호출되었음을 로그로 표시
    console.log('data checkid: ' + $('#userid').data('checkid')); // #userid 요소의 'checkid' 데이터 속성을 콘솔에 출력
    
    // 만약 아이디 입력 필드가 비어있거나 포커스 된 아이디가 현재 값과 같다면 함수를 종료
    if($('#userid').val() == '' || focusId == $('#userid').val()) return;
    
    // Ajax 요청을 통해 서버에서 아이디 중복 여부를 확인
    $.ajax({
        type: 'get', // HTTP GET 방식 사용
        url: '/SpringHotel/user/checkUserId?userId=' + $('#userid').val(), // 서버의 아이디 체크 URL에 현재 아이디 값을 전달
        dataType: 'text', // 서버 응답 데이터 타입을 텍스트로 지정
        success: function(data) { // 서버로부터 응답이 성공적으로 오면 실행
            console.log(data.trim()); // 서버로부터 받은 데이터를 콘솔에 출력 (공백 제거)
            if(data.trim() == "true") { // 응답 데이터가 "true"일 경우 (아이디 사용 가능)
                $('#idDiv').text('사용 가능'); // idDiv 영역에 '사용 가능' 표시
                $('#idDiv').css('color', 'green'); // 글자 색상을 초록색으로 변경 (사용 가능함을 시각적으로 나타냄)
            }
            else { // 응답 데이터가 "true"가 아닐 경우 (아이디 사용 불가)
                $('#idDiv').text('사용 불가능'); // idDiv 영역에 '사용 불가능' 표시
                $('#idDiv').css('color', 'red'); // 글자 색상을 빨간색으로 변경 (사용 불가능함을 시각적으로 나타냄)
            }
        }
    })
}

// 회원가입 시, 유효성 검사 
function Join(e) {
    console.log('Join()'); // Join 함수가 호출되었음을 로그로 표시
    var isOk = true; // 유효성 검사를 통과하면 true, 통과하지 못하면 false

    // 초기화
    $('.infoText').each(function (index, item) { // 각 .infoText 요소들에 대해 반복
        if($(this).attr('id') != 'idDiv') { // id가 'idDiv'가 아닌 경우만 텍스트 초기화
            $(this).text(''); // 초기화
        }
    });
    
    // 1. 아이디 유효성 확인
    if($('#idDiv').text() == '사용 불가능') { // 'idDiv'에 '사용 불가능'이라고 되어 있으면
        $('#idDiv').text("아이디 중복체크 하세요."); // 사용자에게 중복 체크를 하라고 알림
        $('#idDiv').css('color', 'red'); // 알림 글씨를 빨간색으로 표시
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    }
    
    // 아이디가 작성되지 않았거나 '아이디를 작성하세요.'라는 메시지가 있을 경우
    if($('#userid').val() == '' || $('#idDiv').text() == '아이디를 작성하세요.') {
        $('#idDiv').text("아이디를 작성하세요."); // '아이디를 작성하세요' 알림 표시
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    }
    
    // 2. 비밀번호 유효성 확인
    if($('#pwd').val() == '') { // 비밀번호 입력란이 비어 있으면
        $('#pwdDiv').text("비밀번호를 작성하세요."); // 비밀번호 작성 요청 메시지 표시
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    }
    
    // 3. 이름 유효성 확인
    if($('#name').val() == '') { // 이름 입력란이 비어 있으면
        $('#nameDiv').text("이름을 작성하세요."); // 이름 작성 요청 메시지 표시
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    }

    // 4. 이메일 유효성 확인
    if($('#email').val() == '') { // 이메일 입력란이 비어 있으면
        $('#emailDiv').text("비밀번호를 작성하세요."); // 비밀번호 작성 요청 메시지 표시 (여기서 의도는 '이메일을 작성하세요'겠지만 코드 상에서 잘못된 텍스트가 사용됨)
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    }
    
    // 5. 생년월일 유효성 확인
    $('.birth').each(function (index, item) { // 각 .birth 입력란에 대해 반복
        if($(this).val() == '') { // 입력란이 비어 있으면
            $('#birthDiv').text("생년월일을 작성하세요."); // 생년월일 작성 요청 메시지 표시
            e.preventDefault(); // form 제출을 중단
            isOk = false; // 유효성 검사 실패
        } else if(index == 0 && $(this).val().length != 4) { // 첫 번째 입력란(연도)이 4자리가 아니면
            $('#birthDiv').text("태어난 해는 4자리 수로 입력하세요."); // 4자리 수로 입력하라는 메시지 표시
            e.preventDefault(); // form 제출을 중단
            isOk = false; // 유효성 검사 실패
        } else if((index == 1 || index == 2) && $(this).val().length > 2) { // 두 번째(월) 또는 세 번째(일) 입력란이 2자리를 초과하면
            $('#birthDiv').text("태어난 달과 일수는 1자리 또는 2자리로 입력하세요."); // 1자리 또는 2자리로 입력하라는 메시지 표시
            e.preventDefault(); // form 제출을 중단
            isOk = false; // 유효성 검사 실패
        }
    });

    // 6. 전화번호 유효성 확인
    $('.tel').each(function (index, item) { // 각 .tel 입력란에 대해 반복
        if($(this).val() == '') { // 입력란이 비어 있으면
            $('#telDiv').text("전화번호를 작성하세요."); // 전화번호 작성 요청 메시지 표시
            e.preventDefault(); // form 제출을 중단
            isOk = false; // 유효성 검사 실패
        } else if(index != 0 && $(this).val().length != 4) { // 첫 번째 입력란(국번)이 아닌 다른 입력란이 4자리가 아니면
            $('#telDiv').text("4자리 수를 작성하세요."); // 4자리로 입력하라는 메시지 표시
            e.preventDefault(); // form 제출을 중단
            isOk = false; // 유효성 검사 실패
        }
    });

    // 7. 인증번호 확인
    var enteredCode = $('#EmailCheckbutton').val(); // 사용자가 입력한 인증번호 값 가져오기
    var sentCode = $('#checkNum').val(); // 서버에서 발송된 인증번호 값 가져오기

    if (enteredCode === "") { // 인증번호를 입력하지 않은 경우
        $('#emailCheckDiv').text("인증번호를 입력하세요."); // 인증번호 입력 요청 메시지 표시
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    } else if (enteredCode !== sentCode) { // 입력한 인증번호와 발송된 인증번호가 일치하지 않으면
        $('#emailCheckDiv').text("인증번호가 일치하지 않습니다."); // 인증번호 불일치 메시지 표시
        e.preventDefault(); // form 제출을 중단
        isOk = false; // 유효성 검사 실패
    }
    
    // 유효성 검사가 모두 통과된 경우 (isOk가 true일 경우)
    if(isOk) {
        // Ajax 요청을 통해 회원가입 데이터를 서버로 전송
        $.ajax({
            type: 'post', // HTTP POST 방식 사용
            url: '/SpringHotel/user/join/submit', // 서버의 회원가입 처리 URL
            data: $('#joinForm').serialize(), // 회원가입 폼 데이터를 직렬화하여 서버로 전송
            success: function(data) { // 서버로부터 응답이 성공적으로 오면 실행
                console.log('회원가입'); // 회원가입 성공 로그 표시
                alert("회원가입을 축하합니다."); // 회원가입 성공 메시지 표시
                location.href="/SpringHotel"; // 회원가입 후 홈페이지로 이동
            },
            error: function(e) { // 서버 요청이 실패했을 때 실행
                console.log(e); // 에러 내용을 콘솔에 출력
                alert('실패'); // 회원가입 실패 메시지 표시
            }
        });
    }   
}

$(function() {
    // 1. id 중복 체크
    $('#userid').focus(function() { // userid 입력란에 포커스가 가면
        let focusId = $('#userid').val(); // 포커스 된 시점의 아이디 값을 저장
        $('#userid').blur(function() { // 포커스가 해제될 때 아이디 중복 체크
            checkId(focusId)
        });
    });
});

$(document).ready(function() {
    // 이메일 인증번호 발송 버튼 클릭 시
    $('#EmailSendbutton').on('click', function() {
        var email = $('#emailInput').val(); // 입력된 이메일 값 가져오기
        
        if (email === "") { // 이메일을 입력하지 않은 경우
            alert("이메일을 입력하세요."); // 이메일 입력 요청 메시지 표시
            return;
        }

        // 이메일 인증번호 발송을 위해 서버에 Ajax 요청
        $.ajax({
            url: "/SpringHotel/user/EmailAuth", // 이메일 인증번호 발송을 처리하는 서버 URL
            type: "POST", // HTTP POST 방식 사용
            data: {email: email}, // 이메일 데이터를 서버에 전송
            success: function(checkNum) { // 서버로부터 인증번호를 성공적으로 받으면 실행
                alert("인증번호가 이메일로 발송되었습니다. 이메일을 확인하고 인증번호를 입력하세요."); // 인증번호 발송 성공 메시지
                $('#checkNum').val(checkNum);  // 서버에서 받은 인증번호를 checkNum input에 설정
            },
            error: function() { // 이메일 인증 실패 시 실행
                alert("이메일 인증에 실패했습니다. 다시 시도해주세요."); // 인증 실패 메시지
            }
        });
    });

    // 인증번호 확인 버튼 클릭 시
    $('#emailCheckBtn').on('click', function() {
        var enteredCode = $('#EmailCheckbutton').val(); // 사용자가 입력한 인증번호 값
        var sentCode = $('#checkNum').val(); // 서버에서 발송된 인증번호 값

        if (enteredCode === "") { // 인증번호를 입력하지 않은 경우
            $('#emailCheckDiv').text("인증번호를 입력하세요."); // 인증번호 입력 요청 메시지
            return;
        }

        if (enteredCode === sentCode) { // 입력한 인증번호와 발송된 인증번호가 일치하면
            $('#emailCheckDiv').text("인증이 성공적으로 완료되었습니다.").css('color', 'blue'); // 인증 성공 메시지 표시 및 색상 변경
        } else { // 입력한 인증번호와 발송된 인증번호가 일치하지 않으면
            $('#emailCheckDiv').text("인증번호가 일치하지 않습니다. 다시 확인해주세요.") // 인증 실패 메시지 표시
        }
    });
});
