package school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 클래스 선언
public class SchoolMain {
	// 데이터베이스 연결 정보 및 객체들을 선언
	// 데이터베이스 연결을 위한 드라이버 클래스 이름
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// 데이터베이스 연결 URL, 'localhost'와 '1521'은 오라클 데이터베이스가 설치된 호스트와 포트를 나타냅니다. 'XE'는 데이터베이스 인스턴스 이름입니다.
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	// 데이터베이스 사용자 이름
	private String username = "C##JAVA";
	// 데이터베이스 비밀번호
	private String password = "1234";
	// Connection 객체는 데이터베이스와의 연결을 나타냅니다.
	private Connection con;
	// PreparedStatement 객체는 SQL 문을 실행하기 위한 객체입니다.
	private PreparedStatement pstmt;
	// ResultSet 객체는 SQL 쿼리의 결과를 저장하기 위한 객체입니다.
	private ResultSet rs;

	// 생성자 : 드라이버 로드하는 작업
	public SchoolMain() {
		try {
			// JDBC 드라이버를 메모리에 로드합니다.
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// 드라이버 클래스를 찾지 못했을 경우 예외를 처리합니다.
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결을 생성, Connection 객체 초기화
	public void getConnection() {
		try {
			// 데이터베이스 연결을 설정합니다.
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// 연결 실패 시 예외를 처리합니다.
			e.printStackTrace();
		}
	}

	// 메뉴 출력 및 사용자 입력 처리
	public void menu() {
		// Scanner 객체를 생성하여 사용자 입력을 받습니다.
		Scanner scan = new Scanner(System.in);
		// while 문을 통해 계속해서 메뉴를 출력하고 사용자 입력에 따라 적절한 메소드를 호출
		while (true) {
			// 메뉴를 출력합니다.
			System.out.println("****************");
			System.out.println("\t관리");
			System.out.println("****************");
			System.out.println("1. 입력");
			System.out.println("2. 검색");
			System.out.println("3. 삭제");
			System.out.println("4. 종료");
			System.out.println("****************");
			System.out.print("\t번호선택: ");
			// 사용자가 선택한 메뉴 번호를 입력받습니다.
			int choice = scan.nextInt();
			// 버퍼를 클리어합니다.
			scan.nextLine();

			if (choice == 1) {
				// 사용자가 1번을 선택한 경우 insertArticle 메소드를 호출합니다.
				insertArticle();
			} else if (choice == 2) {
				// 사용자가 2번을 선택한 경우 selectArticle 메소드를 호출합니다.
				selectArticle();
			} else if (choice == 3) {
				// 사용자가 3번을 선택한 경우 deleteArticle 메소드를 호출합니다.
				deleteArticle();
			} else if (choice == 4) {
				// 사용자가 4번을 선택한 경우 프로그램을 종료합니다.
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				// 잘못된 선택을 한 경우
				System.out.println("잘못된 선택입니다.");
			}
		}
	}

	// 데이터를 입력받아 데이터베이스에 삽입
	public void insertArticle() {
		// Scanner 객체를 생성하여 사용자 입력을 받습니다.
		Scanner scan = new Scanner(System.in);
		System.out.println("****************");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.println("****************");
		System.out.print("번호선택: ");
		// 사용자가 선택한 번호를 입력받습니다.
		int num = scan.nextInt();
		// 버퍼를 클리어합니다.
		scan.nextLine();

		// 초기화
		String name = "";
		String value = "";
		int code = 0;

		// 각 항목의 입력 프롬프트를 배열로 저장합니다.
		String[] str = {"이름 입력: ", "학번 입력: ", "과목 입력: ", "부서 입력: "};
		// 사용자가 선택한 번호에 따라 필요한 입력 항목을 배열로 매핑합니다.
		int[][] map = {{0, 1}, {0, 2}, {0, 3}}; // mapping[0]: 학생, mapping[1]: 교수, mapping[2]: 관리자

		if (num >= 1 && num <= 3) {
			// 선택된 번호에 따라 입력 항목을 처리합니다.
			for (int i = 0; i < map[num - 1].length; i++) {
				System.out.print(str[map[num - 1][i]]);
				if (i == 0) {
					// 첫 번째 항목인 이름을 입력받습니다.
					name = scan.nextLine();
				} else {
					// 두 번째 항목인 학번/과목/부서를 입력받습니다.
					value = scan.nextLine();
				}
			}
			// 코드 값을 설정합니다.
			code = num;
			// SQL 삽입 작업을 수행하기 위해 데이터베이스 연결을 호출합니다.
			getConnection();
			try {
				// SQL 삽입문을 준비합니다.
				pstmt = con.prepareStatement("INSERT INTO school (name, value, code) VALUES (?, ?, ?)");
				// 각 자리표시자에 값을 설정합니다.
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);
				// SQL 문을 실행하고 영향을 받은 행의 수를 반환합니다.
				int su = pstmt.executeUpdate();
				System.out.println(su + " 행이 삽입되었습니다.");
			} catch (SQLException e) {
				// SQL 실행 중 예외를 처리합니다.
				e.printStackTrace();
			} finally {
				try {
					// 자원을 해제합니다.
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (SQLException e) {
					// 자원 해제 중 예외를 처리합니다.
					e.printStackTrace();
				}
			}
		} else if (num == 4) {
			// 사용자가 이전 메뉴를 선택한 경우 메소드를 종료합니다.
			return;
		} else {
			// 잘못된 선택을 한 경우
			System.out.println("잘못된 선택입니다.");
		}
	}

	// 데이터를 입력받아 데이터베이스에서 삭제하는 메소드
	public void deleteArticle() {
		// Scanner 객체를 생성하여 사용자 입력을 받습니다.
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제를 원하는 이름 입력: ");
		// 삭제할 이름을 입력받습니다.
		String name = scan.nextLine();
		// SQL 삭제 작업을 수행하기 위해 데이터베이스 연결을 호출합니다.
		getConnection();
		try {
			// SQL 삭제문을 준비합니다.
			pstmt = con.prepareStatement("DELETE FROM school WHERE name = ?");
			// 자리표시자에 값을 설정합니다.
			pstmt.setString(1, name);
			// SQL 문을 실행하고 영향을 받은 행의 수를 반환합니다.
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 삭제되었습니다.");
		} catch (SQLException e) {
			// SQL 실행 중 예외를 처리합니다.
			e.printStackTrace();
		} finally {
			try {
				// 자원을 해제합니다.
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// 자원 해제 중 예외를 처리합니다.
				e.printStackTrace();
			}
		}
	}

	// 데이터를 검색하여 데이터베이스에서 조회하는 메소드
	public void selectArticle() {
		// Scanner 객체를 생성하여 사용자 입력을 받습니다.
		Scanner scan = new Scanner(System.in);
		System.out.println("****************");
		System.out.println("1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)");
		System.out.println("2. 전체 검색");
		System.out.println("3. 이전메뉴");
		System.out.println("****************");
		System.out.print("번호선택: ");
		// 사용자가 선택한 번호를 입력받습니다.
		int num = scan.nextInt();
		// 버퍼를 클리어합니다.
		scan.nextLine();

		if (num == 1) {
			// 사용자가 1번을 선택한 경우
			System.out.print("검색할 이름 입력: ");
			// 검색할 이름을 입력받습니다.
			String name = scan.nextLine();
			// SQL 검색 작업을 수행하기 위해 데이터베이스 연결을 호출합니다.
			getConnection();
			try {
				// SQL 검색문을 준비합니다.
				pstmt = con.prepareStatement("SELECT * FROM school WHERE name LIKE ?");
				// 자리표시자에 값을 설정합니다.
				pstmt.setString(1, "%" + name + "%");
				// SQL 문을 실행하고 결과를 ResultSet 객체로 반환합니다.
				rs = pstmt.executeQuery();
				// 결과가 있는 동안 반복합니다.
				while (rs.next()) {
					// 결과를 출력합니다.
					String resultName = rs.getString("name");
					String resultValue = rs.getString("value");
					int resultCode = rs.getInt("code");
					// 코드에 따라 출력 형식을 다르게 합니다.
					if (resultCode == 1) {
						System.out.println("이름 = " + resultName + " 학번 = " + resultValue);
					} else if (resultCode == 2) {
						System.out.println("이름 = " + resultName + " 과목 = " + resultValue);
					} else if (resultCode == 3) {
						System.out.println("이름 = " + resultName + " 부서 = " + resultValue);
					}
				}
			} catch (SQLException e) {
				// SQL 실행 중 예외를 처리합니다.
				e.printStackTrace();
			} finally {
				try {
					// 자원을 해제합니다.
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (SQLException e) {
					// 자원 해제 중 예외를 처리합니다.
					e.printStackTrace();
				}
			}
		} else if (num == 2) {
			// 사용자가 2번을 선택한 경우
			// SQL 검색 작업을 수행하기 위해 데이터베이스 연결을 호출합니다.
			getConnection();
			try {
				// SQL 검색문을 준비합니다.
				pstmt = con.prepareStatement("SELECT * FROM school");
				// SQL 문을 실행하고 결과를 ResultSet 객체로 반환합니다.
				rs = pstmt.executeQuery();
				// 결과가 있는 동안 반복합니다.
				while (rs.next()) {
					// 결과를 출력합니다.
					String resultName = rs.getString("name");
					String resultValue = rs.getString("value");
					int resultCode = rs.getInt("code");
					// 코드에 따라 출력 형식을 다르게 합니다.
					if (resultCode == 1) {
						System.out.println("이름 = " + resultName + " 학번 = " + resultValue);
					} else if (resultCode == 2) {
						System.out.println("이름 = " + resultName + " 과목 = " + resultValue);
					} else if (resultCode == 3) {
						System.out.println("이름 = " + resultName + " 부서 = " + resultValue);
					}
				}
			} catch (SQLException e) {
				// SQL 실행 중 예외를 처리합니다.
				e.printStackTrace();
			} finally {
				try {
					// 자원을 해제합니다.
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (SQLException e) {
					// 자원 해제 중 예외를 처리합니다.
					e.printStackTrace();
				}
			}
		} else if (num == 3) {
			// 사용자가 이전 메뉴를 선택한 경우 메소드를 종료합니다.
			return;
		} else {
			// 잘못된 선택을 한 경우
			System.out.println("잘못된 선택입니다.");
		}
	}

	// 프로그램의 시작점인 main 메소드
	public static void main(String[] args) {
		// SchoolMain 객체를 생성하고 menu 메소드를 호출하여 프로그램을 시작합니다.
		new SchoolMain().menu();
	}
}



/*

 [문제]
Java Project  : school
Package : school.dao
Class    : SchoolMain.java

# 테이블 작성
create table school (
name  varchar2(15)  not  null, -- 이름
value   varchar2(15), -- 학번 or 과목 or 부서
code   number   -- 1이면 학생, 2이면 교수, 3이면 관리자
);

menu()
 ****************
   관리
 ****************
  1. 입력
  2. 검색
  3. 삭제
  4. 종료
 ****************
  번호선택 : 4
프로그램 종료합니다

1번인 입력인 경우 - insertArticle()
 ****************
   1. 학생
   2. 교수
   3. 관리자
   4. 이전메뉴
 ****************
   번호선택 : 

1-1번 학생인 경우
이름 입력 : 
학번 입력 : 

1-2번 교수인 경우
이름 입력 : 
과목 입력 : 

1-3번 관리자인 경우
이름 입력 : 
부서 입력 : 

1 행이 삽입되었습니다.


2번 검색인 경우 - selectArticle()
 ****************
   1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)
   2. 전체 검색
   3. 이전메뉴
 ****************
   번호선택 : 1

2-1번 이름 검색인 경우
검색할 이름 입력 : 이
이름 = 이교수 과목= 자바
이름 = 이관리 부서= 기획
이름 = 이학생 학번= 2002

2-2번 전체 검색인 경우
이름 = 이교수 과목 = 자바
이름 = 코난 학번 = 2022
이름 = 홍길동 학번 = 2000
이름 = 이관리 부서 = 기획
이름 = 김교수 과목 = C
이름 = 이학생 학번 = 2002


3번 삭제인 경우 - deleteArticle()
삭제를 원하는 이름 입력 : (정확하게 3개의 글자가 모두 입력된 상태)
x개 행이 삭제되었습니다.


 */

/*

 주요 부분 설명
패키지 및 임포트:

package school.dao;
import java.sql.*;
import java.util.Scanner;
클래스 선언:

public class SchoolMain {
필드 선언:

데이터베이스 연결 정보 및 객체들을 선언합니다.
driver, url, username, password, con, pstmt
생성자:

public SchoolMain() { ... }
JDBC 드라이버를 로드합니다.
데이터베이스 연결 메소드:

public void getConnection() { ... }
데이터베이스 연결을 설정하고 Connection 객체를 초기화합니다.
메뉴 출력 및 사용자 입력 처리:

public void menu() { ... }
while 문을 통해 계속해서 메뉴를 출력하고 사용자 입력에 따라 적절한 메소드를 호출합니다.
if 문을 사용하여 사용자의 선택에 따라 insertArticle, deleteArticle 메소드를 호출하거나 프로그램을 종료합니다.
데이터 입력 메소드:

public void insertArticle() { ... }
사용자로부터 데이터를 입력받아 데이터베이스에 삽입합니다.
Scanner를 사용하여 사용자 입력을 받고, 이를 SQL 삽입문에 적용합니다.
데이터 삭제 메소드:

public void deleteArticle() { ... }
사용자로부터 이름을 입력받아 데이터베이스에서 해당 이름의 데이터를 삭제합니다.
Scanner를 사용하여 사용자 입력을 받고, 이를 SQL 삭제문에 적용합니다.
메인 메소드:

public static void main(String[] args) { ... }
SchoolMain 객체를 생성하고 menu 메소드를 호출하여 프로그램을 시작합니다.

 */
