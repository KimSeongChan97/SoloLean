package review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDAO reviewDAO;

    @Override
    public void insertReview(ReviewDTO review) throws Exception {
        reviewDAO.insertReview(review);
    }

    @Override
    public List<ReviewDTO> getAllReviews() throws Exception {
        return reviewDAO.getAllReviews();
    }

    @Override
    public void updateReview(ReviewDTO review) throws Exception {
        reviewDAO.updateReview(review);
    }

    @Override
    public void deleteReview(int reviewId) throws Exception {
        reviewDAO.deleteReview(reviewId);
    }

    @Override
    public ReviewDTO getReviewById(Integer reviewId) {
        return reviewDAO.getReviewById(reviewId);
    }
    
    @Override
    public List<ReviewDTO> reviewListByRoom(int roomId) {
    	
    	return reviewDAO.reviewListByRoom(roomId);
    }
}
