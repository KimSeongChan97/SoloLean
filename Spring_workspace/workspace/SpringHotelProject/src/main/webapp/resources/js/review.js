$(document).ready(function() {
    // 리뷰 목록을 동적으로 로드하는 함수
    function loadReviewList(roomId) {
        // Ajax 요청을 통해 서버에서 해당 방의 리뷰 목록을 가져옴
        $.ajax({
            url: '/SpringHotel/review/reviewList', // 리뷰 목록을 불러오는 URL
            type: 'POST', // HTTP POST 방식 사용
            data: { roomId: roomId }, // 서버로 전송할 데이터 (roomId)
            success: function(reviews) { // 요청이 성공했을 때 실행
                $('#reviewListContainer').empty(); // 기존 리뷰 목록을 지움 (초기화)
                reviews.forEach(function(review) { // 서버에서 받은 리뷰 데이터를 순회하며 각각 추가
                    $('#reviewListContainer').append(`
                        <div class="review-item">
                            <h4>${review.userName}</h4>
                            <p>Rating: ${review.rating}/5</p>
                            <p>${review.comment}</p>
                            <button class="btn btn-warning edit-btn" data-id="${review.reviewId}" data-rating="${review.rating}" data-comment="${review.comment}" data-room-id="${roomId}">수정</button>
                            <button class="btn btn-danger delete-btn" data-id="${review.reviewId}" data-room-id="${roomId}">삭제</button>
                        </div>
                    `); // 각각의 리뷰를 HTML로 추가 (사용자 이름, 평점, 코멘트, 수정 및 삭제 버튼)
                });
                $('#reviewListModal').modal('show'); // 리뷰 목록을 모달 창으로 표시
            },
            error: function() {
                alert('리뷰 목록을 불러오는 중 오류가 발생했습니다.'); // 에러 발생 시 알림
            }
        });
    }

    // 리뷰 목록 보기 버튼 클릭 시
    $(document).on('click', '#reviewListBtn', function() {
        const roomId = $(this).data('room-id'); // 버튼에 연결된 roomId를 가져옴
        loadReviewList(roomId); // 해당 방의 리뷰 목록을 로드
    });

    // 리뷰 작성하기 버튼 클릭 시
    $(document).on('click', '#reviewWriteBtn', function() {
        // 리뷰 작성 폼을 초기화 (기존 데이터 초기화)
        $('#reviewForm input[name="reviewId"]').val(''); // 리뷰 ID 초기화 (신규 작성 시 빈 값)
        $('#reviewForm input[name="rating"]').val(''); // 평점 초기화
        $('#reviewForm textarea[name="comment"]').val(''); // 코멘트 초기화
        $('#reviewForm input[name="roomId"]').val($(this).data('room-id')); // 리뷰 작성 시 roomId 설정
        $('#reviewWriteModal').modal('show'); // 리뷰 작성 모달을 띄움
    });

    // 수정 버튼 클릭 시
    $(document).on('click', '.edit-btn', function() {
        const reviewId = $(this).data('id'); // 클릭한 리뷰의 reviewId 가져오기
        const rating = $(this).data('rating'); // 해당 리뷰의 평점 가져오기
        const comment = $(this).data('comment'); // 해당 리뷰의 코멘트 가져오기
        const roomId = $(this).data('room-id'); // 방 ID 가져오기

        // 리뷰 수정 폼에 기존 데이터를 채워 넣음
        $('#reviewForm input[name="reviewId"]').val(reviewId); // 리뷰 ID 설정
        $('#reviewForm input[name="rating"]').val(rating); // 평점 설정
        $('#reviewForm textarea[name="comment"]').val(comment); // 코멘트 설정
        $('#reviewForm input[name="roomId"]').val(roomId); // 방 ID 설정
        $('#reviewWriteModal').modal('show'); // 리뷰 수정 모달 열기
    });

    // 리뷰 작성 제출 버튼 클릭 시
    $('#submitReview').click(function() {
        const reviewIdValue = $('#reviewForm input[name="reviewId"]').val(); // 리뷰 ID 값을 가져옴

        // 리뷰 작성 또는 수정 시 서버로 보낼 데이터를 준비
        const reviewData = {
            reviewId: reviewIdValue && reviewIdValue !== '' ? reviewIdValue : 0, // reviewId가 있을 경우 해당 값을 사용하고, 없으면 0으로 설정 (새 리뷰인 경우)
            roomId: $('#reviewForm input[name="roomId"]').val(), // 방 ID를 포함
            rating: $('#reviewForm input[name="rating"]').val(), // 평점 값을 가져옴
            comment: $('#reviewForm textarea[name="comment"]').val() // 코멘트 값을 가져옴
        };

        // Ajax 요청을 통해 서버에 리뷰를 저장
        $.ajax({
            url: '/SpringHotel/review/insertReview',  // 리뷰를 저장할 서버 URL
            type: 'POST', // HTTP POST 방식 사용
            data: reviewData, // 리뷰 데이터 전송
            success: function(response) { // 요청 성공 시
                if (response === 'success') { // 서버 응답이 성공일 경우
                    alert('리뷰가 성공적으로 저장되었습니다.'); // 리뷰 저장 성공 메시지 표시
                    $('#reviewWriteModal').modal('hide'); // 리뷰 작성 모달 닫기
                    // 리뷰 목록 새로고침
                    loadReviewList(reviewData.roomId); // 방 ID에 맞는 리뷰 목록을 다시 로드
                } else {
                    alert('리뷰 저장 중 오류가 발생했습니다.'); // 저장 실패 시 알림
                }
            },
            error: function() {
                alert('리뷰 저장 중 오류가 발생했습니다.'); // Ajax 요청 실패 시 알림
            }
        });
    });

    // 리뷰 삭제 버튼 클릭 시
    $(document).on('click', '.delete-btn', function() {
        const reviewId = $(this).data('id'); // 삭제할 리뷰 ID 가져오기
        const roomId = $(this).data('room-id'); // 방 ID 가져오기

        // Ajax 요청을 통해 서버에 리뷰 삭제 요청
        $.ajax({
            url: '/SpringHotel/review/deleteReview',  // 리뷰 삭제 URL
            type: 'POST', // HTTP POST 방식 사용
            data: { reviewId: reviewId }, // 서버에 삭제할 리뷰 ID를 전송
            success: function(response) { // 요청 성공 시
                if (response === 'success') { // 서버 응답이 성공일 경우
                    alert('리뷰가 삭제되었습니다.'); // 삭제 성공 메시지 표시
                    // 삭제 후 리뷰 목록 새로고침
                    loadReviewList(roomId); // 방 ID에 맞는 리뷰 목록을 다시 로드
                } else {
                    alert('리뷰 삭제 중 오류가 발생했습니다.'); // 삭제 실패 시 알림
                }
            },
            error: function() {
                alert('리뷰 삭제 중 오류가 발생했습니다.'); // Ajax 요청 실패 시 알림
            }
        });
    });

    // 별점 선택 기능
    $(document).on('click', '.star', function() {
        const rating = $(this).data('value'); // 클릭한 별의 값(평점) 가져오기
        $('#rating').val(rating); // 숨겨진 input에 평점 값 설정
        $('.star').removeClass('selected'); // 기존 선택된 별들을 초기화
        $(this).prevAll().addBack().addClass('selected'); // 선택한 별과 그 이전의 별들에 'selected' 클래스 추가
    });
});
