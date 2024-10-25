<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<!-- CSS 파일 링크 -->
<!-- 로그인 페이지에 적용될 스타일을 logincss.css 파일로부터 가져옵니다. 
     이 파일은 /projectJSP/css/ 디렉터리에 있으며, 해당 파일을 통해 페이지의 레이아웃과 디자인이 적용됩니다. -->
<link rel="stylesheet" type="text/css" href="/projectJSP/css/logincss.css">
</head>
<body>

<!-- 네비게이션 바를 포함 -->
<!-- jsp:include 태그를 사용하여 별도의 JSP 파일(nav.jsp)을 현재 페이지에 포함합니다. 
     nav.jsp 파일에는 사이트 상단에 표시될 네비게이션 바의 코드가 들어 있으며, 이를 재사용하여 코드 중복을 줄일 수 있습니다. -->
<jsp:include page="/jsp/nav.jsp" /> 

<!-- 페이지 제목을 중앙에 배치하고, Comic Sans MS 폰트를 적용합니다. -->
<h2 align="center" style="font-family: 'Comic Sans MS';" style="cursor: pointer;" 
	 onclick="location.href='../index.jsp'" > L o g i n </h2>
<hr/>

<!-- 로그인 폼 -->
<!-- 로그인 폼을 생성하여 사용자가 아이디와 비밀번호를 입력하고 로그인을 시도할 수 있게 합니다. -->
<div>
<form name="memberloginForm" >
    <table>
        <!-- 아이디 입력 필드 -->
        <!-- 사용자로부터 아이디를 입력받는 필드입니다. id 속성을 사용하여 JavaScript에서 쉽게 접근할 수 있게 했습니다. -->
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="id" id="id" placeholder="아이디 입력" />
                <div id="loginIdDiv"></div> <!-- 아이디 오류 메시지를 표시할 공간입니다. 아이디가 입력되지 않으면 이곳에 오류 메시지가 표시됩니다. -->
            </td>
        </tr>
        <!-- 비밀번호 입력 필드 -->
        <!-- 사용자로부터 비밀번호를 입력받는 필드입니다. 비밀번호는 숨김 처리되며, JavaScript에서 접근할 수 있도록 id를 설정했습니다. -->
        <tr>
            <td>비밀번호</td>
            <td>
                <input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" />
                <div id="loginpwdDiv"></div> <!-- 비밀번호 오류 메시지를 표시할 공간입니다. 비밀번호가 입력되지 않으면 이곳에 오류 메시지가 표시됩니다. -->
            </td>
        </tr>

        <!-- 로그인 및 회원가입 버튼 -->
        <tr>
            <td colspan="2" align="center">
                <!-- 로그인 버튼을 클릭하면 로그인 요청이 처리됩니다. id="loginBtn"으로 JavaScript에서 이 버튼에 이벤트를 걸 수 있게 했습니다. -->
                <input type="submit" value="로그인" id="loginBtn" />
                <!-- 회원가입 버튼을 클릭하면 회원가입 페이지로 이동합니다. 회원가입 폼을 불러올 수 있도록 window.location.href로 페이지 이동이 설정되어 있습니다. -->
                <input type="button" value="회원가입" onclick="window.location.href='/projectJSP/member/memberWriteForm.jsp';" />
            </td>
        </tr>
    </table>
    
   
</form>
</div>

<!-- jQuery 라이브러리 추가 -->
<!-- jQuery는 JavaScript 라이브러리로, DOM 조작, 이벤트 처리, AJAX 등을 쉽게 할 수 있도록 도와줍니다. 
     여기서는 jQuery의 최신 버전을 사용하기 위해 CDN을 통해 jQuery를 로드합니다. -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- JavaScript 코드 -->
<script type="text/javascript">
$(function() {
    // 로그인 버튼 클릭 시 작동하는 이벤트 리스너
    $('#loginBtn').click(function() {
        $('#loginIdDiv').empty();
        $('#loginpwdDiv').empty();
        
        // 아이디 입력 필드를 검사
        if ($('#id').val() == '') {
            $('#loginIdDiv').html('아이디를 입력하세요');
            return false;
        } if ($('#pwd').val() == '') {
            $('#loginpwdDiv').html('비밀번호를 입력하세요');
            return false;
        } else {
            // 모든 입력이 완료되면 AJAX로 서버에 로그인 요청을 보냅니다.
            $.ajax({
                type: 'post',
                url: 'memberLogin.jsp',  // 로그인 처리 로직을 포함하는 JSP 파일의 URL
                data: {
                    'id': $('#id').val(),  // 사용자가 입력한 아이디
                    'pwd': $('#pwd').val(),  // 사용자가 입력한 비밀번호
                },
                dataType: 'text',  // 서버로부터 전달받을 데이터 형식
                success: function(data) {
                    if (data.trim() == 'fail') {
                        alert("아이디 또는 비밀번호가 틀렸습니다.");
                        
                    } else {
                        alert(data.trim() + " 님 로그인 되었습니다.");
                        
                        // 로그인 성공 시 index.jsp로 이동
                        window.location.href = "/projectJSP/index.jsp";  // index.jsp로 페이지 이동
                    }
                },
                error: function(e) {
                    console.log(e);  // 에러 발생 시 콘솔에 출력
                }
            });
            return false;  // AJAX 요청이 완료되기 전에 폼이 제출되지 않도록 방지
        }
    });
});

</script>
</body>
</html>
