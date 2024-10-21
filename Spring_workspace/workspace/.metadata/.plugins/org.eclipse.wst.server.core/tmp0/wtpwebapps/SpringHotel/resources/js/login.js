function login() {
	var isOk = true;

	if($('#userid').val() == '') {
		$('#idDiv').text('아이디를 입력하세요.')
		$('#idDiv').css('color', 'red');
		$('#idDiv').css('font-size', '8pt');
		isOk = false;
	}

	if($('#pwd').val() == '') {
		$('#pwdDiv').text('비밀번호를 입력하세요.')
		$('#pwdDiv').css('color', 'red');
		$('#pwdDiv').css('font-size', '8pt');
		isOk = false;
	}
	
	if(isOk) {
		$.ajax({
			type: 'post',
			url: '/SpringHotel/user/login/sh',
			data: {
				'userid' : $('#userid').val(),
				'pwd' : $('#pwd').val()
			},
			dataType: 'text',
			success: function(data) {
				if(data == 'true') {
					console.log('SH 로그인 성공');
					alert("환영합니다.");
					location.href="/SpringHotel";
				}else {
					console.log('SH 로그인 실패');
					alert("아이디 혹은 비밀번호가 틀렸습니다.");
				}
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
}

$(function() {
	// 초기화
	$('#userid').blur(function() {
		$('#idDiv').text('')
	});
	
	$('#pwd').blur(function() {
		$('#pwdDiv').text('')
	});
	
	// 로그인
	$('#loginBtn').click(login);
});