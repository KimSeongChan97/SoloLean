package admin.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import admin.bean.AdminPaging;
import admin.dao.AdminDAO;
import admin.service.AdminService;
import admin.service.ObjectStorageService;
import answer.bean.AnswerDTO;
import questions.bean.QuestionsDTO;
import room.bean.ReserveDTO;
import room.bean.RoomDTO;
import room.bean.RoomImgDTO;
import user.bean.UserDTO;

@Service  // Spring Service 클래스임을 나타냄. 비즈니스 로직을 처리
public class AdminServiceImpl implements AdminService {
    @Autowired  // AdminDAO 객체 자동 주입
    private AdminDAO adminDAO;
    
    @Autowired  // HttpSession 객체 자동 주입 (사용자 세션을 처리)
    private HttpSession session;
    
    @Autowired  // ObjectStorageService 객체 자동 주입 (파일 업로드/삭제 처리)
    private ObjectStorageService objectStorageService;
    
    private String bucketName = "springhotel";  // Object Storage에서 사용할 버킷 이름 (NCP 등 클라우드에서 사용)
    
    @Autowired  // AdminPaging 객체 자동 주입 (페이징 처리)
    private AdminPaging adminPaging;

    @Override
    public Map<String, Object> checkUser(String pg) {
        // 1페이지당 5개씩 보여주기 위한 처리
        int startNum = (Integer.parseInt(pg) - 1) * 5; // 시작 위치 (0부터 시작)
        int endNum = 5; // 한 페이지에 보여줄 개수
        
        // 페이지 범위 설정을 위한 Map 생성
        Map<String, Integer> map = new HashedMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        
        // DB에서 사용자 목록 조회
        List<UserDTO> list = adminDAO.checkUser(map);
        System.out.println("list = " + list);  // 조회된 사용자 목록 콘솔 출력
        
        // 페이징 처리
        int totalA = adminDAO.getTotalA(); // 총 사용자 수 조회
        
        // 페이징 설정
        adminPaging.setCurrentPage(Integer.parseInt(pg)); // 현재 페이지 설정
        adminPaging.setPageBlock(3);  // 한 블록에 보여줄 페이지 개수
        adminPaging.setPageSize(5);  // 한 페이지에 보여줄 항목 수
        adminPaging.setTotalA(totalA);  // 총 사용자 수 설정
        adminPaging.makePagingHTML();  // 페이징 HTML 생성
        
        // 결과를 담을 새로운 Map 생성
        Map<String, Object> map2 = new HashedMap<>();
        map2.put("list", list);  // 사용자 목록 저장
        map2.put("adminPaging", adminPaging);  // 페이징 정보 저장
        
        return map2;  // 사용자 목록과 페이징 정보를 반환
    }

    @Override
    public List<RoomDTO> getRoomList() {
        return adminDAO.getRoomListWithImages();  // 이미지가 포함된 객실 목록을 조회
    }

    @Override
    public RoomDTO getRoomDTO(int roomId) {
        return adminDAO.getRoomDTO(roomId);  // 객실 ID로 특정 객실 정보 조회
    }

    @Override
    public void update(RoomDTO roomDTO, MultipartFile img) {
        String filePath = session.getServletContext().getRealPath("WEB-INF/storage");  // 실제 저장할 파일 경로
        System.out.println("실제 폴더 = " + filePath);  // 저장될 경로를 콘솔에 출력
        
        // 기존 객실 이미지 정보 조회
        RoomImgDTO roomImgDTO = adminDAO.getRoomImgDTO(roomDTO.getRoomId() + "");
        
        String imageFileName;
        String imageOriginalFileName;
        
        // 업로드된 이미지 파일이 있을 경우
        if (img.getSize() != 0) {
            // Object Storage(NCP)에서 기존 이미지 삭제
            objectStorageService.deleteFile(bucketName, "storage/", roomImgDTO.getImageFileName());
            
            // Object Storage(NCP)에 새 이미지 업로드
            imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);  
            imageOriginalFileName = img.getOriginalFilename();
            
            System.out.println("imageFileName = " + imageFileName);  // 업로드된 이미지 파일 이름 출력
            System.out.println("imageOriginalFileName = " + imageOriginalFileName);  // 원본 이미지 파일 이름 출력
            
            // 서버에 파일 저장
            File file = new File(filePath, imageOriginalFileName);  // 파일 경로와 파일 이름으로 File 객체 생성
            
            try {
                img.transferTo(file);  // 실제 파일을 해당 경로에 저장
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();  // 예외 발생 시 출력
            }
        } else {
            // 이미지가 변경되지 않았을 경우 기존 파일명 사용
            imageFileName = roomImgDTO.getImageFileName();
            imageOriginalFileName = roomImgDTO.getImageOriginalFileName();
        }
        
        // 객실 정보 업데이트
        adminDAO.updateRoom(roomDTO);
        
