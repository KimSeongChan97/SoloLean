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
	ReviewPaging reviewPaging = null; // 리뷰 페이징 객체 선언
	
	// 페이징 처리 메서드
	private void paging(String reqPg, int totalA) {
		System.out.println("paging("+reqPg+") 호출");
		
		// 1. 페이지 정보 처리
		int pg = 1; // 기본 페이지를 1로 설정
		if (reqPg != null) pg = Integer.parseInt(reqPg); // 클라이언트로부터 받은 pg 값이 있으면 해당 값으로 설정
		reviewPaging = new ReviewPaging(); // 페이징 객체 생성
		
		// 2. 페이징 정보 설정
		reviewPaging.setCurrentPage(pg); // 현재 페이지 설정
		reviewPaging.setPageBlock(5); // 페이지 목록 개수 설정 (한번에 표시되는 페이지 수)
		reviewPaging.setPageSize(10); // 한 페이지당 보여줄 리뷰 수 설정
		reviewPaging.setTotalA(totalA); // 총 리뷰 수 설정
		
		System.out.println("current: " + reviewPaging.getCurrentPage());
		System.out.println("TotalA: " + reviewPaging.getTotalA());
		
		// 3. 페이지 목록 생성
		reviewPaging.makePagingHTML(); // 페이지 네비게이션 HTML 생성
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 1. 클라이언트로부터 받은 데이터 처리 (영화 코드 받기)
		int mcode = Integer.parseInt(request.getParameter("mcode")); // 영화 코드

		// 2. DAO 객체를 통해 영화와 리뷰 정보 가져오기
		MovieDTO movieDTO = MovieDAO.getInstance().getMovie(mcode); // 영화 정보 가져오기
		ReviewDAO reviewDAO = ReviewDAO.getInstance(); // 리뷰 DAO 객체 생성

		// 3. 페이징 처리
		// 클라이언트로부터 받은 페이지 정보와, 해당 영화에 대한 총 리뷰 수를 이용해 페이징 처리
		paging(request.getParameter("pg"), reviewDAO.getTotalA(mcode)); // 페이지 번호와 리뷰 총 개수
		// 해당 영화에 대한 리뷰 목록을 페이징 처리하여 가져옴
		List<ReviewDTO> reviewDTOList = reviewDAO.getReviewList(mcode, reviewPaging.getCurrentPage(), reviewPaging.getPageSize()); 

		// 4. 클라이언트로 보낼 데이터 설정
		request.setAttribute("movieDTO", movieDTO); // 영화 정보 설정
		request.setAttribute("reviewDTOList", reviewDTOList); // 리뷰 목록 설정
		request.setAttribute("reviewTotalA", reviewPaging.getTotalA()); // 총 리뷰 수 설정
		request.setAttribute("reviewPagingHTML", reviewPaging.getPagingHTML()); // 페이징 네비게이션 설정
		request.setAttribute("pg", reviewPaging.getCurrentPage()); // 현재 페이지 설정
		
		// 5. 해당 JSP 페이지로 이동
		return "/review/reviewView.jsp";
	}

}
