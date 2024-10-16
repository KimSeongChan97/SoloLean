$(function(){
    // 회원 탈퇴 버튼 클릭 이벤트
    // 사용자가 "회원탈퇴" 버튼을 클릭할 때 실행될 로직을 정의합니다.
    $('#deleteBtn').click(function(){
        $('#pwdDiv').empty(); // 기존 오류 메시지 초기화
        // 사용자가 이전에 입력한 비밀번호 오류 메시지를 삭제하여, 새로 입력된 비밀번호와 관련된 메시지만 보여줍니다.

        if ($('#pwd').val() == '') { // 비밀번호 입력란이 비어있는지 확인합니다.
            $('#pwdDiv').html('먼저 비밀번호를 입력하세요'); // 비밀번호 입력 검증
            // 사용자가 비밀번호를 입력하지 않고 탈퇴를 시도하면, 비밀번호 입력을 요구하는 메시지를 보여줍니다.
        } else {
            // 서버로 ID와 비밀번호를 보내 비밀번호 확인 요청
            // 여기서는 사용자가 입력한 ID를 서버로 전송하여, 해당 ID의 비밀번호를 서버에서 확인하는 작업을 진행합니다.
            $.ajax({
                type: 'post', // POST 방식으로 데이터 전송
                // POST 방식은 데이터를 보낼 때 URL에 노출되지 않도록 안전하게 서버에 전달하는 방식입니다.
                url: '/spring/user/getExistPwd', // 서버에서 처리할 URL 경로
                // 비밀번호 검증을 위해 서버에서 처리할 URL로 요청을 보냅니다. 이 URL은 서버에서 ID와 비밀번호를 비교하는 로직을 처리합니다.
                data: { id: $('#id').val() }, // 유저 ID 전송 (객체 형식)
                // 데이터로 사용자의 ID를 서버에 전달합니다. 여기서는 jQuery의 val() 함수를 사용해 입력된 ID 값을 가져옵니다.
                dataType: 'json', // 서버에서 받을 데이터 형식
                // 서버가 응답하는 데이터 형식은 JSON(자바스크립트 객체 형태)입니다. 이 형식은 데이터를 구조화된 형태로 쉽게 처리할 수 있습니다.
                success: function(data) {
                    // 서버 응답에서 받은 비밀번호와 입력한 비밀번호 비교
                    // 서버가 성공적으로 비밀번호를 응답하면, 클라이언트에서 입력된 비밀번호와 서버 응답의 비밀번호를 비교합니다.
                    if (data.pwd === $('#pwd').val()) {
                        // 서버에서 받은 비밀번호(data.pwd)와 사용자가 입력한 비밀번호($('#pwd').val())가 일치하는지 확인합니다.
                        // 비밀번호가 일치하는 경우, 삭제 요청 진행
                        if (confirm('정말로 삭제하시겠습니까?')) {
                            // 비밀번호가 일치하면 사용자에게 최종 확인을 위해 `confirm` 창을 띄웁니다.
                            // `confirm` 창은 확인(true)을 누르면 진행되고, 취소(false)를 누르면 중단됩니다.
                            $.ajax({
                                type: 'post', // POST 방식으로 데이터 전송
                                // 비밀번호 확인이 완료된 후, 회원 삭제 요청을 서버에 POST 방식으로 전송합니다.
                                url: '/spring/user/delete', // 회원 삭제 URL
                                // 회원 삭제를 처리할 서버 측 URL로 요청을 보냅니다.
                                data: { id: $('#id').val() }, // 삭제할 ID 전송 (객체 형식)
                                // 삭제하려는 회원의 ID를 서버로 전송합니다.
                                success: function() {
                                    alert('회원정보 삭제 완료');
                                    // 회원 탈퇴가 성공적으로 처리되면 사용자에게 알림 메시지를 표시합니다.
                                    location.href = '/spring/user/list?pg=' + $('#pg').val(); // 탈퇴 후 페이지 이동
                                    // 탈퇴가 완료되면 회원 목록 페이지로 이동합니다. 이동할 페이지의 `pg` 값은 현재 페이지 번호입니다.
                                },
                                error: function(e) {
                                    console.log(e); // 오류 발생 시 콘솔에 출력
                                    // 만약 서버 요청이 실패할 경우, 오류 내용을 콘솔에 출력하여 개발자가 원인을 확인할 수 있도록 합니다.
                                }
                            });
                        }
                    } else {
                        $('#pwdDiv').html('비밀번호 불일치');
                        // 비밀번호가 일치하지 않으면, 비밀번호 불일치 메시지를 사용자에게 보여줍니다.
                    }
                },
                error: function(e) {
                    console.log(e); // 오류 발생 시 콘솔에 출력
                    // 서버 요청 중 에러가 발생하면, 그 내용을 브라우저 콘솔에 출력하여 개발자가 문제를 추적할 수 있도록 합니다.
                }
            });
        }
    });
});
