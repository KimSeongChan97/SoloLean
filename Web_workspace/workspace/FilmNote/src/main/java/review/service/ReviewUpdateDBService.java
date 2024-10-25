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
		// 리뷰와 영화 정보를 관리하는 DAO 인스턴스 가져오기
		ReviewDAO reviewDAO = ReviewDAO.getInstance(); // 리뷰 데이터베이스 작업을 처리하는 DAO
		MovieDAO movieDAO = MovieDAO.getInstance(); // 영화 데이터베이스 작업을 처리하는 DAO
		
		// 클라이언트에서 전달된 리뷰 코드(rcode), 영화 코드(mcode), 사용자별점(score) 등의 데이터를 요청에서 추출
		int mcode = Integer.parseInt(request.getParameter("movie_code")); // 영화 코드
		int rcode = Integer.parseInt(request.getParameter("rcode")); // 리뷰 코드
		int userMScore = Integer.parseInt(request.getParameter("score")); // 사용자 수정 별점
		
		// 수정할 리뷰 정보를 DTO 객체에 담아 생성
		ReviewDTO reviewDTO = new ReviewDTO(
												rcode,  // 리뷰 코드
												mcode,  // 영화 코드
												request.getParameter("user_id"),  // 작성자 아이디
												request.getParameter("content"),  // 수정된 리뷰 내용
												null,  // 수정 시간 (null 처리, 수정 시점에서 자동 처리 가능)
												userMScore  // 수정된 별점
											);
		
		// 리뷰 정보 출력 (디버깅용)
		System.out.println(reviewDTO.toString());
		System.out.println();
		
		// 1. 리뷰 수정
		// ReviewDAO의 메서드를 사용해 데이터베이스에서 해당 리뷰 정보를 수정
		reviewDAO.updateReviewDTO(reviewDTO);
		
		// 2. 영화 별점 계산
		// 리뷰가 수정된 후, 영화의 전체 리뷰를 다시 계산하여 영화의 평균 별점을 업데이트
		movieDAO.updateMovieScore(mcode);

		// 이 서비스는 별도의 페이지 전환이 필요 없기 때문에 "none"을 반환 (AJAX 응답으로 처리할 수 있음)
		return "none";
	}

}
