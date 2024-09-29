// FilmNote/src/main/webapp/js/userWithdraw.js
$(document).ready(function() {
	$('#withdrawBtn').prop('disabled', true);
	
	// 체크박스 상태에 따라 버튼 활성화/비활성화
	$('#checkbox').change(function() {
		$('#withdrawBtn').prop('disabled', !this.checked);
	});

	$('#withdrawBtn').on('click', function() {
		// 체크박스가 선택되지 않은 경우 경고 메시지
		if (!$('#checkbox').is(':checked')) {
			alert('안내 사항에 동의해야 탈퇴할 수 있습니다.');
			return;
		}

		if (confirm('그래도 탈퇴하시겠습니까?')) {
			$.ajax({
				url: '/FilmNote/user/userWithdrawDB.do',
				type: 'POST',
				success: function(response) {
					console.log('Response from server:', response);
					if (response.trim() === 'success') {
						alert('회원탈퇴 완료');
						location.href = '/FilmNote/index.do';
					} else {
						alert('오류: ' + response);
					}
				},
				error: function(xhr, status, error) {
					console.log('Error details:', xhr, status, error);
					alert('서버와의 통신 중 오류가 발생했습니다.');
				}
			});
		}
	});
});