        // 객실 이미지 정보 업데이트
        roomImgDTO.setImageFileName(imageFileName);
        roomImgDTO.setImageOriginalFileName(imageOriginalFileName);
        adminDAO.updateRoomImg(roomImgDTO);
    }

    @Override
    public Map<String, Object> checkReserve(String pg) {
        // 1페이지당 5개씩 예약 정보를 조회
        int startNum = (Integer.parseInt(pg) - 1) * 5; // 시작 위치
        int endNum = 5; // 한 페이지에 보여줄 예약 수
        
        // 페이지 범위 설정을 위한 Map 생성
        Map<String, Integer> map = new HashedMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        
        // DB에서 예약 목록 조회
        List<ReserveDTO> list = adminDAO.checkReserve(map);
        
        // 페이징 처리
        int totalA = adminDAO.getTotalB(); // 총 예약 수 조회
        
        // 페이징 설정
        adminPaging.setCurrentPage(Integer.parseInt(pg));  // 현재 페이지 설정
        adminPaging.setPageBlock(3);  // 페이지 블록 설정
        adminPaging.setPageSize(5);  // 페이지 크기 설정
        adminPaging.setTotalA(totalA);  // 총 예약 수 설정
        adminPaging.makePagingHTML();  // 페이징 HTML 생성
        
        // 결과를 담을 Map 생성
        Map<String, Object> map2 = new HashedMap<>();
        map2.put("list", list);  // 예약 목록 저장
        map2.put("adminPaging", adminPaging);  // 페이징 정보 저장
        
        return map2;  // 예약 목록과 페이징 정보를 반환
    }

    @Override
    public Map<String, Object> inquiryList(String pg) {
        // 1페이지당 5개의 문의를 조회
        int startNum = (Integer.parseInt(pg) - 1) * 5; // 시작 위치
        int endNum = 5; // 한 페이지에 보여줄 문의 수
        
        // 페이지 범위 설정을 위한 Map 생성
        Map<String, Integer> map = new HashedMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        
        // DB에서 문의 목록 조회
        List<QuestionsDTO> list = adminDAO.inquiryList(map);
        
        // 페이징 처리
        int totalA = adminDAO.getTotalC(); // 총 문의 수 조회
        
        // 페이징 설정
        adminPaging.setCurrentPage(Integer.parseInt(pg));  // 현재 페이지 설정
        adminPaging.setPageBlock(3);  // 페이지 블록 설정
        adminPaging.setPageSize(5);  // 페이지 크기 설정
        adminPaging.setTotalA(totalA);  // 총 문의 수 설정
        adminPaging.makePagingHTML();  // 페이징 HTML 생성
        
        // 결과를 담을 Map 생성
        Map<String, Object> map2 = new HashedMap<>();
        map2.put("list", list);  // 문의 목록 저장
        map2.put("adminPaging", adminPaging);  // 페이징 정보 저장
        
        return map2;  // 문의 목록과 페이징 정보를 반환
    }
    
    @Override
    public QuestionsDTO getQuestionsDTO(String questionsId) {
        System.out.println("questionsId = " + questionsId);  // 문의 ID 출력
        System.out.println(adminDAO.getQuestionsDTO(questionsId));  // 조회된 문의 정보 출력
        return adminDAO.getQuestionsDTO(questionsId);  // 문의 ID로 문의 정보 조회
    }

    @Override
    public void writeComment(AnswerDTO answerDTO) {
        adminDAO.writeComment(answerDTO);  // 댓글 작성
    }

    @Override
    public boolean adminCheck(String adminId, String pwd) {
        Map<String, String> map = new HashedMap<String, String>();
        map.put("adminId", adminId);  // 관리자 ID 저장
        map.put("pwd", pwd);  // 비밀번호 저장
        int result = adminDAO.adminCheck(map);  // 관리자 로그인 여부 확인
        return result > 0;  // 로그인 성공 여부 반환
    }

    @Override
    public void updateComment(int answerId, String comment) {
        Map<String, Object> map = new HashedMap<String, Object>();
        map.put("answerId", answerId);  // 댓글 ID 저장
        map.put("comment", comment);  // 새로운 댓글 내용 저장
        
        adminDAO.updateComment(map);  // 댓글 수정
    }

    @Override
    public void deleteComment(int answerId) {
        adminDAO.deleteComment(answerId);  // 댓글 삭제
    }

    @Override
    public List<AnswerDTO> getCommentsByQuestionId(int questionsId) {
        return adminDAO.getCommentsByQuestionId(questionsId);  // 문의 ID로 댓글 목록 조회
    }

    @Override
    public void saveQuestion(QuestionsDTO questionsDTO) {
        adminDAO.saveQuestion(questionsDTO);  // 문의 저장
    }

    @Override
    public void updateInquiry(int questionsId, int typename, String content) {
        Map<String, Object> map = new HashedMap<String, Object>();
        map.put("questionsId", questionsId);  // 문의 ID 저장
        map.put("typename", typename);  // 타입명 저장
        map.put("content", content);  // 문의 내용 저장
        System.out.println("questionsId2 = " + questionsId);  // 문의 ID 출력
        System.out.println("typename2 = " + typename);  // 타입명 출력
        System.out.println("content2 = " + content);  // 내용 출력
        adminDAO.updateInquiry(map);  // 문의 수정
    }

    @Override
    public void deleteQuestions(int questionsId) {
        adminDAO.deleteQuestions(questionsId);  // 문의 삭제
    }

    @Override
    public int getUserIdByUserName(String userName) {
        int userId = adminDAO.getUserIdByUserName(userName);  // 사용자 이름으로 사용자 ID 조회
        return userId;  // 사용자 ID 반환
    }
}
