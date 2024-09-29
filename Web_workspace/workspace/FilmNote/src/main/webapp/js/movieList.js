// 기존 목록 페이지 이동
function moviePaging(pg) {
	// 선택된 페이지 번호(pg)를 기준으로 영화 목록 페이지로 이동합니다.
	location.href = context + '/admin/movieList.do?pg=' + pg;
}

// 검색 상태를 유지하며 페이지 이동
function selectMoviePaging(pg) {
    // 검색 옵션과 검색어를 가져옵니다.
    let searchOpt = $('.search-opt').val();
    let searchValue = $('#title-box').val();
    
    // AJAX 요청을 통해 새로운 페이지 데이터를 가져옵니다.
    $.ajax({
        url: context + '/admin/movieSelectDB.do', // 영화 검색 DB 처리 URL
        type: 'GET', // GET 요청을 사용하여 데이터를 가져옵니다.
        headers: {
            'X-Requested-With': 'XMLHttpRequest' // AJAX 요청임을 명시하여 서버가 요청을 인식할 수 있도록 합니다.
        },
        data: {
            searchOpt: searchOpt, // 검색 옵션 (예: 영화 제목, 감독 등)
            searchValue: searchValue, // 검색어
            pg: pg // 현재 페이지 번호
        },
        success: function(data) {
            // 성공적으로 응답을 받으면 기존 테이블의 <tbody> 데이터를 모두 지우고 새로운 데이터를 추가합니다.
            $('#movieTableBody').empty(); 
            
            if (!Array.isArray(data.movies) || data.movies.length === 0) {
                // 검색 결과가 없을 경우
                $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
            } else {
                // 검색 결과가 있는 경우 각 영화 데이터를 테이블에 추가합니다.
                data.movies.forEach(function(movieDTO) {
                    $('#movieTableBody').append(`
                        <tr>
                            <td align="center"><input type="checkbox" name="mcode" class="board-list-check" value="${movieDTO.mcode}" />${movieDTO.mcode}</td>
                            <td align="left"><a href="#" class="subject-a">${movieDTO.title}</a></td>
                            <td align="center">${movieDTO.director}</td>
                            <td align="center">${movieDTO.rating === 0 ? '전체' : movieDTO.rating + '세'}</td>
                        </tr>
                    `);
                });
            }

            // 검색 결과 페이지 네비게이션 HTML을 업데이트합니다.
            $('#select-page-block').html(data.selectPagingHTML);
            $('#select-page-block').show(); // 페이지 네비게이션을 보여줍니다.

            // 검색 상태를 URL에 추가하여 브라우저 히스토리에 기록합니다.
            const selectUrl = `${context}/admin/movieSelectDB.do?pg=${pg}&searchOpt=${searchOpt}&searchValue=${encodeURIComponent(searchValue)}`;
            history.pushState({ pg, searchOpt, searchValue }, '', selectUrl);
        },
        error: function() {
            // 에러가 발생하면 경고 메시지를 표시합니다.
            alert('페이지 로드에 실패했습니다.');
        }
    });
}

