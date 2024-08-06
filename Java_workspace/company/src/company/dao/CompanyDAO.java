package company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import company.bean.CompanyDTO;

public class CompanyDAO {
	// 데이터베이스 연결에 필요한 정보들
	private String driver = "oracle.jdbc.driver.OracleDriver"; // 오라클 JDBC 드라이버 클래스
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 연결 URL
	private String user = "c##java"; // 데이터베이스 접속 사용자명
	private String password = "1234"; // 데이터베이스 접속 비밀번호

	private static CompanyDAO instance = new CompanyDAO(); // 싱글톤 패턴을 사용한 CompanyDAO 객체 생성

	//------------------------------------------------------------------------
	// 생성자: 객체가 생성될 때 JDBC 드라이버를 로드함
	public CompanyDAO() {
		try {
			Class.forName(driver); // JDBC 드라이버를 메모리에 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 드라이버 클래스가 없을 때 예외 처리
		}
	}

	//------------------------------------------------------------------------
	// 싱글톤 패턴: 유일한 인스턴스를 반환함
	public static CompanyDAO getInstance() {
		return instance; // 싱글톤 인스턴스를 반환
	}

	//------------------------------------------------------------------------
	// 클래스가 로드될 때 실행되는 초기화 블록
	static {    
		instance.initialize(); // 인스턴스 초기화 메서드 호출
	}

