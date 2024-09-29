// FilmNote/src/main/java/movie.bean.MoviePaging.java
package movie.bean;

import lombok.Data;

@Data
public class MoviePaging {

	private int currentPage; // 현재 페이지
	private int pageBlock; // [이전] [1] [2] [3] [다음]
	private int pageSize; // 한 페이지당 영화 개수
	private int totalA; // 총 영화 수
	private StringBuffer pagingHTML; // 전체 검색 결과에 대한 페이지 HTML
	
	private int selectTotal; // 검색된 영화 개수
	private StringBuffer selectPagingHTML; // 검색 결과에 대한 페이지 HTML
	
	public void makePagingHTML() {

		/** 전체 영화 리스트의 페이징 */
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA + pageSize - 1) / pageSize;
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if (endPage > totalP) endPage = totalP;
		
		if (startPage != 1)
				pagingHTML.append("<span id='paging' onclick='moviePaging(" + (startPage - 1) + ")'>이전</span>");
		
		for (int i = startPage; i<=endPage; i++ ) {
			if ( i == currentPage)
				pagingHTML.append("<span id='currentPaging' onclick='moviePaging(" + i + ")'>" + i + "</span>");
			else
				pagingHTML.append("<span id='paging' onclick='moviePaging(" + i + ")'>" + i + "</span>");
		}
		
		if (endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='moviePaging(" + (endPage + 1) + ")'>다음</span>");
		
		/** 검색된 결과에 대한 페이징 처리 */
		selectPagingHTML = new StringBuffer();
		
		totalP = (selectTotal + pageSize - 1) / pageSize;
		startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		endPage = startPage + pageBlock - 1;
		if (endPage > totalP) endPage = totalP;
		
		if (startPage != 1)
			selectPagingHTML.append("<span id='paging' onclick='selectMoviePaging(" + (startPage - 1) + ")'>이전</span>");
		
		for (int i = startPage; i<=endPage; i++ ) {
			if ( i == currentPage)
				selectPagingHTML.append("<span id='currentPaging' onclick='selectMoviePaging(" + i + ")'>" + i + "</span>");
			else
				selectPagingHTML.append("<span id='paging' onclick='selectMoviePaging(" + i + ")'>" + i + "</span>");
		}
		
		if (endPage < totalP)
			selectPagingHTML.append("<span id='paging' onclick='selectMoviePaging(" + (endPage + 1) + ")'>다음</span>");
		
		
		
		
	}
}