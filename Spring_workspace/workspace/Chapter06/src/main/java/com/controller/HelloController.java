package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// @Controller는 이 클래스가 Spring MVC에서 컨트롤러 역할을 한다는 것을 나타냅니다.
// Spring MVC에서 요청을 처리하는 클래스임을 명시하는 어노테이션입니다. 
// 이 어노테이션을 통해 Spring은 이 클래스를 빈(Bean)으로 등록하고, 웹 요청이 들어왔을 때 해당 클래스가 호출됩니다.
// Spring 컨트롤러는 사용자의 HTTP 요청을 처리하고 그 결과를 뷰(JSP 등)로 전달하는 역할을 합니다.
// 추가 주석: Spring MVC에서는 @Controller 어노테이션을 사용하여 특정 클래스를 컨트롤러로 지정하며, 
// 클라이언트가 보낸 요청을 받아 적절한 비즈니스 로직을 처리하고 결과를 반환합니다.

@Controller
public class HelloController {
    
    // @RequestMapping은 특정 URL 요청을 이 메서드가 처리하도록 매핑하는 어노테이션입니다.
    // 여기서는 "hello.do"라는 URL로 들어오는 GET 요청을 처리하도록 설정했습니다.
    // 즉, 클라이언트가 "hello.do" URL로 GET 요청을 보내면 이 메서드가 호출됩니다.
    // method=RequestMethod.GET은 이 메서드가 GET 방식의 요청만 처리하도록 제한하는 역할을 합니다.
    // 추가 주석: @RequestMapping 어노테이션은 HTTP 요청을 처리할 메서드를 지정합니다.
    // method=RequestMethod.GET은 이 메서드가 오직 GET 방식의 요청만 처리한다는 것을 나타냅니다.
    // POST 요청이 오면 이 메서드는 호출되지 않습니다. 이처럼 method 속성으로 특정 HTTP 메서드에만 반응하도록 제어할 수 있습니다.
	@RequestMapping(value="hello.do", method=RequestMethod.GET)
    public ModelAndView hello() { // 사용자가 만든 콜백메서드
        // 사용자가 정의한 콜백 메서드로, "hello.do"로 들어온 요청을 처리합니다.
        // 이 메서드는 요청을 받아 비즈니스 로직을 처리하고, 뷰에 전달할 데이터를 생성한 뒤 이를 ModelAndView 객체에 담아 반환합니다.
        // 추가 주석: 클라이언트가 "hello.do" 경로로 요청을 보내면 이 메서드가 호출됩니다.
        // 이 메서드는 ModelAndView 객체를 사용하여 결과 데이터와 뷰 정보를 함께 반환합니다.
        
        ModelAndView mav = new ModelAndView();
        // ModelAndView는 모델과 뷰 정보를 함께 담는 객체입니다.
        // 모델(Model)은 처리한 데이터를 담고, 뷰(View)는 결과를 보여줄 페이지를 나타냅니다.
        // 이 객체를 통해 클라이언트에게 보여줄 데이터를 설정하고, 어느 뷰로 응답할지 결정할 수 있습니다.
        // 추가 주석: ModelAndView는 뷰와 데이터를 동시에 처리할 수 있게 도와줍니다.
        // 여기서 데이터를 추가하고 뷰 이름을 설정하면 Spring이 해당 데이터를 뷰에 전달하여 클라이언트에게 응답을 생성합니다.

        mav.addObject("result", " Hello Spring MVC!! ");
        // addObject() 메서드는 Model에 데이터를 추가하는 메서드입니다.
        // 여기서는 "result"라는 이름으로 "Hello Spring MVC!!"라는 문자열을 모델에 추가하고 있습니다.
        // 이 데이터를 JSP 페이지에서 ${result}와 같은 방식으로 출력할 수 있습니다.
        // 이 방식은 JSP와 같은 뷰에서 데이터를 쉽게 참조할 수 있도록 모델에 값을 전달하는 방법입니다.
        // 추가 주석: "result"는 JSP와 같은 뷰에서 데이터를 참조할 수 있는 키(Key)입니다.
        // "Hello Spring MVC!!"라는 값이 JSP에서 ${result}로 참조될 수 있도록 전달됩니다.
        // 뷰는 이 데이터를 사용하여 동적으로 화면을 구성할 수 있습니다.

        mav.setViewName("view/hello");
        // mav.setViewName("hello");
        // 화면에 보여줘야할 이름(JSP 파일명), 즉 hello.jsp 를 찾으라는 의미
        // setViewName() 메서드는 응답할 뷰의 이름을 설정하는 메서드입니다.
        // 여기서는 "hello"라는 이름의 JSP 파일을 응답으로 설정하고 있습니다.
        // Spring MVC는 기본적으로 "WEB-INF/views/hello.jsp" 파일을 찾아 렌더링합니다.
        // 즉, 클라이언트는 "hello.jsp"라는 화면을 보게 됩니다.
        // 추가 주석: setViewName()을 통해 응답할 JSP 파일을 설정합니다.
        // Spring은 "WEB-INF/view/hello.jsp" 파일을 찾아서 해당 JSP 페이지를 렌더링합니다.
        // view/hello는 실제 파일 경로의 일부이며, prefix와 suffix는 별도로 설정된 경로입니다 (예: /WEB-INF/views/).

        return mav;
        // 이 메서드는 ModelAndView 객체를 반환합니다.
        // 이 반환된 객체는 Spring MVC가 처리하여 클라이언트에게 응답을 생성합니다.
        // 모델에 담긴 데이터를 JSP와 같은 뷰에서 참조하고, 뷰의 이름에 맞는 JSP 파일을 찾아서 렌더링합니다.
        // 추가 주석: 반환된 ModelAndView 객체는 Spring이 내부적으로 처리하여 JSP 파일을 찾고 데이터를 뷰로 전달해 줍니다.
        // 클라이언트는 그 결과 화면을 브라우저에서 확인할 수 있습니다.
    }
    
