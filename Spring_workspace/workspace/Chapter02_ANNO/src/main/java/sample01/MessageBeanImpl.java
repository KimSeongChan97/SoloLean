package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// @Component
// @Component는 Spring에서 이 클래스를 Bean으로 등록하겠다는 것을 의미합니다.
// 이 클래스는 Spring 컨테이너에서 관리되며, 별도의 XML 설정 없이 자동으로 Bean으로 등록됩니다.
public class MessageBeanImpl implements MessageBean {

    private String fruit; // 과일 이름을 저장할 필드입니다.
    private int cost; // 과일의 가격을 저장할 필드입니다.
    private int qty; // 과일의 수량을 저장할 필드입니다.

    // @Value는 해당 필드나 생성자 파라미터에 기본값을 주입하는 역할을 합니다.
    // 여기서는 "사과"라는 값을 fruit 필드에 주입합니다.
    public MessageBeanImpl(@Value("사과") String fruit) { 
        this.fruit = fruit; 
        // 생성자가 호출될 때 "사과"라는 값이 fruit 변수에 할당됩니다.
    }

    @Autowired
    // @Autowired는 Spring이 해당 메서드를 자동으로 호출하여 의존성을 주입하게 해 줍니다.
    // 이 경우 setCost 메서드는 스프링 컨테이너에 의해 호출되고, @Value로 지정된 "5000"이 cost 필드에 주입됩니다.
    public void setCost(@Value("5000") int cost) { 
        this.cost = cost; 
        // "5000"이라는 값이 cost 필드에 설정됩니다. 가격 정보가 설정되는 부분입니다.
    }

    @Autowired
    // setQty 메서드 역시 @Autowired로 Spring이 자동으로 호출하며, @Value로 설정된 "3"이 qty 필드에 주입됩니다.
    public void setQty(@Value("3") int qty) { 
        this.qty = qty; 
        // "3"이라는 값이 qty 필드에 설정됩니다. 과일의 수량 정보가 설정되는 부분입니다.
    }

    @Override
    public void sayHello() {
        // 이 메서드는 필드에 저장된 fruit, cost, qty 값을 콘솔에 출력합니다.
        // 여기서 사용되는 값은 스프링 설정이나 주입된 값들입니다.
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    }

    @Override
    public void sayHello(String fruit, int cost) {
        // 이 메서드는 호출 시 전달된 fruit와 cost 값만 출력합니다.
        // qty 값은 필드에 설정된 값을 그대로 출력합니다.
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    }

    @Override
    public void sayHello(String fruit, int cost, int qty) {
        // 이 메서드는 호출된 값으로 세 개의 값을 모두 출력합니다.
        // 전달된 fruit, cost, qty 값이 출력됩니다.
        System.out.println(fruit + "\t" + cost + "\t" + qty);
    }
}
