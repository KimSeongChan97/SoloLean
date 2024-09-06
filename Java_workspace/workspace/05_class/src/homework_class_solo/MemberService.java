package homework_class_solo;

import java.util.Scanner;

public class MemberService {
    private MemberDTO[] ar = new MemberDTO[5]; // 5명의 인원을 저장할 배열
    private Scanner scan = new Scanner(System.in);
    
    // 메뉴 출력 및 선택을 처리하는 메서드
    public void menu() {
        while(true) { // 무한 반복으로 메뉴를 지속적으로 출력
            System.out.println("*************");
            System.out.println("   1. 가입");
            System.out.println("   2. 출력");
            System.out.println("   3. 수정");
            System.out.println("   4. 탈퇴");
            System.out.println("   5. 끝내기");
            System.out.println("*************");
            System.out.print("번호 : ");
            int choice = scan.nextInt(); // 사용자의 선택을 입력받음
            
            switch (choice) {
                case 1: insert(); break; // 사용자가 1을 선택하면 회원 가입 메서드 호출
                case 2: list(); break; // 사용자가 2를 선택하면 회원 목록 출력 메서드 호출
                case 3: update(); break; // 사용자가 3을 선택하면 회원 정보 수정 메서드 호출
                case 4: delete(); break; // 사용자가 4를 선택하면 회원 정보 삭제 메서드 호출
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return; // 사용자가 5를 선택하면 프로그램 종료
                default:
                    System.out.println("잘못된 입력입니다."); // 그 외의 입력일 경우 잘못된 입력 메시지 출력
            }
        }
    }
    
    //회원가입 메소드
    public void insert() {
        // 배열이 꽉 찼는지 확인
        for (int i=0; i<ar.length; i++) {
            if (ar[i] == null) {
                ar[i] = new MemberDTO(); // 신규회원 객체 생성
                System.out.print("이름 입력: ");
                ar[i].setName(scan.next()); // 사용자로부터 이름을 입력받아 MemberDTO 객체의 setName 메소드로 설정
                System.out.print("나이 입력: ");
                ar[i].setAge(scan.nextInt()); // 사용자로부터 나이를 입력받아 MemberDTO 객체의 setAge 메소드로 설정
                System.out.print("핸드폰 입력: ");
                ar[i].setPhone(scan.next()); // 사용자로부터 핸드폰 번호를 입력받아 MemberDTO 객체의 setPhone 메소드로 설정
                System.out.print("주소 입력: ");
                ar[i].setAddress(scan.next()); // 사용자로부터 주소를 입력받아 MemberDTO 객체의 setAddress 메소드로 설정
                System.out.println("회원 가입이 되었습니다."); // 회원 가입 완료 메시지 출력
                return; // 메소드 종료
            }
        }
        System.out.println(" 5명의 정원이 꽉 찼습니다. "); // 배열이 꽉 찼을 때 출력되는 메시지
    }
    
    // 회원 목록 출력 메서드
    public void list() {
        System.out.println("이름\t나이\t핸드폰\t\t주소");
        // 회원 데이터가 있는지 여부를 직접 출력 여부를 판단
        for (MemberDTO member : ar) { // 배열 ar의 모든 요소를 순회
            if (member != null) { // 배열 요소가 null이 아닌 경우만 처리
                System.out.println(member.getName() + "\t" + // 회원의 이름 출력
                                   member.getAge() + "\t" + // 회원의 나이 출력
                                   member.getPhone() + "\t" + // 회원의 핸드폰 번호 출력
                                   member.getAddress()); // 회원의 주소 출력
            }
        }
        
        // 회원 데이터가 하나도 출력되지 않았으면 "출력할 데이터가 없습니다." 출력
        boolean empty = true; // 회원 데이터가 있는지 여부를 판단하는 변수 초기화
        for (MemberDTO member : ar) { // 배열 ar의 모든 요소를 순회
            if (member != null) { // 배열 요소가 null이 아닌 경우
                empty = false; // 회원 데이터가 존재함을 표시
                break; // 반복문 종료
            }
        }
        
        if (empty) { // 회원 데이터가 없는 경우
            System.out.println("출력할 데이터가 없습니다."); // 메시지 출력
        }
    }
    
    // 회원 정보 수정 메소드
    public void update() {
        System.out.print("핸드폰 번호 입력: ");
        String phone = scan.next(); // 사용자로부터 핸드폰 번호를 입력받음
        
        for (MemberDTO member : ar) { // 배열 ar의 모든 요소를 순회
            if (member != null && member.getPhone().equals(phone)) { // 배열 요소가 null이 아니고, 핸드폰 번호가 일치하는 경우
                // 회원 정보 출력
                System.out.println("회원 정보: " + member.getName() + "\t" +
                                   member.getAge() + "\t" +
                                   member.getPhone() + "\t" +
                                   member.getAddress());
                
                // 수정할 데이터 입력 받기
                System.out.print("수정 할 이름 입력: ");
                member.setName(scan.next()); // 이름 수정
                System.out.print("수정 할 나이 입력: ");
                member.setAge(scan.nextInt()); // 나이 수정
                System.out.print("수정 할 핸드폰 입력: ");
                member.setPhone(scan.next()); // 핸드폰 번호 수정
                System.out.print("수정 할 주소 입력: ");
                member.setAddress(scan.next()); // 주소 수정
                
                System.out.println("회원의 정보를 수정하였습니다."); // 수정 완료 메시지 출력
                return; // 메서드 종료
            }
        }
        
        System.out.println("찾는 회원이 없습니다."); // 핸드폰 번호가 일치하는 회원을 찾지 못한 경우 메시지 출력
    }
    
    //회원정보 삭제 메소드
    public void delete() {
        System.out.print("핸드폰 번호 입력: ");
        String phone = scan.next();
        
        for(int i=0; i<ar.length; i++) { // 배열 ar의 모든 요소를 순회
            if(ar[i] !=null && ar[i].getPhone().equals(phone)) {
                ar[i] = null; // 회원정보 삭제
                System.out.println("회원의 정보를 삭제하였습니다. ");
                return;
            }
        }
        
        System.out.println("찾는 회원이 없습니다."); // 핸드폰 번호가 일치하는 회원을 찾지 못한 경우 메시지 출력
    }
}

