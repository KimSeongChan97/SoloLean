$(function() {
    $('#id').focusout(function() {
        $('#idDiv').empty();

        if ($('#id').val() == '') {
            $('#idDiv').html('먼저 아이디를 입력하세요');
            $('#idDiv').removeClass('success').addClass('error show');
        } else {
            $.ajax({
                type: 'post',
                url: '/user/getExistId',
                data: { 'id': $('#id').val() },
                dataType: 'text',
                success: function(data) {
                    if (data == 'exist') {
                        $('#idDiv').html('존재하는 아이디 입니다.');
                        $('#idDiv').removeClass('success').addClass('error show');
                    } else if (data == 'non_exist') {
                        $('#idDiv').html('사용 가능한 아이디 입니다.');
                        $('#idDiv').removeClass('error').addClass('success show');
                    }
                },
                error: function(e) {
                    console.log(e);
                }
            });
        }
    });

    $('#writeBtn').click(function(event) {
        event.preventDefault();
        $('#nameDiv').empty();
        $('#idDiv').empty();
        $('#pwdDiv').empty();

        if ($('#name').val() == '') {
            $('#nameDiv').html('이름을 입력하세요');
        } else if ($('#id').val() == '') {
            $('#idDiv').html('아이디를 입력하세요');
        } else if ($('#pwd').val() == '') {
            $('#pwdDiv').html('비밀번호를 입력하세요');
        } else {
            $.ajax({
                type: 'post',
                url: '/user/write',
                data: $('#userWriteForm').serialize(),
                success: function() {
                    $('#alertModalBody').text('회원가입 완료');
                    $('#alertModal').modal('show');
                    $('#alertModal').on('hidden.bs.modal', function() {
                        location.href = '/';
                    });
                },
                error: function(e) {
                    console.log(e);
                }
            });
        }
    });
});
