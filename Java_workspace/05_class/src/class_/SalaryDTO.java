package class_;

// 1인분

public class SalaryDTO {
	
	private String name; // 이름
	private String job; // 직급
	private int basic, extra, tot; // 기본급, 수당, 합계
	private double rate; // 세율
	private int tax, salary; // 세금, 월급
		
	public void setData(String n, String j, int b, int e) {
		name = n; // 이름 설정
		job = j; // 직급 설정
		basic = b; // 기본급 설정
		extra = e; // 수당 설정
		
	}
	 // 급여 계산 메소드
	public void calc() {
		tot = basic + extra; // 합계
		
		if(tot >=5000000) {
			rate = 0.03; // 세율 0.03%
		} else if (tot >= 3000000) {
			rate = 0.02; // 0.02
		} else {
			rate = 0.01; // 0.01
		}
		// rate = total>=5000000 ? 0.03 : total>=3000000 ? 0.02 : 0.01;
		tax = (int)(tot*rate);
		salary = tot - tax;
		
	}
	 // getter 매서드
	 public String getName() { return name; }
	 public String getJob() { return job; }
	 public int getBasic() { return basic; }
	 public int getExtra() { return extra; }
	 public int getTot() { return tot; }
	 public double getRate() { return rate; }
	 public int getTax() { return tax; }
	 public int getSalary() { return salary; }
	 	 		
}
