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

@Controller  // 이 클래스는 Spring MVC에서 컨트롤러로 사용됨을 나타냄
@RequestMapping("/review")  // "/review" 경로로 들어오는 요청을 이 컨트롤러에서 처리
public class ReviewController {

    @Autowired  // Spring이 자동으로 ReviewService 객체를 주입 (DI: 의존성 주입)
    private ReviewService reviewService;

    // 특정 roomId에 맞는 리뷰 목록을 반환하는 메서드
    @RequestMapping(value="/reviewList", method = RequestMethod.POST)
    public ResponseEntity<List<ReviewDTO>> reviewList(@RequestParam("roomId") int roomId) {
        // reviewService를 통해 roomId에 해당하는 리뷰 목록을 조회
        List<ReviewDTO> reviews = reviewService.reviewListByRoom(roomId);
        return ResponseEntity.ok(reviews);  // 리뷰 목록을 HTTP 응답으로 JSON 형태로 반환
    }

    // 리뷰 작성 또는 수정 메서드
    @RequestMapping(value = "/insertReview", method = RequestMethod.POST)
    public ResponseEntity<String> insertOrUpdateReview(@ModelAttribute ReviewDTO reviewDTO, HttpSession session) {
        // HttpSession에서 로그인한 사용자의 userSeq와 userName 정보를 가져옴
        Integer userSeq = (Integer) session.getAttribute("userSeq");
        String userName = (String) session.getAttribute("userName");

        // 디버깅을 위한 로그 추가
        System.out.println("userSeq: " + userSeq);  // 사용자 ID 출력
        System.out.println("userName: " + userName);  // 사용자 이름 출력

        // 로그인하지 않은 경우 처리
        if (userSeq == null || userName == null) {
            reviewDTO.setUserId(null);  // 익명 사용자는 userId를 null로 설정
            reviewDTO.setUserName("익명의 사용자");  // 익명 사용자 처리
        } else {
            // 로그인한 경우, 세션의 정보를 ReviewDTO에 저장
            reviewDTO.setUserId(userSeq);  // 세션에서 가져온 userSeq를 ReviewDTO에 설정
            reviewDTO.setUserName(userName);  // 세션에서 가져온 userName을 ReviewDTO에 설정
        }

        try {
            // 리뷰 ID가 0이 아니면 이미 존재하는 리뷰이므로 업데이트 처리
            if (reviewDTO.getReviewId() != 0) {
                reviewService.updateReview(reviewDTO);  // 기존 리뷰 업데이트
            } else {
                // 새로운 리뷰인 경우 삽입
                reviewService.insertReview(reviewDTO);  // 새로운 리뷰 저장
            }
            return ResponseEntity.ok("success");  // 성공 시 "success" 반환
        } catch (Exception e) {
            // 예외 발생 시 에러 메시지와 500 응답 반환
            e.printStackTrace();
            return ResponseEntity.status(500).body("error");
        }
    }
    
    // 리뷰 삭제 메서드
    @RequestMapping(value="/deleteReview", method=RequestMethod.POST)
    public ResponseEntity<String> deleteReview(@RequestParam("reviewId") int reviewId) {
        try {
            // reviewId를 이용해 해당 리뷰 삭제
            reviewService.deleteReview(reviewId);
            return ResponseEntity.ok("success");  // 삭제 성공 시 "success" 반환
        } catch (Exception e) {
            // 예외 발생 시 에러 메시지와 500 응답 반환
            e.printStackTrace();
            return ResponseEntity.status(500).body("error");
        }
    }
}
