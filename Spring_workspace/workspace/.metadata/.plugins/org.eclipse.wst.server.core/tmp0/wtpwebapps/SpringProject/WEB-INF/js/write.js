$(function(){
    // 아이디 중복 체크
    $('#id').focusout(function(){ 
        $('#idDiv').empty(); // 기존 오류 메시지를 삭제합니다.

        // 아이디 필드가 비어 있는지 확인
        if($('#id').val() == '') {
            $('#idDiv').html('먼저 아이디를 입력하세요'); // 아이디가 비어 있을 때 출력될 메시지
            $('#idDiv').removeClass('success').addClass('error show'); // 오류 스타일을 적용합니다.
        }
        else {
            // 서버에 Ajax 요청을 보내 아이디 중복을 확인
            $.ajax({
                type: 'post', // POST 방식으로 데이터를 전송
                url: '/spring/user/getExistId', // 서버에서 아이디 중복 확인을 처리하는 URL
                data: 'id=' + $('#id').val(), // 입력된 아이디를 서버로 전송
                dataType: 'text', // 서버로부터 받는 데이터는 텍스트 형식
                success: function(data){ // 서버가 성공적으로 응답을 반환했을 때
                    if(data == 'exist') { // 응답이 'exist'이면 아이디가 이미 존재함
                        $('#idDiv').html('존재하는 아이디 입니다.'); // 중복된 아이디일 때 메시지
                        $('#idDiv').removeClass('success').addClass('error show'); // 오류 스타일을 적용
                    } else { // 아이디가 중복되지 않았을 때
                        $('#idDiv').html('사용 가능한 아이디 입니다.'); // 사용 가능한 아이디일 때 메시지
                        $('#idDiv').removeClass('error').addClass('success show'); // 성공 스타일을 적용
                    }
                },
                error: function(e){ // 서버 요청에 실패했을 때 오류를 콘솔에 출력
                    console.log(e);    
                }
            });   
        }
    });

    // 등록 버튼 클릭 이벤트
    $('#writeBtn').click(function(){
        // 기존 오류 메시지 초기화
        $('#nameDiv').empty();
        $('#idDiv').empty();
        $('#pwdDiv').empty();

        // 각 필드가 비어 있는지 확인
        if($('#name').val() == '')
            $('#nameDiv').html('이름을 입력하세요'); // 이름이 비어 있으면 메시지 출력
        else if($('#id').val() == '')
            $('#idDiv').html('아이디를 입력하세요'); // 아이디가 비어 있으면 메시지 출력
        else if($('#pwd').val() == '')
            $('#pwdDiv').html('비밀번호를 입력하세요'); // 비밀번호가 비어 있으면 메시지 출력
        else
            // 모든 필드가 입력되었을 때 서버로 데이터 전송
            $.ajax({
                type: 'post', // POST 방식으로 데이터 전송
                url: '/spring/user/write', // 회원가입을 처리하는 서버 URL
                data: $('#userWriteForm').serialize(), // 폼 데이터를 직렬화하여 서버로 전송
                success: function(){ // 서버 요청이 성공하면
                    alert('회원가입 완료'); // 회원가입 완료 메시지 출력
                    location.href = '/spring/user/list?pg=1'; // 회원가입 후 회원 목록 페이지로 이동
                },
                error: function(e){ // 서버 요청이 실패했을 때 오류 출력
                    console.log(e);    
                }
            });

    });
});
