
// 글 제목을 클릭하였을 시
$('.subjectA').click(function(){
	if($('#memId').val() == '') 
		alert('먼저 로그인하세요!');
	else {
		// alert($(this).parent().prev().prop('tagName'));
		//alert('seq = ' + $(this).parent().prev().text());
		//alert('pg = ' + $('#pg').val());
		
		let seq = $(this).parent().prev().text();
		let pg = $('#pg').val();
		
		location.href = '/projectMVC/board/boardView.do?seq=' + seq + '&pg=' + pg;
				
	}
		
});
