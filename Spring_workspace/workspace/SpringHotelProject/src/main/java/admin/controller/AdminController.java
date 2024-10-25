package admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import admin.service.AdminService;
import answer.bean.AnswerDTO;
import questions.bean.QuestionsDTO;
import room.bean.RoomDTO;

@Controller  // 이 클래스는 Spring MVC에서 컨트롤러로 사용됨. HTTP 요청을 처리하고 응답을 반환함
public class AdminController {
    
    @Autowired  // AdminService를 자동으로 주입받음 (DI: 의존성 주입)
    private AdminService adminService;

    @RequestMapping(value="admin/login")
    public String login() {
        // 관리자 로그인 페이지로 이동
        return "/admin/login";
    }

    @RequestMapping(value="admin/mypage")
    public String mypage() {
        // 관리자 마이페이지로 이동
        return "/mypage/mypage";
    }

    // 관리자 로그인 처리
    @RequestMapping(value = "admin/loginForm", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    @ResponseBody  // Ajax 요청에 대한 응답을 문자열로 반환
    public String adminLogin(@RequestParam String adminId, @RequestParam String pwd, HttpSession session, Model model) {
        // adminId와 pwd를 받아 관리자 인증
        boolean adminCheck = adminService.adminCheck(adminId, pwd);  // 관리자 로그인 여부 확인
        System.out.println("adminId = " + adminId);  // 관리자 ID 콘솔 출력
        System.out.println("pwd = " + pwd);  // 비밀번호 콘솔 출력
        System.out.println("adminCheck = " + adminCheck);  // 로그인 성공 여부 콘솔 출력
        if (adminCheck) {
            session.setAttribute("adminId", adminId);  // 세션에 adminId 저장 (로그인 유지)
            return "로그인에 성공하였습니다.";  // 성공 메시지 반환
        } else {
            return "아이디 또는 비밀번호가 틀렸습니다.";  // 실패 메시지 반환
        }
    }

    @RequestMapping(value="admin/updateRoom")
    public String updateRoom(Model model) {
        // 관리자가 방 목록을 조회하고 방 정보 업데이트를 위한 페이지로 이동
        List<RoomDTO> roomList = adminService.getRoomList();  // 방 목록 조회
        model.addAttribute("roomList", roomList);  // 모델에 방 목록 저장하여 뷰로 전달
        return "/admin/updateRoom";  // 방 업데이트 페이지로 이동
    }

    @RequestMapping(value="admin/updateRoomInfo", method = RequestMethod.GET)
    public String updateRoomInfo(@RequestParam String type, @RequestParam int roomId, Model model) {
        // 특정 방의 정보를 업데이트하기 위한 페이지
        RoomDTO roomDTO = adminService.getRoomDTO(roomId);  // 방 ID를 통해 방 정보 조회
        model.addAttribute("roomDTO", roomDTO);  // 방 정보 모델에 추가하여 뷰로 전달
        System.out.println(roomDTO);  // 조회된 방 정보 콘솔 출력
        return "/admin/updateRoomInfo";  // 방 정보 업데이트 페이지로 이동
    }

    @RequestMapping(value = "admin/update", produces = "text/html; charset=UTF-8")
    public String update(@ModelAttribute RoomDTO roomDTO, @RequestParam("img") MultipartFile img, Model model) {
        // 방 정보와 이미지를 받아서 업데이트 처리
        System.out.println("roomDTO = " + roomDTO);  // 방 정보 출력
        System.out.println("img = " + img);  // 이미지 파일 정보 출력
        
        adminService.update(roomDTO, img);  // 서비스에서 방 정보와 이미지 업데이트 처리
        
        List<RoomDTO> roomList = adminService.getRoomList();  // 업데이트 후 방 목록 다시 조회
        model.addAttribute("roomList", roomList);  // 모델에 방 목록 추가하여 뷰로 전달
        
        return "admin/updateRoom";  // 방 목록 페이지로 다시 이동
    }

    @RequestMapping(value="admin/checkReserve", method = RequestMethod.GET)
    public String checkReserve(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        // 예약 목록 조회 처리
        Map<String, Object> map2 = adminService.checkReserve(pg);  // 현재 페이지의 예약 목록 조회
        
        map2.put("pg", pg);  // 모델에 페이지 정보 저장
        model.addAttribute("map2", map2);  // 모델에 예약 정보 저장하여 뷰로 전달
        return "/admin/checkReserve";  // 예약 목록 페이지로 이동
    }

    @RequestMapping(value="admin/checkUser", method = RequestMethod.GET)
    public String checkUser(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        // 사용자 목록 조회 처리
        Map<String, Object> map2 = adminService.checkUser(pg);  // 현재 페이지의 사용자 목록 조회
        
        map2.put("pg", pg);  // 모델에 페이지 정보 저장
        model.addAttribute("map2", map2);  // 모델에 사용자 정보 저장하여 뷰로 전달
        
        System.out.println("map2 = " + map2);  // 사용자 정보 콘솔 출력
        return "/admin/checkUser";  // 사용자 목록 페이지로 이동
    }

    @RequestMapping(value="admin/inquiryList", method = RequestMethod.GET)
    public String inquiryList(@RequestParam(required = false, defaultValue = "1") String pg, HttpSession session, Model model) {
        // 문의 목록 조회 처리
        Map<String, Object> map2 = adminService.inquiryList(pg);  // 현재 페이지의 문의 목록 조회
        
        map2.put("pg", pg);  // 모델에 페이지 정보 저장
        model.addAttribute("map2", map2);  // 모델에 문의 정보 저장하여 뷰로 전달
        return "/admin/inquiryList";  // 문의 목록 페이지로 이동
    }
    
    @RequestMapping(value="admin/inquiryDetail", method = RequestMethod.GET)
    public String inquiryDetail(@RequestParam String questionsId, 
                                @RequestParam String typename, 
                                @RequestParam String userName, HttpSession session,Model model) {
        // 문의 상세 정보 조회 처리
        QuestionsDTO questionsDTO = adminService.getQuestionsDTO(questionsId);  // 문의 ID로 문의 정보 조회
        String adminId = (String) session.getAttribute("adminId");  // 세션에서 adminId 가져오기
        String userSeq = (String) session.getAttribute("userSeq");  // 세션에서 userSeq 가져오기
        
        // 댓글 목록 조회
        List<AnswerDTO> comments = adminService.getCommentsByQuestionId(Integer.parseInt(questionsId));  // 문의에 대한 댓글 목록 조회
        
        model.addAttribute("questionsDTO", questionsDTO);  // 문의 정보 모델에 추가
        model.addAttribute("typename", typename);  // 타입명 모델에 추가
        model.addAttribute("userName", userName);  // 사용자명 모델에 추가
        model.addAttribute("comments", comments);  // 댓글 목록 모델에 추가
        model.addAttribute("adminId", adminId);  // 관리자 ID 모델에 추가
        model.addAttribute("userSeq", userSeq);  // 사용자 Seq 모델에 추가
        
        System.out.println("comments = " + comments);  // 댓글 목록 콘솔 출력
        System.out.println(questionsDTO);  // 문의 정보 콘솔 출력
        return "/admin/inquiryDetail";  // 문의 상세 페이지로 이동
    }

    @RequestMapping(value="admin/inquiryDetail2", method = RequestMethod.GET)
    public String inquiryDetail2(@RequestParam String questionsId, 
                                 @RequestParam String seq, 
                                 @RequestParam String typename, 
                                 @RequestParam String userName, HttpSession session,Model model) {
        // 문의 상세 정보 조회 처리 (변경된 방식)
        QuestionsDTO questionsDTO = adminService.getQuestionsDTO(questionsId);  // 문의 ID로 문의 정보 조회
        Integer userSeq = (Integer) session.getAttribute("userSeq");  // 세션에서 userSeq 가져오기
        System.out.println("userSeq = " + userSeq);  // 사용자 Seq 콘솔 출력
        System.out.println("seq = " + seq);  // seq 콘솔 출력
        
        // 댓글 목록 조회
        List<AnswerDTO> comments = adminService.getCommentsByQuestionId(Integer.parseInt(questionsId));  // 문의에 대한 댓글 목록 조회
        
        model.addAttribute("questionsDTO", questionsDTO);  // 문의 정보 모델에 추가
        model.addAttribute("typename", typename);  // 타입명 모델에 추가
        model.addAttribute("userName", userName);  // 사용자명 모델에 추가
        model.addAttribute("comments", comments);  // 댓글 목록 모델에 추가
        model.addAttribute("seq", seq);  // seq 모델에 추가
        model.addAttribute("userSeq", userSeq);  // 사용자 Seq 모델에 추가
        
        System.out.println("comments = " + comments);  // 댓글 목록 콘솔 출력
        System.out.println(questionsDTO);  // 문의 정보 콘솔 출력
        return "/inquiry/inquiryDetail";  // 문의 상세 페이지로 이동
    }

    @RequestMapping(value = "admin/writeComment", method = RequestMethod.POST)
    @ResponseBody
    public String writeComment(@RequestParam int questionsId, 
                               @RequestParam String userName, 
                               @RequestParam String comment, HttpSession session) {
        // 댓글 작성 처리
        String adminId = (String) session.getAttribute("adminId");  // 세션에서 adminId 가져오기
        
        System.out.println("questionsId = " + questionsId);  // 문의 ID 콘솔 출력
        System.out.println("comment = " + comment);  // 댓글 내용 콘솔 출력
        System.out.println("adminId = " + adminId);  // 관리자 ID 콘솔 출력

        int userSeq = adminService.getUserIdByUserName(userName);  // 사용자 이름으로 사용자 ID 조회
        System.out.println("userSeq = " + userSeq);  // 사용자 Seq 콘솔 출력
        
        AnswerDTO answerDTO = new AnswerDTO();  // 댓글 정보 객체 생성
        answerDTO.setQuestionsId(questionsId);  // 댓글이 달릴 문의 ID 설정
        answerDTO.setUserId(userSeq);  // 댓글 작성자 ID 설정
        answerDTO.setComment(comment);  // 댓글 내용 설정
        answerDTO.setAdminId(adminId);  // 관리자 ID 설정

        try {
            adminService.writeComment(answerDTO);  // 댓글 작성 서비스 호출
            return "success";  // 성공 시 "success" 반환
        } catch (Exception e) {
            e.printStackTrace();  // 오류 발생 시 스택 트레이스 출력
            return "fail";  // 실패 시 "fail" 반환
        }
    }

    @RequestMapping(value="admin/updateComment", method = RequestMethod.POST)
    @ResponseBody
    public String updateComment(@RequestParam int answerId, @RequestParam String comment) {
        // 댓글 업데이트 처리
        try {
            adminService.updateComment(answerId, comment);  // 댓글 수정 서비스 호출
            return "success";  // 성공 시 "success" 반환
        } catch (Exception e) {
            e.printStackTrace();  // 오류 발생 시 스택 트레이스 출력
            return "fail";  // 실패 시 "fail" 반환
        }
    }

    @RequestMapping(value="admin/deleteComment", method = RequestMethod.GET)
    @ResponseBody
    public String deleteComment(@RequestParam int answerId) {
        // 댓글 삭제 처리
        try {
            adminService.deleteComment(answerId);  // 댓글 삭제 서비스 호출
            return "success";  // 성공 시 "success" 반환
        } catch (Exception e) {
            e.printStackTrace();  // 오류 발생 시 스택 트레이스 출력
            return "fail";  // 실패 시 "fail" 반환
        }
    }
    
    //------------------------------------------------------------------------------
    @RequestMapping(value="admin/inquiryWrite", method = RequestMethod.GET)
    public String inquiryWrite() {
        // 문의 작성 페이지로 이동
        return "/inquiry/inquiryWrite";
    }

    @PostMapping("/questions/save")
    @ResponseBody
    public String saveQuestion(@RequestParam("qtypesId") int qtypesId,
                               @RequestParam("content") String content,
                               HttpSession session) {
        // 문의 저장 처리
        String userName = (String) session.getAttribute("userName");  // 세션에서 사용자 이름 가져오기
        int userSeq = adminService.getUserIdByUserName(userName);  // 사용자 이름으로 사용자 Seq 조회

        QuestionsDTO questionsDTO = new QuestionsDTO();  // 문의 정보 객체 생성
        questionsDTO.setUserId(userSeq);  // 문의 작성자 ID 설정
        questionsDTO.setContent(content);  // 문의 내용 설정
        questionsDTO.setQtypesId(qtypesId);  // 문의 타입 설정

        adminService.saveQuestion(questionsDTO);  // 문의 저장 서비스 호출

        return "success";  // 성공 시 "success" 반환
    }

    @RequestMapping(value="admin/inquiryUpdate", method = RequestMethod.GET)
    public String inquiryUpdate(@RequestParam("typename") String typename,
                                @RequestParam("content") String content,
                                @RequestParam("questionsId") String questionsId,
                                Model model) {
        // 문의 수정 페이지로 이동
        System.out.println("typename = " + typename);  // 타입명 콘솔 출력
        System.out.println("content = " + content);  // 문의 내용 콘솔 출력
        System.out.println("questionsId = " + questionsId);  // 문의 ID 콘솔 출력
        model.addAttribute("typename", typename);  // 모델에 타입명 추가
        model.addAttribute("content", content);  // 모델에 문의 내용 추가
        model.addAttribute("questionsId", questionsId);  // 모델에 문의 ID 추가
        return "/inquiry/inquiryUpdate";  // 문의 수정 페이지로 이동
    }

    @RequestMapping(value="admin/inquiryList2", method = RequestMethod.GET)
    public String inquiryList2(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
        // 문의 목록 조회 처리 (변경된 방식)
        Map<String, Object> map2 = adminService.inquiryList(pg);  // 문의 목록 조회
        
        map2.put("pg", pg);  // 모델에 페이지 정보 저장
        model.addAttribute("map2", map2);  // 모델에 문의 정보 저장하여 뷰로 전달
        return "/inquiry/inquiryList";  // 문의 목록 페이지로 이동
    }

    @RequestMapping(value = "inquiry/update", method = RequestMethod.POST)
    @ResponseBody  // Ajax 요청에 대해 문자열로 응답
    public String updateInquiry(@RequestParam("typename") int typename,
                                @RequestParam("questionsId") int questionsId,
                                @RequestParam("content") String content) {
        // 문의 업데이트 처리
        System.out.println("typename = " + typename);  // 타입명 콘솔 출력
        System.out.println("questionsId = " + questionsId);  // 문의 ID 콘솔 출력
        System.out.println("content = " + content);  // 문의 내용 콘솔 출력
        
        adminService.updateInquiry(questionsId, typename, content);  // 문의 수정 서비스 호출

        return "success";  // 성공적으로 업데이트된 후 "success" 반환
    }

    @RequestMapping(value = "inquiry/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteInquiry(@RequestParam("questionsId") int questionsId) {
        // 문의 삭제 처리
        try {
            adminService.deleteQuestions(questionsId);  // 문의 삭제 서비스 호출
            return "success";  // 성공 시 "success" 반환
        } catch (Exception e) {
            e.printStackTrace();  // 오류 발생 시 스택 트레이스 출력
            return "fail";  // 실패 시 "fail" 반환
        }
    }

}
