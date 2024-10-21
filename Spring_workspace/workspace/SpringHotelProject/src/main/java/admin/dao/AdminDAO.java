package admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import answer.bean.AnswerDTO;
import questions.bean.QuestionsDTO;
import room.bean.ReserveDTO;
import room.bean.RoomDTO;
import room.bean.RoomImgDTO;
import user.bean.UserDTO;

@Mapper  // MyBatis 매퍼 인터페이스임을 표시 (SQL 매핑 처리)
public interface AdminDAO {

    // 사용자 목록 조회
	public List<UserDTO> checkUser(Map<String, Integer> map);  
    // Map에 담긴 파라미터를 이용해 특정 페이지의 사용자 목록을 조회함

    // 전체 사용자 수 조회
	public int getTotalA();  
    // 전체 사용자 수를 반환하는 메서드로, 페이지네이션을 위해 사용됨

    // 모든 객실 정보 조회
	public List<RoomDTO> getRoomList();  
    // 모든 객실의 목록을 반환하는 메서드로, 객실 관리 페이지에서 사용됨

    // 특정 객실 정보 조회
	public RoomDTO getRoomDTO(int roomId);  
    // 객실 ID를 이용하여 해당 객실의 상세 정보를 반환하는 메서드

    // 객실 정보 업데이트
    public void updateRoom(RoomDTO roomDTO);  
    // RoomDTO 객체를 이용하여 특정 객실의 정보를 업데이트

    // 객실 이미지 정보 업데이트
    public void updateRoomImg(RoomImgDTO roomImgDTO);  
    // RoomImgDTO 객체를 이용하여 특정 객실의 이미지 정보를 업데이트

    // 특정 객실의 이미지 정보 조회
	public RoomImgDTO getRoomImgDTO(String roomId);  
    // 객실 ID를 이용하여 해당 객실의 이미지 정보를 반환

    // 이미지와 함께 객실 정보 조회
	public List<RoomDTO> getRoomListWithImages();  
    // 객실 정보와 각 객실의 이미지 정보를 함께 조회하는 메서드

    // 예약 정보 조회
	public List<ReserveDTO> checkReserve(Map<String, Integer> map);  
    // 특정 페이지의 예약 정보를 조회

    // 총 예약 수 조회
	public int getTotalB();  
    // 전체 예약 수를 반환하는 메서드로, 예약 페이지네이션을 위해 사용됨

    // 문의 총 개수 조회
	public int getTotalC();  
    // 전체 문의 수를 반환하는 메서드로, 문의 목록 페이지네이션에 사용됨

    // 문의 목록 조회
	public List<QuestionsDTO> inquiryList(Map<String, Integer> map);  
    // 특정 페이지의 문의 목록을 조회하는 메서드

    // 특정 문의 조회
	public QuestionsDTO getQuestionsDTO(String questionsId);  
    // 문의 ID를 이용해 해당 문의의 상세 정보를 반환

    // 댓글 작성
	public void writeComment(AnswerDTO answerDTO);  
    // AnswerDTO 객체를 통해 특정 문의에 대한 댓글을 작성

    // 관리자 로그인 체크
	public int adminCheck(Map<String, String> map);  
    // 관리자의 아이디와 비밀번호를 확인하여 로그인 가능 여부를 반환

    // 댓글 업데이트
	public void updateComment(Map<String, Object> map);  
    // 댓글 ID와 업데이트할 댓글 내용을 받아 댓글을 수정

    // 댓글 삭제
	public void deleteComment(int answerId);  
    // 댓글 ID를 이용하여 해당 댓글을 삭제

    // 특정 문의의 댓글 목록 조회
	public List<AnswerDTO> getCommentsByQuestionId(int questionsId);  
    // 문의 ID를 이용하여 해당 문의에 달린 모든 댓글을 조회

    // 문의 작성
	public void saveQuestion(QuestionsDTO questionsDTO);  
    // QuestionsDTO 객체를 통해 새로운 문의를 저장

    // 문의 업데이트
	public void updateInquiry(Map<String, Object> map);  
    // 문의 ID와 새로운 문의 내용을 받아 문의를 수정

    // 문의 삭제
	public void deleteQuestions(int questionsId);  
    // 문의 ID를 이용하여 해당 문의를 삭제

    // 사용자 이름으로 사용자 ID 조회
	public int getUserIdByUserName(String userName);  
    // 사용자 이름을 이용해 해당 사용자의 ID(Seq)를 반환하는 메서드

}
