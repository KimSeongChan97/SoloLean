package room.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import room.bean.ReserveDTO;
import room.bean.RoomDTO;
import user.bean.UserDTO;

public interface ReserveService {

    // 조건에 맞는 객실 목록을 가져오는 메서드
	public ArrayList<RoomDTO> getFindRoomList(Map<String, String> map);
    // map에 담긴 날짜, 인원 등의 조건을 기반으로 객실 목록을 조회하여 반환
    // 반환되는 리스트에는 RoomDTO 객체가 담겨 있음

    // 예약 정보를 설정하는 메서드
	public ReserveDTO setReserveDTO(Map<String, String> getInfoMap);
    // 예약 정보를 담은 getInfoMap을 이용해 ReserveDTO 객체를 생성하여 반환
    // 예약 정보에는 객실 정보, 사용자 정보, 예약 날짜 등이 포함됨

    // 예약 정보를 저장하는 메서드
	public void submitReserve(Map<String, String> getSubmitMap);
    // 사용자가 입력한 예약 정보를 데이터베이스에 저장
    // getSubmitMap에는 예약과 관련된 모든 정보가 포함됨

    // 특정 사용자의 예약 목록을 가져오는 메서드
	public ArrayList<ReserveDTO> getReserveList(String userSeq);
    // userSeq(사용자 ID)에 해당하는 사용자의 예약 내역을 조회하여 반환
    // ArrayList에 ReserveDTO 객체가 담겨 있음

    // 특정 예약의 상세 정보를 가져오는 메서드
	public ReserveDTO getReserveDetali(String reserveId);
    // reserveId에 해당하는 예약의 상세 정보를 조회하여 ReserveDTO 객체로 반환
    // 예약에 대한 세부 정보 (객실, 예약 날짜, 사용자 정보 등) 포함

    // 사용자의 등급을 업데이트하는 메서드
	public void updateUserGrade(String userSeq);
    // 예약이 완료된 후, 사용자 ID(userSeq)를 기반으로 사용자의 등급을 업데이트
    // 예약 횟수나 금액에 따라 사용자의 등급을 상향 조정할 수 있음

    // 특정 사용자의 정보를 가져오는 메서드
	public UserDTO getUserInfo(String userSeq);
    // userSeq에 해당하는 사용자의 개인정보를 UserDTO 객체로 반환
    // 사용자 정보에는 이름, 이메일, 등급 등 다양한 정보가 포함될 수 있음
}
