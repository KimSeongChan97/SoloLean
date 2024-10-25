package homework_class02;

import java.util.Scanner;

public class StringRep {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scanner 객체 생성

        System.out.print("문자열 입력: ");
        String inputStr = scan.next().toLowerCase(); // 사용자로부터 문자열 입력을 받아 소문자로 변환
        System.out.print("현재 문자열 입력: ");
        String targetStr = scan.next().toLowerCase(); // 치환할 문자열을 입력 받아 소문자로 변환
        System.out.print("바꿀 문자열 입력: ");
        String changeStr = scan.next(); // 바꿀 문자열을 입력 받음

        // 입력 문자열의 길이가 치환할 문자열의 길이보다 작은 경우 경고 메시지 출력
        if (inputStr.length() < targetStr.length())
            System.out.println("입력한 문자열의 크기가 작습니다");
        else {
            int index = 0; // 문자열 탐색 시작 인덱스
            int count = 0; // 치환된 횟수

            // targetStr을 inputStr에서 찾을 때까지 반복
            while ((index = inputStr.indexOf(targetStr, index)) != -1) { // targetStr을 찾지 못하면 -1 반환
                index += targetStr.length(); // 다음 탐색 시작 위치를 현재 위치 + targetStr 길이로 설정
                count++; // 치환 횟수 증가
            }

            // 문자열에서 targetStr을 changeStr로 치환하여 출력
            System.out.println(inputStr.replace(targetStr, changeStr));
            // 치환된 횟수 출력
            System.out.println(count + "개 치환");
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
치환 할 수 없습니다

indexOf("문자열")
indexOf("문자열", 시작위치)

"abcgbvgabc" indexOf("abc", 0) = > 0번에
			 indexOf("abc", 3) => 6번에
"wie1234weir1234iemg12341234123"	indexOf("1234", 0) => 3 / 0번부터
			 						indexOF("1234", 7) => 11 / 7번부터
			 						indexOF("1234", 15) => 19 -> for, while 돌려야함
			 
			 
*/