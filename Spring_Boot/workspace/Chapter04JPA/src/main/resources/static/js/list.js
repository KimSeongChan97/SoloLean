$(function(){
   // 검색 버튼 클릭 시 실행되는 이벤트 리스너
   $('#searchListBtn').click(function(){
      // 검색어 입력 여부를 확인
      if($('#value').val() == '') 
         alert('검색어를 입력하시오'); // 검색어가 없을 경우 경고 메시지 출력
      else 
         $.ajax({
            type: 'get', // HTTP GET 요청을 사용하여 서버에 데이터를 요청
            url: '/member/getSearchList', // 요청할 URL, 서버의 특정 엔드포인트와 연결
            data: { 'columnName': $('#columnName').val(), // 검색할 컬럼 이름 (예: name 또는 id)
                  'value': $('#value').val() }, // 검색어 값
            dataType: 'json', // 서버에서 반환되는 데이터 타입을 JSON으로 설정
            success: function(data){
               console.log(data); // 서버로부터 받은 데이터 로그로 출력하여 확인
               
               // 기존 검색 결과를 초기화 (표에서 첫 번째 행 이후의 모든 행 삭제)
               $('#listTable tr:gt(0)').remove();
               
               // 받아온 JSON 데이터를 반복 처리하여 테이블에 추가
               $.each(data.list.content, function(index, item){
                   let result = `<tr>`
                              + `<td align="center">` + item.seq + `</td>`    
                              + `<td align="center">` + item.id + `</td>`     
                              + `<td align="center">` + item.pwd + `</td>`    
                              + `<td align="center">` + item.name + `</td>`   
                              + `</tr>`;
                   $('#listTable').append(result);    
               });
            },
            error: function(e){
               console.log(e); // 오류 정보를 콘솔에 출력하여 문제를 디버깅
            }      
         });
   });
});

// list.js