package review.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.dao.MovieDAO;
import review.dao.ReviewDAO;

public class ReviewDeleteDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		MovieDAO movieDAO = MovieDAO.getInstance();
		
		int rcode = Integer.parseInt(request.getParameter("rcode")); // 리뷰 코드
		int mcode = Integer.parseInt(request.getParameter("mcode")); // 영화 코드
		
		// 1. 리뷰 삭제
		reviewDAO.deleteReviedDTO(rcode);
		// 2. 영화 별점 계산
		movieDAO.updateMovieScore(mcode);
		
		return "none";
	}

}
