$(function(){
    // 아이디 중복 체크
    $('#id').focusout(function(){
        console.log("focusout 이벤트 발생"); // 디버깅을 위한 로그
        $('#idDiv').empty(); // 이전 메시지 제거

        var userId = $('#id').val(); // 입력된 아이디 값

        // 아이디가 입력되지 않았을 경우 메시지 출력
        if(userId == '') {
            $('#idDiv').html('<span style="color:red;">아이디를 입력해주세요.</span>');
        } else {
            // AJAX로 서버에 아이디 중복 체크 요청 (가상의 URL로 설정)
            $.ajax({
                url: '${pageContext.request.contextPath}/user/checkId', // 아이디 중복 체크를 위한 서버 URL
                type: 'POST',
                data: { id: userId }, // 서버로 보낼 데이터
                success: function(response) {
                    if(response.isDuplicate) {
                        // 중복 아이디일 경우 메시지 출력
                        $('#idDiv').html('<span style="color:red;">이미 사용 중인 아이디입니다.</span>');
                    } else {
                        // 사용 가능한 아이디일 경우 메시지 출력
                        $('#idDiv').html('<span style="color:green;">사용 가능한 아이디입니다.</span>');
                    }
                },
                error: function() {
                    // 오류 발생 시 메시지 출력
                    $('#idDiv').html('<span style="color:red;">아이디 확인 중 오류가 발생했습니다.</span>');
                }
            });
        }
    });
});