    // 새로운 메서드 추가
    @RequestMapping(value="hello2.do", method=RequestMethod.GET, produces="text/html; charset=UTF-8")
    @ResponseBody
    public String hello2(){
        
        return " 안녕하세요 ! 스프링 !! ";
        //return "welcom";
        // 추가 주석: @ResponseBody 어노테이션을 사용하면 메서드가 반환하는 값이 JSP 파일이 아니라 
        // 단순히 문자열로 처리됩니다. 즉, 응답으로 문자열 데이터를 직접 보낼 때 사용합니다.
        // 클라이언트는 "안녕하세요! 스프링!!"이라는 단순 텍스트를 브라우저에서 확인하게 됩니다.
        // 이 방식은 주로 Ajax 통신이나 API 응답에 유용하게 사용됩니다.
    }
    // Spring 에서 return 타입이 String 이면 단순 문자열이 아니라 JSP 파일명으로 인식한다.
    // @ResponseBody : 단순 문자열로 처리하여 브라우저에 바로 결과를 표출할려면 ResponseBody 를 사용해야 한다.
    // Spring Boot 에서는 ResponseBody 를 애용한다.
    // 추가 주석: Spring에서 String을 반환하는 경우 기본적으로 JSP 파일을 찾지만,
    // @ResponseBody 어노테이션을 사용하면 JSP를 찾지 않고 문자열을 그대로 응답 본문으로 반환합니다.
    // 이는 RESTful 서비스나 Ajax 호출에서 자주 사용되는 방식입니다.
}

/*

URL에서 바로 JSP 가 실행되지 않게 하기 위해서 /WEB-INF 에 JSP 파일을 작성한다.
http://localhost:8080/Chapter06/hello.do 실행 할 수 없다.
추가 주석: JSP 파일을 직접 URL로 접근하지 못하게 하기 위해, 보안상의 이유로 /WEB-INF 디렉토리 아래에 JSP 파일을 둡니다.
이렇게 하면 Spring 컨트롤러를 거치지 않고는 JSP 파일에 접근할 수 없습니다.

 */

// 이 주석은 서블릿의 생명 주기(lifecycle)를 설명합니다.
// init(): 서블릿이 처음 생성될 때 한 번만 호출되며, 초기화 작업을 수행합니다.
// doGet(): 클라이언트가 GET 요청을 보낼 때 호출되는 메서드입니다. 데이터를 조회할 때 주로 사용됩니다.
// doPost(): 클라이언트가 POST 요청을 보낼 때 호출되는 메서드입니다. 데이터 전송/처리를 주로 담당합니다.
// destroy(): 서블릿이 소멸되기 전에 호출되며, 리소스 정리 등의 작업을 수행합니다.
// Spring MVC에서는 이러한 메서드들을 대체하여 @RequestMapping을 사용해 HTTP 요청을 처리합니다.
// 추가 주석: Spring MVC는 전통적인 서블릿 메서드들(init, doGet, doPost, destroy)을 직접 사용하지 않고,
// @RequestMapping과 같은 어노테이션을 사용하여 HTTP 요청을 처리합니다. 이 방식은 더 간결하고 유지보수가 용이합니다.
