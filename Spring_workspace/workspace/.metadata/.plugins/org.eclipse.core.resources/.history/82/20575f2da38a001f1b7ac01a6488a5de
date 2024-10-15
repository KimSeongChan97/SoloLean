<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
    <!-- user.css 파일을 불러와 회원가입 폼의 스타일을 설정합니다 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css">
    <!-- Font Awesome 아이콘 라이브러리를 사용하여 아이콘을 추가합니다 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div id="write-jsp" class="container-fluid">
        <!-- 좌측 영역: 홈 링크, 프로필 이미지, 기타 링크 -->
        <div id="left">
            <div id="header">
                <!-- HOME 링크 -->
                <a href="/spring/">
                    <img src="${pageContext.request.contextPath}/image/Logo.png" alt="Logo" width="50" height="50" />
                    HOME
                </a>
            </div>
            <div id="profile">
                <!-- 사용자가 등록할 이미지 혹은 기본 프로필 이미지 -->
                <img src="${pageContext.request.contextPath}/image/mang.png" width="140" height="140" alt="mangLogo" />
            </div>
            <div id="links">
                <!-- 고객센터 및 언어 설정 링크 -->
                <a href="#">고객센터</a> | <a href="#">한국어</a>
            </div>
        </div>

        <!-- 우측 영역: 회원가입 폼 -->
        <div id="right">
            <div id="container">
                <div id="edit-header">회원가입</div>
                <!-- 회원가입 폼 -->
                <form name="userWriteForm" id="userWriteForm" class="needs-validation" novalidate>
                    <!-- 이름 입력 필드 -->
                    <div class="mb-3">
                        <label for="name" class="form-label">
                            <i class="fas fa-user"></i> 이름
                        </label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="이름 입력" required>
                        <div id="nameDiv" class="error">이름을 입력하세요.</div>
                    </div>

                    <!-- 아이디 입력 필드 -->
                    <div class="mb-3">
                        <label for="id" class="form-label">
                            <i class="fas fa-id-badge"></i> 아이디
                        </label>
                        <input type="text" class="form-control" name="id" id="id" placeholder="아이디 입력" required>
                        <div id="idDiv" class="error">아이디를 입력하세요.</div>
                    </div>

                    <!-- 비밀번호 입력 필드 -->
                    <div class="mb-3">
                        <label for="pwd" class="form-label">
                            <i class="fas fa-lock"></i> 비밀번호
                        </label>
                        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="비밀번호 입력" required>
                        <div id="pwdDiv" class="error">비밀번호를 입력하세요.</div>
                    </div>

                    <!-- 회원가입 및 초기화 버튼 -->
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary" id="writeBtn">회원가입</button>
                        <button type="reset" class="btn btn-secondary">초기화</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- jQuery 및 Bootstrap JS -->
    <script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/write.js"></script>
</body>
</html>
