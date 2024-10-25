$(document).ready(function() {
    // 회원 탈퇴 버튼을 비활성화된 상태로 설정 (체크박스가 선택되기 전까지 비활성화)
    $('#withdrawBtn').prop('disabled', true);

    // 체크박스 상태에 따라 탈퇴 버튼의 활성화/비활성화 처리
    $('#withdrawbox').change(function() {
        console.log("Checkbox state changed:", this.checked); // 체크박스 상태가 변경될 때 콘솔에 출력
        // 체크박스가 선택된 경우 탈퇴 버튼을 활성화, 선택되지 않으면 비활성화
        $('#withdrawBtn').prop('disabled', !this.checked);
    });

    // 탈퇴 버튼 클릭 시 실행
    $('#withdrawBtn').click(function() {
        // 비밀번호 입력 필드가 비어있는지 확인
        if ($('#nowpwd').val().trim() === '') {
            // 비밀번호 입력 경고 메시지 출력
            $('#nowupwdDiv').html('비밀번호를 입력해주세요').css('color', 'red');
            $('#nowpwd').focus(); // 비밀번호 입력 필드로 포커스를 이동
            return; // 함수 종료 (이후 코드 실행 중지)
        }

        // 체크박스가 선택되지 않은 경우 경고 메시지 출력
        if (!$('#withdrawbox').is(':checked')) {
            alert('안내 사항에 동의해야 탈퇴할 수 있습니다.'); // 체크박스가 선택되지 않으면 경고창 표시
            return; // 함수 종료
        }

        // 사용자에게 탈퇴 의사를 다시 한 번 확인하는 메시지 창
        if (confirm('그래도 탈퇴하시겠습니까?')) {
            // 사용자가 탈퇴를 확인한 경우, 서버에 비밀번호를 포함한 탈퇴 요청을 AJAX로 전송
            $.ajax({
                url: '/FilmNote/user/userWithdrawDB.do', // 서버에 요청을 보낼 URL
                type: 'POST', // POST 방식으로 데이터를 전송
                data: {
                    nowpwd: $('#nowpwd').val().trim() // 비밀번호 입력 값 전송
                },
                success: function(response) {
                    // 서버 응답이 성공인 경우
                    console.log('Response from server:', response); // 서버 응답을 콘솔에 출력
                    if (response.trim() === 'success') {
                        alert("회원탈퇴 성공"); // 성공 메시지 출력
                        location.href = '/FilmNote/index.do'; // 탈퇴 후 메인 페이지로 이동
                    } else {
                        // 탈퇴 실패 시 오류 메시지 출력
                        alert('오2류: ' + response);
                    }
                },
                error: function(xhr, status, error) {
                    // 서버와의 통신 중 오류가 발생한 경우 실행
                    console.log('Error details:', xhr, status, error); // 오류 내용을 콘솔에 출력
                    alert('서버와의 통신 중 오류가 발생했습니다.'); // 사용자에게 오류 메시지 출력
                }
            });
        }
    });
});
