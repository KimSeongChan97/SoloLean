package user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import user.bean.UserDTO;
import user.dao.UserDAO;

/*

public class UserDAOImpl implements UserDAO {
    
    // 템플릿 클래스
    // @Setter 어노테이션은 이 필드에 대한 setter 메서드를 자동으로 생성하여, 다른 클래스에서 이 객체를 주입할 수 있게 만듭니다.
    // jdbcTemplate은 스프링에서 제공하는 데이터베이스와 상호작용을 위한 도구입니다.
	@Setter // Lombok을 사용하여 Setter 메서드를 자동 생성. 스프링에서 의존성 주입을 받을 때 사용됨.
    private JdbcTemplate jdbcTemplate = null; 
    
    // 주석 처리된 부분은 Lombok의 @Setter로 대체되었습니다.
    // Lombok을 사용하지 않는다면 직접 setter 메서드를 구현해야 합니다. 아래는 수동으로 setter를 구현한 예시입니다.
    // public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @Override
    public void write(UserDTO userDTO) {
        // 사용자 정보를 데이터베이스에 삽입하는 SQL 쿼리
        // insert 쿼리를 사용하여 데이터베이스의 usertable에 새로운 사용자 데이터를 추가합니다.
        String sql = "insert into usertable values(?,?,?)";
        
        // jdbcTemplate.update() 메서드를 사용하여 데이터베이스에 데이터를 삽입함.
        // jdbcTemplate의 update 메서드는 SQL의 insert, update, delete와 같은 변경 작업을 처리할 수 있습니다.
        // 첫 번째 인자: 실행할 SQL 쿼리
        // 두 번째, 세 번째, 네 번째 인자는 각각 name, id, pwd 값을 설정
        // userDTO 객체의 get 메서드를 사용하여 name, id, pwd 필드 값을 꺼내와 SQL 쿼리에 전달합니다.
        jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); 
        // update 메서드는 insert, update, delete 작업을 모두 처리할 수 있음.
        // update 메서드는 변경이 필요한 레코드를 수정하고, 이때 몇 개의 레코드가 영향을 받았는지도 확인할 수 있습니다.
    }
    
    @Override
    public List<UserDTO> getUserList() {
        // 데이터베이스에서 사용자 목록을 조회하는 SQL 쿼리
        // 모든 사용자 정보를 조회하는 select 쿼리를 실행합니다. 모든 사용자의 정보가 usertable에 저장되어 있습니다.
        String sql = "select * from usertable";
        
        // jdbcTemplate.query() 메서드를 사용하여 쿼리 실행
        // 첫 번째 인자: 실행할 SQL 쿼리
        // 두 번째 인자: 결과를 UserDTO 객체로 매핑하는 BeanPropertyRowMapper를 사용
        // BeanPropertyRowMapper는 ResultSet의 컬럼명과 UserDTO의 필드명을 자동으로 매핑해줌
        // BeanPropertyRowMapper<UserDTO>를 통해 조회된 데이터를 UserDTO 객체로 변환하고, 이를 리스트에 저장합니다.
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
        // 이 메서드는 List<UserDTO> 형식의 데이터를 반환하며, 데이터베이스에 있는 사용자들의 모든 정보가 리스트 형태로 저장됩니다.
        // BeanPropertyRowMapper는 DB에서 조회한 데이터를 UserDTO의 필드에 자동으로 매핑해주기 때문에 편리합니다.
    }
    
    */
    

	/*
    public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
        // DaoSupport <- JdbcDaoSupport { private JdbcTemplate ... ; } <- UserDAOImpl
    	// 부모가 private 이기 때문에 접근 불가 이므로 메서드로 접근 해야한다. : getJdbcTemplate()
    	// JdbcDaoSupport
    	
        @Override
        public void write(UserDTO userDTO) {

            String sql = "insert into usertable values(?,?,?)";
            
            getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd()); // insert, update, delete

        }
        
        @Override
        public List<UserDTO> getUserList() {
            String sql = "select * from usertable";
            
            return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
            
        }
        
        */

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	// NamedParameterJdbcTemplate
	// NamedParameterJdbcDaoSupport는 NamedParameterJdbcTemplate을 사용하기 위한 기본 지원 클래스입니다.
	// NamedParameterJdbcTemplate은 SQL 쿼리에서 매개변수 이름을 명시적으로 사용할 수 있어 가독성이 좋고 관리가 용이합니다.
	
    @Override
    public void write(UserDTO userDTO) {
    	// Map을 사용하여 사용자 정보를 저장
    	// DTO에서 값을 가져와 name, id, pwd를 키로 설정하고 각 필드 값을 저장
    	Map<String, String> map = new HashMap<>();
    	map.put("name", userDTO.getName());
    	map.put("id", userDTO.getId());
    	map.put("pwd", userDTO.getPwd());
    	
        // SQL 쿼리에서 NamedParameter를 사용하여 매개변수를 명시적으로 지정
        String sql = "insert into usertable values(:name, :id, :pwd)";
        
        // NamedParameterJdbcTemplate을 사용하여 SQL 쿼리를 실행하고 사용자 데이터를 삽입
        getNamedParameterJdbcTemplate().update(sql, map);
        // insert, update, delete 작업은 모두 update() 메서드를 사용해 처리됩니다.
    }
    
    @Override
    public List<UserDTO> getUserList() {
        // 모든 사용자 정보를 조회하는 SQL 쿼리
        String sql = "select * from usertable";
        
        // JdbcTemplate을 사용하여 쿼리를 실행하고 결과를 UserDTO 리스트로 반환
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
        // BeanPropertyRowMapper는 ResultSet의 결과를 자동으로 UserDTO 객체에 매핑해줍니다.
    }
    
    @Override
    public UserDTO getExistId(String id) {
    	// 주어진 아이디에 해당하는 사용자를 조회하는 SQL 쿼리
    	String sql = "select * from usertable where id=?";
    	try {
    		
    		// JdbcTemplate의 queryForObject 메서드를 사용하여 단일 결과를 조회
    		return getJdbcTemplate().queryForObject(
    							sql,
    							new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
    							id);
    		
    		/*
    		// 직접 ResultSet에서 데이터를 추출하여 UserDTO 객체를 생성하는 방식도 가능
    		return getJdbcTemplate().queryForObject(
            							sql,
            							(rs, rowNum) -> {
	                                     UserDTO userDTO = new UserDTO();
	                                     userDTO.setId(rs.getString("id"));
	                                     userDTO.setName(rs.getString("name"));
	                                     userDTO.setPwd(rs.getString("pwd"));
	                                     return userDTO;
            							},
            							id);
    		*/
                                     
    	} catch(EmptyResultDataAccessException e) {
    		// 결과가 없는 경우 빈 결과를 처리
    		return null;
    	}
    }
    
    @Override
    public void update(Map<String, String> map) {
    	// 사용자 정보를 업데이트하는 SQL 쿼리
    	String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
    	
    	// NamedParameterJdbcTemplate을 사용하여 SQL 쿼리를 실행하고 데이터 업데이트
    	getNamedParameterJdbcTemplate().update(sql, map);
    }
    
    @Override
	public void delete(String id) {
		// 특정 아이디의 사용자를 삭제하는 SQL 쿼리
		String sql = "delete from usertable where id=?";
		
		// JdbcTemplate을 사용하여 쿼리를 실행하고 데이터 삭제
		getJdbcTemplate().update(sql, id);
	}
    
  
}
