package room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import room.bean.RoomDTO;
import room.bean.RoomImgDTO;
import room.service.RoomService;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // 전체 객실 목록 가져오기
    @RequestMapping(value = "/roomView", method = RequestMethod.GET)
    public String getAllRooms(Model model) {
        try {
            List<RoomDTO> rooms = roomService.getAllRooms(); // 모든 방 정보를 가져옴
            model.addAttribute("rooms", rooms);  // 모델에 rooms 리스트를 추가
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "room/roomView";  // roomView.jsp로 이동
    }
    
    // 특정 방의 상세 정보 보기
    @RequestMapping(value = "/detail/{roomId}", method = RequestMethod.GET)
    public String roomDetail(@PathVariable("roomId") int roomId, HttpSession session, Model model) {
    	System.out.println(session);
        RoomDTO room = roomService.getRoomById(roomId);  // 특정 방 정보
        List<RoomImgDTO> roomImages = roomService.getRoomImagesByRoomId(roomId);  // 해당 방의 이미지 정보
        
        try {
			String userSeq = session.getAttribute("userSeq").toString();
			int reserveCount = roomService.isWrite(userSeq, roomId); // 리뷰 작성 유무 판단
	        model.addAttribute("reserveCount", reserveCount); // 특정 방의 예약 횟수
		} catch (NullPointerException e) {
			model.addAttribute("reserveCount", 0);
		}
        
        model.addAttribute("room", room);
        model.addAttribute("roomImages", roomImages);  // 이미지 정보를 모델에 추가
        
        return "room/roomDetail";  // roomDetail.jsp로 이동
    }
}
