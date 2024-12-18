package member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.control.CommandProcess;
import member.dao.MemberDAO;

public class WriteService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 데이터 수집
        // 클라이언트에서 전송된 데이터를 받아오는 부분입니다.
        // HTML form에서 입력된 값들을 request 객체에서 가져옵니다.
        String name = request.getParameter("name"); // 사용자가 입력한 이름을 가져옴
        String id = request.getParameter("id"); // 사용자가 입력한 ID를 가져옴
        String pwd = request.getParameter("pwd"); // 사용자가 입력한 비밀번호를 가져옴
        String gender = request.getParameter("gender"); // 사용자가 선택한 성별을 가져옴
        String email1 = request.getParameter("email1"); // 사용자가 입력한 이메일의 첫 번째 부분을 가져옴
        String email2 = request.getParameter("email2"); // 사용자가 입력한 이메일의 두 번째 부분(도메인)을 가져옴
        String tel1 = request.getParameter("tel1"); // 사용자가 입력한 전화번호의 첫 번째 부분을 가져옴
        String tel2 = request.getParameter("tel2"); // 사용자가 입력한 전화번호의 두 번째 부분을 가져옴
        String tel3 = request.getParameter("tel3"); // 사용자가 입력한 전화번호의 세 번째 부분을 가져옴
        String zipcode = request.getParameter("zipcode"); // 사용자가 입력한 우편번호를 가져옴
        String addr1 = request.getParameter("addr1"); // 사용자가 입력한 주소의 첫 번째 부분을 가져옴 (기본 주소)
        String addr2 = request.getParameter("addr2"); // 사용자가 입력한 주소의 두 번째 부분을 가져옴 (상세 주소)

        // MemberDTO 객체 생성 및 데이터 저장
        // DTO(Data Transfer Object)를 사용해 데이터를 하나의 객체로 관리합니다.
        // 폼에서 받은 데이터를 MemberDTO 객체에 저장하여 이후 DB로 전달합니다.
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name); // memberDTO 객체에 이름 저장
        memberDTO.setId(id); // memberDTO 객체에 ID 저장
        memberDTO.setPwd(pwd); // memberDTO 객체에 비밀번호 저장
        memberDTO.setGender(gender); // memberDTO 객체에 성별 저장
        memberDTO.setEmail1(email1); // memberDTO 객체에 이메일 앞부분 저장
        memberDTO.setEmail2(email2); // memberDTO 객체에 이메일 뒷부분 저장
        memberDTO.setTel1(tel1); // memberDTO 객체에 전화번호 첫 번째 부분 저장
        memberDTO.setTel2(tel2); // memberDTO 객체에 전화번호 두 번째 부분 저장
        memberDTO.setTel3(tel3); // memberDTO 객체에 전화번호 세 번째 부분 저장
        memberDTO.setZipcode(zipcode); // memberDTO 객체에 우편번호 저장
        memberDTO.setAddr1(addr1); // memberDTO 객체에 기본 주소 저장
        memberDTO.setAddr2(addr2); // memberDTO 객체에 상세 주소 저장

        // DB 작업
        // DAO(Data Access Object) 패턴을 이용하여 데이터베이스에 접근합니다.
        // MemberDAO의 싱글턴 객체를 사용해 데이터베이스 작업을 수행합니다.
        MemberDAO memberDAO = MemberDAO.getInstance();
        memberDAO.write(memberDTO); // write 메서드를 통해 memberDTO 객체의 데이터를 DB에 저장

        // forwarding 
        // 처리된 결과를 사용자에게 보여주기 위해 JSP 페이지로 포워딩합니다.
        // 사용자가 요청한 작업이 끝난 후, 응답할 페이지를 지정합니다.
        return "/member/write.jsp"; // 회원가입 완료 후 write.jsp 페이지로 이동
    }

}
