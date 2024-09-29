// FilmNote/src/main/java/review.service.ReviewViewService.java
package review.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;
import review.bean.ReviewDTO;
import review.bean.ReviewPaging;
import review.dao.ReviewDAO;

public class ReviewViewService implements CommandProcess {
	ReviewPaging reviewPaging = null;
	
	private void paging(String reqPg, int totalA) {
		System.out.println("pagingp("+reqPg+") 호출");
		
		// 1. 변수 설정
		int pg = 1;
		if (reqPg != null) pg = Integer.parseInt(reqPg);
		reviewPaging = new ReviewPaging();
		
		// 2. paging 변수 설정
		reviewPaging.setCurrentPage(pg);
		reviewPaging.setPageBlock(5); // 페이지 목록 개수 
		reviewPaging.setPageSize(10); // 1페이지의 Item 
		reviewPaging.setTotalA(totalA);
		
		System.out.println("current: " + reviewPaging.getCurrentPage());
		System.out.println("TotalA: " + reviewPaging.getTotalA());
		
		// 3. 페이지 목록 만들기
		reviewPaging.makePagingHTML();
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 1. get Data
		int mcode = Integer.parseInt(request.getParameter("mcode")); // 영화 코드
		
		// 2. DAO
		MovieDTO movieDTO = MovieDAO.getInstance().getMovie(mcode); // 영화 정보
		ReviewDAO reviewDAO = ReviewDAO.getInstance(); // 리뷰 DAO
		
		// 3. Paging
		paging(request.getParameter("pg"), reviewDAO.getTotalA(mcode));
		List<ReviewDTO> reviewDTOList = reviewDAO.getReviewList(mcode, reviewPaging.getCurrentPage(), reviewPaging.getPageSize()); 
		
		// 4. set Data
		request.setAttribute("movieDTO", movieDTO); // 영화 정보
		request.setAttribute("reviewDTOList", reviewDTOList); // 리뷰 리스트
		request.setAttribute("reviewTotalA", reviewPaging.getTotalA());
		request.setAttribute("reviewPagingHTML", reviewPaging.getPagingHTML());
		request.setAttribute("pg", reviewPaging.getCurrentPage());
		
		return "/review/reviewView.jsp";
	}

}
