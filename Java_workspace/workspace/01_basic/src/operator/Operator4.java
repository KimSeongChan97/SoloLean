package operator;

public class Operator4 {

	public static void main(String[] args) {
		int num1=0, num2=0;
		boolean result;
		
		result = ( (num1+=10) < 0 && (num2+=10) > 0);
		System.out.println("result = " +result);
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		System.out.println();//앞에 결과가 false 이기 때문에 후행조건을 무시하므로 num2=0이 된다.
		
		result = ( (num1+=10) > 0 || (num2+=10) > 0);
		System.out.println("result = " +result);
		System.out.println("num1 = " + num1 + " num2 = " + num2);//||는 앞에서 참이므로 뒤도 참으로 본다. (num1에10더함)
		
	}

}
