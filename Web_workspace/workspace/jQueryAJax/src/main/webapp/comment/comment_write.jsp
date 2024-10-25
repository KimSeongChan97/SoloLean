<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP 페이지 지시어를 사용하여 이 페이지가 Java 언어로 작성되었음을 명시하고, 
출력 형식을 XML로 지정합니다. UTF-8 인코딩을 사용하여 한글을 포함한 다양한 문자셋을 지원합니다. 
이는 XML 문서가 클라이언트에게 올바르게 인식되고 표시되도록 합니다. -->

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!-- Java의 기본 라이브러리에서 Date와 SimpleDateFormat 클래스를 임포트합니다. 
Date 클래스는 현재 날짜와 시간을 가져오기 위해 사용되며, 
SimpleDateFormat 클래스는 날짜와 시간을 특정 형식으로 변환하는 데 사용됩니다. 
이러한 클래스를 임포트함으로써 코드에서 직접 사용할 수 있게 됩니다. -->

<%@ page trimDirectiveWhitespaces="true" %>
<!-- trimDirectiveWhitespaces 지시어를 true로 설정하여 JSP 코드에서 생성되는 불필요한 공백을 제거합니다. 
이는 XML 문서에서 공백으로 인한 불필요한 텍스트 노드가 생성되지 않도록 하기 위해 사용됩니다. 
특히, XML에서는 공백이 중요한 의미를 가질 수 있기 때문에, 불필요한 공백을 제거하여 
문서의 일관성과 정확성을 유지합니다. -->

<%

String num = request.getParameter("num");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String datetime = request.getParameter("datetime");
// 클라이언트로부터 전달된 파라미터 값을 가져옵니다. 
// num은 댓글의 고유 번호를, writer는 작성자의 이름을, content는 댓글의 내용을, 
// datetime은 댓글이 작성된 날짜와 시간을 나타냅니다. 
// request.getParameter() 메서드를 사용하여 클라이언트가 전달한 데이터를 추출합니다.

boolean result = true;
// 요청이 성공적으로 처리되었음을 나타내는 boolean 타입의 변수 result를 선언하고, 
// true로 초기화합니다. 이 변수는 요청 처리 결과를 나타내며, XML 응답에서 클라이언트에게 
// 성공 여부를 전달하는 데 사용됩니다.

String message = "덧글이 작성되었습니다.";
// 클라이언트에게 전달될 메시지를 저장하는 String 타입의 변수 message를 선언하고, 
// "덧글이 작성되었습니다."라는 메시지를 할당합니다. 
// 이 메시지는 XML 응답에 포함되어 사용자에게 피드백을 제공합니다.

%>

<%-- XML 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<!-- XML 선언부는 이 문서가 XML 형식임을 나타내며, 
버전은 1.0이고, 인코딩은 UTF-8로 설정되어 있습니다. 
이 선언부는 XML 문서의 첫 번째 줄에 위치하며, 문서의 인코딩 방식과 버전을 명시합니다. -->

<comment>
	<result><%=result %></result>
	<!-- result 태그는 요청 처리의 성공 여부를 나타냅니다. 
	<%=result %> 표현식을 사용하여, JSP에서 선언한 result 변수의 값을 XML 태그 내에 삽입합니다. 
	true 값이 출력되면 요청이 성공적으로 처리되었음을 나타냅니다. -->

	<message><%=message %></message>
	<!-- message 태그는 사용자에게 전달될 메시지를 나타냅니다. 
	여기서는 JSP에서 선언한 message 변수를 사용하여 "덧글이 작성되었습니다."라는 메시지가 출력됩니다. 
	이 메시지는 클라이언트에게 작업 결과에 대한 피드백을 제공합니다. -->

	<item>
		<num><%=num %></num>
		<!-- num 태그는 댓글의 고유 번호를 나타냅니다. 
		<%=num %> 표현식을 사용하여 클라이언트로부터 전달된 num 값을 XML 태그 내에 삽입합니다. 
		이를 통해 각 댓글이 고유하게 식별될 수 있습니다. -->

		<writer><%=writer %></writer>
		<!-- writer 태그는 댓글 작성자의 이름을 나타냅니다. 
		<%=writer %> 표현식을 사용하여 클라이언트로부터 전달된 writer 값을 XML 태그 내에 삽입합니다. 
		이를 통해 작성자의 이름이 XML 응답에 포함됩니다. -->

		<content><%=content %></content>
		<!-- content 태그는 댓글의 내용을 나타냅니다. 
		<%=content %> 표현식을 사용하여 클라이언트로부터 전달된 content 값을 XML 태그 내에 삽입합니다. 
		이를 통해 작성된 댓글의 내용이 XML 응답에 포함됩니다. -->

		<datetime><%=datetime %></datetime>
		<!-- datetime 태그는 댓글이 작성된 날짜와 시간을 나타냅니다. 
		<%=datetime %> 표현식을 사용하여 클라이언트로부터 전달된 datetime 값을 XML 태그 내에 삽입합니다. 
		이를 통해 댓글이 작성된 시점의 정보가 XML 응답에 포함됩니다. -->
	</item>
</comment>
<!-- comment 루트 요소 내에 result, message, item 태그들이 포함되어 있으며, 
이는 댓글 작성 결과를 XML 형식으로 클라이언트에게 전달하기 위해 사용됩니다. 
이 XML 구조는 클라이언트가 서버의 응답을 쉽게 파싱하고, 필요한 데이터를 추출할 수 있도록 설계되었습니다. -->
