package room.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;
import static java.time.temporal.ChronoUnit.DAYS;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import room.bean.ReserveDTO;
import room.bean.RoomDTO;
import room.dao.ReserveDAO;
import room.dao.RoomDAO;
import user.bean.UserDTO;

@Service  // 이 클래스는 Spring의 서비스 계층을 나타내며, 비즈니스 로직을 처리함
public class ReserveServiceImpl implements ReserveService {
    @Autowired  // 자동으로 ReserveDAO 객체를 주입받아 데이터베이스와 상호작용
    private ReserveDAO reserveDAO;
    
    @Autowired  // 자동으로 RoomDAO 객체를 주입받아 객실 정보와 상호작용
    private RoomDAO roomDAO;

    // 예약 가능 객실 목록 조회
    @Override
    public ArrayList<RoomDTO> getFindRoomList(Map<String, String> map) {
        // 사용자가 입력한 어른과 어린이 수를 합산하여 총 인원을 계산
        int kids = Integer.parseInt(map.get("kids"));  // 어린이 수
        int adults = Integer.parseInt(map.get("adults"));  // 어른 수
        
        // 총 인원을 people 키에 저장
        map.put("people", kids + adults + "");
        
        // 데이터베이스에서 조건에 맞는 객실 목록을 조회
        ArrayList<RoomDTO> findRoomList = reserveDAO.findRoomList(map);
        
        // 조회된 객실 목록을 출력 (디버깅용)
        for (RoomDTO roomDTO : findRoomList) {
            System.out.println(roomDTO.toString());
        }
        System.out.println(findRoomList == null);  // 객실 목록이 null인지 확인
        System.out.println(findRoomList.size());  // 조회된 객실 수 출력
        return findRoomList;  // 객실 목록 반환
    }

    // 예약 정보 설정
    @Override
    public ReserveDTO setReserveDTO(Map<String, String> getInfoMap) {
        // 예약 정보를 설정하는 메서드로, 사용자 ID, 객실 정보, 인원 수, 체크인/체크아웃 날짜 등을 처리
        ReserveDTO reserveDTO = new ReserveDTO();
        reserveDTO.setUserId(Integer.parseInt(getInfoMap.get("userSeq")));  // 사용자 ID 설정
        reserveDTO.setRoomId(Integer.parseInt(getInfoMap.get("roomId")));  // 객실 ID 설정
        
        reserveDTO.setAdults(Integer.parseInt(getInfoMap.get("adults")));  // 어른 수 설정
        reserveDTO.setKids(Integer.parseInt(getInfoMap.get("kids")));  // 어린이 수 설정
        
        reserveDTO.setCheckin(getInfoMap.get("checkin"));  // 체크인 날짜 설정
        reserveDTO.setCheckout(getInfoMap.get("checkout"));  // 체크아웃 날짜 설정
        
        // 객실 정보를 RoomDTO 객체로 설정
        RoomDTO roomDTO = roomDAO.getRoomById(reserveDTO.getRoomId());
        reserveDTO.setRoom(roomDTO);
        
        // 숙박 기간에 따른 가격 계산
        reserveDTO.setPrice(getDays(reserveDTO.getCheckin(), reserveDTO.getCheckout()) * roomDTO.getPrice());
        
        return reserveDTO;  // 예약 정보가 담긴 ReserveDTO 반환
    }

    // 예약 정보 저장
    @Override
    public void submitReserve(Map<String, String> getSubmitMap) {
        // 예약 정보를 데이터베이스에 저장
        reserveDAO.submitReserve(getSubmitMap);
    }

    // 특정 사용자의 예약 목록 조회
    @Override
    public ArrayList<ReserveDTO> getReserveList(String userSeq) {
        ArrayList<ReserveDTO> list = reserveDAO.getReserveList(userSeq);  // 사용자의 예약 목록 조회
        
        // 각 예약 정보에 대해 숙박 일수를 계산하여 설정
        for (ReserveDTO reserveDTO : list) {
            reserveDTO.setDays(getDays(reserveDTO.getCheckin(), reserveDTO.getCheckout()));
            System.out.println(reserveDTO);  // 예약 정보를 출력 (디버깅용)
        }
        return list;  // 예약 목록 반환
    }

    // 예약 상세 내역 조회
    @Override
    public ReserveDTO getReserveDetali(String reserveId) {
        // 특정 예약의 상세 정보를 조회
        ReserveDTO reserveDTO = reserveDAO.getReserveDetali(reserveId);
        
        // 숙박 일수를 계산하여 설정
        reserveDTO.setDays(getDays(reserveDTO.getCheckin(), reserveDTO.getCheckout()));
        System.out.println(reserveDTO);  // 예약 상세 정보를 출력 (디버깅용)
        
        return reserveDTO;  // 예약 상세 정보 반환
    }
    
    // 사용자 등급 업데이트
    @Override
    public void updateUserGrade(String userSeq) {
        // 예약 완료 후, 사용자의 등급을 업데이트
        reserveDAO.updateUserGrade(userSeq);
    }
    
    // 숙박 일수 계산
    private int getDays(String checkin, String checkout) {
        // 체크인/체크아웃 날짜를 기준으로 숙박 기간을 계산
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 체크인 날짜와 체크아웃 날짜를 LocalDate 객체로 변환
        LocalDate checkinDate = LocalDate.parse(checkin, format);
        LocalDate checkoutDate = LocalDate.parse(checkout, format);
        
        // 두 날짜 사이의 일수 차이를 계산하여 반환
        return (int) DAYS.between(checkinDate, checkoutDate);
    }

    // 사용자 정보 조회
    @Override
    public UserDTO getUserInfo(String userSeq) {
        // 특정 사용자 ID(userSeq)에 해당하는 사용자 정보를 조회하여 반환
        return reserveDAO.getUserInfo(userSeq);
    }
}
