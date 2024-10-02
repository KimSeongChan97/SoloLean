package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * @RequiredArgsConstructor는 Lombok의 어노테이션으로, 
 * final 또는 @NonNull로 표시된 필드들에 대해 생성자를 자동으로 생성해 줍니다.
 * 이 클래스에서는 fruit 필드가 @NonNull로 표시되어 있어, 이 필드를 초기화하는 생성자가 자동으로 만들어집니다.
 * 기존 주석처럼 따로 생성자를 정의하지 않아도 Lombok이 생성자를 제공하게 됩니다.
 */

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
    // @NonNull은 이 필드가 null이 될 수 없음을 나타내며, 해당 필드의 초기화가 반드시 필요합니다.
    // @RequiredArgsConstructor에 의해 이 필드를 초기화하는 생성자가 자동으로 생성됩니다.
    @NonNull
    private String fruit;
    
    // @Setter는 Lombok이 자동으로 setter 메서드를 생성해 줍니다.
    // 이로 인해 따로 setCost() 메서드를 작성하지 않아도, cost 필드에 값을 설정할 수 있습니다.
    @Setter
    private int cost;

    // @Setter를 사용하여 qty 필드에 대해 setter 메서드가 자동으로 생성됩니다.
    @Setter
    private int qty;

    /*
     * 이 부분은 주석 처리된 생성자와 setter 메서드들입니다.
     * @RequiredArgsConstructor와 @Setter가 이를 대신하여 자동으로 생성해 주므로, 
     * 수동으로 메서드를 작성할 필요가 없습니다.
     * 주석 처리된 생성자와 메서드는 참고용으로 남겨두었습니다.
     * 
     * public MessageBeanImpl(String fruit) { this.fruit = fruit; }
     * 
     * public void setCost(int cost) { this.cost = cost; }
     * 
     * public void setQty(int qty) { this.qty = qty; }
     */

    @Override
    public void sayHello() {
        // 기본적으로 fruit, cost, qty의 값을 출력하는 메서드입니다.
        // 여기서 각각의 값은 객체가 생성되고 나서 설정된 값을 출력합니다.
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    }

    @Override
    public void sayHello(String fruit, int cost) {
        // 이 오버로드된 메서드는 새로운 fruit와 cost 값을 받아서 출력합니다.
        // qty 값은 클래스의 필드에 설정된 값을 그대로 사용합니다.
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    }

    @Override
    public void sayHello(String fruit, int cost, int qty) {
        // 이 오버로드된 메서드는 fruit, cost, qty의 값을 모두 받아서 출력합니다.
        // 이 메서드를 호출하면 필드에 저장된 값이 아닌, 전달된 인자값들이 출력됩니다.
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    }
}
