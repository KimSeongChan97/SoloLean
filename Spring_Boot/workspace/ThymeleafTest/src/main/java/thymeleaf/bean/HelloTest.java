package thymeleaf.bean;

import org.springframework.stereotype.Component;

@Component("helloTest")
public class HelloTest {

	public String hello(String name) {
		return "안녕하세요 ! " + name;
	}
	
	
}
