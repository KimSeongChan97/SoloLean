//이메일 선택 시, email2 input에 자동으로 값을 설정
$('#emailSelect').change(function() {
	$('#email2').val($('#emailSelect').val()); // 이메일 도메인 값을 email2에 설정
});


//유효성 검사 함수
function userEdit() {
	let isValid = true; // 폼이 유효한지 확인하는 플래그

	// 기존의 경고 메시지 제거
	$('#unameDiv').empty();
	$('#uidDiv').empty();
	$('#upwdDiv').empty();
	$('#reupwdDiv').empty();
	$('#nowupwdDiv').empty();

	// 이름 필드가 비었을 경우 경고 메시지 출력
	if ($('#uname').val().trim() === '') {
		$('#unameDiv').html('이름을 입력해주세요.').css('color', 'red');
		$('#uname').focus(); // 해당 필드에 포커스 이동
		return false;
	}

	// 아이디 필드가 비었을 경우 경고 메시지 출력
	if ($('#uid').val().trim() === '') {
		$('#uidDiv').html('아이디를 입력해주세요.').css('color', 'red');
		$('#uid').focus();
		return false;
	}

	// 현재 비밀번호가 입력되지 않았을 경우 처리
	if ($('#nowupwd').val().trim() === '') {
		$('#nowupwdDiv').html('현재 비밀번호를 입력해주세요').css('color', 'red');
		$('#nowupwd').focus();
		return false;
	} else {
		// 새로운 비밀번호가 입력되지 않았을 경우 처리
		if ($('#upwd').val().trim() === '') {
			$('#upwdDiv').html('수정할 비밀번호를 입력해주세요').css('color', 'red');
			$('#upwd').focus();
			return false;
		}
		// 새로운 비밀번호와 재입력된 비밀번호가 일치하지 않을 경우 처리
		if ($('#upwd').val() !== $('#reupwd').val()) {
			$('#reupwdDiv').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
			$('#reupwd').focus();
			return false;
		}
	}

	return isValid; // 유효성 검사를 모두 통과하면 true 반환
}

// 포커스 아웃 이벤트 - 이름 필드 유효성 검사
$('#uname').blur(function() {
	if ($(this).val().trim() === '') {
		$('#unameDiv').html('이름을 입력해주세요.').css('color', 'red');
	} else {
		$('#unameDiv').empty(); // 입력이 올바른 경우 메시지 제거
	}
});

// 포커스 아웃 이벤트 - 아이디 필드 유효성 검사
$('#uid').blur(function() {
	if ($(this).val().trim() === '') {
		$('#uidDiv').html('아이디를 입력해주세요.').css('color', 'red');
	} else {
		$('#uidDiv').empty();
	}
});

// 포커스 아웃 이벤트 - 현재 비밀번호 필드 유효성 검사
$('#nowupwd').blur(function() {
	if ($(this).val().trim() === '') {
		$('#nowupwdDiv').html('현재 비밀번호를 입력해주세요.').css('color', 'red');
	} else {
		$('#nowupwdDiv').empty();
	}
});

// 포커스 아웃 이벤트 - 새로운 비밀번호 필드 유효성 검사
$('#upwd').blur(function() {
	if ($(this).val().trim() === '') {
		$('#upwdDiv').html('수정할 비밀번호를 입력해주세요.').css('color', 'red');
	} else if ($('#upwd').val() !== $('#reupwd').val() && $('#reupwd').val() !== '') {
		$('#upwdDiv').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
	} else {
		$('#upwdDiv').empty();
	}
});

// 포커스 아웃 이벤트 - 비밀번호 재입력 필드 유효성 검사
$('#reupwd').blur(function() {
	if ($(this).val().trim() === '') {
		$('#reupwdDiv').html('비밀번호를 다시 입력해주세요.').css('color', 'red');
	} else if ($('#upwd').val() !== $('#reupwd').val()) {
		$('#reupwdDiv').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
	} else {
		$('#reupwdDiv').empty();
	}
});

//회원정보수정 버튼 클릭 시
$('#userEditBtn').click(function() {
	if (userEdit()) { // 유효성 검사가 통과되었을 경우
		let nowupwd = $('#nowupwd').val(); // 현재 비밀번호 값
		let uid = $('#uid').val(); // 사용자 아이디

		//현재 비밀번호 확인용 Ajax 요청
		$.ajax({
			type: 'POST',
			url: '/FilmNote/user/userPwdCheck.do', // 비밀번호 확인 URL
			data: { uid: uid, nowupwd: nowupwd }, // 전송 데이터
			success: function(response) {

				if (response.pwdCheck) { // 비밀번호가 일치하는 경우
					let serializedData = $('#userEditForm').serialize(); // 폼 데이터 직렬화

					//회원정보 수정 Ajax 요청
					$.ajax({
						type: 'post',
						url: '/FilmNote/user/userEditDB.do', // 회원정보 수정 URL
						data: serializedData,
						contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
						success: function(response) {
							console.log('Response:', response);
							alert('회원정보 수정완료'); // 성공 시 알림
							location.href = '/FilmNote/index.do'; // 메인 페이지로 리다이렉트
						},
						error: function(e) {
							console.log(e); // 오류 발생 시 처리
						}
					});
				} else {
					// 비밀번호가 일치하지 않을 경우 경고 메시지 출력
					$('#nowupwdDiv').html('현재 비밀번호가 일치하지 않습니다.').css('color', 'red');
					$('#nowupwd').focus();
				}
			}, error: function(e) {
				console.log('비밀번호 확인 중 오류가 발생 :', e); // 비밀번호 확인 중 오류 처리
			}
		});
	}
});

//회원탈퇴 버튼 클릭 시 탈퇴 페이지로 이동
$('#withdrawBtn').click(function() {
	window.location.href = '/FilmNote/user/userWithdraw.do'; // 회원 탈퇴 페이지로 이동
});
