// FilmNote/src/main/webapp/js/userEdit.js

//이메일
$('#emailSelect').change(function() {
	$('#email2').val($('#emailSelect').val());
});


//유효성 검사 함수
function userEdit() {
	let isValid = true;

	$('#unameDiv').empty();
	$('#uidDiv').empty();
	$('#upwdDiv').empty();
	$('#reupwdDiv').empty();
	$('#nowupwdDiv').empty()

	if ($('#uname').val().trim() === '') {
		$('#unameDiv').html('이름').css('color','red');
		$('#uname').focus();
		return false;
	}

	if ($('#uid').val().trim() === '') {
		$('#uidDiv').html('아이디').css('color','red');
		$('#uid').focus();
		return false;
	}

	if ($('#nowupwd').val().trim() === '') {
		$('#nowupwdDiv').html('현재 비밀번호를 입력해주세요').css('color', 'red');
		$('#nowupwd').focus();
		return false;
	} else {
		if ($('#upwd').val().trim() === '') {
			$('#upwdDiv').html('수정할 비밀번호를 입력해주세요').css('color', 'red');
			$('#upwd').focus();
			return false;
		}
		if ($('#upwd').val() !== $('#reupwd').val()) {
			$('#reupwdDiv').html('수정할 비밀번호 췤!').css('color', 'red');
			$('#reupwd').focus();
			return false;
		}
	}

	return isValid;
}

// 포커스 아웃 이벤트 추가
$('#uname').blur(function() {
	if ($(this).val().trim() === '') {
		$('#unameDiv').html('이름을 입력해주세요.').css('color', 'red');
	} else {
		$('#unameDiv').empty(); // 올바르게 입력된 경우 메시지 제거
	}
});

$('#uid').blur(function() {
	if ($(this).val().trim() === '') {
		$('#uidDiv').html('아이디를 입력해주세요.').css('color', 'red');
	} else {
		$('#uidDiv').empty();
	}
});

$('#nowupwd').blur(function() {
	if ($(this).val().trim() === '') {
		$('#nowupwdDiv').html('현재 비밀번호를 입력해주세요.').css('color', 'red');
	} else {
		$('#nowupwdDiv').empty();
	}
});

$('#upwd').blur(function() {
	if ($(this).val().trim() === '') {
		$('#upwdDiv').html('수정할 비밀번호를 입력해주세요.').css('color', 'red');
	} else if ($('#upwd').val() !== $('#reupwd').val() && $('#reupwd').val() !== '') {
		$('#upwdDiv').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
	} else {
		$('#upwdDiv').empty();
	}
});

$('#reupwd').blur(function() {
	if ($(this).val().trim() === '') {
		$('#reupwdDiv').html('수정하비밀번호를 다시 입력해주세요.').css('color', 'red');
	} else if ($('#upwd').val() !== $('#reupwd').val()) {
		$('#reupwdDiv').html('비밀번호가 일치하지 않습니다.').css('color', 'red');
	} else {
		$('#reupwdDiv').empty();
	}
});



//회원정보수정 버튼 클릭시
$('#userEditBtn').click(function() {
	if (userEdit()) {
		let nowupwd = $('#nowupwd').val();
		let uid = $('#uid').val();

		//현재 비밀번호 확인용 AJax
		$.ajax({
			type: 'POST',
			url: '/FilmNote/user/userPwdCheck.do', //비밀번호 확인 URL
			data: { uid: uid, nowupwd: nowupwd },
			success: function(response) {
				if (response.valid) { //비밀번호가 일치한다면
					let serializedData = $('#userEditForm').serialize();

					//회원정보 수정 AJax
					$.ajax({
						type: 'post',
						url: '/FilmNote/user/userEditDB.do',
						data: serializedData,
						contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
						success: function(response) {
							console.log('Response:', response);
							alert('회원정보 수정완료');
							location.href = '/FilmNote/index.do';
						},
						error: function(e) {
							console.log(e);
						}
					});
				} else {
					$('#nowupwdDiv').html('현재 비밀번호가 일치하지 않습니다.').css('color', 'red');
					$('#nowupwd').focus();
				}
			}, error: function(e) {
				console.log('비밀번호 확인 중 오류가 발생 :', e);
			}
		});
	}
});

//회원탈퇴 
$('#withdrawBtn').click(function() {
	window.location.href = '/FilmNote/user/userWithdraw.do';
});
