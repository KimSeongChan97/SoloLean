$(document).ready(function() {
    // 리뷰 목록을 동적으로 로드하는 함수
    function loadReviewList(roomId) {
        $.ajax({
            url: '/SpringHotel/review/reviewList',
            type: 'POST',
            data: { roomId: roomId },
            success: function(reviews) {
                $('#reviewListContainer').empty();
                reviews.forEach(function(review) {
                    $('#reviewListContainer').append(`
                        <div class="review-item">
                            <h4>${review.userName}</h4>
                            <p>Rating: ${review.rating}/5</p>
                            <p>${review.comment}</p>
                            <button class="btn btn-warning edit-btn" data-id="${review.reviewId}" data-rating="${review.rating}" data-comment="${review.comment}" data-room-id="${roomId}">수정</button>
                            <button class="btn btn-danger delete-btn" data-id="${review.reviewId}" data-room-id="${roomId}">삭제</button>
                        </div>
                    `);
                });
                $('#reviewListModal').modal('show'); // 모달 열기
            },
            error: function() {
                alert('리뷰 목록을 불러오는 중 오류가 발생했습니다.');
            }
        });
    }

    // 리뷰 목록 보기 버튼 클릭 시
    $(document).on('click', '#reviewListBtn', function() {
        const roomId = $(this).data('room-id');
        loadReviewList(roomId); // 리뷰 목록 로드
    });

    // 리뷰 작성하기 버튼 클릭 시
    $(document).on('click', '#reviewWriteBtn', function() {
        // 리뷰 작성 폼 초기화
        $('#reviewForm input[name="reviewId"]').val('');
        $('#reviewForm input[name="rating"]').val('');
        $('#reviewForm textarea[name="comment"]').val('');
        $('#reviewForm input[name="roomId"]').val($(this).data('room-id')); // roomId 설정
        $('#reviewWriteModal').modal('show'); // 리뷰 작성 모달 열기
    });

    // 수정 버튼 클릭 시
    $(document).on('click', '.edit-btn', function() {
        const reviewId = $(this).data('id');
        const rating = $(this).data('rating');
        const comment = $(this).data('comment');
        const roomId = $(this).data('room-id'); // roomId 가져오기

        $('#reviewForm input[name="reviewId"]').val(reviewId);
        $('#reviewForm input[name="rating"]').val(rating);
        $('#reviewForm textarea[name="comment"]').val(comment);
        $('#reviewForm input[name="roomId"]').val(roomId); // roomId를 폼에 추가
        $('#reviewWriteModal').modal('show'); // 수정 모달 열기
    });

    // 리뷰 작성 제출 버튼 클릭 시
    $('#submitReview').click(function() {
        const reviewIdValue = $('#reviewForm input[name="reviewId"]').val();

        const reviewData = {
            reviewId: reviewIdValue && reviewIdValue !== '' ? reviewIdValue : 0, // reviewId가 없을 경우 0으로 설정
            roomId: $('#reviewForm input[name="roomId"]').val(), // roomId 포함
            rating: $('#reviewForm input[name="rating"]').val(),
            comment: $('#reviewForm textarea[name="comment"]').val()
        };

        $.ajax({
            url: '/SpringHotel/review/insertReview',  // 리뷰 저장 URL
            type: 'POST',
            data: reviewData,
            success: function(response) {
                if (response === 'success') {
                    alert('리뷰가 성공적으로 저장되었습니다.');
                    $('#reviewWriteModal').modal('hide');
                    // 리뷰 목록 새로고침
                    loadReviewList(reviewData.roomId);
                } else {
                    alert('리뷰 저장 중 오류가 발생했습니다.');
                }
            },
            error: function() {
                alert('리뷰 저장 중 오류가 발생했습니다.');
            }
        });
    });

    // 리뷰 삭제 버튼 클릭 시
    $(document).on('click', '.delete-btn', function() {
        const reviewId = $(this).data('id');
        const roomId = $(this).data('room-id'); // roomId 가져오기

        $.ajax({
            url: '/SpringHotel/review/deleteReview',  // 리뷰 삭제 URL
            type: 'POST',
            data: { reviewId: reviewId },
            success: function(response) {
                if (response === 'success') {
                    alert('리뷰가 삭제되었습니다.');
                    // 삭제 후 리뷰 목록 새로고침
                    loadReviewList(roomId);
                } else {
                    alert('리뷰 삭제 중 오류가 발생했습니다.');
                }
            },
            error: function() {
                alert('리뷰 삭제 중 오류가 발생했습니다.');
            }
        });
    });

    // star rating
    $(document).on('click', '.star', function() {
        const rating = $(this).data('value');
        $('#rating').val(rating);
        $('.star').removeClass('selected');
        $(this).prevAll().addBack().addClass('selected');
    });
});
