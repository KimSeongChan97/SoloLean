// FilmNote/src/main/webapp/js/movieEdit.js

$(function() {
	let mcode = $('#mcode').val().trim();
	let pg = $('#pg').val().trim();

	console.log("mcode:", mcode);
	console.log("pg:", pg);
	console.log("context:", context);
	
	/** 이미지 등록 */
	$('#moviePoster').change(function() {
		readURL(this);
	});

	function readURL(input) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#showImg').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
	
	/** 수정 버튼; DB 수정 기능 */
	$('#movieEditBtn').click(function(event) {
		// location.href = context + '/admin/movieEdit.do?mcode=' + mcode + '&pg=' + pg;
		event.preventDefault(); // 폼 제출 방지
		
		let movieTitle = $('#movieTitle').val().trim();
		let movieDirector = $('#movieDirector').val().trim();
		let movieGenre = $('#movieGenre').val().trim();
		let movieReleaseDate = $('#movieReleaseDate').val().trim();
		let movieRating = $('#movieRating').val().trim();
		let movieScore = $('#movieScore').val().trim();
		let movieSynopsis = $('#movieSynopsis').val().trim();
		let moviePoster = $('#moviePoster').val().trim();

		// 오류 메시지 초기화 및 숨김
		$('.validationDiv').hide();
		
		let isValid = true;

		// 영화 제목 입력 검사
		if (movieTitle === '') {
			$('#movieTitleDiv').html('영화 제목을 입력하세요').show();
			isValid = false;
		}

		// 영화 감독 입력 검사
		if (movieDirector === '') {
			$('#movieDirectorDiv').html('영화 감독을 입력하세요').show();
			isValid = false;
		}

		// 영화 장르 입력 검사
		if (movieGenre === '') {
			$('#movieGenreDiv').html('영화 장르를 입력하세요').show();
			isValid = false;
		}

		// 영화 개봉일 입력 검사
		if (movieReleaseDate === '') {
			$('#movieReleaseDateDiv').html('영화 개봉일을 입력하세요').show();
			isValid = false;
		}

		// 영화 관람가 입력 검사
		if (movieRating === '') {
			$('#movieRatingDiv').html('영화 관람가를 입력하세요').show();
			isValid = false;
		}

		// 영화 평점 입력 검사
		if (movieScore === '') {
			$('#movieScoreDiv').html('영화 평점을 입력하세요').show();
			isValid = false;
		}

		// 영화 줄거리 입력 검사
		if (movieSynopsis === '') {
			$('#movieSynopsisDiv').html('영화 줄거리를 입력하세요').show();
			isValid = false;
		}

		// 영화 포스터 입력 검사
		// if (moviePoster === '') {
		if ($('#showImg').attr('src') === '' || $('#showImg').attr('src') === undefined) {
		    $('#moviePosterDiv').html('영화 포스터를 등록하세요').show();
		    isValid = false;
		} 
		
		// 유효성 검사를 통과하면 AJAX로 데이터 전송
		if (isValid) {
			let formData = new FormData($('form[name="movie-edit-form"]')[0]);
			
			$.ajax({
				type: 'POST',
				url: context + '/admin/movieEditDB.do',
				enctype: 'multipart/form-data',
				processData: false,
				contentType: false,
				data: formData,
				success: function() {
					alert("영화를 수정했습니다.");
					// /admin/movieList.do로 이동
					// location.href = context + '/admin/movieList.do?pg=' + pg;
					location.href = context + '/admin/movieView.do?mcode=' + mcode + '&pg=' + pg ;
				},
				error: function(xhr, status, error) {
					alert("영화 수정에 실패했습니다.");
					console.log("에러 상태:", status);
					console.log("에러 메시지:", error);
					console.log("응답 내용:", xhr.responseText);
				}
			});
		}
	});


	// 입력 내용 초기화
	$('#resetBtn').click(function() {
		$('.validationDiv').hide();
		
		// <form> input 초기화
		$('form[name="movie-edit-form"]')[0].reset();
		
		// <form> 이미지 초기화
		// $('#showImg').attr('src', '');
		
		// #showImg 를 비워서 초기화하는 것이 아님. 원래 이미지로 복구
		$('#showImg').attr('src', originalPoster);
	});	
	
	// 입력 필드에 포커스가 갈 때 오류 메시지 숨기기
	$('#movieTitle').focus(function() {
		$('#movieTitleDiv').hide();
	});	
	$('#movieDirector').focus(function() {
		$('#movieDirectorDiv').hide();
	});	
	$('#movieGenre').focus(function() {
		$('#movieGenreDiv').hide();
	});	
	$('#movieReleaseDate').focus(function() {
		$('#movieReleaseDateDiv').hide();
	});	
	$('#movieRating').focus(function() {
		$('#movieRatingDiv').hide();
	});	
	$('#movieScore').focus(function() {
		$('#movieScoreDiv').hide();
	});	
	$('#movieSynopsis').focus(function() {
		$('#movieSynopsisDiv').hide();
	});		
	$('#showImg').click(function() {
		$('#moviePosterDiv').hide();
	});	
	
	
	/** 목록 버튼; movieList.jsp 이동 */
	$('#listBtn').click(function() {
		location.href = context + '/admin/movieList.do?pg=' + pg;
	});

});