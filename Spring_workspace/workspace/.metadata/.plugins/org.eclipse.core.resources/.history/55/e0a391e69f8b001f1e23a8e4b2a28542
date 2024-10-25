package admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.service.AdminService;
import room.bean.RoomDTO;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="admin/login", method = RequestMethod.GET)
	public String login() {
		return "/admin/login";
	}
	
	@RequestMapping(value="admin/updateRoom", method = RequestMethod.GET)
	public String updateRoom(Model model) {
		List<RoomDTO> roomList = adminService.getRoomList();
		model.addAttribute("roomList", roomList);
		return "/admin/updateRoom";
	}
	
	@RequestMapping(value="admin/updateRoomInfo", method = RequestMethod.GET)
	public String updateRoomInfo(@RequestParam String type, Model model) {
		RoomDTO roomDTO = adminService.getRoomDTO(type);
		model.addAttribute("roomDTO", roomDTO);
		
		return "/admin/updateRoomInfo";
	}
	
	@RequestMapping(value = "admin/update", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String update(@ModelAttribute RoomDTO roomDTO,
						 @RequestParam("img") MultipartFile img){
		adminService.update(roomDTO, img);
		return "객실 정보 수정완료";
	}
	
	@RequestMapping(value="admin/checkReserve", method = RequestMethod.GET)
	public String checkReserve() {
		return "/admin/checkReserve";
	}
	
	@RequestMapping(value="admin/checkUser", method = RequestMethod.GET)
	public String checkUser(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
		Map<String, Object> map2 = adminService.checkUser(pg);
		
		map2.put("pg", pg);
		model.addAttribute("map2", map2);
		
		return "/admin/checkUser";
	}
}
