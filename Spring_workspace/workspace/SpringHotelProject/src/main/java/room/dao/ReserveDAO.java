package room.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import room.bean.ReserveDTO;
import room.bean.RoomDTO;
import user.bean.UserDTO;

@Mapper  // MyBatis 매퍼 인터페이스임을 나타냄, SQL 매핑을 처리하는 역할을 함
public interface ReserveDAO {

    // 조건에 맞는 객실 목록 조회
	public ArrayList<RoomDTO> findRoomList(Map<String, String> map);
    // map에 담긴 조건(날짜, 인원 등)에 맞는 객실(RoomDTO)을 조회하여 ArrayList로 반환
    // 예외 발생 시 MyBatis가 처리

    // 예약 정보 저장
	public void submitReserve(Map<String, String> getSubmitMap);
    // 예약 정보를 담은 map을 이용해 데이터베이스에 새로운 예약을 저장함
    // 예약 정보를 Map으로 전달하여 필요한 필드를 동적으로 저장

    // 특정 사용자의 예약 목록 조회
	public ArrayList<ReserveDTO> getReserveList(String userSeq);
    // userSeq(사용자 ID)에 해당하는 사용자의 모든 예약 내역을 ArrayList로 반환
    // ReserveDTO 객체에 예약 정보를 담아 반환

    // 특정 예약의 상세 정보 조회
	public ReserveDTO getReserveDetali(String reserveId);
    // reserveId에 해당하는 예약의 상세 정보를 ReserveDTO로 반환
    // 예약 ID를 통해 개별 예약 정보를 조회함

    // 사용자 등급 업데이트
	public void updateUserGrade(String userSeq);
    // 예약이 완료된 후 사용자의 등급을 업데이트함
    // userSeq를 기준으로 해당 사용자의 등급을 갱신

    // 사용자 정보 조회
	public UserDTO getUserInfo(String userSeq);
    // userSeq에 해당하는 사용자의 정보를 UserDTO 객체로 반환
    // 사용자의 개인정보, 예약 내역 등 사용자와 관련된 정보를 조회
}
