// FilmNote/src/main/webapp/js/index.js

$(function() {
    let movieInRowCount = 4; // 한 행에 4개의 영화 표시

    // 영화 검색
    $('#searchBtn').click(function() {
        let searchOpt = $('.search-opt').val();
        let searchValue = $('#title-box').val();
        
        $.ajax({
            url: context + '/user/movieSearchDB.do',
            type: 'GET',
            data: {
                searchOpt: searchOpt,
                searchValue: searchValue,
            },
            success: function(data) {
                console.log("응답 데이터:", data); // 응답 데이터 확인

                $('#movieTableBody').empty(); // 기존 테이블 <tbody> 데이터 제거
                
                if (data.movies.length === 0) {
                    $('#movieTableBody').append('<tr><td colspan="4" align="center">검색 결과가 없습니다.</td></tr>');
                } else {
                    // 4열의 테이블로 영화 목록 추가
                    for (let row = 0; row < data.movies.length; row += movieInRowCount) {
                        let rowHtml = '<tr>'; // 새로운 행 시작
                        
                        for (let i = row; i < row + movieInRowCount; i++) {
                            if (i < data.movies.length) {
                                let movieDTO = data.movies[i];
                                rowHtml += `
                                    <td>
                                        <a href="${context}/review/reviewView.do?mcode=${movieDTO.mcode}&pg=1">
                                            <div class="hover-info">
                                                <img src="${movieDTO.poster}" alt="" class="thumb"/>
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
                                // 영화 데이터가 없으면 빈 <td> 추가
                                rowHtml += '<td></td>';
                            }
                        }
                        rowHtml += '</tr>'; // 행 종료
                        $('#movieTableBody').append(rowHtml); // 완성된 행 추가
                    }
                }

            },
            error: function(xhr, status, error) {
                alert("영화 검색에 실패했습니다.");
                console.log("에러 상태:", status);
                console.log("에러 메시지:", error);
                console.log("응답 내용:", xhr.responseText);
            }
        });
    });
});
