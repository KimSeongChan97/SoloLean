$(function(){
    // 업로드 버튼 클릭 시 실행되는 이벤트 핸들러
    $('#uploadAJaxBtn').click(function(){
        // FormData 객체를 생성하여 폼에 입력된 데이터를 가져옵니다.
        // FormData는 폼 데이터를 쉽게 다루고, 파일 업로드도 가능하게 해줍니다.
        let formData = new FormData($('#uploadAJaxForm')[0]); 
        // $('#uploadAJaxForm')[0]을 통해 폼 엘리먼트를 선택하여 해당 엘리먼트의 데이터를 FormData로 가져옵니다.

        // AJAX 요청을 통해 데이터를 서버에 비동기 전송
        $.ajax({
            type: 'post', // POST 방식으로 서버에 데이터를 전송
            enctype: 'multipart/form-data', // 파일을 포함한 데이터를 전송하기 위해 설정
            processData: false, // 데이터를 쿼리스트링으로 변환하지 않도록 설정
            contentType: false, // 'multipart/form-data'로 전송하기 위해 contentType 설정을 false로 설정
            url: '/spring/user/upload', // 파일을 전송할 서버의 URL
            data: formData, // 폼 데이터를 담은 formData 객체 전송
            success: function(data) { 
                // 요청이 성공적으로 완료되었을 때 실행되는 콜백 함수
                // 업로드가 완료되면, 페이지를 "/spring/user/uploadList"로 리다이렉트합니다.
                alert('이미지 업로드 완료');
                location.href = "/spring/user/uploadList"; 
            },
            error: function(e) { 
                // 요청이 실패했을 때 오류 메시지를 콘솔에 출력합니다.
                console.log(e); 
            }   
        }); // $.ajax  
        
    }); // #uploadAJaxBtn
});

/*
processData
 - 기본값은 true
 - 기본적으로 Query String으로 변환해서 보내진다('변수=값&변수=값')
 - 파일 전송 시에는 반드시 false로 설정해야 한다. 이는 formData 객체를 문자열로 변환하지 않기 위해서이다.
 - 이 옵션이 false로 설정되면, 데이터가 원본 그대로 서버로 전송된다.
 
contentType
  - 기본적으로 "application/x-www-form-urlencoded; charset=UTF-8"으로 설정되어 있다.
  - 그러나 파일 전송 시에는 'multipart/form-data'로 전송되며, 이를 자동으로 처리할 수 있도록 contentType을 false로 설정해야 한다.
  - 이 설정을 통해 브라우저가 적절한 헤더와 콘텐츠 유형을 자동으로 설정하게 한다.
*/

