$(function() {
	
	/** adminMenu.jsp 배경색 설정 */
	document.getElementById('movie-write-menu').style.background = '#DEC5D2';
	// 'movie-write-menu'의 배경색을 설정하여 현재 메뉴가 선택된 것을 시각적으로 표시함.

	$('#movie-list-menu').hover(
		function() {
			// 현재 항목 스타일 변경
			$(this).css('background', '#DEC5D2');
			// 마우스가 movie-list-menu 위에 있을 때 배경색을 변경하여 강조.

			// movie-write의 배경색을 초기화 
			$('#movie-write-menu').css('background', 'transparent');
			// movie-write-menu의 배경색을 투명하게 바꿔 선택된 스타일을 해제.
		},
		function() {
			// movie-list-menu에서 마우스가 나갈 때 movie-write 배경색 복구
			$('#movie-write-menu').css('background', '#DEC5D2');
			$('#movie-list-menu').css('background', 'transparent');
			// movie-write-menu의 배경색을 다시 설정하고 movie-list-menu의 배경색은 투명하게 변경.
		}
	);
	
	$('#listBtn').click(function() {
		// 리스트 버튼 클릭 시 영화 목록 페이지로 이동
		location.href = context + '/admin/movieList.do';
	});
	
	/** 이미지 등록 */
	$('#moviePoster').change(function() {
		// 파일 입력 필드에서 파일을 선택하면 이미지 미리보기를 위해 readURL 함수 호출
		readURL(this);
	});
	
	function readURL(input) {
		// 사용자가 선택한 파일을 읽어 이미지 미리보기를 제공하는 함수
		var reader = new FileReader(); // FileReader 객체를 생성하여 파일을 읽음
		reader.onload = function(e) {
			// 파일이 로드되면 해당 이미지를 미리보기로 보여줌
			$('#showImg').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
		// 선택된 파일을 DataURL로 읽어 브라우저에 이미지를 표시
	}
	
	/** 유효성 검사 */
	$('#movieWriteBtn').click(function(event) {
		// 영화 등록 버튼을 클릭하면 실행되는 이벤트
		event.preventDefault(); // 폼 제출 방지 (기본 폼 제출 동작을 막음)
		
		// 입력값을 변수에 저장
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
		// 이전에 표시된 오류 메시지들을 모두 숨김.
		
		let isValid = true; // 유효성 검사가 모두 통과했는지 여부를 저장
		
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
		if ($('#moviePoster').get(0).files.length === 0) {
			$('#moviePosterDiv').html('영화 포스터를 등록하세요').show();
			isValid = false;
		}
		
		// 유효성 검사를 통과하면 AJAX로 데이터 전송
		if (isValid) {
			// 모든 필드가 유효한 경우에만 AJAX 요청을 통해 서버로 폼 데이터를 전송
			let formData = new FormData($('form[name="movie-write-form"]')[0]);
			
			$.ajax({
				type: 'POST', // 전송 방식 (POST)
				url: context + '/admin/movieWriteDB.do', // 서버로 보낼 URL
				enctype: 'multipart/form-data', // 파일 전송을 위한 인코딩 타입
				processData: false, // 데이터를 처리하지 않음 (파일 포함시 설정 필요)
				contentType: false, // 파일 전송시 Content-Type 설정을 자동으로 처리하게 설정
				data: formData, // 전송할 데이터를 formData 객체로 설정
				success: function() {
					alert("영화를 등록했습니다.");
					// 영화 등록 성공 시 영화 목록 페이지로 이동
					window.location.href = context + '/admin/movieList.do';
				},
				error: function(xhr, status, error) {
					// 영화 등록 실패 시 에러 메시지를 출력
					alert("영화 등록에 실패했습니다.");
					console.log("에러 상태:", status);
					console.log("에러 메시지:", error);
					console.log("응답 내용:", xhr.responseText);
				}
			});
		}
	});
	
	// 입력 내용 초기화
	$('#resetBtn').click(function() {
		// 폼 초기화 및 이미지 미리보기 초기화
		$('.validationDiv').hide(); // 오류 메시지 숨김
		$('form[name="movie-write-form"]')[0].reset(); // 폼의 모든 필드를 초기화
		$('#showImg').attr('src', ''); // 이미지 미리보기 초기화
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
		// 이미지 클릭 시 오류 메시지 숨기기
		$('#moviePosterDiv').hide();
	});	
	
});
