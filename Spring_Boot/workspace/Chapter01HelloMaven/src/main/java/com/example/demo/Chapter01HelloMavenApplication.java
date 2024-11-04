package com.example.demo; // 패키지 선언. 이 클래스가 'com.example.demo' 패키지에 속해 있음을 나타냅니다.

import org.springframework.boot.SpringApplication; // Spring Boot 애플리케이션을 시작하고 관리하는 기본 클래스.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Spring Boot의 자동 설정을 활성화하는 어노테이션.

/**
 * @SpringBootApplication
 * - 스프링 부트로 만든 애플리케이샨 시작 클래스임을 의미한다.
 * - 이 어노테이션은 여러 개의 기능을 포함하고 있으며, 그 중 주요 기능은 다음과 같습니다:
 *   1. @Configuration: 이 클래스를 스프링의 설정 클래스(Bean 설정 파일)로 사용하겠다는 의미입니다.
 *   2. @EnableAutoConfiguration: 스프링 부트가 클래스패스에 있는 라이브러리들을 자동으로 설정하게 합니다.
 *      예를 들어, 'spring-boot-starter-web'이 포함되어 있으면, 스프링 부트는 자동으로 내장 톰캣 서버와 스프링 MVC를 설정합니다.
 *   3. @ComponentScan: 현재 패키지(com.example.demo)와 그 하위 패키지에 있는 @Component, @Service, @Repository 등이 붙은 클래스를 스프링 빈으로 등록합니다.
 */
@SpringBootApplication // 스프링 부트로 만든 애플리케이샨 시작 클래스임을 의미한다.
public class Chapter01HelloMavenApplication { // 'Chapter01HelloMavenApplication'이라는 클래스 선언부.

    /**
     * main 메서드: 자바 애플리케이션의 진입점(Entry Point)입니다.
     * - 모든 자바 애플리케이션은 main 메서드에서 시작됩니다.
     * - 스프링 부트에서는 main 메서드를 통해 내장 톰캣 서버를 시작하고, 스프링 애플리케이션 컨텍스트(Application Context)를 초기화합니다.
     * - 이 메서드에서 SpringApplication.run() 메서드를 호출하여 스프링 부트 애플리케이션을 시작합니다.
     *
     * @param args: 커맨드 라인에서 전달받은 인자들을 문자열 배열 형태로 받습니다.
     */
    public static void main(String[] args) {
        SpringApplication.run(Chapter01HelloMavenApplication.class, args); // 스프링 부트 애플리케이션을 시작하는 메서드 호출.
        
        // SpringApplication.run()은 다음 작업들을 수행합니다:
        // 1. 스프링 애플리케이션의 초기화: 스프링의 애플리케이션 컨텍스트(Application Context)를 생성하고 필요한 설정과 Bean들을 초기화합니다.
        // 2. 내장 서버 실행: 웹 애플리케이션일 경우 내장된 톰캣 서버를 실행하여 외부 서버 설정 없이도 애플리케이션을 구동할 수 있도록 합니다.
        // 3. 커맨드 라인 파라미터 전달: main 메서드의 args 배열을 통해 전달된 커맨드 라인 인자를 애플리케이션으로 전달합니다.

        System.out.println("Hello Spring Boot(Maven)");
    }

}
