package sungJukSolo;

import java.util.ArrayList;

/**
 * SungJukPrint 클래스는 성적 출력 기능을 제공하는 클래스입니다.
 * 리스트에 저장된 모든 성적 데이터를 출력합니다.
 */
public class SungJukPrint implements SungJuk {
    /**
     * execute 메서드는 리스트에 저장된 성적 데이터를 출력하는 기능을 수행합니다.
     * 성적 데이터를 보기 좋은 형식으로 콘솔에 출력합니다.
     * @param list 성적 데이터가 저장된 ArrayList<SungJukDTO>
     */
    @Override
    public void execute(ArrayList<SungJukDTO> list) {
        // 성적 데이터를 출력할 때 사용할 헤더를 출력
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");

        // 리스트에 저장된 각 SungJukDTO 객체의 정보를 출력
        for (SungJukDTO dto : list) {
            // 각 객체의 toString 메서드를 호출하여 정보를 출력
            System.out.println(dto);  
        }
    }
}
