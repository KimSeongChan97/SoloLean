<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/boardUpdate.css">
</head>
<body>
	<div id="wrap">
		<form action="${pageContext.request.contextPath}/board/boardUpdate.do" method="post">
			<input type="hidden" name="seq" value="${boardDTO.seq}">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value="${boardDTO.subject}" ></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" required>${boardDTO.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
