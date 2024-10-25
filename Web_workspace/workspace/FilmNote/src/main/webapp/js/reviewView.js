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
}// 유효성 검사 함수: 리뷰를 작성했는지, 별점을 선택했는지 확인하는 함수입니다.
function checkReview() {
	console.log('checkReview() 함수'); // 함수 호출 시 콘솔에 로그를 출력하여 디버깅 용도로 사용
	let isOk = false; // 유효성 검사를 통과하지 못하면 false를 반환
	// 1. 리뷰 작성 확인
	let reveiewText = $('#new-review').val(); // 리뷰 작성 textarea의 값을 가져옵니다.
	console.log('리뷰: ' + reveiewText); // 리뷰 내용을 콘솔에 출력
	// 2. 별점 선택 확인
	let scoreText = $('#scoreText').text(); // 선택된 별점의 값을 가져옵니다.
	console.log('별점: ' + scoreText); // 선택된 별점을 콘솔에 출력
	
	// 유효성 검사: 리뷰를 작성하지 않았을 경우
	if(reveiewText == '') alert('리뷰를 작성하세요.');
	// 유효성 검사: 별점을 선택하지 않았을 경우
	else if(scoreText == '0') alert('별점을 선택하세요.');
	else isOk = true; // 모든 검사를 통과한 경우 true를 반환
	return isOk; // 유효성 검사 결과 반환
}

// 별점 선택 함수: 사용자가 선택한 별점을 처리하는 함수입니다.
function selectScore(selectScore, scoreText, isReset) {
	// selectScore: 선택한 별의 요소, scoreText: 별점 표시 텍스트, isReset: 초기화 여부
	let scoreNum = selectScore.data('score'); // 선택한 별의 data-score 값을 가져옴
	let alreadySelect = scoreText.text(); // 이미 선택된 별점 값을 가져옴
	console.log('selectScore() 함수 호출');
	console.log('클릭 이전 Score: ' + alreadySelect + ", 클릭 후 Score: " + scoreNum);
	console.log('p: ' + selectScore.parents('.score-star')); // 별점 요소의 부모 요소를 출력
	console.log(selectScore); // 선택된 별점 요소 출력

	// 초기화: 모든 별을 비활성화 (☆ 검정색으로 변경)
	selectScore.parent().find('.score').each(function(){
		$(this).text('☆').css('color', 'black');
	});
	
	scoreText.text('0'); // 별점 표시 텍스트 초기화
	// 클릭한 별이 이전에 선택한 별과 다르거나, 이전에 별을 선택하지 않았을 때
	if(alreadySelect != scoreNum || alreadySelect == '0') {
		// 별점 표시 텍스트 업데이트
		scoreText.text(scoreNum);
		
		// 선택된 별까지 색칠 (★ 노란색으로 변경)
		selectScore.parent().find('.score').each(function(){
			if($(this).data('score') <= scoreNum) { 
				$(this).text('★').css('color', '#FFBF29'); // 별을 채우고 색상 변경
			}
		 });
	}
}

// 리뷰 전송 함수: 사용자가 작성한 리뷰를 서버로 전송하는 함수입니다.
function writeReview() {
	console.log('writeReview() 호출'); // 리뷰 작성 함수 호출 시 로그 출력
	$.ajax({
		type : 'post', // POST 방식으로 데이터를 전송
		url : '/FilmNote/review/reviewViewDB.do', // 리뷰 전송 처리 URL
		data : {
			'content': $('#new-review').val(), // 리뷰 내용
			'score': $('#scoreText').text(), // 별점 점수
			'user_id': $('#post-comment').data('uid'), // 작성자의 user_id
			'movie_code': $('#movietitle').data('moviecode') // 영화 코드
		},
		success: function() {
			alert('리뷰가 작성되었습니다.'); // 성공 시 알림
			location.reload(); // 페이지 새로고침하여 최신 리뷰를 표시
		},
		error: function(e) {
			console.log(e); // 오류 발생 시 콘솔에 에러 출력
		}
	});
}

