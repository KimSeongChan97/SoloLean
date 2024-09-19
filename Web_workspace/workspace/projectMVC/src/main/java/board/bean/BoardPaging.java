package board.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPaging {
	private int currentPage; // 현재 페이지
    // 사용자가 현재 보고 있는 페이지 번호입니다. 예를 들어, 사용자가 2페이지를 보고 있다면 이 값은 2가 됩니다.
	private int pageBlock; // [이전][1][2][3]...[다음]
    // 한 번에 보여줄 페이지 블록 수입니다. 예를 들어, [1][2][3] 또는 [이전][4][5][6][다음]과 같이 한 번에 몇 개의 페이지를 표시할지 설정합니다.
	private int pageSize; // 1페이지당 5개씩
    // 한 페이지에 표시될 게시글 수입니다. 예를 들어, 한 페이지에 5개의 게시글을 표시하려면 이 값이 5가 됩니다.
	private int totalA;  // 총 글수
    // 전체 게시글 수를 의미합니다. 총 몇 개의 게시글이 있는지 나타냅니다.
	private StringBuffer pagingHTML; 
    // StringBuffer는 문자열을 동적으로 생성할 때 사용됩니다. 여기서는 페이지네이션 HTML을 동적으로 생성하는 데 사용됩니다.
	
	public void makePagingHTML() {
        // pagingHTML을 초기화하여 빈 StringBuffer 객체를 생성합니다.
        // 페이지 번호와 "이전" 및 "다음" 버튼을 포함하는 HTML 코드가 동적으로 여기에 추가될 것입니다.
		pagingHTML = new StringBuffer();
		
		// 전체 페이지 수를 계산합니다.
        // 총 게시글 수(totalA)를 페이지당 표시할 게시글 수(pageSize)로 나누어 총 페이지 수를 구합니다.
        // 예를 들어, 게시글이 13개 있고, 페이지당 5개의 게시글을 표시한다면 총 페이지 수는 3이 됩니다.
        // 'totalA + pageSize - 1'는 총 게시글 수가 딱 나누어 떨어지지 않을 때 한 페이지를 추가하기 위한 처리입니다.
		int totalP = (totalA + pageSize-1) / pageSize; // 총 페이지 수
		
		// startPage
        // 현재 페이지를 기준으로 페이지 블록 내에서 시작 페이지 번호를 계산합니다.
        // 예를 들어, currentPage가 7이고, pageBlock이 3이라면 startPage는 7이 아닌 7이 속한 블록의 첫 페이지가 됩니다.
        // 페이지 블록이 3이라면 [1][2][3], [4][5][6], [7][8][9]로 페이지 블록이 나뉩니다.
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		
		// endPage
        // 끝 페이지를 계산합니다. 시작 페이지에 pageBlock 값을 더한 후 1을 뺀 값이 끝 페이지가 됩니다.
        // 예를 들어, startPage가 4이고 pageBlock이 3이면, endPage는 6이 됩니다.
		int endPage = startPage + pageBlock - 1;
		
		// 만약 endPage가 총 페이지 수보다 크다면 endPage를 총 페이지 수로 설정합니다.
        // 이 코드는 마지막 블록에서 페이지가 부족할 때 끝 페이지를 총 페이지 수로 제한하기 위함입니다.
        // 예를 들어, 총 페이지 수가 7인데 endPage가 9가 된다면, endPage는 7로 조정됩니다.
		if(endPage > totalP) endPage = totalP;
		
		
		// 이전 버튼을 추가
        // 현재 페이지가 1보다 크면 이전 버튼을 표시합니다.
        // 첫 페이지에서는 이전 버튼을 표시하지 않기 위해 currentPage가 1보다 클 때만 이전 버튼이 나타나도록 설정합니다.
        // 'startPage-1'는 이전 블록으로 이동할 수 있도록 계산된 값입니다.
		if(currentPage > 1)
			// 자바스크립트 함수를 호출하여 사용자가 이전 버튼을 클릭했을 때 페이지를 이동합니다.
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (startPage-1) + ")' >이전</span>");
		
		// startPage부터 endPage까지 반복문을 돌며 각 페이지 번호를 추가합니다.
        // for문을 사용해 페이지 블록 내에서 각 페이지 번호를 HTML로 생성합니다.
        // 예를 들어, startPage가 4이고 endPage가 6이면, [4][5][6] 페이지가 생성됩니다.
		for (int i=startPage; i<=endPage; i++) {
                // 현재 페이지는 별도로 강조 표시하기 위해 'id="currentPaging"'으로 스타일을 다르게 적용합니다.
                // 현재 보고 있는 페이지 번호와 비교하여 강조 표시합니다.
				if (i == currentPage)
					pagingHTML.append("<span id='currentPaging' onclick='boardPaging(" + i + ")' >" + i + "</span>");
				else
                    // 현재 페이지가 아닌 경우 일반적인 페이지 번호로 표시됩니다.
					pagingHTML.append("<span id='Paging' onclick='boardPaging(" + i + ")' >" + i + "</span>");
		} // for
		
		// 다음 버튼을 추가
        // 마지막 페이지 블록이 아닌 경우에만 다음 버튼을 표시합니다.
        // endPage가 총 페이지 수(totalP)보다 작은 경우에만 '다음' 버튼을 추가합니다.
        // 'endPage+1'는 다음 블록으로 이동할 수 있도록 계산된 값입니다.
		if(endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (endPage+1) + ")' >다음</span>");
	}
}
