package admin.bean;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component  // Spring에서 이 클래스를 Bean으로 등록하여 다른 곳에서 주입해서 사용할 수 있도록 함
@Setter  // Lombok을 이용해, setter 메서드를 자동 생성
@Getter  // Lombok을 이용해, getter 메서드를 자동 생성
public class AdminPaging {
	private int currentPage; //현재페이지 (현재 사용자가 보고 있는 페이지 번호)
	private int pageBlock; //[이전][1][2][3][다음] (페이지 목록에서 한번에 보여줄 페이지 번호의 수)
	private int pageSize; //1페이지당 5개씩 (한 페이지에 보여줄 게시물의 개수)
	private int totalA; //총글수 (전체 게시물의 개수)
	private StringBuffer pagingHTML;  // 페이지 네비게이션을 저장할 HTML을 만들기 위한 StringBuffer 객체

	// 페이징 HTML을 생성하는 메서드
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();  // StringBuffer 객체를 새로 초기화 (여기에 HTML 문자열이 추가될 예정)
		
		// 총 페이지 수를 계산
		// 예를 들어, 총 게시물이 22개이고, 한 페이지에 5개의 게시물을 보여주면 총 5페이지가 필요함
		int totalP = (totalA + pageSize - 1) / pageSize;
		// totalA는 전체 게시물 수, pageSize는 한 페이지에 보여줄 게시물 수
		// 총 페이지 수를 구할 때, 남는 게시물이 있는 경우 다음 페이지도 필요하기 때문에 pageSize로 나누고 나머지를 반영함

		// 시작 페이지 번호 계산
		// 예: 현재 페이지가 7이고, 페이지 블록이 3이라면, 현재 페이지가 속한 블록의 시작 페이지는 7
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		// (currentPage - 1) / pageBlock을 통해 현재 페이지가 속한 블록을 계산한 후, 해당 블록의 첫 페이지 번호를 구함

		// 끝 페이지 번호 계산
		// 예: 페이지 블록이 3이면, 끝 페이지는 시작 페이지 + 2, 단 총 페이지 수를 넘지 않아야 함
		int endPage = startPage + pageBlock - 1;
		if (endPage > totalP)
			endPage = totalP;  // 마지막 페이지가 총 페이지 수를 넘으면, 총 페이지 수를 마지막 페이지로 설정
		
		// 이전 페이지 블록으로 이동하는 '이전' 버튼을 추가
		// 시작 페이지가 1이 아니면, '이전' 버튼을 보여줌
		if (startPage != 1)
			pagingHTML.append("<span id='paging' onclick='adminPaging(" + (startPage - 1) + ")'>이전</span>");
		// "adminPaging()"은 자바스크립트 함수로, 해당 페이지 번호를 인자로 받아서 새로운 페이지로 이동함
		
		// 현재 페이지가 속한 페이지 블록의 각 페이지 번호를 출력
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage)
				// 현재 페이지는 하이라이트 (id='currentPaging') 처리하여 구분
				pagingHTML.append("<span id='currentPaging' onclick='adminPaging(" + i + ")'>" + i + "</span>");
			else
				// 그 외의 페이지는 일반 링크로 표시
				pagingHTML.append("<span id='paging' onclick='adminPaging(" + i + ")'>" + i + "</span>");
		}//for
		
		// 다음 페이지 블록으로 이동하는 '다음' 버튼을 추가
		// 끝 페이지가 총 페이지보다 적을 경우에만 '다음' 버튼을 보여줌
		if (endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='adminPaging(" + (endPage + 1) + ")'>다음</span>");
	}

}
