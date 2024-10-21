$(function(){
    // '객실 정보 업데이트' 폼 제출 시
    $('#updateRoomInfo').submit(function(event) {
        event.preventDefault(); // 폼의 기본 제출 동작을 막음

        let formData = new FormData(this); // 폼 데이터를 FormData 객체로 변환

        // 서버로 AJAX 요청을 보냄
        $.ajax({
            type: 'POST', // HTTP 메서드 설정
            url: '/SpringHotel/admin/update', // 서버의 URL
            enctype: 'multipart/form-data', // 파일 업로드를 위한 설정
            processData: false, // 데이터를 처리하지 않음 (파일 업로드 시 필요)
            contentType: false, // contentType을 false로 설정하여 jQuery가 설정하지 않도록 함
            data: formData, // 전송할 폼 데이터
            success: function(data) {
                // 서버 응답이 성공적이면, 객실 목록 페이지로 리다이렉트
                location.href = "/SpringHotel/admin/updateRoom";
            },
            error: function(e) {
                // 에러 발생 시 콘솔에 출력
                console.log(e);
            }
        });
    });

    // '댓글 작성' 버튼 클릭 시
    $('#commentWriteBtn').on('click', function(event) {
        event.preventDefault(); // 기본 폼 제출 방지

        // 작성된 댓글 데이터를 폼에서 가져와 formData로 만듦
        let formData = {
            comment: $('#comment22').val(), // 댓글 내용
            questionsId: $('input[name="questionsId"]').val(), // 질문 ID
            userName: $('input[name="userName"]').val() // 사용자 이름
        };

        console.log(formData); // formData 콘솔 출력 (디버깅용)

        // 댓글을 서버로 전송
        $.ajax({
            type: 'POST',
            url: '/SpringHotel/admin/writeComment', // 댓글 작성 서버 URL
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8', // 전송할 데이터의 형식 설정
            data: formData, // 전송할 데이터
            success: function(response) {
                // 성공 시 알림창을 띄우고 페이지 새로고침
                alert("댓글이 작성되었습니다.");
                location.reload();
            },
            error: function(error) {
                // 에러 발생 시 콘솔에 출력
                console.log(error);
            }
        });
    });

    // '로그인' 버튼 클릭 시
    $('#loginBtn').on('click', function(event) {
        event.preventDefault(); // 기본 폼 제출 방지

        // 로그인 폼 데이터 추출
        let formData = {
            adminId: $('#adminId').val(), // 관리자 ID
            pwd: $('#pwd').val() // 비밀번호
        };

        // 로그인 요청을 서버로 보냄
        $.ajax({
            type: 'POST', // POST 방식으로 데이터 전송
            url: '/SpringHotel/admin/loginForm', // 로그인 처리 서버 URL
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8', // 데이터 형식 설정
            data: formData, // 전송할 데이터
            success: function(data) {
                console.log(data); // 서버 응답 출력
                if (data === "로그인에 성공하였습니다.") {
                    // 로그인 성공 시 알림 후 메인 페이지로 이동
                    alert(data);
                    location.href = '/SpringHotel/';
                } else {
                    // 로그인 실패 시 메시지를 출력하고 빨간색으로 표시
                    $('#loginDiv').text(data).css('color', 'red');
                }
            },
            error: function(e) {
                // 서버 오류 발생 시
                console.log(e);
                $('#loginDiv').text("서버 오류가 발생했습니다.").css('color', 'red');
            }
        });
    });

    // 댓글 수정 버튼 클릭 시
    $('.updateCommentBtn').on('click', function() {
        const answerId = $(this).data('answerid'); // 수정할 댓글의 ID 가져오기
        $('#showContent' + answerId).hide(); // 기존 댓글 내용 숨기기
        $('#hideContent' + answerId).show(); // 수정 폼 표시
    });

    // '수정 완료' 버튼 클릭 시
    $(document).on('click', '#updateCommentBtn2', function() {
        const answerId = $(this).data('answerid'); // 댓글 ID 가져오기
        const comment = $('#hideContent' + answerId + ' textarea[name="comment"]').val(); // 수정된 댓글 내용
        const questionId = $('#hideContent' + answerId + ' input[name="questionId"]').val(); // 질문 ID 가져오기

        // 수정된 댓글을 서버로 전송
        $.ajax({
            type: 'POST',
            url: '/SpringHotel/admin/updateComment', // 댓글 수정 처리 서버 URL
            data: {
                answerId: answerId, // 댓글 ID
                comment: comment, // 수정된 댓글 내용
                questionId: questionId // 질문 ID
            },
            success: function(response) {
                if (response === "success") {
                    // 수정 성공 시 알림 후 페이지 새로고침
                    alert("댓글이 수정되었습니다.");
                    location.reload();
                } else {
                    alert("댓글 수정에 실패하였습니다.");
                }
            },
            error: function(error) {
                console.log(error);
                alert("서버 오류가 발생하였습니다.");
            }
        });
    });

    // 댓글 삭제 버튼 클릭 시
    $('.deleteCommentBtn').on('click', function() {
        const answerId = $(this).data('answerid'); // 삭제할 댓글의 ID 가져오기

        // 삭제 확인 대화상자
        if (confirm("정말로 이 댓글을 삭제하시겠습니까?")) {
            // 댓글 삭제 요청
            $.ajax({
                type: 'GET',
                url: '/SpringHotel/admin/deleteComment', // 댓글 삭제 처리 URL
                data: {
                    answerId: answerId // 댓글 ID
                },
                success: function(response) {
                    if (response === "success") {
                        alert("댓글이 삭제되었습니다.");
                        location.reload(); // 페이지 새로고침
                    } else {
                        alert("댓글 삭제에 실패하였습니다.");
                    }
                },
                error: function(error) {
                    console.log(error);
                    alert("서버 오류가 발생하였습니다.");
                }
            });
        }
    });

    // 질문 저장 버튼 클릭 시
    $(document).on('click', '#btn', function() {
        var qtypesId = document.getElementById("qtypesId").value; // 질문 유형 ID
        var content = document.getElementById("content").value; // 질문 내용

        // 질문 저장 요청
        $.ajax({
            type: "POST",
            url: "/SpringHotel/questions/save", // 질문 저장 서버 URL
            data: {
                qtypesId: qtypesId, // 질문 유형 ID
                content: content // 질문 내용
            },
            success: function(response) {
                alert("질문이 성공적으로 저장되었습니다!");
                location.href = '/SpringHotel/admin/inquiryList2'; // 질문 목록 페이지로 이동
            },
            error: function(xhr, status, error) {
                alert("문제가 발생했습니다: " + error);
            }
        });
    });

    // 질문 수정 버튼 클릭 시
    $(document).on('click', '#updateBtn', function() {
        let typename = $('#qtypesId').val(); // 질문 유형 ID
        let content = $('#content').val(); // 수정된 질문 내용
        let questionsId = $('input[name="questionsId"]').val(); // 질문 ID

        // 질문 ID가 유효하지 않을 경우
        if (!questionsId) {
            alert("질문 ID가 유효하지 않습니다.");
            return;
        }

        // 질문 수정 요청
        $.ajax({
            type: "POST",
            url: "/SpringHotel/inquiry/update", // 질문 수정 서버 URL
            data: {
                typename: typename, // 질문 유형 ID
                content: content, // 질문 내용
                questionsId: questionsId // 질문 ID
            },
            success: function(response) {
                alert("수정이 완료되었습니다.");
                location.href = "/SpringHotel/admin/inquiryList2"; // 수정 후 목록 페이지로 이동
            },
            error: function(xhr, status, error) {
                alert("오류 발생: " + error);
            }
        });
    });

    // 질문 삭제 버튼 클릭 시
    $(document).on('click', '#Deletebtn', function() {
        let questionsId = $('input[name="questionsId"]').val(); // 삭제할 질문 ID

        if (confirm("정말로 이 게시글을 삭제하시겠습니까?")) {
            // 질문 삭제 요청
            $.ajax({
                type: 'POST',
                url: '/SpringHotel/inquiry/delete', // 질문 삭제 서버 URL
                data: {
                    questionsId: questionsId // 질문 ID
                },
                success: function(response) {
                    if (response === "success") {
                        alert("게시글이 삭제되었습니다.");
                        location.href = "/SpringHotel/admin/inquiryList2"; // 삭제 후 목록 페이지로 이동
                    } else {
                        alert("게시글 삭제에 실패하였습니다.");
                    }
                },
                error: function(error) {
                    console.log(error);
                    alert("서버 오류가 발생하였습니다.");
                }
            });
        }
    });

    // 페이지 이동 버튼 클릭 시 (예: 목록 페이지 이동)
    $(document).on('click', '#btn', function() {
        location.href = '/SpringHotel/admin/inquiryList2'; // 목록 페이지로 이동
    });
});
