package review.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.dao.MovieDAO;
import review.dao.ReviewDAO;

public class ReviewDeleteDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 리뷰와 영화 정보를 관리하는 DAO 인스턴스 가져오기
		ReviewDAO reviewDAO = ReviewDAO.getInstance(); // 리뷰 데이터베이스 작업을 처리하는 DAO
		MovieDAO movieDAO = MovieDAO.getInstance(); // 영화 데이터베이스 작업을 처리하는 DAO
		
		// 클라이언트에서 전달된 리뷰 코드(rcode)와 영화 코드(mcode)를 요청에서 추출하여 정수로 변환
		int rcode = Integer.parseInt(request.getParameter("rcode")); // 리뷰 코드
		int mcode = Integer.parseInt(request.getParameter("mcode")); // 영화 코드
		
		// 1. 리뷰 삭제
		// ReviewDAO의 메서드를 사용해 데이터베이스에서 해당 리뷰(rcode)를 삭제
		reviewDAO.deleteReviedDTO(rcode);
		
		// 2. 영화 별점 계산
		// 리뷰가 삭제된 후, 영화에 대한 전체 리뷰를 다시 계산하여 영화의 평균 별점을 업데이트
		movieDAO.updateMovieScore(mcode);
		
		// 이 서비스는 별도의 페이지 전환이 필요 없기 때문에 "none"을 반환 (AJAX 응답으로 처리할 수 있음)
		return "none";
	}

}
