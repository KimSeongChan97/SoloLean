package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	// 데이터베이스 연결을 위한 드라이버 클래스 이름
	private String driver = "oracle.jdbc.driver.OracleDriver";
	// 데이터베이스 연결 URL, 'localhost'와 '1521'은 오라클 데이터베이스가 설치된 호스트와 포트를 나타냅니다. 'XE'는 데이터베이스 인스턴스 이름입니다.
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	// 데이터베이스 사용자 이름
	private String username = "c##java";
	// 데이터베이스 비밀번호
	private String password = "1234";

	// Connection 객체는 데이터베이스와의 연결을 나타냅니다.
	private Connection con;
	// PreparedStatement 객체는 SQL 문을 실행하기 위한 객체입니다.
	private PreparedStatement pstmt;

	// 생성자: 드라이버를 로드하는 작업을 수행합니다.
	public UpdateMain() {
		try {
			// JDBC 드라이버를 메모리에 로드합니다.
			Class.forName(driver); // 드라이버 클래스 이름을 정확히 지정해야 합니다.
			System.out.println("driver loading 완료 !");
		} catch (ClassNotFoundException e) {
			// 드라이버 클래스가 발견되지 않으면 예외가 발생합니다.
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결을 생성하는 메소드
	public void getConnection() {
		try {
			// DriverManager를 통해 데이터베이스 연결을 설정합니다.
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connection 완료 !");
		} catch (SQLException e) {
			// 데이터베이스 연결이 실패하면 예외가 발생합니다.
			e.printStackTrace();
		}
	}

	// 데이터를 업데이트하는 메소드
	public void updateArticle() {
		// 사용자로부터 데이터를 입력받기 위해 Scanner 객체를 생성합니다.
		Scanner scan = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		String name = scan.next(); // 이름 입력받기

		// SQL 삽입 작업을 수행하기 위해 데이터베이스 연결을 호출합니다.
		getConnection(); // 데이터베이스 연결 메소드 호출

		try {
			// 이름에 '홍'이 포함된 레코드의 나이를 1 증가시키는 SQL 문을 작성합니다.
			pstmt = con.prepareStatement("update dbtest set age=age+1 where name like ?");

			// ?에 데이터를 매핑합니다.
			pstmt.setString(1, "%" + name + "%"); // 이름에 입력된 값이 포함된 레코드를 찾기 위해 와일드카드를 사용합니다.

			// SQL 문을 실행하고 영향을 받은 행의 수를 반환합니다.
			int su = pstmt.executeUpdate(); // SQL 문을 실행하고, 실행된 행의 수를 반환합니다.

			// 업데이트된 행의 수를 출력합니다.
			System.out.println(su + " 개의 행이 수정되었습니다.");

		} catch (SQLException e) {
			// SQL 예외가 발생하면 스택 트레이스를 출력합니다.
			e.printStackTrace();
		} finally {
			// 자원을 해제합니다.
			try {
				if(pstmt != null) pstmt.close(); // PreparedStatement 객체를 닫습니다.
				if(con != null) con.close(); // Connection 객체를 닫습니다.
			} catch (SQLException e) {
				// 자원 해제 중 예외가 발생하면 스택 트레이스를 출력합니다.
				e.printStackTrace();
			} 
		}
	}

	// 프로그램의 시작점인 main 메소드
	public static void main(String[] args) {
		// UpdateMain 객체를 생성하고, updateArticle 메소드를 호출하여 데이터 업데이트 작업을 시작합니다.
		new UpdateMain().updateArticle(); // 생성자 호출, updateArticle 메소드 호출
	}
}


