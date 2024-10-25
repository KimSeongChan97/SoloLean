package room.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.HttpMethod;

import room.bean.ReserveDTO;
import room.bean.RoomDTO;
import room.service.ReserveService;
import room.service.RoomService;
import user.bean.UserDTO;

@Controller  // Spring MVC의 컨트롤러로 사용됨을 나타냄
@RequestMapping("/reserve")  // "/reserve" 경로에 대한 요청을 이 컨트롤러에서 처리
public class ReserveController {
    
    @Autowired  // ReserveService 객체를 자동으로 주입하여 예약 관련 비즈니스 로직 처리
    ReserveService reserveService;
    
    // [ 날짜, 인원 선택 화면 ]
    @RequestMapping(value = "/main")
    public String main(ModelMap mMap) {
        // "/reserve/main" 경로로 요청이 들어오면 날짜와 인원을 선택하는 페이지로 이동
        return "reserve/menu1";  // reserve/menu1.jsp 또는 reserve/menu1.html 페이지로 이동
    }
    
    // 조건에 맞는 객실 확인
    @RequestMapping(value = "/menu2/findRoom", method = RequestMethod.POST)
    @ResponseBody  // 이 메서드는 View를 반환하지 않고, 데이터만 JSON 형식으로 반환
    public boolean findRoom(@RequestParam Map<String, String> map) {
        // 요청으로부터 전달된 파라미터(map)를 이용해 예약 가능한 객실 목록 조회
        ArrayList<RoomDTO> findRoomList = reserveService.getFindRoomList(map);
        
        // 예약 가능한 객실이 없으면 false 반환
        if(findRoomList == null || findRoomList.size() == 0) return false;
        
        // 예약 가능한 객실이 있으면 true 반환
        return true;
    }
    
    // [ 객실 정보 화면 ]
    @RequestMapping(value = "/menu2")
    public String menu2(@RequestParam Map<String, String> map, ModelMap mMap) {
        // 예약 가능한 객실 목록을 조회한 후 객실 정보 화면으로 이동
        ArrayList<RoomDTO> roomList = reserveService.getFindRoomList(map);  // 조건에 맞는 객실 목록 조회
        mMap.addAttribute("roomList", roomList);  // 조회된 객실 목록을 모델에 추가
        mMap.addAttribute("userInput", map);  // 사용자가 입력한 조건을 모델에 추가
        
        return "reserve/menu2";  // reserve/menu2.jsp 또는 reserve/menu2.html 페이지로 이동
    }
    
    // [ 예약 정보 화면 ]
    @RequestMapping(value = "/menu3/info")
    public String info() {
        // 예약 정보를 입력하는 화면으로 이동
        return "reserve/menu3";  // reserve/menu3.jsp 또는 reserve/menu3.html 페이지로 이동
    }
    
    // 예약 정보 출력
    @RequestMapping(value = "/menu3")
    public void menu3(@RequestParam Map<String, String> getInfoMap, ModelMap mMap) {
        // 예약 정보를 처리하여 화면에 출력
        System.out.println("/menu3");
        System.out.println(getInfoMap);  // 예약 관련 정보 출력 (디버깅용)
        
        // 예약 정보 생성 후 모델에 추가
        mMap.addAttribute("reserveDTO", reserveService.setReserveDTO(getInfoMap));  // 예약 정보 DTO를 생성하여 모델에 추가
    }
    
    // 예약 정보 저장
    @RequestMapping(value = "/menu3/submit", method = RequestMethod.POST)
    @ResponseBody  // View를 반환하지 않고, 데이터만 반환하는 메서드 (AJAX 처리용)
    public String submit(@RequestParam Map<String, String> getSubmitMap, HttpSession session) {
        // 예약 정보를 받아서 데이터베이스에 저장
        System.out.println("/menu3/submit");
        getSubmitMap.put("userSeq", session.getAttribute("userSeq").toString());  // 세션에서 사용자 ID(userSeq) 가져오기
        System.out.println(getSubmitMap);  // 입력된 예약 정보 출력 (디버깅용)
        
        // 예약 정보 저장
        reserveService.submitReserve(getSubmitMap);
        
        // 예약 완료 후 회원 등급 업데이트
        reserveService.updateUserGrade(session.getAttribute("userSeq").toString());
        
        return null;  // 성공 시 특별한 데이터를 반환하지 않음
    }
    
    // 사용자 예약 내역 확인
    @RequestMapping(value = "/list")
    public String list(HttpSession session, Model model) {
        // 현재 로그인한 사용자의 예약 내역을 확인하는 화면으로 이동
        System.out.println("/list");
        
        String userSeq = session.getAttribute("userSeq").toString();  // 세션에서 사용자 ID 가져오기
        ArrayList<ReserveDTO> reserveDTOList = reserveService.getReserveList(userSeq);  // 사용자 예약 내역 조회
        UserDTO userDTO = reserveService.getUserInfo(userSeq);  // 사용자 정보 조회
        
        model.addAttribute("userDTO", userDTO);  // 사용자 정보를 모델에 추가
        model.addAttribute("reserveDTOList", reserveDTOList);  // 예약 내역을 모델에 추가
        
        return "reserve/list";  // reserve/list.jsp 또는 reserve/list.html 페이지로 이동
    }
    
    // 예약 상세 정보
    @RequestMapping(value = "/list/detail")
    public String list(@RequestParam String reserveId, Model model) {
        // 특정 예약의 상세 정보를 조회하여 화면에 표시
        System.out.println("/list/detail");
        
        ReserveDTO reserveDTO = reserveService.getReserveDetali(reserveId);  // 예약 ID로 예약 상세 정보 조회
        model.addAttribute("reserveDTO", reserveDTO);  // 조회된 예약 정보를 모델에 추가
        
        return "reserve/detail";  // reserve/detail.jsp 또는 reserve/detail.html 페이지로 이동
    }
}
