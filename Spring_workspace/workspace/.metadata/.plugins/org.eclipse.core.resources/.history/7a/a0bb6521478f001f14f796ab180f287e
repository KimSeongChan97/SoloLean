package review.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import review.bean.ReviewDTO;
import review.service.ReviewService;
import user.bean.UserDTO;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 특정 roomId에 맞는 리뷰 목록을 반환하는 메서드
    @RequestMapping(value="/reviewList", method = RequestMethod.POST)
    public ResponseEntity<List<ReviewDTO>> reviewList(@RequestParam("roomId") int roomId) {
        List<ReviewDTO> reviews = reviewService.reviewListByRoom(roomId);
        return ResponseEntity.ok(reviews);  // 리뷰 목록을 JSON으로 반환
    }

    // 리뷰 작성
    @RequestMapping(value = "/insertReview", method = RequestMethod.POST)
    public ResponseEntity<String> insertOrUpdateReview(@ModelAttribute ReviewDTO reviewDTO, HttpSession session) {
        // 세션에서 userSeq와 userName 가져오기
        Integer userSeq = (Integer) session.getAttribute("userSeq");
        String userName = (String) session.getAttribute("userName");

        // 디버깅을 위한 로그 추가
        System.out.println("userSeq: " + userSeq);
        System.out.println("userName: " + userName);

        // 로그인하지 않은 경우
        if (userSeq == null || userName == null) {
            reviewDTO.setUserId(null); // 익명 사용자로 처리
            reviewDTO.setUserName("익명의 사용자");
        } else {
            // 로그인한 경우 세션에서 가져온 정보를 이용해 리뷰에 저장
            reviewDTO.setUserId(userSeq); // 세션에서 가져온 userSeq를 ReviewDTO에 저장
            reviewDTO.setUserName(userName); // 세션에서 가져온 userName을 ReviewDTO에 저장
        }

        try {
            if (reviewDTO.getReviewId() != 0) {
                reviewService.updateReview(reviewDTO);
            } else {
                reviewService.insertReview(reviewDTO);
            }
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("error");
        }
    }
    
    // 리뷰 삭제
    @RequestMapping(value="/deleteReview", method=RequestMethod.POST)
    public ResponseEntity<String> deleteReview(@RequestParam("reviewId") int reviewId) {
        try {
            reviewService.deleteReview(reviewId);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("error");
        }
    }
}
