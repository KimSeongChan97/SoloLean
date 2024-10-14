package user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.bean.UserPaging;
import user.dao.UserDAO;
import user.service.UserService;

@Service // 이 클래스가 서비스 레이어임을 나타냅니다.
// 서비스 레이어는 비즈니스 로직을 처리하는 계층입니다. 이 클래스는 Spring이 관리하는 Bean으로 등록되어 의존성 주입을 통해 사용됩니다.
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO; // DAO 객체를 주입받아 DB와의 연결을 관리합니다.
    // DAO는 데이터베이스에 접근하는 역할을 합니다. 여기서는 DB와의 상호작용을 통해 데이터를 읽고 쓰는 작업을 수행합니다.
    
    @Autowired
    private UserPaging userPaging; // 페이징 처리를 위한 객체
    // 페이징은 한 번에 표시할 데이터의 양을 제한하여, 많은 데이터를 효율적으로 표시하기 위해 사용됩니다.
    
    @Override
    public String getExistId(String id) {
        // ID 중복 확인을 위한 서비스 메서드
        UserDTO userDTO = userDAO.getExistId(id); // DAO에서 해당 ID 조회
        // DAO를 통해 데이터베이스에 존재하는 해당 ID의 사용자 정보를 조회합니다.
        if (userDTO == null) {
            return "non_exist"; // 존재하지 않으면 'non_exist' 반환
            // 해당 ID가 데이터베이스에 없으면 'non_exist' 문자열을 반환하여 ID가 사용 가능한 상태임을 나타냅니다.
        } else {
            return "exist"; // 존재하면 'exist' 반환
            // 해당 ID가 이미 존재하면 'exist' 문자열을 반환하여 ID가 중복되었음을 나타냅니다.
        }
    }

    @Override
    public void write(UserDTO userDTO) {
        // DAO로 회원 정보를 전달하여 DB에 저장
        // 새로운 회원가입 요청 시, 전달받은 회원 정보를 데이터베이스에 저장합니다.
        userDAO.write(userDTO); 
        // DAO를 통해 UserDTO 객체를 데이터베이스에 저장하는 메서드를 호출합니다. UserDTO는 사용자 정보를 담고 있는 데이터 전송 객체입니다.
    }

    @Override
    public Map<String, Object> list(String pg) {
        // 페이지네이션을 위한 리스트 조회 서비스
        // 사용자가 요청한 페이지 번호(pg)에 맞춰 데이터를 페이지 단위로 가져오는 로직입니다.
        
        int startNum = (Integer.parseInt(pg) - 1) * 5; // 시작 인덱스 계산
        // 사용자가 요청한 페이지의 시작 인덱스를 계산합니다. 한 페이지에 5개의 데이터가 표시되며, (pg - 1) * 5로 해당 페이지의 시작 인덱스를 구합니다.
        int endNum = 5; // 페이지 당 글 수
        // 한 페이지에 표시될 최대 데이터 수를 5개로 설정합니다.
        
        Map<String, Integer> map = new HashMap<>();
        map.put("startNum", startNum);
        map.put("endNum", endNum);
        // 시작 인덱스와 끝 인덱스를 map에 저장하여 나중에 DB에서 해당 범위의 데이터를 가져오도록 설정합니다.

        // DB에서 리스트 가져오기
        List<UserDTO> list = userDAO.list(map);
        // 위에서 정의한 시작 인덱스와 끝 인덱스에 해당하는 데이터를 DB에서 가져옵니다. 가져온 데이터는 UserDTO 리스트로 반환됩니다.

        // 페이징 처리
        int totalA = userDAO.getTotalA(); // 전체 글 수 조회
        // 전체 데이터(게시글) 수를 DB에서 조회합니다. 이를 통해 전체 페이지 수를 계산할 수 있습니다.
        userPaging.setCurrentPage(Integer.parseInt(pg)); // 현재 페이지 설정
        // 현재 페이지를 설정합니다. 페이지 이동 시 몇 번째 페이지를 표시할지를 결정합니다.
        userPaging.setPageBlock(3); // 페이지 블록 설정
        // 페이지 블록은 한 번에 표시할 페이지 번호의 개수입니다. 예를 들어, [1][2][3] 식으로 표시되도록 3으로 설정합니다.
        userPaging.setPageSize(5); // 한 페이지당 글 수 설정
        // 한 페이지에 표시될 데이터 수를 설정합니다. 여기서는 5개의 데이터를 한 페이지에 표시하도록 설정합니다.
        userPaging.setTotalA(totalA); // 총 글 수 설정
        // 전체 데이터 수를 설정하여 페이지 계산에 사용합니다.
        userPaging.makePagingHTML(); // 페이징 HTML 생성
        // 페이징 처리를 위한 HTML을 생성합니다. 사용자에게 보여줄 페이지 번호와 이전/다음 버튼 등을 처리합니다.

        Map<String, Object> map2 = new HashMap<>();
        map2.put("list", list); // 리스트 저장
        // 가져온 데이터 리스트를 map2에 저장합니다.
        map2.put("userPaging", userPaging); // 페이징 정보 저장
        // 페이징 처리 정보를 map2에 저장하여 뷰에서 사용하도록 넘깁니다.
        
        return map2;
        // 리스트와 페이징 정보를 함께 반환하여, 해당 페이지의 데이터와 페이징 처리를 뷰에 전달합니다.
    }

    @Override
    public UserDTO getUser(String id) {
        // ID로 사용자 정보를 가져옴
        return userDAO.getUser(id);
        // DAO를 통해 해당 ID의 사용자 정보를 DB에서 가져와 반환합니다. 이 정보는 UserDTO 객체에 담겨있습니다.
    }

    @Override
    public void update(UserDTO userDTO) {
        // 수정된 사용자 정보를 DB에 업데이트
        Map<String, String> map = new HashMap<>();
        map.put("name", userDTO.getName());
        map.put("id", userDTO.getId());
        map.put("pwd", userDTO.getPwd());
        // 수정된 사용자 정보를 map에 저장합니다. 이때 이름, 아이디, 비밀번호 정보를 모두 포함하여 업데이트합니다.
        
        userDAO.update(map);
        // map에 저장된 수정된 사용자 정보를 DAO를 통해 데이터베이스에 업데이트합니다.
    }

    @Override
    public UserDTO login(String id, String pwd) {
        // 로그인 처리. ID와 비밀번호 일치 여부 확인
        UserDTO userDTO = userDAO.getUser(id);
        // 해당 ID로 사용자 정보를 DB에서 가져옵니다.
        
        if (userDTO != null && userDTO.getPwd().equals(pwd)) {
            return userDTO; // 비밀번호가 일치하면 로그인 성공
            // 사용자 정보가 존재하고, 비밀번호가 일치하는 경우 로그인 성공으로 처리하여 해당 사용자 정보를 반환합니다.
        } else {
            return null; // 실패하면 null 반환
            // 사용자 정보가 없거나 비밀번호가 일치하지 않으면 null을 반환하여 로그인 실패를 나타냅니다.
        }
    }

    @Override
    public UserDTO getExistPwd(String id) {
        // 해당 사용자의 비밀번호를 확인하는 메서드입니다.
    	UserDTO userDTO = userDAO.getExistPwd(id);
    	// ID를 통해 해당 사용자의 비밀번호 정보를 가져옵니다. 이 정보는 UserDTO에 담겨 반환됩니다.
    	return userDTO;
    }
    
    @Override
    public void delete(String id) {
    	// ID를 기준으로 사용자 정보를 삭제하는 메서드입니다.
    	userDAO.delete(id);
    	// DAO를 통해 해당 ID의 사용자를 DB에서 삭제합니다.
    }
    
    
}
