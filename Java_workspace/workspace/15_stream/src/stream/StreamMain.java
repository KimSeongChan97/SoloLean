package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        // 리스트(ArrayList) 생성 및 초기화
        List<String> list = new ArrayList<>();
        list.add("이제훈");
        list.add("엄태구");
        list.add("이동욱");
        list.add("안효섭");
        list.add("이준기");
        list.add("나인우");
        list.add("아무이름이나 추가");
        
        // 외부 반복 (for 문) : 인덱스를 사용하여 리스트의 각 요소를 반복하면서 출력
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); 
        }
        System.out.println();
        
        // 반복 작업 (Iterator 사용) : Iterator 인터페이스를 사용하여 리스트의 각 요소를 반복하면서 출력
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        
        // 스트림을 사용한 내부 반복 : 컬렉션의 각 요소를 스트림을 통해 반복하면서 출력
        // .forEach 메서드를 사용하여 람다식으로 처리
        Stream<String> stream = list.stream(); // 스트림 생성
        stream.forEach(name -> System.out.println(name)); // 람다식을 사용하여 요소 출력
        System.out.println();
        
        // 메서드 참조(Method Reference)를 사용하여 스트림의 각 요소를 출력
        // 위의 줄과 같은 내용이지만 다른 형식으로 메서드 참조를 사용하여 출력 ( forEach )
        stream = list.stream(); // 스트림을 다시 생성
        stream.forEach(System.out::println); // 메서드 참조를 사용한 출력
    }
}

/*

스트림(Stream)
스트림(Stream)은 자바 8 API에 새로 추가된 기능이다.
람다를 활용해 배열과 컬렉션을 함수형으로 간단하게 처리할 수 있는 기술이다.

기존 방식의 외부 반복과 달리, 스트림을 사용하면 내부 반복을 통해 코드가 간결해지고 가독성이 높아집니다.
스트림은 데이터 소스를 추상화하여 일련의 연산을 수행하며, 람다식과 함께 사용하면 더욱 효과적입니다.

1. 외부 반복(External Iteration): for 문이나 Iterator 를 사용한 방식.
2. 내부 반복(Internal Iteration): 스트림(Stream)을 사용한 방식.

스트림을 사용한 내부 반복의 장점:
- 코드가 간결해집니다.
- 가독성이 높아집니다.
- 병렬 처리가 용이합니다.
- 다양한 중간 연산과 최종 연산을 조합하여 복잡한 작업을 간단하게 수행할 수 있습니다.

위 예제에서는 스트림을 사용하여 리스트의 각 요소를 출력하는 방법을 보여줍니다.
람다식과 메서드 참조를 사용하여 더욱 간결하고 명확하게 코드를 작성할 수 있습니다.

.forEach 메서드에 대한 자세하고 상세한 내용:

1. forEach 메서드 개요:
   - forEach 메서드는 스트림의 각 요소에 대해 지정된 동작(Consumer)을 수행하는 최종 연산입니다.
   - 이 메서드는 각 요소에 대해 한 번씩 동작을 수행하며, 일반적으로 요소를 출력하거나, 요소를 다른 형태로 변환하거나, 요소를 기반으로 다른 작업을 수행할 때 사용됩니다.

2. 람다식과 함께 사용하기:
   - forEach 메서드는 람다식을 매개변수로 받아서 각 요소에 대해 실행합니다.
   - 예: `stream.forEach(name -> System.out.println(name));`
     이 코드는 스트림의 각 요소를 출력합니다.
   - 람다식은 익명 함수로, `name -> System.out.println(name)`은 `name`을 입력으로 받아 `System.out.println(name)`을 실행하는 함수를 의미합니다.

3. 메서드 참조와 함께 사용하기:
   - forEach 메서드는 메서드 참조를 사용할 수도 있습니다. 메서드 참조는 기존 메서드를 람다식으로 변환하는 더 간결한 방식입니다.
   - 예: `stream.forEach(System.out::println);`
     이 코드는 `System.out.println` 메서드를 스트림의 각 요소에 대해 호출합니다.
   - 메서드 참조는 `클래스이름::메서드이름` 형식을 사용하여, 람다식의 간결한 대안으로 사용할 수 있습니다.

4. 최종 연산(Terminal Operation):
   - forEach는 스트림의 최종 연산 중 하나로, 스트림의 요소를 소모하며, 스트림 파이프라인을 종료시킵니다.
   - 최종 연산이 호출된 후에는 스트림을 다시 사용할 수 없으며, 새로운 스트림을 생성해야 합니다.
   - 예제에서 `stream.forEach(System.out::println);`을 두 번 호출하기 위해서는 두 번째 호출 전에 새로운 스트림을 생성해야 합니다.

이와 같이 forEach 메서드는 스트림의 각 요소에 대해 반복 작업을 수행할 때 유용하게 사용됩니다. 스트림을 활용하면 기존의 반복문보다 간결하고 직관적인 코드 작성을 할 수 있습니다.

*/
