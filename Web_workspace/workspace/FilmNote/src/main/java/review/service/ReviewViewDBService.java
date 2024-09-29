// FilmNote/src/main/java/review.service.ReviewViewDBService.java
package review.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.dao.MovieDAO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;

public class ReviewViewDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		MovieDAO movieDAO = MovieDAO.getInstance();
		
		int mcode = Integer.parseInt(request.getParameter("movie_code"));
		int userMScore = Integer.parseInt(request.getParameter("score")); // 사용자 별점
		ReviewDTO reviewDTO = new ReviewDTO(
												0, 
												mcode,
												request.getParameter("user_id"),
												request.getParameter("content"),
												null,
												userMScore
											);
		
		System.out.println(reviewDTO.toString());
		
		// 1. 리뷰 추가
		reviewDAO.insertReviewDTO(reviewDTO);
		
		// 2. 영화 별점 계산
		movieDAO.updateMovieScore(mcode);
		
		return "none";
	}

}