// 리뷰 수정 함수: 기존에 작성한 리뷰를 수정하는 기능입니다.
function editReview() {
	console.log('editReview() 호출'); // 리뷰 수정 함수 호출 시 로그 출력
	
	// [변수 설정]
	const parentDiv = $(this).parents('.review'); // 수정 버튼이 속한 리뷰 div를 찾음
	const updateRDiv = parentDiv.find('.update-review'); // 수정 textarea 및 별점 영역 찾기
	
	// [초기화]
	let scoreText = parentDiv.find('.update-review').find('.scoreText'); // 수정할 별점 텍스트
	parentDiv.find('.list-content').prop('hidden', true); // 기존 리뷰 내용을 숨김
	updateRDiv.prop('hidden', false); // 수정 창을 표시
	updateRDiv.find('.score').each(function(){
		// 기존에 선택된 별점까지 색칠
		if($(this).data('score') <= scoreText.text()) {
			$(this).text('★').css('color', '#FFBF29');
		} else {
			$(this).text('☆').css('color', 'black');
		}
	});
	
	// 별점 수정 처리
	updateRDiv.find('.score-star').find('.score').click(function() {
		console.log(scoreText);
		selectScore($(this), scoreText, false); // 별점 선택 처리
	});
	
	// 리뷰 수정 전송
	updateRDiv.find('.update-reviewBtn').click(function() {
		console.log(updateRDiv.find('.update-reviewText').val()); // 수정된 리뷰 내용
		console.log(updateRDiv.find('.scoreText').text()); // 수정된 별점
		console.log(parentDiv.find('.review-code').text()); // 리뷰 코드
		console.log($('#post-comment').data('uid')); // 작성자 ID
		console.log($('#movietitle').data('moviecode')); // 영화 코드
		
		$.ajax({
			type : 'post', // POST 방식으로 데이터를 전송
			url : '/FilmNote/review/reviewUpdateDB.do', // 리뷰 수정 처리 URL
			data : {
				'content': updateRDiv.find('.update-reviewText').val(), // 수정된 리뷰 내용
				'score': updateRDiv.find('.scoreText').text(), // 수정된 별점
				'rcode': parentDiv.find('.review-code').text(), // 리뷰 코드
				'user_id': $('#post-comment').data('uid'), // 작성자 ID
				'movie_code': $('#movietitle').data('moviecode') // 영화 코드
			},
			success: function() {
				alert('리뷰가 수정되었습니다.'); // 수정 성공 시 알림
				location.reload(); // 페이지 새로고침
			},
			error: function(e) {
				console.log(e); // 에러 발생 시 콘솔에 에러 출력
			}
		});
	});
}

// 리뷰 삭제 함수: 사용자가 작성한 리뷰를 삭제하는 기능입니다.
function deleteReview() {
	let rcode = $(this).parents('.review').find('.review-code').text(); // 삭제할 리뷰 코드
	let mcode = $('#movietitle').data('moviecode'); // 영화 코드
	console.log('deleteReview() 호출' + rcode); // 로그 출력
	
	if(confirm('해당 리뷰를 삭제하시겠습니까?')) { // 삭제 여부 확인
		$.ajax({
			type : 'get', // GET 방식으로 요청
			url : '/FilmNote/review/reviewDeleteDB.do?rcode='+ rcode + '&mcode=' + mcode, // 리뷰 삭제 URL
			success: function() {
				alert('리뷰가 삭제되었습니다.'); // 성공 시 알림
				location.reload(); // 페이지 새로고침
			},
			error: function(e) {
				console.log(e); // 에러 발생 시 콘솔에 출력
			}
		});
	}
}

// 페이징 처리: 리뷰 페이지를 넘길 때 사용하는 함수입니다.
function reviewPaging(pg) {
	location.href = "/FilmNote/review/reviewView.do?mcode=" + $('#movietitle').data('moviecode') + "&pg=" + pg; // 리뷰 페이지 이동
}

$(function() {
	// [0. 초기화]
	$('.update-review').prop('hidden', true); // 모든 리뷰 수정 영역을 숨김
	
	// [1. 신규 리뷰]
	// 로그인 여부 확인: 로그인된 사용자만 리뷰 작성 가능
	if($('#post-comment').data('uid') != '') { // 로그인 상태일 때
		// 평점 클릭 이벤트 처리
		$('#new-score > #score-star > .score').click(function() {
			selectScore($(this), $('#scoreText'), true); // 별점 선택 처리
		});
		
		// 리뷰 전송 버튼 클릭 이벤트
		$('#submit-review').click(function() {
			// 유효성 검사 후 리뷰 전송
			if(checkReview()) writeReview();
		});
	} else {
		// 비로그인 상태일 경우 리뷰 작성 불가
		$('#new-review').prop('readonly', true).val('로그인 하세요.'); // 리뷰 작성란 비활성화
		$('#submit-review').click(function() {
			alert('로그인 후 이용 가능합니다.'); // 경고 메시지 표시
		});
	}
	
	// [2. 기존 리뷰]
	// 옵션 메뉴 노출
	$('.options-btn').click(function() { // 리뷰 수정/삭제 옵션 버튼 클릭 시
		const menu = $(this).next('.options-menu') // 옵션 메뉴 표시
		menu.toggle(); // 메뉴 토글 (보이기/숨기기)
		
		// 메뉴 외부 클릭 시 메뉴 닫기
		$(document).on('click', function(e) {
            if (!$(e.target).closest('.options-btn').length && !$(e.target).closest('.options-menu').length) {
                menu.hide(); // 메뉴 외부를 클릭하면 메뉴를 숨김
            }
        });
	});
	
	// 리뷰 수정 버튼 클릭 이벤트
	$('.edit').click(editReview);
	
	// 리뷰 삭제 버튼 클릭 이벤트
	$('.delete').click(deleteReview);
})


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