package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;

@Configuration // 이 클래스는 스프링의 설정 파일임을 나타내는 어노테이션입니다. XML 설정 파일 대신 자바 클래스를 통해 빈을 정의합니다.
@EnableAspectJAutoProxy // AOP 설정을 활성화하는 어노테이션으로, @Aspect 어노테이션을 사용한 클래스를 자동으로 프록시로 감싸 AOP를 적용할 수 있도록 합니다.
public class SpringConfiguration {

    @Bean // messageBeanImpl 빈을 생성하는 메서드입니다. 이 메서드를 통해 MessageBeanImpl 객체가 스프링 컨테이너에 등록됩니다.
    public MessageBeanImpl messageBeanImpl() {
        return new MessageBeanImpl(); // MessageBeanImpl 객체를 생성하여 반환합니다.
    }

    @Bean // loggingAdvice 빈을 생성하는 메서드입니다. 공통 관심사를 처리하는 LoggingAdvice 객체를 스프링 컨테이너에 등록합니다.
    public LoggingAdvice loggingAdvice() {
        return new LoggingAdvice(); // LoggingAdvice 객체를 생성하여 반환합니다.
    }
}
