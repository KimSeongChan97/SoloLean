package review.service;

import review.bean.ReviewDTO;
import java.util.List;

public interface ReviewService {

    // 리뷰 삽입 메서드
    public void insertReview(ReviewDTO review) throws Exception;
    // ReviewDTO 객체를 받아 해당 리뷰를 데이터베이스에 삽입
    // 예외가 발생할 수 있으므로 Exception 처리 필요

    // 모든 리뷰를 가져오는 메서드
    public List<ReviewDTO> getAllReviews() throws Exception;
    // 데이터베이스에 있는 모든 리뷰를 조회하여 List로 반환
    // 각 항목은 ReviewDTO 객체로 저장됨
    // Exception 처리 필요 (SQL 오류 등)

    // 리뷰 업데이트 메서드
    public void updateReview(ReviewDTO review) throws Exception;
    // 리뷰 수정: ReviewDTO 객체에 담긴 데이터를 사용해 해당 리뷰를 업데이트
    // 예외가 발생할 수 있으므로 Exception 처리 필요

    // 리뷰 삭제 메서드
    public void deleteReview(int reviewId) throws Exception;
    // 리뷰 삭제: reviewId에 해당하는 리뷰를 데이터베이스에서 삭제
    // 예외가 발생할 수 있으므로 Exception 처리 필요

    // 리뷰 ID로 특정 리뷰 조회
    public ReviewDTO getReviewById(Integer reviewId);
    // 리뷰 ID를 받아서 해당 리뷰를 조회하고, ReviewDTO 객체로 반환
    // 리뷰가 존재하지 않으면 null 반환 가능

    // 특정 객실(roomId)에 대한 리뷰 목록을 가져오는 메서드
    public List<ReviewDTO> reviewListByRoom(int roomId);
    // roomId에 해당하는 객실의 리뷰 목록을 조회하고, List로 반환
    // 각 항목은 ReviewDTO 객체로 저장됨

    // 리뷰 추가 메서드
    public void addReview(ReviewDTO reviewDTO);
    // ReviewDTO 객체를 받아 새로운 리뷰를 추가
}

