package school2.dao;
// 선생답안.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolMain2 {
	// 데이터베이스 연결에 필요한 정보들
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";

	// 데이터베이스 연결 객체들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자: JDBC 드라이버를 로드함
	public SchoolMain2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 메서드
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 메뉴를 표시하고 사용자로부터 입력을 받는 메서드
	public void menu() {
		Scanner scan = new Scanner(System.in);
		int num;

		while(true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("       관리");
			System.out.println("********************");
			System.out.println("   1. 입력");
			System.out.println("   2. 검색");
			System.out.println("   3. 삭제");
			System.out.println("   4. 종료");
			System.out.println("********************");
			System.out.print("  번호 선택 : ");
			num = scan.nextInt();

			if(num == 4) break; // 종료 선택 시 반복문 탈출
			if(num == 1) insertArticle(); // 입력 기능 호출
			else if(num == 2) selectArticle(); // 검색 기능 호출
			else if(num == 3) deleteArticle(); // 삭제 기능 호출
		}//while

	}//menu()

	// 삭제 기능 메서드
	private void deleteArticle() {
		System.out.println();
		Scanner scan = new Scanner(System.in);

		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();

		// 데이터베이스 연결
		getConnection();

		String sql = "delete from school where name = ?"; // 삭제 SQL 문
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();

			System.out.println(su + "개의 행이 삭제되었습니다."); // 삭제된 행 수 출력

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close(); // PreparedStatement 닫기
				if(con != null) con.close(); // Connection 닫기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//deleteArticle()

	// 검색 기능 메서드
	private void selectArticle() {
		Scanner scan = new Scanner(System.in);
		int num;

		while(true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("    1. 이름 검색  ");
			System.out.println("    2. 전체 검색  ");
			System.out.println("    3. 이전메뉴 ");
			System.out.println("********************");
			System.out.print("  번호선택 : ");
			num = scan.nextInt();

			if(num == 3) break; // 이전 메뉴로 돌아가기

			System.out.println();
			String name = null;
			if(num == 1) {
				System.out.print("검색할 이름 입력 : ");
				name = scan.next();
			}

			// 데이터베이스 연결
			getConnection();

			String sql;
			if(num == 1)
				sql = "SELECT * FROM SCHOOL WHERE NAME LIKE ?"; // 이름으로 검색
			else
				sql = "SELECT * FROM SCHOOL"; // 전체 검색

			try {
				pstmt = con.prepareStatement(sql);
				if(num == 1) pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery();

				while(rs.next()) {
					System.out.print("이름 = " + rs.getString("name") + "\t");

					if(rs.getInt("code") == 1)
						System.out.println("학번 = " + rs.getString("value"));
					else if(rs.getInt("code") == 2)
						System.out.println("과목 = " + rs.getString("value"));
					else if(rs.getInt("code") == 3)
						System.out.println("부서 = " + rs.getString("value")); 
				}//while

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close(); // ResultSet 닫기
					if(pstmt != null) pstmt.close(); // PreparedStatement 닫기
					if(con != null) con.close(); // Connection 닫기
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}//while

	}//selectArticle()

	// 입력 기능 메서드
	private void insertArticle() {
		Scanner scan = new Scanner(System.in);
		int num;

		while(true) {
			System.out.println();
			System.out.println("********************");
			System.out.println("    1. 학생  ");
			System.out.println("    2. 교수  ");
			System.out.println("    3. 관리자  ");
			System.out.println("    4. 이전메뉴 ");
			System.out.println("********************");
			System.out.print("  번호선택 : ");
			num = scan.nextInt();

			if(num == 4) break; // 이전 메뉴로 돌아가기

			System.out.println();
			String name = null;
			String value = "";
			System.out.print("이름 입력 : ");
			name = scan.next();

			if(num == 1) {
				System.out.print("학번 입력 : ");
				value = scan.next();

			}else if(num == 2) {
				System.out.print("과목 입력 : ");
				value = scan.next();

			}else if(num == 3) {
				System.out.print("부서 입력 : ");
				value = scan.next();

			}

			// 데이터베이스 연결
			getConnection();

			String sql = "insert into school values(?,?,?)"; // 삽입 SQL 문
			try {
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, num);

				int su = pstmt.executeUpdate();

				System.out.println(su + "개의 행이 삽입되었습니다."); // 삽입된 행 수 출력

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close(); // PreparedStatement 닫기
					if(con != null) con.close(); // Connection 닫기
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}//while

	}//insertArticle()

	public static void main(String[] args) {
		SchoolMain2 schoolMain2 = new SchoolMain2();
		schoolMain2.menu();
		System.out.println("프로그램을 종료합니다");
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