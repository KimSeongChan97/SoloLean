package member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import member.entity.MemberEntity;
import member.service.MemberService;


@Controller
@RequestMapping(value = "member")
public class MemberController {

    // MemberService를 주입하여 사용합니다. @Autowired는 Spring이 자동으로 주입해 주는 어노테이션입니다.
    @Autowired
    private MemberService memberService;

    // 회원 정보 작성 화면으로 이동하는 메서드입니다.
    // 이 메서드는 "member/writeForm"이라는 경로를 반환하며, 해당 경로에 매핑된 뷰 페이지를 보여줍니다.
    @GetMapping(value = "writeForm")
    public String writeForm() {
        return "member/writeForm"; // writeForm.html 또는 JSP 파일을 렌더링하는 용도
    };

    // 회원 ID의 중복 여부를 확인하는 메서드입니다. 
    // 클라이언트가 POST 요청을 보내며, id 값을 전송하여 중복 여부를 확인합니다.
    @PostMapping(value = "isExistId")
    @ResponseBody // 이 어노테이션은 리턴 값을 그대로 HTTP 응답 본문에 담아 반환하도록 합니다.
    public String isExistId(@RequestParam(value = "id") String id) {
        // memberService의 isExistId 메서드를 호출하여 중복 여부를 반환받습니다.
        return memberService.isExistId(id); // 중복 여부 결과를 문자열로 반환
    };

    // 새로운 회원 정보를 저장하는 메서드입니다.
    // 회원 정보를 담고 있는 MemberEntity 객체를 파라미터로 받아서 회원 가입을 처리합니다.
    @PostMapping(value = "write")
    @ResponseBody // 이 메서드는 별도의 화면을 반환하지 않고 응답 데이터를 바로 전송합니다.
    public void write(@ModelAttribute MemberEntity memberEntity) {
        // MemberService를 통해 회원 정보를 저장하는 로직을 호출합니다.
        memberService.write(memberEntity); // 회원 정보 저장 메서드
    };

    // 회원 목록을 조회하는 메서드입니다.
    // 페이지 번호와 정렬 기준, 페이지 사이즈 등의 정보를 포함한 Pageable 객체를 파라미터로 받습니다.
    @GetMapping(value = "list")
    public String list(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
                       @PageableDefault(page = 0, size = 3, sort = "name", direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {

        // memberService의 getMemberList 메서드를 호출하여, 페이지 정보를 담은 회원 목록을 가져옵니다.
        Map<String, Object> map = memberService.getMemberList(pageable);

        // model 객체에 "list" 속성으로 회원 목록 데이터를 추가하여 뷰에서 사용할 수 있게 합니다.
        model.addAttribute("list", map.get("list"));
        // 페이징 정보를 "memberPaging" 속성으로 추가하여, 페이지네이션 UI를 구현하는데 사용할 수 있도록 합니다.
        model.addAttribute("memberPaging", map.get("memberPaging"));

        return "member/list"; // "member/list" 뷰 페이지로 이동합니다.
    };
    
    
    
    @GetMapping(value = "getSearchList")
    @ResponseBody
    public Map<String, Object> getSearchList(
        @RequestParam(value = "columnName") String columnName,
        @RequestParam(value = "value") String value,
        @PageableDefault(page = 0, size = 3, sort = "seq", direction = Sort.Direction.DESC) Pageable pageable) {
        return memberService.getSearchList(columnName, value, pageable);
    }
    
    
    
    
    
}
