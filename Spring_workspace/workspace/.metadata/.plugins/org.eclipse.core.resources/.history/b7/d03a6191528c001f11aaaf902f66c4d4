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

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/roomView", method = RequestMethod.GET)
    public String getAllRooms(Model model) {
        List<RoomDTO> rooms;
		try {
			rooms = roomService.getAllRooms(); // 모든 방 정보를 가져옴
			model.addAttribute("rooms", rooms);  // 모델에 rooms 리스트를 추가
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
        return "room/roomView";  // roomView.jsp로 이동
    }
    
    // 특정 방의 상세 정보 보기
    @RequestMapping(value = "/detail/{roomId}", method = RequestMethod.GET)
    public String roomDetail(@PathVariable("roomId") int roomId, Model model) {
        RoomDTO room = roomService.getRoomById(roomId);
        List<RoomImgDTO> roomImages = roomService.getRoomImagesByRoomId(roomId);  // 이미지 정보도 함께 조회
        model.addAttribute("room", room);
        model.addAttribute("roomImages", roomImages);
        return "room/roomDetail";  // roomDetail.jsp로 이동
    }
}
