package review.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.dao.MovieDAO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;

public class ReviewUpdateDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		MovieDAO movieDAO = MovieDAO.getInstance();
		
		int mcode = Integer.parseInt(request.getParameter("movie_code")); // 영화 코드
		int rcode = Integer.parseInt(request.getParameter("rcode")); // 리뷰 코드
		int userMScore = Integer.parseInt(request.getParameter("score")); // 사용자 수정 별점
		ReviewDTO reviewDTO = new ReviewDTO(
												rcode, 
												mcode,
												request.getParameter("user_id"),
												request.getParameter("content"),
												null,
												userMScore
											);
		
		System.out.println(reviewDTO.toString());
		System.out.println();
		
		// 1. 리뷰 수정
		reviewDAO.updateReviewDTO(reviewDTO);
		
		// 2. 영화 별점 계산
		movieDAO.updateMovieScore(mcode);

		return "none";
	}

}
