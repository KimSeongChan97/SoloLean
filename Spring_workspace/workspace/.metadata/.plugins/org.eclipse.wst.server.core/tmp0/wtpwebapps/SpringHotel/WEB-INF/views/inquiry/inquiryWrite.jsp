<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>호텔 C&S - Q&A</title>
   <script type="text/javascript" src="script/script.js"></script>
	<meta name="viewport" content="width=device-width", initial-scale="1">
	<link rel="stylesheet" href="/SpringHotel/resources/css/bootstrap.css">
   <link rel="stylesheet" href="/SpringHotel/resources/css/inquiryCSS.css">
   <link rel="stylesheet" href="/SpringHotel/resources/css/custom.css">
   
      <style>
      #btn{
         margin-top:15px;
         margin-bottom:15px;
         background-color: #382f24;
          width:120px;
          height:50px;
          border: none;
          font-size:medium;
          color:#f1ebd5;
         }
   </style>
</head>

<body>
   
<jsp:include page="../common/header.jsp"/>
   
   
   <br/><br />
	<div id="detailcomment">
	   호텔 C&S는 언제나 고객님의 목소리에 귀기울이고 있습니다.<br />
	   고객님들의 소중한 충고와 격려, 또는 제안의 말씀을 주시면 더 나은 서비스로 보답하겠습니다.
	</div>   
	<form name="regForm" id="regForm" method="post">
	    <table align="center" class="inquiryDetail">
	        <tr>
	            <td id="detail" style="background-color: #EEEEEE;">TITLE</td>
	            <td>
	                <select name="qtypesId" id="qtypesId">
	                    <option value="1">문의</option> <!-- 실제 ID로 수정 -->
	                    <option value="2">신청</option>
	                    <option value="3">불만</option>
	                    <option value="4">건의</option>
	                    <option value="5">기타</option>
	                </select>
	            </td>
	        </tr>
	        <tr>
	            <td id="detail" style="background-color: #EEEEEE;">CONTENT</td>
	            <td><textarea name="b_content" rows="20" cols="150" id="content" placeholder="내용을 입력하세요."></textarea></td>
	        </tr>
	        <tr align="center">
	            <td colspan="2">
	                <input type="button" id="btn" value="확인" />
	                <input type="reset" id="btn" value="취소" />
	            </td>
	        </tr>
	    </table>
	</form>
   
   <jsp:include page="../common/footer.jsp" />
   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <script src="/SpringHotel/resources/js/bootstrap.js"></script>
   <script src="/SpringHotel/resources/js/admin.js"></script>
</body>
</html>