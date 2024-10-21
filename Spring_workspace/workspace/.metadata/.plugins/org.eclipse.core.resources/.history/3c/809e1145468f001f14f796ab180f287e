package admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import answer.bean.AnswerDTO;
import questions.bean.QuestionsDTO;
import room.bean.RoomDTO;

public interface AdminService {

	public Map<String, Object> checkUser(String pg);

	public List<RoomDTO> getRoomList();

	public RoomDTO getRoomDTO(int roomId);

	public void update(RoomDTO roomDTO, MultipartFile img);

	public Map<String, Object> checkReserve(String pg);

	public Map<String, Object> inquiryList(String pg);

	public QuestionsDTO getQuestionsDTO(String questionsId);

	public void writeComment(AnswerDTO answerDTO);

	public boolean adminCheck(String adminId, String pwd);

	public void updateComment(int answerId, String comment);

	public void deleteComment(int answerId);

	public List<AnswerDTO> getCommentsByQuestionId(int parseInt);

	public void saveQuestion(QuestionsDTO questionsDTO);

	public void updateInquiry(int questionsId, int typename, String content);

	public void deleteQuestions(int questionsId);

	public int getUserIdByUserName(String userName);


}
