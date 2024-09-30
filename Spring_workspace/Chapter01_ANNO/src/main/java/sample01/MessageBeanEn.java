package sample01;

public class MessageBeanEn implements MessageBean {
	
	public MessageBeanEn() {
		System.out.println("MessageBeanEn 기본 생성자 입니다.");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
		
	}

}
