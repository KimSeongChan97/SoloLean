package user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}
	/*
	@Autowired: Spring이 DataSource 빈을 자동으로 주입해주는 어노테이션입니다.
	DataSource는 데이터베이스와의 연결을 관리하는 객체로, Spring이 자동으로 생성 및 관리합니다.
	이 메서드를 통해 JDBC의 DataSource를 NamedParameterJdbcDaoSupport 클래스에 설정합니다.

	추가 설명:
	- DataSource는 데이터베이스 연결 풀을 관리하고, 애플리케이션이 데이터베이스에 연결할 때마다 사용됩니다.
	- setDataSource 메서드는 NamedParameterJdbcDaoSupport가 상속받은 메서드로, 이 메서드를 통해 데이터베이스 연결을 관리하는 DataSource 객체를 설정합니다.
	*/

    @Override
    public void write(UserDTO userDTO) {
        Map<String, String> map = new HashMap<>();
        map.put("name", userDTO.getName());
        map.put("id", userDTO.getId());
        map.put("pwd", userDTO.getPwd());
        /*
        userDTO 객체에서 이름, ID, 비밀번호 정보를 가져와서, 이를 Map에 저장합니다.
        여기서 Map은 SQL 쿼리에서 사용할 파라미터와 그 값을 저장하기 위한 자료 구조입니다.
        key 값("name", "id", "pwd")은 SQL 쿼리에서 사용될 파라미터 이름과 일치해야 합니다.
        
        추가 설명:
        - Map 자료구조는 키-값 쌍으로 데이터를 저장합니다. 여기서는 name, id, pwd라는 키와 각각의 값을 저장하여 SQL 쿼리에서 사용합니다.
        */

        String sql = "insert into usertable values(:name, :id, :pwd)";
        /*
        SQL 쿼리를 정의합니다. 이 SQL 쿼리는 usertable 테이블에 name, id, pwd 값을 삽입(insert)하는 쿼리입니다.
        여기서 ":name", ":id", ":pwd"는 Map에서 해당 값들을 가져와서 바인딩됩니다.
        */

        getNamedParameterJdbcTemplate().update(sql, map);
        /*
        getNamedParameterJdbcTemplate() 메서드를 사용하여 SQL 쿼리를 실행합니다. 이 메서드는 이름 기반 파라미터를 사용할 수 있게 해줍니다.
        두 번째 파라미터인 map을 통해, SQL 쿼리 내의 파라미터(:name, :id, :pwd)에 실제 값을 전달합니다.

        추가 설명:
        - NamedParameterJdbcTemplate은 쿼리에서 파라미터 이름을 명시적으로 사용하여 가독성을 높입니다.
        - Map을 전달함으로써 SQL 쿼리의 ":name", ":id", ":pwd"가 각각의 값으로 대체됩니다.
        */
    }

    @Override
    public List<UserDTO> getUserList() {
        String sql = "select * from usertable";
        /*
        SQL 쿼리를 정의합니다. 이 쿼리는 usertable 테이블에 있는 모든 데이터를 선택(select)합니다.
        */

        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
        /*
        getJdbcTemplate().query 메서드를 사용하여 SQL 쿼리를 실행하고, 결과를 UserDTO 객체의 리스트로 변환하여 반환합니다.
        BeanPropertyRowMapper는 SQL 결과를 UserDTO 객체의 프로퍼티에 자동으로 매핑해줍니다.

        추가 설명:
        - BeanPropertyRowMapper는 SQL 결과의 컬럼 이름과 UserDTO 객체의 필드 이름을 자동으로 매핑해주는 역할을 합니다.
        - 즉, 쿼리 결과를 UserDTO 객체로 자동 변환해주므로 편리합니다.
        - 이 메서드는 UserDTO 객체의 리스트(List<UserDTO>)를 반환합니다.
        */
    }

    @Override
    public UserDTO getExistId(String id) {
        String sql = "select * from usertable where id=?";
        /*
        SQL 쿼리를 정의합니다. 이 쿼리는 usertable 테이블에서 특정 id 값을 가진 레코드를 선택합니다.
        물음표(?)는 SQL 파라미터로, 나중에 실제 값(id)으로 대체됩니다.
        */

        try {
            return getJdbcTemplate().queryForObject(
                            sql,
                            new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
                            id);
            /*
            getJdbcTemplate().queryForObject 메서드를 사용하여 SQL 쿼리를 실행하고, 단일 결과를 UserDTO 객체로 반환합니다.
            세 번째 파라미터인 id 값이 SQL 쿼리의 물음표(?)에 바인딩됩니다.
            BeanPropertyRowMapper를 사용하여 SQL 결과를 UserDTO 객체로 자동 매핑합니다.

            추가 설명:
            - queryForObject는 단일 행의 결과를 반환할 때 사용됩니다.
            - id 값이 물음표(?) 자리에 들어가 SQL 쿼리가 실행됩니다.
            */
        } catch(EmptyResultDataAccessException e) {
            return null;
            /*
            만약 쿼리 결과가 존재하지 않을 경우, EmptyResultDataAccessException이 발생합니다.
            이 예외를 잡아(null을 반환함으로써) 프로그램이 중단되지 않도록 처리합니다.
            */
        }
    }

    @Override
    public void update(Map<String, String> map) {
        String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
        /*
        SQL 쿼리를 정의합니다. 이 쿼리는 usertable 테이블에서 특정 id 값을 가진 레코드를 업데이트합니다.
        name과 pwd 값은 Map에서 가져와서 바인딩됩니다.
        */

        getNamedParameterJdbcTemplate().update(sql, map);
        /*
        getNamedParameterJdbcTemplate().update 메서드를 사용하여 SQL 쿼리를 실행하고, Map에서 파라미터 값을 가져와 SQL 쿼리에 바인딩합니다.
        map에서 전달된 name, pwd, id 값이 SQL 쿼리에 매핑되어 업데이트 작업이 실행됩니다.
        */
    }

    @Override
    public void delete(String id) {
        String sql = "delete from usertable where id=?";
        /*
        SQL 쿼리를 정의합니다. 이 쿼리는 특정 id 값을 가진 레코드를 usertable 테이블에서 삭제(delete)합니다.
        */

        getJdbcTemplate().update(sql, id);
        /*
        getJdbcTemplate().update 메서드를 사용하여 SQL 쿼리를 실행하고, id 값을 SQL 쿼리에 바인딩하여 해당 레코드를 삭제합니다.
        */
    }
}
