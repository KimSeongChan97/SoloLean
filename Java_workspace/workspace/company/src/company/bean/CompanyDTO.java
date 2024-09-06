package company.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {
    private String name; //사원 이름
    private String id; //사원 아이디
    private String pw; //사원 비밀번호
    private String phone; //사원 전화번호
    private String regist_day; //입사일
    private String leave_day; //사원 입사일
    private String deleteYN; //탈퇴 여부
    
    private String rank;
    
    private String checkIn_Time; //출근시간
    private String checkOut_Time; //퇴근시간
    private String status; //출근 , 퇴근 , 결근 , 지각 등등
    private String reason; //지각 이유 , 결근 이유 등등
    
    private int checkIn_Count; //출근 횟수
    private int checkOut_Count; //퇴근 횟수
    private int vacation_Days; //휴가 일수
    private int monthly_vacation_Days; //월별 휴가 일수
}
