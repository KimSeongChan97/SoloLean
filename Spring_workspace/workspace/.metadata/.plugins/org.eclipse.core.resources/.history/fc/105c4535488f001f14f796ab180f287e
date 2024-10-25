package room.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
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

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveDAO reserveDAO;
    @Autowired
    private RoomDAO roomDAO;

    // 예약 가능 객실 
	@Override
	public ArrayList<RoomDTO> getFindRoomList(Map<String, String> map) {
		int kids = Integer.parseInt(map.get("kids"));
		int adults = Integer.parseInt(map.get("adults"));
		
		map.put("people", kids + adults + "");
		ArrayList<RoomDTO> findRoomList = reserveDAO.findRoomList(map);
		
		for (RoomDTO roomDTO : findRoomList) {
			System.out.println(roomDTO.toString());
		}
		System.out.println(findRoomList == null);
		System.out.println(findRoomList.size());
		return findRoomList;
	}

	// 예약 정보 설정
	@Override
	public ReserveDTO setReserveDTO(Map<String, String> getInfoMap) {
		// 체크인, 체크아웃, 어른, 어린이, 총 금액, 사용자 아이디, room 정보
		
		ReserveDTO reserveDTO = new ReserveDTO();
		reserveDTO.setUserId(Integer.parseInt(getInfoMap.get("userSeq")));
		reserveDTO.setRoomId(Integer.parseInt(getInfoMap.get("roomId")));
		
		reserveDTO.setAdults(Integer.parseInt(getInfoMap.get("adults")));
		reserveDTO.setKids(Integer.parseInt(getInfoMap.get("kids")));
		
		reserveDTO.setCheckin(getInfoMap.get("checkin"));
		reserveDTO.setCheckout(getInfoMap.get("checkout"));
		
		// RoomDTO 설정
		RoomDTO roomDTO = roomDAO.getRoomById(reserveDTO.getRoomId());
		reserveDTO.setRoom(roomDTO);
		
		// 가격 설정
		reserveDTO.setPrice(getDays(reserveDTO.getCheckin(), reserveDTO.getCheckout()) * roomDTO.getPrice());
		
		return reserveDTO;
	}

	// 예약 정보 저장
	@Override
	public void submitReserve(Map<String, String> getSubmitMap) {
		reserveDAO.submitReserve(getSubmitMap);
	}

	@Override
	public ArrayList<ReserveDTO> getReserveList(String userSeq) {
		ArrayList<ReserveDTO> list = reserveDAO.getReserveList(userSeq);
		
		for (ReserveDTO reserveDTO : list) {
			reserveDTO.setDays(getDays(reserveDTO.getCheckin(), reserveDTO.getCheckout()));
			System.out.println(reserveDTO);
		}
		return list;
	}

	// 예약 상세 내역
	@Override
	public ReserveDTO getReserveDetali(String reserveId) {
		ReserveDTO reserveDTO = reserveDAO.getReserveDetali(reserveId);
		reserveDTO.setDays(getDays(reserveDTO.getCheckin(), reserveDTO.getCheckout()));
		System.out.println(reserveDTO);
		return reserveDTO;
	}
	
	@Override
	public void updateUserGrade(String userSeq) {
		reserveDAO.updateUserGrade(userSeq);
	}
	
	// 숙박일 계산
	private int getDays(String checkin, String checkout) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate checkinDate = LocalDate.parse(checkin, format);
		LocalDate checkoutDate = LocalDate.parse(checkout, format);
		
		return (int) DAYS.between(checkinDate, checkoutDate);
	}

	@Override
	public UserDTO getUserInfo(String userSeq) {
		return reserveDAO.getUserInfo(userSeq);
	}
	
}
