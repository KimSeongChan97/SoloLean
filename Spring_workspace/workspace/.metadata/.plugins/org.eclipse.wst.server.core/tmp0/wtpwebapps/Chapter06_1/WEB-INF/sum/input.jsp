<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Page</title>
<link rel="stylesheet" href="css/input.css">
</head>
<body>
	
	<form action="result.do" method="get">
		<table>
		<tr>
			<td>X</td>
		 	<td><input type="text" name="x" /></td>
		</tr>
		<tr>
			<td>Y</td> 	
	    	<td><input type="text" name="y" /></td>
	    </tr>	
	    	<td colspan="2">
	    	<input type="submit" value="계산" />
	    	<input type="reset" value="취소"/>
	    	</td>
	    </table>
	</form>
	
</body>
</html>