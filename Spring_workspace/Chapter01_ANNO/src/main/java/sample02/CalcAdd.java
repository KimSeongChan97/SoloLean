package sample02;

import org.springframework.stereotype.Component;

@Component("calcAdd")
public class CalcAdd implements Calc {

	@Override
	public void calculate(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x + y));

	}

}
