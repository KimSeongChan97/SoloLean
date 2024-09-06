package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonSort {

    public static void main(String[] args) {
        // 문자열 배열 정렬
        String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};

        System.out.print("정렬 전 = ");
        for (String data : ar) {
            System.out.print(data + "  ");
        }
        System.out.println();

        Arrays.sort(ar); // 기본 오름차순 정렬

        System.out.print("정렬 후 = ");
        for (String data : ar) {
            System.out.print(data + "  ");
        }
        System.out.println();

        // PersonDTO 객체 생성 및 리스트에 추가, 객체 비교
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("프로도", 40);
        PersonDTO cc = new PersonDTO("라이언", 30);

        ArrayList<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        // 정렬 전 리스트 출력
        System.out.println("정렬 전 = ");
        for (PersonDTO person : list) {
            System.out.println(person);
        }

        // PersonDTO 리스트 정렬 (기본은 이름의 내림차순 정렬)
        Collections.sort(list);

        // 정렬 후 리스트 출력
        System.out.println("정렬 후 = ");
        for (PersonDTO person : list) {
            System.out.println(person);
        }
    }
}













