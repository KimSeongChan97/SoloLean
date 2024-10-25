package review.dao;

import review.bean.ReviewDTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper  // MyBatis에서 이 인터페이스가 SQL 매핑 파일과 연동되어 SQL 쿼리를 실행할 수 있음을 나타냄
public interface ReviewDAO {

    // 리뷰 삽입 메서드
    public void insertReview(ReviewDTO review) throws Exception;  
    // ReviewDTO 객체를 받아 해당 리뷰를 데이터베이스에 삽입함
    // Exception을 던지는 이유는 데이터베이스 연결 문제나 SQL 오류가 발생할 수 있기 때문

    // 모든 리뷰를 가져오는 메서드
    public List<ReviewDTO> getAllReviews() throws Exception;  
    // 데이터베이스에 저장된 모든 리뷰를 List로 반환함. 각 항목은 ReviewDTO 객체
    // Exception을 던져서 SQL 실행 중 예외 처리 가능

    // 리뷰 업데이트 메서드
    public void updateReview(ReviewDTO review) throws Exception;  
    // ReviewDTO 객체에 담긴 데이터를 이용해 데이터베이스에서 해당 리뷰를 수정함
    // 예외 처리가 필요할 수 있음 (SQL 오류 등)

    // 리뷰 삭제 메서드
    public void deleteReview(int reviewId) throws Exception;  
    // 리뷰 ID(reviewId)를 받아 해당 ID의 리뷰를 데이터베이스에서 삭제
    // 예외 처리가 필요할 수 있음 (SQL 오류 등)

    // 리뷰 ID로 특정 리뷰를 가져오는 메서드
    public ReviewDTO getReviewById(Integer reviewId);  
    // reviewId를 이용해 특정 리뷰를 조회하고, ReviewDTO 객체로 반환
    // 리뷰가 존재하지 않으면 null 반환 가능

    // 특정 객실(roomId)에 대한 리뷰 목록을 가져오는 메서드
	public List<ReviewDTO> reviewListByRoom(int roomId);  
    // roomId에 해당하는 리뷰 목록을 조회하고, List로 반환함. 각 항목은 ReviewDTO 객체로 저장
}

