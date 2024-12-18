package sample05;

public class MessageBeanImpl implements MessageBean {

    // 필드 선언
    private String name;  // name 필드는 이 객체에서 사용할 이름을 저장하는 역할을 합니다.
    private String phone; // phone 필드는 전화번호를 저장합니다.
    private Outputter outputter; // outputter는 메시지를 출력하는 역할을 하는 Outputter 인터페이스 타입의 객체를 저장합니다.

    // 생성자: 객체가 생성될 때 호출되며, name 필드를 초기화합니다.
    // 생성자를 통해 객체를 만들 때 반드시 이름 값을 전달해야 합니다.
    public MessageBeanImpl(String name) {
        this.name = name; // 전달받은 이름을 객체의 name 필드에 저장합니다.
        System.out.println("MessageBeanImpl(String name)"); // 객체가 생성되었음을 확인하기 위한 출력문입니다.
    }

    // setPhone 메서드: 외부에서 phone 필드에 값을 설정할 수 있게 하는 setter 메서드입니다.
    // phone 필드는 private로 선언되어 있기 때문에, 이 메서드를 통해서만 값을 설정할 수 있습니다.
    public void setPhone(String phone) {
        this.phone = phone; // 전달받은 전화번호를 객체의 phone 필드에 저장합니다.
        System.out.println("setPhone(String phone)"); // phone 필드가 설정되었음을 확인하기 위한 출력문입니다.
    }

    // setOutputter 메서드: 외부에서 Outputter 타입의 객체를 주입할 수 있는 setter 메서드입니다.
    // 의존성 주입(Dependency Injection)을 통해 Outputter 객체를 설정합니다.
    // 이 객체는 메시지를 출력하는 역할을 담당하며, 인터페이스를 사용하여 다양한 구현체가 주입될 수 있습니다.
    public void setOutputter(Outputter outputter) {
        this.outputter = outputter; // 전달받은 Outputter 객체를 outputter 필드에 저장합니다.
        System.out.println("setOutputter(Outputter outputter)"); // outputter 필드가 설정되었음을 확인하기 위한 출력문입니다.
    }

    // helloCall 메서드: 이 메서드는 name과 phone 정보를 출력하는 기능을 수행합니다.
    // Outputter 객체의 output 메서드를 호출하여 메시지를 출력합니다.
    // 이 메서드는 주로 다른 클래스나 컨트롤러에서 호출되어 메시지를 생성하고 출력하는 역할을 합니다.
    @Override
    public void helloCall() {
        System.out.println("helloCall()"); // 메서드 호출을 확인하기 위한 출력문입니다.
        // Outputter 객체의 output 메서드를 호출하여 name과 phone 정보를 출력합니다.
        // "나의 이름은 [name]이고, 전화번호는 [phone]이다." 형식의 메시지를 출력하게 됩니다.
        // 출력 방식은 주입된 Outputter 구현체에 따라 달라질 수 있습니다.
        outputter.output("나의 이름은 " + name + "이고, 전화번호는 " + phone + "이다. \n");
        // Outputter의 역할: 이 객체는 실제 출력 작업을 수행합니다.
        // 예를 들어, 파일에 출력하거나 콘솔에 출력하는 다양한 방식으로 구현할 수 있으며, 그 구현체는 외부에서 주입됩니다.
        outputter.output(name + "에게는 " + phone + "이라는 번호가 있꼬...");
       
    }

}
