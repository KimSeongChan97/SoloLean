package company.service;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyAttendance implements Company {
	
	Company company = null;
	CompanyDTO companyDTO = null;
	
	public CompanyAttendance(CompanyDTO companyDTO) { // 생성자 추가
        this.companyDTO = companyDTO;
    }

    // Company 인터페이스의 execute 메서드를 구현
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
        CompanyDAO companyDAO = CompanyDAO.getInstance(); // CompanyDAO의 싱글톤 인스턴스 가져오기
        //CompanyDTO companyDTO = new CompanyDTO();

        
        String name = companyDTO.getName();
        String rank = companyDTO.getRank();
        String id = companyDTO.getId();
        
        
        if (companyDTO != null) {
        	while (true) {
                System.out.println("------------------");
                System.out.println("1. 출근");
                System.out.println("2. 퇴근");
                System.out.println("3. 휴가 설정");
                System.out.println("4. 휴가 상세 정보 보기");
                System.out.println("5. 이전 메뉴");
                System.out.println("------------------");
                System.out.print("번호 입력 : ");
                int n = sc.nextInt(); // 사용자 입력 번호

                if (n == 5) break; // 이전 메뉴로 돌아감
                else if (n == 1) {
                    if (companyDAO.isAlreadyCheckedIn(id)) {
                        // 이미 출근한 경우 메시지 출력
                        System.out.println("이미 출근하셨습니다.");
                    } else {
                        companyDAO.checkin(id); // 출근 체크
                        System.out.println("출근하셨습니다.");
                    }
                } else if (n == 2) {
                    if (companyDAO.isAlreadyCheckedOut(id)) {
                        // 이미 퇴근한 경우 메시지 출력
                        System.out.println("이미 퇴근하셨습니다.");
                    } else {
                        companyDAO.checkout(id); // 퇴근 체크
                    }
                } else if (n == 3) {
                	//출근이 안되어있을경우
                	if (!companyDAO.isAlreadyCheckedIn(id)) {
                		 System.out.println("출근 먼저 해주세요");                   	
                    }//if
                	else {
                		Date today = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String format_Date = dateFormat.format(today);

                        String start_day = null; 
                        String end_day = null;   

                    	while (true) {
                            System.out.print("휴가 일수를 입력하세요: ");
                            int days = sc.nextInt();
                            sc.nextLine(); // 버퍼 비우기 (nextInt() 후에 남은 개행 문자 제거) 안지우면 오늘 이전 안된다는 출력문 뜸

                            while (start_day == null) { 
                                System.out.print("휴가 시작 날짜(YYYY-MM-DD): ");
                                String startDate = sc.nextLine();
                                if (startDate.compareTo(format_Date) < 0) {
                                    System.out.println("휴가 시작 날짜는 오늘 이전일 수 없습니다.");
                                } else {
                                    start_day = startDate; //startDate를 start_day에 저장
                                }
                            }

                            while (end_day == null) { 
                                System.out.print("휴가 종료 날짜(YYYY-MM-DD): ");
                                String endDate = sc.nextLine();
                                if (endDate.compareTo(start_day) < 0) {
                                    System.out.println("휴가 종료 날짜는 휴가 시작 날짜보다 이전일 수 없습니다.");
                                } else {
                                    end_day = endDate; //endDate를 end_day에 저장
                                }
                            }

                            companyDAO.setVacation(id, days, start_day, end_day); // 휴가 설정
                            System.out.println("휴가가 등록되었습니다");
                            break;
                        }
                	}
                	
                    
                } else if (n == 4) {
                    companyDAO.getVacationDetails(id); // 휴가 상세 정보 조회
                } else {
                    System.out.println("1 ~ 5 중에서 입력하세요");
                    continue;
                }
            }//while
        }
        
    }
}
