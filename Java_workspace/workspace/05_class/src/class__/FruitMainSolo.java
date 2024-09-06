package class__;

public class FruitMainSolo {
    public static void main(String[] args) {
        // FruitSolo 객체 배열 생성 및 초기화
        FruitSolo[] fruits = {
            new FruitSolo("사과", 100, 80, 75), // 사과의 1월, 2월, 3월 판매량
            new FruitSolo("포도", 30, 25, 10), // 포도의 1월, 2월, 3월 판매량
            new FruitSolo("딸기", 25, 30, 90) // 딸기의 1월, 2월, 3월 판매량
        };

        // 결과 출력
        FruitSolo.output(fruits); // 모든 과일의 1월, 2월, 3월 판매량의 합계를 출력
    }
}



/*
[문제]
과일 판매량 구하기
월별 매출합계도 구하시오

[클래스]
Fruit
[필드]
pum, jan, feb, mar, tot
sumJan, sumFeb, sumMar
[메소드]
생성자(품명, 1월, 2월, 3월)
calcTot()
display()
public static void output()

[클래스]
FruitMain

[실행결과]
---------------------------------------
PUM JAN   FEB   MAR TOT
---------------------------------------
사과    100    80    75     255
포도     30    25    10     xxx
딸기     25    30    90     xxx
---------------------------------------
        xxx   xxx   xxx output()로 처리

*/