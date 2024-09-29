<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="../image/film_favicon.png" type="image/png">
    <link rel="stylesheet" href="../css/userWithdraw.css">
    <title>회원 탈퇴</title>
    <%-- 회원 탈퇴 페이지를 위한 CSS와 아이콘을 포함한 기본 설정입니다. --%>
</head>
<body>
   <jsp:include page="../common/header.jsp" />
   <%-- 공통 헤더를 포함하여 페이지 상단에 표시되는 부분입니다. 주로 네비게이션 바나 로고가 위치합니다. --%>
   
    <div class="container">
        <h2>회원 탈퇴 안내</h2>
        <p>회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
        <%-- 회원 탈퇴 절차와 주의 사항을 안내하는 텍스트로 구성된 섹션입니다. --%>
        
        <div class="notice">
            <h3>주의 사항</h3>
            <ul>
                <li>사용하고 계신 아이디 (<strong class="strong1">${userDTO.uid }</strong>) 는 탈퇴할 경우 재사용 및 복구가 불가능합니다. <br>
                <strong class="strong">탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</strong>하오니 신중하게 선택하시기 바랍니다.</li>
                <li>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다. <br>
                회원정보 및 개인정보, 무비로그, 무비코인, 친구추가 등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.
                <br>삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.</li>
            </ul>
            <%-- 회원 탈퇴 시 주의사항을 설명합니다. 계정과 관련된 데이터는 복구할 수 없으며, 미리 백업을 권장합니다. --%>
        </div>
        
        <div class="services">
        <br>
            <h3>삭제되는 내용</h3>
            <ul>
               <li>FilmNote</li>
               <li>개인정보 : 개인정보 및 보관 중인 DB 삭제</li>
               <li>무비리뷰 : 등록한 무비 리뷰 및 정보 삭제</li>
               <li>무비로그 : 등록한 무비 로그 및 정보 삭제</li>
               <li>무비코인 : 충전한 무비 코인 및 정보 삭제</li>
               <li>친구추가 : 등록된 친구 계정 및 친구정보 삭제</li>
               <li>modoo!(모두): 등록된 내용 및 모든 게시물 삭제</li>
            </ul>
            <%-- 탈퇴 시 삭제되는 서비스와 데이터의 목록을 나열합니다. --%>
        </div>

        <div class="additional-info">
        <br>
            <h3>게시판형 서비스 관련</h3>
            <p>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다. 삭제를 원하는 게시글이 있다면
             <strong class="strong">반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.</strong></p>
             <%-- 게시판 서비스에 올린 게시물은 탈퇴 후에도 유지되므로, 필요시 비공개나 삭제를 탈퇴 전에 해야 한다는 점을 설명합니다. --%>
        </div>

        <div class="final-warning">
            <h3>중요 안내</h3>
        <br>
            <strong class="strong">탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.</strong>
            <strong class="strong">FilmNote 아이디로 로그인하여 사용 중이던 외부 사이트를 방문하여 다른 로그인 수단을 준비하거나,
            데이터를 백업한 후 FilmNote 회원을 탈퇴해야 합니다.</strong>
            <%-- 마지막으로 탈퇴 후에는 본인 여부를 확인할 방법이 없으므로 주의가 필요하다는 점을 강조합니다. --%>
        </div>

        <div class="agreement">
            <div class="password-input">
                <label for="nowpwd">비밀번호:</label>
                <input type="password" id="nowpwd" required placeholder="비밀번호를 입력하세요.">
                <div id="nowupwdDiv"></div>
            </div>
            <%-- 탈퇴를 위해 비밀번호를 확인하는 입력란입니다. 필수 입력 사항입니다. --%>
            <label>
                <input type="checkbox" id="withdrawbox" required> 안내 사항을 모두 확인하였으며, 이에 동의합니다.
            </label>
            <%-- 회원 탈퇴 전 안내 사항을 확인하고 동의해야만 탈퇴를 진행할 수 있는 체크박스입니다. 필수 입력 사항입니다. --%>
        </div>

        <button id="withdrawBtn" type="button">탈퇴하기</button>
        <button id="cancelWithdraw" type="reset">취소</button>
        <%-- '탈퇴하기' 버튼을 클릭하면 탈퇴 절차가 진행되며, '취소' 버튼은 모든 입력을 초기화합니다. --%>
    </div>
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="../js/userWithdraw.js"></script>
    <%-- jQuery 라이브러리와 회원 탈퇴 관련 스크립트 파일을 포함합니다. --%>
</body>
</html>
