package homework_class;

import java.util.Scanner;

public class MemberService {
    private MemberDTO[] ar = new MemberDTO[5]; // 최대 5명의 회원 정보를 저장할 수 있는 배열
    private Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체

    // 기본 생성자
    public MemberService() {
        System.out.println("MemberService 기본 생성자");
    }

    // 메뉴를 출력하고 사용자의 선택에 따라 기능을 수행하는 메서드
    public void menu() {
        int num;

        while (true) { // 무한 루프를 통해 메뉴를 계속 출력
            System.out.println();
            System.out.println("******************");
            System.out.println("   1. 가입");
            System.out.println("   2. 출력");
            System.out.println("   3. 수정");
            System.out.println("   4. 탈퇴");
            System.out.println("   5. 끝내기");
            System.out.println("******************");
            System.out.print("   번호 : ");
            num = scan.nextInt(); // 사용자가 입력한 번호를 num 변수에 저장

            if (num == 5) break; // 번호가 5이면 루프를 종료
            if (num == 1) this.insert(); // 번호가 1이면 회원 가입 메서드 호출
            else if (num == 2) list(); // 번호가 2이면 회원 목록 출력 메서드 호출
            else if (num == 3) update(); // 번호가 3이면 회원 정보 수정 메서드 호출
            else if (num == 4) delete(); // 번호가 4이면 회원 탈퇴 메서드 호출
        }
    }

    // 회원 가입을 처리하는 메서드
    public void insert() {
        System.out.println();

        int i;
        // 빈 자리를 찾기 위한 루프
        for (i = 0; i < ar.length; i++) {
            if (ar[i] == null) break; // 배열에서 빈 자리를 찾으면 루프를 종료
        }

        if (i == ar.length) {
            System.out.println(ar.length + "명의 정원이 꽉 찼습니다.");
            return; // 배열이 꽉 차있으면 메서드를 종료
        }

        ar[i] = new MemberDTO(); // 새로운 회원 정보를 저장할 객체 생성
        System.out.print("이름 입력 : ");
        ar[i].setName(scan.next()); // 이름 입력 받기
        System.out.print("나이 입력 : ");
        ar[i].setAge(scan.nextInt()); // 나이 입력 받기
        System.out.print("핸드폰 입력 : ");
        ar[i].setPhone(scan.next()); // 핸드폰 번호 입력 받기
        System.out.print("주소 입력 : ");
        ar[i].setAddress(scan.next()); // 주소 입력 받기

        System.out.println("회원 가입이 되었습니다.");
    }

    // 회원 목록을 출력하는 메서드
    public void list() {
        System.out.println();

        // 배열을 순회하며 null이 아닌 회원 정보를 출력
        for (MemberDTO dto : ar) {
            if (dto != null)
                System.out.println(dto.getName() + "\t"
                        + dto.getAge() + "\t"
                        + dto.getPhone() + "\t"
                        + dto.getAddress());
        }
    }

    // 회원 정보를 수정하는 메서드
    public void update() {
        System.out.println();
        System.out.print("핸드폰 번호 입력 : ");
        String phone = scan.next(); // 수정할 회원을 찾기 위해 핸드폰 번호 입력 받기

        int i;
        // 배열을 순회하며 입력받은 핸드폰 번호와 일치하는 회원을 찾기 위한 루프
        for (i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                if (ar[i].getPhone().equals(phone)) {
                    // 해당 회원 정보를 출력
                    System.out.println(ar[i].getName() + "\t"
                            + ar[i].getAge() + "\t"
                            + ar[i].getPhone() + "\t"
                            + ar[i].getAddress());

                    // 새로운 정보 입력 받기
                    System.out.println();
                    System.out.print("수정 할 이름 입력 : ");
                    ar[i].setName(scan.next());
                    System.out.print("수정 할 나이 입력 : ");
                    ar[i].setAge(scan.nextInt());
                    System.out.print("수정 할 핸드폰 입력 : ");
                    ar[i].setPhone(scan.next());
                    System.out.print("수정 할 주소 입력 : ");
                    ar[i].setAddress(scan.next());

                    System.out.println("\n 회원의 정보를 수정하였습니다.");
                    break; // 수정이 완료되면 루프 종료
                }
            }
        }

        if (i == ar.length)
            System.out.println("찾는 회원이 없습니다"); // 해당 회원을 찾지 못한 경우
    }

    // 회원 탈퇴를 처리하는 메서드
    public void delete() {
        System.out.println();
        System.out.print("핸드폰 번호 입력 : ");
        String phone = scan.next(); // 삭제할 회원을 찾기 위해 핸드폰 번호 입력 받기

        int i;
        // 배열을 순회하며 입력받은 핸드폰 번호와 일치하는 회원을 찾기 위한 루프
        for (i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                if (ar[i].getPhone().equals(phone)) {
                    ar[i] = null; // 해당 회원 정보를 삭제
                    System.out.println("회원의 정보를 삭제하였습니다.");
                    break; // 삭제가 완료되면 루프 종료
                }
            }
        }

        if (i == ar.length)
            System.out.println("찾는 회원이 없습니다"); // 해당 회원을 찾지 못한 경우
    }
}








