$(function(){
    // 수정
    $('#updateBtn').click(function(){
        $('#nameDiv').empty();
        $('#pwdDiv').empty();

        if($('#name').val() == '') {
            $('#nameDiv').html('이름을 입력하세요');
        } else if($('#pwd').val() == '') {
            $('#pwdDiv').html('비밀번호를 입력하세요');
        } else {
            $.ajax({
                type: 'post',
                url: '/spring/user/update',
                data: $('#userUpdateForm').serialize(),
                success: function() {
                    alert('회원정보 수정 완료');
                    location.href = '/spring/user/list?pg=' + $('#pg').val();
                },
                error: function(e) {
                    console.log(e);
                }
            }); 
        }
    });
    
    // 삭제
    $('#deleteBtn').click(function(){
        if(confirm('정말로 탈퇴하시겠습니까?')) {
            $.ajax({
                type: 'post',
                url: '/spring/user/delete',
                data: { id: $('#id').val() },
                success: function() {
                    alert('회원탈퇴 완료');
                    location.href = '/spring/user/list?pg=' + $('#pg').val();
                },
                error: function(e) {
                    console.log(e);
                }
            });
        }
    });
    
});
