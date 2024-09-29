// FilmNote/src/main/webapp/js/movieList.js

// 기존 목록 페이지 이동
function moviePaging(pg) {
	location.href=context + '/admin/movieList.do?pg=' + pg;
}

// 검색 상태를 유지하며 페이지 이동
function selectMoviePaging(pg) {
    let searchOpt = $('.search-opt').val();
    let searchValue = $('#title-box').val();
    
    // AJAX 요청을 통해 새 페이지 데이터 가져오기
    $.ajax({
        url: context + '/admin/movieSelectDB.do',
        type: 'GET',
        headers: {
            'X-Requested-With': 'XMLHttpRequest' // AJAX 요청임을 명시
        },
        data: {
            searchOpt: searchOpt,
            searchValue: searchValue,
            pg: pg
        },
        success: function(data) {
            $('#movieTableBody').empty(); // 기존 테이블 <tbody> 데이터 제거
            
            if (!Array.isArray(data.movies) || data.movies.length === 0) {
                $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
            } else {
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

            // 검색 결과의 페이지 HTML을 업데이트
            $('#select-page-block').html(data.selectPagingHTML);
            $('#select-page-block').show();

            // 검색 상태를 URL에 추가
			// encodeURIComponent() : 문자 인코딩: URL에 포함될 수 없는 특수 문자(예: 공백, &, =, ?, # 등)를 올바르게 변환
            const selectUrl = `${context}/admin/movieSelectDB.do?pg=${pg}&searchOpt=${searchOpt}&searchValue=${encodeURIComponent(searchValue)}`;
            history.pushState({ pg, searchOpt, searchValue }, '', selectUrl);
        },
        error: function() {
            alert('페이지 로드에 실패했습니다.');
        }
    });
}

$(function() {
	document.getElementById('movie-list-menu').style.background = '#DEC5D2';

    $('#movie-write-menu').hover(
        function() {
        	// 현재 항목 스타일 변경
            $(this).css('background', '#DEC5D2');

            // movie-list-menu의 배경색을 초기화 
            $('#movie-list-menu').css('background', 'transparent');
        },
        function() {
            // movie-write-menu에서 마우스가 나갈 때 movie-list-menu 배경색 복구
            $('#movie-list-menu').css('background', '#DEC5D2');
            $('#movie-write-menu').css('background', 'transparent');
        }
    );
	

	// 전체 선택 / 전체 해제 이벤트를 동적으로 바인딩
	$(document).on('change', '#all_check', function() {
	    let isChk = $(this).is(':checked');
	    // 전체 선택 체크박스 상태에 따라 모든 체크박스 상태 변경
	    $('.board-list-check').prop('checked', isChk);
	});

	// 개별 체크박스 상태에 따른 전체 선택 체크박스 상태 업데이트
	$(document).on('change', '.board-list-check', function() {
	    let total = $('.board-list-check').length; // 전체 체크박스 수
	    let checked = $('.board-list-check:checked').length; // 체크된 체크박스 수
	    // 체크된 체크박스 수가 전체 체크박스 수와 같으면 전체 선택 체크박스 체크
	    $('#all_check').prop('checked', total === checked);
	});	
	
	// 게시판 제목 클릭했을 때
	$('.subject-a').click(function(){
		let mcode = $(this).parent().prev().text().trim();
		// $(this).parent() :  <a> 태그의 부모 요소인 <td>에 접근
		// parent().prev() : 부모 요소(현재 <td> 태그) 바로 앞의 형제 요소, 즉 mcode 값이 있는 <td>에 접근
		// .text() : 그 <td> 태그의 텍스트, 즉 mcode 값을 가져옴
		// trim() : mcode 값을 가져올 때 따라오는 공백 제거 - 안해주면 mcode 앞에 %20 이 붙음
		
		let pg = $('#pg').val();
		
		location.href = context + '/admin/movieView.do?mcode=' + mcode + '&pg=' + pg;
		// ${pageContext.request.contextPath }
	});
	
	// movieList.js
	// 영화 삭제
	$('#deleteBtn').click(function() {
		// 체크된 mcode들을 배열로 가져오기
	    let mcodeArray = [];
	    $('input[name="mcode"]:checked').each(function() {
	        mcodeArray.push($(this).val().trim());
	    });

		if (mcodeArray.length === 0) {
		    alert("삭제할 영화를 선택하세요.");
		    return;
		}

	    $.ajax({
	        url: context + '/admin/movieDeleteDB.do',
	        type: 'POST',
	        data: {mcode: mcodeArray},
	        traditional: true,  // 배열 데이터를 서버에 전송할 때 필요한 설정
	        success: function() {
	            alert('영화가 삭제되었습니다.');
	            location.reload(); // 페이지 새로고침
	        },
	        error: function() {
	            alert('영화 삭제에 실패했습니다.');
	        }
	    });
	});

	// 영화 검색
	$('#searchBtn').click(function() {
	    let searchOpt = $('.search-opt').val();
	    let searchValue = $('#title-box').val();
	    let pg = 1;
	    
	    $.ajax({
	        url: context + '/admin/movieSelectDB.do',
	        type: 'GET',
	        headers: {
	            'X-Requested-With': 'XMLHttpRequest' // AJAX 요청임을 명시
	        },            
	        data: {
	            searchOpt: searchOpt,
	            searchValue: searchValue,
	            pg: pg
	        },
	        success: function(data) {
	            console.log("응답 데이터:", data); // 응답 데이터 확인

	            $('#movieTableBody').empty(); // 기존 테이블 <tbody> 데이터 제거
	            
	            if (!Array.isArray(data.movies)) { // movies가 배열인지 확인
	                console.error("응답 데이터의 movies가 배열이 아닙니다:", data);
	                $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
	                return;
	            }

	            if (data.movies.length === 0) {
	                $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
	            } else {
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
	            // 검색 시 페이지 블록 나타내기
	            $('#select-page-block').show();         

	            // 검색 상태를 URL에 추가
	            const selectUrl = `${context}/admin/movieSelectDB.do?pg=${pg}&searchOpt=${searchOpt}&searchValue=${encodeURIComponent(searchValue)}`;
	            history.pushState({ pg, searchOpt, searchValue }, '', selectUrl);
	        },
	        error: function(xhr, status, error) {
	            alert("영화 검색에 실패했습니다.");
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
	    selectMoviePaging(pg); // AJAX 요청을 통해 새 페이지 데이터 가져오기
	});

	
});