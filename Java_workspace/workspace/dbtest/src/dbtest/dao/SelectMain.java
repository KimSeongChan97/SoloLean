package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {

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

	// ResultSet 객체는 쿼리 결과를 저장하고 이를 반복(iterate)하여 데이터를 추출하는데 사용됩니다.
	private ResultSet rs;

	// SelectMain 클래스의 생성자입니다.
	// 데이터베이스 드라이버를 로딩합니다.
	public SelectMain() {
		try {
			// 드라이버 클래스를 로딩합니다.
			Class.forName(driver);
			System.out.println("driver loading");
		} catch (ClassNotFoundException e) {
			// 드라이버 클래스를 찾지 못했을 때 예외를 처리합니다.
			e.printStackTrace();
		} 
	}

	// 데이터베이스 연결을 생성하는 메소드
	public void getConnection() {
		try {
			// DriverManager를 통해 데이터베이스 연결을 설정합니다.
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connection");
		} catch (SQLException e) {
			// 데이터베이스 연결이 실패하면 예외가 발생합니다.
			e.printStackTrace();
		}
	}

	// 데이터베이스에서 데이터를 조회하는 메소드입니다.
	public void selectArticle() {
		// 데이터베이스 연결을 생성합니다.
		getConnection(); 

		// 실행할 SQL 쿼리 문입니다.
		String sql = "select * from dbtest";

		try {
			// PreparedStatement 객체를 생성하여 SQL 쿼리를 준비합니다.
			pstmt = con.prepareStatement(sql);
			// SQL 쿼리를 실행하고 결과를 ResultSet 객체에 저장합니다.
			rs = pstmt.executeQuery();

			// ResultSet 객체를 반복하여 결과를 출력합니다.
			while(rs.next()) {
				// 각 열의 값을 가져와서 출력합니다.
				System.out.println(rs.getString("name") + "\t"
						+ rs.getInt("age") + "\t"
						+ rs.getDouble("height") + "\t"
						+ rs.getString("logtime"));
			}

		} catch (SQLException e) {
			// SQL 쿼리 실행 중 예외가 발생하면 예외를 처리합니다.
			e.printStackTrace();
		} finally {
			// 자원을 해제하기 위해 반대로 닫습니다.
			try {
				// ResultSet 객체를 닫습니다.
				if(rs != null) rs.close();
				// PreparedStatement 객체를 닫습니다.
				if(pstmt != null ) pstmt.close();
				// Connection 객체를 닫습니다.
				if(con != null ) con.close();
			} catch (SQLException e) {
				// 자원 해제 중 예외가 발생하면 스택 트레이스를 출력합니다.
				e.printStackTrace();
			}
		}
	}

	// main 메소드, 프로그램의 시작점입니다.
	public static void main(String[] args) {
		// SelectMain 객체를 생성하고 selectArticle 메소드를 호출하여 데이터베이스에서 데이터를 조회합니다.
		new SelectMain().selectArticle();
	}
}

