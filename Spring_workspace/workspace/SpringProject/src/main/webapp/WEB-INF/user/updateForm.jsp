<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
<!-- updateForm.css 파일을 불러와 회원정보 수정 폼의 스타일을 적용합니다 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateForm.css">
<!-- Font Awesome 아이콘 라이브러리를 사용하여 페이지에 아이콘을 추가합니다 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div id="update-jsp">
        <div id="left">
            <div id="header">
                <!-- 홈으로 돌아가는 링크입니다. /spring 경로로 이동하며, 로고와 텍스트가 함께 표시됩니다 -->
                <a href="/spring/">
                    <img src="${pageContext.request.contextPath}/image/Logo.png" alt="Logo" width="50" height="50" /> HOME
                </a>
            </div>
            <div id="profile">
                <!-- 프로필 이미지를 표시하는 부분입니다. 여기서는 'mang.png' 이미지를 사용하고 있습니다. -->
                <img src="${pageContext.request.contextPath}/image/mang.png" width="140" height="140" alt="mangLogo" />
            </div>
            <div id="links">
                <!-- 고객센터와 언어 선택 링크가 제공됩니다. 현재는 링크가 실제로 작동하지 않습니다. -->
                <a href="#">고객센터</a> | <a href="#">한국어</a>
            </div>
        </div>

        <div id="right">
            <div id="container">
                <!-- 회원정보 수정 폼의 헤더 부분입니다. -->
                <div id="edit-header">회원수정</div>
                <!-- 회원정보 수정을 위한 폼입니다. -->
                <form name="userUpdateForm" id="userUpdateForm">
                    <!-- 현재 페이지(pg) 정보를 숨김 필드로 저장하여 나중에 사용할 수 있게 합니다. -->
                    <input type="hidden" id="pg" value="${pg }" />
                    <table>
                        <tr>
                            <!-- '이름' 필드를 표시하며, 아이콘과 함께 이름 입력 필드가 제공됩니다. -->
                            <th class="label"><i class="fas fa-user"></i> 이름</th>
                            <td class="input">
                                <!-- 사용자 이름을 입력하는 텍스트 필드입니다. 기존의 이름을 'userDTO.name' 값으로 불러옵니다. -->
                                <input type="text" name="name" id="name" value="${userDTO.name}" />
                                <!-- 입력 오류나 추가 정보를 표시할 div입니다. -->
                                <div id="nameDiv"></div>
                            </td>
                        </tr>
                        <tr>
                            <!-- '아이디' 필드를 표시하며, 아이콘과 함께 아이디를 출력합니다. 아이디는 수정할 수 없도록 읽기 전용으로 설정되어 있습니다. -->
                            <th class="label"><i class="fas fa-id-badge"></i> 아이디</th>
                            <td class="input">
                                <!-- 사용자 아이디를 표시하는 필드입니다. readonly 속성으로 인해 수정이 불가능합니다. -->
                                <input type="text" name="id" id="id" value="${userDTO.id}" readonly />
                            </td>
                        </tr>
                        <tr>
                            <!-- '비밀번호' 필드를 표시하며, 아이콘과 함께 비밀번호 입력 필드가 제공됩니다. -->
                            <th class="label"><i class="fas fa-lock"></i> 비밀번호</th>
                            <td class="input">
                                <!-- 사용자 비밀번호를 입력하는 필드입니다. 보안상 비밀번호는 화면에 표시되지 않고 별표(*)로 표시됩니다. -->
                                <input type="password" name="pwd" id="pwd" value="${userDTO.pwd}" />
                                <!-- 입력 오류나 추가 정보를 표시할 div입니다. -->
                                <div id="pwdDiv"></div>
                            </td>
                        </tr>
                        <tr align="center">
                            <!-- 테이블의 하단에 여러 버튼들을 배치합니다. -->
                            <td colspan="2" height="20">
                                <!-- '회원목록' 버튼을 클릭하면 회원 목록 페이지로 이동합니다. 현재 페이지 정보(pg)를 URL에 포함시켜 전송합니다. -->
                                <button type="button" onclick="location.href='/spring/user/list?pg=${pg}'">회원목록</button>
                                <!-- '정보수정' 버튼입니다. 클릭 시 자바스크립트의 update.js 파일에서 처리됩니다. -->
                                <button type="button" id="updateBtn">정보수정</button>
                                <!-- '회원탈퇴' 버튼입니다. 클릭 시 회원 탈퇴 기능이 수행되도록 설정되어 있습니다. -->
                                <button type="button"
								    onclick="location.href='/spring/user/deleteForm?id=${userDTO.id}&pg=${pg}'">
								    회원탈퇴
								</button>

                                <!-- '초기화' 버튼입니다. 클릭 시 입력된 내용을 초기화합니다. -->
                                <button type="reset">초기화</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery 라이브러리를 불러옵니다. 주로 Ajax 요청과 DOM 조작을 위해 사용됩니다. -->
    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- 사용자 정보 수정을 처리하기 위한 자바스크립트 파일을 불러옵니다. 'update.js'는 정보 수정과 탈퇴와 같은 기능을 처리합니다. -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/update.js"></script>
    <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/delete.js"></script> --%>
</body>
</html>
