package room.dao;

import org.apache.ibatis.annotations.Mapper;
import room.bean.RoomDTO;
import room.bean.RoomImgDTO;

import java.util.HashMap;
import java.util.List;

@Mapper  // MyBatis 매퍼 인터페이스로, SQL 쿼리와 매핑되는 메서드를 정의
public interface RoomDAO {

    // 모든 객실 정보를 가져오는 메서드
    public List<RoomDTO> getAllRooms() throws Exception;
    // 데이터베이스에서 모든 객실(RoomDTO) 정보를 조회하여 List로 반환
    // 예외가 발생할 수 있으므로 Exception을 던짐

    // 특정 객실 정보를 가져오는 메서드
    public RoomDTO getRoomById(int roomId);
    // roomId에 해당하는 특정 객실 정보를 RoomDTO 객체로 반환

    // 특정 객실의 이미지 리스트를 가져오는 메서드
    public List<RoomImgDTO> getRoomImagesByRoomId(int roomId);
    // roomId에 해당하는 객실의 이미지 정보를 조회하여 List로 반환
    // 각 항목은 RoomImgDTO 객체로 저장됨

    // 사용자가 특정 방에 대한 리뷰를 작성했는지 여부 확인
    public int isWrite(HashMap<String, Integer> map);
    // 사용자 ID(userSeq)와 객실 ID(roomId)를 HashMap으로 받아
    // 사용자가 해당 객실에 대해 리뷰를 작성했는지 여부를 확인하고
    // 작성한 경우 1, 작성하지 않은 경우 0을 반환
}
