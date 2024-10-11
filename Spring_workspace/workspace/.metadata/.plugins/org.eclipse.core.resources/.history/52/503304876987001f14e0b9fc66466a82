$(function(){
    // 수정 버튼 클릭 이벤트
    $('#updateBtn').click(function(){
        $('#nameDiv').empty(); // 이전 오류 메시지를 초기화
        $('#pwdDiv').empty();  // 이전 오류 메시지를 초기화

        // 이름 필드가 비어 있는지 확인
        if($('#name').val() == '') {
            $('#nameDiv').html('이름을 입력하세요'); // 이름이 비어있으면 오류 메시지를 출력
        } else if($('#pwd').val() == '') { // 비밀번호 필드가 비어 있는지 확인
            $('#pwdDiv').html('비밀번호를 입력하세요'); // 비밀번호가 비어있으면 오류 메시지를 출력
        } else {
            // 이름과 비밀번호가 모두 입력되었을 경우 서버로 데이터를 전송
            $.ajax({
                type: 'post', // POST 방식으로 데이터 전송
                url: '/spring/user/update', // 서버에서 처리할 URL 경로
                data: $('#userUpdateForm').serialize(), // 폼 데이터를 직렬화하여 전송
                success: function() {
                    alert('회원정보 수정 완료'); // 성공 시 알림 메시지
                    location.href = '/spring/user/list?pg=' + $('#pg').val(); // 수정 후 회원목록 페이지로 이동
                },
                error: function(e) {
                    console.log(e); // 오류 발생 시 콘솔에 오류 로그 출력
                }
            });
        }
    });

    // 회원 탈퇴 버튼 클릭 이벤트
    $('#deleteBtn').click(function(){
        if(confirm('정말로 탈퇴하시겠습니까?')) { // 탈퇴 확인 메시지
            $.ajax({
                type: 'post', // POST 방식으로 데이터 전송
                url: '/spring/user/delete', // 서버에서 처리할 URL 경로
                data: { id: $('#id').val() }, // 탈퇴할 유저의 ID를 전송
                success: function() {
                    alert('회원탈퇴 완료'); // 성공 시 알림 메시지
                    location.href = '/spring/user/list?pg=' + $('#pg').val(); // 탈퇴 후 회원목록 페이지로 이동
                },
                error: function(e) {
                    console.log(e); // 오류 발생 시 콘솔에 오류 로그 출력
                }
            });
        }
    });
});
