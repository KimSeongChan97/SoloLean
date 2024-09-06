package safari;

import com.zoo.Zoo;

public class Safari extends Zoo {

	public static void main(String[] args) {
		
		// Zoo class 의 tiger() 호출
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe();
		//zoo.elephant();
		//zoo.lion(); 
		
		Safari safari = new Safari();
	
		safari.tiger();
		safari.giraffe();
		//safari.elephant();
		//safari.lion(); 

	}

}
