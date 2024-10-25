package admin.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class AdminPaging {
	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][다음]
	private int pageSize; //1페이지당 5개씩
	private int totalA; //총글수
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA + pageSize-1) / pageSize;
		
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > totalP)
			endPage = totalP;
		
		if(startPage != 1)
			pagingHTML.append("<span id='paging' onclick='adminPaging(" + (startPage-1) + ")'>이전</span>");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i == currentPage)
				pagingHTML.append("<span id='currentPaging' onclick='adminPaging(" + i + ")'>" + i + "</span>");
			else
				pagingHTML.append("<span id='paging' onclick='adminPaging(" + i + ")'>" + i + "</span>");
		}//for
		
		if(endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='adminPaging(" + (endPage+1) + ")'>다음</span>");
	}

}
