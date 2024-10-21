package admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import answer.bean.AnswerDTO;
import questions.bean.QuestionsDTO;
import room.bean.RoomDTO;

public interface AdminService {

    // 사용자 목록을 페이지 단위로 조회
    public Map<String, Object> checkUser(String pg);  
    // pg는 현재 페이지 번호를 나타내며, 반환되는 Map에는 사용자 목록과 페이지 정보가 포함됨

    // 객실 목록 조회
    public List<RoomDTO> getRoomList();  
    // 객실 정보를 담은 RoomDTO의 리스트를 반환함. 모든 객실의 정보를 조회할 때 사용

    // 특정 객실 정보 조회
    public RoomDTO getRoomDTO(int roomId);  
    // 주어진 roomId에 해당하는 객실 정보를 RoomDTO 객체로 반환

    // 객실 정보 및 이미지를 업데이트
    public void update(RoomDTO roomDTO, MultipartFile img);  
    // roomDTO는 업데이트할 객실 정보를 담고 있고, img는 해당 객실의 이미지를 담은 MultipartFile 객체임

    // 예약 목록을 페이지 단위로 조회
    public Map<String, Object> checkReserve(String pg);  
    // pg는 현재 페이지 번호를 나타내며, 반환되는 Map에는 예약 목록과 페이지 정보가 포함됨

    // 문의 목록을 페이지 단위로 조회
    public Map<String, Object> inquiryList(String pg);  
    // pg는 현재 페이지 번호를 나타내며, 반환되는 Map에는 문의 목록과 페이지 정보가 포함됨

    // 특정 문의 정보 조회
    public QuestionsDTO getQuestionsDTO(String questionsId);  
    // questionsId에 해당하는 문의 정보를 QuestionsDTO 객체로 반환

    // 댓글 작성
    public void writeComment(AnswerDTO answerDTO);  
    // AnswerDTO 객체를 사용하여 특정 문의에 대한 댓글을 작성

    // 관리자 로그인 확인
    public boolean adminCheck(String adminId, String pwd);  
    // adminId와 pwd를 사용하여 관리자인지 여부를 확인하고, 로그인 가능 여부를 boolean으로 반환

    // 댓글 업데이트
    public void updateComment(int answerId, String comment);  
    // 댓글 ID와 새 댓글 내용을 받아 댓글을 수정

    // 댓글 삭제
    public void deleteComment(int answerId);  
    // 댓글 ID를 받아 해당 댓글을 삭제

    // 특정 문의에 달린 댓글 목록 조회
    public List<AnswerDTO> getCommentsByQuestionId(int parseInt);  
    // 주어진 문의 ID에 해당하는 댓글 목록을 List로 반환

    // 문의 저장
    public void saveQuestion(QuestionsDTO questionsDTO);  
    // 새로운 문의를 QuestionsDTO 객체로 받아 데이터베이스에 저장

    // 문의 업데이트
    public void updateInquiry(int questionsId, int typename, String content);  
    // 주어진 문의 ID, 새로운 타입명(typename), 내용(content)으로 문의 정보를 업데이트

    // 문의 삭제
    public void deleteQuestions(int questionsId);  
    // 주어진 문의 ID에 해당하는 문의를 삭제

    // 사용자 이름으로 사용자 ID 조회
    public int getUserIdByUserName(String userName);  
    // 사용자 이름을 받아 해당 사용자의 ID(Seq)를 반환

}
