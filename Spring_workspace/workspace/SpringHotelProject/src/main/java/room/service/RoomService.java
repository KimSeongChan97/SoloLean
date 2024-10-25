package room.service;

import room.bean.RoomDTO;
import room.bean.RoomImgDTO;

import java.util.List;

public interface RoomService {

    // 모든 객실 정보를 조회하는 메서드
    public List<RoomDTO> getAllRooms() throws Exception;
    // 데이터베이스에서 모든 객실(RoomDTO) 정보를 조회하여 List로 반환
    // 각 RoomDTO 객체에는 객실의 이름, 설명, 가격 등의 정보가 담김
    // 예외 발생 시 Exception을 던짐

    // 특정 객실의 정보를 조회하는 메서드
    public RoomDTO getRoomById(int roomId);
    // roomId를 기준으로 특정 객실의 정보를 조회하고, RoomDTO 객체로 반환
    // RoomDTO 객체에는 해당 객실의 상세 정보가 담김

    // 특정 객실의 이미지 목록을 조회하는 메서드
    public List<RoomImgDTO> getRoomImagesByRoomId(int roomId);
    // roomId에 해당하는 객실의 이미지(RoomImgDTO) 목록을 조회하여 List로 반환
    // 이미지 목록은 해당 객실에 연결된 여러 개의 이미지로 구성될 수 있음

    // 사용자가 특정 객실에 대해 리뷰를 작성했는지 여부 확인
    public int isWrite(String userSeq, int roomId);
    // userSeq(사용자 ID)와 roomId(객실 ID)를 받아 사용자가 해당 객실에 대한 리뷰를 작성했는지 확인
    // 리뷰를 작성한 경우 1, 작성하지 않은 경우 0을 반환
}
