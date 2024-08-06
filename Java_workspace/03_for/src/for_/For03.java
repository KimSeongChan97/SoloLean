package for_;

public class For03 {

	public static void main(String[] args) {
		int sum=0;
		int mul=1;
		System.out.println("\t" + "합" + "\t" + "곱");
		for(int i= 1; i<=10; i++) {
			sum = sum + i;
			mul = mul * i;
			System.out.println(i + "\t" + sum + "\t" + mul);
			
		} // for 1~10 , sum 값 구하기.

	}

}

/*

       합		곱
1      1		1
2		3		2
3				6
4
5
6
7
8
9
10		55		..

*/
