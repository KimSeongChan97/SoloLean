package sungJukSolo;

import java.util.ArrayList;

/**
 * SungJuk 인터페이스는 성적 처리 기능을 제공하기 위한 메서드를 정의합니다.
 * 이 인터페이스를 구현하는 클래스는 성적을 처리하는 구체적인 로직을 제공해야 합니다.
 */
public interface SungJuk {
    /**
     * execute 메서드는 성적 처리 기능을 수행합니다.
     * 성적 데이터는 ArrayList 형태로 전달받으며, 이 리스트를 사용하여 성적을 처리합니다.
     * @param list 성적 데이터가 저장된 ArrayList<SungJukDTO>
     */
    void execute(ArrayList<SungJukDTO> list);
}
