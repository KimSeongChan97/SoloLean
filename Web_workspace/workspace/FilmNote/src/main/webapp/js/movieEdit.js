$(function() {
	// 페이지 로딩 시 mcode와 pg 값을 가져와서 콘솔에 출력합니다.
	let mcode = $('#mcode').val().trim();
	let pg = $('#pg').val().trim();

	console.log("mcode:", mcode);
	console.log("pg:", pg);
	console.log("context:", context);
	
	/** 이미지 등록 */
	$('#moviePoster').change(function() {
		// 사용자가 이미지 파일을 변경하면, readURL 함수를 호출하여 새 이미지를 미리보기로 보여줍니다.
		readURL(this);
	});

	function readURL(input) {
		// 파일을 읽어서 브라우저에서 이미지로 미리보기를 제공하는 함수입니다.
		var reader = new FileReader(); // FileReader 객체를 생성합니다.
		reader.onload = function(e) {
			// 이미지가 로드되면 미리보기 요소의 src 속성에 이미지를 설정합니다.
			$('#showImg').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]); // 파일을 DataURL로 변환하여 읽습니다.
	}
	
	/** 수정 버튼; DB 수정 기능 */
	$('#movieEditBtn').click(function(event) {
		// 수정 버튼을 클릭하면 폼 데이터를 DB에 전송하여 영화를 수정합니다.
		event.preventDefault(); // 폼 제출을 방지하여 AJAX로 전송하도록 합니다.
		
		// 각 입력 필드에서 값을 가져와서 변수에 저장합니다.
		let movieTitle = $('#movieTitle').val().trim();
		let movieDirector = $('#movieDirector').val().trim();
		let movieGenre = $('#movieGenre').val().trim();
		let movieReleaseDate = $('#movieReleaseDate').val().trim();
		let movieRating = $('#movieRating').val().trim();
		let movieScore = $('#movieScore').val().trim();
		let movieSynopsis = $('#movieSynopsis').val().trim();
		let moviePoster = $('#moviePoster').val().trim();

		// 오류 메시지를 초기화하고 숨깁니다.
		$('.validationDiv').hide();
		
		let isValid = true; // 유효성 검사를 위한 변수입니다.

		// 각 입력 필드에 대해 유효성 검사를 실시합니다.
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
		if ($('#showImg').attr('src') === '' || $('#showImg').attr('src') === undefined) {
		    $('#moviePosterDiv').html('영화 포스터를 등록하세요').show();
		    isValid = false;
		} 
		
		// 유효성 검사를 통과하면 AJAX로 데이터 전송
		if (isValid) {
			// 폼 데이터를 객체로 변환하여 전송 준비를 합니다.
			let formData = new FormData($('form[name="movie-edit-form"]')[0]);
			
			$.ajax({
				type: 'POST', // 전송 방식
				url: context + '/admin/movieEditDB.do', // 전송할 URL
				enctype: 'multipart/form-data', // 파일 전송을 위한 인코딩 타입
				processData: false, // 데이터를 처리하지 않음 (파일 포함시 필수)
				contentType: false, // Content-Type을 자동으로 설정하게 함
				data: formData, // 폼 데이터를 전송
				success: function() {
					// 성공적으로 영화를 수정하면 알림을 띄우고 영화 상세 보기 페이지로 이동합니다.
					alert("영화를 수정했습니다.");
					location.href = context + '/admin/movieView.do?mcode=' + mcode + '&pg=' + pg;
				},
				error: function(xhr, status, error) {
					// 오류 발생 시 알림을 띄우고 콘솔에 에러 정보를 출력합니다.
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
		// 폼 필드 및 오류 메시지를 초기화합니다.
		$('.validationDiv').hide();
		
		// 폼 입력 필드를 초기화합니다.
		$('form[name="movie-edit-form"]')[0].reset();
		
		// 영화 포스터 이미지 초기화
		// 원래의 이미지로 복구 (비워서 초기화하는 것이 아님)
		$('#showImg').attr('src', originalPoster);
	});	
	
	// 입력 필드에 포커스가 갈 때 오류 메시지를 숨기기
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
		$('#moviePosterDiv').hide(); // 이미지 클릭 시 포스터 오류 메시지를 숨깁니다.
	});	
	
	/** 목록 버튼; movieList.jsp로 이동 */
	$('#listBtn').click(function() {
		// 목록 버튼을 클릭하면 영화 목록 페이지로 이동합니다.
		location.href = context + '/admin/movieList.do?pg=' + pg;
	});

});
