package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.control.CommandProcess;
import member.dao.MemberDAO;

public class UpdateService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        // 폼에서 입력된 회원 정보 가져오기
        // 클라이언트에서 전달된 회원 정보가 담긴 폼 데이터들을 가져오는 부분입니다.
        // 사용자는 이름, 아이디, 비밀번호, 성별, 이메일, 전화번호, 우편번호, 주소 등을 입력합니다.
        String name = request.getParameter("name");  // 사용자가 입력한 이름을 가져옵니다.
        String id = request.getParameter("id");  // 사용자가 입력한 ID를 가져옵니다.
        String pwd = request.getParameter("pwd");  // 사용자가 입력한 비밀번호를 가져옵니다.
        String gender = request.getParameter("gender");  // 사용자가 선택한 성별을 가져옵니다.
        String email1 = request.getParameter("email1");  // 사용자가 입력한 이메일 앞부분을 가져옵니다.
        String email2 = request.getParameter("email2");  // 사용자가 입력한 이메일 뒷부분(도메인)을 가져옵니다.
        String tel1 = request.getParameter("tel1");  // 사용자가 입력한 전화번호 첫 번째 부분을 가져옵니다.
        String tel2 = request.getParameter("tel2");  // 사용자가 입력한 전화번호 두 번째 부분을 가져옵니다.
        String tel3 = request.getParameter("tel3");  // 사용자가 입력한 전화번호 세 번째 부분을 가져옵니다.
        String zipcode = request.getParameter("zipcode");  // 사용자가 입력한 우편번호를 가져옵니다.
        String addr1 = request.getParameter("addr1");  // 사용자가 입력한 주소의 첫 번째 부분(기본 주소)을 가져옵니다.
        String addr2 = request.getParameter("addr2");  // 사용자가 입력한 주소의 두 번째 부분(상세 주소)을 가져옵니다.

        // MemberDTO 객체에 데이터 설정
        // 입력된 회원 정보를 MemberDTO 객체에 저장하는 부분입니다.
        // DTO(Data Transfer Object)는 데이터를 객체로 묶어 관리하고, 이를 DB로 전달하는 데 사용됩니다.
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);  // DTO에 이름 설정
        memberDTO.setId(id);  // DTO에 ID 설정
        memberDTO.setPwd(pwd);  // DTO에 비밀번호 설정
        memberDTO.setGender(gender);  // DTO에 성별 설정
        memberDTO.setEmail1(email1);  // DTO에 이메일 앞부분 설정
        memberDTO.setEmail2(email2);  // DTO에 이메일 뒷부분 설정
        memberDTO.setTel1(tel1);  // DTO에 전화번호 첫 번째 부분 설정
        memberDTO.setTel2(tel2);  // DTO에 전화번호 두 번째 부분 설정
        memberDTO.setTel3(tel3);  // DTO에 전화번호 세 번째 부분 설정
        memberDTO.setZipcode(zipcode);  // DTO에 우편번호 설정
        memberDTO.setAddr1(addr1);  // DTO에 기본 주소 설정
        memberDTO.setAddr2(addr2);  // DTO에 상세 주소 설정

        // DB 작업 - 회원 정보 수정
        // DAO(Data Access Object)를 사용해 데이터베이스에서 해당 회원의 정보를 수정하는 작업입니다.
        // MemberDAO 객체를 싱글턴 패턴으로 가져와 데이터베이스와 연결된 메서드를 호출합니다.
        MemberDAO memberDAO = MemberDAO.getInstance();
        memberDAO.update(memberDTO);  // update 메서드를 호출해 memberDTO 객체의 데이터를 DB에 저장 (회원 정보 수정)

        // 수정 완료 후 이동할 페이지 지정
        // 회원 정보 수정이 완료된 후, 사용자에게 결과를 보여줄 페이지로 포워딩합니다.
        
        return "none";  
    }

}
