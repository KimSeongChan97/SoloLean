package homework_class;

import java.util.Scanner;

public class MemberServiceSoloGPT {
	private MemberDTO[] ar = new MemberDTO[5]; // 5명의 인원을 저장할 배열
	private Scanner scan = new Scanner(System.in);
	
		// 메뉴 출력 및 선택을 처리하는 메서드
		public void menu() {
			while(true) { // 메뉴 출력
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
		            case 1: insert(); break; // 회원 가입 메서드 호출
	                case 2: list(); break; // 회원 목록 출력 메서드 호출
	                case 3: update(); break; // 회원 정보 수정 메서드 호출
	                case 4: delete(); break; // 회원 정보 삭제 메서드 호출
	                case 5:
	                    System.out.println("프로그램을 종료합니다.");
	                    return; // 프로그램 종료
	                default:
	                    System.out.println("잘못된 입력입니다.");
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
					ar[i].setName(scan.next());
					System.out.print("나이 입력: ");
	                ar[i].setAge(scan.nextInt());
	                System.out.print("핸드폰 입력: ");
	                ar[i].setPhone(scan.next());
	                System.out.print("주소 입력: ");
	                ar[i].setAddress(scan.next());
	                System.out.println("회원 가입이 되었습니다.");
	                return; // 회원가입 후 메소드 종료
				}
			}
			System.out.println(" 5명의 정원이 꽉 찼습니다. ");
		}
		
		// 회원 목록 출력 메서드
		public void list() {
		    System.out.println("이름\t나이\t핸드폰\t\t주소");
			    // 회원 데이터가 있는지 여부를 직접 출력 여부를 판단
			    for (MemberDTO member : ar) {
			        if (member != null) {
			            System.out.println(member.getName() + "\t" +
			                               member.getAge() + "\t" +
			                               member.getPhone() + "\t" +
			                               member.getAddress());
			        }
			    }

			    // 회원 데이터가 하나도 출력되지 않았으면 "출력할 데이터가 없습니다." 출력
			    boolean empty = true; // 회원 데이터 가 있는지 여부를 판단하는 변수
			    for (MemberDTO member : ar) {
			        if (member != null) {
			            empty = false; // 회원 데이터가 있음을 표시
			            break;
			        }
			    }
		    
				    if (empty) {
				        System.out.println("출력할 데이터가 없습니다.");
				    }
		}
		// 회원 정보 수정 메소드
		public void update() {
			System.out.print("핸드폰 번호 입력: ");
			String phone = scan.next();
				for (MemberDTO member : ar) {
					if (member != null && member.getPhone().equals(phone)) { // 회원 정보 출력
						System.out.println("회원 정보: " + member.getName() + "\t"
											+ member.getAge() + "\t"
											+ member.getPhone() + "\t"
											+ member.getAddress());
							System.out.print("수정 할 이름 입력: ");
			                member.setName(scan.next());
			                System.out.print("수정 할 나이 입력: ");
			                member.setAge(scan.nextInt());
			                System.out.print("수정 할 핸드폰 입력: ");
			                member.setPhone(scan.next());
			                System.out.print("수정 할 주소 입력: ");
			                member.setAddress(scan.next());
			                System.out.println("회원의 정보를 수정하였습니다.");
							return;
					}
				}
				System.out.println("찾는 회원이 없습니다.");
		}
		
		//회원정보 삭제 메소드
		public void delete() {
			System.out.print("핸드폰 번호 입력: ");
			String phone = scan.next();
			
				for(int i=0; i<ar.length; i++) {
					if(ar[i] !=null && ar[i].getPhone().equals(phone)) {
						ar[i] = null; //회원정보 삭제
						System.out.println("회원의 정보를 삭제하였습니다. ");
						return;
					}
				}
				System.out.println("찾는 회원이 없습니다.");
		}
			
}