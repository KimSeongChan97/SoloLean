<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%-- 
        int x = Integer.parseInt(request.getParameter("x");
        int y = Integer.parseInt(request.getParameter("y");
        
        // 이 부분은 JSP 스크립틀릿을 이용한 자바 코드입니다.
        // 사용자가 입력한 x와 y 값을 `request.getParameter("x")`로 받아오는데,
        // GET 또는 POST 방식으로 전달된 HTTP 요청 파라미터의 값을 가져오는 방식입니다.
        // 여기서 중요한 점은 `getParameter`로 가져오는 값은 **문자열**이므로,
        // 자바에서 숫자 연산을 하기 위해선 **Integer.parseInt()**로 문자열을 정수로 변환합니다.
        // 이 코드는 x와 y 값을 받아서 정수로 변환한 후, 그 값들을 활용하려고 합니다.
        // 그러나 이 방식은 JSP에서 스크립틀릿(<% %>)을 사용하는 방식이고,
        // 최근 JSP에서는 EL(Expression Language)을 선호하여,
        // 자바 코드가 아닌 표현 언어로 값을 처리하는 것을 권장합니다.
        // 하지만 이 코드 자체는 JSP 스크립틀릿의 동작 방식을 보여주는 좋은 예시입니다.
        // --> EL에서는 자바 코드 대신 더 직관적이고 간단하게 표현할 수 있다는 장점이 있습니다.
        // 이 부분에서 자바 코드로 연산을 처리하는 방법이 어떻게 구현되는지 보여주지만, 
        // 더 좋은 방법은 EL로 같은 기능을 하는 것입니다.
    --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Result</title>
</head>

<body>

    <%-- <%=x %> + <%=x %> = <%=x+y %> --%>
    <%-- 
        이 부분은 스크립틀릿을 사용한 코드입니다. 
        위에서 변환된 x와 y 값을 HTML 문서에 출력하는 부분입니다.
        <%= %>는 JSP에서 스크립틀릿을 사용하여 값을 출력하는 표현식입니다.
        여기서는 x와 y의 값을 각각 더한 결과를 화면에 출력하는데 사용됩니다.
        EL을 사용하지 않고 스크립틀릿을 사용하여 자바 코드를 삽입하는 방식입니다.
        그러나 최근 JSP에서는 EL을 권장하기 때문에,
        스크립틀릿을 사용하는 것은 가능하면 피하는 것이 좋습니다.
        EL은 더 간결하고 유지보수가 용이하기 때문입니다.
        // --> 스크립틀릿은 자바 코드를 JSP 파일에 직접 삽입하는 방법이지만, 코드가 길어질 수 있고 가독성이 떨어집니다.
        // EL은 이런 단점을 극복하기 위해 더 간결한 문법으로 데이터를 표현하는 데 유리합니다.
    --%>

    <%-- <p> 계산 결과 : ${param.x } + ${param.y } = ${param.x + param.y }</p> --%>
    <%-- 
        이 부분은 EL(Expression Language)을 사용한 코드입니다. 
        ${param.x}와 ${param.y}는 각각 GET이나 POST 요청을 통해 전달된 x와 y 값을 나타냅니다.
        EL을 사용하면 자바 코드를 작성하지 않고도 JSP에서 데이터를 쉽게 다룰 수 있습니다.
        여기서는 ${param.x}와 ${param.y}로 각각 x와 y 값을 가져오고, 그 값을 더하는 방식입니다.
        ${param.x + param.y}는 두 값을 더한 결과를 화면에 출력하는 것입니다.
        EL은 자바 코드 없이 표현식으로 데이터를 처리하므로 코드가 더 간결하고 직관적입니다.
        최근의 JSP 개발에서는 EL을 사용하여 이렇게 데이터를 처리하는 것이 일반적입니다.
        // --> ${param.x}는 GET 또는 POST 요청을 통해 넘어온 x 파라미터의 값을 나타냅니다.
        // param은 request 객체의 파라미터 값을 가져오는 EL 기본 객체로, 자바 코드를 쓰지 않아도 간편하게 사용 가능합니다.
    --%>

    <p> 계산 결과 : ${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] }</p>
    <%-- 
        이 코드도 EL을 사용하는 방식입니다. ${param['x']}와 ${param['y']}는 사용자가 입력한 x와 y 값을 가져옵니다.
        앞서 사용한 ${param.x}와 동일하게 x, y 파라미터 값을 EL로 가져오는 방식입니다.
        차이점은 []를 사용하여 파라미터 이름을 명시적으로 가져오는 방식입니다.
        ${param['x'] + param['y']}는 두 값을 더한 결과를 표현합니다.
        EL을 사용하면 자바 코드를 사용할 필요 없이 직관적으로 JSP에서 데이터를 처리할 수 있습니다.
        그리고 ${param['x']}와 ${param.x}는 거의 동일하게 동작하지만, 
        [] 안에 파라미터 이름을 넣으면 더 명시적으로 이름을 지정할 수 있습니다. 
        이 방식은 파라미터 이름에 특수문자나 공백이 있는 경우에도 사용될 수 있습니다.
        // --> [] 안에 문자열로 이름을 명시적으로 지정하는 방법은 변수명에 공백이나 특수문자가 포함될 때 주로 사용됩니다.
        // 예를 들어, ${param['x']}와 ${param.x}는 거의 동일한 역할을 하지만, 공백 등의 특수 상황에서는 차이를 보일 수 있습니다.
    --%>
    
    <br/>
    
    <p> 계산 결과 : ${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] }</p>
    <%-- 
        이 코드에서는 사용자가 입력한 두 값을 뺄셈 연산하여 출력하는 예시입니다.
        ${param['x']}는 사용자가 입력한 x 값을 가져오고, ${param['y']}는 y 값을 가져옵니다.
        이 둘을 ${param['x'] - param['y']}를 통해 뺄셈 연산한 결과를 출력합니다.
        EL에서는 이렇게 산술 연산을 쉽게 할 수 있습니다.
        // --> EL은 단순히 값을 출력하는 것뿐만 아니라 덧셈, 뺄셈, 곱셈, 나눗셈과 같은 산술 연산도 지원합니다.
        // 자바 코드를 따로 작성할 필요 없이, ${} 안에서 연산을 처리할 수 있어 매우 간결합니다.
    --%>
    
    <br/>
    
    <p> 계산 결과 : ${param.x } * ${param.y } = ${param.x * param.y } </p>
    <%-- 
        이 부분은 두 값을 곱하는 코드입니다.
        ${param.x}와 ${param.y}는 각각 x와 y의 값을 나타내며,
        이 둘을 곱하는 연산은 ${param.x * param.y}로 처리됩니다.
        EL은 곱셈 연산도 쉽게 지원합니다.
        // --> 여기서 * 기호는 곱셈 연산을 의미하며, JSP에서 EL을 사용해 간단하게 곱셈 연산을 처리할 수 있습니다.
        // ${param.x * param.y}를 통해 두 값을 곱한 결과를 표현합니다.
    --%>
    
    <br/>
    
    <p> 계산 결과 : ${param.x } / ${param.y } = ${param.x / param.y } </p>
    <%-- 
        이 부분은 두 값을 나눗셈 연산하여 출력하는 예시입니다.
        ${param.x}와 ${param.y}는 각각 입력된 값이며, 
        이 둘을 나눗셈 연산으로 결과를 출력하려면 ${param.x / param.y}를 사용합니다.
        // --> 나눗셈 또한 EL에서 쉽게 처리할 수 있습니다. ${param.x / param.y}로 x 값을 y 값으로 나눈 결과를 출력합니다.
        // 단, y 값이 0일 경우 오류가 발생할 수 있으니, 실제 환경에서는 이를 체크하는 로직을 추가하는 것이 좋습니다.
    --%>

    <a href="elInput.jsp"> 다시 입력하기 </a>
    <%-- 
        이 코드는 사용자가 입력한 값을 다시 입력할 수 있도록 "elInput.jsp"로 돌아가는 링크입니다.
        '다시 입력하기' 버튼을 클릭하면 다시 elInput.jsp로 이동하여 값을 다시 입력할 수 있게 합니다.
        이는 단순한 HTML 링크로, JSP가 처리하는 로직과는 관계없습니다.
        사용자 경험을 향상시키기 위해 다시 입력 페이지로 쉽게 돌아가도록 하는 좋은 예시입니다.
        // --> 사용자가 다시 값을 입력할 수 있도록 '다시 입력하기' 링크를 통해 elInput.jsp로 돌아가게 합니다.
        // 'a' 태그는 일반적인 HTML 링크로 동작하며, 사용자가 추가적인 입력을 할 수 있도록 페이지를 이동시킵니다.
    --%>

</body>
</html>

<!-- 

param의 의미
param: JSP에서 GET 또는 POST 요청으로 전달된 파라미터 값을 가져올 때 사용됩니다.
예를 들어, <input> 요소에 사용자가 입력한 값은 URL 파라미터로 전송되며, 이를 param으로 받아와 사용할 수 있습니다.

동작 과정
elInput.jsp에서 사용자가 X와 Y 값을 입력하고, 폼이 제출되면 그 값이 HTTP 요청 파라미터로 서버에 전달됩니다.

이때, X와 Y는 각각 name="x"와 name="y"로 지정되어 있으므로, 그 값들은 x, y라는 파라미터로 전송됩니다.
elResult.jsp에서 param 객체를 사용해 전송된 값을 읽어옵니다. 즉, param.x는 elInput.jsp에서 제출된 x 파라미터의 값을 의미합니다.

param과 관련된 EL 객체
${param['파라미터 이름']}: 특정 요청 파라미터의 값을 가져옵니다.
${paramValues['파라미터 이름']}: 배열 형태로 동일한 이름을 가진 여러 요청 파라미터의 값을 가져옵니다.

  -->
