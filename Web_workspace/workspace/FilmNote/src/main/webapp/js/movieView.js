// FilmNote/src/main/webapp/js/movieView.js

$(function(){	
	// let boardId = $('#boardId').text(); // 작성자 ID
	let mcode = $('#mcode').val().trim();
	let pg = $('#pg').val().trim();
	let movieTitle = $('#movieTitle').val().trim();
	
	console.log("mcode:", mcode);
	console.log("pg:", pg);
	console.log("movieTitle:", movieTitle);
	console.log("context:", context);

	
	/** 수정 버튼; 해당 영화 수정 페이지 이동 */
	$('#movieEditBtn').click(function() {
		location.href = context + '/admin/movieEdit.do?mcode=' + mcode + '&pg=' + pg;
	});
	
	// movieView.js
	/** 삭제 버튼; 해당 영화 삭제 */
	$('#movieDeleteBtn').click(function() {
		let mcodeArray = [];
		mcodeArray.push(mcode);
		
		if (confirm("' " + movieTitle + " ' 을(를) 삭제하시겠습니까?")) {
			$.ajax({
			    type: 'POST',
			    url: context + '/admin/movieDeleteDB.do',
			    data: { mcode: mcodeArray},  // 배열로 감싸서 전송 - 선택 삭제와 dao 함수 같이 쓰기 위함
				traditional: true,
			    success: function() {
			        alert("' " + movieTitle + " ' 을(를) 삭제하였습니다.");
			        window.location.href = context + '/admin/movieList.do?pg=' + pg;
			    },
			    error: function(xhr, status, error) {
			        alert("' " + movieTitle + " ' 을(를) 삭제하지 못했습니다.");
			        console.log("에러 상태:", status);
			        console.log("에러 메시지:", error);
			        console.log("응답 내용:", xhr.responseText);
			    }
			});			
			
		} else {
		    // 취소를 클릭했을 때 아무 동작도 하지 않음
		}
	});
	
	
	/** 목록 버튼; movieList.jsp 이동 */
	$('#listBtn').click(function() {
		location.href = context + '/admin/movieList.do?pg=' + pg;
	});

});
