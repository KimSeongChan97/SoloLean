package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    // 이 변수는 오라클 데이터베이스와 연결하기 위해 필요한 JDBC 드라이버의 클래스 이름을 지정합니다.
    // 이 클래스를 사용하여 Java 프로그램이 오라클 데이터베이스와 통신할 수 있게 됩니다.
    // 예를 들어, 이 드라이버는 SQL 문을 오라클 데이터베이스로 전송하고, 그 결과를 받아오는 역할을 합니다.
    
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // 오라클 데이터베이스에 연결하기 위한 URL을 지정합니다.
    // 이 URL은 오라클 서버의 위치를 나타내며, 'thin' 드라이버를 통해 데이터베이스와의 직접적인 연결을 설정합니다.
    // 여기서 'localhost'는 데이터베이스가 로컬 머신에서 실행 중임을 의미하고, '1521'은 오라클의 기본 포트입니다.
    // 'xe'는 오라클 익스프레스 에디션(Express Edition)의 SID를 나타냅니다.

    private String username = "c##java";
    // 데이터베이스에 연결하기 위한 사용자 이름을 나타냅니다.
    // 이 이름은 데이터베이스에 정의된 사용자의 계정 이름으로, 이 계정에 접근할 권한을 나타냅니다.

    private String password = "1234";
    // 데이터베이스에 연결하기 위한 비밀번호를 지정합니다.
    // 이 비밀번호는 해당 사용자 계정에 대한 인증을 제공하며, 연결을 허용하는 데 사용됩니다.

    private Connection con;
    // 이 변수는 데이터베이스와의 연결을 나타내는 객체입니다.
    // Connection 객체를 통해 데이터베이스와의 연결을 관리하고, SQL 명령을 실행할 수 있습니다.
    // 예를 들어, 이 객체를 통해 SQL 쿼리를 데이터베이스로 전송하고, 그 결과를 받아올 수 있습니다.

    private PreparedStatement pstmt;
    // PreparedStatement는 SQL 문을 실행하기 위한 객체입니다.
    // 이 객체는 미리 컴파일된 SQL 문을 실행하여 성능을 높이고, SQL 인젝션 공격을 방지할 수 있습니다.
    // SQL 문에서 파라미터를 바인딩하여 실행할 수 있어, 데이터베이스 작업을 더욱 안전하게 수행할 수 있습니다.

    private ResultSet rs;
    // ResultSet 객체는 SQL 쿼리의 결과를 저장하는 데 사용됩니다.
    // SELECT 문을 실행한 후, 반환된 데이터는 ResultSet에 저장되며, 이 데이터를 통해 데이터베이스에서 조회된 결과를 처리할 수 있습니다.
    // 예를 들어, 데이터베이스에서 특정 조건에 맞는 데이터를 가져올 때, 이 객체에 결과가 저장됩니다.

    private static GuestbookDAO guestbookDAO = new GuestbookDAO();
    // 이 클래스는 싱글톤 패턴을 사용하여 하나의 인스턴스만 생성되도록 설계되었습니다.
    // 싱글톤 패턴을 통해 애플리케이션 전역에서 이 DAO 객체를 재사용할 수 있어, 불필요한 객체 생성으로 인한 자원 낭비를 방지할 수 있습니다.
    // 예를 들어, 데이터베이스 연결 관리를 하나의 객체에서만 처리하여 시스템의 효율성을 높일 수 있습니다.

    public static GuestbookDAO getInstance() {
        return guestbookDAO;
        // 이 메서드는 GuestbookDAO의 유일한 인스턴스를 반환합니다.
        // 이를 통해 다른 클래스에서 이 인스턴스를 재사용할 수 있으며, 새로운 인스턴스를 생성할 필요가 없습니다.
    }

    public GuestbookDAO() {
        try {
            Class.forName(driver);
            // 이 코드는 JDBC 드라이버 클래스를 메모리에 로드하여 데이터베이스와의 연결을 준비합니다.
            // Class.forName() 메서드는 드라이버 클래스를 동적으로 로드하여, 드라이버가 프로그램 내에서 사용될 수 있도록 합니다.
            // 이 작업은 데이터베이스와의 통신을 시작하기 전에 반드시 수행되어야 합니다.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // 드라이버 클래스가 클래스패스에 없거나 로드되지 못했을 때 예외가 발생합니다.
            // 이 예외를 처리하여, 드라이버 로딩에 실패했음을 알려주고 문제를 해결할 수 있는 단서를 제공합니다.
        }
    }

    public Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, username, password);
            // DriverManager는 데이터베이스에 대한 연결을 설정하는 클래스입니다.
            // getConnection() 메서드는 지정된 URL, 사용자 이름, 비밀번호를 사용하여 데이터베이스에 연결합니다.
            // 연결이 성공하면, Connection 객체가 반환되고, 이 객체를 통해 데이터베이스와의 모든 통신이 이루어집니다.
        } catch (SQLException e) {
            e.printStackTrace();
            // 데이터베이스에 연결하는 중에 오류가 발생하면 예외가 발생합니다.
            // 예를 들어, 데이터베이스 서버가 실행 중이 아니거나, 네트워크에 문제가 있을 때 이 예외가 발생할 수 있습니다.
        }
        return con;
        // Connection 객체를 반환합니다. 이 객체는 데이터베이스와의 연결을 나타내며, SQL 문을 실행하는 데 사용됩니다.
    }

    public void guestbookWrite(GuestbookDTO guestbookDTO) {
        getConnection();
        // 이 메서드를 호출하여 데이터베이스에 연결합니다.
        // 연결이 성공하면 SQL 문을 실행할 준비가 완료됩니다.
        
        String sql = """
            insert into guestbook values(seq_guestbook.nextval, ?,?,?,?,?, sysdate)
            """;
        // SQL INSERT 문을 정의합니다. 이 문은 guestbook 테이블에 새 레코드를 삽입합니다.
        // 여기서는 seq_guestbook.nextval을 사용하여 고유 시퀀스 값을 자동으로 증가시키며, 
        // ?는 나중에 바인딩될 파라미터를 나타냅니다. SYSDATE는 현재 날짜와 시간을 삽입합니다.

        try {
            pstmt = con.prepareStatement(sql); // 생성
            // PreparedStatement 객체를 생성합니다. 이 객체는 SQL 문을 실행하는 데 사용됩니다.
            // 이 시점에서 SQL 문은 아직 실행되지 않았으며, 파라미터 바인딩이 완료된 후 실행됩니다.

            // ?에 데이터 대입
            pstmt.setString(1, guestbookDTO.getName());
            pstmt.setString(2, guestbookDTO.getEmail());
            pstmt.setString(3, guestbookDTO.getHomepage());
            pstmt.setString(4, guestbookDTO.getSubject());
            pstmt.setString(5, guestbookDTO.getContent());
            // 위의 각 setString() 메서드는 PreparedStatement 객체에 파라미터를 바인딩하는 과정입니다.
            // ?로 표시된 부분에 실제 값을 채워 넣어 SQL 문이 완성됩니다.
            // 예를 들어, 첫 번째 ?에는 사용자의 이름이, 두 번째 ?에는 이메일이 대입됩니다.

            pstmt.executeUpdate(); // 실행 - 개수 리턴
            // SQL INSERT 문을 실행하여 데이터베이스에 새로운 레코드를 삽입합니다.
            // executeUpdate() 메서드는 영향을 받은 행의 수를 반환하지만, 여기서는 반환값을 사용하지 않습니다.

        } catch (SQLException e) {
            e.printStackTrace();
            // SQL 문을 실행하는 동안 오류가 발생하면 예외가 발생합니다.
            // 예를 들어, 데이터베이스에 중복된 키가 존재하거나, 테이블 구조에 문제가 있을 때 발생할 수 있습니다.
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
                // 사용한 자원을 해제합니다. PreparedStatement와 Connection 객체는 사용이 끝나면 반드시 닫아야 합니다.
                // 이를 통해 메모리 누수 및 데이터베이스 연결이 불필요하게 유지되는 것을 방지할 수 있습니다.
            } catch (SQLException e) {
                e.printStackTrace();
                // 자원을 해제하는 과정에서 오류가 발생하면 예외가 발생합니다.
                // 이러한 예외는 드물지만, 발생 시 시스템에 문제를 일으킬 수 있으므로 적절히 처리해야 합니다.
            }
        }
    }

    public List<GuestbookDTO> getAllGuestbooks(int startNum, int endNum) {
        List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
        // 방명록 데이터를 저장할 ArrayList 객체를 생성합니다.
        // 이 리스트는 방명록의 각 항목을 DTO 객체로 저장하여 반환합니다.

        getConnection();
        // 데이터베이스에 연결합니다. 이 메서드를 통해 SQL 문을 실행할 준비를 합니다.

        String sql = """
            select * from
            (select rownum rn, tt.* from
            (select * from guestbook order by seq desc) tt
            ) where rn >= ? and rn <= ?
            """;
        // 방명록의 특정 범위(startNum부터 endNum까지)를 가져오기 위한 SQL 쿼리를 정의합니다.
        // rownum을 사용하여 각 행에 번호를 매기고, 원하는 범위의 행만 선택합니다.
        // 이 쿼리는 최신 항목이 먼저 나올 수 있도록 seq 열을 기준으로 내림차순으로 정렬합니다.

        try {
            pstmt = con.prepareStatement(sql);
            // PreparedStatement 객체를 생성합니다.
            // SQL 쿼리를 미리 컴파일하여 성능을 높이고, 파라미터 바인딩을 통해 SQL 인젝션 공격을 방지합니다.

            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            // 쿼리의 ? 자리에 startNum과 endNum 값을 대입하여 범위를 지정합니다.
            // 이 값들은 사용자가 요청한 페이지 번호에 따라 계산된 값일 수 있습니다.

            rs = pstmt.executeQuery();
            // SQL 쿼리를 실행하여 결과를 ResultSet 객체에 저장합니다.
            // ResultSet 객체는 데이터베이스에서 조회된 결과를 포함하며, 이 데이터를 통해 방명록 항목을 가져올 수 있습니다.

            while(rs.next()) {
                GuestbookDTO guestbookDTO = new GuestbookDTO();
                guestbookDTO.setSeq(rs.getInt("seq"));
                guestbookDTO.setName(rs.getString("name"));
                guestbookDTO.setEmail(rs.getString("email"));
                guestbookDTO.setHomepage(rs.getString("homepage"));
                guestbookDTO.setSubject(rs.getString("subject"));
                guestbookDTO.setContent(rs.getString("content"));
                guestbookDTO.setLogtime(rs.getDate("logtime"));
                // ResultSet에서 데이터를 추출하여 각 항목을 GuestbookDTO 객체에 설정합니다.
                // 이 작업을 통해 데이터베이스의 각 레코드가 자바 객체로 변환되어 리스트에 저장됩니다.

                list.add(guestbookDTO);
                // 리스트에 DTO 객체를 추가합니다.
                // 최종적으로 이 리스트는 모든 방명록 항목을 포함하게 됩니다.
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            list = null;
            // SQL 문을 실행하는 중 오류가 발생하면 예외가 발생합니다.
            // 이 경우, null을 반환하여 문제가 발생했음을 호출자에게 알립니다.
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
                // 사용한 자원(ResultSet, PreparedStatement, Connection)을 해제합니다.
                // 이는 자원 누수를 방지하고, 시스템 성능을 최적화하는 데 중요합니다.
            } catch (SQLException e) {
                e.printStackTrace();
                // 자원을 해제하는 과정에서 오류가 발생하면 예외가 발생합니다.
                // 이 예외는 자원을 제대로 해제하지 못했음을 나타내며, 시스템 자원을 낭비할 수 있습니다.
            }
        }
        
        return list;
        // 방명록 항목이 담긴 리스트를 반환합니다.
        // 이 리스트는 클라이언트에 전달되어 방명록 페이지에 출력됩니다.
    }

    public int getTotal() {
        int total = 0;
        // 방명록 항목의 총 개수를 저장할 변수를 초기화합니다.

        try {
            con = getConnection();
            String sql = "select count(*) from guestbook";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // SQL 쿼리를 실행하여 guestbook 테이블의 총 레코드 수를 가져옵니다.

            if (rs.next()) {
                total = rs.getInt(1);
                // 쿼리 결과에서 첫 번째 값을 가져와 total 변수에 저장합니다.
                // 이 값은 방명록에 작성된 총 글 수를 나타냅니다.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // SQL 문을 실행하는 중 오류가 발생하면 예외가 발생합니다.
            // 예를 들어, 데이터베이스 연결 오류 또는 쿼리 실행 오류가 있을 수 있습니다.
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
                // 사용한 자원(ResultSet, PreparedStatement, Connection)을 해제합니다.
                // 이를 통해 시스템 자원을 효율적으로 관리하고, 성능 저하를 방지할 수 있습니다.
            } catch (SQLException e) {
                e.printStackTrace();
                // 자원을 해제하는 과정에서 오류가 발생하면 예외가 발생합니다.
                // 이 예외는 시스템 성능에 영향을 줄 수 있으므로 적절히 처리해야 합니다.
            }
        }
        return total;
        // 방명록의 총 글 수를 반환합니다.
        // 이 값은 클라이언트에게 전달되어 페이지 수 계산 등에 사용될 수 있습니다.
    }
}

