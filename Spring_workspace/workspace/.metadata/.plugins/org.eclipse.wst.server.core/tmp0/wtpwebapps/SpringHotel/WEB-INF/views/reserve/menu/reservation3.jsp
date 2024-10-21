<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// 로그인 하지 않았을 시 로그인 페이지로 이동
	if(session.getAttribute("userID")==null){
		response.sendRedirect("login.jsp");
	}

	String r_type = request.getParameter("r_type");
	String r_checkin = request.getParameter("r_checkin");
	String r_checkout = request.getParameter("r_checkout");
	String r_adults = request.getParameter("r_adults");
	String r_kids = request.getParameter("r_kids");
	int r_price = Integer.parseInt(request.getParameter("r_price"));
	int diffday = Integer.parseInt(request.getParameter("diffday"));
	int totalprice = r_price * diffday;
	
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>reservation3.jsp : 옵션 선택</title>
	<script type="text/javascript" src="script/script.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
	<link rel="stylesheet" href="css/reserveCSS.css">
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
			
		#input{
		    height:20px;
		    width:95px;
		    border:none;
		    text-align:left;
		    font-size:large;
		    font-weight:bold;
			}
	</style>
</head>

<body>
	
		<table width="80%" align="center" class="reserveOption">
			<tr height="15%">
				<th colspan="4" align="center"><font size="5">예약정보</font></th>
			</tr>
			<tr id="line">
				<td align="center" id="line"><img src="img/<%=r_type%>.jpg" width="280" height="200"></td>
				<td colspan="3" id="line">
					<table width="100%">
						<tr align="left">	
							<td>
								예약 객실 : <b><%=r_type%></b>
							</td>
							<td>
								체크인날짜 : <b><%=r_checkin%></b>
							</td>
						</tr>
						<tr align="left">
							<td>
								체크아웃 날짜 : <b><%=r_checkout%></b>
							</td>
							<td>
								성인 투숙객 수 : <b><%=r_adults%></b>명
							</td>
						</tr>
						<tr align="left">
							<td>
								아동 투숙객 수 : <b><%=r_kids%></b>명
							</td>
							<td> 
								총 금액 : <input type="number" name="r_price" id="input" readonly="readonly" value="<%=totalprice%>" />원
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr id="line">
				<td colspan="4" align="center" id="line">
					<input type="button" id="btn" value="예약하기" onclick="location.href='reservationProc.jsp?r_id=<%=session.getAttribute("userID")%>&r_adults=<%=r_adults%>&r_kids=<%=r_kids%>&r_checkin=<%=r_checkin%>&r_checkout=<%=r_checkout%>&r_type=<%= r_type %>&r_price=<%= totalprice %>'"/>
				</td>
			</tr>
		</table>
		
				<div class="card mb-3">
		  <img src="/SpringHotel/resources/image/1.png" width="400px" class="card-img-top" alt="">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		    <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
		  </div>
		</div>
	<%@ include file="footer.jsp" %>
</body>
</html>