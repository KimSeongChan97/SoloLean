package homework_class02;

import java.util.Scanner;

public class StringRepSolo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            // 사용자로부터 문자열 입력 받기
            System.out.print("문자열 입력: ");
            String input = scan.nextLine();

            // 치환할 문자열 입력 받기
            System.out.print("현재 문자열 입력: ");
            String target = scan.nextLine();

            // 바꿀 문자열 입력 받기
            System.out.print("바꿀 문자열 입력: ");
            String replacement = scan.nextLine();

            // 대소문자 무시하고 치환하기 위해 입력 문자열과 대상 문자열을 모두 소문자로 변환하여 처리
            String lowerInput = input.toLowerCase();
            String lowerTarget = target.toLowerCase();

            // 치환된 결과를 저장할 StringBuilder 객체 생성
            StringBuilder result = new StringBuilder();
            int count = 0;  // 치환된 횟수 저장

            // 입력 문자열을 순회하며 치환 작업 수행
            int startIndex = 0;
            while (true) {
                // 대상 문자열의 시작 인덱스를 찾기
                int index = lowerInput.indexOf(lowerTarget, startIndex);

                // 더 이상 대상 문자열이 없으면 루프 종료
                if (index == -1) {
                    // 남은 부분을 결과에 추가
                    result.append(input.substring(startIndex));
                    break;
                }

                // 대상 문자열 전까지의 부분을 결과에 추가
                result.append(input, startIndex, index);
                // 치환 문자열을 결과에 추가
                result.append(replacement);
                // 치환된 횟수 증가
                count++;

                // 다음 탐색 시작 위치를 현재 치환 위치 이후로 설정
                startIndex = index + target.length();
            }

            // 결과 출력
            System.out.println(result.toString());

            // 치환된 횟수 출력
            if (count > 0) {
                System.out.println(count + "번 치환");
            } else {
                System.out.println("입력한 문자열의 크기가 작습니다");
                System.out.println("치환 할 수 없습니다");
            }

            // 결과와 다음 입력 사이에 줄 바꿈 추가
            System.out.println();
        }

        
    }
}


/*
[문제]
치환하는 프로그램을 작성하시오 - indexOf(?, ?), replace()
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbbdd
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다
치환 할 수 없습니다.

*/