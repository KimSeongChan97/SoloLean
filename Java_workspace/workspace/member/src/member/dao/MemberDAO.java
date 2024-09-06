package member.dao;

import java.sql.Connection; // 데이터베이스 연결을 위해 필요
import java.sql.DriverManager; // 데이터베이스 연결을 설정하는 드라이버 관리자
import java.sql.PreparedStatement; // SQL 문을 실행하기 위해 필요
import java.sql.ResultSet; // SQL 쿼리의 결과를 저장하기 위해 필요
import java.sql.SQLException; // SQL 관련 예외 처리를 위해 필요
import java.util.Map; // Map 사용을 위해 필요

import member.bean.MemberDTO; // 데이터 전송 객체를 가져오기 위해 필요

public class MemberDAO {
	// 싱글톤 인스턴스를 위한 변수
	// MemberDAO 클래스의 유일한 인스턴스를 저장하기 위한 정적 변수입니다.
	private static MemberDAO instance;
	// 데이터베이스 연결을 위한 설정 정보
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String username = "C##JAVA";
	private String password = "1234";
	// 데이터베이스 연결과 SQL 실행을 위한 변수들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자를 private 으로 설정하여 외부에서 인스턴스를 생성하지 못하도록 함
	private MemberDAO() {
		try {
			Class.forName(driver); // JDBC 드라이버 로드
		} catch (ClassNotFoundException e) { // 드라이버 클래스를 찾지 못했을 때 예외 처리
			e.printStackTrace();
		}
	}

	// 싱글톤 인스턴스를 반환하는 메서드
	// 이 메서드는 MemberDAO 클래스의 유일한 인스턴스를 반환합니다.
	public static synchronized MemberDAO getInstance() {
		// 인스턴스가 아직 생성되지 않았다면 생성
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	// 데이터베이스 연결 메서드
	// 이 메서드는 데이터베이스와의 연결을 설정합니다.
	public void getConnection() {
		try { // 데이터베이스 연결 설정
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {// 데이터베이스 연결 실패 시 예외 처리
			e.printStackTrace();
		}
	}

	// 리소스 해제 메서드
	// 데이터베이스 관련 자원들을 해제하여 메모리 누수를 방지합니다.
	private void close() {
		try {
			if (rs != null) rs.close(); // ResultSet 해제
			if (pstmt != null) pstmt.close(); // PreparedStatement 해제
			if (con != null) con.close(); // Connection 해제
		} catch (SQLException e) { // 자원 해제 실패 시 예외 처리
			e.printStackTrace();
		}
	}

	// 데이터 삽입 메서드
	// 주어진 MemberDTO 객체를 데이터베이스에 삽입합니다.
	public int write(MemberDTO memberDTO) {
		int su = 0; // 삽입된 행의 수를 저장할 변수
		getConnection(); // 데이터베이스 연결 설정
		String sql = "INSERT INTO member (name, id, pwd, phone) VALUES (?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비 및 실행
			pstmt.setString(1, memberDTO.getName()); // 첫 번째 ?에 name 값 설정
			pstmt.setString(2, memberDTO.getId()); // 두 번째 ?에 id 값 설정
			pstmt.setString(3, memberDTO.getPwd()); // 세 번째 ?에 pwd 값 설정
			pstmt.setString(4, memberDTO.getPhone()); // 네 번째 ?에 phone 값 설정
			su = pstmt.executeUpdate(); // SQL 문 실행 후 삽입된 행의 수를 저장
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close();
		}
		return su; // 삽입된 행의 수를 반환
	}

	// 데이터 조회 메서드
	// 주어진 아이디와 비밀번호에 해당하는 회원 정보를 데이터베이스에서 조회합니다.
	// 비밀번호가 null일 경우, 아이디만으로 조회합니다.
	public MemberDTO selectMember(String id, String pwd) {
		getConnection(); // 데이터베이스 연결 설정
		// 비밀번호가 null이면 아이디만으로 조회하는 쿼리, 그렇지 않으면 아이디와 비밀번호로 조회하는 쿼리
		String sql = pwd != null ? "SELECT * FROM member WHERE id = ? AND pwd = ?" : "SELECT * FROM member WHERE id = ?";
		MemberDTO memberDTO = null; // 조회된 회원 정보를 저장할 MemberDTO 객체
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비 및 실행
			pstmt.setString(1, id); // 첫 번째 ?에 id 값 설정
			if (pwd != null) {
				pstmt.setString(2, pwd); // 두 번째 ?에 pwd 값 설정 (비밀번호가 있는 경우)
			}
			rs = pstmt.executeQuery(); // SQL 문 실행 및 결과 반환
			// 조회된 결과가 있을 경우 MemberDTO 객체 생성 및 데이터 설정
			if (rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name")); // 조회된 name 값 설정
				memberDTO.setId(rs.getString("id")); // 조회된 id 값 설정
				memberDTO.setPwd(rs.getString("pwd")); // 조회된 pwd 값 설정
				memberDTO.setPhone(rs.getString("phone")); // 조회된 phone 값 설정
			}
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close();
		}
		return memberDTO; // 조회된 MemberDTO 객체 반환
	}

