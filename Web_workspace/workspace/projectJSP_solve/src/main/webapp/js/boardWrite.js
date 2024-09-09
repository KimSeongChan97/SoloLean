$(function(){
	$('#boardWriteBtn').click(function(){
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if($('#subject').val() == '')
			$('#subjectDiv').html('제목 입력');
		
		else if($('#content').val() == '')
			$('#contentDiv').html('내용 입력');
		
		else
			$.ajax({
				type: 'post',
				url: 'boardWrite.jsp',
				data: {
					'subject': $('#subject').val(),
					'content': $('#content').val()
				},
				success: function(){
					alert("글쓰기 완료");
					location.href = "boardList.jsp?pg=1";
				},
				error: function(e){
					console.log(e);
				}
			});
	});
});












