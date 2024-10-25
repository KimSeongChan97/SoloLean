package room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import room.bean.RoomDTO;
import room.bean.RoomImgDTO;
import room.dao.RoomDAO;

import java.util.HashMap;
import java.util.List;

@Service  // 이 클래스는 Spring의 서비스 계층으로 동작하며, 비즈니스 로직을 처리
public class RoomServiceImpl implements RoomService {

    @Autowired  // RoomDAO 객체를 자동으로 주입받아 데이터베이스와 상호작용
    private RoomDAO roomDAO;

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        // 모든 객실 정보를 조회하는 메서드
        // RoomDAO에서 getAllRooms()를 호출하여 데이터베이스의 객실 목록을 조회
        return roomDAO.getAllRooms();
    }
    
    @Override
    public RoomDTO getRoomById(int roomId) {
        // 특정 roomId에 해당하는 객실 정보를 조회하는 메서드
        // RoomDAO에서 getRoomById()를 호출하여 해당 객실의 정보를 반환
        return roomDAO.getRoomById(roomId);
    }

    @Override
    public List<RoomImgDTO> getRoomImagesByRoomId(int roomId) {
        // 특정 roomId에 해당하는 객실의 이미지 리스트를 가져오는 메서드
        // RoomDAO에서 getRoomImagesByRoomId()를 호출하여 이미지 정보를 조회
        return roomDAO.getRoomImagesByRoomId(roomId);
    }

    @Override
    public int isWrite(String userSeq, int roomId) {
        // 사용자가 특정 roomId에 대해 리뷰를 작성했는지 확인하는 메서드
        // userSeq(사용자 ID)와 roomId(객실 ID)를 HashMap에 담아 RoomDAO에 전달
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("userSeq", Integer.parseInt(userSeq));  // 사용자 ID를 정수형으로 변환하여 Map에 추가
        map.put("roomId", roomId);  // 객실 ID를 Map에 추가
        
        // RoomDAO의 isWrite() 메서드를 호출하여 리뷰 작성 여부를 확인
        return roomDAO.isWrite(map);
    }
}