$(function() {
	// movie-list-menu 배경색 설정
	document.getElementById('movie-list-menu').style.background = '#DEC5D2';

    $('#movie-write-menu').hover(
        function() {
        	// 현재 항목(movie-write-menu)에 마우스가 올라가면 배경색을 변경
            $(this).css('background', '#DEC5D2');
            // movie-list-menu 배경색 초기화
            $('#movie-list-menu').css('background', 'transparent');
        },
        function() {
            // movie-write-menu에서 마우스가 나가면 배경색을 복구
            $('#movie-list-menu').css('background', '#DEC5D2');
            $('#movie-write-menu').css('background', 'transparent');
        }
    );
	
	// 전체 선택 / 전체 해제 이벤트를 동적으로 처리
	$(document).on('change', '#all_check', function() {
	    let isChk = $(this).is(':checked'); // 전체 선택 체크박스가 체크되었는지 확인
	    // 전체 선택 체크박스 상태에 따라 모든 체크박스 상태를 변경
	    $('.board-list-check').prop('checked', isChk);
	});

	// 개별 체크박스 상태에 따른 전체 선택 체크박스 상태를 업데이트
	$(document).on('change', '.board-list-check', function() {
	    let total = $('.board-list-check').length; // 전체 체크박스 수
	    let checked = $('.board-list-check:checked').length; // 체크된 체크박스 수
	    // 체크된 체크박스 수가 전체 체크박스 수와 같으면 전체 선택 체크박스를 체크
	    $('#all_check').prop('checked', total === checked);
	});	
	
	// 게시판 제목을 클릭했을 때
	$('.subject-a').click(function(){
		let mcode = $(this).parent().prev().text().trim();
		// 현재 클릭한 제목의 mcode 값을 가져옵니다.
		let pg = $('#pg').val();
		
		// 영화 상세 보기 페이지로 이동 (mcode와 현재 페이지 번호 전달)
		location.href = context + '/admin/movieView.do?mcode=' + mcode + '&pg=' + pg;
	});
	
	// 영화 삭제 버튼 클릭 시
	$('#deleteBtn').click(function() {
		// 체크된 mcode들을 배열로 수집
	    let mcodeArray = [];
	    $('input[name="mcode"]:checked').each(function() {
	        mcodeArray.push($(this).val().trim());
	    });

		// 아무 것도 선택되지 않았을 경우 경고 메시지 표시
		if (mcodeArray.length === 0) {
		    alert("삭제할 영화를 선택하세요.");
		    return;
		}

	    // 선택된 영화들을 삭제하기 위한 AJAX 요청
	    $.ajax({
	        url: context + '/admin/movieDeleteDB.do', // 삭제 처리 URL
	        type: 'POST', // POST 요청
	        data: {mcode: mcodeArray}, // 선택된 mcode 데이터
	        traditional: true,  // 배열 데이터를 서버에 전송할 때 필요한 설정
	        success: function() {
	            // 영화 삭제 성공 시 알림 후 페이지 새로고침
	            alert('영화가 삭제되었습니다.');
	            location.reload();
	        },
	        error: function() {
	            // 삭제 실패 시 에러 메시지 출력
	            alert('영화 삭제에 실패했습니다.');
	        }
	    });
	});

	// 영화 검색 버튼 클릭 시
	$('#searchBtn').click(function() {
	    let searchOpt = $('.search-opt').val(); // 검색 옵션 가져오기
	    let searchValue = $('#title-box').val(); // 검색어 가져오기
	    let pg = 1; // 검색 시 1페이지로 이동
	    
	    // 검색 요청을 위한 AJAX 호출
	    $.ajax({
	        url: context + '/admin/movieSelectDB.do', // 검색 처리 URL
	        type: 'GET', // GET 방식으로 요청
	        headers: {
	            'X-Requested-With': 'XMLHttpRequest' // AJAX 요청임을 명시
	        },            
	        data: {
	            searchOpt: searchOpt, // 검색 옵션
	            searchValue: searchValue, // 검색어
	            pg: pg // 현재 페이지 번호
	        },
	        success: function(data) {
	            console.log("응답 데이터:", data); // 응답 데이터를 콘솔에 출력

	            $('#movieTableBody').empty(); // 기존 테이블 <tbody> 데이터 제거
	            
	            if (!Array.isArray(data.movies)) { // 응답 데이터의 movies가 배열인지 확인
	                console.error("응답 데이터의 movies가 배열이 아닙니다:", data);
	                $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
	                return;
	            }

	            if (data.movies.length === 0) {
	                // 검색 결과가 없을 때
	                $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
	            } else {
	                // 검색 결과가 있을 때 테이블에 추가
	                data.movies.forEach(function(movieDTO) {
	                    $('#movieTableBody').append(`
	                        <tr>
	                            <td align="center"><input type="checkbox" name="mcode" class="board-list-check" value="${movieDTO.mcode}" />${movieDTO.mcode}</td>
	                            <td align="left"><a href="#" class="subject-a">${movieDTO.title}</a></td>
	                            <td align="center">${movieDTO.director}</td>
	                            <td align="center">${movieDTO.rating === 0 ? '전체' : movieDTO.rating + '세'}</td>
	                        </tr>
	                    `);
	                });
	            }

	            // 원래의 페이지 블록 숨기기
	            $('#list-page-block').hide();

	            // 검색 결과의 페이지 HTML을 업데이트
	            $('#select-page-block').html(data.selectPagingHTML);
	            // 검색 시 페이지 블록을 보여줌
	            $('#select-page-block').show();         

	            // 검색 상태를 URL에 추가
	            const selectUrl = `${context}/admin/movieSelectDB.do?pg=${pg}&searchOpt=${searchOpt}&searchValue=${encodeURIComponent(searchValue)}`;
	            history.pushState({ pg, searchOpt, searchValue }, '', selectUrl);
	        },
	        error: function(xhr, status, error) {
	            alert("영화 검색에 실패했습니다."); // 검색 실패 시 알림
	            console.log("에러 상태:", status);
	            console.log("에러 메시지:", error);
	            console.log("응답 내용:", xhr.responseText);
	        }
	    });
	});
	
	// 검색 결과에서 페이지 전환 시
	$(document).on('click', '.paging-link', function(e) {
	    e.preventDefault(); // 기본 링크 동작 방지
	    let pg = $(this).data('pg'); // 클릭한 페이지 번호 가져오기
	    selectMoviePaging(pg); // 선택한 페이지로 이동하며 새 데이터를 가져옴
	});
	
});
