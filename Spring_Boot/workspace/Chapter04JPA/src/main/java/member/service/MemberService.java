package member.service;

import java.util.Map;
import org.springframework.data.domain.Pageable;
import member.entity.MemberEntity;

public interface MemberService {
    public String isExistId(String id);
    public void write(MemberEntity memberEntity);
    public Map<String, Object> getMemberList(Pageable pageable);
    public Map<String, Object> getSearchList(String columnName, String value, Pageable pageable);
}
