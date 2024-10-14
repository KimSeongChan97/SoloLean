$(function() {
    // "전체 선택" 체크박스 클릭 이벤트 처리
    $('#selectAll').on('click', function() {
        const selectAll = $(this).prop('checked');
        // 모든 .selectItem 체크박스 상태를 "전체 선택" 상태에 맞게 변경
        $('.selectItem').prop('checked', selectAll);
    });

    // 개별 체크박스 클릭 이벤트 처리
    $('.selectItem').on('click', function() {
        const totalCheckboxes = $('.selectItem').length;
        const checkedCheckboxes = $('.selectItem:checked').length;

        // 모든 체크박스가 체크되었을 경우 "전체 선택" 체크박스를 체크, 그렇지 않으면 해제
        $('#selectAll').prop('checked', totalCheckboxes === checkedCheckboxes);
    });
});


$(function(){
	$('#deleteButton').click(function(){
		alert("정말로 삭제하시겠습니까?");
	}); // #deleteButton
});