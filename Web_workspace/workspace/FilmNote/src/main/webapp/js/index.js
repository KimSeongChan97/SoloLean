$(function() {
    let movieInRowCount = 4; // 한 행에 4개의 영화를 표시하기 위해 설정된 변수입니다.

    // 영화 검색 버튼을 클릭하면 실행되는 함수
    $('#searchBtn').click(function() {
        let searchOpt = $('.search-opt').val(); // 검색 옵션을 선택한 값을 가져옴 (예: 영화 제목, 감독 등)
        let searchValue = $('#title-box').val(); // 입력된 검색어를 가져옴
        
        // AJAX 요청을 통해 서버에 영화 검색 요청을 보냄
        $.ajax({
            url: context + '/user/movieSearchDB.do', // 서버에 요청할 URL
            type: 'GET', // GET 방식으로 데이터를 요청
            data: {
                searchOpt: searchOpt, // 검색 옵션 (제목, 감독 등)
                searchValue: searchValue, // 검색어 입력값
            },
            success: function(data) {
                // 서버로부터 검색 결과 데이터를 성공적으로 받으면 실행되는 부분
                console.log("응답 데이터:", data); // 응답 데이터를 콘솔에 출력하여 확인
                
                // 기존에 표시된 영화 목록을 모두 제거
                $('#movieTableBody').empty(); 
                
                // 검색 결과가 없을 경우
                if (data.movies.length === 0) {
                    // 테이블에 검색 결과가 없다는 메시지를 표시
                    $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
                } else {
                    // 검색 결과가 있을 경우 영화 목록을 테이블 형식으로 표시
                    // 4개의 영화씩 한 행에 표시하기 위해 for문 사용
                    for (let row = 0; row < data.movies.length; row += movieInRowCount) {
                        let rowHtml = '<tr>'; // 새로운 행을 시작
                        
                        // 한 행에 최대 4개의 영화를 추가
                        for (let i = row; i < row + movieInRowCount; i++) {
                            if (i < data.movies.length) {
                                // 영화 데이터가 있는 경우 해당 영화 정보를 테이블에 추가
                                let movieDTO = data.movies[i];
                                rowHtml += `
                                    <td>
                                        <a href="${context}/review/reviewView.do?mcode=${movieDTO.mcode}&pg=1">
                                            <div class="hover-info">
                                                <!-- 영화 포스터를 표시하고 마우스를 올렸을 때 영화 정보가 나타나도록 설정 -->

                                                <img width="230px" height="330px" src="${movieDTO.poster}" alt="" class="thumb"/>

                                                <div class="over">
                                                    <span class="title">${movieDTO.title}</span><br>
                                                    <span class="open_date">개봉일 : ${movieDTO.release_date}</span><br>
                                                    <span class="director">감독 : ${movieDTO.director}</span><br>
                                                    <span class="score">평점 : ${movieDTO.score.toFixed(2)}점</span><br>
                                                </div>
                                            </div>
                                        </a>
                                    </td>
                                `;
                            } else {
                                // 영화 데이터가 없는 경우 빈 <td>를 추가하여 자리 유지
                                rowHtml += '<td></td>';
                            }
                        }
                        rowHtml += '</tr>'; // 행을 종료
                        $('#movieTableBody').append(rowHtml); // 완성된 행을 테이블에 추가
                    }
                }

            },
            error: function(xhr, status, error) {
                // 서버로부터 응답을 받는 데 실패했을 경우 실행
                alert("영화 검색에 실패했습니다."); // 사용자에게 실패 메시지를 알림
                console.log("에러 상태:", status); // 에러 상태를 콘솔에 출력
                console.log("에러 메시지:", error); // 에러 메시지를 콘솔에 출력
                console.log("응답 내용:", xhr.responseText); // 서버 응답 내용을 콘솔에 출력
            }
        });
    });
});
