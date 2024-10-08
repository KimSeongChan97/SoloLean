package com.controller;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Component  // 이 클래스가 Spring의 컴포넌트로 관리된다는 것을 나타냄
@Controller  // 이 클래스가 Controller로 작동하며, 요청을 처리하는 역할을 함
public class SumController {
	
	@RequestMapping(value="input.do", method=RequestMethod.GET, produces="text/html; charset=UTF-8")
    public String input(){
        // 이 메서드는 "input.do" URL로 GET 요청이 들어올 때 실행됨
        // "input.do"는 사용자가 브라우저에서 요청할 때 입력하는 경로임.
        // 이 메서드는 GET 방식으로만 호출될 수 있으며, POST 방식은 허용되지 않음
        // produces="text/html; charset=UTF-8"은 응답이 HTML 형식이며, UTF-8 인코딩이 사용된다는 것을 명시함
        // 이 설정은 브라우저가 페이지를 올바르게 표시할 수 있도록 도와줌
        return "sum/input";  
        // "sum/input"이라는 뷰(JSP 페이지)로 이동함
        // 여기서 "sum/input"은 뷰의 경로로, Spring의 ViewResolver에 의해 실제 JSP 파일 경로로 매핑됨
        // 예를 들어, "WEB-INF/views/sum/input.jsp"일 가능성이 있음
        // JSP 페이지를 통해 입력을 받을 수 있음
	}
	
//	@RequestMapping(value = "result.do", method = RequestMethod.GET, produces="text/html; charset=UTF-8")
//    public String result() {
//		return "sum/result";
//    }
//  // 위의 주석 처리된 메서드는 "result.do"라는 URL로 GET 요청이 들어오면 "sum/result" 뷰로 이동하는 역할을 함
//  // Model이나 데이터를 전달하지 않으므로 단순히 뷰로만 이동하는 메서드임. 
//  // 예를 들어, "sum/result.jsp"와 같은 파일로 이동하여 결과 페이지를 사용자에게 보여줌

	
//	@RequestMapping(value = "result.do", method = RequestMethod.GET, produces="text/html; charset=UTF-8")
//    public ModelAndView result(@RequestParam int x, @RequestParam int y) {
//        // 이 메서드는 "result.do"라는 URL로 GET 요청이 들어올 때 실행됨
//        // @RequestParam 어노테이션은 URL 요청 매개변수에서 값을 가져오는 역할을 함
//        // 예를 들어, 사용자가 "result.do?x=10&y=20"이라고 요청을 보내면
//        // x는 10, y는 20이라는 값이 각각 매개변수로 전달됨
//        // int x와 int y는 각각 사용자로부터 입력받은 값을 의미함
//        ModelAndView mav = new ModelAndView();  
//        // ModelAndView 객체는 모델 데이터와 뷰 정보를 담는 객체임
//        // 이 객체는 컨트롤러가 뷰에 데이터를 전달할 때 사용됨
//        // 즉, 뷰에 표시할 데이터를 여기에 추가함으로써 뷰와 데이터를 함께 리턴할 수 있음
//        mav.addObject("x", x);  
//        // addObject 메서드는 뷰에 전달할 데이터를 추가하는 메서드임
//        // 여기서는 x라는 이름으로 사용자로부터 입력받은 x 값을 뷰에 전달함
//        // 이 데이터는 JSP 페이지에서 ${x}로 접근할 수 있음
//        mav.addObject("y", y);  
//        // 마찬가지로 y라는 이름으로 사용자로부터 입력받은 y 값을 뷰에 전달함
//        // JSP 페이지에서 ${y}로 이 값을 출력하거나 사용할 수 있음       
//        mav.setViewName("sum/result");  
//        // setViewName 메서드는 어떤 뷰로 이동할지를 설정하는 메서드임
//        // 여기서는 "sum/result"라는 뷰 이름을 설정함
//        // 이는 ViewResolver에 의해 실제 경로로 매핑되며, "WEB-INF/views/sum/result.jsp"와 같은 파일로 연결될 가능성이 있음
//        // 사용자가 보게 될 페이지는 result.jsp일 것임        
//        return mav;  
//        // 이 메서드는 ModelAndView 객체를 반환함
//        // 즉, 지정된 뷰로 이동하고, x와 y 데이터를 해당 뷰에 전달함
//    }
//  // 이 주석 처리된 메서드는 ModelAndView 객체를 사용하여, 결과 페이지에 x와 y 데이터를 전달하는 방식으로 동작함.
//  // 사용자로부터 두 개의 정수 값을 받아 JSP 페이지에 전달하고, JSP에서 이 값을 출력하는 방식으로 데이터를 처리함.

	
//	@RequestMapping(value = "result.do", method = RequestMethod.GET, produces="text/html; charset=UTF-8")
//    public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x, 
//    						   @RequestParam(required = false, defaultValue = "0") String y) {
//		// @RequestParam(required = false, defaultValue = "0"): 이 설정은 요청에 매개변수가 없을 경우 기본값을 0으로 설정하는 역할을 함
//		// 즉, 사용자가 x와 y 값을 전달하지 않으면 자동으로 0이 할당됨
//		ModelAndView mav = new ModelAndView(); 
//		// ModelAndView 객체를 사용하여 데이터를 전달하고 뷰를 설정함
//		mav.addObject("x", x); 
//		// x라는 이름으로 x 값을 뷰에 전달함. 이 값은 JSP에서 ${x}로 접근 가능
//		mav.addObject("y", y);
//		// y라는 이름으로 y 값을 뷰에 전달함. JSP에서 ${y}로 접근 가능
//		mav.setViewName("sum/result");
//		// "sum/result" 뷰로 이동. 이 뷰는 JSP 파일로 매핑되어 있음
//		return mav;
//	}
//  // 이 메서드는 GET 요청 시 x와 y 값을 받아 ModelAndView에 담아 "sum/result" 뷰로 전달함.
//  // 매개변수가 없는 경우 기본값을 0으로 설정하여 뷰에 전달함. JSP 페이지에서 해당 값을 출력하거나 처리할 수 있음.

	
//  @RequestMapping(value = "result.do", method = RequestMethod.GET, produces="text/html; charset=UTF-8")
//  public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
//		// @RequestParam Map<String, String> map : 모든 요청 매개변수를 Map 객체로 받아옴
//		// 이는 여러 개의 매개변수를 처리할 때 유용함. 각 매개변수의 이름을 키로, 그 값을 값으로 저장함
//		// ModelMap modelMap : 데이터를 뷰에 전달할 때 사용됨. 이 객체에 데이터를 추가하면 JSP에서 접근할 수 있음
//		modelMap.put("x", map.get("x"));
//		// map에서 "x"라는 키로 값을 가져와서 modelMap에 추가함. JSP에서 ${x}로 접근 가능
//		modelMap.put("y", map.get("y"));
//		// map에서 "y"라는 키로 값을 가져와서 modelMap에 추가함. JSP에서 ${y}로 접근 가능
//		return "sum/result";
//		// "sum/result"라는 뷰로 이동. 결과 페이지에서 x와 y 값을 출력하거나 사용할 수 있음
//  }
//  // 이 메서드는 GET 요청으로 전달된 모든 매개변수를 Map 객체로 받아들이고, 이를 ModelMap을 통해 뷰로 전달함.
//  // JSP에서 해당 값을 출력하거나 로직에 사용할 수 있음.

  
  @RequestMapping(value = "result.do", method = RequestMethod.GET, produces="text/html; charset=UTF-8")
  public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		// @ModelAttribute SumDTO sumDTO : SumDTO라는 자바 빈 객체로 폼에서 전송된 데이터를 받아옴
		// @ModelAttribute는 요청 파라미터 값을 자동으로 SumDTO 객체에 바인딩해줌
		// 예를 들어, SumDTO 클래스에 'x'와 'y'라는 필드가 있으면, 폼 데이터에서 전달된 'x'와 'y' 값을 해당 필드에 자동으로 매핑해줌
		// 이렇게 전달된 SumDTO 객체는 요청된 데이터와 함께 뷰로 전달됨
		model.addAttribute("x", sumDTO.getX());
		// sumDTO 객체에서 x 값을 가져와서 뷰에 "x"라는 이름으로 전달함
		// 이 데이터는 JSP 페이지에서 ${x}로 접근할 수 있음
		model.addAttribute("y", sumDTO.getY());
		// 마찬가지로 sumDTO 객체에서 y 값을 가져와서 뷰에 "y"라는 이름으로 전달함
		// JSP 페이지에서 ${y}로 이 값을 사용할 수 있음
		// model.addAttribute("x", sumDTO);
		// model.addAttribute("y", sumDTO);
		// 위의 두 줄은 주석 처리되어 있음. 이는 sumDTO 객체 자체를 전달하는 방식으로, 뷰에서 sumDTO.getX()와 같이 데이터를 접근할 수 있음
		// 그러나 현재 코드는 개별적으로 x와 y만 전달하고 있으므로 필요하지 않은 부분임
		return "sum/result";  
		// "sum/result"라는 뷰 이름을 반환함. 이 이름은 ViewResolver에 의해 실제 JSP 파일 경로로 매핑됨
		// 예를 들어, "WEB-INF/views/sum/result.jsp"와 같은 경로일 가능성이 있음
		// 이 페이지에서 x와 y 값을 출력하거나 사용할 수 있음
  }	
	
}
