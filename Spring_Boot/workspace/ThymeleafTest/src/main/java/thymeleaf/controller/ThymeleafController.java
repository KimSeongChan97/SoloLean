package thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import thymeleaf.bean.PersonDTO;

@Controller
public class ThymeleafController {

    // 생성자: ThymeleafController 객체가 생성될 때 실행됩니다.
    // 생성자가 호출될 때마다 "ThymeleafController 생성자 입니다."라는 메시지를 출력합니다.
    public ThymeleafController() {
        System.out.println(" ThymeleafController 생성자 입니다. ");
    }

    // "hithymeleaf" 경로에 GET 요청이 들어오면 실행되는 메서드
    // Model 객체를 통해 데이터를 전달하고, "basic/hithymeleaf" 템플릿을 반환하여 해당 HTML을 렌더링합니다.
    @GetMapping("hithymeleaf")
    public String hithymeleaf(Model model) {
        // 모델에 "say"라는 속성에 "안녕하세요!" 문자열을 추가
        model.addAttribute("say", "안녕하세요!");
        return "basic/hithymeleaf"; // "basic/hithymeleaf"라는 템플릿 파일을 사용하여 응답
    }

    // "literal" 경로에 GET 요청이 들어오면 실행되는 메서드
    @GetMapping("literal")
    public String literal(Model model) {
        // "data" 속성에 문자열을 추가하여 템플릿에 전달
        model.addAttribute("data", "Spring Boot! Thymeleaf입니다");
        return "basic/literal"; // "basic/literal" 템플릿 파일을 반환
    }

    // "variable" 경로에 GET 요청이 들어오면 실행되는 메서드
    @GetMapping("variable")
    public String variable(Model model) {
        // 세 명의 PersonDTO 객체 생성하여 각기 다른 사람의 이름과 나이를 설정
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 32);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        // 리스트에 PersonDTO 객체들을 추가하여 여러 사람의 정보를 저장
        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        // 맵에 키-값 쌍으로 PersonDTO 객체를 추가하여 특정 데이터를 맵으로 전달
        Map<String, Object> map = new HashMap<>();
        map.put("cc", cc);

        // 각각의 데이터를 모델에 추가하여 템플릿에 전달
        model.addAttribute("aa", aa); // 단일 PersonDTO 객체
        model.addAttribute("list", list); // 여러 PersonDTO 객체가 포함된 리스트
        model.addAttribute("map", map); // 특정 데이터를 담은 맵

