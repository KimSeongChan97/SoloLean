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

@Controller  // 이 클래스는 Spring MVC의 컨트롤러임을 나타냄
@RequestMapping("/room")  // "/room" 경로에 대한 요청을 이 컨트롤러에서 처리
public class RoomController {

    @Autowired  // RoomService 객체를 자동으로 주입받음. 서비스 계층의 비즈니스 로직을 호출하는 데 사용됨
    private RoomService roomService;

    // 전체 객실 목록 가져오기
    @RequestMapping(value = "/roomView", method = RequestMethod.GET)  // GET 요청에 대해 객실 목록을 보여줌
    public String getAllRooms(Model model) {
        try {
            // 서비스에서 모든 객실(RoomDTO) 정보를 가져옴
            List<RoomDTO> rooms = roomService.getAllRooms();
            model.addAttribute("rooms", rooms);  // 모델에 객실 목록 추가하여 뷰로 전달
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 스택 트레이스 출력
        }
        return "room/roomView";  // 객실 목록을 보여줄 roomView.jsp로 이동
    }
    
    // 특정 방의 상세 정보 보기
    @RequestMapping(value = "/detail/{roomId}", method = RequestMethod.GET)  // GET 요청 시, 특정 방의 상세 정보를 조회
    public String roomDetail(@PathVariable("roomId") int roomId, HttpSession session, Model model) {
        // @PathVariable을 이용해 URL에서 roomId를 추출하고, HttpSession을 통해 사용자 세션 정보에 접근
        System.out.println(session);  // 세션 정보 출력 (디버깅용)
        
        // roomId를 이용해 특정 객실의 정보를 가져옴
        RoomDTO room = roomService.getRoomById(roomId);
        
        // roomId를 이용해 해당 객실의 이미지 리스트를 가져옴
        List<RoomImgDTO> roomImages = roomService.getRoomImagesByRoomId(roomId);
        
        try {
            // 세션에서 사용자 고유 ID(userSeq)를 가져와 해당 사용자가 해당 방에 대해 리뷰를 작성했는지 확인
            String userSeq = session.getAttribute("userSeq").toString();  // 세션에서 userSeq 가져오기
            int reserveCount = roomService.isWrite(userSeq, roomId);  // 사용자가 이 방에 대한 리뷰를 작성했는지 확인
            model.addAttribute("reserveCount", reserveCount);  // 해당 방의 예약 횟수 정보를 모델에 추가
        } catch (NullPointerException e) {
            // 세션 정보가 없거나 (로그인하지 않은 사용자) NullPointerException 발생 시, 예약 횟수를 0으로 설정
            model.addAttribute("reserveCount", 0);
        }
        
        // 모델에 객실 정보와 이미지 리스트를 추가하여 뷰에 전달
        model.addAttribute("room", room);
        model.addAttribute("roomImages", roomImages);  // 객실 이미지 리스트를 모델에 추가
        
        return "room/roomDetail";  // 객실 상세 정보를 보여줄 roomDetail.jsp로 이동
    }
}
