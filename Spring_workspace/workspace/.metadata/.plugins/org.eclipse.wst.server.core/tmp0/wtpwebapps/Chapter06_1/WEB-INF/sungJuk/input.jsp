<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력 페이지</title>
<link rel="stylesheet" href="../css/sungJukinput.css">
</head>
<body>
	
	<form action="/Chapter06_1/sungJuk/result.do" method="post">
		<table>
		<tr>
			<td> 이름 </td>
			<td>
	      		<input type="text" name="name" />
	      	</td>
	      	<td> 국어 </td>
			<td>
	      		<input type="text" name="kor" />
	      	</td>
	      	<td> 영어 </td>
			<td>
	      		<input type="text" name="eng" />
	      	</td>
	      	<td> 수학 </td>
			<td>
	      		<input type="text" name="math" />
	      	</td>
			        
        	<td colspan="2">
	    	<input type="submit" value="계산" />
	    	<input type="reset" value="취소"/>
	    	</td>
        </table>
    </form>
	
</body>
</html>