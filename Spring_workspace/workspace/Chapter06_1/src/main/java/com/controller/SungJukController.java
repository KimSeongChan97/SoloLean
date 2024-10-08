package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {

    // 성적 입력 페이지로 이동하는 메소드
    @RequestMapping(value = "sungJuk/input.do", method = RequestMethod.POST, produces="text/html; charset=UTF-8")
    public String input() {
        // "/sungJuk/input" 뷰 페이지로 이동하게 함.
        // 클라이언트가 "/sungJuk/input.do"로 POST 요청을 보내면 이 메소드가 호출되고, 입력 페이지로 이동시킴.
        return "/sungJuk/input";
    }

    // 성적 결과를 처리하고 결과 페이지로 이동하는 메소드
    @RequestMapping(value = "sungJuk/result.do", method = RequestMethod.POST, produces="text/html; charset=UTF-8")
    public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap modelMap) {
        // @ModelAttribute를 사용하여 클라이언트가 전송한 폼 데이터를 SungJukDTO 객체로 바인딩함.
        // 이 객체는 클라이언트의 입력 값을 자동으로 수집하여 'sungJukDTO'로 주입됨.
        // ModelMap은 데이터를 뷰에 전달하기 위한 객체로, 컨트롤러에서 생성한 데이터를 JSP에 넘겨줄 때 사용됨.
        int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
        // getKor(), getEng(), getMath() 메소드를 사용하여 각 과목의 점수를 가져와 더한 후 총점을 계산함.
        // 국어, 영어, 수학 점수를 더해 'tot' 변수에 저장.        
        double avg = tot / 3.0;
        // 총점을 3으로 나눠 평균을 계산. 3.0으로 나눠서 소수점이 포함된 정확한 평균값을 구함.        
        sungJukDTO.setTot(tot);
        // 계산된 총점을 SungJukDTO 객체의 'tot' 속성에 설정.        
        sungJukDTO.setAvg(avg);
        // 계산된 평균을 SungJukDTO 객체의 'avg' 속성에 설정.        
        modelMap.put("sungJukDTO", sungJukDTO);
        // ModelMap 객체에 'sungJukDTO'라는 이름으로 SungJukDTO 객체를 저장함.
        // 이를 통해 JSP 페이지에서 'sungJukDTO'라는 이름으로 해당 데이터를 접근할 수 있음.
        return "/sungJuk/result";
        // 결과를 처리한 후 "/sungJuk/result" 페이지로 이동.
        // 이때 ModelMap에 저장된 데이터는 JSP에서 사용될 수 있음. 예를 들어 총점과 평균을 출력하기 위해 사용됨.
    }
}
