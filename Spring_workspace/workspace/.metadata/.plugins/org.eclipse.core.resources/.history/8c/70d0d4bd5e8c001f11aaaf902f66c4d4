$(document).ready(function() {
	
    // Update button click
    $('.update-btn').click(function() {
        const reviewId = $(this).data('id');
        window.location.href = '/review/reviewUpdateForm?reviewId=' + reviewId;  // 경로가 맞는지 확인
    });

    // Delete button click
    $('.delete-btn').click(function() {
        const reviewId = $(this).data('id');
        if (confirm('정말로 리뷰를 삭제하시겠습니까?')) {
            $.ajax({
                url: '/review/deleteReview',  // 정확한 경로 설정
                type: 'POST',
                data: { reviewId: reviewId },
                success: function(response) {
                    alert(response);  // 서버에서 전달된 성공 메시지 출력
                    location.reload(); // 삭제 후 페이지 리로드
                },
                error: function(err) {
                    alert(err.responseText);  // 서버에서 전달된 오류 메시지 출력
                }
            });
        }
    });

    // Update button click for review update
    $('.save-btn').click(function() {
        const reviewData = {
            reviewId: $('#reviewId').val(),
            content: $('#content').val(),
            rating: $('#rating').val()
        };

        $.ajax({
            url: '/review/updateReview',
            type: 'POST',
            data: reviewData,
            success: function(response) {
                alert(response);  // 성공 메시지
                window.location.href = '/review/reviewList';  // 리뷰 목록으로 이동
            },
            error: function(err) {
                alert(err.responseText);  // 오류 메시지
            }
        });
    });
});
