<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<style>
/* a 태그의 기본 스타일 */
a {
    text-decoration: none; /* 밑줄 제거 */
    color: #f2f2f2; /* 텍스트 색상을 연한 회색으로 설정 */
    transition: color 1.5s ease, text-shadow 1.5s ease; /* 색상이 서서히 변하도록 트랜지션 설정 */
    /* transition을 사용하면 색상과 그림자가 부드럽게 변화함 */
}

a:hover {
    color: cyan; /* 마우스를 올렸을 때 텍스트 색상을 cyan으로 변경 */
    text-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;
    /* 마우스를 올렸을 때 글자에 네온 효과를 주는 그림자 설정 */
    /* text-shadow는 글자 주위로 빛이 퍼져나가는 네온 효과를 구현함 */
}

/* 공통 네온 버튼 스타일 */
.neon-btn {
    background-color: #f2f2f2; /* 기본 배경색을 연한 회색으로 설정 */
    color: black; /* 기본 텍스트 색상을 검은색으로 설정 */
    padding: 10px 20px; /* 버튼 내부의 여백 설정 (위아래 10px, 좌우 20px) */
    border: none; /* 버튼 테두리를 제거 */
    cursor: pointer; /* 마우스 커서를 손 모양으로 변경 */
    transition: box-shadow 1.5s ease; /* 박스 그림자가 서서히 변하도록 트랜지션 설정 */
    border-radius: 25px; /* 버튼의 모서리를 둥글게 설정 */
    /* border-radius는 버튼의 모서리를 둥글게 만들어 시각적으로 더 부드럽게 보이게 함 */
}

/* 버튼에 대한 hover 시 네온 효과 적용 */
.neon-btn:hover {
    box-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;
    /* 마우스를 올렸을 때 버튼의 박스 주위에 네온 효과가 나타나도록 설정 */
    /* box-shadow는 버튼 주위로 빛나는 테두리를 만들어 네온사인 효과를 줌 */
}

/* Logout 버튼의 스타일 설정 */
#logoutBtn {
    background-color: #f2f2f2; /* Logout 버튼의 배경색을 연한 회색으로 설정 */
    color: black; /* 텍스트 색상은 검은색으로 설정 */
    padding: 10px 20px; /* 버튼 내부 여백 설정 (위아래 10px, 좌우 20px) */
    border: none; /* 버튼 테두리 제거 */
    cursor: pointer; /* 마우스 커서를 손 모양으로 변경 */
    transition: box-shadow 1.5s ease; /* 박스 그림자가 서서히 변하도록 설정 */
    border-radius: 25px; /* 버튼의 모서리를 둥글게 설정 */
    /* logoutBtn 스타일은 네온 버튼과 동일하지만 별도로 정의하여 특화된 변경 가능성을 남김 */
}

/* Logout 버튼에 대한 hover 시 박스 네온 효과 적용 */
#logoutBtn:hover {
    box-shadow: 0 0 10px cyan, 0 0 20px cyan, 0 0 30px cyan, 0 0 40px cyan;
    /* 마우스를 올렸을 때 Logout 버튼 주위에 네온사인 효과를 줌 */
}
</style>

<!-- 세션이 없을 때 -->
<c:if test="${memId == null }">
    <!-- 로그인 및 회원가입 버튼을 표시 -->
	<input type="button" class="neon-btn" value="Login" 
		   onclick="location.href='${ pageContext.request.contextPath }/member/loginForm.do'" /> <br><br/>
	<!-- 로그인 버튼: 클릭 시 loginForm.do로 이동 -->

	<input type="button" class="neon-btn" value="회원가입" 
		   onclick="location.href='${ pageContext.request.contextPath }/member/writeForm.do'"  /> <br><br/>
	<!-- 회원가입 버튼: 클릭 시 writeForm.do로 이동 -->
</c:if>

<!-- 세션이 있을 때 -->
<c:if test="${memId != null }">
    <!-- 로그인된 상태일 때 사용자 ID를 표시 -->
	<h3>
		<a href="${ pageContext.request.contextPath }/member/updateForm.do">${memId } 님.</a>
		<!-- 사용자 ID를 클릭하면 회원정보 수정 페이지로 이동 -->
	</h3>
		
	<input type="button" value="Logout" id="logoutBtn"/> <br><br/>
	<!-- Logout 버튼: 클릭 시 로그아웃 처리 -->
	
	<%-- 	
	<input type="button" value="회원정보수정" 
		onclick="location.href='${ pageContext.request.contextPath }/member/updateForm.do'" /> <br><br/>
	 --%>
</c:if>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	// 로그아웃 버튼 클릭 시 처리
	$('#logoutBtn').click(function(){
		 $.ajax({
			type: 'post',  // POST 요청 방식으로 서버에 로그아웃 요청을 보냄
			url: '/projectMVC/member/logout.do',  // 로그아웃을 처리할 서버 URL
			success: function(){
				// 로그아웃 성공 시 메인 페이지로 이동
				location.href="/projectMVC/index.do";
			},
			error: function(e){
				console.log(e);  // 오류 발생 시 콘솔에 출력
			}
		}); 
	});
	
</script>