	// 아이디 중복 체크 메서드 추가
	// 주어진 아이디가 데이터베이스에 존재하는지 여부를 확인합니다.
	public boolean isExistId(String id) {
		boolean exist = false; // 아이디 존재 여부를 저장할 변수
		getConnection(); // 데이터베이스 연결 설정
		String sql = "SELECT * FROM member WHERE id = ?";
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비 및 실행
			pstmt.setString(1, id); // 첫 번째 ?에 id 값 설정
			rs = pstmt.executeQuery(); // 현재 값 받아 SQL 문 실행 및 결과 반환
			if (rs.next()) { exist = true; } // 아이디가 존재하면 true 반환
		} catch (SQLException e) {// SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close();
		}
		return exist; // 아이디 존재 여부 반환
	}

	public String login(String id, String pwd) {
		String name = null; // 로그인된 사용자의 이름을 저장할 변수
		getConnection(); // 데이터베이스 연결
		String sql = "SELECT name FROM member WHERE id = ? AND pwd = ?";
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비
			pstmt.setNString(1, id); // 첫 번째 파라미터에 id 설정
			pstmt.setNString(2, pwd); // 두 번째 파라미터에 pwd 설정
			rs = pstmt.executeQuery(); // 쿼리 실행 및 결과 반환
			if (rs.next()) { // 결과가 있는 경우
				name = rs.getString("name"); // 결과에서 이름 컬럼의 값을 가져옴
			} else {
				name = null; // 결과가 없으면 name 을 null 로 설정
			}
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace(); // 예외 스택 트레이스 출력
		} finally { // 자원 해제
			close(); // 데이터베이스 연결 닫기
		}

		return name; // 로그인된 사용자의 이름을 반환, 로그인 실패 시 null 반환
	}

	// 아이디로 회원 정보를 조회하는 메서드 추가
	public MemberDTO getMember(String id) {
		MemberDTO memberDTO = null; // 조회된 회원 정보를 저장할 객체
		getConnection(); // 데이터베이스 연결 설정
		String sql = "SELECT * FROM member WHERE id = ?"; // SQL 쿼리문
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비
			pstmt.setString(1, id); // ?에 아이디 값 설정
			rs = pstmt.executeQuery(); // 쿼리 실행 및 결과 반환
			if (rs.next()) { // 결과가 있는 경우
				memberDTO = new MemberDTO(); // MemberDTO 객체 생성
				memberDTO.setName(rs.getString("name")); // name 값 설정
				memberDTO.setId(rs.getString("id")); // id 값 설정
				memberDTO.setPwd(rs.getString("pwd")); // pwd 값 설정
				memberDTO.setPhone(rs.getString("phone")); // phone 값 설정
			}
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close();
		}
		return memberDTO; // 조회된 회원 정보 반환
	}

	// 비밀번호 확인 메서드 ----------------------------------------------------
	// 주어진 아이디와 비밀번호가 일치하는지 여부를 확인합니다.
	public boolean TruePwd(String id, String pwd) {
		getConnection(); // 데이터베이스 연결 설정
		String sql = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		boolean TruePwd = false; // 비밀번호 일치 여부를 저장할 변수
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비 및 실행
			pstmt.setString(1, id); // 첫 번째 ?에 id 값 설정
			pstmt.setString(2, pwd); // 두 번째 ?에 pwd 값 설정
			rs = pstmt.executeQuery(); // SQL 문 실행 및 결과 반환
			if (rs.next()) { // 조회된 결과가 있을 경우
				TruePwd = true; // 아이디와 비밀번호가 일치함
			}
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close();
		}
		return TruePwd; // 비밀번호 일치 여부 반환
	}

	// 회원 정보 삭제 메서드
	// 주어진 아이디에 해당하는 회원 정보를 데이터베이스에서 삭제합니다.
	public int deleteMember(String id) {
		int su = 0; // 삭제 결과를 저장할 변수
		getConnection(); // 데이터베이스 연결 설정
		String sql = "DELETE FROM member WHERE id = ?"; // SQL 쿼리문: 주어진 아이디에 해당하는 회원 정보를 삭제
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 값 설정
			su = pstmt.executeUpdate(); // 삭제 실행 및 결과 반환
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close(); // 데이터베이스 연결 닫기
		}
		return su; // 삭제 결과 반환, 삭제된 행의 수를 반환
	} // ------------------------------------------------------------------

	// 회원 정보 업데이트 메서드
	// 주어진 Map 객체를 사용하여 회원 정보를 업데이트합니다.
	public int update(Map<String, String> map) {
		int su = 0; // 업데이트된 행의 수를 저장할 변수
		getConnection(); // 데이터베이스 연결 설정
		String sql = "UPDATE member SET name = ?, pwd = ?, phone = ? WHERE id = ?"; // SQL 쿼리문
		try {
			pstmt = con.prepareStatement(sql); // SQL 문 준비
			pstmt.setString(1, map.get("name")); // 첫 번째 ?에 name 값 설정
			pstmt.setString(2, map.get("pwd")); // 두 번째 ?에 pwd 값 설정
			pstmt.setString(3, map.get("phone")); // 세 번째 ?에 phone 값 설정
			pstmt.setString(4, map.get("id")); // 네 번째 ?에 id 값 설정
			su = pstmt.executeUpdate(); // 업데이트 실행 및 결과 반환
		} catch (SQLException e) { // SQL 실행 실패 시 예외 처리
			e.printStackTrace();
		} finally { // 자원 해제
			close();
		}
		return su; // 업데이트된 행의 수를 반환
	}
}
