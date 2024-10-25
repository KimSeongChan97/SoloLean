$(function(){
    // jQuery를 사용하여 문서가 완전히 로드된 후 실행될 함수를 정의합니다.
    // $(function() {})은 jQuery의 기본적인 준비 함수입니다.
    // 즉, 이 내부의 코드는 HTML 문서가 완전히 로드된 후에 실행됩니다.
    // 이렇게 하면 HTML 요소들이 모두 준비된 이후에 JavaScript가 정상적으로 작동할 수 있습니다.

    // 현재 로그인한 사용자가 게시글 작성자인지 확인하는 로직
    // '#memId'는 현재 로그인한 사용자의 ID를 담고 있는 hidden input 필드입니다.
    // hidden input 필드는 사용자에게는 보이지 않지만, 값은 저장되어 있는 HTML 요소입니다.
    // '#id'는 게시글 작성자의 ID를 표시하는 요소입니다.
    // 게시글 화면에서 작성자의 ID를 화면에 표시하는 경우 이를 이용해 로그인한 사용자와 비교할 수 있습니다.
    if($('#memId').val() == $('#id').text()){
        // 조건이 참이면 (즉, 로그인한 사용자가 게시글 작성자라면)
        // 사용자가 자신이 쓴 게시글을 확인하는 경우에만 수정 및 삭제 버튼을 보여줍니다.
        // '#boardViewSpan' 요소를 보이게 합니다.
        // 이 요소는 수정/삭제 버튼을 포함하고 있을 것입니다.
        // $('#boardViewSpan').show()는 jQuery의 show() 메서드로, 숨겨진 HTML 요소를 화면에 표시하는 기능입니다.
        $('#boardViewSpan').show();
    } else {
        // 조건이 거짓이면 (즉, 로그인한 사용자가 게시글 작성자가 아니라면)
        // 수정/삭제 버튼이 포함된 '#boardViewSpan' 요소를 숨깁니다.
        // 이 코드로 작성자가 아닌 다른 사용자는 수정 및 삭제 기능을 볼 수 없게 됩니다.
        // $('#boardViewSpan').hide()는 jQuery의 hide() 메서드로, 해당 HTML 요소를 화면에서 숨깁니다.
        $('#boardViewSpan').hide();
    }
    
    // 글 수정
    // 게시글을 수정하는 버튼 클릭 이벤트를 처리하는 함수입니다.
    // '#boardUpdateFormBtn'은 글 수정 버튼의 ID로, 사용자가 수정 버튼을 클릭하면 이 이벤트가 실행됩니다.
    $('#boardUpdateFormBtn').click(function(){
        // 클릭 시 현재 폼('#boardViewForm')의 action 속성을 '/projectMVC/board/boardUpdateForm.do'로 변경합니다.
        // action 속성은 폼이 제출되었을 때 데이터를 전송할 URL을 지정하는 부분입니다.
        // 즉, 사용자가 수정 버튼을 누르면 '/projectMVC/board/boardUpdateForm.do'로 폼 데이터가 전송됩니다.
        $('#boardViewForm').attr('action', '/projectMVC/board/boardUpdateForm.do');
        
        // 폼 데이터를 실제로 제출하는 코드입니다.
        // $('#boardViewForm').submit()은 폼에 입력된 데이터를 서버로 전송합니다.
        // 이 때, seq (글 번호)와 pg (페이지 정보)가 폼 데이터로 전송됩니다.
        $('#boardViewForm').submit(); // seq, pg 를 가지고 이동한다.
    });
        
    // 글 삭제 - 글을 삭제한 후에는 1페이지를 보여줌
    // 게시글을 삭제하는 버튼 클릭 이벤트를 처리하는 함수입니다.
    // '#boardDeleteFormBtn'은 글 삭제 버튼의 ID로, 사용자가 삭제 버튼을 클릭하면 이 이벤트가 실행됩니다.
    $('#boardDeleteFormBtn').click(function(){
        // 클릭 시 현재 폼('#boardViewForm')의 action 속성을 '/projectMVC/board/boardDeleteForm.do'로 변경합니다.
        // 삭제 요청은 '/projectMVC/board/boardDeleteForm.do'로 전송됩니다.
        $('#boardViewForm').attr('action', '/projectMVC/board/boardDeleteForm.do');
        
        // 폼 데이터를 서버로 제출하는 코드입니다.
        // 이 때, seq (글 번호)가 폼 데이터로 전송됩니다.
        // 즉, 사용자가 삭제 버튼을 누르면 글 번호(seq)를 기반으로 해당 게시글이 삭제됩니다.
        $('#boardViewForm').submit(); // seq 를 가지고 이동한다.
    });
});
