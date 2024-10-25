package review.bean;

import lombok.Data;

@Data
public class ReviewPaging {
    private int currentPage; // 현재 페이지 번호
    private int pageBlock; // 한 번에 표시할 페이지 블록 수 (예: [이전] [1] [2] [3] [다음])
    private int pageSize; // 한 페이지당 표시할 리뷰의 수
    private int totalA; // 전체 리뷰 수
    private StringBuffer pagingHTML; // 페이징 처리된 HTML을 담을 StringBuffer

    // 페이징 HTML을 생성하는 메서드
    public void makePagingHTML() {
        pagingHTML = new StringBuffer(); // 페이징 HTML 생성을 위한 StringBuffer 초기화

        // 전체 페이지 수 계산
        int totalP = (totalA + pageSize - 1) / pageSize; 
        // 시작 페이지 번호 계산
        int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
        // 끝 페이지 번호 계산
        int endPage = startPage + pageBlock - 1;
        // 끝 페이지 번호가 전체 페이지 수보다 크면, 전체 페이지 수로 설정
        if (endPage > totalP) endPage = totalP;

        // 이전 페이지 블록이 있는 경우, "이전" 버튼 추가
        if (startPage != 1)
            pagingHTML.append("<span id='paging' onclick='reviewPaging(" + (startPage - 1) + ")'>이전</span>");

        // 페이지 번호 출력
        for (int i = startPage; i <= endPage; i++) {
            if (i == currentPage) {
                // 현재 페이지는 강조하여 표시
                pagingHTML.append("<span id='currentPaging' onclick='reviewPaging(" + i + ")'>" + i + "</span>");
            } else {
                // 다른 페이지는 일반 링크로 표시
                pagingHTML.append("<span id='paging' onclick='reviewPaging(" + i + ")'>" + i + "</span>");
            }
        }

        // 다음 페이지 블록이 있는 경우, "다음" 버튼 추가
        if (endPage < totalP)
            pagingHTML.append("<span id='paging' onclick='reviewPaging(" + (endPage + 1) + ")'>다음</span>");
    }
}
