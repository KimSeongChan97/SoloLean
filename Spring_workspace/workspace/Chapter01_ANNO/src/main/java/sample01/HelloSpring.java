package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("helloSpringSample01")
public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean messageBean = (MessageBean) context.getBean("messageBean"); 
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = (MessageBean) context.getBean("messageBean");
		messageBean2.sayHello("Spring");
		System.out.println();

		MessageBean messageBean3 = (MessageBean) context.getBean("messageBean");
		messageBean3.sayHello("Spring");
		System.out.println();
	} 

}
