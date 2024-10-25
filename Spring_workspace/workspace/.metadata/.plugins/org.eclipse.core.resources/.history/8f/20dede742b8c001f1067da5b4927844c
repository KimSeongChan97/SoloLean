package review.dao;

import review.bean.ReviewDTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewDAO {
    public void insertReview(ReviewDTO review) throws Exception;
    public List<ReviewDTO> getAllReviews() throws Exception;
    public void updateReview(ReviewDTO review) throws Exception;  // 리뷰 업데이트
    public void deleteReview(int reviewId) throws Exception;      // 리뷰 삭제
	public ReviewDTO getReviewById(Integer reviewId);
    
}

