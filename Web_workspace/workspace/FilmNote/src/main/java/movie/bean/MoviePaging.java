package movie.bean;

import lombok.Data;

@Data
public class MoviePaging {

    private int currentPage; // 현재 페이지 번호
    private int pageBlock; // [이전] [1] [2] [3] [다음] 페이지 블록 수
    private int pageSize; // 한 페이지에 보여줄 영화 개수
    private int totalA; // 전체 영화 개수 (총 레코드 수)
    private StringBuffer pagingHTML; // 전체 영화 리스트에 대한 페이지네이션 HTML

    private int selectTotal; // 검색된 영화 개수
    private StringBuffer selectPagingHTML; // 검색된 영화 리스트에 대한 페이지네이션 HTML

    public void makePagingHTML() {
        /** 전체 영화 리스트에 대한 페이지네이션 생성 */
        pagingHTML = new StringBuffer();
        
        // 총 페이지 수 계산: (총 영화 개수 + 페이지 크기 - 1) / 페이지 크기
        int totalP = (totalA + pageSize - 1) / pageSize;
        
        // 현재 페이지에서 시작 페이지 계산: 페이지 블록 내의 첫 번째 페이지
        int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
        
        // 마지막 페이지 계산: 블록 내 마지막 페이지 번호
        int endPage = startPage + pageBlock - 1;
        
        // 마지막 페이지 번호가 총 페이지 수보다 크면, 총 페이지 수로 설정
        if (endPage > totalP) endPage = totalP;
        
        // 시작 페이지가 1보다 크면 [이전] 버튼을 생성
        if (startPage != 1)
            pagingHTML.append("<span id='paging' onclick='moviePaging(" + (startPage - 1) + ")'>이전</span>");
        
        // 페이지 블록 내의 각 페이지 번호를 생성
        for (int i = startPage; i <= endPage; i++) {
            if (i == currentPage) {
                // 현재 페이지일 경우, 해당 페이지에 강조 표시
                pagingHTML.append("<span id='currentPaging' onclick='moviePaging(" + i + ")'>" + i + "</span>");
            } else {
                // 그 외 페이지 번호는 클릭 가능하게 설정
                pagingHTML.append("<span id='paging' onclick='moviePaging(" + i + ")'>" + i + "</span>");
            }
        }
        
        // 마지막 페이지가 총 페이지보다 작으면 [다음] 버튼을 생성
        if (endPage < totalP)
            pagingHTML.append("<span id='paging' onclick='moviePaging(" + (endPage + 1) + ")'>다음</span>");
        
        /** 검색 결과에 대한 페이지네이션 생성 */
        selectPagingHTML = new StringBuffer();
        
        // 검색된 영화 총 페이지 수 계산: (검색된 영화 개수 + 페이지 크기 - 1) / 페이지 크기
        totalP = (selectTotal + pageSize - 1) / pageSize;
        
        // 검색 결과에서도 동일하게 시작 페이지와 마지막 페이지를 계산
        startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
        endPage = startPage + pageBlock - 1;
        if (endPage > totalP) endPage = totalP;
        
        // 검색 결과의 페이지네이션에서도 [이전] 버튼 생성
        if (startPage != 1)
            selectPagingHTML.append("<span id='paging' onclick='selectMoviePaging(" + (startPage - 1) + ")'>이전</span>");
        
        // 검색된 결과의 페이지 번호를 생성
        for (int i = startPage; i <= endPage; i++) {
            if (i == currentPage) {
                // 검색된 결과에서 현재 페이지일 경우, 강조 표시
                selectPagingHTML.append("<span id='currentPaging' onclick='selectMoviePaging(" + i + ")'>" + i + "</span>");
            } else {
                // 검색된 결과의 다른 페이지는 클릭 가능하게 설정
                selectPagingHTML.append("<span id='paging' onclick='selectMoviePaging(" + i + ")'>" + i + "</span>");
            }
        }
        
        // 검색 결과 마지막 페이지가 총 페이지보다 작으면 [다음] 버튼을 생성
        if (endPage < totalP)
            selectPagingHTML.append("<span id='paging' onclick='selectMoviePaging(" + (endPage + 1) + ")'>다음</span>");
    }
}