	//------------------------------------------------------------------------
	// 초기화 메서드: 데이터베이스 연결 후 company_status 테이블 초기화
		// 이 메서드는 데이터가 없는 경우에만 초기화를 수행하도록 조건을 설정함
		public void initialize() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url, user, password); // 데이터베이스 연결 설정
				// 데이터가 이미 있는지 확인
				String checkSql = "SELECT COUNT(*) FROM company_status";
				pstmt = con.prepareStatement(checkSql); // SQL 쿼리 준비
				rs = pstmt.executeQuery(); // SQL 쿼리 실행
				rs.next();
				int count = rs.getInt(1); // 테이블의 데이터 개수 확인

				// 데이터가 없는 경우에만 초기화를 수행
				if (count == 0) {
					String sql = "update company_status set status = '결근', reason = null";
					pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
					pstmt.executeUpdate(); // SQL 쿼리 실행
				}
			} catch (SQLException e) {
				e.printStackTrace(); // SQL 실행 중 예외 처리
			} finally {
				closeResources(rs, pstmt, con); // 자원 해제
			}
		}


	//------------------------------------------------------------------------
	// 데이터베이스 연결을 설정하는 메서드
	private Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password); // 데이터베이스 연결 설정
		} catch (SQLException e) {
			e.printStackTrace(); // 데이터베이스 연결 중 예외 처리
		}
		return con;
	}

	//------------------------------------------------------------------------
	// 자원 해제 메서드
	private void closeResources(AutoCloseable... resources) {
		for (AutoCloseable resource : resources) {
			if (resource != null) {
				try {
					resource.close(); // 자원 해제
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	//------------------------------------------------------------------------
	// 1. 입사 처리 메서드
	public void regist(String name, String id, String pw, String phone, String rank) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		try {
			// 회사 테이블에 새로운 직원 정보 삽입
			String sql = "insert into company values(?,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, name); // 첫 번째 ?에 이름 설정
			pstmt.setString(2, id); // 두 번째 ?에 아이디 설정
			pstmt.setString(3, pw); // 세 번째 ?에 비밀번호 설정
			pstmt.setString(4, phone); // 네 번째 ?에 전화번호 설정
			pstmt.setString(5, rank);
			pstmt.executeUpdate(); // SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}

		try {
			con = getConnection(); // 데이터베이스 연결
			// 회사 상태 테이블에 새로운 직원 상태 정보 삽입
			String sql2 = "insert into company_status (name, id, checkin_time, checkout_time, status, reason, "
					+ "late_count, early_leave_count, vacation_days) "
					+ "values (?, ?, to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI'), "
					+ "null, '결근', null, 0, 0, 0)";
			pstmt = con.prepareStatement(sql2); // SQL 쿼리 준비
			pstmt.setString(1, name); // 첫 번째 ?에 이름 설정
			pstmt.setString(2, id); // 두 번째 ?에 아이디 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}
	}

	//------------------------------------------------------------------------
	// 아이디 중복 체크 메서드
	public boolean isExistId(String id) {
		boolean exist = false;
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from company where id = ?"; // 아이디 중복 여부를 확인하는 SQL 쿼리
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			if(rs.next()) {
				exist = true; // 결과 집합에 데이터가 있으면 아이디가 중복됨
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
		return exist; // 아이디 중복 여부 반환
	}

	//------------------------------------------------------------------------
	// 사원 목록 출력 메서드
	public void list(CompanyDTO companyDTO) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식을 지정하는 객체
		String sql = "select company.name as company_name, company.id as company_id, company.regist_day, company.phone, "
				+ "company_status.status, company_status.late_count, company_status.early_leave_count "
				+ "from company join company_status on company.id = company_status.id"; // 사원 목록을 조회하는 SQL 쿼리
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				String id = rs.getString("company_id"); // 사원 아이디 가져오기
				String status = rs.getString("status"); // 출결 상태 가져오기
				if (isOnVacation(id)) { // 휴가 중인 경우 상태를 '휴가'로 변경
					status = "휴가";
				}
				// 사원 정보를 출력
				System.out.println(rs.getString("company_name") + "\t" + 
						rs.getString("company_id") + "\t" + 
						sdf.format(rs.getDate("regist_day")) + "\t" + 
						rs.getString("phone") + "\t" +
						status + "\t" +
						rs.getInt("late_count") + "\t" +
						rs.getInt("early_leave_count") + "\t" 
						);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
	}

	//------------------------------------------------------------------------
	// 출결 체크용 로그인 메서드
	public CompanyDTO login(String id, String pw) {
		String name = null;  
		String rank = null;
		CompanyDTO companyDTO = null;
		
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from company where id = ? and pw = ?"; // 아이디와 비밀번호로 로그인 확인하는 SQL 쿼리
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.setString(2, pw); // 두 번째 ?에 비밀번호 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				companyDTO = new CompanyDTO();
	            companyDTO.setName(rs.getString("name"));
	            companyDTO.setId(rs.getString("id"));
	            companyDTO.setPw(rs.getString("pw"));
	            companyDTO.setPhone(rs.getString("phone"));
	            companyDTO.setRegist_day(rs.getString("regist_day"));
	            companyDTO.setRank(rs.getString("rank"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
		return companyDTO; // 로그인된 사용자의 이름 반환
	}

	//------------------------------------------------------------------------
	// 출근 체크 메서드
	public void checkin(String id) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		if (isOnVacation(id)) {
			System.out.println("현재 휴가 중입니다. 출근할 수 없습니다.");
			return;
		}
		String sql = "update company_status set status = case when id = ? and sysdate <= to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI') "
				+ "then '출근' when id = ? and sysdate > to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI') "
				+ "then '지각' else status end,late_count = CASE "
				+ "WHEN sysdate > TO_DATE(TO_CHAR(sysdate, 'YYYY-MM-DD') || ' 09:00', 'YYYY-MM-DD HH24:MI') THEN late_count + 1 "
				+ "ELSE late_count END, checkin_time = sysdate where id = ?";
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.setString(2, id); // 두 번째 ?에 아이디 설정
			pstmt.setString(3, id); // 세 번째 ?에 아이디 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}

		try {
			con = getConnection(); // 데이터베이스 연결
			// 출근 기록을 attendance_log 테이블에 추가
			String sqlLog = "insert into attendance_log (id, action_type, action_time) values (?, '출근', sysdate)";
			pstmt = con.prepareStatement(sqlLog); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}
	}

	//------------------------------------------------------------------------
	// 퇴근 체크 메서드
	public void checkout(String id) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;

		if(isCheckin(id)) {
			System.out.println("아직 출근하지 않았습니다.");
			return;
		}
		if (isOnVacation(id)) {
			System.out.println("현재 휴가 중입니다. 퇴근할 수 없습니다.");
			return;
		}
		String sql = "update company_status set status = case when id = ? and sysdate <= to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 18:00', 'YYYY-MM-DD HH24:MI') "
				+ "then '조퇴' when id = ? and sysdate > to_date(to_char(sysdate, 'YYYY-MM-DD') || ' 18:00', 'YYYY-MM-DD HH24:MI') "
				+ "then '퇴근' else status end, early_leave_count = CASE "
				+ "WHEN sysdate < TO_DATE(TO_CHAR(sysdate, 'YYYY-MM-DD') || ' 18:00', 'YYYY-MM-DD HH24:MI') THEN early_leave_count + 1"
				+ "ELSE early_leave_count END, checkout_time = sysdate where id = ?";
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.setString(2, id); // 두 번째 ?에 아이디 설정
			pstmt.setString(3, id); // 세 번째 ?에 아이디 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
			 System.out.println("퇴근하셨습니다.");
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}

		try {
			con = getConnection(); // 데이터베이스 연결
			// 퇴근 기록을 attendance_log 테이블에 추가
			String sqlLog = "insert into attendance_log (id, action_type, action_time) values (?, '퇴근', sysdate)";
			pstmt = con.prepareStatement(sqlLog); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}
	}

	//------------------------------------------------------------------------
	// 출퇴근 기록 조회 메서드
	public void getAttendanceLogs(String id) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜 형식을 지정하는 객체
		String sql = "SELECT * FROM attendance_log WHERE id = ? ORDER BY action_time";
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				// 출퇴근 기록을 출력
				System.out.println(rs.getString("action_type") + "\t" + 
						sdf.format(rs.getDate("action_time")));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
	}
	//------------------------------------------------------------------------
	// 출근 여부 확인 메서드
	public boolean isAlreadyCheckedIn(String id) {
	    Connection con = getConnection(); // 데이터베이스 연결
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    boolean isCheckedIn = false; // 출근 여부를 저장할 변수
	    String sql = "SELECT * FROM attendance_log WHERE id = ? AND action_type = '출근' AND action_time >= TRUNC(sysdate)";
	    try {
	        pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
	        pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
	        rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
	        if (rs.next()) {
	            isCheckedIn = true; // 결과 집합에 데이터가 있으면 이미 출근한 상태
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // SQL 실행 중 예외 처리
	    } finally {
	        closeResources(rs, pstmt, con); // 자원 해제
	    }
	    return isCheckedIn; // 출근 여부 반환
	}

	// 퇴근 여부 확인 메서드
	public boolean isAlreadyCheckedOut(String id) {
	    Connection con = getConnection(); // 데이터베이스 연결
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    boolean isCheckedOut = false; // 퇴근 여부를 저장할 변수
	    String sql = "SELECT * FROM attendance_log WHERE id = ? AND action_type = '퇴근' AND action_time >= TRUNC(sysdate)";
	    try {
	        pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
	        pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
	        rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
	        if (rs.next()) {
	            isCheckedOut = true; // 결과 집합에 데이터가 있으면 이미 퇴근한 상태
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // SQL 실행 중 예외 처리
	    } finally {
	        closeResources(rs, pstmt, con); // 자원 해제
	    }
	    return isCheckedOut; // 퇴근 여부 반환
	}
	
	//------------------------------------------------------------------------
	// 휴가 설정 메서드
	public void setVacation(String id, int days, String startDate, String endDate) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO vacation (id, start_date, end_date, days) VALUES (?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.setDate(2, java.sql.Date.valueOf(startDate)); // 두 번째 ?에 시작 날짜 설정
			pstmt.setDate(3, java.sql.Date.valueOf(endDate)); // 세 번째 ?에 종료 날짜 설정
			pstmt.setInt(4, days); // 네 번째 ?에 휴가 일수 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(pstmt, con); // 자원 해제
		}
	}

	//------------------------------------------------------------------------
	// 휴가 상세 정보 조회 메서드
	public void getVacationDetails(String id) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM vacation WHERE id = ?";
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				// 휴가 정보 출력
				System.out.println("휴가 시작 날짜: " + rs.getDate("start_date") + 
						", 휴가 종료 날짜: " + rs.getDate("end_date") + 
						", 휴가 일수: " + rs.getInt("days"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
	}

	//------------------------------------------------------------------------
	// 휴가 중 여부 확인 메서드
	public boolean isOnVacation(String id) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean onVacation = false; // 휴가 여부를 저장할 변수
		//trunc() 함수는 시간 정보를 제거하여 오늘 날짜의 자정(00:00:00)을 나타낸대요
		String sql = "SELECT * FROM vacation WHERE id = ? AND start_date <= TRUNC(sysdate) and end_date >= trunc(sysdate)"; 
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			if (rs.next()) {
				onVacation = true; // 결과 집합에 데이터가 있으면 휴가 중임
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
		return onVacation; // 휴가 여부 반환
	}

	//------------------------------------------------------------------------
	// 퇴사 처리 메서드
	public String delete(String id, String pw) {
		String name = null; // 퇴사자의 이름을 저장할 변수
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 퇴사자의 이름을 가져오는 SQL 쿼리
			String sql1 = "select name from company where id = ? and pw = ?";
			pstmt = con.prepareStatement(sql1); // SQL 쿼리 준비
			pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
			pstmt.setString(2, pw); // 두 번째 ?에 비밀번호 설정
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				name = rs.getString("name"); // 결과 집합에서 이름 추출
			}
			if(name != null) {
				// 퇴사한 인원의 데이터를 leaveperson 테이블에 삽입
				String sql4 = "insert into leaveperson values(?, ?, (select regist_day from company where id = ?), sysdate)";
				pstmt = con.prepareStatement(sql4); // SQL 쿼리 준비
				pstmt.setString(1, name); // 첫 번째 ?에 이름 설정
				pstmt.setString(2, id); // 두 번째 ?에 아이디 설정
				pstmt.setString(3, id); // 세 번째 ?에 아이디 설정
				pstmt.executeUpdate(); // SQL 쿼리 실행
				
				//출결 로그 테이블에서 데이터 삭제
				String sql5 = "delete from attendance_log";
				pstmt = con.prepareStatement(sql5);
				pstmt.executeUpdate();
				
				//휴가 로그 테이블에서 데이터 삭제
				String sql6 = "delete from vacation";
				pstmt = con.prepareStatement(sql6);
				pstmt.executeUpdate();
				
				// 회사 테이블에서 데이터를 삭제
				String sql2 = "delete from company where id = ?";
				pstmt = con.prepareStatement(sql2); // SQL 쿼리 준비
				pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
				pstmt.executeUpdate(); // SQL 쿼리 실행

				// 회사 상태 테이블에서 데이터를 삭제
				String sql3 = "delete from company_status where id = ?";
				pstmt = con.prepareStatement(sql3); // SQL 쿼리 준비
				pstmt.setString(1, id); // 첫 번째 ?에 아이디 설정
				pstmt.executeUpdate(); // SQL 쿼리 실행
			}

		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
		return name; // 퇴사자의 이름 반환
	}

	//------------------------------------------------------------------------
	// 퇴사 사원 목록 출력 메서드
	public void leavelist(CompanyDTO companyDTO) {
		Connection con = getConnection(); // 데이터베이스 연결
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식을 지정하는 객체
		String sql = "select * from leaveperson"; // leaveperson 테이블에서 모든 데이터를 가져오는 SQL 쿼리
		try {
			pstmt = con.prepareStatement(sql); // SQL 쿼리 준비
			rs = pstmt.executeQuery(); // SQL 쿼리 실행하여 결과 집합 반환
			while(rs.next()) {
				// 결과 집합에서 각 행의 데이터를 출력
				System.out.println(rs.getString("name") + "\t"
						+ rs.getString("id") + "\t"
						+ sdf.format(rs.getDate("regist_day")) + "\t"
						+ sdf.format(rs.getDate("leave_day")));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQL 실행 중 예외 처리
		} finally {
			closeResources(rs, pstmt, con); // 자원 해제
		}
	}
	//------------------------------------------------------------------------
	// 퇴근 시 출근 여부 확인 메소드
	public boolean isCheckin(String id) {
	    // 데이터베이스 연결을 위한 Connection 객체 생성
	    Connection con = getConnection();
	    // PreparedStatement와 ResultSet 객체 초기화
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    // 출근 여부를 저장할 변수, 기본값은 true로 설정 (출근하지 않았다고 가정)
	    boolean ischeckin = true;
	    
	    // SQL 쿼리문: 특정 ID의 사원이 '출근' 또는 '지각' 상태인지 확인
	    String sql = "select * from company_status where id = ? and (status = '출근' or status = '지각')";
	    
	    try {
	        // PreparedStatement 객체에 SQL 쿼리문 설정
	        pstmt = con.prepareStatement(sql);
	        
	        // SQL 쿼리문의 첫 번째 파라미터에 id 값을 설정
	        pstmt.setString(1, id);
	        
	        // 쿼리 실행 후 결과를 ResultSet 객체에 저장
	        rs = pstmt.executeQuery();
	        
	        // ResultSet 객체에 데이터가 있으면 (즉, '출근' 또는 '지각' 상태이면)
	        if(rs.next()) {
	            // 출근 여부를 false로 설정 (출근 또는 지각 상태임을 의미)
	            ischeckin = false;
	        }
	    } catch (SQLException e) {
	        // SQL 실행 중 예외가 발생한 경우 스택 트레이스를 출력
	        e.printStackTrace();
	    } finally {
	        // 자원 해제를 위해 ResultSet, PreparedStatement, Connection 객체를 닫음
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            // 자원 해제 중 예외가 발생한 경우 스택 트레이스를 출력
	            e.printStackTrace();
	        }
	    }
	    // 출근 여부 반환
	    return ischeckin;
	}

	//------------------------------------------------------------------------
}
