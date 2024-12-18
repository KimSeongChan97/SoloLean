package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping; // 클라이언트의 요청을 특정 메서드와 매핑하기 위해 사용하는 어노테이션
import org.springframework.web.bind.annotation.RequestParam; // 요청 파라미터를 메서드 파라미터로 받을 때 사용하는 어노테이션
import org.springframework.web.bind.annotation.RestController; // RESTful 웹 서비스를 위한 컨트롤러임을 나타내는 어노테이션

// @Controller 가 아닌 @RestController 를 통해 ResposeBody 의 역할을 대신 한다.
@RestController // @RestController는 JSP 같은 뷰를 별도로 만들지 않는 대신에 컨트롤러 메소드가 리턴하는 데이터 자체를 클라이언트로 보낸다.
// - @RestController는 @Controller와 @ResponseBody 어노테이션을 합친 것과 같은 역할을 합니다.
// - 즉, 메서드의 반환 값이 뷰(JSP 파일 등)로 전달되지 않고, 그대로 HTTP 응답의 본문(Body)으로 전달됩니다.
// - REST API나 JSON 데이터를 반환하는 웹 서비스에서 주로 사용됩니다.
public class HelloController { // HelloController 클래스 선언부. 이 클래스는 HTTP 요청을 처리하는 컨트롤러 역할을 합니다.
    // Bean 설정 하였다.
    
    public HelloController() { // HelloController 클래스의 생성자. 이 생성자가 호출될 때마다 객체가 생성됨을 알리기 위해 메시지를 출력합니다.
        System.out.println("HelloController 의 생성자 입니다.");	
        // "HelloController 생성자 입니다."라는 메시지를 콘솔에 출력합니다.
        // 이 메시지를 통해 HelloController 객체가 생성되었음을 확인할 수 있습니다.
    };
    
    @RequestMapping(value="/") // HTTP 요청의 URL을 메서드와 매핑합니다. "/" 경로로 요청이 들어오면 index() 메서드가 호출됩니다.
    //@ResponseBody // Browser 에 문자열 바로 뿌리기(JSP, HTML 등을 거치지 않고..)
    // - @ResponseBody 어노테이션은 메서드의 반환 값을 HTTP 응답의 본문으로 전달할 때 사용됩니다.
    // - @RestController 사용 시 @ResponseBody는 생략 가능하며, 메서드의 반환 값이 그대로 클라이언트에게 전달됩니다.
    public String index() { // index 메서드는 "/" URL 요청에 대한 응답을 처리합니다.
        return "Hello Spring Boot Gradle !! ";
        // 문자열 "Hello Spring Boot Gradle !! "를 반환합니다.
        // 이 문자열은 브라우저에 직접 출력되며, 뷰(JSP 또는 HTML 파일)를 거치지 않습니다.
        // 따라서 클라이언트는 이 메시지를 HTTP 응답 본문으로 받게 됩니다.
    };
    
    @RequestMapping(value="/hello") // "/hello" 경로로 요청이 들어오면 hello() 메서드가 호출됩니다.
    public String hello(@RequestParam(value="name") String name) { // 요청 파라미터 "name"을 메서드 파라미터로 받습니다.
        return "안녕하세요 ! " + name + " 님 !! ";
        // "안녕하세요 ! [name] 님 !!"이라는 메시지를 반환합니다.
        // 예를 들어, http://localhost:9000/hello?name=홍길동 라고 요청하면
        // "안녕하세요 ! 홍길동 님 !!"이라는 메시지가 출력됩니다.
        // @RequestParam을 통해 URL 요청에서 전달된 파라미터를 받아와서 메서드 내에서 사용할 수 있게 됩니다.
        // 사용 예: http://localhost:9000/hello?변수=값&변수=값...
    };
    
};
