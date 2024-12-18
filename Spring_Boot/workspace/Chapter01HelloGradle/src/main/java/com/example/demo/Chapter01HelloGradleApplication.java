package com.example.demo; // 패키지 선언. 이 클래스가 'com.example.demo' 패키지에 속해 있음을 나타냅니다.

import org.springframework.boot.SpringApplication; // Spring Boot 애플리케이션을 시작하고 관리하는 클래스
import org.springframework.boot.WebApplicationType; // Spring Boot 애플리케이션이 웹 애플리케이션으로 동작할지 여부를 설정하는 Enum 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication; // 스프링 부트 자동 설정을 활성화하는 어노테이션
import org.springframework.context.annotation.ComponentScan;

/**
 * @SpringBootApplication
 * - 스프링 부트 애플리케이션의 시작 클래스를 지정하기 위해 사용됩니다.
 * - 이 어노테이션은 여러 어노테이션의 기능을 포함하고 있습니다:
 *   1. @Configuration: 이 클래스가 스프링 설정 클래스(Bean 설정 파일)로 사용됨을 나타냅니다.
 *   2. @EnableAutoConfiguration: 스프링 부트가 클래스패스에서 필요한 설정을 자동으로 로드합니다.
 *      예를 들어, 'spring-boot-starter-web'이 포함되어 있으면, 내장 톰캣 서버와 스프링 MVC 설정이 자동으로 완료됩니다.
 *   3. @ComponentScan: 현재 패키지(com.example.demo)와 하위 패키지에 있는 @Component, @Service, @Repository 등이 
 *   붙은 클래스들을 스프링 빈으로 자동 등록합니다.
 */
@ComponentScan(basePackages = {"com.example.demo", "board.controller"})
@SpringBootApplication
public class Chapter01HelloGradleApplication { // 'Chapter01HelloGradleApplication'이라는 클래스 선언부

    /**
     * main 메서드: 자바 애플리케이션의 진입점(Entry Point)입니다.
     * - 모든 자바 애플리케이션은 main 메서드에서 실행을 시작합니다.
     * - 스프링 부트에서는 main 메서드를 통해 애플리케이션이 시작되며, 이 메서드를 통해 내장 서버(톰캣 등)를 실행하고 스프링 애플리케이션을 초기화합니다.
     * - 이 메서드에서 SpringApplication.run()을 호출하여 스프링 부트 애플리케이션을 실행합니다.
     *
     * @param args: 커맨드 라인에서 전달된 인자를 배열 형태로 받습니다.
     */
    public static void main(String[] args) {
        // SpringApplication.run(Chapter01HelloGradleApplication.class, args); // 스프링 부트 애플리케이션을 실행하는 메서드입니다.
        // SpringApplication.run() 메서드의 역할:
        // 1. 스프링 애플리케이션 컨텍스트를 초기화하고 필요한 빈을 생성 및 설정합니다.
        // 2. 웹 애플리케이션의 경우 내장된 톰캣 서버를 구동하여 별도의 서버 설정 없이 애플리케이션을 실행할 수 있도록 합니다.
        // 3. main 메서드의 인자(args)를 애플리케이션에 전달하여 커맨드 라인에서 전달된 파라미터가 애플리케이션에서 사용될 수 있게 합니다.

        SpringApplication springApplication = new SpringApplication(Chapter01HelloGradleApplication.class); 
        // SpringApplication 객체를 생성하고, Chapter01HelloGradleApplication 클래스에서 애플리케이션을 초기화합니다.
        
        springApplication.setWebApplicationType(WebApplicationType.NONE); 
        // 애플리케이션의 웹 애플리케이션 타입을 NONE으로 설정하여 웹 서버를 실행하지 않도록 설정합니다.
        // WebApplicationType.NONE: 웹 서버를 사용하지 않도록 설정하여 일반 자바 애플리케이션처럼 동작하게 합니다.
        // 웹 애플리케이션이 아닌, 콘솔 애플리케이션이나 배치 프로그램을 실행할 때 유용합니다.
        
        springApplication.run(args); // 설정된 SpringApplication 객체를 통해 애플리케이션을 실행합니다.
        // 이 메서드는 애플리케이션을 실제로 시작하며, 이전에 설정된 WebApplicationType에 따라 웹 서버가 실행되지 않도록 합니다.

        System.out.println(" Hello Spring Boot ( Gradle ) "); 
        // "Hello Spring Boot ( Gradle )" 메시지를 콘솔에 출력합니다.
        // Gradle 빌드 시스템을 사용하여 프로젝트가 실행되었음을 표시하는 메시지입니다.
    }

}

/*
- 스프링 부트로 만든 애플리케이션은 일반 자바 애플리케이션으로 실행할 수도 있고
  웹 애플리케이션으로 실행할 수도 있다.
- 기본적으로 작성된 메인 클래스를 실행하면 웹 애플리케이션으로 실행된다.
  내장 Tomcat이 구동되고 브라우저에서 전송한 요청을 처리할 수 있다.
  하지만 코드를 수정하여 일반 자바 애플리케이션으로 실행하면 내장 Tomcat은 구동되지 않는다.
  
WebApplicationType 으로 설정할 수 있는 3가지 타입
① WebApplicationType.NONE – 웹으로 동작하지 않도록 설정
② WebApplicationType.SERVLET – 기존의 스프링 MVC를 기반으로 웹 애플리케이션을 구동하는 설정
③ WebApplicationType.REACTIVE – 스프링 5.0에서 추가된 비동기 처리와 논블로킹 입출력을 지원하는 웹플럭스(WebFlux)를 적용할 때 사용

외부 프로퍼티 사용
src/main/resources 의 application.properties 파일은 전체 프로젝트의 프로퍼티 정보를 관리하는 설정 파일이다.
자바 소스보다 application.properties 설정이 우선순위가 높다.
자바 소스에서 WebApplicationType.NONE 으로 설정했어도 프로퍼티 설정의 우선순위가 높기 때문에 웹 애플리케이션이 실행된다.

application.properties : Servlet-context.xml, root-context.xml 의 역할을 다 한다.

application.properties에 설정한 프로퍼티 정보들은 실제 해당 Properties 객체의 Setter 메소드가 호출되어 의존성이 주입된다는 것이다.
Ctrl 키를 누른 상태에서 server.port에 마우스를 대면 하이퍼링크로 변한다. 링크를 클릭하면 ServerProperties 클래스의 setPort() 메소드가 선택된다.

사용자가 정의한 클래스들이 자동으로 빈으로 등록되기 때문에 스프링 부트에서는 패키지 이름을 주의해서 작성해야 한다.
만약 루트 패키지인 "com.example.demo" 가 아닌 다른 패키지에 클래스를 작성하면 스프링 컨테이너는 해당 클래스를 빈으로 등록하지 않는다. 
다른 패키지의 클래스까지 스캔 대상에 포함 시키려면 메인 클래스에 @ComponentScan을 추가하여 패키지를 직접 지정하면 된다.

*/
