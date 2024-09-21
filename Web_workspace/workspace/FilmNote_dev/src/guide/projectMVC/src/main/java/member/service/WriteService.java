package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class WriteService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 데이터
        // 사용자가 폼에서 입력한 데이터를 request 객체에서 받아옵니다.
        String name = request.getParameter("name"); // 사용자 이름
        String id = request.getParameter("id");     // 사용자 ID
        String pwd = request.getParameter("pwd");   // 사용자 비밀번호
        String gender = request.getParameter("gender"); // 사용자 성별
        String email1 = request.getParameter("email1"); // 사용자 이메일 앞부분
        String email2 = request.getParameter("email2"); // 사용자 이메일 뒷부분
        String tel1 = request.getParameter("tel1"); // 전화번호 앞부분 (지역번호)
        String tel2 = request.getParameter("tel2"); // 전화번호 중간부분
        String tel3 = request.getParameter("tel3"); // 전화번호 끝부분
        String zipcode = request.getParameter("zipcode"); // 사용자 우편번호
        String addr1 = request.getParameter("addr1"); // 사용자 주소1
        String addr2 = request.getParameter("addr2"); // 사용자 주소2 (상세 주소)
        
        // MemberDTO 객체에 입력된 정보를 저장합니다.
        // MemberDTO는 회원 정보를 담는 객체입니다.
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);     // 사용자 이름 설정
        memberDTO.setId(id);         // 사용자 ID 설정
        memberDTO.setPwd(pwd);       // 사용자 비밀번호 설정
        memberDTO.setGender(gender); // 사용자 성별 설정
        memberDTO.setEmail1(email1); // 사용자 이메일 앞부분 설정
        memberDTO.setEmail2(email2); // 사용자 이메일 뒷부분 설정
        memberDTO.setTel1(tel1);     // 전화번호 앞부분 설정
        memberDTO.setTel2(tel2);     // 전화번호 중간부분 설정
        memberDTO.setTel3(tel3);     // 전화번호 끝부분 설정
        memberDTO.setZipcode(zipcode); // 사용자 우편번호 설정
        memberDTO.setAddr1(addr1);   // 사용자 주소1 설정
        memberDTO.setAddr2(addr2);   // 사용자 주소2 설정 (상세 주소)
        
        // DB 처리
        // DAO 객체를 통해 회원 정보를 데이터베이스에 저장합니다.
        MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤 패턴으로 DAO 객체를 가져옵니다.
        memberDAO.write(memberDTO); // memberDTO에 담긴 회원 정보를 데이터베이스에 저장
        
        return "none"; // 이 로직에서는 화면 전환 없이 단순히 작업만 수행하므로 "none"을 반환합니다.
    }

}