        return "basic/variable"; // "basic/variable" 템플릿 파일을 사용하여 렌더링
    }

    // "operation" 경로에 GET 요청이 들어오면 실행되는 메서드
    // 연산이나 간단한 로직을 테스트할 때 사용할 수 있습니다.
    @GetMapping("operation")
    public String operation() {
        return "basic/operation"; // "basic/operation" 템플릿 파일을 반환
    }

    // "text_basic" 경로에 GET 요청이 들어오면 실행되는 메서드
    @GetMapping("text_basic")
    public String text_basic(ModelMap modelMap) {
        // 모델맵에 "data"라는 키와 값을 추가하여 템플릿에 전달
        modelMap.put("data", "SpringBoot");
        return "basic/text_basic"; // "basic/text_basic" 템플릿 파일을 반환
    }

    // "attribute" 경로에 GET 요청이 들어오면 실행되는 메서드
    @GetMapping("attribute")
    public String attribute(ModelMap modelMap) {
        // 모델맵에 "data"라는 키와 값을 추가하여 템플릿에 전달
        modelMap.put("data", "SpringBoot");
        return "basic/attribute"; // "basic/attribute" 템플릿 파일을 반환
    }

    // "ifcondition" 경로에 GET 요청이 들어오면 실행되는 메서드
    // 조건문 사용 예제를 위해 데이터를 모델에 추가합니다.
    @GetMapping("ifcondition")
    public String ifcondition(Model model) {
        // 템플릿에서 조건문을 사용할 때 참조할 데이터를 모델에 추가
        model.addAttribute("age", 18); // "age"에 18이라는 값 설정
        model.addAttribute("movie", "베놈"); // "movie"에 "베놈"이라는 값 설정
        model.addAttribute("today", "수요일"); // "today"에 "수요일"이라는 값 설정

        return "basic/ifcondition"; // "basic/ifcondition" 템플릿 파일을 반환
    }

    // "condition" 경로에 GET 요청이 들어오면 실행되는 메서드
    // 여러 조건을 테스트하기 위한 데이터 설정
    @GetMapping("condition")
    public String condition(Model model) {
        // 다양한 나이의 PersonDTO 객체를 생성하여 리스트에 추가
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 17);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        model.addAttribute("list", list); // 리스트를 모델에 추가하여 템플릿에 전달

        return "basic/condition"; // "basic/condition" 템플릿 파일을 반환
    }

    // "each" 경로에 GET 요청이 들어오면 실행되는 메서드
    // 반복문 사용 예제를 위해 데이터를 모델에 추가합니다.
    @GetMapping("each")
    public String each(Model model) {
        // 여러 사람의 정보를 담은 PersonDTO 객체 리스트 생성
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 17);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        model.addAttribute("list", list); // 리스트를 모델에 추가하여 템플릿에 전달

        return "basic/each"; // "basic/each" 템플릿 파일을 반환
    }

    // "block" 경로에 GET 요청이 들어오면 실행되는 메서드
    @GetMapping("block")
    public String block(Model model) {
        // 블록 요소 테스트를 위한 여러 사람의 정보를 리스트에 담아 모델에 추가
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 17);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        model.addAttribute("list", list); // 리스트를 모델에 추가하여 템플릿에 전달

        return "basic/block"; // "basic/block" 템플릿 파일을 반환
    }

    // "link" 경로에 GET 요청이 들어오면 실행되는 메서드
    // 링크를 템플릿에서 테스트하기 위해 사용됩니다.
    @GetMapping("link")
    public String link() {
        return "basic/link"; // "basic/link" 템플릿 파일을 반환
    }

    // "hello" 경로에 GET 요청이 들어오면 실행되는 메서드
    // 단순한 문자열을 반환하여 JSON 또는 문자열 응답을 테스트
    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam(name="name", defaultValue="noname") String name, 
    					@RequestParam(name="age", defaultValue="0") int age) {
        return name + " / " + age; 
    }

    // 경로 변수(Path Variable) 처리 예제 메서드
    // URL에 포함된 이름(name)과 나이(age)를 동적으로 처리하여 응답으로 반환합니다.
    @GetMapping("/hello2/{name}/{age}")
    @ResponseBody
    public String hello2(@PathVariable("name") String name, @PathVariable("age") int age) {
        // 경로 변수에서 전달된 "name"과 "age" 값을 사용하여 맞춤형 문자열 생성
        return name + " / " + age;
    }
    
    @GetMapping("/hello3/{name}")
    @ResponseBody
    public String hello3(@PathVariable("name") String name,
    					 @RequestParam("age") int age) {
    	return name + " / " + age;
    };
    
    @GetMapping("/select")
    @ResponseBody
    public String select() {
    	return "select 요청";
    };
    
    @GetMapping("/insert")
    @ResponseBody
    public String insert(@RequestParam(name="pageno", defaultValue="1000") int pageno) {
    	
    	return "pageno = " + pageno;
    };
    
    
    @GetMapping("/character/detail/{name}/{number}")
    @ResponseBody
    public String character_detail(@PathVariable("name") String name,
    							   @PathVariable("number") int number) {
    	
    	return name + " / " + number;
    };
    
    @GetMapping("basicObject")
    public String basicObject(HttpSession session,Model model) {
    	
    	LocalDateTime startTime = LocalDateTime.now();
    	
    	// 세션
    	session.setAttribute("memId", "hong");
    	session.setAttribute("memName", "홍길동");
    	
    	model.addAttribute("startTime", startTime);
    	model.addAttribute("str", "   Spring Boot   ");
    	model.addAttribute("num", "123456789.389");
    	
    	
        return "basic/basicObject"; 
    };
    
    @GetMapping("/fragmentMain1")
    public String fragmentMain1() {
    	return "basic/fragmentMain1";
    };
    
    @GetMapping("/fragmentMain2")
    public String fragmentMain2() {
    	return "basic/fragmentMain2";
    };

    
}
