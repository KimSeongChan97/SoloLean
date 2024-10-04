package user.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	// 템플릿 클래스
	@Setter // Lombok을 사용하여 Setter 메서드를 자동 생성. 스프링에서 의존성 주입을 받을 때 사용됨.
	private JdbcTemplate jdbcTemplate = null; 
	
//	주석 처리된 부분은 Lombok의 @Setter로 대체되었습니다. 
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public void write(UserDTO userDTO) {
		// 사용자 정보를 데이터베이스에 삽입하는 SQL 쿼리
		String sql = "insert into usertable values(?,?,?)";
		
		// jdbcTemplate.update() 메서드를 사용하여 데이터베이스에 데이터를 삽입함.
		// 첫 번째 인자: 실행할 SQL 쿼리
		// 두 번째, 세 번째, 네 번째 인자는 각각 name, id, pwd 값을 설정
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); 
		// update 메서드는 insert, update, delete 작업을 모두 처리할 수 있음.
	}
	
	@Override
	public List<UserDTO> getUserList() {
		// 데이터베이스에서 사용자 목록을 조회하는 SQL 쿼리
		String sql = "select * from usertable";
		
		// jdbcTemplate.query() 메서드를 사용하여 쿼리 실행
		// 첫 번째 인자: 실행할 SQL 쿼리
		// 두 번째 인자: 결과를 UserDTO 객체로 매핑하는 BeanPropertyRowMapper를 사용
		// BeanPropertyRowMapper는 ResultSet의 컬럼명과 UserDTO의 필드명을 자동으로 매핑해줌
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
}
