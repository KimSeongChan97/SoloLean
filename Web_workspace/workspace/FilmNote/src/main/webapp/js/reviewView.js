// FilmNote/src/main/webapp/js/reviewView.js
// 유효성 검사
function checkReview() {
	console.log('checkReview() 함수');
	let isOk = false;
	// 1. 리뷰 작성 확인
	let reveiewText = $('#new-review').val()
	console.log('리뷰: ' + reveiewText);
	// 2. 별점 선택 확인
	let scoreText = $('#scoreText').text();
	console.log('별점: ' + scoreText);
	
	if(reveiewText == '') alert('리뷰를 작성하세요.');
	else if(scoreText == '0') alert('별점을 선택하세요.');
	else isOk = true;
	return isOk;
}

// 별점 선택
function selectScore(selectScore, scoreText, isReset) {
	// selectScore: 선택한 별 span 태그
	// scoreText: 별점 Text div 태그
	let scoreNum = selectScore.data('score');
	let alreadySelect = scoreText.text();
	console.log('selectScore() 함수 호출');
	console.log('클릭 이전 Score: ' + alreadySelect + ", 클릭 후 Score: " + scoreNum);
	console.log('p: ' + selectScore.parents('.score-star'));
	console.log(selectScore);
	// 초기화
	selectScore.parent().find('.score').each(function(){
		$(this).text('☆').css('color', 'black');
	});
	
	scoreText.text('0');
	if(alreadySelect != scoreNum || alreadySelect == '0') {
		// 별점 Text
		scoreText.text(scoreNum);
		
		// 별 색칠하기 
		console.log(selectScore.parent().find('.score'));
		selectScore.parent().find('.score').each(function(){
			if($(this).data('score') <= scoreNum) { 
				$(this).text('★').css('color', '#FFBF29');
			}
		 });
	}
}

// 리뷰 전송
function writeReview() {
	console.log('writeReview() 호출');
	$.ajax({
		type : 'post',
		url : '/FilmNote/review/reviewViewDB.do',
		data : {
			'content': $('#new-review').val(),
			'score': $('#scoreText').text(),
			'user_id': $('#post-comment').data('uid'),
			'movie_code': $('#movietitle').data('moviecode')
		},
		success: function() {
			alert('리뷰가 작성되었습니다.');
			location.reload();
		},
		error: function(e) {
			console.log(e);
		}
	});
}

// 리뷰 수정
function editReview() {
	console.log('editReview() 호출');
	
	// [변수 설정]
	const parentDiv = $(this).parents('.review'); // 수정 버튼의 부모 Div
	const updateRDiv = parentDiv.find('.update-review'); // 수정 Textarea & 별점 부모 Div
	
	// [초기화]
	let scoreText = parentDiv.find('.update-review').find('.scoreText');
	parentDiv.find('.list-content').prop('hidden', true); // 리뷰 
	updateRDiv.prop('hidden', false); // 리뷰 수정 창 노출
	updateRDiv.find('.score').each(function(){
		if($(this).data('score') <= scoreText.text()) {
			$(this).text('★').css('color', '#FFBF29');
		}else {
			$(this).text('☆').css('color', 'black');
		}
	});
	
	// 별점 수정
	updateRDiv.find('.score-star').find('.score').click(function() {
		console.log(scoreText);
		selectScore($(this), scoreText, false);
	});
	
	// 리뷰 수정
	updateRDiv.find('.update-reviewBtn').click(function() {
		console.log(updateRDiv.find('.update-reviewText').val());
		console.log(updateRDiv.find('.scoreText').text());
		console.log(parentDiv.find('.review-code').text());
		console.log($('#post-comment').data('uid'));
		console.log($('#movietitle').data('moviecode'));
		console.log($('#reviewTotalNum').text());
		
		$.ajax({
			type : 'post',
			url : '/FilmNote/review/reviewUpdateDB.do',
			data : {
				'content': updateRDiv.find('.update-reviewText').val(), // 작성자의 리뷰
				'score': updateRDiv.find('.scoreText').text(), // 작성자의 별점
				'rcode': parentDiv.find('.review-code').text(),
				'user_id': $('#post-comment').data('uid'), // 작성자 
				'movie_code': $('#movietitle').data('moviecode') // 영화 코드
				//'reviewTotalNum' : $('#reviewTotalNum').text() // 리뷰 개수
			},
			success: function() {
				alert('리뷰가 수정되었습니다.');
				location.reload();
			},
			error: function(e) {
				console.log(e);
			}
		});
	});
}

// 리뷰 삭제
function deleteReview() {
	let rcode = $(this).parents('.review').find('.review-code').text();
	let mcode = $('#movietitle').data('moviecode');
	console.log('deleteReview() 호출' + rcode);
	
	if(confirm('해당 리뷰를 삭제하시겠습니까?')) {
		$.ajax({
			type : 'get',
			url : '/FilmNote/review/reviewDeleteDB.do?rcode='+ rcode + '&mcode=' + mcode,
			success: function() {
				alert('리뷰가 삭제되었습니다.');
				location.reload();
			},
			error: function(e) {
				console.log(e);
			}
		});
	}
}

// 페이징 처리
function reviewPaging(pg) {
	location.href = "/FilmNote/review/reviewView.do?mcode=" + $('#movietitle').data('moviecode') + "&pg=" + pg;
}

$(function() {
	// [0. 초기화]
	$('.update-review').prop('hidden', true);
	
	// [1. 신규 리뷰]
	// 로그인 여부 확인
	if($('#post-comment').data('uid') != '') { // 로그인 
		// 평점
		$('#new-score > #score-star > .score').click(function() {
			selectScore($(this), $('#scoreText'), true);
		});
		
		// 리뷰 전송
		$('#submit-review').click(function() {
			if(checkReview()) writeReview();
		});
	} else {
		$('#new-review').prop('readonly', true).val('로그인 하세요.');
		$('#submit-review').click		(function() {
			alert('로그인 후 이용 가능합니다.');
		});
	}
	
	// [2. 기존 리뷰]
	// 옵션 메뉴 노출	
	$('.options-btn').click(function() { // 댓글 옵션 메뉴 (토글)
		const menu = $(this).next('.options-menu')
		menu.toggle();
		
		// 클릭한 버튼이 아닌 다른 곳을 클릭하면 메뉴 닫기
		$(document).on('click', function(e) {
            if (!$(e.target).closest('.options-btn').length && !$(e.target).closest('.options-menu').length) {
                menu.hide();
            }
        });
	});
	
	// 리뷰 수정
	$('.edit').click(editReview);
	
	// 리뷰 삭제
	$('.delete').click(deleteReview);
})