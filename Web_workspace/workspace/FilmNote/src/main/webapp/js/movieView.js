$(function(){	
	// mcode: 영화 고유 코드, pg: 페이지 번호, movieTitle: 영화 제목을 각각의 변수에 저장합니다.
	let mcode = $('#mcode').val().trim();
	let pg = $('#pg').val().trim();
	let movieTitle = $('#movieTitle').val().trim();
	
	// 콘솔에 각 변수의 값을 출력하여 값이 제대로 설정되었는지 확인합니다.
	console.log("mcode:", mcode);
	console.log("pg:", pg);
	console.log("movieTitle:", movieTitle);
	console.log("context:", context);

	/** 수정 버튼 클릭 시 해당 영화 수정 페이지로 이동 */
	$('#movieEditBtn').click(function() {
		// 수정 버튼을 누르면 영화 수정 페이지로 이동합니다.
		// 수정하려는 영화의 mcode와 현재 페이지 번호를 쿼리 스트링으로 전달합니다.
		location.href = context + '/admin/movieEdit.do?mcode=' + mcode + '&pg=' + pg;
	});
	
	/** 삭제 버튼 클릭 시 해당 영화를 삭제하는 기능 */
	$('#movieDeleteBtn').click(function() {
		// 삭제할 영화의 코드를 배열로 만들어 전송합니다.
		let mcodeArray = [];
		mcodeArray.push(mcode);
		
		// 삭제 여부를 사용자에게 확인하는 메시지를 출력합니다.
		if (confirm("' " + movieTitle + " ' 을(를) 삭제하시겠습니까?")) {
			// 사용자가 확인을 누르면 AJAX를 통해 삭제 요청을 서버로 보냅니다.
			$.ajax({
			    type: 'POST', // 데이터 전송 방식 (POST)
			    url: context + '/admin/movieDeleteDB.do', // 서버로 보낼 URL
			    data: { mcode: mcodeArray},  // mcode 값을 배열로 감싸서 전송 (선택 삭제와의 호환을 위해)
				traditional: true, // 배열 데이터를 제대로 전송하기 위한 옵션
			    success: function() {
			        // 영화 삭제에 성공하면 알림을 띄우고 영화 목록 페이지로 이동합니다.
			        alert("' " + movieTitle + " ' 을(를) 삭제하였습니다.");
			        window.location.href = context + '/admin/movieList.do?pg=' + pg;
			    },
			    error: function(xhr, status, error) {
			        // 영화 삭제에 실패하면 오류 메시지를 출력하고 콘솔에 오류 상태를 기록합니다.
			        alert("' " + movieTitle + " ' 을(를) 삭제하지 못했습니다.");
			        console.log("에러 상태:", status);
			        console.log("에러 메시지:", error);
			        console.log("응답 내용:", xhr.responseText);
			    }
			});			
		} else {
		    // 사용자가 취소를 누르면 아무 동작도 하지 않음
		}
	});
	
	/** 목록 버튼 클릭 시 영화 목록 페이지로 이동 */
	$('#listBtn').click(function() {
		// 목록 버튼을 누르면 현재 페이지 번호를 유지한 채로 영화 목록 페이지로 이동합니다.
		location.href = context + '/admin/movieList.do?pg=' + pg;
	});

});
