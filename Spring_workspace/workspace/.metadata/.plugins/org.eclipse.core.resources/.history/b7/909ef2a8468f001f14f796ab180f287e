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

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private HttpSession session;
	@Autowired
	private ObjectStorageService objectStorageService;
	
	private String bucketName = "springhotel";
	@Autowired
	private AdminPaging adminPaging;
	@Override
	public Map<String, Object> checkUser(String pg) {
		//1페이지당 5개씩
		int startNum = (Integer.parseInt(pg)-1) * 5; //시작위치 (0부터 시작)
		int endNum = 5; //개수
		
		Map<String, Integer> map = new HashedMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		//DB
		List<UserDTO> list = adminDAO.checkUser(map);
		
		System.out.println("list = " + list);
		//페이징 처리
		int totalA = adminDAO.getTotalA(); //총글수
		
		adminPaging.setCurrentPage(Integer.parseInt(pg)); //현재페이지
		adminPaging.setPageBlock(3);
		adminPaging.setPageSize(5);
		adminPaging.setTotalA(totalA);
		adminPaging.makePagingHTML();
		
		Map<String, Object> map2 = new HashedMap<>();
		map2.put("list", list);
		map2.put("adminPaging", adminPaging);
		
		return map2;
	}
	@Override
	public List<RoomDTO> getRoomList() {
	    return adminDAO.getRoomListWithImages();
	}    
	@Override
	public RoomDTO getRoomDTO(int roomId) {
		return adminDAO.getRoomDTO(roomId);
	}
	@Override
	public void update(RoomDTO roomDTO, MultipartFile img) {
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		RoomImgDTO roomImgDTO  = adminDAO.getRoomImgDTO(roomDTO.getRoomId()+"");
		
		String imageFileName;
		String imageOriginalFileName;
		
		if(img.getSize() != 0) {
			//Object Storage(NCP) 이미지 삭제
			objectStorageService.deleteFile(bucketName, "storage/", roomImgDTO.getImageFileName());
			
			//Object Storage(NCP) 새로운 이미지 올리기
			imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);			
			imageOriginalFileName = img.getOriginalFilename();
			
			System.out.println("imageFileName = " + imageFileName);
			System.out.println("imageOriginalFileName = " + imageOriginalFileName);
			//파일을 서버에 저장
			File file = new File(filePath, imageOriginalFileName);
			
			try {
				img.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//이미지가 변경되지 않으면 기존 파일명 사용
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
		//1페이지당 5개씩
		int startNum = (Integer.parseInt(pg)-1) * 5; //시작위치 (0부터 시작)
		int endNum = 5; //개수
		
		Map<String, Integer> map = new HashedMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		//DB
		List<ReserveDTO> list = adminDAO.checkReserve(map);
		
		//페이징 처리
		int totalA = adminDAO.getTotalB(); //총글수
		
		adminPaging.setCurrentPage(Integer.parseInt(pg)); //현재페이지
		adminPaging.setPageBlock(3);
		adminPaging.setPageSize(5);
		adminPaging.setTotalA(totalA);
		adminPaging.makePagingHTML();
		
		Map<String, Object> map2 = new HashedMap<>();
		map2.put("list", list);
		map2.put("adminPaging", adminPaging);
		
		return map2;
	}
	@Override
	public Map<String, Object> inquiryList(String pg) {
		//1페이지당 5개씩
		int startNum = (Integer.parseInt(pg)-1) * 5; //시작위치 (0부터 시작)
		int endNum = 5; //개수
		
		Map<String, Integer> map = new HashedMap<>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		//DB
		List<QuestionsDTO> list = adminDAO.inquiryList(map);
		
		//페이징 처리
		int totalA = adminDAO.getTotalC(); //총글수
		
		adminPaging.setCurrentPage(Integer.parseInt(pg)); //현재페이지
		adminPaging.setPageBlock(3);
		adminPaging.setPageSize(5);
		adminPaging.setTotalA(totalA);
		adminPaging.makePagingHTML();
		
		Map<String, Object> map2 = new HashedMap<>();
		map2.put("list", list);
		map2.put("adminPaging", adminPaging);
		
		return map2;
	}
	
	@Override
	public QuestionsDTO getQuestionsDTO(String questionsId) {
		System.out.println("questionsId = " + questionsId);
		System.out.println(adminDAO.getQuestionsDTO(questionsId));
		return adminDAO.getQuestionsDTO(questionsId);
	}
	@Override
	public void writeComment(AnswerDTO answerDTO) {
		adminDAO.writeComment(answerDTO);
	}
	
	@Override
	public boolean adminCheck(String adminId, String pwd) {
		Map<String, String> map = new HashedMap<String, String>();
		map.put("adminId", adminId);
		map.put("pwd", pwd);
		int result = adminDAO.adminCheck(map);
		return result > 0;
	}
	@Override
	public void updateComment(int answerId, String comment) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("answerId", answerId);
		map.put("comment", comment);
		
		adminDAO.updateComment(map);
		
	}
	@Override
	public void deleteComment(int answerId) {		
		adminDAO.deleteComment(answerId);
		
	}
	@Override
	public List<AnswerDTO> getCommentsByQuestionId(int questionsId) {
	    return adminDAO.getCommentsByQuestionId(questionsId);
	}
	@Override
	public void saveQuestion(QuestionsDTO questionsDTO) {
		adminDAO.saveQuestion(questionsDTO);
		
	}
	@Override
	public void updateInquiry(int questionsId, int typename, String content) {
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("questionsId", questionsId);
		map.put("typename", typename);
		map.put("content", content);
		System.out.println("questionsId2 = " + questionsId);
		System.out.println("typename2 = " + typename);
		System.out.println("content2 = " + content);
		adminDAO.updateInquiry(map);
		
	}
	@Override
	public void deleteQuestions(int questionsId) {
		adminDAO.deleteQuestions(questionsId);
	}
	@Override
	public int getUserIdByUserName(String userName) {
		int userId = adminDAO.getUserIdByUserName(userName);
		return userId;
	}


}
