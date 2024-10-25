package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok을 이용한 Food 클래스 정의
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동으로 생성
@AllArgsConstructor // 모든 필드를 매개변수로 가지는 생성자를 자동으로 생성
@Getter // 모든 필드에 대한 Getter 메서드를 자동으로 생성
@Setter // 모든 필드에 대한 Setter 메서드를 자동으로 생성
class Food {
    String name; // 음식 이름
    int calorie; // 음식 칼로리
}

//---------------------------------------------
public class StreamMain02 {
	static int hap; // 클래스 변수로 합계를 저장할 변수 선언
	
    public static void main(String[] args) {
        // Food 객체 생성
        Food aa = new Food("탕수육", 616);
        Food bb = new Food("라면", 460);
        Food cc = new Food("돈까스", 960);
        Food dd = new Food("떡볶이", 482);
        Food ee = new Food("짜장면", 670);
        
        // Food 객체를 리스트에 추가
        List<Food> list = new ArrayList<>(); // Food 객체를 담을 ArrayList 생성
        list.add(aa);
        list.add(bb);
        list.add(cc);
        list.add(dd);
        list.add(ee);
        
        // calorie가 500을 넘는 음식만 필터링하고 오름차순으로 정렬하여 음식명을 출력
        List<Food> calorieList = new ArrayList<>(); // 500칼로리 이상인 Food 객체를 담을 ArrayList 생성
        for (Food food : list) { // 리스트를 순회하면서
            if (food.getCalorie() > 500) // 500칼로리 이상인 경우
                calorieList.add(food); // calorieList에 추가
        }
        
        // calorieList를 칼로리 기준으로 오름차순 정렬
        Collections.sort(calorieList, new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                return Integer.compare(f1.getCalorie(), f2.getCalorie()); // 칼로리를 기준으로 정렬
            }
        });
        
        // 정렬된 리스트에서 음식명만 추출하여 새로운 리스트에 저장
        List<String> foodName = new ArrayList<>();
        for (Food food : calorieList) { // 정렬된 calorieList를 순회하면서
            foodName.add(food.getName()); // 음식명만 추출하여 foodName 리스트에 추가
        }
        
        // 추출한 음식명 리스트를 출력
        System.out.println(foodName);
        System.out.println();
        // 위의 작업을 Stream을 이용하여 간단하게 처리
        // Stream 이용 (내부 반복이기 때문에, Collections 안에서 작업)
        // 리스트 안에 String 객체를 설정
        List<String> foodNameList = list.stream() // 리스트에서 스트림 생성
                .filter(f -> f.getCalorie() > 500) // 500칼로리 이상인 음식만 필터링
                .sorted(Comparator.comparing(Food::getCalorie)) // 칼로리 기준으로 오름차순 정렬
                .map(Food::getName) // 음식명만 추출
                // .map(f -> f.getName()) 동일한 표현
                .collect(Collectors.toList()); // 결과를 리스트로 변환
        // 추출한 음식명 리스트를 출력
        System.out.println(foodNameList);
        System.out.println();
        //------------------------------------------------------------
        // 합계
        // .reduce(초기값, (누적변수, 요소) -> 처리문)
        // .reduce()는 Stream 의 요소들을 하나의 데이터로 만드는 작업을 수행
        // 시작은 정수형/실수형 Stream 을 설정 (Int/DoubleStream)
        IntStream stream = IntStream.range(1, 5); // range() 함수는 끝 수를 포함하지 않음 = 1, 2, 3, 4 까지만 포함
        int sum = stream.reduce(0, (total, num) -> total + num); // 0부터 시작하여 각 요소를 더하여 합계를 구함
        System.out.println("합계 = " + sum);
        System.out.println();
        
        IntStream stream2 = IntStream.rangeClosed(1, 5); // rangeClosed() 함수는 끝 수를 포함함 = 1, 2, 3, 4, 5 까지 포함
        stream2.forEach(x -> hap += x); // 각 요소를 합하여 hap 변수에 저장
        System.out.println("합계 = " + hap);
        System.out.println();
    }
}

/*
Stream API에 대한 상세 설명:
Java Stream API는 컬렉션 데이터를 처리하는 데 매우 유용한 도구입니다. 여기서, Stream API를 사용하는 이유와 각 메서드의 역할을 설명합니다.
1. `stream()` 메서드:
   - 이 메서드는 리스트(혹은 다른 컬렉션)에서 스트림을 생성합니다.
   - 스트림은 데이터를 일관성 있게 처리할 수 있도록 해주는 추상화된 도구입니다.
   - 예: `list.stream()`은 리스트에서 스트림을 생성합니다.
2. `filter` 메서드:
   - 스트림에서 특정 조건에 맞는 요소만 걸러낼 때 사용합니다.
   - 여기서는 음식 칼로리가 500을 초과하는 경우에만 필터링합니다.
   - 예: `.filter(f -> f.getCalorie() > 500)`은 칼로리가 500을 초과하는 음식만 필터링합니다.
3. `sorted` 메서드:
   - 스트림의 요소를 정렬합니다.
   - 여기서는 칼로리를 기준으로 오름차순 정렬합니다.
   - 예: `.sorted(Comparator.comparing(Food::getCalorie))`은 칼로리를 기준으로 오름차순 정렬합니다.
4. `map` 메서드:
   - 스트림의 요소를 다른 형태로 변환합니다.
   - 여기서는 Food 객체를 음식 이름(String)으로 변환합니다.
   - 예: `.map(Food::getName)`은 Food 객체를 음식 이름으로 변환합니다.
5. `collect` 메서드:
   - 스트림의 처리 결과를 컬렉션(리스트 등)으로 변환합니다.
   - 예: `.collect(Collectors.toList())`은 스트림의 요소를 리스트로 변환합니다.
위의 Stream API를 이용하면 리스트를 간결하고 직관적으로 처리할 수 있습니다. 반복문을 사용한 기존 코드와 비교했을 때, Stream API는 코드가 더 짧고 가독성이 높습니다. 또한, 내부 반복을 사용하여 성능 면에서도 유리합니다.

.reduce 메서드에 대한 설명:
- .reduce() 메서드는 스트림의 요소들을 하나의 결과값으로 결합할 때 사용되는 최종 연산입니다.
- 이 메서드는 초기값과 누적 변수, 요소를 사용하여 연산을 수행합니다.
- 예: `stream.reduce(0, (total, num) -> total + num);`은 스트림의 각 요소를 더하여 합계를 계산합니다.
- 초기값은 연산의 시작값을 지정하며, 람다식은 누적 변수와 현재 요소를 사용하여 연산을 수행합니다.

.range()와 .rangeClosed() 메서드:
- IntStream.range(1, 5)는 1부터 4까지의 정수 스트림을 생성합니다.
- IntStream.rangeClosed(1, 5)는 1부터 5까지의 정수 스트림을 생성합니다.
- range()는 끝 값을 포함하지 않고, rangeClosed()는 끝 값을 포함합니다.
- 이 메서드들을 사용하여 원하는 범위의 정수 스트림을 생성할 수 있습니다.
*/
