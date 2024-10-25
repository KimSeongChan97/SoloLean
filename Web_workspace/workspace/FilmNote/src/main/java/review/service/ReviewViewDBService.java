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
		// 리뷰 데이터베이스 작업을 처리하는 DAO 인스턴스 생성
		ReviewDAO reviewDAO = ReviewDAO.getInstance(); 
		// 영화 데이터베이스 작업을 처리하는 DAO 인스턴스 생성
		MovieDAO movieDAO = MovieDAO.getInstance();
		
		// 1. Data 받기
		// 클라이언트에서 전달된 영화 코드와 사용자 점수를 요청으로부터 가져옴
		int mcode = Integer.parseInt(request.getParameter("movie_code")); // 영화 코드
		int userMScore = Integer.parseInt(request.getParameter("score")); // 사용자 별점

		// 새로운 리뷰 정보를 DTO 객체로 생성
		ReviewDTO reviewDTO = new ReviewDTO(
												0, // 리뷰 코드는 자동으로 증가되므로 0으로 설정
												mcode, // 영화 코드
												request.getParameter("user_id"), // 작성자 아이디
												request.getParameter("content"), // 리뷰 내용
												null, // 작성 시간 (null 처리)
												userMScore // 사용자 별점
											);
		
		// 디버깅용으로 생성된 리뷰 정보 출력
		System.out.println(reviewDTO.toString());
		
		// 2. 리뷰 추가
		// ReviewDAO의 insertReviewDTO 메서드를 호출하여 데이터베이스에 새로운 리뷰 추가
		reviewDAO.insertReviewDTO(reviewDTO);
		
		// 3. 영화 별점 갱신
		// 리뷰가 추가되었으므로 해당 영화의 별점을 다시 계산하고 갱신
		movieDAO.updateMovieScore(mcode);
		
		// 페이지 이동이 필요 없기 때문에 "none"을 반환 (AJAX 응답 처리에 사용)
		return "none";
	}

}

