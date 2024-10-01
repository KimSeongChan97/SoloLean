package sample04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukOutput implements SungJuk {

	@Autowired
	private List<SungJukDTO2> list; 
		
	@Override
	public void execute() {
		 System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
	        for (SungJukDTO2 dto : list) {
	            System.out.println(dto.getName() 
	            					+ "\t" + dto.getKor() 
	            					+ "\t" + dto.getEng() 
	            					+ "\t" + dto.getMath() 
	            					+ "\t" + dto.getTot() 
	            					+ "\t" + dto.getAvg());
	        }
	    }

}
