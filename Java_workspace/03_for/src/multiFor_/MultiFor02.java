package multiFor_;

public class MultiFor02 {

	public static void main(String[] args) {
		int dan, i;
		
		for (dan=2; dan<=9; dan++) {
			
			
			for(i=1; i<=9; i++) {
				System.out.println(dan +" * " + i + " = " + dan*1);
			} // for i
			System.out.println();
		} // for dan
		
	}

}

/*

2단~9단

2*1=2
2*2=4
~~
2*9=18

3*1=3
3*2=6
~~
3*9=27




*/