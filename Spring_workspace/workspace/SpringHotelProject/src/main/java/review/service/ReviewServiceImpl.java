package review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import java.util.List;

@Service  // 이 클래스는 Spring의 서비스 계층을 나타내며, 비즈니스 로직을 처리
public class ReviewServiceImpl implements ReviewService {

    @Autowired  // ReviewDAO 객체를 자동으로 주입. 데이터베이스와 상호작용하는 역할
    private ReviewDAO reviewDAO;

    @Override
    public void insertReview(ReviewDTO review) throws Exception {
        // 리뷰 삽입: ReviewDTO 객체를 받아 데이터베이스에 리뷰를 저장
        reviewDAO.insertReview(review);  // DAO 메서드를 호출하여 리뷰를 삽입
    }

    @Override
    public List<ReviewDTO> getAllReviews() throws Exception {
        // 모든 리뷰 조회: 데이터베이스에 저장된 모든 리뷰를 가져옴
        return reviewDAO.getAllReviews();  // DAO 메서드를 호출하여 모든 리뷰 목록을 반환
    }

    @Override
    public void updateReview(ReviewDTO review) throws Exception {
        // 리뷰 업데이트: ReviewDTO 객체에 담긴 정보로 기존 리뷰를 수정
        reviewDAO.updateReview(review);  // DAO 메서드를 호출하여 리뷰를 업데이트
    }

    @Override
    public void deleteReview(int reviewId) throws Exception {
        // 리뷰 삭제: reviewId에 해당하는 리뷰를 데이터베이스에서 삭제
        reviewDAO.deleteReview(reviewId);  // DAO 메서드를 호출하여 리뷰를 삭제
    }

    @Override
    public ReviewDTO getReviewById(Integer reviewId) {
        // 리뷰 ID로 특정 리뷰 조회: reviewId에 해당하는 리뷰를 조회하여 반환
        return reviewDAO.getReviewById(reviewId);  // DAO 메서드를 호출하여 특정 리뷰를 반환
    }
    
    @Override
    public List<ReviewDTO> reviewListByRoom(int roomId) {
        // 특정 객실(roomId)에 대한 리뷰 목록 조회: roomId에 해당하는 리뷰 목록을 반환
        return reviewDAO.reviewListByRoom(roomId);  // DAO 메서드를 호출하여 특정 객실의 리뷰 목록을 반환
    }
    
    @Override
    public void addReview(ReviewDTO reviewDTO) {
        // 리뷰 추가: TODO로 표시된 부분은 아직 구현되지 않음. 리뷰 추가 로직을 여기에 작성해야 함
        // 향후 구현될 리뷰 추가 로직이 여기에 들어가야 함
    }
}
