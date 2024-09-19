package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;
import member.control.CommandProcess;
import member.dao.MemberDAO;

public class UpdateService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        // 폼에서 입력된 회원 정보 가져오기
        // 클라이언트에서 전달된 회원 정보가 담긴 폼 데이터들을 가져오는 부분입니다.
        // 사용자는 이름, 아이디, 비밀번호, 성별, 이메일, 전화번호, 우편번호, 주소 등을 입력합니다.
        // HttpServletRequest의 getParameter() 메서드를 사용하여 폼 데이터를 받아옴.
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
        
        // 사용자가 입력한 데이터를 각각의 변수에 저장한 후, 이를 DTO 객체에 전달하여 DB에 저장할 준비를 합니다.
        // DTO 객체는 여러 필드를 하나로 묶어 데이터 전달을 효율적으로 해주는 역할을 합니다.

        // MemberDTO 객체에 데이터 설정
        // 입력된 회원 정보를 MemberDTO 객체에 저장하는 부분입니다.
        // DTO(Data Transfer Object)는 데이터를 객체로 묶어 관리하고, 이를 DB로 전달하는 데 사용됩니다.
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);  // DTO에 이름 설정
        // name 변수에 담긴 사용자의 이름을 MemberDTO 객체에 설정합니다.
        memberDTO.setId(id);  // DTO에 ID 설정
        // 사용자의 아이디를 DTO에 저장하여 DB 작업 시 이 ID로 식별할 수 있게 합니다.
        memberDTO.setPwd(pwd);  // DTO에 비밀번호 설정
        // 비밀번호는 민감한 정보이므로 이를 안전하게 저장하는 방법도 고려해야 합니다.
        memberDTO.setGender(gender);  // DTO에 성별 설정
        // 성별 정보는 사용자가 선택한 값을 기준으로 저장됩니다.
        memberDTO.setEmail1(email1);  // DTO에 이메일 앞부분 설정
        memberDTO.setEmail2(email2);  // DTO에 이메일 뒷부분 설정
        // 이메일은 두 부분으로 나뉘어져 있지만, 이를 하나의 이메일로 완성하여 사용할 수 있습니다.
        memberDTO.setTel1(tel1);  // DTO에 전화번호 첫 번째 부분 설정
        memberDTO.setTel2(tel2);  // DTO에 전화번호 두 번째 부분 설정
        memberDTO.setTel3(tel3);  // DTO에 전화번호 세 번째 부분 설정
        // 전화번호는 각 자리별로 나누어 입력받지만, 이를 합쳐 하나의 전화번호로 관리할 수 있습니다.
        memberDTO.setZipcode(zipcode);  // DTO에 우편번호 설정
        memberDTO.setAddr1(addr1);  // DTO에 기본 주소 설정
        memberDTO.setAddr2(addr2);  // DTO에 상세 주소 설정
        // 사용자가 입력한 주소 정보는 기본 주소와 상세 주소로 나누어 저장됩니다.
        
        // 위에서 사용된 DTO는 하나의 객체로 회원 정보를 한 번에 담아 전달할 수 있도록 도와줍니다.
        // 이를 통해 코드의 가독성과 유지보수성을 높일 수 있습니다.

        // DB 작업 - 회원 정보 수정
        // DAO(Data Access Object)를 사용해 데이터베이스에서 해당 회원의 정보를 수정하는 작업입니다.
        // MemberDAO 객체를 싱글턴 패턴으로 가져와 데이터베이스와 연결된 메서드를 호출합니다.
        MemberDAO memberDAO = MemberDAO.getInstance();
        // MemberDAO는 회원 정보와 관련된 DB 작업을 처리하는 객체입니다. getInstance() 메서드를 사용해 객체를 하나만 생성하는 싱글턴 패턴을 사용합니다.
        memberDAO.update(memberDTO);  // update 메서드를 호출해 memberDTO 객체의 데이터를 DB에 저장 (회원 정보 수정)
        // 회원 정보를 업데이트하기 위해 memberDTO 객체를 전달하며, 이를 기반으로 DB에 저장된 회원 정보를 수정합니다.
        // 이 메서드는 DB에 접근하여 SQL UPDATE 쿼리를 실행하고, 회원의 정보를 수정하는 작업을 담당합니다.

        // 회원정보 수정 후, 세션 초기화 작업
        HttpSession session = request.getSession();  // 현재 세션을 가져옵니다.
        session.invalidate();  // 세션을 무효화하여 로그아웃 상태로 만듭니다.
        // 사용자가 회원 정보를 수정한 후, 보안상 이유로 세션을 무효화하여 다시 로그인을 요구하는 것이 일반적입니다.
        // 세션을 초기화함으로써 사용자가 정보 수정 후 로그아웃되도록 처리할 수 있습니다.
        
        return "none";  
        // 리턴값으로 "none"을 반환하는데, 이는 특정 페이지로 이동하지 않도록 설정할 때 사용될 수 있습니다.
        // 'none'은 특정 JSP 페이지로 포워딩하지 않고, 서버에서 후속 처리가 이루어지지 않음을 나타낼 수 있습니다.
    }
}
