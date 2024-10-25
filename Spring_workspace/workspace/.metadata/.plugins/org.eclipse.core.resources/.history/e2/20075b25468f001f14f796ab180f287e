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

@Mapper
public interface AdminDAO {

	public List<UserDTO> checkUser(Map<String, Integer> map);

	public int getTotalA();

	public List<RoomDTO> getRoomList();

	public RoomDTO getRoomDTO(int roomId);

	// 객실 정보 업데이트
    public void updateRoom(RoomDTO roomDTO);

    // 객실 이미지 정보 업데이트
    public void updateRoomImg(RoomImgDTO roomImgDTO);

	public RoomImgDTO getRoomImgDTO(String roomId);

	public List<RoomDTO> getRoomListWithImages();

	public List<ReserveDTO> checkReserve(Map<String, Integer> map);

	public int getTotalB();

	public int getTotalC();

	public List<QuestionsDTO> inquiryList(Map<String, Integer> map);

	public QuestionsDTO getQuestionsDTO(String questionsId);

	public void writeComment(AnswerDTO answerDTO);

	public int adminCheck(Map<String, String> map);

	public void updateComment(Map<String, Object> map);

	public void deleteComment(int answerId);

	public List<AnswerDTO> getCommentsByQuestionId(int questionsId);

	public void saveQuestion(QuestionsDTO questionsDTO);

	public void updateInquiry(Map<String, Object> map);

	public void deleteQuestions(int questionsId);

	public int getUserIdByUserName(String userName);

}
